package business;

public class ForSearch_s extends Search {
	public StringBuilder queryOpition(String option) throws Exception
	{
		StringBuilder s=new StringBuilder();
		if(option.equals("CA"))
		{
			s=s.append("<p align='center' class='style1'>ȫ���ͻ���Ϣ</p>");
			s=s.append(search_customer_forS("select * from V_cmer"));
		}
		else if(option.equals("VA"))
		{
			s=s.append("<p align='center' class='style1'>ȫ��������Ϣ</p>");
			s=s.append(search_vehicle_forS("select * from V_vcle"));
		}
		else if(option.equals("VCB"))
		{
			s=s.append("<p align='center'  class='style1'>��ɫ������Ϣ</p>");
			s=s.append(search_vehicle_forS("select * from V_vcle_black"));
		}
		else if(option.equals("VCW"))
		{
			s=s.append("<p align='center'  class='style1'>��ɫ������Ϣ</p>");
			s=s.append(search_vehicle_forS("select * from V_vcle_white"));
		}
		else if(option.equals("VCS"))
		{
			s=s.append("<p align='center'  class='style1'>��ɫ������Ϣ</p>");
			s=s.append(search_vehicle_forS("select * from V_vcle_silvery"));
		}
		else if(option.equals("VCO"))
		{
			s=s.append("<p align='center'  class='style1'>������ɫ������Ϣ</p>");
			s=s.append(search_vehicle_forS("select * from V_vcle_cother"));
		}
		else if(option.equals("VMBenz"))
		{
			s=s.append("<p align='center'  class='style1'>���۳�����Ϣ</p>");
			s=s.append(search_vehicle_forS("select * from V_vcle_benz"));
		}
		else if(option.equals("VMBMW"))
		{
			s=s.append("<p align='center'  class='style1'>��������Ϣ</p>");
			s=s.append(search_vehicle_forS("select * from V_vcle_bmw"));
		}
		else if(option.equals("VMAUDI"))
		{
			s=s.append("<p align='center'  class='style1'>�µϳ�����Ϣ</p>");
			s=s.append(search_vehicle_forS("select * from V_vcle_audi"));
		}
		else if(option.equals("VMO"))
		{
			s=s.append("<p align='center'  class='style1'>����Ʒ�Ƴ�����Ϣ</p>");
			s=s.append(search_vehicle_forS("select * from V_vcle_omanu"));
		}
		else if(option.equals("VD1"))
		{
			s=s.append("<p align='center'  class='style1'>2009��ǰ����������Ϣ</p>");
			s=s.append(search_vehicle_forS("select * from V_vcle_date1"));
		}
		else if(option.equals("VD2"))
		{
			s=s.append("<p align='center'  class='style1'>2010-2011�����������Ϣ</p>");
			s=s.append(search_vehicle_forS("select * from V_vcle_date2"));
		}
		else if(option.equals("VD3"))
		{
			s=s.append("<p align='center'  class='style1'>2012������������Ϣ</p>");
			s=s.append(search_vehicle_forS("select * from V_vcle_date3"));
		}
		else if(option.equals("VP1"))
		{
			s=s.append("<p align='center'  class='style1'>50�����³�����Ϣ</p>");
			s=s.append(search_vehicle_forS("select * from V_vcle_price1"));
		}
		else if(option.equals("VP2"))
		{
			s=s.append("<p align='center'  class='style1'>50-100������Ϣ</p>");
			s=s.append(search_vehicle_forS("select * from V_vcle_price2"));
		}
		else if(option.equals("VP3"))
		{
			s=s.append("<p align='center'  class='style1'>100�����ϳ�����Ϣ</p>");
			s=s.append(search_vehicle_forS("select * from V_vcle_price3"));
		}
		
		else if (option.equals("SaPao")) {
			String sql = "select salesman.Sid,Sname,sum(sale.Samount)'saleamount' from salesman,sale where LEFT(sale.Sdate,6)= '"
					+ Fordate.getNow_date()
					+ "'and sale.Sid=salesman.Sid group by salesman.Sid,Sname order by saleamount desc";
			s = s.append("<p align='center'  class='style1'>�������������а�</p>");
			s = s.append(search_phb_amout(sql));
		}
        else if (option.equals("SaPat")) {
			String sql = "select salesman.Sid,Sname,sum(sale.Samount)'saleamount' from salesman,sale where LEFT(sale.Sdate,6) between '"
					+ Fordate.getPre_date()
					+ "' and '"
					+ Fordate.getNow_date()
					+ "'and sale.Sid=salesman.Sid group by salesman.Sid,Sname order by saleamount desc";
			s = s.append("<p align='center'  class='style1'>�����������������а�</p>");
			s = s.append(search_phb_amout(sql));
		}
		else if(option.equals("SaPaa"))
		{
			s=s.append("<p align='center'  class='style1'>ȫ�����������а�</p>");
			s=s.append(search_phb_amout("select * from V_phb_amount order by saleamount desc"));
		}
		else if(option.equals("SaPpo"))
		{
			String sql="select salesman.Sid,Sname,SUM(vehicle.Vprice*sale.Samount)'totalprice' from salesman,sale,vehicle where LEFT(sale.Sdate,6)= '"
					+ Fordate.getNow_date()
					+ "'and vehicle.Vnum=sale.Vnum and sale.Sid=salesman.Sid group by salesman.Sid,Sname order by totalprice desc";
			s=s.append("<p align='center'  class='style1'>�������۶����а�</p>");
			s=s.append(search_phb_price(sql));
		}
		else if(option.equals("SaPpt"))
		{
			String sql = "select salesman.Sid,Sname,SUM(vehicle.Vprice*sale.Samount)'totalprice' from salesman,sale,vehicle where LEFT(sale.Sdate,6) between '"
					+ Fordate.getPre_date()
					+ "' and '"
					+ Fordate.getNow_date()
					+ "'and vehicle.Vnum=sale.Vnum and sale.Sid=salesman.Sid group by salesman.Sid,Sname order by totalprice desc";
			s = s.append("<p align='center'  class='style1'>�����������۶����а�</p>");
			s = s.append(search_phb_price(sql));
		}
		else if(option.equals("SaPpa"))
		{
			s=s.append("<p align='center'  class='style1'>ȫ�����۶����а�</p>");
			s=s.append(search_phb_price("select * from V_phb_totalprice order by totalprice desc"));
		}
		return s;
	}
	
