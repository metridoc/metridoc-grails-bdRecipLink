<%@ page import="com.bd.Bd_institution" %>



<div class="fieldcontain ${hasErrors(bean: bd_institutionInstance, field: 'institution', 'error')} required">
	<label for="institution">
		<g:message code="bd_institution.institution.label" default="Institution: " />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="institution" required="" value="${bd_institutionInstance?.institution}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bd_institutionInstance, field: 'library_id', 'error')} required">
	<label for="library_id">
		<g:message code="bd_institution.library_id.label" default="Library Id: " />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="library_id" required="" value="${fieldValue(bean: bd_institutionInstance, field: 'library_id')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bd_institutionInstance, field: 'catalog_code', 'error')} required">
	<label for="catalog_code">
		<g:message code="bd_institution.catalog_code.label" default="Catalog Code: " />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="catalog_code" required="" value="${bd_institutionInstance?.catalog_code}"/>
</div>


