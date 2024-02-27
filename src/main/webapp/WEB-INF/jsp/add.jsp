<%@ page import="com.crudapp.crudapplication.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add User </title>
    <link rel="stylesheet" href="/jsp/add.css">
  </head>
<body>
<div class="container">
  <h1>Add User</h1>
  <%
    User user = (User)request.getAttribute("user");
    if(user==null){
       user = new User("","","");
    }

  %>
  <form action="/add" method="post">
    <input type="text" id="id" name="id" value="<%=user.getId()%>" hidden="hidden">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="<%=user.getName()%>" required>

    <label for="education">Education:</label>
    <input type="text" id="education" name="education" value="<%=user.getEducation()%>" required>

    <label for="post">Designation:</label>
    <input type="text" id="post" name="post" value="<%=user.getSkills()%>" required>

    <button type="submit">Submit</button>
  </form>
</div>
</body>
</html>
