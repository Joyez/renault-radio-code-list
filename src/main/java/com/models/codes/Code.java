package com.models.codes;

import java.io.Serializable;

public class Code implements Comparable, Serializable {
    private String numberCode;

    public Code(String numberCode) {
        this.numberCode= numberCode;
    }

    @Override
    public int compareTo(Object o) {
        Code code = (Code)o;
        return stringCompare(this.numberCode,code.numberCode);
    }

    public String getNumberCode() {
        return numberCode;
    }

    private int stringCompare(String str1, String str2)
    {

        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }


        if (l1 != l2) {
            return l1 - l2;
        }


        else {
            return 0;
        }
    }


    public String toString()
    {
        return numberCode;
    }
}
