<%-- 
    Document   : ldap
    Created on : 21.03.2017, 17:21:19
    Author     : trunov_as
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/pages/admin/header.jsp" %>
<!-- /.row -->
    


    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Каталог Windows <c:out value="${add}" />
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <c:if test="${not empty msg}">
                        <div class="alert alert-${css} alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert"
                                    aria-label="Close">
                                    <span aria-hidden="true">×</span>
                            </button>
                            <strong>${msg}</strong>
                        </div>
                    </c:if>
                    
                    
                    <c:if test="${empty persons}">
                        Каталог Windows пустой
                    </c:if>
                    <c:if test="${not empty persons}">  
                            <table id="ldapTable" width="100%" class="table table-striped table-bordered table-hover">
                            <thead>
                                <tr>
                                    
                                    <th>ФИО</th>
                                    <th>cn</th>
                                    <th>ou</th>
                                    <th>телефон</th>
                                    <th>Редактировать</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${persons}" var="person">
                                    <c:if test="${person.ou != 'apps'}">
                                    <tr>
                                        <td><c:out value="${person.name}"/></td>
                                        <td><c:out value="cn=${person.cn}" /></td>
                                        <td><c:out value="cn=${person.ou}" /></td>
                                        <td><c:out value="${person.telephone}"/></td>
                                        <td class="center"><a href="<c:url value="/ldap/update" />?cn=<c:out value='${person.cn}'/>&ou=<c:out value='${person.ou}'/>&telephone=<c:out value='${person.ou}'/>">Редактировать</a></td>
                                    </tr>
                                    </c:if>
                                </c:forEach>


                            </tbody>
                        </table>
                    </c:if>
                    <!-- /.table-responsive -->
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
                <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->

<%@ include file="/WEB-INF/pages/admin/footer.jsp" %>