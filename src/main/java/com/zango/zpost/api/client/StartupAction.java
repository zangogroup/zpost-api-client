package com.zango.zpost.api.client;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.zango.zpost.api.constant.DestinationNames;

public class StartupAction extends SimpleAction {

	@Override
	public void run(String[] ids) throws ActionException {

		/*
		 * When the client module starts, it registers so that it can listen to
		 * responses provided asynchronously by ZPost. Please note that listeners can
		 * also be register using XML configuration and that you can have as many
		 * listeners as you want
		 */

		MessageListener messageListener = new ZPostMessageListener();
		
		MessageBusUtil.registerMessageListener(DestinationNames.ACCOUNT_REGISTER, messageListener);
		MessageBusUtil.registerMessageListener(DestinationNames.ACCOUNT_UPDATE, messageListener);
		MessageBusUtil.registerMessageListener(DestinationNames.ACCOUNT_UPDATE_EMAIL_ADDRESSES, messageListener);
		MessageBusUtil.registerMessageListener(DestinationNames.CUSTOMER_REGISTER, messageListener);
		MessageBusUtil.registerMessageListener(DestinationNames.CUSTOMER_UPDATE, messageListener);
		MessageBusUtil.registerMessageListener(DestinationNames.CUSTOMER_UPDATE_EMAIL_ADDRESSES, messageListener);
	}

}
