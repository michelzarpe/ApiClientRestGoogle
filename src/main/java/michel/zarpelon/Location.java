package michel.zarpelon;

public class Location {

	private Double lat;
	private Double lng;
	
	public Location(Double lat, double lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}

	public Location() {
		super();
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Location [lat=").append(lat).append(", lng=").append(lng).append("]");
		return builder.toString();
	}
	
}
