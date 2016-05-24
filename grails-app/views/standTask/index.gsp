
<%@ page import="cn.edu.cup.process.StandTask" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'standTask.label', default: 'StandTask')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-standTask" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-standTask" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'standTask.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="paramsDescription" title="${message(code: 'standTask.paramsDescription.label', default: 'Params Description')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${standTaskInstanceList}" status="i" var="standTaskInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${standTaskInstance.id}">${fieldValue(bean: standTaskInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: standTaskInstance, field: "paramsDescription")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${standTaskInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
