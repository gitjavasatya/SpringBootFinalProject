<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>

	<form action="updateUom" method="post">
		<pre>
		
UOM ID		:<input type="text" name="uomId" value="${uom.uomId}"
				readonly="readonly" /> 
UOM Type	:<select name="uomType">
			<option value="1">Select</option>
			<c:forEach items="${uomTypes}" var="ob">
			<c:choose>
			<c:when test="${uom.uomType eq ob.key}">
			<option value="${ob.key}" selected="selected">${ob.value}</option>
			</c:when>
			<c:otherwise>
			<option value="${ob.key}">${ob.value}</option>
			</c:otherwise>
			</c:choose>
			</c:forEach>
			</select>
UOM Model	:<input type="text" name="uomModel" value="${uom.uomModel}" />
CreatedDate	:<input type="text" value="${uom.createdDate}" readonly="readonly" />
Description	:<textarea name="description">${uom.description}</textarea>
<input type="submit" value="UPDATE" />

</pre>
	</form>

</body>
</html>