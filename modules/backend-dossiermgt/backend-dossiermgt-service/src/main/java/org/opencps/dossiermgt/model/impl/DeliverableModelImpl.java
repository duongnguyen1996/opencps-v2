/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.opencps.dossiermgt.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import org.opencps.dossiermgt.model.Deliverable;
import org.opencps.dossiermgt.model.DeliverableModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Deliverable service. Represents a row in the &quot;opencps_deliverable&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link DeliverableModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DeliverableImpl}.
 * </p>
 *
 * @author huymq
 * @see DeliverableImpl
 * @see Deliverable
 * @see DeliverableModel
 * @generated
 */
@ProviderType
public class DeliverableModelImpl extends BaseModelImpl<Deliverable>
	implements DeliverableModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a deliverable model instance should use the {@link Deliverable} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_deliverable";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "deliverableId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "deliverableCode", Types.VARCHAR },
			{ "deliverableName", Types.VARCHAR },
			{ "deliverableType", Types.VARCHAR },
			{ "govAgencyCode", Types.VARCHAR },
			{ "govAgencyName", Types.VARCHAR },
			{ "applicantIdNo", Types.VARCHAR },
			{ "applicantName", Types.VARCHAR },
			{ "subject", Types.VARCHAR },
			{ "formData", Types.VARCHAR },
			{ "formScript", Types.VARCHAR },
			{ "formReport", Types.VARCHAR },
			{ "expireDate", Types.TIMESTAMP },
			{ "issueDate", Types.TIMESTAMP },
			{ "revalidate", Types.TIMESTAMP },
			{ "deliverableState", Types.VARCHAR },
			{ "fileEntryId", Types.BIGINT },
			{ "dossierId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("deliverableId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("deliverableCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("deliverableName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("deliverableType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("govAgencyCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("govAgencyName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("applicantIdNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("applicantName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("subject", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("formData", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("formScript", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("formReport", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("expireDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("issueDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("revalidate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("deliverableState", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fileEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dossierId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_deliverable (uuid_ VARCHAR(75) null,deliverableId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,deliverableCode VARCHAR(75) null,deliverableName VARCHAR(75) null,deliverableType VARCHAR(75) null,govAgencyCode VARCHAR(75) null,govAgencyName VARCHAR(75) null,applicantIdNo VARCHAR(75) null,applicantName VARCHAR(75) null,subject VARCHAR(75) null,formData TEXT null,formScript TEXT null,formReport TEXT null,expireDate DATE null,issueDate DATE null,revalidate DATE null,deliverableState VARCHAR(75) null,fileEntryId LONG,dossierId LONG)";
	public static final String TABLE_SQL_DROP = "drop table opencps_deliverable";
	public static final String ORDER_BY_JPQL = " ORDER BY deliverable.deliverableId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_deliverable.deliverableId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.dossiermgt.model.Deliverable"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.dossiermgt.model.Deliverable"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.dossiermgt.model.Deliverable"),
			true);
	public static final long APPLICANTIDNO_COLUMN_BITMASK = 1L;
	public static final long COMPANYID_COLUMN_BITMASK = 2L;
	public static final long DELIVERABLECODE_COLUMN_BITMASK = 4L;
	public static final long DELIVERABLEID_COLUMN_BITMASK = 8L;
	public static final long DELIVERABLESTATE_COLUMN_BITMASK = 16L;
	public static final long DELIVERABLETYPE_COLUMN_BITMASK = 32L;
	public static final long GOVAGENCYCODE_COLUMN_BITMASK = 64L;
	public static final long GROUPID_COLUMN_BITMASK = 128L;
	public static final long UUID_COLUMN_BITMASK = 256L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.dossiermgt.model.Deliverable"));

	public DeliverableModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _deliverableId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDeliverableId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _deliverableId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Deliverable.class;
	}

	@Override
	public String getModelClassName() {
		return Deliverable.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("deliverableId", getDeliverableId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("deliverableCode", getDeliverableCode());
		attributes.put("deliverableName", getDeliverableName());
		attributes.put("deliverableType", getDeliverableType());
		attributes.put("govAgencyCode", getGovAgencyCode());
		attributes.put("govAgencyName", getGovAgencyName());
		attributes.put("applicantIdNo", getApplicantIdNo());
		attributes.put("applicantName", getApplicantName());
		attributes.put("subject", getSubject());
		attributes.put("formData", getFormData());
		attributes.put("formScript", getFormScript());
		attributes.put("formReport", getFormReport());
		attributes.put("expireDate", getExpireDate());
		attributes.put("issueDate", getIssueDate());
		attributes.put("revalidate", getRevalidate());
		attributes.put("deliverableState", getDeliverableState());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("dossierId", getDossierId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long deliverableId = (Long)attributes.get("deliverableId");

		if (deliverableId != null) {
			setDeliverableId(deliverableId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String deliverableCode = (String)attributes.get("deliverableCode");

		if (deliverableCode != null) {
			setDeliverableCode(deliverableCode);
		}

		String deliverableName = (String)attributes.get("deliverableName");

		if (deliverableName != null) {
			setDeliverableName(deliverableName);
		}

		String deliverableType = (String)attributes.get("deliverableType");

		if (deliverableType != null) {
			setDeliverableType(deliverableType);
		}

		String govAgencyCode = (String)attributes.get("govAgencyCode");

		if (govAgencyCode != null) {
			setGovAgencyCode(govAgencyCode);
		}

		String govAgencyName = (String)attributes.get("govAgencyName");

		if (govAgencyName != null) {
			setGovAgencyName(govAgencyName);
		}

		String applicantIdNo = (String)attributes.get("applicantIdNo");

		if (applicantIdNo != null) {
			setApplicantIdNo(applicantIdNo);
		}

		String applicantName = (String)attributes.get("applicantName");

		if (applicantName != null) {
			setApplicantName(applicantName);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String formData = (String)attributes.get("formData");

		if (formData != null) {
			setFormData(formData);
		}

		String formScript = (String)attributes.get("formScript");

		if (formScript != null) {
			setFormScript(formScript);
		}

		String formReport = (String)attributes.get("formReport");

		if (formReport != null) {
			setFormReport(formReport);
		}

		Date expireDate = (Date)attributes.get("expireDate");

		if (expireDate != null) {
			setExpireDate(expireDate);
		}

		Date issueDate = (Date)attributes.get("issueDate");

		if (issueDate != null) {
			setIssueDate(issueDate);
		}

		Date revalidate = (Date)attributes.get("revalidate");

		if (revalidate != null) {
			setRevalidate(revalidate);
		}

		String deliverableState = (String)attributes.get("deliverableState");

		if (deliverableState != null) {
			setDeliverableState(deliverableState);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Long dossierId = (Long)attributes.get("dossierId");

		if (dossierId != null) {
			setDossierId(dossierId);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getDeliverableId() {
		return _deliverableId;
	}

	@Override
	public void setDeliverableId(long deliverableId) {
		_columnBitmask |= DELIVERABLEID_COLUMN_BITMASK;

		if (!_setOriginalDeliverableId) {
			_setOriginalDeliverableId = true;

			_originalDeliverableId = _deliverableId;
		}

		_deliverableId = deliverableId;
	}

	public long getOriginalDeliverableId() {
		return _originalDeliverableId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getDeliverableCode() {
		if (_deliverableCode == null) {
			return "";
		}
		else {
			return _deliverableCode;
		}
	}

	@Override
	public void setDeliverableCode(String deliverableCode) {
		_columnBitmask |= DELIVERABLECODE_COLUMN_BITMASK;

		if (_originalDeliverableCode == null) {
			_originalDeliverableCode = _deliverableCode;
		}

		_deliverableCode = deliverableCode;
	}

	public String getOriginalDeliverableCode() {
		return GetterUtil.getString(_originalDeliverableCode);
	}

	@Override
	public String getDeliverableName() {
		if (_deliverableName == null) {
			return "";
		}
		else {
			return _deliverableName;
		}
	}

	@Override
	public void setDeliverableName(String deliverableName) {
		_deliverableName = deliverableName;
	}

	@Override
	public String getDeliverableType() {
		if (_deliverableType == null) {
			return "";
		}
		else {
			return _deliverableType;
		}
	}

	@Override
	public void setDeliverableType(String deliverableType) {
		_columnBitmask |= DELIVERABLETYPE_COLUMN_BITMASK;

		if (_originalDeliverableType == null) {
			_originalDeliverableType = _deliverableType;
		}

		_deliverableType = deliverableType;
	}

	public String getOriginalDeliverableType() {
		return GetterUtil.getString(_originalDeliverableType);
	}

	@Override
	public String getGovAgencyCode() {
		if (_govAgencyCode == null) {
			return "";
		}
		else {
			return _govAgencyCode;
		}
	}

	@Override
	public void setGovAgencyCode(String govAgencyCode) {
		_columnBitmask |= GOVAGENCYCODE_COLUMN_BITMASK;

		if (_originalGovAgencyCode == null) {
			_originalGovAgencyCode = _govAgencyCode;
		}

		_govAgencyCode = govAgencyCode;
	}

	public String getOriginalGovAgencyCode() {
		return GetterUtil.getString(_originalGovAgencyCode);
	}

	@Override
	public String getGovAgencyName() {
		if (_govAgencyName == null) {
			return "";
		}
		else {
			return _govAgencyName;
		}
	}

	@Override
	public void setGovAgencyName(String govAgencyName) {
		_govAgencyName = govAgencyName;
	}

	@Override
	public String getApplicantIdNo() {
		if (_applicantIdNo == null) {
			return "";
		}
		else {
			return _applicantIdNo;
		}
	}

	@Override
	public void setApplicantIdNo(String applicantIdNo) {
		_columnBitmask |= APPLICANTIDNO_COLUMN_BITMASK;

		if (_originalApplicantIdNo == null) {
			_originalApplicantIdNo = _applicantIdNo;
		}

		_applicantIdNo = applicantIdNo;
	}

	public String getOriginalApplicantIdNo() {
		return GetterUtil.getString(_originalApplicantIdNo);
	}

	@Override
	public String getApplicantName() {
		if (_applicantName == null) {
			return "";
		}
		else {
			return _applicantName;
		}
	}

	@Override
	public void setApplicantName(String applicantName) {
		_applicantName = applicantName;
	}

	@Override
	public String getSubject() {
		if (_subject == null) {
			return "";
		}
		else {
			return _subject;
		}
	}

	@Override
	public void setSubject(String subject) {
		_subject = subject;
	}

	@Override
	public String getFormData() {
		if (_formData == null) {
			return "";
		}
		else {
			return _formData;
		}
	}

	@Override
	public void setFormData(String formData) {
		_formData = formData;
	}

	@Override
	public String getFormScript() {
		if (_formScript == null) {
			return "";
		}
		else {
			return _formScript;
		}
	}

	@Override
	public void setFormScript(String formScript) {
		_formScript = formScript;
	}

	@Override
	public String getFormReport() {
		if (_formReport == null) {
			return "";
		}
		else {
			return _formReport;
		}
	}

	@Override
	public void setFormReport(String formReport) {
		_formReport = formReport;
	}

	@Override
	public Date getExpireDate() {
		return _expireDate;
	}

	@Override
	public void setExpireDate(Date expireDate) {
		_expireDate = expireDate;
	}

	@Override
	public Date getIssueDate() {
		return _issueDate;
	}

	@Override
	public void setIssueDate(Date issueDate) {
		_issueDate = issueDate;
	}

	@Override
	public Date getRevalidate() {
		return _revalidate;
	}

	@Override
	public void setRevalidate(Date revalidate) {
		_revalidate = revalidate;
	}

	@Override
	public String getDeliverableState() {
		if (_deliverableState == null) {
			return "";
		}
		else {
			return _deliverableState;
		}
	}

	@Override
	public void setDeliverableState(String deliverableState) {
		_columnBitmask |= DELIVERABLESTATE_COLUMN_BITMASK;

		if (_originalDeliverableState == null) {
			_originalDeliverableState = _deliverableState;
		}

		_deliverableState = deliverableState;
	}

	public String getOriginalDeliverableState() {
		return GetterUtil.getString(_originalDeliverableState);
	}

	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	@Override
	public long getDossierId() {
		return _dossierId;
	}

	@Override
	public void setDossierId(long dossierId) {
		_dossierId = dossierId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Deliverable.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Deliverable.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Deliverable toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Deliverable)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DeliverableImpl deliverableImpl = new DeliverableImpl();

		deliverableImpl.setUuid(getUuid());
		deliverableImpl.setDeliverableId(getDeliverableId());
		deliverableImpl.setCompanyId(getCompanyId());
		deliverableImpl.setGroupId(getGroupId());
		deliverableImpl.setUserId(getUserId());
		deliverableImpl.setUserName(getUserName());
		deliverableImpl.setCreateDate(getCreateDate());
		deliverableImpl.setModifiedDate(getModifiedDate());
		deliverableImpl.setDeliverableCode(getDeliverableCode());
		deliverableImpl.setDeliverableName(getDeliverableName());
		deliverableImpl.setDeliverableType(getDeliverableType());
		deliverableImpl.setGovAgencyCode(getGovAgencyCode());
		deliverableImpl.setGovAgencyName(getGovAgencyName());
		deliverableImpl.setApplicantIdNo(getApplicantIdNo());
		deliverableImpl.setApplicantName(getApplicantName());
		deliverableImpl.setSubject(getSubject());
		deliverableImpl.setFormData(getFormData());
		deliverableImpl.setFormScript(getFormScript());
		deliverableImpl.setFormReport(getFormReport());
		deliverableImpl.setExpireDate(getExpireDate());
		deliverableImpl.setIssueDate(getIssueDate());
		deliverableImpl.setRevalidate(getRevalidate());
		deliverableImpl.setDeliverableState(getDeliverableState());
		deliverableImpl.setFileEntryId(getFileEntryId());
		deliverableImpl.setDossierId(getDossierId());

		deliverableImpl.resetOriginalValues();

		return deliverableImpl;
	}

	@Override
	public int compareTo(Deliverable deliverable) {
		long primaryKey = deliverable.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Deliverable)) {
			return false;
		}

		Deliverable deliverable = (Deliverable)obj;

		long primaryKey = deliverable.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		DeliverableModelImpl deliverableModelImpl = this;

		deliverableModelImpl._originalUuid = deliverableModelImpl._uuid;

		deliverableModelImpl._originalDeliverableId = deliverableModelImpl._deliverableId;

		deliverableModelImpl._setOriginalDeliverableId = false;

		deliverableModelImpl._originalCompanyId = deliverableModelImpl._companyId;

		deliverableModelImpl._setOriginalCompanyId = false;

		deliverableModelImpl._originalGroupId = deliverableModelImpl._groupId;

		deliverableModelImpl._setOriginalGroupId = false;

		deliverableModelImpl._setModifiedDate = false;

		deliverableModelImpl._originalDeliverableCode = deliverableModelImpl._deliverableCode;

		deliverableModelImpl._originalDeliverableType = deliverableModelImpl._deliverableType;

		deliverableModelImpl._originalGovAgencyCode = deliverableModelImpl._govAgencyCode;

		deliverableModelImpl._originalApplicantIdNo = deliverableModelImpl._applicantIdNo;

		deliverableModelImpl._originalDeliverableState = deliverableModelImpl._deliverableState;

		deliverableModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Deliverable> toCacheModel() {
		DeliverableCacheModel deliverableCacheModel = new DeliverableCacheModel();

		deliverableCacheModel.uuid = getUuid();

		String uuid = deliverableCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			deliverableCacheModel.uuid = null;
		}

		deliverableCacheModel.deliverableId = getDeliverableId();

		deliverableCacheModel.companyId = getCompanyId();

		deliverableCacheModel.groupId = getGroupId();

		deliverableCacheModel.userId = getUserId();

		deliverableCacheModel.userName = getUserName();

		String userName = deliverableCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			deliverableCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			deliverableCacheModel.createDate = createDate.getTime();
		}
		else {
			deliverableCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			deliverableCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			deliverableCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		deliverableCacheModel.deliverableCode = getDeliverableCode();

		String deliverableCode = deliverableCacheModel.deliverableCode;

		if ((deliverableCode != null) && (deliverableCode.length() == 0)) {
			deliverableCacheModel.deliverableCode = null;
		}

		deliverableCacheModel.deliverableName = getDeliverableName();

		String deliverableName = deliverableCacheModel.deliverableName;

		if ((deliverableName != null) && (deliverableName.length() == 0)) {
			deliverableCacheModel.deliverableName = null;
		}

		deliverableCacheModel.deliverableType = getDeliverableType();

		String deliverableType = deliverableCacheModel.deliverableType;

		if ((deliverableType != null) && (deliverableType.length() == 0)) {
			deliverableCacheModel.deliverableType = null;
		}

		deliverableCacheModel.govAgencyCode = getGovAgencyCode();

		String govAgencyCode = deliverableCacheModel.govAgencyCode;

		if ((govAgencyCode != null) && (govAgencyCode.length() == 0)) {
			deliverableCacheModel.govAgencyCode = null;
		}

		deliverableCacheModel.govAgencyName = getGovAgencyName();

		String govAgencyName = deliverableCacheModel.govAgencyName;

		if ((govAgencyName != null) && (govAgencyName.length() == 0)) {
			deliverableCacheModel.govAgencyName = null;
		}

		deliverableCacheModel.applicantIdNo = getApplicantIdNo();

		String applicantIdNo = deliverableCacheModel.applicantIdNo;

		if ((applicantIdNo != null) && (applicantIdNo.length() == 0)) {
			deliverableCacheModel.applicantIdNo = null;
		}

		deliverableCacheModel.applicantName = getApplicantName();

		String applicantName = deliverableCacheModel.applicantName;

		if ((applicantName != null) && (applicantName.length() == 0)) {
			deliverableCacheModel.applicantName = null;
		}

		deliverableCacheModel.subject = getSubject();

		String subject = deliverableCacheModel.subject;

		if ((subject != null) && (subject.length() == 0)) {
			deliverableCacheModel.subject = null;
		}

		deliverableCacheModel.formData = getFormData();

		String formData = deliverableCacheModel.formData;

		if ((formData != null) && (formData.length() == 0)) {
			deliverableCacheModel.formData = null;
		}

		deliverableCacheModel.formScript = getFormScript();

		String formScript = deliverableCacheModel.formScript;

		if ((formScript != null) && (formScript.length() == 0)) {
			deliverableCacheModel.formScript = null;
		}

		deliverableCacheModel.formReport = getFormReport();

		String formReport = deliverableCacheModel.formReport;

		if ((formReport != null) && (formReport.length() == 0)) {
			deliverableCacheModel.formReport = null;
		}

		Date expireDate = getExpireDate();

		if (expireDate != null) {
			deliverableCacheModel.expireDate = expireDate.getTime();
		}
		else {
			deliverableCacheModel.expireDate = Long.MIN_VALUE;
		}

		Date issueDate = getIssueDate();

		if (issueDate != null) {
			deliverableCacheModel.issueDate = issueDate.getTime();
		}
		else {
			deliverableCacheModel.issueDate = Long.MIN_VALUE;
		}

		Date revalidate = getRevalidate();

		if (revalidate != null) {
			deliverableCacheModel.revalidate = revalidate.getTime();
		}
		else {
			deliverableCacheModel.revalidate = Long.MIN_VALUE;
		}

		deliverableCacheModel.deliverableState = getDeliverableState();

		String deliverableState = deliverableCacheModel.deliverableState;

		if ((deliverableState != null) && (deliverableState.length() == 0)) {
			deliverableCacheModel.deliverableState = null;
		}

		deliverableCacheModel.fileEntryId = getFileEntryId();

		deliverableCacheModel.dossierId = getDossierId();

		return deliverableCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", deliverableId=");
		sb.append(getDeliverableId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", deliverableCode=");
		sb.append(getDeliverableCode());
		sb.append(", deliverableName=");
		sb.append(getDeliverableName());
		sb.append(", deliverableType=");
		sb.append(getDeliverableType());
		sb.append(", govAgencyCode=");
		sb.append(getGovAgencyCode());
		sb.append(", govAgencyName=");
		sb.append(getGovAgencyName());
		sb.append(", applicantIdNo=");
		sb.append(getApplicantIdNo());
		sb.append(", applicantName=");
		sb.append(getApplicantName());
		sb.append(", subject=");
		sb.append(getSubject());
		sb.append(", formData=");
		sb.append(getFormData());
		sb.append(", formScript=");
		sb.append(getFormScript());
		sb.append(", formReport=");
		sb.append(getFormReport());
		sb.append(", expireDate=");
		sb.append(getExpireDate());
		sb.append(", issueDate=");
		sb.append(getIssueDate());
		sb.append(", revalidate=");
		sb.append(getRevalidate());
		sb.append(", deliverableState=");
		sb.append(getDeliverableState());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append(", dossierId=");
		sb.append(getDossierId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(79);

		sb.append("<model><model-name>");
		sb.append("org.opencps.dossiermgt.model.Deliverable");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deliverableId</column-name><column-value><![CDATA[");
		sb.append(getDeliverableId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deliverableCode</column-name><column-value><![CDATA[");
		sb.append(getDeliverableCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deliverableName</column-name><column-value><![CDATA[");
		sb.append(getDeliverableName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deliverableType</column-name><column-value><![CDATA[");
		sb.append(getDeliverableType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>govAgencyCode</column-name><column-value><![CDATA[");
		sb.append(getGovAgencyCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>govAgencyName</column-name><column-value><![CDATA[");
		sb.append(getGovAgencyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantIdNo</column-name><column-value><![CDATA[");
		sb.append(getApplicantIdNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantName</column-name><column-value><![CDATA[");
		sb.append(getApplicantName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subject</column-name><column-value><![CDATA[");
		sb.append(getSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formData</column-name><column-value><![CDATA[");
		sb.append(getFormData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formScript</column-name><column-value><![CDATA[");
		sb.append(getFormScript());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formReport</column-name><column-value><![CDATA[");
		sb.append(getFormReport());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expireDate</column-name><column-value><![CDATA[");
		sb.append(getExpireDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issueDate</column-name><column-value><![CDATA[");
		sb.append(getIssueDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>revalidate</column-name><column-value><![CDATA[");
		sb.append(getRevalidate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deliverableState</column-name><column-value><![CDATA[");
		sb.append(getDeliverableState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierId</column-name><column-value><![CDATA[");
		sb.append(getDossierId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Deliverable.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Deliverable.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _deliverableId;
	private long _originalDeliverableId;
	private boolean _setOriginalDeliverableId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _deliverableCode;
	private String _originalDeliverableCode;
	private String _deliverableName;
	private String _deliverableType;
	private String _originalDeliverableType;
	private String _govAgencyCode;
	private String _originalGovAgencyCode;
	private String _govAgencyName;
	private String _applicantIdNo;
	private String _originalApplicantIdNo;
	private String _applicantName;
	private String _subject;
	private String _formData;
	private String _formScript;
	private String _formReport;
	private Date _expireDate;
	private Date _issueDate;
	private Date _revalidate;
	private String _deliverableState;
	private String _originalDeliverableState;
	private long _fileEntryId;
	private long _dossierId;
	private long _columnBitmask;
	private Deliverable _escapedModel;
}