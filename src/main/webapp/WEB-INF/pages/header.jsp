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
    
    <title>Телефонный справочник</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
     <link href="<c:url value="/resources/vendor/datatables/css/dataTables.bootstrap.min.css" />" rel="stylesheet">
   
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
    <style>
        html, body {
        height: 100%;
        margin: 0;
      }
      #wrapper {
        min-height: 100%;
        margin-bottom: -60px;
      }
      .footer, .push{
          height: 60px;
      }
      .footer {
            line-height: 60px;
            background-color: #f5f5f5;
      }
    </style>
</head>

<body>

 

        