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
 * Servlet implementation class DelSale
 */
@WebServlet("/DelSale")
public class DelSale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelSale() {
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
		String number=request.getParameter("name");
		out.println("<HTML>");
		out.println("<HEAD><meta http-equiv='Content-Type' content='text/html; charset=gb2312'><link rel='stylesheet' href='Business/script04.css'><script src='JavaScript/checkDelnull.js'></script><script src='Business/jQuery.js'></script><script src='Business/jquery/jquery.tablesorter.js'></script><script src='Business/script05.js'></script><style type='text/css'>.style1 {font-family: '华文行楷'; font-size: 24px; font-style: normal; color: #666666; }.style2 {font-family: Arial, Helvetica, sans-serif; font-size: 12px; font-style: normal; color: #006666; }</style></HEAD>");
		out.println("<BODY>");
		out.println("<p align='center' class='style1'>删除销售记录</p>");
		out.println("<form id=\"form1\" name=\"form1\" action='DelSale'><p class='style2'>请输入要删除的销售流水号：<input name='name' type='text' size='12'/><input type='button' value='删除' onclick='checkDelnull();'/></p></form>");
		if(number!=null)
		{
			byte b[]=number.getBytes("ISO-8859-1");//必须先做转换！！！
			number=new String(b);
			String sql="delete from sale where Snum='"+number+"'";
			try {
				if(delete.doIDU(sql))
					out.print("<script language=javascript>alert('删除成功！');</script>");
				else
					out.print("<script language=javascript>alert('不存在该销售记录！');</script>");
				out.print(s);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			s=search.search_sale("select * from V_sale");
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
