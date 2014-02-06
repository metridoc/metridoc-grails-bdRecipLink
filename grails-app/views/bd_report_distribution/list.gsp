
<%@ page import="com.bd.Bd_report_distribution" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bd_report_distribution.label', default: 'Email Distribution')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-bd_report_distribution" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-bd_report_distribution" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="email_addr" title="${message(code: 'bd_report_distribution.email_addr.label', default: 'Email Address')}" />
					
						<!--g:sortableColumn property="library_id" title="${message(code: 'bd_report_distribution.library_id.label', default: 'Library Id')}" /-->
					
						<g:sortableColumn property="institution" title="${message(code: 'ezb_reportDistribution.institution.label', default: 'Institution')}" />
						<!--th><g:message code="bd_report_distribution.institution.label" default="Institution" /></th-->
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${bd_report_distributionInstanceList}" status="i" var="bd_report_distributionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${bd_report_distributionInstance.id}">${fieldValue(bean: bd_report_distributionInstance, field: "email_addr")}</g:link></td>
					
						<!--td align="right">${fieldValue(bean: bd_report_distributionInstance, field: "library_id")}</td-->
					
						<td>${fieldValue(bean: bd_report_distributionInstance, field: "institution")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${bd_report_distributionInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
