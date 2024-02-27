<%@ page import="com.crudapp.crudapplication.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/jsp/index.css">
    <title>Crud Application</title>
</head>
<body>

<table>
    <%@include file="header.jsp"%>
    <a  href="/getAddPage"><button id="add">ADD</button></a>
    <thead>
    <tr>
        <th>Name</th>
        <th>Education</th>
        <th>Skills</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
<% for (User user : (List<User>)request.getAttribute("users")) { %>
    <tr>
        <td><%=user.getName()%></td>
        <td><%=user.getEducation()%></td>
        <td><%=user.getSkills()%></td>
        <td>
            <a href="/getUser?id=<%=user.getId()%>"><button>Edit</button></a>
            <a href="/deleteUser?id=<%=user.getId()%>"><button>Delete</button></a>

        </td>
    </tr>
  <%}%>
    </tbody>
</table>
</body>
</html>

