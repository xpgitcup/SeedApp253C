<%@ page import="cn.edu.cup.process.ProcessTask" %>



<div class="fieldcontain ${hasErrors(bean: processTaskInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="processTask.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="name" name="name.id" from="${cn.edu.cup.process.StandTask.list()}" optionKey="id" required="" value="${processTaskInstance?.name?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: processTaskInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="processTask.status.label" default="Status" />
		
	</label>
	<g:checkBox name="status" value="${processTaskInstance?.status}" />

</div>

<div class="fieldcontain ${hasErrors(bean: processTaskInstance, field: 'createdAt', 'error')} required">
	<label for="createdAt">
		<g:message code="processTask.createdAt.label" default="Created At" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="createdAt" precision="day"  value="${processTaskInstance?.createdAt}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: processTaskInstance, field: 'upTask', 'error')} ">
	<label for="upTask">
		<g:message code="processTask.upTask.label" default="Up Task" />
		
	</label>
	<g:select id="upTask" name="upTask.id" from="${cn.edu.cup.process.ProcessTask.list()}" optionKey="id" value="${processTaskInstance?.upTask?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: processTaskInstance, field: 'paramsString', 'error')} required">
	<label for="paramsString">
		<g:message code="processTask.paramsString.label" default="Params String" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="paramsString" required="" value="${processTaskInstance?.paramsString}"/>

</div>

