package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Fordate;
import business.Search;

/**
 * Servlet implementation class QuerySale
 */
@WebServlet("/QuerySale")
public class QuerySale extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuerySale() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Search search = new Search();
		StringBuilder s = new StringBuilder();
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		String date = request.getParameter("dateselect");
		String sname = request.getParameter("sname");
		String cname = request.getParameter("cname");
		out.println("<HTML>");
		out.println("<HEAD><meta http-equiv='Content-Type' content='text/html; charset=gb2312'><link rel='stylesheet' href='Business/script04.css'><script src='Business/jQuery.js'></script><script src='Business/jquery/jquery.tablesorter.js'></script><script src='Business/script05.js'></script><style type='text/css'>.style1 {font-family: '�����п�'; font-size: 24px; font-style: normal; color: #666666; }.style2 {font-family: Arial, Helvetica, sans-serif; font-size: 12px; font-style: normal; color: #006666; }</style></HEAD>");
		out.println("<BODY>");
		out.println("<p align='center' class='style1'>���ۼ�¼�Զ����ѯ</p>");
		out.println("<form action='QuerySale'><p class='style2'>�������ڣ�<select name='dateselect' size='1' id='select'><option value='omonth'>����</option><option value='tmonth'>��������<option value='all'  selected='selected'>����</option></select>");
		out.println("����Ա�����ؼ��֣�<input name='sname' type='text' size='12'/>");
		out.println("�ͻ������ؼ��֣�<input name='cname' type='text' size='12'/>");
		out.println("<input type='submit' value='��ѯ' /></p></form>");
		
		if (date != null && sname != null && cname != null) 
		{
			byte sn[] = sname.getBytes("ISO-8859-1");// ��������ת��������
			sname = new String(sn);
			byte cn[] = cname.getBytes("ISO-8859-1");
			cname = new String(cn);
			String youroption = "<p class='style2'>����ѡ������Ա�����ؼ��֣�<font color=\"#36F\">"+sname+"</font> �ͻ������ؼ��֣�<font color=\"#36F\">"+cname+"</font>";
			String sql = "select * from V_Sale where Sname like '%"+sname+"%' and Cname like '%"+cname+"%' and ";
			if (date.equals("omonth")) {
				sql = sql + "left(Sdate,6)= '" + Fordate.getNow_date() + "'";
				youroption = youroption + "�������ڣ�<font color=\"#36F\">����</font></p>";
			} else if (date.equals("tmonth")) {
				sql = sql + "left(Sdate,6) between '" + Fordate.getPre_date()
						+ "' and '" + Fordate.getNow_date() + "'";
				youroption = youroption + "�������ڣ�<font color=\"#36F\">��������</font></p>";
			} else if (date.equals("all")) {
				sql=sql+"Sdate is not null";
				youroption = youroption + "�������ڣ�<font color=\"#36F\">����</font></p>";
			}
			try {
				s=search.search_sale(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.print(youroption);
			out.print(s);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
