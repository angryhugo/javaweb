package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import yhc.Db;

public class Search extends Db {
	// ��ѯԱ����Ϣ
	public StringBuilder search_salesman(String sql) throws Exception {
		StringBuilder s = new StringBuilder();
		ResultSet rs = getRs(sql);
		s = s.append("<table id=\"theTable\" width='100%'>");
		s = s.append("<thead>");
		s = s.append("<tr>");
		s = s.append("<th>" + "����");
		s = s.append("<th>" + "����");
		s = s.append("<th>" + "�Ա�");
		s = s.append("<th>" + "����");
		s = s.append("<th>" + "����");
		s = s.append("<th>" + "ѧ��");
		s = s.append("<th>" + "�޸�");
		s = s.append("<th>" + "ɾ��");
		s = s.append("</tr>");
		s = s.append("</thead>");
		// ѭ�����ÿһ����¼
		while (rs.next()) {
			// ���ÿ���ֶ�
			s = s.append("<tr>");
			s = s.append("<td>" + rs.getString("Sid") + "</td>");
			s = s.append("<td>" + rs.getString("Sname") + "</td>");
			s = s.append("<td>" + rs.getString("Sgender") + "</td>");
			s = s.append("<td>" + rs.getString("Sage") + "</td>");
			s = s.append("<td>" + rs.getString("Saddress") + "</td>");
			s = s.append("<td>" + rs.getString("Seducation") + "</td>");
			s = s.append("<td><a href=\"/VehicleSystem/UpdSalesman?id="+rs.getString("Sid")+"\">�޸�</a></td>");
			s = s.append("<td><a href=\"/VehicleSystem/DelSalesman?name="+rs.getString("Sname")+"\">ɾ��</a></td>");
			s = s.append("</tr>");
		}
		s = s.append("</table>");
		// �ر�����
		rs.close();
		return s;
	}

	// ��ѯ�ͻ���Ϣ(����Ա�����޸�ɾ��)
	public StringBuilder search_customer(String sql) throws Exception {
		StringBuilder s = new StringBuilder();
		ResultSet rs = getRs(sql);
		s = s.append("<table id=\"theTable\" width='100%'>");
		s = s.append("<thead>");
		s = s.append("<tr>");
		s = s.append("<th>" + "���");
		s = s.append("<th>" + "����");
		s = s.append("<th>" + "�Ա�");
		s = s.append("<th>" + "����");
		s = s.append("<th>" + "��ϵ��ʽ");
		s = s.append("<th>" + "��ַ");
		s = s.append("<th>" + "�޸�");
		s = s.append("<th>" + "ɾ��");
		s = s.append("</tr>");
		s = s.append("</thead>");
		// ѭ�����ÿһ����¼
		while (rs.next()) {
			// ���ÿ���ֶ�
			s = s.append("<tr>");
			s = s.append("<td>" + rs.getString("Cid") + "</td>");
			s = s.append("<td>" + rs.getString("Cname") + "</td>");
			s = s.append("<td>" + rs.getString("Cgender") + "</td>");
			s = s.append("<td>" + rs.getString("Cage") + "</td>");
			s = s.append("<td>" + rs.getString("Ccontact") + "</td>");
			s = s.append("<td>" + rs.getString("Caddress") + "</td>");
			s = s.append("<td><a href=\"/VehicleSystem/UpdCustomer?id="+rs.getString("Cid")+"\">�޸�</a></td>");
			s = s.append("<td><a href=\"/VehicleSystem/DelCustomer?name="+rs.getString("Cname")+"\">ɾ��</a></td>");
			s = s.append("</tr>");
		}
		s = s.append("</table>");
		// �ر�����
		rs.close();
		return s;
	}
	
	// ��ѯ�˿���Ϣ
		public StringBuilder search_customer_forS(String sql) throws Exception {
			StringBuilder s = new StringBuilder();
			ResultSet rs = getRs(sql);
			s = s.append("<table id=\"theTable\" width='100%'>");
			s = s.append("<thead>");
			s = s.append("<tr>");
			s = s.append("<th>" + "���");
			s = s.append("<th>" + "����");
			s = s.append("<th>" + "�Ա�");
			s = s.append("<th>" + "����");
			s = s.append("<th>" + "��ϵ��ʽ");
			s = s.append("<th>" + "��ַ");
			s = s.append("</tr>");
			s = s.append("</thead>");
			// ѭ�����ÿһ����¼
			while (rs.next()) {
				// ���ÿ���ֶ�
				s = s.append("<tr>");
				s = s.append("<td>" + rs.getString("Cid") + "</td>");
				s = s.append("<td>" + rs.getString("Cname") + "</td>");
				s = s.append("<td>" + rs.getString("Cgender") + "</td>");
				s = s.append("<td>" + rs.getString("Cage") + "</td>");
				s = s.append("<td>" + rs.getString("Ccontact") + "</td>");
				s = s.append("<td>" + rs.getString("Caddress") + "</td>");
				s = s.append("</tr>");
			}
			s = s.append("</table>");
			// �ر�����
			rs.close();
			return s;
		}

