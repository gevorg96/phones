<%-- 
    Document   : index
    Created on : 23.03.2018, 9:27:17
    Author     : trunov_as
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/pages/admin/header.jsp" %>

<div id="appLdap">
    <c:if test="msg != null">
        <div class="message">
            <c:out value="${msg}" />
        </div>
    </c:if>
    
    <div class="row"><div class="col-lg-2"><a class="btn btn-primary" href="/phones/ldap/contact/add">Добавить контакт</a></div></div><br /><br />
    
    <table id="adminLdapTable" class="table table-responsive table-hover">
        <thead>
            <th>ФИО</th>
            <th>Телефон</th>
            <th>Почта</th>
            <th></th>
            <th></th>
        </thead>
        <tbody>
            <c:forEach items="${contacts}" var="contact">
                <tr>
                    <td>${contact.displayName}</td>
                    <td>${contact.telephoneNumber}</td>
                    <td>${contact.mail}</td>
                    <td><a href="contact/update/?cn=<c:out value="${contact.cn}" />">Редактировать</a></td>
                    <td><a href="contact/delete/<c:out value="${contact.cn}" />">Удалить</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>        

<%@ include file="/WEB-INF/pages/admin/footer.jsp" %>
<script type="text/javascript">
    var appLdap = new Vue({
        el: "#appLdap",
        data:{
        },
        methods: {
            delete: function (e){
                console.log(e.target);
            }
        }
    });
</script>