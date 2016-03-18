/**
 *
 */
package com.acc.facade;

import com.acc.data.MakerbotData;


/**
 * @author swapnil.a.pandey
 *
 */
public interface MakerbotDetailsFacade
{
	public MakerbotData getMakerbotAccountDetails(String username);

	public void updateMakerbotAccountDetails(String username, String password);

	public void saveMakerbotAccountDetails(String username, String password, final String thingurl, final String description);
}
