<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<c:import url="head.jsp" />

<body>
<form:form method="POST" action="/todo-list/addAccount">
<div id="Register"><p>TODO--LIST<p>
    <div id="username" ><label>Username</label><input name="username"/></div>
    <div class="password"><label>Password</label><input type="password" name="pwfirst"/></div>
    <div class="password"><label>PW Again</label><input type="password" name="pwsecond"/></div>
    <button type="submit">Compelet</button>
</div>
</form:form>

</body>
</html>