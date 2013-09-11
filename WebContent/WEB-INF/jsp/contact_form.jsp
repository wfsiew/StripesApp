<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<s:form beanclass="stripesbook.action.ContactFormActionBean">
	<table class="form">
		<tr>
			<td>Email:</td>
			<td><s:text name="contact.email" /></td>
		</tr>
		<tr>
			<td>First name:</td>
			<td><s:text name="contact.firstName" /></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><s:text name="contact.lastName" /></td>
		</tr>
		<tr>
			<td>Phone number:</td>
			<td><s:text name="contact.phoneNumber" /></td>
		</tr>
		<tr>
			<td>Birth date:</td>
			<td><s:text name="contact.birthDate" /></td>
		</tr>
	</table>
</s:form>