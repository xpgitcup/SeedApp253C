<%@ page import="cn.edu.cup.process.StandTask" %>



<div class="fieldcontain ${hasErrors(bean: standTaskInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="standTask.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${standTaskInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: standTaskInstance, field: 'paramsDescription', 'error')} required">
	<label for="paramsDescription">
		<g:message code="standTask.paramsDescription.label" default="Params Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="paramsDescription" required="" value="${standTaskInstance?.paramsDescription}"/>

</div>

