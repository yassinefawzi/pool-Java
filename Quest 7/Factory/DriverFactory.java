public class DriverFactory {
    public static Driver getDriver(String type){
        if (type=="Car"){
            return new CarDriver();
        } else if (type=="Plane"){
            return new PlaneDriver();
        } else{
            return null;    
        }
    }
}