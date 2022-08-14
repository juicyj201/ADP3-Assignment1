package za.ac.cput.Domain.Entity.Util;

import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Domain.Entity.Payment;

import java.util.Arrays;

public class Validation {
    public static boolean checkStringNullOrEmpty(String... string){
        return string.equals(null) || string.length == 0;
    }

    public static boolean checkAttributeEmpty(int... integ){
        return Arrays.stream(integ).equals(0);
    }

    public static boolean checkAdminNull(Admin admin){
        return admin.equals(null);
    }

    public static boolean checkPaymentNull(Payment payment){
        return payment.equals(null);
    }
}
