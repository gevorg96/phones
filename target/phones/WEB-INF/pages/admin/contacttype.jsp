<%-- 
    Document   : contacttype
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
                    Типы контактов <c:out value="${add}" />
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
                    <a href="<c:url value="contacttype/add" />">Добавить тип контакта</a>
                    <c:if test="${empty types}">
                        Справочник Тип контактов пустой
                    </c:if>
                    <c:if test="${not empty types}">  
                            <table width="100%" class="table table-striped table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Наименование</th>
                                    <th>Редактировать</th>
                                    <th>Удалить</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${types}" var="type">
                                    <tr>
                                        <td><c:out value="${type.id}"/></td>
                                        <td><c:out value="${type.name}"/></td>
                                        <td class="center"><a href="<c:url value="/contacttype/update" />?id=<c:out value='${type.id}'/>">Редактировать</a></td>
                                        <td class="center"><a href="<c:url value="/contacttype/delete" />?id=<c:out value='${type.id}'/>">Удалить</a></td>
                                    </tr>
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