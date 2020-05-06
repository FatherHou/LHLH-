/**
 * 
 */
package domain;

/**
 * @author Lenovo
 *
 */
public class Question {
	
	private int question_id;//问题ID
	private String question;//问题文本
	private String type;//问题类型
	private int survey_id;//对应问卷
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
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the survey_id
	 */
	public int getSurvey_id() {
		return survey_id;
	}
	/**
	 * @param survey_id the survey_id to set
	 */
	public void setSurvey_id(int survey_id) {
		this.survey_id = survey_id;
	}
	
	

}
