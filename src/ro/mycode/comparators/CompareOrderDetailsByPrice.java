package ro.mycode.comparators;

import ro.mycode.models.OrderDetails;

import java.util.Comparator;

public class CompareOrderDetailsByPrice implements Comparator<OrderDetails> {
    @Override
    public int compare(OrderDetails o1, OrderDetails o2) {
        if (o1.getPrice()> o2.getPrice()){
            return 1;
        } else if (o1.getPrice()<o2.getPrice()) {
            return -1;
        }
        return 0;
    }
}
