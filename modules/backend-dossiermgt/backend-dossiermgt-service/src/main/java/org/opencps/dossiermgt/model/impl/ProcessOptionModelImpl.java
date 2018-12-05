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

import org.opencps.dossiermgt.model.ProcessOption;
import org.opencps.dossiermgt.model.ProcessOptionModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ProcessOption service. Represents a row in the &quot;opencps_processoption&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ProcessOptionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProcessOptionImpl}.
 * </p>
 *
 * @author huymq
 * @see ProcessOptionImpl
 * @see ProcessOption
 * @see ProcessOptionModel
 * @generated
 */
@ProviderType
public class ProcessOptionModelImpl extends BaseModelImpl<ProcessOption>
	implements ProcessOptionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a process option model instance should use the {@link ProcessOption} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_processoption";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "processOptionId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "serviceConfigId", Types.BIGINT },
			{ "optionOrder", Types.INTEGER },
			{ "optionName", Types.VARCHAR },
			{ "autoSelect", Types.VARCHAR },
			{ "dossierTemplateId", Types.BIGINT },
			{ "serviceProcessId", Types.BIGINT },
			{ "instructionNote", Types.VARCHAR },
			{ "submissionNote", Types.VARCHAR },
			{ "sampleCount", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("processOptionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("serviceConfigId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("optionOrder", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("optionName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("autoSelect", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dossierTemplateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("serviceProcessId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("instructionNote", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("submissionNote", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sampleCount", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_processoption (uuid_ VARCHAR(75) null,processOptionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(255) null,createDate DATE null,modifiedDate DATE null,serviceConfigId LONG,optionOrder INTEGER,optionName VARCHAR(500) null,autoSelect VARCHAR(500) null,dossierTemplateId LONG,serviceProcessId LONG,instructionNote TEXT null,submissionNote TEXT null,sampleCount LONG)";
	public static final String TABLE_SQL_DROP = "drop table opencps_processoption";
	public static final String ORDER_BY_JPQL = " ORDER BY processOption.processOptionId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_processoption.processOptionId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.dossiermgt.model.ProcessOption"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.dossiermgt.model.ProcessOption"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.dossiermgt.model.ProcessOption"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long DOSSIERTEMPLATEID_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long OPTIONORDER_COLUMN_BITMASK = 8L;
	public static final long SERVICECONFIGID_COLUMN_BITMASK = 16L;
	public static final long UUID_COLUMN_BITMASK = 32L;
	public static final long PROCESSOPTIONID_COLUMN_BITMASK = 64L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.dossiermgt.model.ProcessOption"));

	public ProcessOptionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _processOptionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProcessOptionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _processOptionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProcessOption.class;
	}

	@Override
	public String getModelClassName() {
		return ProcessOption.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("processOptionId", getProcessOptionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("serviceConfigId", getServiceConfigId());
		attributes.put("optionOrder", getOptionOrder());
		attributes.put("optionName", getOptionName());
		attributes.put("autoSelect", getAutoSelect());
		attributes.put("dossierTemplateId", getDossierTemplateId());
		attributes.put("serviceProcessId", getServiceProcessId());
		attributes.put("instructionNote", getInstructionNote());
		attributes.put("submissionNote", getSubmissionNote());
		attributes.put("sampleCount", getSampleCount());

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

		Long processOptionId = (Long)attributes.get("processOptionId");

		if (processOptionId != null) {
			setProcessOptionId(processOptionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Long serviceConfigId = (Long)attributes.get("serviceConfigId");

		if (serviceConfigId != null) {
			setServiceConfigId(serviceConfigId);
		}

		Integer optionOrder = (Integer)attributes.get("optionOrder");

		if (optionOrder != null) {
			setOptionOrder(optionOrder);
		}

		String optionName = (String)attributes.get("optionName");

		if (optionName != null) {
			setOptionName(optionName);
		}

		String autoSelect = (String)attributes.get("autoSelect");

		if (autoSelect != null) {
			setAutoSelect(autoSelect);
		}

		Long dossierTemplateId = (Long)attributes.get("dossierTemplateId");

		if (dossierTemplateId != null) {
			setDossierTemplateId(dossierTemplateId);
		}

		Long serviceProcessId = (Long)attributes.get("serviceProcessId");

		if (serviceProcessId != null) {
			setServiceProcessId(serviceProcessId);
		}

		String instructionNote = (String)attributes.get("instructionNote");

		if (instructionNote != null) {
			setInstructionNote(instructionNote);
		}

		String submissionNote = (String)attributes.get("submissionNote");

		if (submissionNote != null) {
			setSubmissionNote(submissionNote);
		}

		Long sampleCount = (Long)attributes.get("sampleCount");

		if (sampleCount != null) {
			setSampleCount(sampleCount);
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
	public long getProcessOptionId() {
		return _processOptionId;
	}

	@Override
	public void setProcessOptionId(long processOptionId) {
		_processOptionId = processOptionId;
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
	public long getServiceConfigId() {
		return _serviceConfigId;
	}

	@Override
	public void setServiceConfigId(long serviceConfigId) {
		_columnBitmask |= SERVICECONFIGID_COLUMN_BITMASK;

		if (!_setOriginalServiceConfigId) {
			_setOriginalServiceConfigId = true;

			_originalServiceConfigId = _serviceConfigId;
		}

		_serviceConfigId = serviceConfigId;
	}

	public long getOriginalServiceConfigId() {
		return _originalServiceConfigId;
	}

	@Override
	public int getOptionOrder() {
		return _optionOrder;
	}

	@Override
	public void setOptionOrder(int optionOrder) {
		_columnBitmask |= OPTIONORDER_COLUMN_BITMASK;

		if (!_setOriginalOptionOrder) {
			_setOriginalOptionOrder = true;

			_originalOptionOrder = _optionOrder;
		}

		_optionOrder = optionOrder;
	}

	public int getOriginalOptionOrder() {
		return _originalOptionOrder;
	}

	@Override
	public String getOptionName() {
		if (_optionName == null) {
			return "";
		}
		else {
			return _optionName;
		}
	}

	@Override
	public void setOptionName(String optionName) {
		_optionName = optionName;
	}

	@Override
	public String getAutoSelect() {
		if (_autoSelect == null) {
			return "";
		}
		else {
			return _autoSelect;
		}
	}

	@Override
	public void setAutoSelect(String autoSelect) {
		_autoSelect = autoSelect;
	}

	@Override
	public long getDossierTemplateId() {
		return _dossierTemplateId;
	}

	@Override
	public void setDossierTemplateId(long dossierTemplateId) {
		_columnBitmask |= DOSSIERTEMPLATEID_COLUMN_BITMASK;

		if (!_setOriginalDossierTemplateId) {
			_setOriginalDossierTemplateId = true;

			_originalDossierTemplateId = _dossierTemplateId;
		}

		_dossierTemplateId = dossierTemplateId;
	}

	public long getOriginalDossierTemplateId() {
		return _originalDossierTemplateId;
	}

	@Override
	public long getServiceProcessId() {
		return _serviceProcessId;
	}

	@Override
	public void setServiceProcessId(long serviceProcessId) {
		_serviceProcessId = serviceProcessId;
	}

	@Override
	public String getInstructionNote() {
		if (_instructionNote == null) {
			return "";
		}
		else {
			return _instructionNote;
		}
	}

	@Override
	public void setInstructionNote(String instructionNote) {
		_instructionNote = instructionNote;
	}

	@Override
	public String getSubmissionNote() {
		if (_submissionNote == null) {
			return "";
		}
		else {
			return _submissionNote;
		}
	}

	@Override
	public void setSubmissionNote(String submissionNote) {
		_submissionNote = submissionNote;
	}

	@Override
	public long getSampleCount() {
		return _sampleCount;
	}

	@Override
	public void setSampleCount(long sampleCount) {
		_sampleCount = sampleCount;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ProcessOption.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ProcessOption.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProcessOption toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ProcessOption)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProcessOptionImpl processOptionImpl = new ProcessOptionImpl();

		processOptionImpl.setUuid(getUuid());
		processOptionImpl.setProcessOptionId(getProcessOptionId());
		processOptionImpl.setGroupId(getGroupId());
		processOptionImpl.setCompanyId(getCompanyId());
		processOptionImpl.setUserId(getUserId());
		processOptionImpl.setUserName(getUserName());
		processOptionImpl.setCreateDate(getCreateDate());
		processOptionImpl.setModifiedDate(getModifiedDate());
		processOptionImpl.setServiceConfigId(getServiceConfigId());
		processOptionImpl.setOptionOrder(getOptionOrder());
		processOptionImpl.setOptionName(getOptionName());
		processOptionImpl.setAutoSelect(getAutoSelect());
		processOptionImpl.setDossierTemplateId(getDossierTemplateId());
		processOptionImpl.setServiceProcessId(getServiceProcessId());
		processOptionImpl.setInstructionNote(getInstructionNote());
		processOptionImpl.setSubmissionNote(getSubmissionNote());
		processOptionImpl.setSampleCount(getSampleCount());

		processOptionImpl.resetOriginalValues();

		return processOptionImpl;
	}

	@Override
	public int compareTo(ProcessOption processOption) {
		long primaryKey = processOption.getPrimaryKey();

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

		if (!(obj instanceof ProcessOption)) {
			return false;
		}

		ProcessOption processOption = (ProcessOption)obj;

		long primaryKey = processOption.getPrimaryKey();

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
		ProcessOptionModelImpl processOptionModelImpl = this;

		processOptionModelImpl._originalUuid = processOptionModelImpl._uuid;

		processOptionModelImpl._originalGroupId = processOptionModelImpl._groupId;

		processOptionModelImpl._setOriginalGroupId = false;

		processOptionModelImpl._originalCompanyId = processOptionModelImpl._companyId;

		processOptionModelImpl._setOriginalCompanyId = false;

		processOptionModelImpl._setModifiedDate = false;

		processOptionModelImpl._originalServiceConfigId = processOptionModelImpl._serviceConfigId;

		processOptionModelImpl._setOriginalServiceConfigId = false;

		processOptionModelImpl._originalOptionOrder = processOptionModelImpl._optionOrder;

		processOptionModelImpl._setOriginalOptionOrder = false;

		processOptionModelImpl._originalDossierTemplateId = processOptionModelImpl._dossierTemplateId;

		processOptionModelImpl._setOriginalDossierTemplateId = false;

		processOptionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ProcessOption> toCacheModel() {
		ProcessOptionCacheModel processOptionCacheModel = new ProcessOptionCacheModel();

		processOptionCacheModel.uuid = getUuid();

		String uuid = processOptionCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			processOptionCacheModel.uuid = null;
		}

		processOptionCacheModel.processOptionId = getProcessOptionId();

		processOptionCacheModel.groupId = getGroupId();

		processOptionCacheModel.companyId = getCompanyId();

		processOptionCacheModel.userId = getUserId();

		processOptionCacheModel.userName = getUserName();

		String userName = processOptionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			processOptionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			processOptionCacheModel.createDate = createDate.getTime();
		}
		else {
			processOptionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			processOptionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			processOptionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		processOptionCacheModel.serviceConfigId = getServiceConfigId();

		processOptionCacheModel.optionOrder = getOptionOrder();

		processOptionCacheModel.optionName = getOptionName();

		String optionName = processOptionCacheModel.optionName;

		if ((optionName != null) && (optionName.length() == 0)) {
			processOptionCacheModel.optionName = null;
		}

		processOptionCacheModel.autoSelect = getAutoSelect();

		String autoSelect = processOptionCacheModel.autoSelect;

		if ((autoSelect != null) && (autoSelect.length() == 0)) {
			processOptionCacheModel.autoSelect = null;
		}

		processOptionCacheModel.dossierTemplateId = getDossierTemplateId();

		processOptionCacheModel.serviceProcessId = getServiceProcessId();

		processOptionCacheModel.instructionNote = getInstructionNote();

		String instructionNote = processOptionCacheModel.instructionNote;

		if ((instructionNote != null) && (instructionNote.length() == 0)) {
			processOptionCacheModel.instructionNote = null;
		}

		processOptionCacheModel.submissionNote = getSubmissionNote();

		String submissionNote = processOptionCacheModel.submissionNote;

		if ((submissionNote != null) && (submissionNote.length() == 0)) {
			processOptionCacheModel.submissionNote = null;
		}

		processOptionCacheModel.sampleCount = getSampleCount();

		return processOptionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", processOptionId=");
		sb.append(getProcessOptionId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", serviceConfigId=");
		sb.append(getServiceConfigId());
		sb.append(", optionOrder=");
		sb.append(getOptionOrder());
		sb.append(", optionName=");
		sb.append(getOptionName());
		sb.append(", autoSelect=");
		sb.append(getAutoSelect());
		sb.append(", dossierTemplateId=");
		sb.append(getDossierTemplateId());
		sb.append(", serviceProcessId=");
		sb.append(getServiceProcessId());
		sb.append(", instructionNote=");
		sb.append(getInstructionNote());
		sb.append(", submissionNote=");
		sb.append(getSubmissionNote());
		sb.append(", sampleCount=");
		sb.append(getSampleCount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("org.opencps.dossiermgt.model.ProcessOption");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processOptionId</column-name><column-value><![CDATA[");
		sb.append(getProcessOptionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
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
			"<column><column-name>serviceConfigId</column-name><column-value><![CDATA[");
		sb.append(getServiceConfigId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>optionOrder</column-name><column-value><![CDATA[");
		sb.append(getOptionOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>optionName</column-name><column-value><![CDATA[");
		sb.append(getOptionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>autoSelect</column-name><column-value><![CDATA[");
		sb.append(getAutoSelect());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierTemplateId</column-name><column-value><![CDATA[");
		sb.append(getDossierTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceProcessId</column-name><column-value><![CDATA[");
		sb.append(getServiceProcessId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>instructionNote</column-name><column-value><![CDATA[");
		sb.append(getInstructionNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>submissionNote</column-name><column-value><![CDATA[");
		sb.append(getSubmissionNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sampleCount</column-name><column-value><![CDATA[");
		sb.append(getSampleCount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ProcessOption.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ProcessOption.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _processOptionId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _serviceConfigId;
	private long _originalServiceConfigId;
	private boolean _setOriginalServiceConfigId;
	private int _optionOrder;
	private int _originalOptionOrder;
	private boolean _setOriginalOptionOrder;
	private String _optionName;
	private String _autoSelect;
	private long _dossierTemplateId;
	private long _originalDossierTemplateId;
	private boolean _setOriginalDossierTemplateId;
	private long _serviceProcessId;
	private String _instructionNote;
	private String _submissionNote;
	private long _sampleCount;
	private long _columnBitmask;
	private ProcessOption _escapedModel;
}