
<%@ page import="com.bd.Bd_institution" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bd_institution.label', default: 'Institution')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-bd_institution" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-bd_institution" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="institution" title="${message(code: 'bd_institution.institution.label', default: 'Institution')}" />
						<g:sortableColumn property="library_id" title="${message(code: 'bd_institution.library_id.label', default: 'Library Id')}" />
						<g:sortableColumn property="catalog_code" title="${message(code: 'bd_institution.catalog_code.label', default: 'Catalog Code')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${bd_institutionInstanceList}" status="i" var="bd_institutionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="show" id="${bd_institutionInstance.id}">${fieldValue(bean: bd_institutionInstance, field: "institution")}</g:link></td>
						<td align="right">${fieldValue(bean: bd_institutionInstance, field: "library_id")}</td>
						<td align="center">${fieldValue(bean: bd_institutionInstance, field: "catalog_code")}</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${bd_institutionInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
