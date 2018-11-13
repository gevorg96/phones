<%-- 
    Document   : sync
    Created on : 21.03.2017, 17:21:19
    Author     : trunov_as
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/pages/admin/header.jsp" %>
<!-- /.row -->
    


    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Синхронизация
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    Синхронизация с базой инвернатризации<br />
                    Последняя синхронизация: <%=new Date()%><br />
                    Обновлено 10 записей<br />
                    <a href="/">Посмотреть детальную информацию последней синхронизации</a><br />
                    
                    <a class="btn btn-default" href="/">Выполнить синхронизацию вручную</a>
                    <hr />
                    
                    Синхронизация с кадровой системой<br />
                    Добавлено 3 сотрудника<br />
                     <a href="/">Посмотреть детальную информацию последней синхронизации</a><br />
                    Последняя синхронизация: <%=new Date()%><br />
                    <a class="btn btn-default" href="/">Выполнить синхронизацию вручную</a>
                    <hr />
                    
                    Синхронизация с Active Directory<br />
                    Внесено 18 изменений в Active Directory<br />
                    <a href="/">Посмотреть детальную информацию последней синхронизации</a><br />
                    Последняя синхронизация: <%=new Date()%><br />
                    <a class="btn btn-default" href="/">Выполнить синхронизацию вручную</a>
                    
                    
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
                <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->

<%@ include file="/WEB-INF/pages/admin/footer.jsp" %>