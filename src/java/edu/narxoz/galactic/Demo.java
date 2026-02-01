package java.edu.narxoz.galactic;

import java.edu.narxoz.galactic.bodies.Planet;
import java.edu.narxoz.galactic.cargo.Cargo;
import java.edu.narxoz.galactic.drones.LightDrone;
import java.edu.narxoz.galactic.drones.HeavyDrone;
import java.edu.narxoz.galactic.task.DeliveryTask;
import java.edu.narxoz.galactic.dispatcher.Dispatcher;

public class Demo {
    public static void main(String[] args) {
        Planet jupiter = new Planet("Jupiter", 0, 0, "O2");
        Planet mars = new Planet("Mars", 100, 0, "CO2");

        Cargo cargo = new Cargo(20, "Supplies");

        LightDrone light = new LightDrone("LD-1", 10);
        HeavyDrone heavy = new HeavyDrone("HD-1", 50);

        DeliveryTask task = new DeliveryTask(jupiter, mars, cargo);
        Dispatcher dispatcher = new Dispatcher();

        System.out.println(dispatcher.assignTask(task, light).ok());
        System.out.println(dispatcher.assignTask(task, heavy).ok());
        System.out.println(task.estimateTime());
        System.out.println(dispatcher.completeTask(task).ok());
        System.out.println(task.getState());
        System.out.println(heavy.getStatus());
    }
}
