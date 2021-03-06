<%-- 
    Document   : organization
    Created on : 17.04.2017, 13:41:35
    Author     : trunov_as
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/pages/admin/header.jsp" %>
<div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Организации <c:out value="${add}" />
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
                    <a href="<c:url value="organization/add" />">Добавить организацию</a>
                    <c:if test="${empty organizations}">
                        Справочник организаций пустой
                    </c:if>
                    <c:if test="${not empty organizations}">  
                            <table width="100%" id="organizationsTable" class="table table-striped table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>Наименование</th>
                                    <th>Родитель</th>
                                    <th>Регион</th>
                                    
                                    <th>Тип</th>
                                    <th>Редактировать</th>
                                    <th>Удалить</th>
                                </tr>
                            </thead>
                            
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