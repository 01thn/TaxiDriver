<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Auth driver</title>
</head>
<body>
    <h2>Sign in</h2>
    <form method="post" action="check-driver">
        <label for="login">Login</label>
        <input class="input" type="text" id="login" name="login" value="${login}" placeholder="Enter your login">
        <label for="password">Password</label>
        <input class="input" type="password" id="password" name="password" placeholder="Enter your password">

        <input type="submit" value="Sign in">
    </form>

    <form action="sign-up">
        <input type="submit" value="Sign up"/>
    </form>

    <c:if test="${not empty message}">
        ${message}
    </c:if>

</body>
</html>