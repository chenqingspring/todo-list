<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Todo Something</title>
    <link href="view/css/login.css"  rel="stylesheet" type="text/css"/>
</head>

<body>

<form:form method="POST" action="/todo-list/Login">
    <div id="user-login"><p>User Login</p>
        <div id="username"><label>Username</label><input name="username" type="text"/></div>
        <div id="password"><label>Password</label><input name="password" type="password"/></div>
        <button type="submit" class="button">login</button>
        <a href="Register" class="button">register</a>
    </div>
</form:form>

</body>
</html>
