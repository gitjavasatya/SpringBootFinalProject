 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="insertUom" method="post">
<pre>
UOM Type	:<select name="uomType">
			<option value="1">Select</option>
			<option value="Pack">PACKING</option>
			<option value="NoPack">NOPACKING</option>
			<option value="Bag">BAG</option>
			<option value="Box">BOX</option>
			<option value="Roll">ROLL</option>
			<option value="NA">-NA-</option>
			</select>
UOM Model	:<input type="text" name="uomModel"/>
Description	:<textarea name="description"></textarea>
<input type="Submit" value="UOM Register"/>
</pre>
</form>
<a href="getAllUom">View All UOM's Data</a><br/>
UOM Id No:${Msg}
</body>
</html>