
<%@ page import="com.bd.Bd_institution" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bd_institution.label', default: 'Institution')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-bd_institution" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-bd_institution" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ul class="property-list bd_institution">

				<g:if test="${bd_institutionInstance?.institution}">
				<li class="fieldcontain">
					<span id="institution-label" class="property-label"><g:message code="bd_institution.institution.label" default="Institution: " /></span>
					
						<span class="property-value" aria-labelledby="institution-label"><g:fieldValue bean="${bd_institutionInstance}" field="institution"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bd_institutionInstance?.library_id}">
				<li class="fieldcontain">
					<span id="library_id-label" class="property-label"><g:message code="bd_institution.library_id.label" default="Library Id: " /></span>
					
						<span class="property-value" aria-labelledby="library_id-label"><g:fieldValue bean="${bd_institutionInstance}" field="library_id"/></span>
					
				</li>
				</g:if>

				<g:if test="${bd_institutionInstance?.catalog_code}">
				<li class="fieldcontain">
					<span id="catalog_code-label" class="property-label"><g:message code="bd_institution.catalog_code.label" default="Catalog Code: " /></span>

						<span class="property-value" aria-labelledby="catalog_code-label"><g:fieldValue bean="${bd_institutionInstance}" field="catalog_code"/></span>

				</li>
				</g:if>

			</ul>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${bd_institutionInstance?.id}" />
					<g:link class="edit" action="edit" id="${bd_institutionInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
