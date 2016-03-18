/**
 *
 */
package com.acc.service;

import com.accenture.model.MakerbotModel;


/**
 * @author swapnil.a.pandey
 *
 */
public interface MakerbotDetailsService
{
	public MakerbotModel getMakerbotAccountDetails(String username);


	/**
	 * @param username
	 * @param password
	 */
	public void updateMakerbotAccountDetails(String username, String password);

	public void saveMakerbotAccountDetails(String username, String password, String thingurl, String description);





}
