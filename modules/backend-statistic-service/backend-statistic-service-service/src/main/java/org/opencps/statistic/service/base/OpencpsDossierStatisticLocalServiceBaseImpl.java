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

package org.opencps.statistic.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import org.opencps.statistic.model.OpencpsDossierStatistic;
import org.opencps.statistic.service.OpencpsDossierStatisticLocalService;
import org.opencps.statistic.service.persistence.OpencpsDossierStatisticFinder;
import org.opencps.statistic.service.persistence.OpencpsDossierStatisticManualPersistence;
import org.opencps.statistic.service.persistence.OpencpsDossierStatisticPersistence;
import org.opencps.statistic.service.persistence.OpencpsPersonStatisticFinder;
import org.opencps.statistic.service.persistence.OpencpsPersonStatisticPersistence;
import org.opencps.statistic.service.persistence.OpencpsVotingStatisticFinder;
import org.opencps.statistic.service.persistence.OpencpsVotingStatisticPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the opencps dossier statistic local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.opencps.statistic.service.impl.OpencpsDossierStatisticLocalServiceImpl}.
 * </p>
 *
 * @author khoavu
 * @see org.opencps.statistic.service.impl.OpencpsDossierStatisticLocalServiceImpl
 * @see org.opencps.statistic.service.OpencpsDossierStatisticLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class OpencpsDossierStatisticLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements OpencpsDossierStatisticLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.opencps.statistic.service.OpencpsDossierStatisticLocalServiceUtil} to access the opencps dossier statistic local service.
	 */

	/**
	 * Adds the opencps dossier statistic to the database. Also notifies the appropriate model listeners.
	 *
	 * @param opencpsDossierStatistic the opencps dossier statistic
	 * @return the opencps dossier statistic that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public OpencpsDossierStatistic addOpencpsDossierStatistic(
		OpencpsDossierStatistic opencpsDossierStatistic) {
		opencpsDossierStatistic.setNew(true);

		return opencpsDossierStatisticPersistence.update(opencpsDossierStatistic);
	}

	/**
	 * Creates a new opencps dossier statistic with the primary key. Does not add the opencps dossier statistic to the database.
	 *
	 * @param dossierStatisticId the primary key for the new opencps dossier statistic
	 * @return the new opencps dossier statistic
	 */
	@Override
	@Transactional(enabled = false)
	public OpencpsDossierStatistic createOpencpsDossierStatistic(
		long dossierStatisticId) {
		return opencpsDossierStatisticPersistence.create(dossierStatisticId);
	}

	/**
	 * Deletes the opencps dossier statistic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dossierStatisticId the primary key of the opencps dossier statistic
	 * @return the opencps dossier statistic that was removed
	 * @throws PortalException if a opencps dossier statistic with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public OpencpsDossierStatistic deleteOpencpsDossierStatistic(
		long dossierStatisticId) throws PortalException {
		return opencpsDossierStatisticPersistence.remove(dossierStatisticId);
	}

	/**
	 * Deletes the opencps dossier statistic from the database. Also notifies the appropriate model listeners.
	 *
	 * @param opencpsDossierStatistic the opencps dossier statistic
	 * @return the opencps dossier statistic that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public OpencpsDossierStatistic deleteOpencpsDossierStatistic(
		OpencpsDossierStatistic opencpsDossierStatistic) {
		return opencpsDossierStatisticPersistence.remove(opencpsDossierStatistic);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(OpencpsDossierStatistic.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return opencpsDossierStatisticPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.statistic.model.impl.OpencpsDossierStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return opencpsDossierStatisticPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.statistic.model.impl.OpencpsDossierStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return opencpsDossierStatisticPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return opencpsDossierStatisticPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return opencpsDossierStatisticPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public OpencpsDossierStatistic fetchOpencpsDossierStatistic(
		long dossierStatisticId) {
		return opencpsDossierStatisticPersistence.fetchByPrimaryKey(dossierStatisticId);
	}

	/**
	 * Returns the opencps dossier statistic matching the UUID and group.
	 *
	 * @param uuid the opencps dossier statistic's UUID
	 * @param groupId the primary key of the group
	 * @return the matching opencps dossier statistic, or <code>null</code> if a matching opencps dossier statistic could not be found
	 */
	@Override
	public OpencpsDossierStatistic fetchOpencpsDossierStatisticByUuidAndGroupId(
		String uuid, long groupId) {
		return opencpsDossierStatisticPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the opencps dossier statistic with the primary key.
	 *
	 * @param dossierStatisticId the primary key of the opencps dossier statistic
	 * @return the opencps dossier statistic
	 * @throws PortalException if a opencps dossier statistic with the primary key could not be found
	 */
	@Override
	public OpencpsDossierStatistic getOpencpsDossierStatistic(
		long dossierStatisticId) throws PortalException {
		return opencpsDossierStatisticPersistence.findByPrimaryKey(dossierStatisticId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(opencpsDossierStatisticLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(OpencpsDossierStatistic.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("dossierStatisticId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(opencpsDossierStatisticLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(OpencpsDossierStatistic.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"dossierStatisticId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(opencpsDossierStatisticLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(OpencpsDossierStatistic.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("dossierStatisticId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {
		final ExportActionableDynamicQuery exportActionableDynamicQuery = new ExportActionableDynamicQuery() {
				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary = portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(stagedModelType,
						modelAdditionCount);

					long modelDeletionCount = ExportImportHelperUtil.getModelDeletionCount(portletDataContext,
							stagedModelType);

					manifestSummary.addModelDeletionCount(stagedModelType,
						modelDeletionCount);

					return modelAdditionCount;
				}
			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {
				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(dynamicQuery,
						"modifiedDate");
				}
			});

		exportActionableDynamicQuery.setCompanyId(portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<OpencpsDossierStatistic>() {
				@Override
				public void performAction(
					OpencpsDossierStatistic opencpsDossierStatistic)
					throws PortalException {
					StagedModelDataHandlerUtil.exportStagedModel(portletDataContext,
						opencpsDossierStatistic);
				}
			});
		exportActionableDynamicQuery.setStagedModelType(new StagedModelType(
				PortalUtil.getClassNameId(
					OpencpsDossierStatistic.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return opencpsDossierStatisticLocalService.deleteOpencpsDossierStatistic((OpencpsDossierStatistic)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return opencpsDossierStatisticPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the opencps dossier statistics matching the UUID and company.
	 *
	 * @param uuid the UUID of the opencps dossier statistics
	 * @param companyId the primary key of the company
	 * @return the matching opencps dossier statistics, or an empty list if no matches were found
	 */
	@Override
	public List<OpencpsDossierStatistic> getOpencpsDossierStatisticsByUuidAndCompanyId(
		String uuid, long companyId) {
		return opencpsDossierStatisticPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of opencps dossier statistics matching the UUID and company.
	 *
	 * @param uuid the UUID of the opencps dossier statistics
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of opencps dossier statistics
	 * @param end the upper bound of the range of opencps dossier statistics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching opencps dossier statistics, or an empty list if no matches were found
	 */
	@Override
	public List<OpencpsDossierStatistic> getOpencpsDossierStatisticsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<OpencpsDossierStatistic> orderByComparator) {
		return opencpsDossierStatisticPersistence.findByUuid_C(uuid, companyId,
			start, end, orderByComparator);
	}

	/**
	 * Returns the opencps dossier statistic matching the UUID and group.
	 *
	 * @param uuid the opencps dossier statistic's UUID
	 * @param groupId the primary key of the group
	 * @return the matching opencps dossier statistic
	 * @throws PortalException if a matching opencps dossier statistic could not be found
	 */
	@Override
	public OpencpsDossierStatistic getOpencpsDossierStatisticByUuidAndGroupId(
		String uuid, long groupId) throws PortalException {
		return opencpsDossierStatisticPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the opencps dossier statistics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.statistic.model.impl.OpencpsDossierStatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of opencps dossier statistics
	 * @param end the upper bound of the range of opencps dossier statistics (not inclusive)
	 * @return the range of opencps dossier statistics
	 */
	@Override
	public List<OpencpsDossierStatistic> getOpencpsDossierStatistics(
		int start, int end) {
		return opencpsDossierStatisticPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of opencps dossier statistics.
	 *
	 * @return the number of opencps dossier statistics
	 */
	@Override
	public int getOpencpsDossierStatisticsCount() {
		return opencpsDossierStatisticPersistence.countAll();
	}

	/**
	 * Updates the opencps dossier statistic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param opencpsDossierStatistic the opencps dossier statistic
	 * @return the opencps dossier statistic that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public OpencpsDossierStatistic updateOpencpsDossierStatistic(
		OpencpsDossierStatistic opencpsDossierStatistic) {
		return opencpsDossierStatisticPersistence.update(opencpsDossierStatistic);
	}

	/**
	 * Returns the opencps dossier statistic local service.
	 *
	 * @return the opencps dossier statistic local service
	 */
	public OpencpsDossierStatisticLocalService getOpencpsDossierStatisticLocalService() {
		return opencpsDossierStatisticLocalService;
	}

	/**
	 * Sets the opencps dossier statistic local service.
	 *
	 * @param opencpsDossierStatisticLocalService the opencps dossier statistic local service
	 */
	public void setOpencpsDossierStatisticLocalService(
		OpencpsDossierStatisticLocalService opencpsDossierStatisticLocalService) {
		this.opencpsDossierStatisticLocalService = opencpsDossierStatisticLocalService;
	}

	/**
	 * Returns the opencps dossier statistic persistence.
	 *
	 * @return the opencps dossier statistic persistence
	 */
	public OpencpsDossierStatisticPersistence getOpencpsDossierStatisticPersistence() {
		return opencpsDossierStatisticPersistence;
	}

	/**
	 * Sets the opencps dossier statistic persistence.
	 *
	 * @param opencpsDossierStatisticPersistence the opencps dossier statistic persistence
	 */
	public void setOpencpsDossierStatisticPersistence(
		OpencpsDossierStatisticPersistence opencpsDossierStatisticPersistence) {
		this.opencpsDossierStatisticPersistence = opencpsDossierStatisticPersistence;
	}

	/**
	 * Returns the opencps dossier statistic finder.
	 *
	 * @return the opencps dossier statistic finder
	 */
	public OpencpsDossierStatisticFinder getOpencpsDossierStatisticFinder() {
		return opencpsDossierStatisticFinder;
	}

	/**
	 * Sets the opencps dossier statistic finder.
	 *
	 * @param opencpsDossierStatisticFinder the opencps dossier statistic finder
	 */
	public void setOpencpsDossierStatisticFinder(
		OpencpsDossierStatisticFinder opencpsDossierStatisticFinder) {
		this.opencpsDossierStatisticFinder = opencpsDossierStatisticFinder;
	}

	/**
	 * Returns the opencps dossier statistic manual local service.
	 *
	 * @return the opencps dossier statistic manual local service
	 */
	public org.opencps.statistic.service.OpencpsDossierStatisticManualLocalService getOpencpsDossierStatisticManualLocalService() {
		return opencpsDossierStatisticManualLocalService;
	}

	/**
	 * Sets the opencps dossier statistic manual local service.
	 *
	 * @param opencpsDossierStatisticManualLocalService the opencps dossier statistic manual local service
	 */
	public void setOpencpsDossierStatisticManualLocalService(
		org.opencps.statistic.service.OpencpsDossierStatisticManualLocalService opencpsDossierStatisticManualLocalService) {
		this.opencpsDossierStatisticManualLocalService = opencpsDossierStatisticManualLocalService;
	}

	/**
	 * Returns the opencps dossier statistic manual persistence.
	 *
	 * @return the opencps dossier statistic manual persistence
	 */
	public OpencpsDossierStatisticManualPersistence getOpencpsDossierStatisticManualPersistence() {
		return opencpsDossierStatisticManualPersistence;
	}

	/**
	 * Sets the opencps dossier statistic manual persistence.
	 *
	 * @param opencpsDossierStatisticManualPersistence the opencps dossier statistic manual persistence
	 */
	public void setOpencpsDossierStatisticManualPersistence(
		OpencpsDossierStatisticManualPersistence opencpsDossierStatisticManualPersistence) {
		this.opencpsDossierStatisticManualPersistence = opencpsDossierStatisticManualPersistence;
	}

	/**
	 * Returns the opencps person statistic local service.
	 *
	 * @return the opencps person statistic local service
	 */
	public org.opencps.statistic.service.OpencpsPersonStatisticLocalService getOpencpsPersonStatisticLocalService() {
		return opencpsPersonStatisticLocalService;
	}

	/**
	 * Sets the opencps person statistic local service.
	 *
	 * @param opencpsPersonStatisticLocalService the opencps person statistic local service
	 */
	public void setOpencpsPersonStatisticLocalService(
		org.opencps.statistic.service.OpencpsPersonStatisticLocalService opencpsPersonStatisticLocalService) {
		this.opencpsPersonStatisticLocalService = opencpsPersonStatisticLocalService;
	}

	/**
	 * Returns the opencps person statistic persistence.
	 *
	 * @return the opencps person statistic persistence
	 */
	public OpencpsPersonStatisticPersistence getOpencpsPersonStatisticPersistence() {
		return opencpsPersonStatisticPersistence;
	}

	/**
	 * Sets the opencps person statistic persistence.
	 *
	 * @param opencpsPersonStatisticPersistence the opencps person statistic persistence
	 */
	public void setOpencpsPersonStatisticPersistence(
		OpencpsPersonStatisticPersistence opencpsPersonStatisticPersistence) {
		this.opencpsPersonStatisticPersistence = opencpsPersonStatisticPersistence;
	}

	/**
	 * Returns the opencps person statistic finder.
	 *
	 * @return the opencps person statistic finder
	 */
	public OpencpsPersonStatisticFinder getOpencpsPersonStatisticFinder() {
		return opencpsPersonStatisticFinder;
	}

	/**
	 * Sets the opencps person statistic finder.
	 *
	 * @param opencpsPersonStatisticFinder the opencps person statistic finder
	 */
	public void setOpencpsPersonStatisticFinder(
		OpencpsPersonStatisticFinder opencpsPersonStatisticFinder) {
		this.opencpsPersonStatisticFinder = opencpsPersonStatisticFinder;
	}

	/**
	 * Returns the opencps voting statistic local service.
	 *
	 * @return the opencps voting statistic local service
	 */
	public org.opencps.statistic.service.OpencpsVotingStatisticLocalService getOpencpsVotingStatisticLocalService() {
		return opencpsVotingStatisticLocalService;
	}

	/**
	 * Sets the opencps voting statistic local service.
	 *
	 * @param opencpsVotingStatisticLocalService the opencps voting statistic local service
	 */
	public void setOpencpsVotingStatisticLocalService(
		org.opencps.statistic.service.OpencpsVotingStatisticLocalService opencpsVotingStatisticLocalService) {
		this.opencpsVotingStatisticLocalService = opencpsVotingStatisticLocalService;
	}

	/**
	 * Returns the opencps voting statistic persistence.
	 *
	 * @return the opencps voting statistic persistence
	 */
	public OpencpsVotingStatisticPersistence getOpencpsVotingStatisticPersistence() {
		return opencpsVotingStatisticPersistence;
	}

	/**
	 * Sets the opencps voting statistic persistence.
	 *
	 * @param opencpsVotingStatisticPersistence the opencps voting statistic persistence
	 */
	public void setOpencpsVotingStatisticPersistence(
		OpencpsVotingStatisticPersistence opencpsVotingStatisticPersistence) {
		this.opencpsVotingStatisticPersistence = opencpsVotingStatisticPersistence;
	}

	/**
	 * Returns the opencps voting statistic finder.
	 *
	 * @return the opencps voting statistic finder
	 */
	public OpencpsVotingStatisticFinder getOpencpsVotingStatisticFinder() {
		return opencpsVotingStatisticFinder;
	}

	/**
	 * Sets the opencps voting statistic finder.
	 *
	 * @param opencpsVotingStatisticFinder the opencps voting statistic finder
	 */
	public void setOpencpsVotingStatisticFinder(
		OpencpsVotingStatisticFinder opencpsVotingStatisticFinder) {
		this.opencpsVotingStatisticFinder = opencpsVotingStatisticFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("org.opencps.statistic.model.OpencpsDossierStatistic",
			opencpsDossierStatisticLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"org.opencps.statistic.model.OpencpsDossierStatistic");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return OpencpsDossierStatisticLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return OpencpsDossierStatistic.class;
	}

	protected String getModelClassName() {
		return OpencpsDossierStatistic.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = opencpsDossierStatisticPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = OpencpsDossierStatisticLocalService.class)
	protected OpencpsDossierStatisticLocalService opencpsDossierStatisticLocalService;
	@BeanReference(type = OpencpsDossierStatisticPersistence.class)
	protected OpencpsDossierStatisticPersistence opencpsDossierStatisticPersistence;
	@BeanReference(type = OpencpsDossierStatisticFinder.class)
	protected OpencpsDossierStatisticFinder opencpsDossierStatisticFinder;
	@BeanReference(type = org.opencps.statistic.service.OpencpsDossierStatisticManualLocalService.class)
	protected org.opencps.statistic.service.OpencpsDossierStatisticManualLocalService opencpsDossierStatisticManualLocalService;
	@BeanReference(type = OpencpsDossierStatisticManualPersistence.class)
	protected OpencpsDossierStatisticManualPersistence opencpsDossierStatisticManualPersistence;
	@BeanReference(type = org.opencps.statistic.service.OpencpsPersonStatisticLocalService.class)
	protected org.opencps.statistic.service.OpencpsPersonStatisticLocalService opencpsPersonStatisticLocalService;
	@BeanReference(type = OpencpsPersonStatisticPersistence.class)
	protected OpencpsPersonStatisticPersistence opencpsPersonStatisticPersistence;
	@BeanReference(type = OpencpsPersonStatisticFinder.class)
	protected OpencpsPersonStatisticFinder opencpsPersonStatisticFinder;
	@BeanReference(type = org.opencps.statistic.service.OpencpsVotingStatisticLocalService.class)
	protected org.opencps.statistic.service.OpencpsVotingStatisticLocalService opencpsVotingStatisticLocalService;
	@BeanReference(type = OpencpsVotingStatisticPersistence.class)
	protected OpencpsVotingStatisticPersistence opencpsVotingStatisticPersistence;
	@BeanReference(type = OpencpsVotingStatisticFinder.class)
	protected OpencpsVotingStatisticFinder opencpsVotingStatisticFinder;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}