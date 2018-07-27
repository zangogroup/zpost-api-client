package com.zango.zpost.api.client;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.zango.zpost.api.constant.DeliveryModes;
import com.zango.zpost.api.constant.Vendors;
import com.zango.zpost.api.service.ZPostLocalServiceUtil;

/**
 * Portlet implementation class ZPostAPIClientPortlet
 */
public class ZPostAPIClientPortlet extends MVCPortlet {

	private Log _log = LogFactoryUtil.getLog(ZPostAPIClientPortlet.class);

	public void registerAccounts(ActionRequest request, ActionResponse response) {

		try {
			List<String> accountIds = ListUtil.fromString(ParamUtil.getString(request, "accountIds", "A1,A2,A3"),
					StringPool.COMMA);
			String deliveryMode = ParamUtil.getString(request, "deliveryMode", DeliveryModes.EMAIL);
			List<String> emailAddresses = ListUtil.fromString(
					ParamUtil.getString(request, "emailAddresses", "eric.coquelin@zango.pro,reda.zejli@zango.pro"),
					StringPool.COMMA);
			Date fromDate = new Date();
			String vendorId = ParamUtil.getString(request, "vendorId", Vendors.MOBILE);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

			_log.debug("accountIds=" + accountIds.size() + ", deliveryMode=" + deliveryMode + ", emailAddresses="
					+ emailAddresses.size() + ", fromDate=" + fromDate + ", vendorId=" + vendorId);

			ZPostLocalServiceUtil.registerAccounts(accountIds, deliveryMode, emailAddresses, fromDate, vendorId,
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

	public void updateAccountsEmailAddresses(ActionRequest request, ActionResponse response) {

		try {
			List<String> accountIds = ListUtil.fromString("A1,A2,A3", StringPool.COMMA);
			List<String> emailAddresses = ListUtil.fromString("eric.coquelin@zango.pro,reda.zejli@zango.pro",
					StringPool.COMMA);
			Date fromDate = new Date();
			String vendorId = Vendors.MOBILE;
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

			ZPostLocalServiceUtil.updateAccountsEmailAddresses(accountIds, emailAddresses, fromDate, vendorId,
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

	public void unregisterAccounts(ActionRequest request, ActionResponse response) {

		try {

			List<String> accountIds = ListUtil.fromString(ParamUtil.getString(request, "accountIds", "A1,A2,A3"),
					StringPool.COMMA);
			String deliveryMode = ParamUtil.getString(request, "deliveryMode", DeliveryModes.EMAIL);
			Date fromDate = new Date();
			String vendorId = ParamUtil.getString(request, "vendorId", Vendors.MOBILE);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

			_log.debug("accountIds=" + accountIds.size() + ", deliveryMode=" + deliveryMode + ", fromDate=" + fromDate
					+ ", vendorId=" + vendorId);

			ZPostLocalServiceUtil.unregisterAccountIds(accountIds, deliveryMode, fromDate, vendorId, serviceContext);

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
