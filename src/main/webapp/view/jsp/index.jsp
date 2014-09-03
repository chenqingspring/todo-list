<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Todo Something</title>
    <link href="view/css/layout.css"  rel="stylesheet" type="text/css"/>
</head>

<body>
<div id="show-todo">Show my todo-list
    <c:forEach items="${Items}" var="item">
        <div><input type="checkbox"/>${item.description}</div>
    </c:forEach>
</div>

<form:form method="POST" action="/todo-list/addItem">
    <div id="add-todo">Add a item
        <input name="description" type="text"/>
        <input type="submit"/>
    </div>
</form:form>
</body>
</html>
