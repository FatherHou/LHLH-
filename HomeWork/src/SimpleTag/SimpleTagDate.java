package SimpleTag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author lxb
 *
 */
public class SimpleTagDate extends SimpleTagSupport{
	
	private static String date = null;

	
	/**
	 * @return the date
	 */
	public static String getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public static void setDate(String date) {
		SimpleTagDate.date = date;
	}


	public void doTag()throws JspException, IOException{
		Calendar cal=Calendar.getInstance();
		java.util.Date now=cal.getTime();
		date =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now);
		getJspContext().getOut().println(date);
		
		setDate(date);
	}

}