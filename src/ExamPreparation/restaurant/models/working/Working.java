package ExamPreparation.restaurant.models.working;

import ExamPreparation.restaurant.models.client.Client;
import ExamPreparation.restaurant.models.waiter.Waiter;

import java.util.Collection;

public interface Working {
    void takingOrders(Client client, Collection<Waiter> waiters);

}