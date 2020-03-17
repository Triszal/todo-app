<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Todo List</title>
</head>
<link rel="stylesheet" href="/css/Styles.css" >
<body>
<h2>Todo Tasks</h2>
<a type = "button" class="newb" href="${pageContext.request.contextPath}/todo/create">Click here to add   new tasks</a>
<table>
    <thead>
    <tr>
        <div class = "test" style="text-overflow:ellipsis;">Hint  Click the New Button to add new tasks</div>
        <td><label>Title</label></td>
        <br>
        <td><label>Completed</label></td>
        <td><label>Action</label></td>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="todo" items="${todos}">
    <tr>
        <td>
            ${todo.title}
        </td>
        <td>
            ${todo.completed}
        </td>
        <td>
            <a type="button" class="glow-on-hover" href="${pageContext.request.contextPath}/todo/edit/${todo.id}">Edit </a>
            &nbsp;
            <a type="button" class="glow-on-hover" href="${pageContext.request.contextPath}/todo/complete/${todo.id}">Complete </a>
            &nbsp;
            <a type="button" class="glow-on-hover" href="${pageContext.request.contextPath}/todo/delete/${todo.id}">Delete </a>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
