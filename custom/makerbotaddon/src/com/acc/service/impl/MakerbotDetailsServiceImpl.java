/**
 *
 */
package com.acc.service.impl;

import de.hybris.platform.servicelayer.model.ModelService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.acc.dao.MakerbotDetailsDao;
import com.acc.service.MakerbotDetailsService;
import com.accenture.model.MakerbotModel;



/**
 * @author swapnil.a.pandey
 * 
 */
public class MakerbotDetailsServiceImpl implements MakerbotDetailsService
{
	@Resource(name = "makerbotDetailsDao")
	private MakerbotDetailsDao makerbotDetailsDao;
	@Resource(name = "modelService")
	private ModelService modelService;
	private static MessageDigest digester;


	static
	{
		System.out.println("inside updateMakerbotDetails++++++++++++++++++++++++++++++ ");

		try
		{
			digester = MessageDigest.getInstance("MD5");
		}
		catch (final NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
	}



	/**
	 * @return the modelService
	 */
	public ModelService getModelService()
	{
		return modelService;
	}



	/**
	 * @param modelService
	 *           the modelService to set
	 */
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}



	/**
	 * @return the makerbotDetailsDao
	 */
	public MakerbotDetailsDao getMakerbotDetailsDao()
	{
		return makerbotDetailsDao;
	}



	/**
	 * @param makerbotDetailsDao
	 *           the makerbotDetailsDao to set
	 */
	public void setMakerbotDetailsDao(final MakerbotDetailsDao makerbotDetailsDao)
	{
		this.makerbotDetailsDao = makerbotDetailsDao;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see MakerbotDetailsService.MakerbotDetailsService#getMakerbotAccountDetails(java.lang.String)
	 */
	@Override
	public MakerbotModel getMakerbotAccountDetails(final String username)
	{
		// YTODO Auto-generated method stub
		return makerbotDetailsDao.getMakerbotAccountDetails(username);
	}

	@Override
	public void updateMakerbotAccountDetails(final String username, final String password)
	{
		System.out.println("String Password+++++++++++++++++++++++++++++" + password);
		final String encryptedPassword = encryptPassword(password);

		System.out.println("String encryptedPassword+++++++++++++++++++++++++++++" + encryptedPassword);

		final MakerbotModel makerbot = makerbotDetailsDao.getMakerbotAccountDetails(username);
		makerbot.setPassword(encryptedPassword);
		makerbot.setCustomermakerbotstatus(Boolean.TRUE);
		System.out.println("inside sevice class+++++++++++++" + makerbot.getPassword() + "*****" + password);
		modelService.save(makerbot);


	}

	@Override
	public void saveMakerbotAccountDetails(final String username, final String password, final String thingurl,
			final String description)
	{
		System.out.println("String Password+++++++++++++++++++++++++++++" + password);

		final String encryptedPassword = encryptPassword(password);

		System.out.println("String encryptedPassword+++++++++++++++++++++++++++++" + encryptedPassword);
		final List<String> thingList = new ArrayList<String>();
		final List<String> descList = new ArrayList<String>();
		final MakerbotModel makerbot = modelService.create(MakerbotModel.class);
		makerbot.setUsername(username);
		makerbot.setPassword(encryptedPassword);
		makerbot.setCustomermakerbotstatus(Boolean.TRUE);

		thingList.add(thingurl);
		makerbot.setThingurl(thingList);


		descList.add(description);


		makerbot.setDescription(descList);
		System.out.println("inside sevice class+++++++++++++" + makerbot.getPassword() + "*****" + password);
		System.out.println("inside sevice class+++++++++++++" + makerbot.getDescription() + "*****" + thingurl);
		System.out.println("inside sevice class+++++++++++++" + makerbot.getThingurl() + "*****" + description);

		modelService.save(makerbot);


	}

	private String encryptPassword(final String password)
	{
		digester.update(password.getBytes());
		final byte[] hash = digester.digest();
		final StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++)
		{
			if ((0xff & hash[i]) < 0x10)
			{
				hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
			}
			else
			{
				hexString.append(Integer.toHexString(0xFF & hash[i]));
			}
		}
		final String encryptedPassword = hexString.toString();
		System.out.println("the encrypted password is +++++++++++++++++++++++++++++" + encryptedPassword);


		return encryptedPassword;
	}

}
