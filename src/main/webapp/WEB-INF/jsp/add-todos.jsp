<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h2>Hello ${name} add your todos</h2>
	<br>

	<form:form action="" method="post" modelAttribute="todo">
		<fieldset class="form-group">
			<form:hidden path="id" />
			<form:label path="desc">Description:</form:label>
			<form:input path="desc" type="text" name="description"
				class="form-control" required="required" />
			<form:errors path="desc" cssClass="text-warning" />
			<form:label path="targetDate">Target Date</form:label>
			<form:input path="targetDate" type="text" name="targetDate"
				class="form-control" required="required" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>
		<input type="submit" value="Add" class="btn btn-success">
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>
