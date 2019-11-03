package website;


public class Profile{
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String[] getDescription() {
		return description;
	}

	public void setDescription(String[] description) {
		this.description = description;
	}
	
	public String getName() {
		return this.description[0];
	}
	
	public String getAge() {
		return this.description[1];
	}
	
	public String getGender() {
		return this.description[2];
	}
	
	public String getSyndrome() {
		return this.description[3];
	}
	
	public String getDiagnosis() {
		return this.description[4];
	}
	
	public void setName(String name) {
		this.description[0] = name;
	}
	
	public void setAge(String age) {
		this.description[1] = age;
	}
	
	public void setGender(String gender) {
		this.description[2] = gender;
	}
	
	public void setSyndrome(String syndrome) {
		this.description[3] = syndrome;
	}
	
	public void setDiagnosis(String diagnosis) {
		this.description[4] = diagnosis;
	}

	private int pid;
	private String[] description;
	
	public Profile(int pid, String[] description){
		this.pid = pid;
		this.description = description;
	}
	
}