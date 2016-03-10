package com.technosavy.showmedistance.helper;

/**
 * @author Nayanesh Gupte
 */
public interface ILocationConstants {


    /**
     * The desired interval for location updates. Inexact. Updates may be more or less frequent.
     */
    long UPDATE_INTERVAL_IN_MILLISECONDS = 10000;

    /**
     * The fastest rate for active location updates. Exact. Updates will never be more frequent
     * than this value.
     */
    long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = UPDATE_INTERVAL_IN_MILLISECONDS / 2;


    String LOACTION_ACTION = "com.technosavy.showmedistance.LOCATION_ACTION";

    String LOCATION_MESSAGE = "com.technosavy.showmedistance.LOCATION_DATA";


}
