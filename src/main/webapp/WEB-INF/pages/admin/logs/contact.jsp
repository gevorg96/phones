<%-- 
    Document   : add
    Created on : 22.03.2017, 13:43:43
    Author     : trunov_as
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/pages/admin/header.jsp" %>
<style type="text/css">
    .editRoom{
        border:none;
    }
</style>


<div id="contactLog" class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
            <h2>История изменений контакта ${logs[0].contact}</h2>
            <ol>
                <c:forEach items="${logs}" var="log">
                    <li><c:out value="${log.date}" /> <c:out value="${log.log}" /></li>
                </c:forEach>
            </ol>
        </div>
    </div>



<%@ include file="/WEB-INF/pages/admin/footer.jsp" %>
