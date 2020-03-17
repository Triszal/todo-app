<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${modeTitle} Todo</title>
</head>
<body>
<link rel="stylesheet" href="/css/add.css" >
<h2>${modeTitle} your new tasks</h2>
<form:form action="${pageContext.request.contextPath}/todo/${mode}" method="post" modelAttribute="todo">
    <form:hidden path="id"/>
    <table>
        <tr>
            <td>
                <form:label path="title">What tasks do you want to do?</form:label>
            </td>
            <td>
                <form:input path="title"></form:input>
            </td>
            <td>
                <form:errors path="title"></form:errors>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="description">Description of the task</form:label>
            </td>
            <td>
                <form:textarea path="description" cols="40" rows="25"></form:textarea>
            </td>
            <td>
                <form:errors path="description"></form:errors>
            </td>
        </tr>
        <tr>
            <td>
                <label>Actions</label>
            </td>
            <td>
                <form:button name="cancel">Cancel</form:button>
                &nbsp;
                <input type="submit" name="submit" value="Submit">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
