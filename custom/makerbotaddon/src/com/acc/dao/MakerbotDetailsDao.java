/**
 *
 */
package com.acc.dao;

import de.hybris.platform.core.model.user.CustomerModel;

import com.accenture.model.MakerbotModel;


/**
 * @author swapnil.a.pandey
 *
 */
public interface MakerbotDetailsDao
{
	public MakerbotModel getMakerbotAccountDetails(String username);

	/**
	 * @param username
	 * @return
	 */
	public CustomerModel isCustomerFound(String username);
}
