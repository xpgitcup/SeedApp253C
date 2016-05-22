
<%@ page import="cn.edu.cup.userLibs.UserLibConfig" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'userLibConfig.label', default: 'UserLibConfig')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-userLibConfig" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-userLibConfig" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="description" title="${message(code: 'userLibConfig.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'userLibConfig.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="path" title="${message(code: 'userLibConfig.path.label', default: 'Path')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${userLibConfigInstanceList}" status="i" var="userLibConfigInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${userLibConfigInstance.id}">${fieldValue(bean: userLibConfigInstance, field: "description")}</g:link></td>
					
						<td>${fieldValue(bean: userLibConfigInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: userLibConfigInstance, field: "path")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${userLibConfigInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
