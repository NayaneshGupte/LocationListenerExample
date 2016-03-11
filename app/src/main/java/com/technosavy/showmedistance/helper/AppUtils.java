package com.technosavy.showmedistance.helper;

import android.os.Build;

/**
 * @author Nayanesh Gupte
 */
public class AppUtils {

    /**
     * @return true If device has Android Marshmallow or above version
     */
    public static boolean hasM() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }
}
