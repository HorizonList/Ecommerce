import java.util.Observable;
import java.util.Observer;

public class QuantityObserver implements OrderObserver {
    @Override
    public void update(Order order)
    {
            if (order.getCount() > 5) {
                System.out.println("More than 5 items in this order");
                order.applyShippingCost(0);
            }
            else if (order.getCount() <= 5 )
            {
                System.out.println("Should have bought more, $10 wasted");
                order.applyShippingCost(10);
            }
        }
    }

