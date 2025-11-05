import java.util.Objects;
public class CelestialObject {
	public double x;
	public double y;
	public double z;
	public String name;
	public static final double KM_IN_ONE_AU = 150_000_000;
	private int mass;

	public CelestialObject() {
		this.x = 0.0;
		this.y = 0.0;
		this.z = 0.0;
		this.name = "Soleil";
		this.mass = 0;
	}
	public CelestialObject(String name, double x, double y, double z, int mass) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.z = z;
		this.mass = mass;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getZ() {
		return z;
	}
	public String getName() {
		return name;
	}
	public int getMass() { 
		return mass;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMass(int mass) { 
		this.mass = mass;
	}
	public static double getDistanceBetween(CelestialObject a, CelestialObject b) {
		double dx = a.x - b.x;
		double dy = a.y - b.y;
		double dz = a.z - b.z;
		return Math.sqrt(dx * dx + dy * dy + dz * dz);
	}
	public static double getDistanceBetweenInKm(CelestialObject a, CelestialObject b) {
		return getDistanceBetween(a, b) * KM_IN_ONE_AU;
	}
	public String toString() {
		return String.format("%s is positioned at (%.3f, %.3f, %.3f)", name, x, y, z);
	}
	public boolean equals(Object obj) {
		if (obj == null )
			return false;
		CelestialObject other = (CelestialObject) obj;
		return Double.compare(x, other.x) == 0 && Double.compare(y, other.y) == 0 && mass == other.mass &&
			Double.compare(z, other.z) == 0 && (name.equals(other.name));
	}
	public int hashCode() {
		return Objects.hash(x, y, z, name, mass);
	}
}