	// ��ѯ������Ϣ(����Ա�����޸�ɾ��)
	public StringBuilder search_vehicle(String sql) throws Exception {
		StringBuilder s = new StringBuilder();
		ResultSet rs = getRs(sql);
		s = s.append("<table id=\"theTable\" width='100%'>");
		s = s.append("<thead>");
		s = s.append("<tr>");
		s = s.append("<th>" + "���");
		s = s.append("<th>" + "�ͺ�");
		s = s.append("<th>" + "��ɫ");
		s = s.append("<th>" + "��������");
		s = s.append("<th>" + "�������");
		s = s.append("<th>" + "�۸�");
		s = s.append("<th>" + "�޸�");
		s = s.append("<th>" + "ɾ��");
		s = s.append("</tr>");
		s = s.append("</thead>");
		// ѭ�����ÿһ����¼
		while (rs.next()) {
			// ���ÿ���ֶ�
			s = s.append("<tr>");
			s = s.append("<td>" + rs.getString("Vnum") + "</td>");
			s = s.append("<td>" + rs.getString("Vmodel") + "</td>");
			s = s.append("<td>" + rs.getString("Vcolor") + "</td>");
			s = s.append("<td>" + rs.getString("Vmanu") + "</td>");
			s = s.append("<td>" + rs.getString("Vdate") + "</td>");
			s = s.append("<td>" + rs.getFloat("Vprice") + "</td>");
			s = s.append("<td><a href=\"/VehicleSystem/UpdVehicle?id="+rs.getString("Vnum")+"\">�޸�</a></td>");
			s = s.append("<td><a href=\"/VehicleSystem/DelVehicle?name="+rs.getString("Vnum")+"\">ɾ��</a></td>");
			s = s.append("</tr>");
		}
		s = s.append("</table>");
		// �ر�����
		rs.close();
		return s;
	}
	
	// ��ѯ������Ϣ
		public StringBuilder search_vehicle_forS(String sql) throws Exception {
			StringBuilder s = new StringBuilder();
			ResultSet rs = getRs(sql);
			s = s.append("<table id=\"theTable\" width='100%'>");
			s = s.append("<thead>");
			s = s.append("<tr>");
			s = s.append("<th>" + "���");
			s = s.append("<th>" + "�ͺ�");
			s = s.append("<th>" + "��ɫ");
			s = s.append("<th>" + "��������");
			s = s.append("<th>" + "�������");
			s = s.append("<th>" + "�۸�");
			s = s.append("</tr>");
			s = s.append("</thead>");
			// ѭ�����ÿһ����¼
			while (rs.next()) {
				// ���ÿ���ֶ�
				s = s.append("<tr>");
				s = s.append("<td>" + rs.getString("Vnum") + "</td>");
				s = s.append("<td>" + rs.getString("Vmodel") + "</td>");
				s = s.append("<td>" + rs.getString("Vcolor") + "</td>");
				s = s.append("<td>" + rs.getString("Vmanu") + "</td>");
				s = s.append("<td>" + rs.getString("Vdate") + "</td>");
				s = s.append("<td>" + rs.getFloat("Vprice") + "</td>");
				s = s.append("</tr>");
			}
			s = s.append("</table>");
			// �ر�����
			rs.close();
			return s;
		}

