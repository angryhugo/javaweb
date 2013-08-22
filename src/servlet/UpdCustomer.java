package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Search;
import business.InsDelUpd;

/**
 * Servlet implementation class UpdCustomer
 */
@WebServlet("/UpdCustomer")
public class UpdCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static String change(String s) throws Exception {
		byte b[] = s.getBytes("ISO-8859-1");// 必须先做转换！！！
		String snew = new String(b);
		return snew;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		Search search = new Search();
		InsDelUpd update = new InsDelUpd();
		String name = request.getParameter("name");
		String gender = request.getParameter("genderselect");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String cid = request.getParameter("id");
		out.println("<HTML>");
		out.println("<HEAD><meta http-equiv='Content-Type' content='text/html; charset=gb2312'><link rel=\"stylesheet\" type=\"text/css\" href=\"test.css\"><script src='JavaScript/checkUpdnull.js'></script><script src='JavaScript/doUpdCustomer.js'></script><style type='text/css'>.style1 {font-family: '华文行楷'; font-size: 24px; font-style: normal; color: #666666; }</style></HEAD>");
		out.println("<BODY>");
		out.println("<p align='center' class='style1'>修改客户信息</p>");
		out.println("<form id=\"form1\" name=\"form1\" action='UpdCustomer'>请输入要修改的客户编号：<input name='id' type='text' size='12'/>");
		out.println("<input type='button' value='确定' onclick='checkUpdnull();'/></form>");
		if (cid != null && name == null) {
			try {
				ResultSet rs = search.getRs("select * from V_cmer where Cid='"
						+ cid + "'");
				if (rs.next()) {    //先判断是否存在！
					out.print("<form id=\"form2\" name=\"form2\" action='UpdCustomer'> ");
					out.print("<table width=\"29%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">");
					out.print(" <tr><td width=\"18%\">编号：</td><td width=\"82%\"><label><input name=\"id\" type=\"text\"  readonly=\"readonly\" value=\""
							+ cid + "\"/></label></td></tr>");
					out.print(" <tr><td >姓名：</td><td ><label><input name=\"name\" type=\"text\" value=\""
							+ rs.getString("Cname") + "\"/></label></td></tr>");
					if (rs.getString("Cgender").trim().equals("M"))// 此处必须用trim函数去掉多余的空格！！！
						out.print("<tr><td>性别：</td><td><select name='genderselect' size='1' id='select'><option value='M' selected='selected'>男</option><option value='F'>女</option></select></td></tr>");
					else
						out.print("<tr><td>性别：</td><td><select name='genderselect' size='1' id='select'><option value='M'>男</option><option value='F' selected='selected'>女</option></select></td></tr>");
					out.print("<tr><td>年龄：</td><td><input name=\"age\" type=\"text\" size=\"1\" value=\""
							+ rs.getString("Cage") + "\" /></td></tr>");
					out.print("<tr><td>联系方式：</td><td><input name=\"contact\" type=\"text\" value=\""
							+ rs.getString("Ccontact") + "\" /></td></tr>");
					out.print("<tr><td>地址：</td><td><input name=\"address\" type=\"text\" value=\""
							+ rs.getString("Caddress") + "\" /></td></tr>");
					out.print("<tr><td></td><td><input type=\"button\" value=\"修改\" onclick='doUpdCustomer();'/></td></tr>");
					out.print("</table></form");
				} else
					out.print("<script language=javascript>alert('不存在该客户！');</script>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (cid != null && name != null && gender != null && age != null
				&& address != null && contact != null) {
			try {// 必须做转换 不然乱码
				name = change(name);
				address = change(address);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String sql = "update customer set Cname='" + name + "',Cage='"
					+ age + "',Cgender='" + gender + "',Caddress='" + address
					+ "',Ccontact='" + contact + "' where Cid='" + cid
					+ "'";
			try {
				if (update.doIDU(sql))
					out.print("<script language=javascript>alert('修改成功！');</script>");
				else
					out.print("<script language=javascript>alert('修改失败！');</script>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print("<script language=javascript>alert('修改失败！');</script>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
