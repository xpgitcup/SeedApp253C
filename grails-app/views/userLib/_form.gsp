<%@ page import="cn.edu.cup.userLibs.UserLibInstance" %>



<div class="fieldcontain ${hasErrors(bean: userLibInstanceInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="userLibInstance.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${userLibInstanceInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userLibInstanceInstance, field: 'developer', 'error')} required">
	<label for="developer">
		<g:message code="userLibInstance.developer.label" default="Developer" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="developer" required="" value="${userLibInstanceInstance?.developer}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userLibInstanceInstance, field: 'libType', 'error')} required">
	<label for="libType">
		<g:message code="userLibInstance.libType.label" default="Lib Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="libType" name="libType.id" from="${cn.edu.cup.userLibs.UserLibConfig.list()}" optionKey="id" required="" value="${userLibInstanceInstance?.libType?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userLibInstanceInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="userLibInstance.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${userLibInstanceInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userLibInstanceInstance, field: 'uploadDate', 'error')} required">
	<label for="uploadDate">
		<g:message code="userLibInstance.uploadDate.label" default="Upload Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="uploadDate" precision="day"  value="${userLibInstanceInstance?.uploadDate}"  />

</div>

