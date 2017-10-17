 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<html>
<head><style type="text/css">.error {color: red;}</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fm:form action="insertUom" method="post" modelAttribute="uom">
<pre>
UOM Type	:<fm:select path="uomType">
			<fm:option value="">Select</fm:option>
			<fm:option value="Pack">PACKING</fm:option>
			<fm:option value="NoPack">NOPACKING</fm:option>
			<fm:option value="Bag">BAG</fm:option>
			<fm:option value="Box">BOX</fm:option>
			<fm:option value="Roll">ROLL</fm:option>
			<fm:option value="NA">-NA-</fm:option>
			</fm:select>
			<fm:errors path="uomType" cssClass="error"/>
UOM Model	:<fm:input type="text" path="uomModel"/>
			 <fm:errors path="uomModel" cssClass="error"/>
Description	:<fm:textarea path="description"></fm:textarea>
			 <fm:errors path="description" cssClass="error"/>
<input type="Submit" value="UOM Register"/>
</pre>
</fm:form>
<a href="getAllUom">View All UOM's Data</a><br/>
UOM Id No:${Msg}
</body>
</html>