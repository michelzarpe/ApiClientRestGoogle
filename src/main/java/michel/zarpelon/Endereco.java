package michel.zarpelon;

import java.util.List;

public class Endereco {
	private List<Results> results;

	public Endereco(List<Results> results) {
		super();
		this.results = results;
	}

	public Endereco() {
		super();
	}

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Endereco [results=").append(results).append("]");
		return builder.toString();
	}
	
	
}