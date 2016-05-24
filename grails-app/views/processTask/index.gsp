
<%@ page import="cn.edu.cup.process.ProcessTask" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'processTask.label', default: 'ProcessTask')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-processTask" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-processTask" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="processTask.name.label" default="Name" /></th>
					
						<g:sortableColumn property="status" title="${message(code: 'processTask.status.label', default: 'Status')}" />
					
						<g:sortableColumn property="createdAt" title="${message(code: 'processTask.createdAt.label', default: 'Created At')}" />
					
						<th><g:message code="processTask.upTask.label" default="Up Task" /></th>
					
						<g:sortableColumn property="paramsString" title="${message(code: 'processTask.paramsString.label', default: 'Params String')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${processTaskInstanceList}" status="i" var="processTaskInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${processTaskInstance.id}">${fieldValue(bean: processTaskInstance, field: "name")}</g:link></td>
					
						<td><g:formatBoolean boolean="${processTaskInstance.status}" /></td>
					
						<td><g:formatDate date="${processTaskInstance.createdAt}" /></td>
					
						<td>${fieldValue(bean: processTaskInstance, field: "upTask")}</td>
					
						<td>${fieldValue(bean: processTaskInstance, field: "paramsString")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${processTaskInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
