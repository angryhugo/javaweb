<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<jsp:useBean id="fsearchM" class="business.ForSearch"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="script04.css">
<script src="jQuery.js"></script>
<script src="jquery/jquery.tablesorter.js"></script>
<script src="script05.js"></script>
<style type="text/css">
.style1 {font-family: "�����п�"; font-size: 24px; font-style: normal; color: #666666; }
</style>
</head>
<body>
	<% 
		String option = request.getParameter("a");
		StringBuilder s = new StringBuilder();
        s = fsearchM.queryOpition(option);
		out.print(s);
	%>
</body>
</html>