<%@ page import="cn.edu.cup.test.TestDataA" %>



<div class="fieldcontain ${hasErrors(bean: testDataAInstance, field: 'dataa', 'error')} required">
	<label for="dataa">
		<g:message code="testDataA.dataa.label" default="Dataa" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="dataa" value="${fieldValue(bean: testDataAInstance, field: 'dataa')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: testDataAInstance, field: 'datab', 'error')} required">
	<label for="datab">
		<g:message code="testDataA.datab.label" default="Datab" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="datab" value="${fieldValue(bean: testDataAInstance, field: 'datab')}" required=""/>

</div>

