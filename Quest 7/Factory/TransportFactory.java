public class TransportFactory {
    public static Transport getTransport(String type) {
        if (type=="Car") {
            return new Car();
        } else if (type=="Plane") {
            return new Plane();
        }
        return null;
    }
}
