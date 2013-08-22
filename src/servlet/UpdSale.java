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
import business.Fordate;


/**
 * Servlet implementation class UpdSale
 */
@WebServlet("/UpdSale")
public class UpdSale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdSale() {
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
		String sname = request.getParameter("sname");
		String cname = request.getParameter("cname");
		String vnum = request.getParameter("vnum");
		String sdate = request.getParameter("sdate");
		String amount = request.getParameter("amount");
		String snum= request.getParameter("id");
		out.println("<HTML>");
		out.println("<HEAD><meta http-equiv='Content-Type' content='text/html; charset=gb2312'><script src='Business/jQuery.js'></script><link rel='stylesheet' href='Business/jquery-ui/jquery-ui-1.9.2.custom.css'><script src='Business/jquery-ui/jquery-1.8.3.js'></script><script src='Business/jquery-ui/jquery-ui-1.9.2.custom.js'></script><script src='Business/jquery-ui/calendar.js'></script><link rel=\"stylesheet\" type=\"text/css\" href=\"test.css\"><script src='JavaScript/checkUpdnull.js'></script><script src='JavaScript/doUpdSale.js'></script><style type='text/css'>.style1 {font-family: '华文行楷'; font-size: 24px; font-style: normal; color: #666666; }</style></HEAD>");
		out.println("<BODY>");
		out.println("<p align='center' class='style1'>修改销售记录</p>");
		out.println("<form id=\"form1\" name=\"form1\" action='UpdSale'>请输入要修改的销售流水号：<input name='id' type='text' size='12'/>");
		out.println("<input type='button' value='确定' onclick='checkUpdnull();'/></form>");
		if (snum != null && sname == null) {
			try {
				ResultSet rs = search.getRs("select * from V_sale where Snum='"
						+snum + "'");
				if (rs.next()) {    //先判断是否存在！
					out.print("<form id=\"form2\" name=\"form2\" action='UpdSale'> ");
					out.print("<table width=\"29%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">");
					out.print(" <tr><td width=\"18%\">流水号：</td><td width=\"82%\"><label><input name=\"id\" type=\"text\"  readonly=\"readonly\" value=\""
							+ snum + "\"/></label></td></tr>");
					out.print(" <tr><td >销售员：</td><td ><label><input name=\"sname\" type=\"text\" value=\""
							+ rs.getString("Sname") + "\"/></label></td></tr>");
					out.print("<tr><td>客户：</td><td><input name=\"cname\" type=\"text\"  value=\""
							+ rs.getString("Cname") + "\" /></td></tr>");
					out.print("<tr><td>车辆编号：</td><td><input name=\"vnum\" type=\"text\" value=\""
							+ rs.getString("Vnum") + "\" /></td></tr>");
					out.print("<tr><td>销售日期：</td><td><input name=\"sdate\" id=\"sdate\" type=\"text\" value=\""
							+ Fordate.ChangeBack(rs.getString("Sdate")) + "\" /></td></tr>");
					out.print("<tr><td>数量：</td><td><input name=\"amount\" type=\"text\" value=\""
							+ rs.getString("Samount") + "\" /></td></tr>");
					out.print("<tr><td></td><td><input type=\"button\" value=\"修改\" onclick='doUpdSale();'/></td></tr>");
					out.print("</table></form");
				} else
					out.print("<script language=javascript>alert('不存在该销售记录！');</script>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else if (snum != null && sname != null && cname != null && vnum != null && sdate != null && amount != null) {
			try {// 必须做转换 不然乱码
				sname = change(sname);
				cname = change(cname);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				ResultSet rs_sname = search.getRs("select * from V_sman where Sname='"+sname+"'");
				ResultSet rs_cname = search.getRs("select * from V_cmer where Cname='"+cname+"'");
				ResultSet rs_vnum = search.getRs("select * from V_vcle where Vnum='"+vnum+"'");
				if(rs_sname.next()&&rs_cname.next()&&rs_vnum.next())
				{
					String sid=rs_sname.getString("Sid");
					String cid=rs_cname.getString("Cid");
					String sql = "update sale set Sid='" + sid + "',Cid='"
							+ cid + "',Vnum='" + vnum + "',Sdate='" + Fordate.Change(sdate)
							+ "',Samount='" + amount + "' where Snum='" + snum
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
				else
					out.print("<script language=javascript>alert('修改失败，请输入有效的信息！');</script>");
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
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
