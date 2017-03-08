package spittr;

public class Spitter {
	private long id;
	private String fullName;
	private String email;
	private String username;
	private String password;
	private boolean updateByEmail;

	public Spitter() {

	}

	public Spitter(long id, String fullName, String email, String username, String password, boolean updateByEmail) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.updateByEmail = updateByEmail;
	}

	public long getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean isUpdateByEmail() {
		return updateByEmail;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUpdateByEmail(boolean updateByEmail) {
		this.updateByEmail = updateByEmail;
	}
}
