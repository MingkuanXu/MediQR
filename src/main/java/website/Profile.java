package website;


public class Profile{
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private int pid;
	private String description;
	
	public Profile(int pid, String description){
		this.pid = pid;
		this.description = description;
	}
	
}