public class Excalibur {
    private String name;
    private static Excalibur INSTANCE;
	
    private Excalibur(String n){
        this.name = n;
    }

    public String getName(){
        return this.name;
    }
	
    public static Excalibur getInstance(){
         if (INSTANCE == null) {
            INSTANCE = new Excalibur("Sword");
        }
        return INSTANCE;
    }
}