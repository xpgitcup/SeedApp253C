
<%@ page import="cn.edu.cup.process.ProcessTask" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'processTask.label', default: 'ProcessTask')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-processTask" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-processTask" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list processTask">
			
				<g:if test="${processTaskInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="processTask.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:link controller="standTask" action="show" id="${processTaskInstance?.name?.id}">${processTaskInstance?.name?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${processTaskInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="processTask.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:formatBoolean boolean="${processTaskInstance?.status}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${processTaskInstance?.createdAt}">
				<li class="fieldcontain">
					<span id="createdAt-label" class="property-label"><g:message code="processTask.createdAt.label" default="Created At" /></span>
					
						<span class="property-value" aria-labelledby="createdAt-label"><g:formatDate date="${processTaskInstance?.createdAt}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${processTaskInstance?.upTask}">
				<li class="fieldcontain">
					<span id="upTask-label" class="property-label"><g:message code="processTask.upTask.label" default="Up Task" /></span>
					
						<span class="property-value" aria-labelledby="upTask-label"><g:link controller="processTask" action="show" id="${processTaskInstance?.upTask?.id}">${processTaskInstance?.upTask?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${processTaskInstance?.paramsString}">
				<li class="fieldcontain">
					<span id="paramsString-label" class="property-label"><g:message code="processTask.paramsString.label" default="Params String" /></span>
					
						<span class="property-value" aria-labelledby="paramsString-label"><g:fieldValue bean="${processTaskInstance}" field="paramsString"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:processTaskInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${processTaskInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
