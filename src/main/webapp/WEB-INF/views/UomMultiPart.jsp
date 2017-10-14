<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to UOM MultiPart</h2>
<h2>Export Data Into Excel Sheet</h2>
<a href="uomExport">Export UOM Data</a>
<hr />
<h2>Import Data using Excel Sheet</h2>
<form action="uomImport" method="post" enctype="multipart/form-data">
<pre>
Select File:<input type="file" name="efile"/>
<input type="submit" value="ImportFile" />
</pre>
</form>
${importmessage}
</body>
</html>