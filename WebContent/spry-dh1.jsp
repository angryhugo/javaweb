<%@ page language="java" contentType="text/html; charset=GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>Insert title here</title>
<script src="SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<ul id="MenuBar1" class="MenuBarHorizontal">
		<li><a class="MenuBarItemSubmenu" >员工信息查询</a>
			<ul>
				<li><a
					onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SH'">有业绩员工</a></li>
				<li><a
					onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SN'">无业绩员工</a></li>
				<li><a
					onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SA'">全部员工</a></li>
				<li><a 
					onclick="document.getElementById('ifid').src='QuerySalesman'">自定义查询</a></li>
				<!--页面后加？a=1传递参数  -->
			</ul></li>
		<li><a class="MenuBarItemSubmenu" >客户信息查询</a>
			<ul>
				<li><a
					onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=CH'">成交客户</a></li>
				<li><a
					onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=CN'">未成交客户</a></li>
				<li><a 
					onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=CA'">全部客户</a></li>
				<li><a
					onclick="document.getElementById('ifid').src='QueryCustomer'">自定义查询</a></li>
			</ul></li>
		<li><a class="MenuBarItemSubmenu">车辆信息查询</a>
			<ul>
				<li><a >按颜色</a>
					<ul>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VCB'">黑色</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VCW'">白色</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VCS'">银色</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VCO'">其他</a></li>
					</ul></li>
				<li><a >按厂商</a>
					<ul>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VMBenz'">奔驰</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VMBMW'">宝马</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VMAUDI'">奥迪</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VMO'">其他</a></li>
					</ul></li>
				<li><a >按出厂年份</a>
					<ul>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VD1'">2009年前</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VD2'">2010-2011年</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VD3'">2012年后</a></li>
					</ul></li>
				<li><a >按价格</a>
					<ul>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VP1'">50万以下</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VP2'">50万-100万</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VP3'">100万以上</a></li>
					</ul></li>
				<li><a
					onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VA'">全部</a></li>
				<li><a onclick="document.getElementById('ifid').src='QueryCar'">自定义查询</a></li>
			</ul></li>
		<li><a  class="MenuBarItemSubmenu">销售信息查询</a>
			<ul>
				<li><a >按员工分组</a>
					<ul>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaSo'">本月</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaSt'">近三个月</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaSa'">全部</a></li>
					</ul></li>
				<li><a >按厂商分组</a>
					<ul>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaMo'">本月</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaMt'">近三个月</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaMa'">全部</a></li>
					</ul></li>
				<li><a >各条记录明细</a>
					<ul>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaAo'">本月</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaAt'">近三个月</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaAa'">全部</a></li>
					</ul></li>
				<li><a
					onclick="document.getElementById('ifid').src='QuerySale'">自定义查询</a></li>
			</ul></li>
		<li><a class="MenuBarItemSubmenu" >销售排行榜</a>
			<ul>
				<li><a >按销售量</a>
					<ul>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaPao'">本月</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaPat'">近三个月</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaPaa'">全部</a></li>
					</ul></li>
				<li><a >按销售额</a>
					<ul>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaPpo'">本月</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaPpt'">近三个月</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaPpa'">全部</a></li>
					</ul></li>
			</ul></li>
		<li><a class="MenuBarItemSubmenu" >录入信息</a>
			<ul>
				<li><a	onclick="document.getElementById('ifid').src='InsSalesman'">员工信息</a></li>
				<li><a	onclick="document.getElementById('ifid').src='InsCustomer'">客户信息</a></li>
				<li><a	onclick="document.getElementById('ifid').src='InsVehicle'">车辆信息</a></li>
				<li><a onclick="document.getElementById('ifid').src='InsSale'">销售记录</a></li>
			</ul></li>
		<li><a class="MenuBarItemSubmenu">修改信息</a>
			<ul>
				<li><a onclick="document.getElementById('ifid').src='UpdSalesman'">员工信息</a></li>
				<li><a onclick="document.getElementById('ifid').src='UpdCustomer'">客户信息</a></li>
				<li><a onclick="document.getElementById('ifid').src='UpdVehicle'">车辆信息</a></li>
				<li><a onclick="document.getElementById('ifid').src='UpdSale'">销售记录</a></li>
			</ul></li>
		<li><a class="MenuBarItemSubmenu">删除信息</a>
			<ul>
				<li><a
					onclick="document.getElementById('ifid').src='DelSalesman'">员工信息</a></li>
				<li><a
					onclick="document.getElementById('ifid').src='DelCustomer'">客户信息</a></li>
				<li><a
					onclick="document.getElementById('ifid').src='DelVehicle'">车辆信息</a></li>
				<li><a onclick="document.getElementById('ifid').src='DelSale'">销售记录</a></li>
			</ul></li>
		<li><a onclick="document.getElementById('ifid').src='UpdPsw_M'">修改密码</a></li>
	</ul>
	<script type="text/javascript">
	<!--
		var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {
			imgDown : "SpryAssets/SpryMenuBarDownHover.gif",
			imgRight : "SpryAssets/SpryMenuBarRightHover.gif"
		});
	//-->
	</script>
</body>
</html>