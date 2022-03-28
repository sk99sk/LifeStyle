<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Product Page</title>
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css"/>
<style type="text/css">
  <%@include file="../../WEB-INF/lib/index.css" %>
</style>
</head>
<body>
<div class="topnav">
  <a class="active" href="http://localhost:3000/">LifeStyle</a>
</div>
    
    <div class=adp>
    
    <h1>Add a Product</h1>

	<c:url var="addAction" value="/product/add"></c:url>

	<form:form action="${addAction}" commandName="product">
		<table>
			<c:if test="${!empty product.name}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="description">
						<spring:message text="Description" />
					</form:label></td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td><form:label path="price">
						<spring:message text="Price" />
					</form:label></td>
				<td><form:input type="number" step="0.01" path="price" /></td>
			</tr>
			<tr>
				<td><form:label path="imgSrc">
						<spring:message text="Image Src" />
					</form:label></td>
				<td><form:input path="imgSrc" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty product.name}">
						<input type="submit" value="<spring:message text="Edit Product"/>" />
					</c:if> <c:if test="${empty product.name}">
						<input type="submit" value="<spring:message text="Add Product"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
    </div>
	
	<br>
	<div class="pl">
	
	<h2>Products List</h2>
	<c:if test="${!empty listProducts}">
		<table class="tg">
			<tr>
				<th width="80">Product ID</th>
				<th width="120">Product Name</th>
				<th width="120">Product Description</th>
				<th width="80">Product Price</th>
				<th width="120">Product Image Src</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listProducts}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.price}</td>
					<td>${product.imgSrc}</td>
					<td><a href="<c:url value='/edit/${product.id}' />">Edit</a></td>
					<td><a href="<c:url value='/remove/${product.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>
	
	
	<div id="footer">
<div class="inner">Life Style</div>
</div>
</body>


</html>
