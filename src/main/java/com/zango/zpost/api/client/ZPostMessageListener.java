package com.zango.zpost.api.client;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.zango.zpost.api.constant.DestinationNames;
import com.zango.zpost.api.util.MessageUtil;

public class ZPostMessageListener implements MessageListener {

	private Log _log = LogFactoryUtil.getLog(ZPostMessageListener.class);

	@Override
	public void receive(Message message) throws MessageListenerException {

		if (_log.isDebugEnabled()) {
			_log.debug("just received a new message: " + message);
		}

		// from that value, developer can identify where the original request came from
		String destinationName = message.getDestinationName();

		boolean isSuccessful = MessageUtil.isSuccessful(message);
		if (isSuccessful) {
			/*
			 * it works
			 */
		} else {
			/*
			 * Something went wrong
			 */
			Exception error = MessageUtil.getError(message);
			if (error != null) {
				_log.error("This is the error received from ZPost", error);
			}
		}

		switch (destinationName) {
		case DestinationNames.ACCOUNTS_REGISTER_FEEDBACK:
			/*
			 * Do whatever you need if registration fails
			 */
			break;
		case DestinationNames.ACCOUNTS_UNREGISTER_FEEDBACK:
			/*
			 * Do whatever you need if unregistration fails
			 */
			break;
		case DestinationNames.ACCOUNTS_UPDATE_EMAIL_ADDRESSES_FEEDBACK:
			/*
			 * Do whatever you need if updating email addresses fails
			 */
			break;
		}

	}
}