	// ��ѯ������Ϣ(����Ա�����޸�ɾ��)
	public StringBuilder search_sale(String sql) throws Exception {
		StringBuilder s = new StringBuilder();
		ResultSet rs = getRs(sql);
		s = s.append("<table id=\"theTable\" width='100%'>");
		s = s.append("<thead>");
		s = s.append("<tr>");
		s = s.append("<th>" + "������ˮ��");
		s = s.append("<th>" + "�������");
		s = s.append("<th>" + "�ͺ�");
		s = s.append("<th>" + "��ɫ");
		s = s.append("<th>" + "�۸�");
		s = s.append("<th>" + "��������");
		s = s.append("<th>" + "��������");
		s = s.append("<th>" + "�ͻ�");
		s = s.append("<th>" + "����Ա");
		s = s.append("<th>" + "�޸�");
		s = s.append("<th>" + "ɾ��");
		s = s.append("</tr>");
		s = s.append("</thead>");
		// ѭ�����ÿһ����¼
		while (rs.next()) {
			// ���ÿ���ֶ�
			s = s.append("<tr>");
			s = s.append("<td>" + rs.getString("Snum") + "</td>");
			s = s.append("<td>" + rs.getString("Vnum") + "</td>");
			s = s.append("<td>" + rs.getString("Vmodel") + "</td>");
			s = s.append("<td>" + rs.getString("Vcolor") + "</td>");
			s = s.append("<td>" + rs.getFloat("Vprice") + "</td>");
			s = s.append("<td>" + rs.getString("Sdate") + "</td>");
			s = s.append("<td>" + rs.getInt("Samount") + "</td>");
			s = s.append("<td>" + rs.getString("Cname") + "</td>");
			s = s.append("<td>" + rs.getString("Sname") + "</td>");
			s = s.append("<td><a href=\"/VehicleSystem/UpdSale?id="+rs.getString("Snum")+"\">�޸�</a></td>");
			s = s.append("<td><a href=\"/VehicleSystem/DelSale?name="+rs.getString("Snum")+"\">ɾ��</a></td>");
			s = s.append("</tr>");
		}
		s = s.append("</table>");
		// �ر�����
		rs.close();
		return s;
	}
	
	// ��ѯ������Ϣ
		public StringBuilder search_sale_forS(String sql) throws Exception {
			StringBuilder s = new StringBuilder();
			ResultSet rs = getRs(sql);
			s = s.append("<table id=\"theTable\" width='100%'>");
			s = s.append("<thead>");
			s = s.append("<tr>");
			s = s.append("<th>" + "������ˮ��");
			s = s.append("<th>" + "�������");
			s = s.append("<th>" + "�ͺ�");
			s = s.append("<th>" + "��ɫ");
			s = s.append("<th>" + "�۸�");
			s = s.append("<th>" + "��������");
			s = s.append("<th>" + "��������");
			s = s.append("<th>" + "�ͻ�");
			s = s.append("<th>" + "����Ա");
			s = s.append("</tr>");
			s = s.append("</thead>");
			// ѭ�����ÿһ����¼
			while (rs.next()) {
				// ���ÿ���ֶ�
				s = s.append("<tr>");
				s = s.append("<td>" + rs.getString("Snum") + "</td>");
				s = s.append("<td>" + rs.getString("Vnum") + "</td>");
				s = s.append("<td>" + rs.getString("Vmodel") + "</td>");
				s = s.append("<td>" + rs.getString("Vcolor") + "</td>");
				s = s.append("<td>" + rs.getFloat("Vprice") + "</td>");
				s = s.append("<td>" + rs.getString("Sdate") + "</td>");
				s = s.append("<td>" + rs.getInt("Samount") + "</td>");
				s = s.append("<td>" + rs.getString("Cname") + "</td>");
				s = s.append("<td>" + rs.getString("Sname") + "</td>");
				s = s.append("</tr>");
			}
			s = s.append("</table>");
			// �ر�����
			rs.close();
			return s;
		}

	// ��Ա�������ѯ������Ϣ
	public StringBuilder search_sale_byS(String sql) throws Exception {
		StringBuilder s = new StringBuilder();
		ResultSet rs = getRs(sql);
		s = s.append("<table id=\"theTable\" width='100%'>");
		s = s.append("<thead>");
		s = s.append("<tr>");
		s = s.append("<th>" + "����");
		s = s.append("<th>" + "����");
		s = s.append("<th>" + "�Ա�");
		s = s.append("<th>" + "����");
		s = s.append("<th>" + "��ַ");
		s = s.append("<th>" + "ѧ��");
		s = s.append("<th>" + "��������");
		s = s.append("<th>" + "�����۶�");
		s = s.append("</tr>");
		s = s.append("</thead>");
		// ѭ�����ÿһ����¼
		while (rs.next()) {
			// ���ÿ���ֶ�
			s = s.append("<tr>");
			s = s.append("<td>" + rs.getString("Sid") + "</td>");
			s = s.append("<td>" + rs.getString("Sname") + "</td>");
			s = s.append("<td>" + rs.getString("Sgender") + "</td>");
			s = s.append("<td>" + rs.getFloat("Sage") + "</td>");
			s = s.append("<td>" + rs.getString("Saddress") + "</td>");
			s = s.append("<td>" + rs.getString("Seducation") + "</td>");
			s = s.append("<td>" + rs.getString("saleamount") + "</td>");
			s = s.append("<td>" + rs.getString("totalprice") + "</td>");
			s = s.append("</tr>");
		}
		s = s.append("</table>");
		// �ر�����
		rs.close();
		return s;
	}

