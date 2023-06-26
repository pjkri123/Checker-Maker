<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Home Page</title>
    <style>
        table, table th, table td {
            border-collapse: collapse;
            border: 1px solid #ddd;
              padding: 8px;
        }
    </style>
</head>
<body>
<h3>Home Page</h3>
    <form:form>
        <a href="<c:url value='/checker'/>">Checker</a><br>
        <a href="<c:url value='/maker'/>">Maker</a>
    </form:form>
</body>
</html>
