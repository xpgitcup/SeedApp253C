<%@ page import="cn.edu.cup.userLibs.UserMethodInstance" %>



<div class="fieldcontain ${hasErrors(bean: userMethodInstanceInstance, field: 'clazz', 'error')} required">
	<label for="clazz">
		<g:message code="userMethodInstance.clazz.label" default="Clazz" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="clazz" name="clazz.id" from="${cn.edu.cup.userLibs.UserClassInstance.list()}" optionKey="id" required="" value="${userMethodInstanceInstance?.clazz?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userMethodInstanceInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="userMethodInstance.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${userMethodInstanceInstance?.name}"/>

</div>

