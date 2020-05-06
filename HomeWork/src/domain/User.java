package domain;

public class User {
	
	private int user_id;//ID
	private String user_phone;//手机账号
	private String user_password;//密码
	private String user_name;//名字
	private String user_bithday;//生日
	private String user_email;//email
	private String actor;//角色
	
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	public User(String user_phone, String user_password) {

		super();
		this.user_phone = user_phone;
		this.user_password = user_password;

	}
	public User() {
		super();
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the user_phone
	 */
	public String getUser_phone() {
		return user_phone;
	}
	/**
	 * @param user_phone the user_phone to set
	 */
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	/**
	 * @return the user_password
	 */
	public String getUser_password() {
		return user_password;
	}
	/**
	 * @param user_password the user_password to set
	 */
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}
	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	/**
	 * @return the user_bithday
	 */
	public String getUser_bithday() {
		return user_bithday;
	}
	/**
	 * @param user_bithday the user_bithday to set
	 */
	public void setUser_bithday(String user_bithday) {
		this.user_bithday = user_bithday;
	}
	/**
	 * @return the user_email
	 */
	public String getUser_email() {
		return user_email;
	}
	/**
	 * @param user_email the user_email to set
	 */
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	/**
	 * @return the actor
	 */
	public String getActor() {
		return actor;
	}
	/**
	 * @param actor the actor to set
	 */
	public void setActor(String actor) {
		this.actor = actor;
	}
	
	

}
