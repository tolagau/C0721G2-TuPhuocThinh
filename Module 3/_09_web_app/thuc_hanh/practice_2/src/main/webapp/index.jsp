<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <style type="text/css">
    .login {
      height:180px; width:230px;
      margin:0;
      padding:10px;
      border:1px #CCC solid;
    }
    .login input {
      padding:5px; margin:5px
    }
  </style>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="/practice_2">
      <div class="login">
        <h2>Login</h2>
        <input type="text" name="username" size="30" placeholder="username"/>
        <input type="text" name="password" size="30" placeholder="password"/>
        <input type="submit" value="Sign in">
      </div>
  </form>
  </body>
</html>
