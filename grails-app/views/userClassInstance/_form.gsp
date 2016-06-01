<%@ page import="cn.edu.cup.userLibs.UserClassInstance" %>



<div class="fieldcontain ${hasErrors(bean: userClassInstanceInstance, field: 'lib', 'error')} required">
	<label for="lib">
		<g:message code="userClassInstance.lib.label" default="Lib" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="lib" name="lib.id" from="${cn.edu.cup.userLibs.UserLibInstance.list()}" optionKey="id" required="" value="${userClassInstanceInstance?.lib?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userClassInstanceInstance, field: 'methods', 'error')} ">
	<label for="methods">
		<g:message code="userClassInstance.methods.label" default="Methods" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userClassInstanceInstance?.methods?}" var="m">
    <li><g:link controller="userMethodInstance" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="userMethodInstance" action="create" params="['userClassInstance.id': userClassInstanceInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'userMethodInstance.label', default: 'UserMethodInstance')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: userClassInstanceInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="userClassInstance.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${userClassInstanceInstance?.name}"/>

</div>

