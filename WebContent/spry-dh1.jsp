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
		<li><a class="MenuBarItemSubmenu" >Ա����Ϣ��ѯ</a>
			<ul>
				<li><a
					onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SH'">��ҵ��Ա��</a></li>
				<li><a
					onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SN'">��ҵ��Ա��</a></li>
				<li><a
					onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SA'">ȫ��Ա��</a></li>
				<li><a 
					onclick="document.getElementById('ifid').src='QuerySalesman'">�Զ����ѯ</a></li>
				<!--ҳ���ӣ�a=1���ݲ���  -->
			</ul></li>
		<li><a class="MenuBarItemSubmenu" >�ͻ���Ϣ��ѯ</a>
			<ul>
				<li><a
					onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=CH'">�ɽ��ͻ�</a></li>
				<li><a
					onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=CN'">δ�ɽ��ͻ�</a></li>
				<li><a 
					onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=CA'">ȫ���ͻ�</a></li>
				<li><a
					onclick="document.getElementById('ifid').src='QueryCustomer'">�Զ����ѯ</a></li>
			</ul></li>
		<li><a class="MenuBarItemSubmenu">������Ϣ��ѯ</a>
			<ul>
				<li><a >����ɫ</a>
					<ul>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VCB'">��ɫ</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VCW'">��ɫ</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VCS'">��ɫ</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VCO'">����</a></li>
					</ul></li>
				<li><a >������</a>
					<ul>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VMBenz'">����</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VMBMW'">����</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VMAUDI'">�µ�</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VMO'">����</a></li>
					</ul></li>
				<li><a >���������</a>
					<ul>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VD1'">2009��ǰ</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VD2'">2010-2011��</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VD3'">2012���</a></li>
					</ul></li>
				<li><a >���۸�</a>
					<ul>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VP1'">50������</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VP2'">50��-100��</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VP3'">100������</a></li>
					</ul></li>
				<li><a
					onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=VA'">ȫ��</a></li>
				<li><a onclick="document.getElementById('ifid').src='QueryCar'">�Զ����ѯ</a></li>
			</ul></li>
		<li><a  class="MenuBarItemSubmenu">������Ϣ��ѯ</a>
			<ul>
				<li><a >��Ա������</a>
					<ul>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaSo'">����</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaSt'">��������</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaSa'">ȫ��</a></li>
					</ul></li>
				<li><a >�����̷���</a>
					<ul>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaMo'">����</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaMt'">��������</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaMa'">ȫ��</a></li>
					</ul></li>
				<li><a >������¼��ϸ</a>
					<ul>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaAo'">����</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaAt'">��������</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaAa'">ȫ��</a></li>
					</ul></li>
				<li><a
					onclick="document.getElementById('ifid').src='QuerySale'">�Զ����ѯ</a></li>
			</ul></li>
		<li><a class="MenuBarItemSubmenu" >�������а�</a>
			<ul>
				<li><a >��������</a>
					<ul>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaPao'">����</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaPat'">��������</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaPaa'">ȫ��</a></li>
					</ul></li>
				<li><a >�����۶�</a>
					<ul>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaPpo'">����</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaPpt'">��������</a></li>
						<li><a
							onclick="document.getElementById('ifid').src='Business/m_query.jsp?a=SaPpa'">ȫ��</a></li>
					</ul></li>
			</ul></li>
		<li><a class="MenuBarItemSubmenu" >¼����Ϣ</a>
			<ul>
				<li><a	onclick="document.getElementById('ifid').src='InsSalesman'">Ա����Ϣ</a></li>
				<li><a	onclick="document.getElementById('ifid').src='InsCustomer'">�ͻ���Ϣ</a></li>
				<li><a	onclick="document.getElementById('ifid').src='InsVehicle'">������Ϣ</a></li>
				<li><a onclick="document.getElementById('ifid').src='InsSale'">���ۼ�¼</a></li>
			</ul></li>
		<li><a class="MenuBarItemSubmenu">�޸���Ϣ</a>
			<ul>
				<li><a onclick="document.getElementById('ifid').src='UpdSalesman'">Ա����Ϣ</a></li>
				<li><a onclick="document.getElementById('ifid').src='UpdCustomer'">�ͻ���Ϣ</a></li>
				<li><a onclick="document.getElementById('ifid').src='UpdVehicle'">������Ϣ</a></li>
				<li><a onclick="document.getElementById('ifid').src='UpdSale'">���ۼ�¼</a></li>
			</ul></li>
		<li><a class="MenuBarItemSubmenu">ɾ����Ϣ</a>
			<ul>
				<li><a
					onclick="document.getElementById('ifid').src='DelSalesman'">Ա����Ϣ</a></li>
				<li><a
					onclick="document.getElementById('ifid').src='DelCustomer'">�ͻ���Ϣ</a></li>
				<li><a
					onclick="document.getElementById('ifid').src='DelVehicle'">������Ϣ</a></li>
				<li><a onclick="document.getElementById('ifid').src='DelSale'">���ۼ�¼</a></li>
			</ul></li>
		<li><a onclick="document.getElementById('ifid').src='UpdPsw_M'">�޸�����</a></li>
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