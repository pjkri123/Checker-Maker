<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<head>
<title>New Customer</title>
    <style>
        .error
        {
            color: #ff0000;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <p><a href="?language=en_US">English</a>|<a href="?language=hi_IN">Hindi</a> </p>
    <h3><spring:message code="userForm.title1" text="Add New Customer"/></h3>

    <form:form action="success" modelAttribute="customer" method="POST">
        <table>
            <tr>
                <td><label path="customerCode"><spring:message code="userForm.customerCode" text="Enter customerCode"/></label></td>
                <td><form:input path="customerCode"/></td>
                <td><form:errors path="customerCode" cssClass="error" /></td>
            </tr>
            <tr>
                <td><label for="customerName"><spring:message code="userForm.customerName" text="Enter customerName"/></label></td>
                <td><form:input path="customerName"/></td>
                <td><form:errors path="customerName" cssClass="error" /></td>
            </tr>
            <tr>
                <td><label for="customerAddress1"><spring:message code="userForm.customerAddress1" text="Enter customerAddress1"/></label></td>
                <td><textArea id="customerAddress1" name="customerAddress1"></textArea></td>
                <td><form:errors path="customerAddress1" cssClass="error" /></td>
            </tr>
            <tr>
                <td><label for="customerAddress2"><spring:message code="userForm.customerAddress2" text="Enter customerAddress2"/></label></td>
                <td><textArea id="customerAddress2" name="customerAddress2"></textArea></td>
            </tr>
            <tr>
                <td><label for="customerPinCode"><spring:message code="userForm.customerPinCode" text="Enter customerPinCode"/></label></td>
                <td><form:input path="customerPinCode"/></td>
                <td><form:errors path="customerPinCode" cssClass="error" /></td>
            </tr>
            <tr>
                <td><label for="emailAddress"><spring:message code="userForm.emailAddress" text="Enter emailAddress"/></label></td>
                <td><form:input path="emailAddress"/></td>
                <td><form:errors path="emailAddress" cssClass="error" /></td>
            </tr>
            <tr>
                <td><label for="contactNumber"><spring:message code="userForm.contactNumber" text="Enter contactNumber"/></label></td>
                <td><form:input path="contactNumber"/></td>
                <td><form:errors path="contactNumber" cssClass="error" /></td>
            </tr>
            <tr>
                <td><label for="primaryContactPerson"><spring:message code="userForm.primaryContactPerson" text="Enter primaryContactPerson"/></label></td>
                <td><form:input path="primaryContactPerson"/></td>
                <td><form:errors path="primaryContactPerson" cssClass="error" /></td>
            </tr>
            <tr>
                <td><label for="activeInactiveFlag"><spring:message code="userForm.activeInactiveFlag" text="Enter activeInactiveFlag"/></label></td>
                <td><form:select path="activeInactiveFlag" value="location">
                 <form:option value="A">Active</form:option>
                 <form:option value="I">Inactive</form:option>
                 </form:select></td>
                 <td><form:errors path="activeInactiveFlag" cssClass="error" /></td>
            </tr>
        </table>
        <p>
            <input type="submit" value="<spring:message code="userForm.Add" text="Add"/>"/>
            <input type="reset" value="<spring:message code="userForm.Clear" text="Clear"/>"/>
        </p>

    </form:form>

    <br>
    <form:form action="maker">
        <input type="submit" value="<spring:message code="userForm.HomePage" text="Home Page"/>"/>
    </form:form>
</body>
</html>
