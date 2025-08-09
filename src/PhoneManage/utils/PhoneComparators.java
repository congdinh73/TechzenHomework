package PhoneManage.utils;

import PhoneManage.model.Phone;

import java.util.Comparator;

public class PhoneComparators {

    public static final Comparator<Phone> BY_PRICE_ASCENDING =
            (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice());

    public static final Comparator<Phone> BY_PRICE_DESCENDING =
            (p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice());

}
