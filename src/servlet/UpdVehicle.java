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
 * Servlet implementation class UpdVehicle
 */
@WebServlet("/UpdVehicle")
public class UpdVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdVehicle() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public static String change(String s) throws Exception {
		byte b[] = s.getBytes("ISO-8859-1");// ��������ת��������
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
		String model = request.getParameter("model");
		String color = request.getParameter("color");
		String manu = request.getParameter("manu");
		String date = request.getParameter("date");
		String price = request.getParameter("price");
		String vnum= request.getParameter("id");
		out.println("<HTML>");
		out.println("<HEAD><meta http-equiv='Content-Type' content='text/html; charset=gb2312'><link rel=\"stylesheet\" type=\"text/css\" href=\"test.css\"><script src='JavaScript/checkUpdnull.js'></script><script src='JavaScript/doUpdVehicle.js'></script><style type='text/css'>.style1 {font-family: '�����п�'; font-size: 24px; font-style: normal; color: #666666; }</style></HEAD>");
		out.println("<BODY>");
		out.println("<p align='center' class='style1'>�޸ĳ�����Ϣ</p>");
		out.println("<form id=\"form1\" name=\"form1\" action='UpdVehicle'>������Ҫ�޸ĵĳ�����ţ�<input name='id' type='text' size='12'/>");
		out.println("<input type='button' value='ȷ��' onclick='checkUpdnull();'/></form>");
		if (vnum != null && model == null) {
			try {
				ResultSet rs = search.getRs("select * from V_vcle where Vnum='"
						+ vnum + "'");
				if (rs.next()) {    //���ж��Ƿ���ڣ�
					out.print("<form id=\"form2\" name=\"form2\" action='UpdVehicle'> ");
					out.print("<table width=\"29%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">");
					out.print(" <tr><td width=\"18%\">��ţ�</td><td width=\"82%\"><label><input name=\"id\" type=\"text\"  readonly=\"readonly\" value=\""
							+ vnum + "\"/></label></td></tr>");
					out.print(" <tr><td >�ͺţ�</td><td ><label><input name=\"model\" type=\"text\" value=\""
							+ rs.getString("Vmodel") + "\"/></label></td></tr>");
					out.print("<tr><td>��ɫ��</td><td><input name=\"color\" type=\"text\"  value=\""
							+ rs.getString("Vcolor") + "\" /></td></tr>");
					out.print("<tr><td>�������̣�</td><td><input name=\"manu\" type=\"text\" value=\""
							+ rs.getString("Vmanu") + "\" /></td></tr>");
					out.print("<tr><td>������ݣ�</td><td><input name=\"date\" type=\"text\" value=\""
							+ rs.getString("Vdate") + "\" /></td></tr>");
					out.print("<tr><td>�۸�</td><td><input name=\"price\" type=\"text\" value=\""
							+ rs.getString("Vprice") + "\" /></td></tr>");
					out.print("<tr><td></td><td><input type=\"button\" value=\"�޸�\" onclick='doUpdVehicle();'/></td></tr>");
					out.print("</table></form");
				} else
					out.print("<script language=javascript>alert('�����ڸó�����');</script>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else if (vnum != null && model != null && color != null && manu != null && date != null && price != null) {
			try {// ������ת�� ��Ȼ����
				model = change(model);
				color = change(color);
				manu = change(manu);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String sql = "update vehicle set Vmodel='" + model + "',Vcolor='"
					+ color + "',Vmanu='" + manu + "',Vdate='" + date
					+ "',Vprice='" + price + "' where Vnum='" + vnum
					+ "'";
			try {
				if (update.doIDU(sql))
					out.print("<script language=javascript>alert('�޸ĳɹ���');</script>");
				else
					out.print("<script language=javascript>alert('�޸�ʧ�ܣ�');</script>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print("<script language=javascript>alert('�޸�ʧ�ܣ�');</script>");
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
