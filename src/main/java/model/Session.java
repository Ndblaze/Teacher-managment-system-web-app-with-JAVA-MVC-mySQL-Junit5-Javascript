package model;

public class Session {
	private int id;
	private String group;
	private String module;
	private String date;
	private String present;
	private String firstname;
	private String lastname;
    private int student; 
	
	public Session() {
		super();
	}
	
	public String getModuleName() {
		return module;
	}

	public void setModuleName(String module) {
		this.module = module;
	}
	
	public int getStudent() {
		return student ; 
	}
	
	public void setStudent(int student) {
			
		this.student = student ; 
	}

	public int getIdsession() {
		return id;
	}

	public void setIdsession(int id) {
		this.id = id;
	}
	
	public String getGroupName() {
		return group;
	}

	public void setGroupName(String group) {
		this.group = group;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}	
	
	public String getPresent() {
		return present;
	}
	
	public void setPresent(String present) {
		this.present = present;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date ;
	}
}
