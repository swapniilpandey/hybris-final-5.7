/**
 *
 */
package com.acc.facade.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;

import javax.annotation.Resource;

import com.acc.data.MakerbotData;
import com.acc.facade.MakerbotDetailsFacade;
import com.acc.service.MakerbotDetailsService;
import com.acc.service.impl.MakerbotDetailsServiceImpl;
import com.accenture.model.MakerbotModel;


/**
 * @author swapnil.a.pandey
 *
 */
public class MakerbotDetailsFacadeImpl implements MakerbotDetailsFacade
{

	@Resource(name = "makerbotDetailsService")
	private MakerbotDetailsService makerbotDetailsService;

	@Resource(name = "makerbotConverter")
	private Converter<MakerbotModel, MakerbotData> makerbotConverter;


	/**
	 * @return the makerbotDetailsService
	 */
	public MakerbotDetailsService getMakerbotDetailsService()
	{
		return makerbotDetailsService;
	}



	/**
	 * @param makerbotDetailsService
	 *           the makerbotDetailsService to set
	 */
	public void setMakerbotDetailsService(final MakerbotDetailsServiceImpl makerbotDetailsService)
	{
		this.makerbotDetailsService = makerbotDetailsService;
	}



	/**
	 * @return the makerbotConverter
	 */
	public Converter<MakerbotModel, MakerbotData> getMakerbotConverter()
	{
		return makerbotConverter;
	}



	/**
	 * @param makerbotConverter
	 *           the makerbotConverter to set
	 */
	public void setMakerbotConverter(final Converter<MakerbotModel, MakerbotData> makerbotConverter)
	{
		this.makerbotConverter = makerbotConverter;
	}






	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.facade.MakerbotDetailsFacade#getMakerbotAccountDetails()
	 */
	@Override
	public MakerbotData getMakerbotAccountDetails(final String username)
	{
		// YTODO Auto-generated method stub

		final MakerbotModel model = makerbotDetailsService.getMakerbotAccountDetails(username);

		final MakerbotData data = makerbotConverter.convert(model);
		System.out.println("inside facade*******************************");

		return data;
	}

	@Override
	public void updateMakerbotAccountDetails(final String username, final String password)
	{
		makerbotDetailsService.updateMakerbotAccountDetails(username, password);

	}



	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.facade.MakerbotDetailsFacade#saveMakerbotAccountDetails(java.lang.String, java.lang.String)
	 */
	@Override
	public void saveMakerbotAccountDetails(final String username, final String password, final String thingurl,
			final String description)
	{
		// YTODO Auto-generated method stub
		makerbotDetailsService.saveMakerbotAccountDetails(username, password, thingurl, description);

	}

}
