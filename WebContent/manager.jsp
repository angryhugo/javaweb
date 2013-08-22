<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:useBean id="mger" class="business.Manager"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="test.css">
<title>管理员界面</title>
</head>
<body>
	<%
		String name = request.getParameter("username");
		String psw = request.getParameter("password");
		if (mger.checkManager(name, psw)) {
			session.setAttribute("用户名", name);
	%>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="66%">
				<p>
					<img src="images/head-yhc.jpg" width="450" height="53" />
				</p>
			</td>
			<td width="30%" align="right"><p><%="欢迎您： " + session.getAttribute("用户名") + " 管理员 "%></p></td>
			<td width="4%" align="right"><form id="form1" name="form1"
					method="post" action="login.jsp">
					<label> <input type="submit" name="Submit" value="退出" />
					</label>
				</form></td>
		</tr>
		<tr>
			<td bgcolor="#E3E1EC" colspan="3"><jsp:include
					page="spry-dh1.jsp"></jsp:include></td>
		</tr>
	</table>
	<iframe id="ifid" src="Business/m_query.jsp?a=SA" frameborder="1"
		width="100%" scrolling="no"></iframe>
	<script type="text/javascript">
		function reinitIframe() {
			var iframe = document.getElementById("ifid");
			try {
				iframe.height = iframe.contentWindow.document.documentElement.scrollHeight;
			} catch (ex) {
			}
		}
		window.setInterval("reinitIframe()", 200);
	</script>

	<table width="795" border="0" cellspacing="0" align="center"
		bgcolor="#E3E1EC">
		<tr>
			<td align="center"><p>&nbsp;</p> <font color="#939393">&copy;2012-2020&nbsp;&nbsp;印韩春4s店
					版权所有&nbsp;&nbsp; 联系方式:<a href="mailto:yinhanchun24@gmail.com">yinhanchun24@gmail.com</a>
			</font></td>
		</tr>
	</table>
	<%
		} else {
			out.print("<script language=javascript>alert('用户名密码错误！ ');window.location='login.jsp';</script>");
		}
	%>
</body>
</html>