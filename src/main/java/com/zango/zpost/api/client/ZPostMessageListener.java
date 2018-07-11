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

public class ZPostMessageListener implements MessageListener {

	private Log _log = LogFactoryUtil.getLog(ZPostMessageListener.class);

	@Override
	public void receive(Message message) throws MessageListenerException {

		if (_log.isDebugEnabled()) {
			_log.debug("just received a new message: " + message);
		}

		// from that value, developer can identify where the original request came from
		String destinationName = message.getDestinationName();

		if (DestinationNames.ACCOUNTS_REGISTER_FEEDBACK.equals(destinationName)) {

			// this is the response message following a call for account registration

			// same parameters as those sent along with the call are available
			String accountId = message.getString("accountId"); // "A12345"
			String accountLabel = message.getString("accountLabel"); // "Zango (Maurice) Ltée"
			String customerId = message.getString("customerId"); // "C12345"
			String customerLabel = message.getString("customerLabel"); // "Groupe Zango"
			List<String> emailAddresses = (List) message.get("emailAddresses"); // "eric.coquelin@zango.pro,reda.zejli@zango.pro"
			Date fromDate = (Date) message.get("fromDate"); // new Date()
			String vendorId = message.getString("vendorId"); // "MT/mobile"
			ServiceContext serviceContext = (ServiceContext) message.get("serviceContext"); // ServiceContextFactory.getInstance(request)

		}

		String error = message.getString("error");
		if (Validator.isNotNull(error)) {
			// there is an error, developer must handle it
		} else {
			// will provide with the unique identifier of the activated ebilling rule
			String notificationRuleCode = message.getString("notificationRuleCode");
		}
	}
}
