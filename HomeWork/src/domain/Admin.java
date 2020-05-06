/**
 * 
 */
package domain;

/**
 * @author Lenovo
 *
 */
public class Admin {
	private int admin_id;//ID
	private String admin_phone;//ÕËºÅ
	private String admin_password;//ÃÜÂë
	private String actor;//½ÇÉ«
	private String admin_name;//Ãû×Ö
	public Admin(String phone, String password, int id, String name) {
		// TODO Auto-generated constructor stub
		super();
		this.admin_phone = phone ;
		this.admin_password = password;
		this.admin_id = id;
		this.admin_name = name;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	/**
	 * @return the admin_id
	 */
	public int getAdmin_id() {
		return admin_id;
	}
	/**
	 * @param admin_id the admin_id to set
	 */
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	/**
	 * @return the admin_phone
	 */
	public String getAdmin_phone() {
		return admin_phone;
	}
	/**
	 * @param admin_phone the admin_phone to set
	 */
	public void setAdmin_phone(String admin_phone) {
		this.admin_phone = admin_phone;
	}
	/**
	 * @return the admin_password
	 */
	public String getAdmin_password() {
		return admin_password;
	}
	/**
	 * @param admin_password the admin_password to set
	 */
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
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
