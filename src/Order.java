import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Order
{
    private int id;
    private List<Double> items;
    private double TotalPrice;
    private double shippingCost;
    private List<OrderObserver> observers;

    private boolean Discount_applied = false;

    public Order(int id)
    {
        this.id = id;
        this.items = new ArrayList<>();
        this.observers = new ArrayList<>();;
        this.shippingCost = 10.0;
    }

    public void attach(OrderObserver observer)
    {
        observers.add(observer);
    }

    public void addItem(double price)
    {
        items.add(price);
        TotalPrice += price;
    }

    public void detach(OrderObserver observer){
        observers.remove(observer);
    }

    public double getTotalPrice(){
        return TotalPrice;
    }

    public int getCount(){
        return items.size();
    }

    public void notifyObservers(){
        for(OrderObserver observer : observers){
            observer.update(this);
        }
    }

    public void applyDiscount(double discount){
        TotalPrice = TotalPrice - discount;
    }

    public void applyShippingCost(double cost)
    {
        shippingCost = cost;
        TotalPrice = TotalPrice + cost;
    }

    public boolean isDiscount_applied()
    {
        return Discount_applied;
    }

    public void SetDiscount(boolean applied)
    {
        this.Discount_applied = true;
    }



    public String toString(){
        return "Order #" +id +" ,Total Price: $"+TotalPrice+" ,Items = "+  getCount()+" ,Shipping Cost = "+shippingCost;
    }



}
