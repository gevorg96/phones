<%-- 
    Document   : index.jsp
    Created on : 21.03.2017, 18:16:16
    Author     : trunov_as
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/pages/admin/header.jsp" %>


    <!-- /.row -->
    <div class="container-fluid">
        <table width="100%" id="adminContactTable" class="table table-responsive table-hover">
            <thead>
                <tr>
                    <th>Фио</th>
                    <th>Телефон</th>
                    <th>Примечание</th>
                    <th>Группа</th>
                    <th>Редактировать</th>
                </tr>
            </thead>
            
        </table>
       
    </div>
    <!-- /.row -->

<%@ include file="/WEB-INF/pages/admin/footer.jsp" %>