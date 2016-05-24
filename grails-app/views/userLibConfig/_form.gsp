<%@ page import="cn.edu.cup.userLibs.UserLibConfig" %>



<div class="fieldcontain ${hasErrors(bean: userLibConfigInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="userLibConfig.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${userLibConfigInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userLibConfigInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="userLibConfig.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${userLibConfigInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userLibConfigInstance, field: 'path', 'error')} required">
	<label for="path">
		<g:message code="userLibConfig.path.label" default="Path" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="path" required="" value="${userLibConfigInstance?.path}"/>

</div>

