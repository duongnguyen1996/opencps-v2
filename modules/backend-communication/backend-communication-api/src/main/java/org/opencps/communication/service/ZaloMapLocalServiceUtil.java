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

package org.opencps.communication.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ZaloMap. This utility wraps
 * {@link org.opencps.communication.service.impl.ZaloMapLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author khoavd
 * @see ZaloMapLocalService
 * @see org.opencps.communication.service.base.ZaloMapLocalServiceBaseImpl
 * @see org.opencps.communication.service.impl.ZaloMapLocalServiceImpl
 * @generated
 */
@ProviderType
public class ZaloMapLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.opencps.communication.service.impl.ZaloMapLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the zalo map to the database. Also notifies the appropriate model listeners.
	*
	* @param zaloMap the zalo map
	* @return the zalo map that was added
	*/
	public static org.opencps.communication.model.ZaloMap addZaloMap(
		org.opencps.communication.model.ZaloMap zaloMap) {
		return getService().addZaloMap(zaloMap);
	}

	public static org.opencps.communication.model.ZaloMap adminProcessData(
		com.liferay.portal.kernel.json.JSONObject objectData) {
		return getService().adminProcessData(objectData);
	}

	public static org.opencps.communication.model.ZaloMap adminProcessDelete(
		Long id) {
		return getService().adminProcessDelete(id);
	}

	/**
	* Creates a new zalo map with the primary key. Does not add the zalo map to the database.
	*
	* @param zaloMapId the primary key for the new zalo map
	* @return the new zalo map
	*/
	public static org.opencps.communication.model.ZaloMap createZaloMap(
		long zaloMapId) {
		return getService().createZaloMap(zaloMapId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the zalo map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param zaloMapId the primary key of the zalo map
	* @return the zalo map that was removed
	* @throws PortalException if a zalo map with the primary key could not be found
	*/
	public static org.opencps.communication.model.ZaloMap deleteZaloMap(
		long zaloMapId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteZaloMap(zaloMapId);
	}

	/**
	* Deletes the zalo map from the database. Also notifies the appropriate model listeners.
	*
	* @param zaloMap the zalo map
	* @return the zalo map that was removed
	*/
	public static org.opencps.communication.model.ZaloMap deleteZaloMap(
		org.opencps.communication.model.ZaloMap zaloMap) {
		return getService().deleteZaloMap(zaloMap);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.communication.model.impl.ZaloMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.communication.model.impl.ZaloMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.opencps.communication.model.ZaloMap fetchZaloMap(
		long zaloMapId) {
		return getService().fetchZaloMap(zaloMapId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<org.opencps.communication.model.ZaloMap> getByGroupId(
		long groupId) {
		return getService().getByGroupId(groupId);
	}

	public static java.util.List<org.opencps.communication.model.ZaloMap> getByOAId(
		String oAId) {
		return getService().getByOAId(oAId);
	}

	public static org.opencps.communication.model.ZaloMap getByTelNo(
		String telNo) {
		return getService().getByTelNo(telNo);
	}

	public static org.opencps.communication.model.ZaloMap getByUId(String uId) {
		return getService().getByUId(uId);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the zalo map with the primary key.
	*
	* @param zaloMapId the primary key of the zalo map
	* @return the zalo map
	* @throws PortalException if a zalo map with the primary key could not be found
	*/
	public static org.opencps.communication.model.ZaloMap getZaloMap(
		long zaloMapId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getZaloMap(zaloMapId);
	}

	/**
	* Returns a range of all the zalo maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.communication.model.impl.ZaloMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of zalo maps
	* @param end the upper bound of the range of zalo maps (not inclusive)
	* @return the range of zalo maps
	*/
	public static java.util.List<org.opencps.communication.model.ZaloMap> getZaloMaps(
		int start, int end) {
		return getService().getZaloMaps(start, end);
	}

	/**
	* Returns the number of zalo maps.
	*
	* @return the number of zalo maps
	*/
	public static int getZaloMapsCount() {
		return getService().getZaloMapsCount();
	}

	public static org.opencps.communication.model.ZaloMap removeByPrimaryKey(
		long zaloMapId) {
		return getService().removeByPrimaryKey(zaloMapId);
	}

	public static org.opencps.communication.model.ZaloMap updateZaloMap(
		long zaloMapId, long groupId, String uId, String telNo, String oAId,
		int isFollow, String payload)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateZaloMap(zaloMapId, groupId, uId, telNo, oAId,
			isFollow, payload);
	}

	/**
	* Updates the zalo map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param zaloMap the zalo map
	* @return the zalo map that was updated
	*/
	public static org.opencps.communication.model.ZaloMap updateZaloMap(
		org.opencps.communication.model.ZaloMap zaloMap) {
		return getService().updateZaloMap(zaloMap);
	}

	public static ZaloMapLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ZaloMapLocalService, ZaloMapLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ZaloMapLocalService.class);

		ServiceTracker<ZaloMapLocalService, ZaloMapLocalService> serviceTracker = new ServiceTracker<ZaloMapLocalService, ZaloMapLocalService>(bundle.getBundleContext(),
				ZaloMapLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}