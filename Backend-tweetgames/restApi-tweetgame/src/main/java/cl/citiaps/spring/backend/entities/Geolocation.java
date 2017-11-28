package cl.citiaps.spring.backend.entities;


import javax.persistence.*;

@Entity
@Table(name="geolocalizacion")
@NamedQuery(name="Geolocation.findAll", query="SELECT g FROM Geolocation g")
public class Geolocation {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "radius", unique = false, nullable = false)
	private int radius;
	
	@Column(name = "country", unique = false, nullable = false)
	private String country;
	
	@Column(name = "significance", unique = false, nullable = false)
	private String significance;
	
	@Column(name = "date", unique = false, nullable = false)
	private String date;
	
	@Column(name = "latitude", unique = false, nullable = false)
	private float latitude;
	
	@Column(name = "longitude", unique = false, nullable = false)
	private float longitude;
	
	@Column(name = "fillkey", unique = false, nullable = false)
	private String fillKey;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSignificance() {
		return significance;
	}

	public void setSignificance(String significance) {
		this.significance = significance;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getFillKey() {
		return fillKey;
	}

	public void setFillKey(String fillKey) {
		this.fillKey = fillKey;
	}
	
	
	


}
