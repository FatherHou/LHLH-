package domain;

public class Answer {
	private int answer_id;//答案ID
	private int question_id;//问题ID
	private String answer_text;//答案文本
	private int option_id;//对应选项ID
	/**
	 * @return the answer_id
	 */
	public int getAnswer_id() {
		return answer_id;
	}
	/**
	 * @param answer_id the answer_id to set
	 */
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
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
	 * @return the answer_text
	 */
	public String getAnswer_text() {
		return answer_text;
	}
	/**
	 * @param answer_text the answer_text to set
	 */
	public void setAnswer_text(String answer_text) {
		this.answer_text = answer_text;
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
	

}
