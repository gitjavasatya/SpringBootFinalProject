<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">.error {color: red;}</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>

	<fm:form action="updateUom" method="post" modelAttribute="uom">
		<pre>
		
UOM ID		:<fm:input type="text" path="uomId" value="${uom.uomId}" readonly="readonly" /> 
UOM Type	:<fm:select path="uomType">
			<fm:option value="1">Select</fm:option>
			<c:forEach items="${uomTypes}" var="ob">
			<c:choose>
			<c:when test="${uom.uomType eq ob.key}">
			<fm:option value="${ob.key}" selected="selected">${ob.value}</fm:option>
			</c:when>
			<c:otherwise>
			<fm:option value="${ob.key}">${ob.value}</fm:option>
			</c:otherwise>
			</c:choose>
			</c:forEach>
			</fm:select>
			<fm:errors path="uomType" cssClass="error" />
UOM Model	:<fm:input type="text" path="uomModel" value="${uom.uomModel}" />
			 <fm:errors path="uomModel" cssClass="error" />
CreatedDate	:<fm:input type="text" path="description" value="${uom.createdDate}" readonly="readonly" />
Description	:<fm:textarea path="description">${uom.description}</fm:textarea>
			 <fm:errors path="description" cssClass="" />
			 <input type="submit" value="UPDATE" />

</pre>
	</fm:form>

</body>
</html>