	// �����̷����ѯ������Ϣ
	public StringBuilder search_sale_byM(String sql) throws Exception {
		StringBuilder s = new StringBuilder();
		ResultSet rs = getRs(sql);
		s = s.append("<table id=\"theTable\" width='100%'>");
		s = s.append("<thead>");
		s = s.append("<tr>");
		s = s.append("<th>" + "��������");
		s = s.append("<th>" + "��������");
		s = s.append("<th>" + "�����۶�");
		s = s.append("</tr>");
		s = s.append("</thead>");
		// ѭ�����ÿһ����¼
		while (rs.next()) {
			// ���ÿ���ֶ�
			s = s.append("<tr>");
			s = s.append("<td>" + rs.getString("Vmanu") + "</td>");
			s = s.append("<td>" + rs.getString("saleamount") + "</td>");
			s = s.append("<td>" + rs.getString("totalprice") + "</td>");
			s = s.append("</tr>");
		}
		s = s.append("</table>");
		// �ر�����
		rs.close();
		return s;
	}

	// ��ѯ���а� 1.
	public StringBuilder search_phb_amout(String sql)throws Exception {
		StringBuilder s = new StringBuilder();
		int count=1;//ͳ������
		int pre_ranking=1;//ǰһ������
		int ranking=1;//��ǰ����
		int pre_amount=0;//ǰһλ��������
		int amount=0;//��ǰ��������
		ResultSet rs = getRs(sql);
		s = s.append("<table  width='100%'>");
		s = s.append("<thead>");
		s = s.append("<tr>");
		s = s.append("<th>" + "����");//
		s = s.append("<th>" + "����");
		s = s.append("<th>" + "����");
		s = s.append("<th>" + "��������");
		s = s.append("</tr>");
		s = s.append("</thead>");
		// ѭ�����ÿһ����¼
		while (rs.next()) {
			// ���ÿ���ֶ�
			s = s.append("<tr>");
			amount=Integer.parseInt(rs.getString("saleamount"));
			if(amount==pre_amount)
			{
				s = s.append("<td>" + pre_ranking+ "</td>");
				ranking=pre_ranking;
			}
			else
			{
				s = s.append("<td>" + count+ "</td>");
				ranking=count;
			}
			s = s.append("<td>" + rs.getString("Sid") + "</td>");
			s = s.append("<td>" + rs.getString("Sname") + "</td>");
			s = s.append("<td>" + rs.getString("saleamount") + "</td>");
			s = s.append("</tr>");
			pre_amount=amount;
			pre_ranking=ranking;
			count++;
		}
		s = s.append("</table>");
		// �ر�����
		rs.close();
		return s;
	}
	// ��ѯ���а� 2.
		public StringBuilder search_phb_price(String sql)throws Exception {
			StringBuilder s = new StringBuilder();
			int count=1;//ͳ������
			int pre_ranking=1;//ǰһ������
			int ranking=1;//��ǰ����
			double pre_price=0;//ǰһλ�����۶�
			double price=0;//��ǰ�����۶�
			ResultSet rs = getRs(sql);
			s = s.append("<table  width='100%'>");
			s = s.append("<thead>"); 
			s = s.append("<tr>");
			s = s.append("<th>" + "����");//
			s = s.append("<th>" + "����");
			s = s.append("<th>" + "����");
			s = s.append("<th>" + "�����۶�");
			s = s.append("</tr>");
			s = s.append("</thead>");
			// ѭ�����ÿһ����¼
			while (rs.next()) {
				// ���ÿ���ֶ�
				s = s.append("<tr>");
				price=Double.parseDouble(rs.getString("totalprice"));
				if(price==pre_price)
				{
					s = s.append("<td>" + pre_ranking+ "</td>");
					ranking=pre_ranking;
				}
				else
				{
					s = s.append("<td>" + count+ "</td>");
					ranking=count;
				}
				s = s.append("<td>" + rs.getString("Sid") + "</td>");
				s = s.append("<td>" + rs.getString("Sname") + "</td>");
				s = s.append("<td>" + rs.getString("totalprice") + "</td>");
				s = s.append("</tr>");
				pre_price=price;
				pre_ranking=ranking;
				count++;
			}
			s = s.append("</table>");
			// �ر�����
			rs.close();
			return s;
		}
}
