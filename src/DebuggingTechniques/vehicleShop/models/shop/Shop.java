package DebuggingTechniques.vehicleShop.models.shop;

import DebuggingTechniques.vehicleShop.models.vehicle.Vehicle;
import DebuggingTechniques.vehicleShop.models.worker.Worker;

public interface Shop {
    void make(Vehicle vehicle, Worker worker);
}