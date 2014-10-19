<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<c:import url="head.jsp" />

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
