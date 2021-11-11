package pucrs.myflight.modelo;
import static java.lang.Math.*;

public class Geo {
	private double latitude;
	private double longitude;
	private double d;
	private double lat1;
	private double lat2;
	private double lon1;
	private double lon2;
	private double raiz;
	private double sin1;
	private double sin2;
	
	public Geo(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}

	public double distancia(Geo g1, Geo g2) {
		lat1 = Math.toRadians(g1.getLatitude());
		lat2 = Math.toRadians(g2.getLatitude());
		lon1 = Math.toRadians(g1.getLongitude());
		lon2 = Math.toRadians(g2.getLongitude());
		sin1 = Math.sin((lat1 - lat2)/2) * Math.sin((lat1 - lat2)/2);
		sin2 = Math.sin((lon1 - lon2)/2) * Math.sin((lon1 - lon2)/2);
		raiz = Math.sqrt(sin1 + sin2 * Math.cos(lat1) * Math.cos(lat2));
		d = (2 * 6371) * Math.asin(raiz);
		return d;
	}
}
