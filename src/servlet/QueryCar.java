package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Search;

/**
 * Servlet implementation class QueryCar
 */
@WebServlet("/QueryCar")
public class QueryCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Search search = new Search();
		StringBuilder s = new StringBuilder();
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		String color = request.getParameter("colorselect");
		String manu = request.getParameter("manuselect");
		String year = request.getParameter("yearselect");
		String price = request.getParameter("priceselect");
		out.println("<HTML>");
		out.println("<HEAD><meta http-equiv='Content-Type' content='text/html; charset=gb2312'><link rel='stylesheet' href='Business/script04.css'><script src='Business/jQuery.js'></script><script src='Business/jquery/jquery.tablesorter.js'></script><script src='Business/script05.js'></script><style type='text/css'>.style1 {font-family: '�����п�'; font-size: 24px; font-style: normal; color: #666666; }.style2 {font-family: Arial, Helvetica, sans-serif; font-size: 12px; font-style: normal; color: #006666; }</style></HEAD>");
		out.println("<BODY>");
		out.println("<p align='center' class='style1'>������Ϣ�Զ����ѯ</p>");
		out.println("<form action='QueryCar'><p class='style2'>��ɫ��<select name='colorselect' size='1' id='select'><option value='black'>��ɫ</option><option value='white'>��ɫ</option><option value='silvery'>��ɫ</option><option value='else'>����</option><option value='all'  selected='selected'>����</option></select>");
		out.println("���̣�<select name='manuselect' size='1' id='select'><option value='benz'>����</option><option value='bmw'>����</option><option value='audi'>�µ�</option><option value='else'>����</option><option value='all'  selected='selected'>����</option></select>");
		out.println("������ݣ�<select name='yearselect' size='1' id='select'><option value='2009'>2009��ǰ</option><option value='2010'>2010-2011��</option><option value='2012'>2012���</option><option value='all'  selected='selected'>����</option></select>");
		out.println("�۸�<select name='priceselect' size='1' id='select'><option value='b50'>50������</option><option value='50'>50-100��</option><option value='u100'>100������</option><option value='all'  selected='selected'>����</option></select>");
		out.println("<input type='submit' value='��ѯ' /></p></form>");
		if (color != null && manu != null && year != null && price != null) {
			String sql = "select * from vehicle where ";
			String youroption = "<p class='style2'>����ѡ��";
			if (color.equals("black")) {
				sql = sql + "Vcolor='��ɫ'";
				youroption = youroption + "��ɫ��<font color=\"#36F\">��ɫ</font>";
			} else if (color.equals("white")) {
				sql = sql + "Vcolor='��ɫ'";
				youroption = youroption + "��ɫ��<font color=\"#36F\">��ɫ</font>";
			} else if (color.equals("silvery")) {
				sql = sql + "Vcolor='��ɫ'";
				youroption = youroption + "��ɫ��<font color=\"#36F\">��ɫ</font>";
			} else if (color.equals("else")) {
				sql = sql + "Vcolor not in('��ɫ','��ɫ','��ɫ')";
				youroption = youroption + "��ɫ��<font color=\"#36F\">����</font>";
			} else if (color.equals("all")) {
				sql = sql + "Vcolor is not null";
				youroption = youroption + "��ɫ��<font color=\"#36F\">����</font>";
			}

			if (manu.equals("benz")) {
				sql = sql + " and Vmanu='����'";
				youroption = youroption + " ���̣�<font color=\"#36F\">����</font>";
			} else if (manu.equals("bmw")) {
				sql = sql + " and Vmanu='����'";
				youroption = youroption + " ���̣�<font color=\"#36F\">����</font>";
			} else if (manu.equals("audi")) {
				sql = sql + " and Vmanu='�µ�'";
				youroption = youroption + " ���̣�<font color=\"#36F\">�µ�</font>";
			} else if (manu.equals("else")) {
				sql = sql + " and Vmanu not in ('����','����','�µ�')";
				youroption = youroption + " ���̣�<font color=\"#36F\">����</font>";
			} else if (manu.equals("all")) {
				sql = sql + " and Vmanu is not null";
				youroption = youroption + " ���̣�<font color=\"#36F\">����</font>";
			}

			if (year.equals("2009")) {
				sql = sql + " and Vdate<='2009'";
				youroption = youroption + " ������ݣ�<font color=\"#36F\">2009��ǰ</font>";
			} else if (year.equals("2010")) {
				sql = sql + " and Vdate between '2010' and '2011'";
				youroption = youroption + " ������ݣ�<font color=\"#36F\">2010-2011��</font>";
			} else if (year.equals("2012")) {
				sql = sql + " and Vdate>='2012'";
				youroption = youroption + " ������ݣ�<font color=\"#36F\">2012���</font>";
			} else if (year.equals("all")) {
				sql = sql + " and Vdate is not null";
				youroption = youroption + " ������ݣ�<font color=\"#36F\">����</font>";
			}

			if (price.equals("b50")) {
				sql = sql + " and Vprice<500000";
				youroption = youroption + " �۸�<font color=\"#36F\">50������</font></p>";
			} else if (price.equals("50")) {
				sql = sql + " and Vprice between 500000 and 1000000";
				youroption = youroption + " �۸�<font color=\"#36F\">50-100��</font></p>";
			} else if (price.equals("u100")) {
				sql = sql + " and Vprice>1000000";
				youroption = youroption + " �۸�<font color=\"#36F\">100������</font></p>";
			}else if (price.equals("all")) {
				sql = sql + " and Vprice is not null";
				youroption = youroption + " �۸�<font color=\"#36F\">����</font></p>";
			}

			try {
				s = search.search_vehicle(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.print(youroption);//StringBulider����ֱ����equals�ķ��� ����Ƚϵ��ǵ�ַ
			if(s.toString().equals("<table id=\"theTable\" width='100%'><thead><tr><th>���<th>�ͺ�<th>��ɫ<th>��������<th>��������<th>�۸�</tr></thead>"))
				out.print("<script language=javascript>alert('�Բ���û�з���ѡ��ĳ�����Ϣ��');</script>");
			else
				out.print(s);
		}

		out.println("<BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
