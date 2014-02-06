<%@ page import="com.bd.Bd_report_distribution" %>



<div class="fieldcontain ${hasErrors(bean: bd_report_distributionInstance, field: 'email_addr', 'error')} required">
	<label for="email_addr">
		<g:message code="bd_report_distribution.email_addr.label" default="Email Address:" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email_addr" required="" value="${bd_report_distributionInstance?.email_addr}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bd_report_distributionInstance, field: 'institution', 'error')} required">
	<label for="institution">
		<g:message code="bd_report_distribution.institution.label" default="Institution" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="institution" name="institution.id" from="${com.bd.Bd_institution.list()}" optionKey="id" required="" value="${bd_report_distributionInstance?.institution?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bd_report_distributionInstance, field: 'library_id', 'error')} required">
	<label for="library_id">
		<g:message code="bd_report_distribution.library_id.label" default="Library Id:" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="library_id" required="" value="${bd_report_distributionInstance?.library_id}"/>
</div>

