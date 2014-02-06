
<%@ page import="com.bd.Bd_report_distribution" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bd_report_distribution.label', default: 'Email Distribution')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-bd_report_distribution" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-bd_report_distribution" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list bd_report_distribution">
			
				<g:if test="${bd_report_distributionInstance?.email_addr}">
				<li class="fieldcontain">
					<span id="email_addr-label" class="property-label"><g:message code="bd_report_distribution.email_addr.label" default="Email Address:" /></span>
					
						<span class="property-value" aria-labelledby="email_addr-label"><g:fieldValue bean="${bd_report_distributionInstance}" field="email_addr"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bd_report_distributionInstance?.institution}">
				<li class="fieldcontain">
					<span id="institution-label" class="property-label"><g:message code="bd_report_distribution.institution.label" default="Institution:" /></span>
					
						<span class="property-value" aria-labelledby="institution-label"><g:link controller="bd_institution" action="show" id="${bd_report_distributionInstance?.institution?.id}">${bd_report_distributionInstance?.institution?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${bd_report_distributionInstance?.library_id}">
				<li class="fieldcontain">
					<span id="library_id-label" class="property-label"><g:message code="bd_report_distribution.library_id.label" default="Library Id:" /></span>
					
						<span class="property-value" aria-labelledby="library_id-label"><g:fieldValue bean="${bd_report_distributionInstance}" field="library_id"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${bd_report_distributionInstance?.id}" />
					<g:link class="edit" action="edit" id="${bd_report_distributionInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
