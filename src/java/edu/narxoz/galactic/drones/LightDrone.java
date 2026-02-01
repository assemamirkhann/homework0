package java.edu.narxoz.galactic.drones;

public class LightDrone extends Drone{
    public LightDrone(String id, double maxPayLoadKg){
        super(id, maxPayLoadKg);
    }
    @Override
    public double speedKmPerMin(){
        return 10.0;
    }
}
