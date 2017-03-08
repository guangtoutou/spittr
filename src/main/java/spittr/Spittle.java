package spittr;

import java.util.Date;

public class Spittle {
	private final Long id;
	private final String message;
	private final Date time;
	private Spitter spitter;

	public Spitter getSpitter() {
		return spitter;
	}

	public Spittle(long id, String message, Date time, Spitter spitter) {
		this.id = id;
		this.message = message;
		this.time = time;
		this.spitter = spitter;

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

	@Override
	public boolean equals(Object that) {
		return true;
		// return EqualsBuilder.reflectionEquals(this, that,"id","time");
	}
}
