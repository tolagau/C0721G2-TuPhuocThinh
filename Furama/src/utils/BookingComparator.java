package utils;

import models.Booking;

import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {


    @Override
    public int compare(Booking o1, Booking o2) {
        if (o1.getNgayBatDau().compareTo(o2.getNgayBatDau()) == 0){
            return o1.getNgayKetThuc().compareTo(o2.getNgayKetThuc());
        }else
            return o1.getNgayBatDau().compareTo(o2.getNgayBatDau());
    }
}
