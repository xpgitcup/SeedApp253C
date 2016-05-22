
<%@ page import="cn.edu.cup.userLibs.UserLibInstance" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'userLibInstance.label', default: 'UserLibInstance')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-userLibInstance" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-userLibInstance" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list userLibInstance">
			
				<g:if test="${userLibInstanceInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="userLibInstance.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${userLibInstanceInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userLibInstanceInstance?.developer}">
				<li class="fieldcontain">
					<span id="developer-label" class="property-label"><g:message code="userLibInstance.developer.label" default="Developer" /></span>
					
						<span class="property-value" aria-labelledby="developer-label"><g:fieldValue bean="${userLibInstanceInstance}" field="developer"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userLibInstanceInstance?.libType}">
				<li class="fieldcontain">
					<span id="libType-label" class="property-label"><g:message code="userLibInstance.libType.label" default="Lib Type" /></span>
					
						<span class="property-value" aria-labelledby="libType-label"><g:link controller="userLibConfig" action="show" id="${userLibInstanceInstance?.libType?.id}">${userLibInstanceInstance?.libType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${userLibInstanceInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="userLibInstance.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${userLibInstanceInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userLibInstanceInstance?.uploadDate}">
				<li class="fieldcontain">
					<span id="uploadDate-label" class="property-label"><g:message code="userLibInstance.uploadDate.label" default="Upload Date" /></span>
					
						<span class="property-value" aria-labelledby="uploadDate-label"><g:formatDate date="${userLibInstanceInstance?.uploadDate}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:userLibInstanceInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${userLibInstanceInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
