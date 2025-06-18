import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client
{
    public static void main(String[] args)
    {
        Order order = new Order(1);
        order.attach(new PriceObserver());
        order.attach(new QuantityObserver());

        List<Double> items = Arrays.asList(40.0, 30.0, 20.0, 25.0, 35.0);  // 5 items


        for (double price : items)
        {
            order.addItem(price);
        }
        order.notifyObservers();


        System.out.println(order);
    }
}
