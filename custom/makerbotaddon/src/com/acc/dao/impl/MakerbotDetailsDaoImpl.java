/**
 *
 */
package com.acc.dao.impl;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import org.springframework.util.CollectionUtils;

import com.acc.dao.MakerbotDetailsDao;
import com.accenture.model.MakerbotModel;


/**
 * @author swapnil.a.pandey
 *
 */
public class MakerbotDetailsDaoImpl extends AbstractItemDao implements MakerbotDetailsDao
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.dao.MakerbotDetailsDao#getMakerbotAccountDetails(java.lang.String)
	 */
	@Override
	public MakerbotModel getMakerbotAccountDetails(final String username)
	{
		final FlexibleSearchQuery flexibleQuery = new FlexibleSearchQuery("select {pk} from {Makerbot} where {username}='"
				+ username + "'");
		final SearchResult<MakerbotModel> result = getFlexibleSearchService().search(flexibleQuery);


		return CollectionUtils.isEmpty(result.getResult()) ? null : result.getResult().get(0);
	}


	@Override
	public CustomerModel isCustomerFound(final String username)
	{
		FlexibleSearchQuery flexibleQuery = null;

		flexibleQuery = new FlexibleSearchQuery("select {pk} from {customer} where {uid} ='" + username + "'");

		final SearchResult<CustomerModel> result = getFlexibleSearchService().search(flexibleQuery);

		return CollectionUtils.isEmpty(result.getResult()) ? null : result.getResult().get(0);

	}

}
