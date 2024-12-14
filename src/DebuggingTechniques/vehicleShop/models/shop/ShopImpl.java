package DebuggingTechniques.vehicleShop.models.shop;

import DebuggingTechniques.vehicleShop.models.tool.Tool;
import DebuggingTechniques.vehicleShop.models.vehicle.Vehicle;
import DebuggingTechniques.vehicleShop.models.worker.Worker;

public class ShopImpl implements Shop {

    @Override
    public void make(Vehicle vehicle, Worker worker) {

        // Проверявам дали от инструментите на този работник има ПОНЕ 1, който НЕ Е негоден!
        boolean hasWorkerFitTool = worker.getTools().stream().anyMatch(tool -> !tool.isUnfit()); // true
        while (worker.canWork() && hasWorkerFitTool && !vehicle.reached()) {
            // Поправям превозното средство
            // 1. Вземам инструмент, с който ще поправям превозното средство
            Tool toolToUse = worker.getTools().stream().filter(tool -> !tool.isUnfit()).findFirst().get();
            // 2. Използвам този инструмент
            toolToUse.decreasesPower();
            // 3. Извършвам ремонт по превозното средство
            vehicle.making();
            // 4. Работника работи и се измаря
            worker.working();

            // Проверявам дали все още има инструменти за ползване
            hasWorkerFitTool = worker.getTools().stream().anyMatch(tool -> !tool.isUnfit());
        }
    }
}