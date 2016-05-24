<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'userLibInstance.label', default: 'UserLibInstance')}" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>上传用户类库</title>
    </head>
    <body>
        <div id="list-userLibInstance" class="content scaffold-list" role="main">
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:uploadForm controller="userLib" action="doUploadUserLib">
                <fieldset class="form">
                    <g:render template="form"/>
                    <div class="fieldcontain ${hasErrors(bean: userLibInstanceInstance, field: 'developer', 'error')} required">
                        <label for="developer">
                            请选择一个类库文件
                            <span class="required-indicator">*</span>
                        </label>
                        <span>
                            <input class="fieldcontain" type="file" name="uploadedFile" />
                        </span>
                        <g:submitButton name="upload" value="导入"/>
                    </div>                    
                </fieldset>
            </g:uploadForm>
        </div>
    </body>
</html>
