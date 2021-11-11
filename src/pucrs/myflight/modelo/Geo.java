package pucrs.myflight.modelo;
import static java.lang.Math.*;

public class Geo {
	private double latitude;
	private double longitude;

	
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

	public static double distancia(Geo g1, Geo g2) {
		double lat1 = Math.toRadians(g1.getLatitude());
		double lat2 = Math.toRadians(g2.getLatitude());
		double lon1 = Math.toRadians(g1.getLongitude());
		double lon2 = Math.toRadians(g2.getLongitude());
		double sin1 = Math.sin((lat1 - lat2)/2) * Math.sin((lat1 - lat2)/2);
		double sin2 = Math.sin((lon1 - lon2)/2) * Math.sin((lon1 - lon2)/2);
		double raiz = Math.sqrt(sin1 + sin2 * Math.cos(lat1) * Math.cos(lat2));
		double d = (2 * 6371) * Math.asin(raiz);
		return d;
	}

	public double distancia(Geo g2) {
		double lat1 = Math.toRadians(this.getLatitude());
		double lat2 = Math.toRadians(g2.getLatitude());
		double lon1 = Math.toRadians(this.getLongitude());
		double lon2 = Math.toRadians(g2.getLongitude());
		double sin1 = Math.sin((lat1 - lat2)/2) * Math.sin((lat1 - lat2)/2);
		double sin2 = Math.sin((lon1 - lon2)/2) * Math.sin((lon1 - lon2)/2);
		double raiz = Math.sqrt(sin1 + sin2 * Math.cos(lat1) * Math.cos(lat2));
		double d = (2 * 6371) * Math.asin(raiz);
		return d;
	}
}
