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

    <h4>Hello Maker</h4>
    <form>
        <input type="submit" value="Add New" formAction="customer" method="POST"/></td>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <br>
        <h3>Customer List</h3>
        <table>
            <tr>
                <th>customerId</th>
                <th>customerCode</th>
                <th>customerName</th>
                <th>customerAddress1</th>
                <th>customerAddress2</th>
                <th>customerPinCode</th>
                <th>emailAddress</th>
                <th>contactNumber</th>
                <th>primaryContactPerson</th>
                <th>recordStatus</th>
                <th>activeInactiveFlag</th>
                <th>createDate</th>
                <th>createdBy</th>
                <th>modifiedDate</th>
                <th>modifiedBy</th>
                <th>authorizedDate</th>
                <th>authorizedBy</th>
                <th>Edit/Delete</th>
            </tr>
            <c:forEach var="customer" items="${customer}">
            <tr>
                <td>${customer.customerId}</td>
                <td>${customer.customerCode}</td>
                <td>${customer.customerName}</td>
                <td>${customer.customerAddress1}</td>
                <td>${customer.customerAddress2}</td>
                <td>${customer.customerPinCode}</td>
                <td>${customer.emailAddress}</td>
                <td>${customer.contactNumber}</td>
                <td>${customer.primaryContactPerson}</td>
                <td>${customer.recordStatus}</td>
                <td>${customer.activeInactiveFlag}</td>
                <td>${customer.createDate}</td>
                <td>${customer.createdBy}</td>
                <td>${customer.modifiedDate}</td>
                <td>${customer.modifiedBy}</td>
                <td>${customer.authorizedDate}</td>
                <td>${customer.authorizedBy}</td>
                <td>
                    <form>
                        <table>
                            <td><a href="<c:url value='/update${customer.customerCode}'/>">Edit</a></td>
                            <td><a href="<c:url value='/deleteCustomer/${customer.customerCode}'/>">Delete</a></td>
                        </table>
                    </form>
                </td>
            </tr>
            </c:forEach>
        </table>
        <br>
        <c:url value="/logout" var="logoutUrl" />

        <form id="logout" action="${logoutUrl}" method="post" >
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
        	<a href="javascript:document.getElementById('logout').submit()">Logout</a>
        </c:if>
</body>
</html>
