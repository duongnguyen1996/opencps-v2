package org.graphql.api.controller.impl;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManagerUtil;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.image.ImageCaptchaService;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.QueryParam;

import org.apache.commons.io.IOUtils;
import org.graphql.api.controller.utils.CaptchaServiceSingleton;
import org.graphql.api.controller.utils.ElasticQueryWrapUtil;
import org.graphql.api.controller.utils.WebKeys;
import org.graphql.api.errors.OpenCPSNotFoundException;
import org.graphql.api.model.FileTemplateMiniItem;
import org.graphql.api.model.UsersUserItem;
import org.opencps.datamgt.model.DictCollection;
import org.opencps.datamgt.model.FileAttach;
import org.opencps.datamgt.service.DictCollectionLocalServiceUtil;
import org.opencps.datamgt.service.FileAttachLocalServiceUtil;
import org.opencps.dossiermgt.action.DeliverableTypesActions;
import org.opencps.dossiermgt.action.impl.DeliverableTypesActionsImpl;
import org.opencps.dossiermgt.action.util.SpecialCharacterUtils;
import org.opencps.dossiermgt.constants.DeliverableTerm;
import org.opencps.dossiermgt.model.Deliverable;
import org.opencps.dossiermgt.model.DeliverableType;
import org.opencps.dossiermgt.model.ServiceFileTemplate;
import org.opencps.dossiermgt.service.DeliverableLocalServiceUtil;
import org.opencps.dossiermgt.service.DeliverableTypeLocalServiceUtil;
import org.opencps.dossiermgt.service.ServiceFileTemplateLocalServiceUtil;
import org.opencps.dossiermgt.service.persistence.ServiceFileTemplatePK;
import org.opencps.usermgt.action.impl.UserActions;
import org.opencps.usermgt.model.Employee;
import org.opencps.usermgt.model.EmployeeJobPos;
import org.opencps.usermgt.model.JobPos;
import org.opencps.usermgt.service.EmployeeLocalServiceUtil;
import org.opencps.usermgt.service.JobPosLocalServiceUtil;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import backend.admin.config.whiteboard.BundleLoader;
import backend.utils.FileUploadUtils;
import io.swagger.annotations.ApiParam;

/**
 * Rest Controller
 *
 * @author binhth
 */
@RestController
public class RestfulController {

