package com.technosavy.showmedistance;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.technosavy.showmedistance.helper.ILocationConstants;
import com.technosavy.showmedistance.service.LocationService;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Activity to display latest location updates
 *
 * @author Nayanesh Gupte
 */
public class ShowDistanceActivity extends AppCompatActivity implements ILocationConstants {

    protected static final String TAG = ShowDistanceActivity.class.getSimpleName();


    @Bind(R.id.last_update_time_text)
    TextView mLastUpdateTimeTextView;

    @Bind(R.id.latitude_text)
    TextView mLatitudeTextView;

    @Bind(R.id.longitude_text)
    TextView mLongitudeTextView;

    @Bind(R.id.toolbar)
    Toolbar toolbar;


    private LocationReceiver locationReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_distance);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);


        locationReceiver = new LocationReceiver();


    }


    private void startLocationService() {

        Intent serviceIntent = new Intent(this, LocationService.class);
        startService(serviceIntent);

    }

    @Override
    protected void onStart() {
        super.onStart();

        LocalBroadcastManager.getInstance(this).registerReceiver(locationReceiver, new IntentFilter(LOACTION_ACTION));

        startLocationService();


    }

    @Override
    protected void onStop() {
        super.onStop();

        LocalBroadcastManager.getInstance(this).unregisterReceiver(locationReceiver);
    }

    private class LocationReceiver extends BroadcastReceiver {


        @Override
        public void onReceive(Context context, Intent intent) {


            if (null != intent && intent.getAction().equals(LOACTION_ACTION)) {

                String locationData = intent.getStringExtra(LOCATION_MESSAGE);

                mLatitudeTextView.setText(locationData);
            }

        }
    }


}
