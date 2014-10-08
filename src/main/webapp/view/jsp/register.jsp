<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Todo Something</title>
    <link href="view/css/login.css"  rel="stylesheet" type="text/css"/>
</head>

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