<%-- 
    Document   : contact
    Created on : 17.04.2017, 14:58:38
    Author     : trunov_as
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/pages/admin/header.jsp" %>
<!-- /.row -->
    


    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Контакты <c:out value="${add}" />
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
                    <div class="row">
                        <div class="col-sm-6">
                            <!--a href="<c:url value="contact/add" />">Добавить пользователя</a-->
                        </div>
                        <div class="text-right col-sm-6">
                            <form class="form-inline" method="GET" action="cotnact">
                                <input class="form-control" name="search" type="text" value="${search}" placeholder="Строка поиска" />
                                <input type="hidden" name="page" value="1">
                                <input class="btn" type="submit" value="Поиск" />
                                <input class="btn" type="reset" value="Очистить" />
                            </form>
                        </div>
                    </div>
                    <br />
                    <c:if test="${empty persons}">
                        Справочник контактов пустой
                    </c:if>
                    <c:if test="${not empty contacts}">  
                            <table width="100%" class="table table-striped table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Контакт</th>
                                    <th>Тип</th>
                                    <th>Пользователь</th>
                                    <th>Редактировать</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${contacts}" var="contact">
                                    <tr>
                                        <td><c:out value="${contact.id}"/></td>
                                        <td>
                                            <c:out value="${contact.contact}"/> <br />
                                        </td>
                                        <td><c:out value="${contact.type.name}"/></td>
                                        <td><c:out value="${contact.person.surname}"/></td>
                                        <td class="center"><a href="<c:url value="/contact/update" />?id=<c:out value='${contact.id}'/>">Редактировать</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                    <!-- /.table-responsive -->
                    <c:if test="${maxPage > 0}">
                    <nav aria-label="Page navigation">
                        <ul class="pagination text-center">
                          <li>
                                <a href="<c:url value="/contact" />?page=<c:choose><c:when test="${curentPage > 1}"><c:out value="${curentPage-1}" /></c:when><c:otherwise><c:out value="${curentPage}" /></c:otherwise></c:choose><c:if test="${search != null}">&search=${search}</c:if>" aria-label="Next">
                                <span aria-hidden="true">&laquo;</span>
                              </a>
                            </li>
                            
                            <c:forEach var="i" begin="1" end="${maxPage}">
                            
                                <li class="<c:if test="${i == curentPage}"><c:out value="active" /></c:if>"><a href="<c:url value="/person" />?page=${i}<c:if test="${search != null}">&search=${search}</c:if>">${i}</a></li>
                           
                          </c:forEach>
                             <li>
                              <a href="<c:url value="/contact" />?page=<c:choose><c:when test="${curentPage+1>maxPage}"><c:out value="${curentPage}" /></c:when><c:otherwise><c:out value="${curentPage+1}" /></c:otherwise></c:choose><c:if test="${search != null}">&search=${search}</c:if>" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                              </a>
                            </li>
                        </ul>
                      </nav>
                    </c:if>
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
                <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->

<%@ include file="/WEB-INF/pages/admin/footer.jsp" %>