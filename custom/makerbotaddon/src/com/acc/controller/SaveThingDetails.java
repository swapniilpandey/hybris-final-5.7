/**
 *
 */
package com.acc.controller;

import de.hybris.platform.core.model.user.CustomerModel;
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

import com.acc.dao.MakerbotDetailsDao;
import com.acc.data.MakerbotData;
import com.acc.facade.MakerbotDetailsFacade;


/**
 * @author swapnil.a.pandey
 * 
 */
@Controller
@RequestMapping(value = "/v1/{baseSiteId}/SaveThingDetails")
public class SaveThingDetails
{
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String THINGURL = "thingurl";
	private static final String DESCRIPTION = "description";

	@Autowired
	UserService userService;
	@Autowired
	MakerbotDetailsFacade makerbotDetailsFacade;
	@Autowired
	MakerbotDetailsDao makerbotDetailsDao;


	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String save(final HttpServletRequest request) throws UnsupportedEncodingException, IOException, ParseException

	{
		System.out.println("inside saveMakerbotDetails++++++++++++++++++++++++++++++ ");
		String status = null;

		final StringBuffer sbuf = getJsonBodyString(request);
		if (StringUtils.isNotEmpty(sbuf.toString()))
		{
			final JSONParser parser = new JSONParser();
			final JSONObject obj = (JSONObject) parser.parse(sbuf.toString());
			final String username = String.valueOf(obj.get(USERNAME));
			final String password = String.valueOf(obj.get(PASSWORD));
			final String thingurl = String.valueOf(obj.get(THINGURL));
			final String description = String.valueOf(obj.get(DESCRIPTION));

			System.out.println("thingurl***************" + thingurl);
			System.out.println("description***************" + description);




			final MakerbotData makerbot = makerbotDetailsFacade.getMakerbotAccountDetails(username);

			final CustomerModel customer = makerbotDetailsDao.isCustomerFound(username);



			System.out.println("isCustomermakerbotstatus+++++++++++++++++++++++" + makerbot.isCustomermakerbotstatus());
			if (null != customer)
			{
				if (null == makerbot.getUsername() && !makerbot.isCustomermakerbotstatus())

				{
					makerbotDetailsFacade.saveMakerbotAccountDetails(username, password, thingurl, description);
					System.out.println("user details updated successfully++++++++++++++++++++" + password);
					status = "success";

				}
				else
				{
					status = "failed";
					System.out.println("this is the exiting user++++++++++++++++++++");
				}
			}

			else
			{
				status = "failed";
				System.out.println("unregistered hybris user***********");

			}

			System.out.println("outside if loop***********");

		}

		return status;
	}

	/**
	 * @param request
	 * @return StringBuffer
	 * @throws IOException
	 *            +
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
