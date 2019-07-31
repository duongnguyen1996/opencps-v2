package org.opencps.statistic.rest.engine.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

public interface VotingStatisticUpdateService<R1> {
	void updateVotingStatistic(R1 payload) throws PortalException, SystemException;
}