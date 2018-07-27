<%@ include file="../init.jsp" %>

<jsp:useBean scope="request" id="vendors" class="com.zango.zpost.api.constant.Vendors"/>
<jsp:useBean scope="request" id="deliveryModes" class="com.zango.zpost.api.constant.DeliveryModes"/>

<liferay-portlet:actionURL name="registerAccounts" var="registerAccountsURL">
</liferay-portlet:actionURL>

<liferay-ui:header title="Register" />
<aui:form action="${registerAccountsURL}" name="registerForm">
	<aui:input name="accountIds" placeholder="A1,A2,A3,A4"/>
	<aui:input name="emailAddresses" placeholder="eric.coquelin@zango.pro,kamal.doukali@zango.pro"/>
	<aui:select name="vendorId">
		<c:forEach var="vendor" items="${vendors.names}" >
			<aui:option name="${vendor}" label="${vendor}"/>
		</c:forEach>
	</aui:select>
	<aui:select name="deliveryMode">
		<c:forEach var="deliveryMode" items="${deliveryModes.names}" >
			<aui:option name="${deliveryMode}" label="${deliveryMode}"/>
		</c:forEach>
	</aui:select>
	<aui:button type="submit"></aui:button>
</aui:form>

<liferay-portlet:actionURL name="unregisterAccounts" var="unregisterAccountsURL">
</liferay-portlet:actionURL>

<liferay-ui:header title="Unregister" />
<aui:form action="${unregisterAccountsURL}" name="unregisterForm">
	<aui:input name="accountIds" placeholder="A1,A2,A3,A4"/>
	<aui:select name="vendorId">
		<c:forEach var="vendor" items="${vendors.names}" >
			<aui:option name="${vendor}" label="${vendor}"/>
		</c:forEach>
	</aui:select>
	<aui:select name="deliveryMode">
		<c:forEach var="deliveryMode" items="${deliveryModes.names}" >
			<aui:option name="${deliveryMode}" label="${deliveryMode}"/>
		</c:forEach>
	</aui:select>
	<aui:button type="submit"></aui:button>
</aui:form>

