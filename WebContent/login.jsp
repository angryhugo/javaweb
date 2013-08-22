<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script charset="gb2312" type="text/javascript" src="JavaScript/logincheck.js"></script>
<!-- 此处如果不加charset="gb2312" 会导致乱码 -->
<link rel="stylesheet" type="text/css" href="test.css">
<title>欢迎登陆销售管理系统</title>
</head>
<body>
	<table width="795" border="0" cellspacing="0" align="center"
		bgcolor="#E3E1EC">
		<tr>
			<td width="465" height="66"><img src="images/head-yhc.jpg"
				width="450" height="53" /></td>
			<td width="326" height="66"><marquee>
					<p>&nbsp;</p>
					<p>
						<font style="font-family: '华文行楷'">欢迎登录4S店销售管理系统</font>
					</p>
				</marquee> &nbsp;</td>
		</tr>
	</table>
	<table width="auto" border="0" cellspacing="0" align="center"
		bgcolor="#E3E1EC">
		<tr>
			<td width="422" rowspan="2"><img src="images/login1.jpg"
				width="422" height="265" /></td>
			<td width="369" colspan="2" align="center"><p>
					<img src="images/yhdllogin.jpg" width="161" height="33" />
				</p></td>
		</tr>
		<tr>
			<td width="50">&nbsp;</td>
			<td><form id="form1" name="form1" method="post">
					<p>
						<img src="images/1.jpg" width="21" height="25" />用户名： <label>
							<input name="username" type="text" size="20" />
						</label>
					</p>
					<p>
						<img src="images/2.jpg" width="21" height="25" />密&nbsp;&nbsp;&nbsp;
						码： <label> <input name="password" type="password"
							size="20" />
						</label>
					</p>
					<table width="200" bgcolor="#E3E1EC">
						<tr>
							<td width="63"><label> <input type="radio"
									name="RadioGroup1" value="manager.jsp" /> 管理员
							</label></td>
							<td width="63"><label> <input type="radio"
									name="RadioGroup1" value="salesman.jsp" checked="checked" />
									销售员
							</label></td>
							<td width="60"></td>
						</tr>
					</table>
					<p>
						<label> <input name="enter" type="button"
							onclick="check();" value="登录" /> &nbsp;&nbsp;&nbsp;&nbsp;
						</label> <label> <input type="reset" name="reset" value="重置" />
						</label>
					</p>
					<p>&nbsp;</p>
				</form></td>
		</tr>
	</table>
	<table width="795" border="0" cellspacing="0" align="center"
		bgcolor="#E3E1EC">
		<tr>
			<td align="center"><p>&nbsp;</p> <font color="#939393">&copy;2012-2020&nbsp;&nbsp;印韩春4s店
					版权所有&nbsp;&nbsp; 联系方式:<a href="mailto:yinhanchun24@gmail.com">yinhanchun24@gmail.com</a>
			</font></td>
		</tr>
	</table>
</body>
</html>