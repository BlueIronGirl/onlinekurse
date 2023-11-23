<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <title>Add Todo Page</title>
</head>
<body>
<div class="container">
    <h1>Enter Todo Details</h1>
    <form:form method="post" modelAttribute="todo">
        <form:input path="id" type="hidden" name="id"/>
        <form:input path="username" type="hidden" name="username"/>
        <form:input path="done" type="hidden" name="done"/><br>

        Description: <form:input path="description" type="text" name="description" class="form-control" required="required"/><br>
        Target Date: <form:input path="targetDate" type="date" name="targetDate" class="form-control" required="required"/><br>


        <input type="submit" value="Submit" class="btn btn-success">
    </form:form>
</div>
</body>
</html>