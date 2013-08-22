package business;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fordate {
	public static SimpleDateFormat sy1 = new SimpleDateFormat("yyyyMM");
	
	public static String getNow_date()
	{
		return sy1.format(new Date());
	}
	
	public static String getPre_date()
	{
		String previous_date;
		String now_date = sy1.format(new Date());
		int year= Integer.parseInt(now_date.substring(0,4));
		int month= Integer.parseInt(now_date.substring(4,6));
		if ((month - 2) <= 0) {
			month = month + 12 - 2;
			year = year - 1;
		} else {
			month = month - 2;
		}
		if (month < 10) {
			previous_date = String.valueOf(year) +0+ String.valueOf(month);
		}
		else
			previous_date = String.valueOf(year) + String.valueOf(month);
		return previous_date;
	}
	public static String Change(String date)
	{
		String newDate=date.substring(6, 10)+date.substring(0, 2)+date.substring(3, 5);
		return newDate;
	}
	
	public static String ChangeBack(String date)
	{
		String newDate=date.substring(4, 6)+"/"+date.substring(6, 8)+"/"+date.substring(0, 4);
		return newDate;
	}
}
