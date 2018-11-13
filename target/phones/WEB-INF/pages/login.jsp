
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/pages/header.jsp" %>
<div id="wrapper">
    <div class="container">

      <form class="form-signin">
        <h2 class="form-signin-heading">Авторизация</h2>
        <label for="name" class="sr-only">Пользователь</label>
        <input type="text" id="name" class="form-control" placeholder="Имя пользователя" required="" autofocus="">
        <label for="password" class="sr-only">Пароль</label>
        <input type="password" id="password" class="form-control" placeholder="Пароль" required="">
        <!--div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button-->
      </form>

    </div>

           
        
 <%@ include file="/WEB-INF/pages/footer.jsp" %>