<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Todo Something</title>
    <link href="view/css/layout.css"  rel="stylesheet" type="text/css"/>
</head>
<body>
<form:form method="POST" action="/todo/addItem">
    <div id="show-todo">Show my todo-list
        <div><input type="checkbox"/>Pay bills</div>
        <div><input type="checkbox"/>Wash car</div>
        <div><input type="checkbox"/>Get laundry</div>
        <div><input type="checkbox"/>Buy Groceries</div>
        <div><input type="checkbox"/>Pick up kids</div>
        <div><input type="checkbox"/>${newItem}</div>
    </div>
    <div id="add-todo">Add a item
        <input type="text"/>
        <input type="submit"/>
    </div>
</form:form>
</body>
</html>
