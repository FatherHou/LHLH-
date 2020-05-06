/**
 * 
 */
package domain;

/**
 * @author Lenovo
 *
 */
public class Option {
	
	private int option_id;//选项ID
	private int question_id;//问题ID
	private String option_text;//选项的具体文本
	private int option_no;
	private String sum;//选项总数量
	
	/**
	 * @return the sum
	 */
	public String getSum() {
		return sum;
	}
	/**
	 * @param sum the sum to set
	 */
	public void setSum(String sum) {
		this.sum = sum;
	}
	/**
	 * @return the option_id
	 */
	public int getOption_id() {
		return option_id;
	}
	/**
	 * @param option_id the option_id to set
	 */
	public void setOption_id(int option_id) {
		this.option_id = option_id;
	}
	/**
	 * @return the question_id
	 */
	public int getQuestion_id() {
		return question_id;
	}
	/**
	 * @param question_id the question_id to set
	 */
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	/**
	 * @return the option_text
	 */
	public String getOption_text() {
		return option_text;
	}
	/**
	 * @param option_text the option_text to set
	 */
	public void setOption_text(String option_text) {
		this.option_text = option_text;
	}
	/**
	 * @return the option_no
	 */
	public int getOption_no() {
		return option_no;
	}
	/**
	 * @param option_no the option_no to set
	 */
	public void setOption_no(int option_no) {
		this.option_no = option_no;
	}
	
	

}