	@RequestMapping(value = "/user/{id}/deactive", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void deactiveAccount(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") long id,
			@RequestBody String body) {

		try {

			JSONObject bodyData = JSONFactoryUtil.createJSONObject(body);

			User user = UserLocalServiceUtil.getUser(id);

			boolean locked = bodyData.getBoolean("locked");

			if (locked) {
				user.setStatus(WorkflowConstants.STATUS_INACTIVE);
			} else {
				user.setStatus(WorkflowConstants.STATUS_APPROVED);
			}

			UserLocalServiceUtil.updateUser(user);

			Indexer<User> indexer = IndexerRegistryUtil.nullSafeGetIndexer(User.class);

			indexer.reindex(user);

		} catch (Exception e) {
			_log.debug(e);
		}

	}

	@RequestMapping(value = "/user/{id}/changepass", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void changePassWordUser(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") long id, @RequestBody String body) {

		try {

			JSONObject bodyData = JSONFactoryUtil.createJSONObject(body);

			String password = bodyData.getString("password");

			User user = UserLocalServiceUtil.updatePassword(id, password, password, Boolean.FALSE);

			Indexer<User> indexer = IndexerRegistryUtil.nullSafeGetIndexer(User.class);

			indexer.reindex(user);

		} catch (Exception e) {
			_log.debug(e);
		}

	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseStatus(HttpStatus.OK)
	public String getUserId(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") long id) {

		JSONObject result = JSONFactoryUtil.createJSONObject();

		result.put("email", StringPool.BLANK);
		result.put("screenName", StringPool.BLANK);
		result.put("deactiveAccountFlag", 0);

		try {

			User user = UserLocalServiceUtil.fetchUser(id);

			result.put("email", user.getEmailAddress());
			result.put("screenName", user.getScreenName());
			result.put("deactiveAccountFlag", user.getStatus());

		} catch (Exception e) {
			_log.debug(e);
		}

		return result.toJSONString();
	}

	@RequestMapping(value = "/users/login", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseStatus(HttpStatus.OK)
	public String getUserLoginInfo(HttpServletRequest request, HttpServletResponse response) {

		JSONArray dataUser = JSONFactoryUtil.createJSONArray();

		JSONObject result = JSONFactoryUtil.createJSONObject();

		result.put("email", StringPool.BLANK);
		result.put("role", StringPool.BLANK);
		result.put("deactiveAccountFlag", 0);

		try {

			long userId = 0;
			if (Validator.isNotNull(request.getAttribute(WebKeys.USER_ID))) {
				userId = Long.valueOf(request.getAttribute(WebKeys.USER_ID).toString());

				User user = UserLocalServiceUtil.fetchUser(userId);

				List<Role> roles = user.getRoles();

				String roleName = StringPool.BLANK;

				for (Role role : roles) {

					if ("Administrator".equals(role.getName())) {
						roleName = "Administrator";
						break;
					}

					if ("Administrator_data".equals(role.getName())) {
						roleName = "Administrator_data";
						break;
					}

				}

				result.put("email", user.getEmailAddress());
				result.put("role", roleName);
				result.put("deactiveAccountFlag", user.getStatus());

			}

		} catch (Exception e) {
			_log.debug(e);
		}

		dataUser.put(result);

		return dataUser.toJSONString();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
	@ResponseStatus(HttpStatus.OK)
	public String doLogin(HttpServletRequest request, HttpServletResponse response) {
		long checkUserId = -1;
		String emailAddress = StringPool.BLANK;
		
		try {

			Enumeration<String> headerNames = request.getHeaderNames();

			String strBasic = StringPool.BLANK;

			if (headerNames != null) {
				while (headerNames.hasMoreElements()) {
					String key = (String) headerNames.nextElement();
					String value = request.getHeader(key);
					if (key.trim().equalsIgnoreCase(WebKeys.AUTHORIZATION)) {
						strBasic = value;
						break;
					}
				}
			}

			// Get encoded user and password, comes after "BASIC "
			String userpassEncoded = strBasic.substring(6);
			String decodetoken = new String(Base64.decode(userpassEncoded), StringPool.UTF8);

			String account[] = decodetoken.split(":");

			String email = account[0];
			String password = account[1];
			emailAddress = email;
			
			long userId = AuthenticatedSessionManagerUtil.getAuthenticatedUserId(request, email, password,
					CompanyConstants.AUTH_TYPE_EA);
			if (userId > 0 && userId != 20103) {
				checkUserId = userId;
//				AuthenticatedSessionManagerUtil.login(request, response, email, password, true,
//						CompanyConstants.AUTH_TYPE_EA);
				//Remember me false
				AuthenticatedSessionManagerUtil.login(request, response, email, password, false,
						CompanyConstants.AUTH_TYPE_EA);

				Employee employee = EmployeeLocalServiceUtil.fetchByFB_MUID(userId);

				User user = UserLocalServiceUtil.fetchUser(userId);
//				String sessionId = request.getSession() != null ? request.getSession().getId() : StringPool.BLANK;
//				
//				UserLoginLocalServiceUtil.updateUserLogin(user.getCompanyId(), user.getGroupId(), userId, user.getFullName(), new Date(), new Date(), 0l, sessionId, 0, null, request.getRemoteAddr());
//				String userAgent = request.getHeader("User-Agent") != null ? request.getHeader("User-Agent") : StringPool.BLANK;
//				ArrayList<UserTrackerPath> userTrackerPath = new ArrayList<UserTrackerPath>();
//				UserTrackerLocalServiceUtil.addUserTracker(
//						user.getCompanyId(), 
//						userId, 
//						new Date(), 
//						sessionId, 
//						request.getRemoteAddr(), 
//						request.getRemoteHost(), 
//						userAgent, 
//						userTrackerPath);
				if (Validator.isNotNull(employee)) {

					if (user != null && user.getStatus() == WorkflowConstants.STATUS_PENDING) {
						return "pending";
					} else {
						return "/c";
					}
				} else {
					if (user != null && user.getStatus() == WorkflowConstants.STATUS_PENDING) {
						return "pending";
					} else {
						return "ok";
					}

				}
			}

		} 
		catch (AuthException ae) {
			System.out.println("AUTH EXCEPTION: " + checkUserId);
			_log.debug(ae);
			if (checkUserId != -1) {
				User checkUser = UserLocalServiceUtil.fetchUser(checkUserId);
				
				if (checkUser != null && checkUser.getFailedLoginAttempts() >= 5) {
					ImageCaptchaService instance = CaptchaServiceSingleton.getInstance();
					String jCaptchaResponse = request.getParameter("j_captcha_response");
					String captchaId = request.getSession().getId();
					try {
						boolean isResponseCorrect = instance.validateResponseForID(captchaId, jCaptchaResponse);
						if (!isResponseCorrect)
							return "captcha";
					} catch (CaptchaServiceException e) {
						_log.debug(e);
						return "captcha";
					}
				}
				else {
					return "captcha";
				}
			}
			else {
				try {
					Company company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
					User checkUser = UserLocalServiceUtil.fetchUserByEmailAddress(company.getCompanyId(), emailAddress);
					
					if (checkUser != null && checkUser.getFailedLoginAttempts() >= 5) {
						ImageCaptchaService instance = CaptchaServiceSingleton.getInstance();
						String jCaptchaResponse = request.getParameter("j_captcha_response");
						String captchaId = request.getSession().getId();
				        try {
				        	boolean isResponseCorrect = instance.validateResponseForID(captchaId,
				        			jCaptchaResponse);
				        	if (!isResponseCorrect) 
				        		return "captcha";
				        } catch (CaptchaServiceException e) {
				        	_log.debug(e);
				        	return "captcha";
				        }				
					}		
				} catch (PortalException e) {
					_log.debug(e);
				}				
			}
		}
		catch (PortalException pe) {
			System.out.println("PORTAL EXCEPTION: " + emailAddress);
			_log.debug(pe);
			try {
				Company company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
				User checkUser = UserLocalServiceUtil.fetchUserByEmailAddress(company.getCompanyId(), emailAddress);
				
				if (checkUser != null && checkUser.getFailedLoginAttempts() >= 5) {
					ImageCaptchaService instance = CaptchaServiceSingleton.getInstance();
					String jCaptchaResponse = request.getParameter("j_captcha_response");
					String captchaId = request.getSession().getId();
			        try {
			        	boolean isResponseCorrect = instance.validateResponseForID(captchaId,
			        			jCaptchaResponse);
			        	if (!isResponseCorrect) 
			        		return "captcha";
			        } catch (CaptchaServiceException e) {
			        	_log.debug(e);
			        	return "captcha";
			        }				
				}		
			} catch (PortalException e) {
				_log.debug(e);
			}
			
		}		
		catch (Exception e) {
			System.out.println("EXCEPTION");
			_log.debug(e);
		}

		return "";
	}

	@RequestMapping(value = "/users/avatar/{className}/{pk}", method = RequestMethod.GET, produces = "text/plain; charset=utf-8")
	@ResponseStatus(HttpStatus.OK)
	public String getAttachment(HttpServletRequest request, @PathVariable("className") String className,
			@PathVariable("pk") String pk) {

		String result = StringPool.BLANK;

		long groupId = 0;

		if (Validator.isNotNull(request.getHeader("groupId"))) {
			groupId = Long.valueOf(request.getHeader("groupId"));
		}

		List<FileAttach> fileAttachs = FileAttachLocalServiceUtil.findByF_className_classPK(groupId, className, pk);

		if (Validator.isNotNull(fileAttachs) && fileAttachs.size() > 0) {

			FileAttach fileAttach = fileAttachs.get(fileAttachs.size() - 1);

			try {

//				DLFileEntry file = DLFileEntryLocalServiceUtil.getFileEntry(fileAttach.getFileEntryId());
				FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(fileAttach.getFileEntryId());
				
//				result = "/documents/" + file.getGroupId() + StringPool.FORWARD_SLASH + file.getFolderId()
//						+ StringPool.FORWARD_SLASH + HtmlUtil.escape(file.getTitle()) + StringPool.FORWARD_SLASH + file.getUuid();
				result = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY), StringPool.BLANK);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				_log.debug(e);
			}

		}

		return result;
	}

	@RequestMapping(value = "/users/upload/{code}/{className}/{pk}", method = RequestMethod.POST)
	public void uploadAttachment(MultipartHttpServletRequest request, @PathVariable("code") String code,
			@PathVariable("className") String className, @PathVariable("pk") String pk) {

		CommonsMultipartFile multipartFile = null;

		Iterator<String> iterator = request.getFileNames();

		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			// create multipartFile array if you upload multiple files
			multipartFile = (CommonsMultipartFile) request.getFile(key);
		}

		long userId = 0;
		if (Validator.isNotNull(request.getAttribute(WebKeys.USER_ID))) {
			userId = Long.valueOf(request.getAttribute(WebKeys.USER_ID).toString());
		}
		long groupId = 0;
		if (Validator.isNotNull(request.getHeader("groupId"))) {
			groupId = Long.valueOf(request.getHeader("groupId"));
		}
		long companyId = CompanyThreadLocal.getCompanyId();
		String desc = "FileAttach file upload";
		String destination = "FileAttach/";

		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setUserId(userId);
		serviceContext.setCompanyId(companyId);
		serviceContext.setScopeGroupId(groupId);

		try {
			if (multipartFile != null) {
				FileEntry fileEntry = FileUploadUtils.uploadFile(userId, companyId, groupId, multipartFile.getInputStream(),
						UUID.randomUUID() + "_" + multipartFile.getOriginalFilename(),
						multipartFile.getOriginalFilename()
								.substring(multipartFile.getOriginalFilename().lastIndexOf(".") + 1),
						multipartFile.getSize(), destination, desc, serviceContext);

				if ("opencps_adminconfig".equals(code)) {

					ServiceFileTemplateLocalServiceUtil.addServiceFileTemplate(Long.valueOf(pk),
							fileEntry.getFileEntryId() + StringPool.BLANK, multipartFile.getOriginalFilename(),
							fileEntry.getFileEntryId(), serviceContext);

				} else {

					User user = UserLocalServiceUtil.fetchUser(userId);

					FileAttach fileAttach = FileAttachLocalServiceUtil.addFileAttach(userId, groupId, className, pk,
							user.getFullName(), user.getEmailAddress(), fileEntry.getFileEntryId(), StringPool.BLANK,
							StringPool.BLANK, 0, fileEntry.getFileName(), serviceContext);

					if ("opencps_employee".equals(code)) {
						Employee employee = EmployeeLocalServiceUtil.fetchEmployee(Long.valueOf(pk));
						employee.setPhotoFileEntryId(fileAttach.getFileEntryId());
						EmployeeLocalServiceUtil.updateEmployee(employee);
					} else if ("opencps_deliverabletype".equals(code)) {

						DeliverableType openCPSDeliverableType = DeliverableTypeLocalServiceUtil
								.fetchDeliverableType(Long.valueOf(pk));

						if (className.endsWith("FORM")) {
							openCPSDeliverableType.setFormScriptFileId(fileAttach.getFileEntryId());
						} else if (className.endsWith("JASPER")) {
							openCPSDeliverableType.setFormReportFileId(fileAttach.getFileEntryId());
						}

						DeliverableTypeLocalServiceUtil.updateDeliverableType(openCPSDeliverableType);

					} else if ("opencps_applicant".equals(code)) {

						System.out.println("RestfulController.uploadAttachment()" + Long.valueOf(pk));
						Employee employee = EmployeeLocalServiceUtil.fetchEmployee(Long.valueOf(pk));
						System.out.println("RestfulController.uploadAttachment(className)" + className);
						File file = DLFileEntryLocalServiceUtil.getFile(fileEntry.getFileEntryId(), fileEntry.getVersion(),
								true);
						if ("org.opencps.usermgt.model.ApplicantEsign".equals(className)) {
							String buildFileName = PropsUtil.get(PropsKeys.LIFERAY_HOME) + StringPool.FORWARD_SLASH + "data/cer/" + employee.getEmail() + StringPool.PERIOD + "png";
							File targetFile = new File(buildFileName);
							employee.setFileSignId(fileAttach.getFileEntryId());
							Files.copy(file.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
						} else {
							String buildFileName = PropsUtil.get(PropsKeys.LIFERAY_HOME) + StringPool.FORWARD_SLASH + "data/cer/" + employee.getEmail() + StringPool.PERIOD + "cer";
							File targetFile = new File(buildFileName);
							employee.setFileCertId(fileAttach.getFileEntryId());
							Files.copy(file.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
						}

						EmployeeLocalServiceUtil.updateEmployee(employee);

					} else if ("opencps_deliverable".equals(code)) {

						Deliverable openCPSDeliverable = DeliverableLocalServiceUtil
								.fetchDeliverable(Long.valueOf(pk));

						openCPSDeliverable.setFileEntryId(fileAttach.getFileEntryId());

						DeliverableLocalServiceUtil.updateDeliverable(openCPSDeliverable);

					}

				}
			}
		} catch (Exception e) {
			_log.debug(e);
		}

	}

	@RequestMapping(value = "/users/upload/{code}/{className}/{serviceInfoId}/{fileTemplateNo}", method = RequestMethod.POST)
	public void uploadServiceFileAttachment(MultipartHttpServletRequest request, @PathVariable("code") String code,
			@PathVariable("className") String className, @PathVariable("serviceInfoId") String serviceInfoId,
			@PathVariable("fileTemplateNo") String fileTemplateNo) {

		CommonsMultipartFile multipartFile = null;

		Iterator<String> iterator = request.getFileNames();

		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			// create multipartFile array if you upload multiple files
			multipartFile = (CommonsMultipartFile) request.getFile(key);
		}

		long userId = 0;
		if (Validator.isNotNull(request.getAttribute(WebKeys.USER_ID))) {
			userId = Long.valueOf(request.getAttribute(WebKeys.USER_ID).toString());
		}
		long groupId = 0;
		if (Validator.isNotNull(request.getHeader("groupId"))) {
			groupId = Long.valueOf(request.getHeader("groupId"));
		}
		long companyId = CompanyThreadLocal.getCompanyId();
		String desc = "FileAttach file upload";
		String destination = "FileAttach/";

		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setUserId(userId);
		serviceContext.setCompanyId(companyId);
		serviceContext.setScopeGroupId(groupId);

		try {
			if (multipartFile != null) {
				FileEntry fileEntry = FileUploadUtils.uploadFile(userId, companyId, groupId, multipartFile.getInputStream(),
						UUID.randomUUID() + "_" + multipartFile.getOriginalFilename(),
						multipartFile.getOriginalFilename()
								.substring(multipartFile.getOriginalFilename().lastIndexOf(".") + 1),
						multipartFile.getSize(), destination, desc, serviceContext);

				User user = UserLocalServiceUtil.fetchUser(userId);

				FileAttach fileAttach = FileAttachLocalServiceUtil.addFileAttach(userId, groupId, className, serviceInfoId+ "_"+fileTemplateNo,
						user.getFullName(), user.getEmailAddress(), fileEntry.getFileEntryId(), StringPool.BLANK,
						StringPool.BLANK, 0, fileEntry.getFileName(), serviceContext);

				if ("opencps_services_filetemplates".equals(code)) {

					ServiceFileTemplate fileTemplate = ServiceFileTemplateLocalServiceUtil
							.fetchByF_serviceInfoId_fileTemplateNo(Long.valueOf(serviceInfoId), fileTemplateNo);

					if (className.endsWith("FORM")) {
						fileTemplate.setFormScriptFileId(fileAttach.getFileEntryId());
					} else if (className.endsWith("JASPER")) {
						fileTemplate.setFormReportFileId(fileAttach.getFileEntryId());
					}

					ServiceFileTemplateLocalServiceUtil.updateServiceFileTemplate(fileTemplate);
				}
			}

		} catch (Exception e) {
			_log.debug(e);
		}

	}

	@RequestMapping(value = "/filetemplate/{pk}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseStatus(HttpStatus.OK)
	public String getServiceFileTemplate(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("pk") long pk) {

		JSONObject result = JSONFactoryUtil.createJSONObject();

		JSONArray resultArray = JSONFactoryUtil.createJSONArray();

		List<ServiceFileTemplate> serviceFileTemplates = ServiceFileTemplateLocalServiceUtil.getByServiceInfoId(pk);

		result.put("total", serviceFileTemplates.size());

		JSONObject object = null;
		for (ServiceFileTemplate serviceFileTemplate : serviceFileTemplates) {

			try {

				object = JSONFactoryUtil.createJSONObject(JSONFactoryUtil.looseSerialize(serviceFileTemplate));

				long fileEntryId = serviceFileTemplate.getFileEntryId();

				FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(fileEntryId);

				object.put("extension", fileEntry.getExtension());
				object.put("size", fileEntry.getSize());

				resultArray.put(object);

			} catch (Exception e) {
				_log.debug(e);
			}

		}
		result.put("data", resultArray);

		return result.toJSONString();

	}

	@RequestMapping(value = "/fileattach/{className}/{pk}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseStatus(HttpStatus.OK)
	public String getAttachFileData(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("className") String className, @PathVariable("pk") String pk) {

		JSONObject result = JSONFactoryUtil.createJSONObject();

		JSONArray resultArray = JSONFactoryUtil.createJSONArray();

		long groupId = 0;

		if (Validator.isNotNull(request.getHeader("groupId"))) {
			groupId = Long.valueOf(request.getHeader("groupId"));
		}

		List<FileAttach> fileAttachs = FileAttachLocalServiceUtil.findByF_className_classPK(groupId, className, pk);

		result.put("total", fileAttachs.size());

		JSONObject object = null;
		for (FileAttach ett : fileAttachs) {

			try {

				String newName = ett.getFileName();

				if (newName.indexOf("_") > 0) {

					ett.setFileName(newName.substring(newName.indexOf("_") + 1));

				}

				object = JSONFactoryUtil.createJSONObject(JSONFactoryUtil.looseSerialize(ett));

				long fileEntryId = ett.getFileEntryId();

				FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(fileEntryId);

				object.put("extension", fileEntry.getExtension());
				object.put("size", fileEntry.getSize());

				resultArray.put(object);

			} catch (Exception e) {
				_log.debug(e);
			}

		}
		result.put("data", resultArray);

		return result.toJSONString();

	}

	@RequestMapping(value = "/users/upload/delete/{code}/{className}/{pk}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
	@ResponseStatus(HttpStatus.OK)
	public String deleteAttachFileData(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("className") String className, @PathVariable("pk") String pk,
			@PathVariable("code") String code) {

		JSONObject result = JSONFactoryUtil.createJSONObject();

		long groupId = 0;

		if (Validator.isNotNull(request.getHeader("groupId"))) {
			groupId = Long.valueOf(request.getHeader("groupId"));
		}

		List<FileAttach> fileAttachs = FileAttachLocalServiceUtil.findByF_className_classPK(groupId, className, pk);

		for (FileAttach ett : fileAttachs) {

			FileAttachLocalServiceUtil.deleteFileAttach(ett);

		}

		if ("opencps_deliverable".equals(code)) {
			Deliverable openCPSDeliverable = DeliverableLocalServiceUtil
					.fetchDeliverable(Long.valueOf(pk));

			openCPSDeliverable.setFileEntryId(0);

			DeliverableLocalServiceUtil.updateDeliverable(openCPSDeliverable);
		}

		return result.toJSONString();

	}

	@RequestMapping(value = "/users/upload/download/{code}/{className}/{pk}", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody byte[] downloadFileAttach(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("className") String className, @PathVariable("pk") String pk,
			@PathVariable("code") String code) {

		try {

			FileAttach fileAttach = FileAttachLocalServiceUtil.fetchFileAttach(Long.valueOf(pk));

			FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(fileAttach.getFileEntryId());

			response.setContentType("application/force-download");
			response.setHeader("Content-Disposition",
					"attachment; filename=" + fileEntry.getFileName() + fileEntry.getExtension());

			InputStream inputStream = fileEntry.getContentStream();

			return IOUtils.toByteArray(inputStream);

		} catch (Exception exception) {
			_log.debug(exception);
		}
		return null;
	}

	@RequestMapping(value = "/filetemplate/{serviceInfoId}/{fileTemplateNo}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeServiceFileTemplate(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("serviceInfoId") long serviceInfoId, @PathVariable("fileTemplateNo") String fileTemplateNo) {

		try {
			ServiceFileTemplate serviceFileTemplate = ServiceFileTemplateLocalServiceUtil
					.fetchByF_serviceInfoId_fileTemplateNo(serviceInfoId, fileTemplateNo);

			long fileEntryId = serviceFileTemplate.getFileEntryId();

			ServiceFileTemplateLocalServiceUtil.deleteServiceFileTemplate(serviceFileTemplate);
			DLAppLocalServiceUtil.deleteFileEntry(fileEntryId);

		} catch (Exception e) {
			_log.debug(e);
		}

	}

	@RequestMapping(value = "/filetemplate/{serviceInfoId}/{fileTemplateNo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody byte[] downloadServiceFileTemplate(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("serviceInfoId") long serviceInfoId, @PathVariable("fileTemplateNo") String fileTemplateNo) {

		ServiceFileTemplate serviceFileTemplate = ServiceFileTemplateLocalServiceUtil
				.fetchByF_serviceInfoId_fileTemplateNo(serviceInfoId, fileTemplateNo);

		if (Validator.isNotNull(serviceFileTemplate)) {
			try {

				FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(serviceFileTemplate.getFileEntryId());

				response.setContentType("application/force-download");
				response.setHeader("Content-Disposition",
						"attachment; filename=" + serviceFileTemplate.getTemplateName() + fileEntry.getExtension());

				InputStream inputStream = fileEntry.getContentStream();

				return IOUtils.toByteArray(inputStream);

			} catch (Exception exception) {
				_log.debug(exception);
			}
		}
		return null;
	}

	@RequestMapping(value = "/filetemplate/{serviceInfoId}/{fileTemplateNo}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void upDateServiceFileTemplate(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("serviceInfoId") long serviceInfoId, @PathVariable("fileTemplateNo") String fileTemplateNo,
			@RequestBody FileTemplateMiniItem fileTemplateMiniItem) {

		ServiceFileTemplate serviceFileTemplate = ServiceFileTemplateLocalServiceUtil
				.fetchByF_serviceInfoId_fileTemplateNo(serviceInfoId, fileTemplateNo);

		ServiceFileTemplatePK serviceFileTemplatePK = new ServiceFileTemplatePK(serviceInfoId, fileTemplateNo);

		ServiceFileTemplate serviceFileTemplateNew;
		try {
			serviceFileTemplateNew = ServiceFileTemplateLocalServiceUtil.getServiceFileTemplate(serviceFileTemplatePK);

			ServiceFileTemplateLocalServiceUtil.deleteServiceFileTemplate(serviceFileTemplate);

			if (Validator.isNotNull(serviceFileTemplateNew)) {

				if (Validator.isNotNull(fileTemplateMiniItem.getFileTemplateNo())) {
					serviceFileTemplateNew.setFileTemplateNo(fileTemplateMiniItem.getFileTemplateNo());
				}
				if (Validator.isNotNull(fileTemplateMiniItem.getTemplateName())) {
					serviceFileTemplateNew.setTemplateName(fileTemplateMiniItem.getTemplateName());
				}

				ServiceFileTemplateLocalServiceUtil.updateServiceFileTemplate(serviceFileTemplateNew);
			}
		} catch (PortalException e) {
			_log.debug(e);
		}

	}

	@RequestMapping(value = "/upload/", method = RequestMethod.POST)
	public String uploadFile(MultipartHttpServletRequest request) {
		//CommonsMultipartFile multipartFile = null; // multipart file class depends on which class you use assuming you
													// are using
													// org.springframework.web.multipart.commons.CommonsMultipartFile

		//Iterator<String> iterator = request.getFileNames();

		//while (iterator.hasNext()) {
			//String key = (String) iterator.next();
			// create multipartFile array if you upload multiple files
			//multipartFile = (CommonsMultipartFile) request.getFile(key);
		//}

		//try {
			//System.out.println("LiferayRestController.uploadFile()" + multipartFile.getInputStream());
		//} catch (IOException e) {
		//	_log.debug(e);
		//}

		return "sdfds";
	}

	@RequestMapping(value = "/jexcel/{bundleName}/{modelName}/{serviceName}/{idCol}/{textCol}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseStatus(HttpStatus.OK)
	public String getJExcelAutoComplate(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("bundleName") String bundleName, @PathVariable("modelName") String modelName,
			@PathVariable("serviceName") String serviceName, @PathVariable("idCol") String idCol,
			@PathVariable("textCol") String textCol) {

		JSONArray result = JSONFactoryUtil.createJSONArray();

		try {

			BundleLoader bundleLoader = new BundleLoader(bundleName);

			Class<?> model = bundleLoader.getClassLoader().loadClass(modelName);

			Method method = bundleLoader.getClassLoader().loadClass(serviceName).getMethod("dynamicQuery");

			DynamicQuery dynamicQuery = (DynamicQuery) method.invoke(model);

			ProjectionList projectionList = ProjectionFactoryUtil.projectionList();

			projectionList.add(ProjectionFactoryUtil.property(idCol));
			projectionList.add(ProjectionFactoryUtil.property(textCol));

			dynamicQuery.setProjection(projectionList);

			Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
			disjunction.add(RestrictionsFactoryUtil.eq("groupId", 0l));
			if (Validator.isNotNull(request.getHeader("groupId"))) {
				disjunction.add(RestrictionsFactoryUtil.eq("groupId", Long.valueOf(request.getHeader("groupId"))));
			}
			dynamicQuery.add(disjunction);

			if (Validator.isNotNull(request.getParameter("pk")) && Validator.isNotNull(request.getParameter("col"))) {
				dynamicQuery.add(PropertyFactoryUtil.forName(request.getParameter("col"))
						.eq(Validator.isNumber(request.getParameter("pk")) ? Long.valueOf(request.getParameter("pk"))
								: request.getParameter("pk")));
			}
			if (Validator.isNotNull(request.getParameter("collectionCode"))
					&& Validator.isNotNull(request.getParameter("column"))
					&& Validator.isNotNull(request.getParameter("type"))) {

				if ("int".equals(request.getParameter("type"))) {
					DictCollection dictCollection = DictCollectionLocalServiceUtil.fetchByF_dictCollectionCode(
							request.getParameter("collectionCode"), Long.valueOf(request.getHeader("groupId")));

					if (Validator.isNotNull(dictCollection)) {
						dynamicQuery.add(PropertyFactoryUtil.forName(request.getParameter("column"))
								.eq(dictCollection.getDictCollectionId()));
					}
				} else {
					dynamicQuery.add(PropertyFactoryUtil.forName(request.getParameter("column"))
							.eq(request.getParameter("collectionCode")));
				}
			}

			method = bundleLoader.getClassLoader().loadClass(serviceName).getMethod("dynamicQuery", DynamicQuery.class,
					int.class, int.class);

			List<Object[]> list = (List<Object[]>) method.invoke(model, dynamicQuery, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS);

			//_log.info("List object: "+JSONFactoryUtil.looseSerialize(list));
			JSONObject object = null;
			for (Object[] objects : list) {

				object = JSONFactoryUtil.createJSONObject();

				//_log.info("objects[0]: "+objects[0]);
				object.put("id", objects[0]);

				if (modelName.equals(EmployeeJobPos.class.getName())) {

					long jobPostId = (long) objects[1];

					JobPos jobPos = JobPosLocalServiceUtil.fetchJobPos(jobPostId);

					String name = Validator.isNotNull(jobPos) ? jobPos.getTitle() : StringPool.BLANK;

					object.put("name", name);
					//_log.debug("name: "+name);

				} else {
					object.put("name", objects[1]);
					//_log.debug("name: "+objects[1]);
				}

				result.put(object);

				//_log.info("result: "+JSONFactoryUtil.looseSerialize(result));
			}

		} catch (Exception e) {
			_log.debug(e);
		}

		return result.toJSONString();

	}

	@RequestMapping(value = "/users/{id}", produces = { "application/json",
			"application/xml" }, method = RequestMethod.GET)
	public ResponseEntity<UsersUserItem> getUserById(
			@ApiParam(value = "id của user", required = true) @PathVariable("id") String id) {

		if (Validator.isNull(id)) {

			throw new OpenCPSNotFoundException(User.class.getName());

		} else {

			UserActions actions = new UserActions();

			String userData = actions.getUserById(Long.valueOf(id));

			if (Validator.isNull(userData)) {
				throw new OpenCPSNotFoundException(User.class.getName());
			}

			return new ResponseEntity<UsersUserItem>(JSONFactoryUtil.looseDeserialize(userData, UsersUserItem.class),
					HttpStatus.OK);

		}

	}

	@RequestMapping(value = "/fileattach/{id}/text", produces = {
			"text/plain; charset=utf-8" }, method = RequestMethod.GET)
	public String getTextFromFileEntryId(
			@ApiParam(value = "id của user", required = true) @PathVariable("id") Long id) {

		String result = StringPool.BLANK;

		InputStream is = null;

		try {

			DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getFileEntry(id);

			is = dlFileEntry.getContentStream();

			result = IOUtils.toString(is, StandardCharsets.UTF_8);

		} catch (Exception e) {
			_log.debug(e);
			result = StringPool.BLANK;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					_log.debug(e);
				}
			}
		}

		return result;

	}

	@RequestMapping(value = "/deliverable/{type}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseStatus(HttpStatus.OK)
	public String getDeliverable(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("type") String type, @QueryParam("start") Integer start, @QueryParam("end") Integer end,
			@QueryParam("keyword") String keyword) {

		JSONObject result = JSONFactoryUtil.createJSONObject();

		try {

			long userId = 0;
			if (Validator.isNotNull(request.getAttribute(WebKeys.USER_ID))) {
				userId = Long.valueOf(request.getAttribute(WebKeys.USER_ID).toString());

				long groupId = 0;

				if (Validator.isNotNull(request.getHeader("groupId"))) {
					groupId = Long.valueOf(request.getHeader("groupId"));
				}

				try {
					String[] subQuerieArr = new String[] { DeliverableTerm.DELIVERABLE_TYPE, DeliverableTerm.DELIVERABLE_NAME,
							DeliverableTerm.GOV_AGENCY_NAME, DeliverableTerm.APPLICANT_NAME,
							DeliverableTerm.DELIVERABLE_CODE_SEARCH };
					String queryBuilder = StringPool.BLANK;
					String queryBuilderLike = StringPool.BLANK;
					StringBuilder sbBuilder = new StringBuilder();
					if (Validator.isNotNull(keyword)) {
						//LamTV_Process search LIKE
						String keySearch = SpecialCharacterUtils.splitSpecial(keyword);
						sbBuilder.append(" AND (");
						int length = subQuerieArr.length;
						for (int i = 0; i < length; i++) {
							sbBuilder.append(subQuerieArr[i] + ": *" + keySearch + "*");
							if (i < length - 1) {
								sbBuilder.append(" OR ");
							} else {
								sbBuilder.append(" ) ");
							}
						}
					} else {
						DeliverableTypesActions actions = new DeliverableTypesActionsImpl();

						DeliverableType deliverableType = actions.getByTypeCode(userId, groupId, type,
								new ServiceContext());

						JSONArray filterData = JSONFactoryUtil.createJSONArray(deliverableType.getDataConfig());

						for (int i = 0; i < filterData.length(); i++) {

							if (Validator
									.isNotNull(request.getParameter(filterData.getJSONObject(i).getString("fieldName")))) {

								if ("like".equals(filterData.getJSONObject(i).getString("compare"))) {

									queryBuilderLike += " AND " + filterData.getJSONObject(i).getString("fieldName") + ": *"
											+ request.getParameter(filterData.getJSONObject(i).getString("fieldName"))
											+ "*";

								} else {

									queryBuilder += " AND " + filterData.getJSONObject(i).getString("fieldName") + ":"
											+ request.getParameter(filterData.getJSONObject(i).getString("fieldName"));

								}

							}

						}
					}

					System.out.println("queryBuilderLike:" + queryBuilderLike);
					System.out.println("queryBuilder:" + queryBuilder);
					int size = 0;
					if (Validator.isNull(end) || end == 0) {
						start = -1;
						//end = -1;
						size = -1;
					} else {
						size = end - start;
					}

					JSONObject query = JSONFactoryUtil.createJSONObject(" { \"from\" : " + start
							+ ", \"size\" : " + size
							+ ", \"query\": { \"query_string\": { \"query\" : \"(entryClassName:(entryClassName:org.opencps.dossiermgt.model.Deliverable) AND groupId:"
							+ groupId + " AND deliverableType: " + type + queryBuilder + queryBuilderLike + sbBuilder.toString() + " )\" }}"
							+ "}");

					JSONObject countQuery = JSONFactoryUtil.createJSONObject(" { "
							+ "\"query\": { \"query_string\": { \"query\" : \"(entryClassName:(entryClassName:org.opencps.dossiermgt.model.Deliverable) AND groupId:"
							+ groupId + " AND deliverableType: " + type + queryBuilder + queryBuilderLike + sbBuilder.toString() + " )\" }}"
							+ "}");

					System.out.println("query:" + query);
					JSONObject count = ElasticQueryWrapUtil.count(countQuery.toJSONString());

					System.out.println("RestfulController.getDeliverable(count)" + count.toJSONString());

					result = ElasticQueryWrapUtil.query(query.toJSONString());

					result.getJSONObject("hits").put("total", count.getLong("count"));

				} catch (JSONException e) {
					_log.debug(e);
				}

			}

		} catch (Exception e) {
			_log.debug(e);
		}

		return result.toJSONString();
	}

	@RequestMapping(value = "/deliverable/{id}/detail", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseStatus(HttpStatus.OK)
	public String getDeliverableById(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("id") Long id) {

		//JSONObject result = JSONFactoryUtil.createJSONObject();

		try {
			//long userId = 0;
			//if (Validator.isNotNull(request.getAttribute(WebKeys.USER_ID))) {
				//userId = Long.valueOf(request.getAttribute(WebKeys.USER_ID).toString());

				//long groupId = 0;
				//if (Validator.isNotNull(request.getHeader("groupId"))) {
				//}

				//JSONObject query = JSONFactoryUtil.createJSONObject(
				//		" { \"from\" : 0, \"size\" : 1, \"query\": { \"query_string\": { \"query\" : \"(entryClassName:(entryClassName:org.opencps.deliverable.model.OpenCPSDeliverable) AND groupId:"
				//				+ groupId + " AND entryClassPK: " + id + " )\" }}}");
				//result = ElasticQueryWrapUtil.query(query.toJSONString());

			Deliverable deliverable = DeliverableLocalServiceUtil.fetchDeliverable(id);
			if (deliverable != null) {
				return JSONFactoryUtil.looseSerialize(deliverable);
			}

		} catch (Exception e) {
			_log.debug(e);
		}

		return StringPool.BLANK;
	}

	@RequestMapping(value = "/deliverable/file/{id}", method = RequestMethod.GET, produces = "text/plain; charset=utf-8")
	@ResponseStatus(HttpStatus.OK)
	public String getFile(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long id) {

		String result = StringPool.BLANK;

		DLFileEntry fileEntry;
		try {

			fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(id);

			result = "/documents/" + fileEntry.getGroupId() + StringPool.FORWARD_SLASH + fileEntry.getFolderId()
					+ StringPool.FORWARD_SLASH + fileEntry.getTitle() + StringPool.FORWARD_SLASH + fileEntry.getUuid();

		} catch (Exception e) {
			_log.debug(e);
		}

		return result;
	}

	@RequestMapping(value = "/admin/{bundleName}/{modelName}/{serviceName}/data", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseStatus(HttpStatus.OK)
	public String getAdminToolData(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("bundleName") String bundleName, @PathVariable("modelName") String modelName,
			@PathVariable("serviceName") String serviceName) {

		// JSONArray result = JSONFactoryUtil.createJSONArray();
		String result = JSONFactoryUtil.createJSONArray().toJSONString();
		try {

			BundleLoader bundleLoader = new BundleLoader(bundleName);

			System.out.println("RestfulController.getAdminToolData(bundleLoader)" + bundleLoader.getClassLoader());
			Class<?> model = bundleLoader.getClassLoader().loadClass(modelName);

			System.out.println("RestfulController.getAdminToolData(model)" + model);

			System.out.println("RestfulController.getAdminToolData(serviceName)" + serviceName);
			Method method = bundleLoader.getClassLoader().loadClass(serviceName).getMethod("dynamicQuery");
			System.out.println("RestfulController.getAdminToolData(method)" + method);

			DynamicQuery dynamicQuery = (DynamicQuery) method.invoke(model);

			Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
			disjunction.add(RestrictionsFactoryUtil.eq("groupId", 0l));
			if (Validator.isNotNull(request.getHeader("groupId"))) {
				disjunction.add(RestrictionsFactoryUtil.eq("groupId", Long.valueOf(request.getHeader("groupId"))));
			}
			dynamicQuery.add(disjunction);

			method = bundleLoader.getClassLoader().loadClass(serviceName).getMethod("dynamicQuery", DynamicQuery.class,
					int.class, int.class);

			result = JSONFactoryUtil.looseSerialize(method.invoke(model, dynamicQuery, QueryUtil.ALL_POS, QueryUtil.ALL_POS)).toString();

		} catch (Exception e) {
			_log.debug(e);
		}

		return result;

	}
	
	@RequestMapping(value = "/site/name", method = RequestMethod.GET, produces = "text/plain; charset=utf-8")
	@ResponseStatus(HttpStatus.OK)
	public String getSiteName(HttpServletRequest request, HttpServletResponse response) {

		String result = StringPool.BLANK;
		
		long groupId = 0;

		if (Validator.isNotNull(request.getHeader("groupId"))) {
			groupId = Long.valueOf(request.getHeader("groupId"));
		}
		
		Group group = GroupLocalServiceUtil.fetchGroup(groupId);

		if (Validator.isNotNull(group)) {
			
			result = group.getGroupKey();
			
		}
		
		return result.toUpperCase();

	}
	
	@RequestMapping(value = "/users/login/jcaptcha", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Resource> getJCaptcha(HttpServletRequest request, HttpServletResponse response) {
		try {
			ImageCaptchaService instance = CaptchaServiceSingleton.getInstance();
			
		    String captchaId = request.getSession().getId();
			File destDir = new File("jcaptcha");
			if (!destDir.exists()) {
				destDir.mkdir();
			}
			File file = new File("jcaptcha/" + captchaId  + ".png");
			if (!file.exists()) {
				file.createNewFile();				
			}
	
			if (file.exists()) {
			    BufferedImage challengeImage = instance.getImageChallengeForID(
			    captchaId, Locale.US );
			    try {
					ImageIO.write( challengeImage, "png", file );
				    
				} catch (IOException e) {
					_log.debug(e);
				}
			}
		
			Path path = Paths.get(file.getAbsolutePath());
		    ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

		    return ResponseEntity.ok()
		            .headers(new HttpHeaders())
		            .contentLength(file.length())
		            .contentType(MediaType.parseMediaType("application/octet-stream"))
		            .body(resource);
		}
		catch (Exception e) {
			_log.debug(e);
			return null;
		}
		
	}	

	public static final Log _log = LogFactoryUtil.getLog(RestfulController.class);
}
