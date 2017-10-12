<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>WELCOME TO UOM DATA PAGE</title>
</head>
<body>
<table bgcolor="#4CAF50" border="1px solid #ccc">
<tr>
<th>UomId</th><th>UomType</th><th>UomModel</th><th>CreatedDate</th><th>LastModifiedDate</th><th>Description</th>
</tr>
<c:forEach items="${Uomdata}" var="uom">
<tr>
<td><c:out value="${uom.uomId}"></c:out></td>
<td><c:out value="${uom.uomType}"></c:out></td>
<td><c:out value="${uom.uomModel}"></c:out></td>
<td><c:out value="${uom.createdDate}"></c:out></td>
<td><c:out value="${uom.lastModifiedDate}"></c:out></td>
<td><c:out value="${uom.description}"></c:out></td>
<td><a href="deleteUom?uomId=${uom.uomId}">DELETE</a></td>
<td><a href="editUom?uomId=${uom.uomId}">EDIT</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>