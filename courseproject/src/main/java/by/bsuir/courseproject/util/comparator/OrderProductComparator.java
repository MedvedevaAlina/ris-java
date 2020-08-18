package by.bsuir.courseproject.util.comparator;

import by.bsuir.courseproject.entity.OrderProduct;

import java.util.Comparator;

public class OrderProductComparator implements Comparator<OrderProduct> {
    @Override
    public int compare(OrderProduct o1, OrderProduct o2) {
        return o1.getId().getProduct().getIdProduct().compareTo(o2.getId().getProduct().getIdProduct());
    }
}
