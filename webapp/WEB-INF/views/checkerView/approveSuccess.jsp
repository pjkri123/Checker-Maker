<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <style>
        table, table th, table td {
            border-collapse: collapse;
            border: 1px solid #ddd;
              padding: 8px;
        }
    </style>
</head>
<body>
    <h4>Approved</h4>
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
        </tr>
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
        </tr>
    </table>


    <br>
    <form:form action="checker">
        <input type="submit" value="Home Page"/>
    </form:form>
</body>
</html>
