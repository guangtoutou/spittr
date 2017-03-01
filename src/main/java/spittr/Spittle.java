package spittr;

import java.util.Date;

public class Spittle {
	private final Long id;
	private final String message;
	private final Date time;
	private Double latitude;
	private Double longitude;

	public Spittle(String message, Date time) {
		this(message, time, null, null);
	}

	public Spittle(String message, Date time, Double longtitude, Double latitude) {
		this.id = null;
		this.message = message;
		this.time = time;
		this.longitude = longtitude;
		this.latitude = latitude;
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

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}
	
	@Override
	public boolean equals(Object that){
		return true;
		//return EqualsBuilder.reflectionEquals(this, that,"id","time");
	}
}