	//���� ������Ա��ѯ�й��Լ�����Ϣ
	public StringBuilder queryOpition(String option,String name) throws Exception{
		StringBuilder s=new StringBuilder();
		if(option.equals("Sao"))
		{
			s=s.append("<p align='center'  class='style1'>�������ۼ�¼��ϸ</p>");
			s=s.append(search_sale_forS("select * from V_sale where Sname='"+name+"' and LEFT(V_Sale.Sdate,6)='"+Fordate.getNow_date()+"'"));
		}
		else if(option.equals("Sat"))
		{
			s=s.append("<p align='center'  class='style1'>�����������ۼ�¼��ϸ</p>");
			s=s.append(search_sale_forS("select * from V_sale where Sname='"+name+"' and LEFT(V_Sale.Sdate,6) between '"+Fordate.getPre_date()+"' and '"+Fordate.getNow_date()+"'"));
		}
		else if(option.equals("Saa"))
		{
			s=s.append("<p align='center'  class='style1'>ȫ�����ۼ�¼��ϸ</p>");
			s=s.append(search_sale_forS("select * from V_sale where Sname='"+name+"'"));
		}
		//����Ŀͻ�
		else if(option.equals("CM"))
		{
			s=s.append("<p align='center'  class='style1'>����ͻ���Ϣ</p>");
			s=s.append(search_customer_forS("select distinct customer.Cid,Cname,Cgender,Cage,Ccontact,Caddress from customer,salesman,sale where sale.Cid=customer.Cid and sale.Sid=salesman.Sid and salesman.Sname='"+name+"'"));
		}
		return s;
	}

}
