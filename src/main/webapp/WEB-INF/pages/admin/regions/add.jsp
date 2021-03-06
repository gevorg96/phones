<%-- 
    Document   : add
    Created on : 22.03.2017, 13:43:43
    Author     : trunov_as
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/pages/admin/header.jsp" %>
<div class="container">
    <form:form method="POST" modelAttribute="regionForm" action="/phones/regions/addoredit">
        <form:hidden path="id" />
        <spring:bind path="name">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <div class="row">
                <label class="col-sm-1 control-label">Регион:</label>
                <div class="col-sm-4">
                    <form:input path="name" type="text" class="form-control"
                     id="name" placeholder="" />
                    <form:errors path="name" class="control-label" />
                </div>
            </div>  
        </div>
        <div class="form-group">
            <div class="row">
                <div class="col-sm-offset-1 col-sm-4">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </div>
            
          </div> 
      </spring:bind>
    </form:form>
       
    </div>



<%@ include file="/WEB-INF/pages/admin/footer.jsp" %>