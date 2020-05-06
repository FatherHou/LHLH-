package SimpleTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author lxb
 *
 */
public class SimpleTagCounter extends SimpleTagSupport{
	
	private static int counter = 1;

	public static int getCounter() {
		return counter;
	}

	public static void setCounter() {
		counter++;
		
	}
	public void doTag()throws JspException, IOException{
		getJspContext().getOut().println(counter);
		
		setCounter();
	}

}
