package michel.zarpelon;

public class Geometry {
	private Location location;

	public Geometry(Location location) {
		super();
		this.location = location;
	}

	public Geometry() {
		super();
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Geometry [location=").append(location).append("]");
		return builder.toString();
	}
	
	
}
