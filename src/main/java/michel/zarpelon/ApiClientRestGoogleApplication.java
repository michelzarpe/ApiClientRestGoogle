package michel.zarpelon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@SpringBootApplication
public class ApiClientRestGoogleApplication implements CommandLineRunner {
	public static final String SUA_KEY = "";

	public static void main(String[] args) {
		SpringApplication.run(ApiClientRestGoogleApplication.class, args);
	}

	@Override
	public void run(String... args) throws ClientProtocolException, IOException {
		Location local = this.getLatLon("Av. presidente Castelo Branco, 141, Centro, Herval D'Oeste, 896000 -SC");
		System.out.println(local.toString());
	}

	@SuppressWarnings("unused")
	private static void usandoJRS(String endereco) {
		Client c = Client.create();
		String enderecoConcatenado = retEnderecoConcatenado(endereco);
		WebResource resource = c.resource("https://maps.googleapis.com/maps/api/geocode/json?address=+"+enderecoConcatenado+"&key="+ SUA_KEY + "&language=pt-BR");
		String response = resource.get(String.class);
	}

	public static Location getLatLon(String endereco) throws ClientProtocolException, IOException {
		Double latitude = 0.0;
		Double longitude = 0.0;
		String enderecoConcatenado = retEnderecoConcatenado(endereco);
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet("https://maps.googleapis.com/maps/api/geocode/json?address=" + enderecoConcatenado+ "&key=" + SUA_KEY + "&language=pt-BR");
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		Gson gson = new GsonBuilder().create();
		Endereco c = gson.fromJson(rd, Endereco.class);
		for (Results r : c.getResults()) {
			latitude = r.getGeometry().getLocation().getLat();
			longitude = r.getGeometry().getLocation().getLng();
		}
		return new Location(latitude, longitude);
	}

	private static String retEnderecoConcatenado(String endereco) {
		return endereco.replaceAll(" ", "+");
	}

}
