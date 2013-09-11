<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
	title="Contact List">
	<s:layout-component name="body">
		<s:messages/>
		<table>
			<tr>
				<th>First name</th>
				<th>Last name</th>
				<th>Email</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="contact" items="${actionBean.contacts}">
				<tr>
					<td>${contact.firstName}</td>
					<td>${contact.lastName}</td>
					<td>${contact.email}</td>
					<td>
						<s:link beanclass="stripesbook.action.ContactListActionBean"
							event="view">
							<s:param name="contactId" value="${contact.id}" />
							View
						</s:link> |
					</td>
					<td>
						<s:link beanclass="stripesbook.action.ContactListActionBean"
							event="delete"
							onclick="return confirm('Delete ${contact}?')">
							<s:param name="contactId" value="${contact.id}" />
							Delete
						</s:link>
					</td>
				</tr>
			</c:forEach>
		</table>
	</s:layout-component>
</s:layout-render>