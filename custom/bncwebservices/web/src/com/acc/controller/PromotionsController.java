/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2013 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 * 
 *  
 */
package com.acc.controller;

import de.hybris.platform.commercefacades.product.data.PromotionData;
import de.hybris.platform.commercefacades.promotion.CommercePromotionFacade;
import de.hybris.platform.commercefacades.promotion.PromotionOption;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acc.constants.YcommercewebservicesConstants;
import com.acc.product.data.PromotionDataList;
import com.google.common.base.Strings;


/**
 * Main Controller for Promotions
 */
@Controller
@RequestMapping(value = "/v1/{baseSiteId}/promotions")
public class PromotionsController extends BaseController
{
	private static final Logger LOG = Logger.getLogger(PromotionsController.class);
	private static final String ORDER_PROMOTION = "order";
	private static final String PRODUCT_PROMOTION = "product";
	private static final String ALL_PROMOTIONS = "all";
	@Resource(name = "commercePromotionFacade")
	private CommercePromotionFacade commercePromotionFacade;

	@Secured("ROLE_TRUSTED_CLIENT")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public PromotionDataList getPromotions(@RequestParam final String type,
			@RequestParam(required = false) final String promotionGroup)
	{
		validateTypeParameter(type);
		final PromotionDataList promotionDataList = new PromotionDataList();
		promotionDataList.setPromotions(getPromotionList(type, promotionGroup));
		return promotionDataList;
	}

	/**
	 * Web service handler for the getPromotionByCode call. The options are turned into a Set<PromotionOption> and passed
	 * on to the facade. BASIC is included by default. <br/>
	 * Sample Call: https://localhost:9002/rest/v1/{SITE}/promotions/{CODE}?options=BASIC%2CEXTENDED <br/>
	 * Keep in mind ',' needs to be encoded as %2C
	 * 
	 * @param code
	 *           - the unique code used to identify a promotion
	 * @param options
	 *           - a String enumerating the detail level, values are BASIC (included by default), EXTENDED. Combine by
	 *           using a ',', which needs to be encoded as part of a URI using URLEncoding: %2C.
	 * @return the {@link PromotionData} which will be marshaled to JSON or XML based on Accept-Header
	 */
	@Secured("ROLE_TRUSTED_CLIENT")
	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	@ResponseBody
	public PromotionData getPromotionByCode(@PathVariable final String code, @RequestParam(required = false) final String options)
	{
		final PromotionData promotionData;
		if (Strings.isNullOrEmpty(options))
		{
			promotionData = commercePromotionFacade.getPromotion(code);
		}
		else
		{
			promotionData = commercePromotionFacade.getPromotion(code, extractOptions(options));
		}
		return promotionData;
	}

	protected void validateTypeParameter(final String type) throws IllegalArgumentException
	{
		if (!ORDER_PROMOTION.equals(type) && !PRODUCT_PROMOTION.equals(type) && !ALL_PROMOTIONS.equals(type))
		{
			throw new IllegalArgumentException("Parameter type=" + type
					+ " is not supported. Permitted values for this parameter are : 'order' or 'product' or 'all'");
		}
	}

	protected List<PromotionData> getPromotionList(final String type, final String promotionGroup)
	{
		if (promotionGroup == null || promotionGroup.isEmpty())
		{
			return getPromotionList(type);
		}

		List<PromotionData> promotions = null;
		if (ORDER_PROMOTION.equals(type))
		{
			promotions = getCommercePromotionFacade().getOrderPromotions(promotionGroup);
		}
		else if (PRODUCT_PROMOTION.equals(type))
		{
			promotions = getCommercePromotionFacade().getProductPromotions(promotionGroup);
		}
		else if (ALL_PROMOTIONS.equals(type))
		{
			promotions = getCommercePromotionFacade().getProductPromotions(promotionGroup);
			promotions.addAll(getCommercePromotionFacade().getOrderPromotions(promotionGroup));
		}
		return promotions;

	}

	protected List<PromotionData> getPromotionList(final String type)
	{
		List<PromotionData> promotions = null;
		if (ORDER_PROMOTION.equals(type))
		{
			promotions = getCommercePromotionFacade().getOrderPromotions();
		}
		else if (PRODUCT_PROMOTION.equals(type))
		{
			promotions = getCommercePromotionFacade().getProductPromotions();
		}
		else if (ALL_PROMOTIONS.equals(type))
		{
			promotions = getCommercePromotionFacade().getProductPromotions();
			promotions.addAll(getCommercePromotionFacade().getOrderPromotions());
		}
		return promotions;
	}

	protected Set<PromotionOption> extractOptions(final String options)
	{
		final String optionsStrings[] = options.split(YcommercewebservicesConstants.OPTIONS_SEPARATOR);

		final Set<PromotionOption> opts = new HashSet<PromotionOption>();
		for (final String option : optionsStrings)
		{
			opts.add(PromotionOption.valueOf(option));
		}
		return opts;
	}

	public CommercePromotionFacade getCommercePromotionFacade()
	{
		return commercePromotionFacade;
	}

	public void setCommercePromotionFacade(final CommercePromotionFacade commercePromotionFacade)
	{
		this.commercePromotionFacade = commercePromotionFacade;
	}

}
