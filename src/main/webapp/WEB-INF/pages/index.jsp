
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/pages/header.jsp" %>
<div id="wrapper">
    <div class="container-fluid bg-primary">
        <div style="padding: 20px 0"class="container">
            <div class="row">
                <div class="col-lg-2"><img style="width: 75px" src="resources/images/emblem.svg"></div>
                <div class="col-lg-10"><h2>Телефонный справочник Верховного Суда Российской Федерации</h2></div>
            </div>
        </div>
    </div>
    <div style="margin-top: 30px;" class="container">
        <div class="row">
            <div class="col-xs-12">
                <table id="contact-table" class="table table-responsive">
                    <thead>
                        <tr>
                            <th></th>
                            <th>Фио</th>
                            <th>Телефон</th>
                        </tr>
                    </thead>

                </table>
            </div>
        </div>
    </div>
    <div class="push"></div>
</div>    
<footer class="footer">
    <div class="container-fluid">
        <div class="container">
            <span class="text-muted">Заметили ошибку? <a href="#">Напишите нам.</a></span>
        </div>
      
    </div>
</footer>

           
        
 <%@ include file="/WEB-INF/pages/footer.jsp" %>