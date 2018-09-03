package michel.zarpelon;

public class Results {
	private String formatted_address;
	private Geometry geometry;
	
	public Results(String formatted_address, Geometry geometry) {
		super();
		this.formatted_address = formatted_address;
		this.geometry = geometry;
	}

	public Results() {
		super();
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Results [formatted_address=").append(formatted_address).append(", geometry=").append(geometry)
				.append("]");
		return builder.toString();
	}
	
	
}
