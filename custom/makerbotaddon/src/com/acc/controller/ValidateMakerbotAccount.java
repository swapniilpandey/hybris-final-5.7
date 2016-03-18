/**
 *
 */
package com.acc.controller;

import de.hybris.platform.servicelayer.user.UserService;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acc.data.MakerbotData;
import com.acc.facade.MakerbotDetailsFacade;


/**
 * @author swapnil.a.pandey
 *
 */
@Controller
@RequestMapping(value = "/v1/{baseSiteId}/ValidateMakerbotAccount")
public class ValidateMakerbotAccount
{
	private static final String USERNAME = "username";

	@Autowired
	UserService userService;

	@Autowired
	MakerbotDetailsFacade makerbotDetailsFacade;


	@RequestMapping(value = "/validate", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String validateCustomerMakerbotAccount(final HttpServletRequest request) throws UnsupportedEncodingException,
			IOException, ParseException
	{
		System.out.println("inside validateCustomerMakerbotAccount++++++++++++++++++++++++++++++ ");

		String status = null;

		final StringBuffer sbuf = getJsonBodyString(request);
		if (StringUtils.isNotEmpty(sbuf.toString()))
		{
			final JSONParser parser = new JSONParser();
			final JSONObject obj = (JSONObject) parser.parse(sbuf.toString());

			final String userName = String.valueOf(obj.get(USERNAME));
			final MakerbotData makerbot = makerbotDetailsFacade.getMakerbotAccountDetails(userName);
			System.out.println("makerbot++++++" + makerbot);
			if (null != makerbot.getUsername())
			{
				System.out.println("makerbot++++++" + makerbot.getUsername());

				status = "enabled";
			}
			else
			{
				status = "disabled";

			}

		}

		return status;


	}

	/**
	 * @param request
	 * @return StringBuffer
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	private StringBuffer getJsonBodyString(final HttpServletRequest request) throws IOException, UnsupportedEncodingException
	{
		final ServletInputStream input = request.getInputStream();
		final byte[] buf = new byte[201];
		final StringBuffer sbuf = new StringBuffer();
		int result;
		do
		{
			result = input.readLine(buf, 0, buf.length);
			if (result != -1)
			{
				sbuf.append(new String(buf, 0, result, "UTF-8"));
			}
			else
			{
				break;
			}
		}
		while (result == buf.length);
		return sbuf;
	}
}
