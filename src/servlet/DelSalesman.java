package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.InsDelUpd;
import business.Search;

/**
 * Servlet implementation class DelSalesman
 */
@WebServlet("/DelSalesman")
public class DelSalesman extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelSalesman() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		Search search=new Search();
		InsDelUpd delete=new InsDelUpd();
		StringBuilder s = new StringBuilder();
		String name=request.getParameter("name");
		out.println("<HTML>");
		out.println("<HEAD><meta http-equiv='Content-Type' content='text/html; charset=gb2312'><link rel='stylesheet' href='Business/script04.css'><script src='JavaScript/checkDelnull.js'></script><script src='Business/jQuery.js'></script><script src='Business/jquery/jquery.tablesorter.js'></script><script src='Business/script05.js'></script><style type='text/css'>.style1 {font-family: '�����п�'; font-size: 24px; font-style: normal; color: #666666; }.style2 {font-family: Arial, Helvetica, sans-serif; font-size: 12px; font-style: normal; color: #006666; }</style></HEAD>");
		out.println("<BODY>");
		out.println("<p align='center' class='style1'>ɾ��Ա����Ϣ</p>");
		out.println("<form id=\"form1\" name=\"form1\" action='DelSalesman'><p class='style2'>������Ҫɾ����Ա��������<input name='name' type='text' size='12'/><input type='button' value='ɾ��' onclick='checkDelnull();'/></p></form>");
		if(name!=null)
		{
			byte b[]=name.getBytes("ISO-8859-1");//��������ת��������
	    	name=new String(b);
			String sql="delete from salesman where Sname='"+name+"'";
			try {
				if(delete.doIDU(sql))
					out.print("<script language=javascript>alert('ɾ���ɹ���');</script>");
				else
					out.print("<script language=javascript>alert('�����ڸ�Ա����');</script>");
				out.print(s);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			s=search.search_salesman("select * from V_sman");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(s);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
