package java.edu.narxoz.galactic.dispatcher;

import java.edu.narxoz.galactic.drones.DroneStatus;
import java.edu.narxoz.galactic.task.DeliveryTask;
import java.edu.narxoz.galactic.drones.Drone;
import java.edu.narxoz.galactic.task.TaskState;

public class Dispatcher {
    public Result assignTask(DeliveryTask task, Drone drone){
        if(task == null || drone == null){
            return new Result(false, "Error");
        }
        if(task.getState() != TaskState.CREATED){
            return new Result(false, "Not Created");
        }
        if(drone.getStatus() != DroneStatus.IDLE){
            return new Result(false, "Not Idle");
        }
        if(task.getCargo().getWeightKg() > drone.getMaxPayloadKg()){
            return new Result(false, "Overweight");
        }
        task.setAssignedDrone(drone);
        task.setState(TaskState.ASSIGNED);
        drone.setStatus(DroneStatus.IN_FLIGHT);

        return new Result(true, null);
    }
    public Result completeTask(DeliveryTask task){
        if(task == null){
            return new Result(false,"Is null");
        }
        if(task.getState() != TaskState.ASSIGNED){
            return new Result(false, "Not assigned");
        }
        if(task.getAssignedDrone() == null){
            return new Result(false, "No drone");
        }
        if(task.getAssignedDrone().getStatus() != DroneStatus.IN_FLIGHT){
            return new Result(false, "Not in flight");
        }
        task.setState(TaskState.DONE);
        task.getAssignedDrone().setStatus(DroneStatus.IDLE);

        return new Result(true, null);
    }
}
