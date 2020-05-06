/**
 * 
 */
package domain;

/**
 * @author Lenovo
 *
 */
public class Survey {
	
	private int survey_id;//问卷ID
	private String title;//问卷标题
	private String description;//问卷说明
	private String state;//问卷状态
	private String link;//问卷链接
	private int user_id;//对应发起人
	
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
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
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	

}
