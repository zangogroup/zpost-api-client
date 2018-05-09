package com.zango.zpost.api.client;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.zango.zpost.api.service.ZPostLocalServiceUtil;

/**
 * Portlet implementation class ZPostAPIClientPortlet
 */
public class ZPostAPIClientPortlet extends MVCPortlet {

	public void registerAccount(ActionRequest request, ActionResponse response) {

		try {
			String accountId = "A12345";
			String accountLabel = "Zango (Maurice) Ltée";
			String customerId = "C12345";
			String customerLabel = "Groupe Zango";
			List<String> emailAddresses = ListUtil.fromString("eric.coquelin@zango.pro,reda.zejli@zango.pro",
					StringPool.COMMA);
			Date fromDate = new Date();
			String vendorId = "MT/mobile";
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

			ZPostLocalServiceUtil.registerAccount(accountId, accountLabel, customerLabel, customerId, emailAddresses,
					fromDate, vendorId, serviceContext);

			/*
			 * If it reaches that point, then the call message has been queued and will be
			 * processed soon. If any errors raise from the call, then developer should
			 * catch them using the MessageListener
			 */

		} catch (SystemException | PortalException e) {
			/*
			 * If any errors raise here, that means that something went wrong before the
			 * call to ZPost webservices was queued
			 */
		}

	}

	public void registerCustomer(ActionRequest request, ActionResponse response) {

		try {
			String customerId = "C12345";
			String customerLabel = "Groupe Zango";
			List<String> emailAddresses = ListUtil.fromString("eric.coquelin@zango.pro,reda.zejli@zango.pro",
					StringPool.COMMA);
			Date fromDate = new Date();
			String vendorId = "MT/mobile";
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

			ZPostLocalServiceUtil.registerCustomer(customerId, customerLabel, emailAddresses, fromDate, vendorId,
					serviceContext);

			/*
			 * If it reaches that point, then the call message has been queued and will be
			 * processed soon. If any errors raise from the call, then developer should
			 * catch them using the MessageListener
			 */

		} catch (SystemException | PortalException e) {
			/*
			 * If any errors raise here, that means that something went wrong before the
			 * call to ZPost webservices was queued
			 */
		}

	}

	public void updateAccount(ActionRequest request, ActionResponse response) {

		try {
			String accountId = "A12345";
			String accountLabel = "Zango (Maurice) Ltée";
			String customerId = "C12345";
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

			ZPostLocalServiceUtil.updateAccount(accountId, accountLabel, customerId, serviceContext);

			/*
			 * If it reaches that point, then the call message has been queued and will be
			 * processed soon. If any errors raise from the call, then developer should
			 * catch them using the MessageListener
			 */

		} catch (SystemException | PortalException e) {
			/*
			 * If any errors raise here, that means that something went wrong before the
			 * call to ZPost webservices was queued
			 */
		}

	}

	public void updateCustomer(ActionRequest request, ActionResponse response) {

		try {
			String customerId = "C12345";
			String customerLabel = "Groupe Zango";
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

			ZPostLocalServiceUtil.updateCustomer(customerId, customerLabel, serviceContext);

			/*
			 * If it reaches that point, then the call message has been queued and will be
			 * processed soon. If any errors raise from the call, then developer should
			 * catch them using the MessageListener
			 */

		} catch (SystemException | PortalException e) {
			/*
			 * If any errors raise here, that means that something went wrong before the
			 * call to ZPost webservices was queued
			 */
		}

	}

	public void updateAccountEmailAddresses(ActionRequest request, ActionResponse response) {

		try {
			String accountId = "A12345";
			List<String> emailAddresses = ListUtil.fromString("eric.coquelin@zango.pro,reda.zejli@zango.pro",
					StringPool.COMMA);
			Date fromDate = new Date();
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

			ZPostLocalServiceUtil.updateAccountEmailAddresses(accountId, emailAddresses, fromDate, serviceContext);

			/*
			 * If it reaches that point, then the call message has been queued and will be
			 * processed soon. If any errors raise from the call, then developer should
			 * catch them using the MessageListener
			 */

		} catch (SystemException | PortalException e) {
			/*
			 * If any errors raise here, that means that something went wrong before the
			 * call to ZPost webservices was queued
			 */
		}

	}
	
	public void updateCustomerEmailAddresses(ActionRequest request, ActionResponse response) {

		try {
			String customerId = "C12345";
			List<String> emailAddresses = ListUtil.fromString("eric.coquelin@zango.pro,reda.zejli@zango.pro",
					StringPool.COMMA);
			Date fromDate = new Date();
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

			ZPostLocalServiceUtil.updateCustomerEmailAddresses(customerId, emailAddresses, fromDate, serviceContext);

			/*
			 * If it reaches that point, then the call message has been queued and will be
			 * processed soon. If any errors raise from the call, then developer should
			 * catch them using the MessageListener
			 */

		} catch (SystemException | PortalException e) {
			/*
			 * If any errors raise here, that means that something went wrong before the
			 * call to ZPost webservices was queued
			 */
		}

	}

}
