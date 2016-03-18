/**
 *
 */
package com.acc.populator;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.acc.data.MakerbotData;
import com.accenture.model.MakerbotModel;


/**
 * @author swapnil.a.pandey
 *
 */
public class MakerbotPopulator implements Populator<MakerbotModel, MakerbotData>
{

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.converters.Populator#populate(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void populate(final MakerbotModel source, final MakerbotData target) throws ConversionException
	{
		final List<String> descList = new ArrayList<String>();
		final List<String> thingList = new ArrayList<String>();
		if (null != source)
		{
			target.setUsername(source.getUsername());
			target.setPassword(source.getPassword());
			if (CollectionUtils.isNotEmpty(source.getDescription()))
			{
				for (final String desc : source.getDescription())
				{
					descList.add(desc);
				}
			}
			target.setDescription(descList);
			target.setCustomermakerbotstatus(source.getCustomermakerbotstatus() == null ? false : source.getCustomermakerbotstatus()
					.booleanValue());
			if (CollectionUtils.isNotEmpty(source.getThingurl()))
			{
				for (final String thing : source.getThingurl())
				{
					thingList.add(thing);
				}
			}
			target.setThingurl(source.getThingurl());


		}

	}

}
