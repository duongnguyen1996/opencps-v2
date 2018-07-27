package org.opencps.api.controller.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.apache.commons.httpclient.util.HttpURLConnection;
import org.opencps.api.controller.StatisticManagement;
import org.opencps.api.controller.exception.ErrorMsg;
import org.opencps.api.controller.util.StatisticUtils;
import org.opencps.api.statistic.model.StatisticDossierResults;
import org.opencps.api.statistic.model.StatisticDossierSearchModel;
import org.opencps.auth.api.BackendAuth;
import org.opencps.auth.api.BackendAuthImpl;
import org.opencps.auth.api.exception.UnauthenticationException;
import org.opencps.auth.api.exception.UnauthorizationException;
import org.opencps.dossiermgt.action.DossierActions;
import org.opencps.dossiermgt.action.StatisticActions;
import org.opencps.dossiermgt.action.impl.DossierActionsImpl;
import org.opencps.dossiermgt.action.impl.StatisticActionsImpl;
import org.opencps.dossiermgt.constants.DossierTerm;
import org.opencps.dossiermgt.model.StepConfig;
import org.opencps.dossiermgt.service.StepConfigLocalServiceUtil;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class StatisticManagementImpl implements StatisticManagement {

	private static final Log _log = LogFactoryUtil.getLog(StatisticManagementImpl.class);

//	@Override
//	public Response getDossierTodo(HttpServletRequest request, HttpHeaders header, Company company, Locale locale,
//			User user, ServiceContext serviceContext, StatisticDossierSearchModel query) {
//
//		long groupId = GetterUtil.getLong(header.getHeaderString("groupId"));
//		BackendAuth auth = new BackendAuthImpl();
//		DossierActions actions = new DossierActionsImpl();
//
//		try {
//
//			if (!auth.isAuth(serviceContext)) {
//				throw new UnauthenticationException();
//			}
//
//			LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();
//
//			params.put(Field.GROUP_ID, String.valueOf(groupId));
//			params.put(DossierTerm.STATUS, query.getDossierStatus());
//			params.put(DossierTerm.SUBSTATUS, query.getDossierSubStatus());
//			params.put(Field.USER_ID, String.valueOf(user.getUserId()));
//			params.put(DossierTerm.FOLLOW, String.valueOf(true));
//
//			// params.put("LEVEL", query.getLevel());
//
///*			JSONObject jsonData = actions.getDossierTodo(user.getUserId(), company.getCompanyId(), groupId, params,
//					null, serviceContext);
//*/
//			JSONObject jsonData = actions.getDossierTodoPermission(user.getUserId(), company.getCompanyId(), groupId, params,
//					null, serviceContext);
//
//			StatisticDossierResults results = new StatisticDossierResults();
//
//			results.setTotal(jsonData.getInt("total"));
//
//			results.getStatisticDossierModel()
//					.addAll(StatisticUtils.mapperStatisticDossierList(jsonData.getJSONArray("data")));
//
//			return Response.status(200).entity(results).build();
//
//		} catch (Exception e) {
//			_log.error(e);
//
//			ErrorMsg error = new ErrorMsg();
//
//			if (e instanceof UnauthenticationException) {
//				error.setMessage("Non-Authoritative Information.");
//				error.setCode(HttpURLConnection.HTTP_NOT_AUTHORITATIVE);
//				error.setDescription("Non-Authoritative Information.");
//
//				return Response.status(HttpURLConnection.HTTP_NOT_AUTHORITATIVE).entity(error).build();
//			} else {
//				if (e instanceof UnauthorizationException) {
//					error.setMessage("Unauthorized.");
//					error.setCode(HttpURLConnection.HTTP_NOT_AUTHORITATIVE);
//					error.setDescription("Unauthorized.");
//
//					return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(error).build();
//
//				} else {
//
//					error.setMessage("Internal Server Error");
//					error.setCode(HttpURLConnection.HTTP_FORBIDDEN);
//					error.setDescription(e.getMessage());
//
//					return Response.status(HttpURLConnection.HTTP_INTERNAL_ERROR).entity(error).build();
//
//				}
//			}
//		}
//	}

	@Override
	public Response getDossierTodo(HttpServletRequest request, HttpHeaders header, Company company, Locale locale,
			User user, ServiceContext serviceContext, StatisticDossierSearchModel query) {

		long groupId = GetterUtil.getLong(header.getHeaderString("groupId"));
		BackendAuth auth = new BackendAuthImpl();
		DossierActions actions = new DossierActionsImpl();

		try {

			if (!auth.isAuth(serviceContext)) {
				throw new UnauthenticationException();
			}

			LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();

			params.put(Field.GROUP_ID, String.valueOf(groupId));
			params.put(DossierTerm.STATUS, query.getDossierStatus());
			params.put(DossierTerm.SUBSTATUS, query.getDossierSubStatus());
			params.put(Field.USER_ID, String.valueOf(user.getUserId()));
			params.put(DossierTerm.FOLLOW, String.valueOf(false));

			JSONObject jsonData = actions.getDossierTodoPermission(user.getUserId(), company.getCompanyId(), groupId, params,
					null, serviceContext);

			StatisticDossierResults results = new StatisticDossierResults();

			results.setTotal(jsonData.getInt("total"));

			results.getStatisticDossierModel()
					.addAll(StatisticUtils.mapperStatisticDossierList(jsonData.getJSONArray("data")));

			return Response.status(200).entity(results).build();

		} catch (Exception e) {
			_log.error(e);
			return processException(e);
		}
	}

	@Override
	public Response getDossierCountTodo(HttpServletRequest request, HttpHeaders header, Company company, Locale locale,
			User user, ServiceContext serviceContext, StatisticDossierSearchModel query) {

		BackendAuth auth = new BackendAuthImpl();
		DossierActions actions = new DossierActionsImpl();

		try {

			if (!auth.isAuth(serviceContext)) {
				throw new UnauthenticationException();
			}

			LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();
			long groupId = GetterUtil.getLong(header.getHeaderString("groupId"));
			long userId = user.getUserId();

			// Get info input
			long notStatusReg = query.getNotStatusReg();
			String status = query.getDossierStatus();
			String substatus = query.getDossierSubStatus();
			

			params.put(Field.GROUP_ID, String.valueOf(groupId));
			params.put(DossierTerm.STATUS, status);
			params.put(DossierTerm.SUBSTATUS, substatus);
			params.put(Field.USER_ID, String.valueOf(userId));
			params.put(DossierTerm.OWNER, String.valueOf(true));
			params.put(DossierTerm.NOT_STATUS_REG, notStatusReg);

			JSONObject jsonData = actions.getDossierCountTodoPermission(user.getUserId(), company.getCompanyId(), groupId, params,
					null, serviceContext);

			StatisticDossierResults results = new StatisticDossierResults();

			results.setTotal(jsonData.getInt("total"));

			results.getStatisticDossierModel()
					.addAll(StatisticUtils.mapperStatisticDossierList(jsonData.getJSONArray("data")));

			return Response.status(200).entity(results).build();

		} catch (Exception e) {
			_log.error(e);
			return processException(e);
		}
	}

	// Declare exception major process
	private Response processException (Exception e) {
		ErrorMsg error = new ErrorMsg();

		if (e instanceof UnauthenticationException) {
			error.setMessage("Non-Authoritative Information.");
			error.setCode(HttpURLConnection.HTTP_NOT_AUTHORITATIVE);
			error.setDescription("Non-Authoritative Information.");

			return Response.status(HttpURLConnection.HTTP_NOT_AUTHORITATIVE).entity(error).build();
		} else {
			if (e instanceof UnauthorizationException) {
				error.setMessage("Unauthorized.");
				error.setCode(HttpURLConnection.HTTP_NOT_AUTHORITATIVE);
				error.setDescription("Unauthorized.");

				return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(error).build();

			} else {

				error.setMessage("Internal Server Error");
				error.setCode(HttpURLConnection.HTTP_FORBIDDEN);
				error.setDescription(e.getMessage());

				return Response.status(HttpURLConnection.HTTP_INTERNAL_ERROR).entity(error).build();

			}
		}
	}

	@Override
	public Response getDossierTodoTest(HttpServletRequest request, HttpHeaders header, Company company, Locale locale,
			User user, ServiceContext serviceContext, StatisticDossierSearchModel query, String owner) {
		BackendAuth auth = new BackendAuthImpl();
		StatisticActions actions = new StatisticActionsImpl();

		try {

			if (!auth.isAuth(serviceContext)) {
				throw new UnauthenticationException();
			}

			LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();
			long groupId = GetterUtil.getLong(header.getHeaderString("groupId"));
			long userId = user.getUserId();
//			int stepType = 0;

			_log.info("START");
			// Get info input
//			long notStatusReg = query.getNotStatusReg();
//			String status = query.getDossierStatus();
//			String substatus = query.getDossierSubStatus();
			_log.info("START");
			JSONArray statistics = JSONFactoryUtil.createJSONArray();

			params.put(Field.GROUP_ID, String.valueOf(groupId));
			params.put(Field.USER_ID, String.valueOf(userId));
			boolean ownerBoolean = GetterUtil.getBoolean(owner);
			if (ownerBoolean) {
				params.put(DossierTerm.OWNER, String.valueOf(true));				
			}
			int total = 0;
			//
			String stepCode = query.getStep();
			_log.info("STEPCODE: "+stepCode);
			if (Validator.isNotNull(stepCode)) {
				String[] stepArr = stepCode.split(StringPool.COMMA);
				if (stepArr != null && stepArr.length > 0) {
					for (int i = 0; i < stepArr.length; i++) {
						StepConfig stepConfig = StepConfigLocalServiceUtil.getByCode(groupId, stepArr[i]);
						if (stepConfig != null) {
							params.put(DossierTerm.STATUS, stepConfig.getDossierStatus());
							params.put(DossierTerm.SUBSTATUS, stepConfig.getDossierSubStatus());
							//TODO
							String permission = user.getUserId() + ":write";
							params.put(DossierTerm.MAPPING_PERMISSION, permission);
							_log.info("START");
							long count = actions.countTodoTest(user.getUserId(), company.getCompanyId(), groupId,
									params, null, serviceContext);
							_log.info("START");
							JSONObject statistic = JSONFactoryUtil.createJSONObject();
							statistic.put("stepCode", stepConfig.getStepCode());
							statistic.put("stepName", stepConfig.getStepName());
							statistic.put("dossierStatus", stepConfig.getDossierStatus());
							statistic.put("dossierSubStatus", stepConfig.getDossierSubStatus());
							statistic.put("totalCount", count);
							total += count;
							statistics.put(statistic);
						}
					}
				}
			} else {
				List<StepConfig> stepList = StepConfigLocalServiceUtil.getStepByGroupId(groupId);
				if (stepList != null && stepList.size() > 0) {
					_log.info("length: "+stepList.size());
					for (StepConfig step: stepList) {
						params.put(DossierTerm.STATUS, step.getDossierStatus());
						params.put(DossierTerm.SUBSTATUS, step.getDossierSubStatus());
						//TODO
						String permission = user.getUserId() + ":write";
						params.put(DossierTerm.MAPPING_PERMISSION, permission);
						_log.info("DossierStatus: "+step.getDossierStatus());
						long count = actions.countTodoTest(user.getUserId(), company.getCompanyId(), groupId, params,
								null, serviceContext);
						_log.info("count: "+count);
						JSONObject statistic = JSONFactoryUtil.createJSONObject();
						statistic.put("stepCode", step.getStepCode());
						statistic.put("stepName", step.getStepName());
						statistic.put("dossierStatus", step.getDossierStatus());
						statistic.put("dossierSubStatus", step.getDossierSubStatus());
						statistic.put("totalCount", count);
						total += count;
						statistics.put(statistic);
					}
				}
			}
//			_log.info("START");
//			JSONArray statistics = JSONFactoryUtil.createJSONArray();
//
//			params.put(Field.GROUP_ID, String.valueOf(groupId));
//			params.put(Field.USER_ID, String.valueOf(userId));
//			params.put(DossierTerm.OWNER, String.valueOf(true));
//			params.put(DossierTerm.NOT_STATUS_REG, notStatusReg);

			StatisticDossierResults results = new StatisticDossierResults();

			results.setTotal(total);
			_log.info("total: "+total);
			results.getStatisticDossierModel()
					.addAll(StatisticUtils.mapperStatisticDossierList(statistics));

			return Response.status(200).entity(results).build();

		} catch (Exception e) {
			_log.error(e);
			return processException(e);
		}
	}
}
