<%-- 
    Document   : loginPage
    Created on : 13 Jun, 2022, 7:40:24 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form method="post" action="loginCode">
            <center>
                <table>
                    <tr>
                        <td colspan="2" align="center">
                            Login
                        </td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>
                            <input type="text" required>
                        </td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td>
                            <input type="password" required>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Login">
                        </td>
                    </tr>
                </table>
            </center>
        </form>
    </body>
</html>
