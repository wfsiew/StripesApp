<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<s:layout-definition>
	<!DOCTYPE html>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>${title}</title>
	<link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css" />
	</head>
	<body>
		<div id="header">
			<span class="title">${title}</span>
		</div>
		<div id="body">
			<s:layout-component name="body" />
		</div>
	</body>
	</html>
</s:layout-definition>