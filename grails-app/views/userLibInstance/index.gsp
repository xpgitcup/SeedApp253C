
<%@ page import="cn.edu.cup.userLibs.UserLibInstance" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'userLibInstance.label', default: 'UserLibInstance')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-userLibInstance" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-userLibInstance" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="description" title="${message(code: 'userLibInstance.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="developer" title="${message(code: 'userLibInstance.developer.label', default: 'Developer')}" />
					
						<th><g:message code="userLibInstance.libType.label" default="Lib Type" /></th>
					
						<g:sortableColumn property="name" title="${message(code: 'userLibInstance.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="uploadDate" title="${message(code: 'userLibInstance.uploadDate.label', default: 'Upload Date')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${userLibInstanceInstanceList}" status="i" var="userLibInstanceInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${userLibInstanceInstance.id}">${fieldValue(bean: userLibInstanceInstance, field: "description")}</g:link></td>
					
						<td>${fieldValue(bean: userLibInstanceInstance, field: "developer")}</td>
					
						<td>${fieldValue(bean: userLibInstanceInstance, field: "libType")}</td>
					
						<td>${fieldValue(bean: userLibInstanceInstance, field: "name")}</td>
					
						<td><g:formatDate date="${userLibInstanceInstance.uploadDate}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${userLibInstanceInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
