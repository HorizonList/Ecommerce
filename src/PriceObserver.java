public class PriceObserver implements OrderObserver
{
    @Override
    public void update(Order order)
    {
        if(order.getTotalPrice() > 200 && !order.isDiscount_applied())
        {
            System.out.println("Order > 200 , $20 DISCOUNT FOR YOU CUSTOMER !");
            order.applyDiscount(20);
            order.SetDiscount(true);
        }
    }
}
