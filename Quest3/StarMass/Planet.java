import java.util.Objects;

public class Planet extends CelestialObject {
    private Star centerStar;
    public Planet() {
        super();
        this.centerStar = new Star();
    }
    public Planet(String name, double x, double y, double z, Star centerStar, int mass) {
        super(name, x, y, z, mass);
        this.centerStar = centerStar;
    }
    public Star getCenterStar() {
        return centerStar;
    }
    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }
    public String toString() {
        double distance = CelestialObject.getDistanceBetween(this, centerStar);
        return String.format("%s circles around %s at the %.3f AU", getName(), centerStar.getName(), distance);
    }
    public boolean equals(Object obj) {
        if (!(obj instanceof Planet)) return false;
        Planet other = (Planet) obj;
        return super.equals(other) && centerStar.equals(other.centerStar);
    }

	@Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), centerStar);
    }
}
