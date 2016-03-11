package com.technosavy.showmedistance.helper;

import android.os.Build;

/**
 * Created by Nayanesh Gupte
 */
public class AppUtils {

    public static boolean hasM() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }
}
