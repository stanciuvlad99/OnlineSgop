package ro.mycode.comparators;

import ro.mycode.models.Products;

import java.util.Comparator;

public class CompareProductByWeight implements Comparator<Products> {
    @Override
    public int compare(Products o1, Products o2) {

        if(o1.getWeight()>o2.getWeight()){
            return 1;
        } else if (o1.getWeight()<o2.getWeight()) {
            return -1;
        }
        return 0;
    }

}
