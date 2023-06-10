package ro.mycode.comparators;

import ro.mycode.models.Orders;

import java.util.Comparator;

public class CompareOrdersByAmmount implements Comparator<Orders> {
    @Override
    public int compare(Orders o1, Orders o2) {
        if (o1.getAmmount()>o2.getAmmount()){
            return 1;
        } else if (o1.getAmmount()<o2.getAmmount()) {
            return -1;
        }
        return 0;
    }
}
