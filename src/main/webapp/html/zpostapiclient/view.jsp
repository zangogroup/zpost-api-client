<%@ include file="../init.jsp" %>

<jsp:useBean scope="request" id="vendors" class="com.zango.zpost.api.constant.Vendors"/>
<jsp:useBean scope="request" id="deliveryModes" class="com.zango.zpost.api.constant.DeliveryModes"/>

<liferay-portlet:actionURL name="registerAccounts" var="registerAccountsURL">
</liferay-portlet:actionURL>

<aui:form action="${registerAccountsURL}">
	<aui:input name="accountIds" value="A1,A2,A3"/>
	<aui:input name="emailAddresses" value="eric.coquelin@zango.pro,kamal.doukali@zango.pro"/>
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

