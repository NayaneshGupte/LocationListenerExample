package com.technosavy.showmedistance;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.kayvannj.permission_utils.Func2;
import com.github.kayvannj.permission_utils.PermissionUtil;
import com.technosavy.showmedistance.helper.AppUtils;
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


    @Bind(R.id.tvLocationData)
    TextView tvLocationData;

    @Bind(R.id.toolbar)
    Toolbar toolbar;


    /**
     * Receiver listening to Location updates and updating UI in activity
     */
    private LocationReceiver locationReceiver;

    /**
     * Permission util with callback mechanism to avoid boilerplate code
     * <p/>
     * https://github.com/kayvannj/PermissionUtil
     */
    private PermissionUtil.PermissionRequestObject mBothPermissionRequest;


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


        /**
         * Runtime permissions are required on Android M and above to access User's location
         */
        if (AppUtils.hasM() && !(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)) {

            askPermissions();

        } else {

            startLocationService();

        }

    }

    /**
     * Ask user for permissions to access GPS location on Android M
     */
    public void askPermissions() {
        mBothPermissionRequest =
                PermissionUtil.with(this).request(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION).onResult(
                        new Func2() {
                            @Override
                            protected void call(int requestCode, String[] permissions, int[] grantResults) {

                                if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                                    startLocationService();

                                } else {

                                    Toast.makeText(ShowDistanceActivity.this, R.string.permission_denied, Toast.LENGTH_LONG).show();
                                }
                            }

                        }).ask(PERMISSION_ACCESS_LOCATION_CODE);

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

                tvLocationData.setText(locationData);
            }

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if (null != mBothPermissionRequest) {
            mBothPermissionRequest.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


}
