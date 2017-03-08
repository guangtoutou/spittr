package spittr;

import java.util.Date;

public class Spittle {
	private Long id;
	private String message;
	private Date time;
	private Spitter spitter;

	public Spittle(long id, String message, Date time, Spitter spitter) {
		this.id = id;
		this.message = message;
		this.time = time;
		this.spitter = spitter;

	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setSpitter(Spitter spitter) {
		this.spitter = spitter;
	}

	public Spittle() {
	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public Date getTime() {
		return time;
	}

	public Spitter getSpitter() {
		return spitter;
	}

	@Override
	public boolean equals(Object that) {
		return true;
		// return EqualsBuilder.reflectionEquals(this, that,"id","time");
	}
}
