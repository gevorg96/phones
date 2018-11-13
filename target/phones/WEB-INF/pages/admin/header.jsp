<%-- 
    Document   : header
    Created on : 22.03.2017, 11:39:34
    Author     : trunov_as
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>Админка телефонного справочника</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
   
    <!-- MetisMenu CSS -->
    <link href="<c:url value="/resources/vendor/metisMenu/metisMenu.min.css" />" rel="stylesheet">
    
    <!--DataTables-->
    
    <link href="<c:url value="/resources/vendor/datatables/css/dataTables.bootstrap.min.css" />" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/sb-admin-2.min.css" />" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <!--link href="<c:url value="/resources/vendor/morrisjs/morris.css" />" rel="stylesheet"-->

    <!-- JQuery UI -->
    <link href="<c:url value="/resources/vendor/jquery/jquery-ui.css" />" rel="stylesheet">
    
    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">
    
    <link href="<c:url value="/resources/vendor/pretty-checkbox/pretty-checkbox.min.css" />" rel="stylesheet" type="text/css"/>
   
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
    
       
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<c:url value="/admin" />">Панель администратора "Телефонный справочник Верховного Суда Российской Федерации"</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>Лог телефонного справочника</strong>
                                    <span class="pull-right text-muted">
                                        <em>Сегодня</em>
                                    </span>
                                </div>
                                <div>Проведена синхронизация справочника с кадровой системой</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>Лог телефонного справочника</strong>
                                    <span class="pull-right text-muted">
                                        <em>Сегодня</em>
                                    </span>
                                </div>
                                <div>Внесены изменения в Active Directory</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>Лог телефонного справочника</strong>
                                    <span class="pull-right text-muted">
                                        <em>Сегодня</em>
                                    </span>
                                </div>
                                <div>Именен основной номер телефона у Трунов А.С.</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Читать все сообщения</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> Профиль пользователя</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Настройки</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Выйти</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="<c:url value="/admin" />"><i class="fa fa-dashboard fa-fw"></i> Главная</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> Справочники<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<c:url value="/regions" />">Регионы</a>
                                </li>
                                <li>
                                    <a href="<c:url value="/contacttype" />">Типы контактов</a>
                                </li>
                                <li>
                                    <a href="<c:url value="/organizationtype" />">Организаций</a>
                                </li>
                                <li>
                                    <a href="<c:url value="/organization" />">Подразделения</a>
                                </li>
                                
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> Active Directory local.vsrf.ru<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>    
                                    <a href="<c:url value="/ldap" />"><i class="fa fa-table fa-fw"></i>Телефоны учетных записей</a>
                                </li>
                                <li>
                                    <a href="<c:url value="/ldap/contact" />"><i class="fa fa-table fa-fw"></i>Контейнер контактов AD</a>
                                </li>
                            </ul>
                        </li>
                          <li>
                            <a href="<c:url value="/pool" />"><i class="fa fa-list fa-fw"></i> Пул номеров</a>
                        </li>
                        <li>
                            <a href="<c:url value="/sync" />"><i class="fa fa-gear fa-fw"></i> Синхронизация</a>
                        </li>
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"></h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>