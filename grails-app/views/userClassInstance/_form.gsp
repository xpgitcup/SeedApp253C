<%@ page import="cn.edu.cup.userLibs.UserClassInstance" %>



<div class="fieldcontain ${hasErrors(bean: userClassInstanceInstance, field: 'lib', 'error')} required">
	<label for="lib">
		<g:message code="userClassInstance.lib.label" default="Lib" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="lib" name="lib.id" from="${cn.edu.cup.userLibs.UserLibInstance.list()}" optionKey="id" required="" value="${userClassInstanceInstance?.lib?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userClassInstanceInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="userClassInstance.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${userClassInstanceInstance?.name}"/>

</div>

