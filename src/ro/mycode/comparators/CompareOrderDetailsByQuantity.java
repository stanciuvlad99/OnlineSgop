package ro.mycode.comparators;

import ro.mycode.models.OrderDetails;

import java.util.Comparator;

public class CompareOrderDetailsByQuantity implements Comparator<OrderDetails> {


    @Override
    public int compare(OrderDetails o1, OrderDetails o2) {
        if (o1.getQuantity()>o2.getQuantity()){
            return 1;
        }else if (o1.getQuantity()<o2.getQuantity()){
            return -1;
        }
        return 0;
    }
}
