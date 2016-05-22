
<%@ page import="cn.edu.cup.test.TestDataA" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'testDataA.label', default: 'TestDataA')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-testDataA" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-testDataA" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="dataa" title="${message(code: 'testDataA.dataa.label', default: 'Dataa')}" />
					
						<g:sortableColumn property="datab" title="${message(code: 'testDataA.datab.label', default: 'Datab')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${testDataAInstanceList}" status="i" var="testDataAInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${testDataAInstance.id}">${fieldValue(bean: testDataAInstance, field: "dataa")}</g:link></td>
					
						<td>${fieldValue(bean: testDataAInstance, field: "datab")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${testDataAInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
