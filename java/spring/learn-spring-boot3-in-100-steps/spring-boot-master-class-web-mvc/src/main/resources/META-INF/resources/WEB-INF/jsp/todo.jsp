<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <h1>Enter Todo Details</h1>
    <%--@elvariable id="todo" type="de.alice.springboot.webmvc.todo.Todo"--%>
    <form:form method="post" modelAttribute="todo">
        <form:input path="id" type="hidden" name="id"/>
        <form:input path="username" type="hidden" name="username"/>
        <form:input path="done" type="hidden" name="done"/><br>

        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input path="description" type="text" name="description" class="form-control" required="required"/>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>

        <fielset class="mb-3">
            <form:label path="targetDate">Target Date</form:label>
            <form:input path="targetDate" type="text" name="targetDate" class="form-control" required="required"/>
            <form:errors path="targetDate" cssClass="text-warning"/>
        </fielset>
        <br>

        <input type="submit" value="Submit" class="btn btn-success">
    </form:form>
</div>

<%@ include file="common/footer.jspf" %>
<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
    });
</script>