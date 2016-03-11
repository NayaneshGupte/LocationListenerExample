# LocationListenerExample

What this example does:

1. Runs STICKY service in the background continuously and calculate distance since the app is started. 

2. It posts location updates to Activity using LocalBroadcastManager in case App is running in foreground.

3. Takes care of runtime permissions for Android - M



Google Play Services for location updates using Fused (GPS + Network) Location Provider :

WHY USE:

We could choose one of the location providers (GPS or Network) and request location updates or set up proximity alert. But there were two main issues with this approach:

1. In case we need to define precise location, we had to switch between network and GPS location providers (as GPS doesn’t work indoors).
2. Proximity alerts were used to notify a user about proximity to a location, and this took its toll on the battery life.

ADVANTAGE OF USING THIS API:

1. Simple APIs: Lets us specify high-level needs like “high accuracy” or “low power”, instead of having to worry about location providers.
2. Immediately available: Gives our apps immediate access to the best, most recent location.
3. Power-efficiency: Minimizes out app’s use of power. Based on all incoming location requests and available sensors, fused location provider chooses the most efficient way to meet those needs.
4. Versatility: Meets a wide range of needs, from foreground uses that need highly accurate location to background uses that need periodic location updates with negligible power impact.


Note : 

1. Make sure Google Play services is properly installed and working in our device. Don’t test this Location API in emulator unless you are taking care of Google Play Services.

2. Service keeps running continuously in background and there is NO breaking condition, so in case you install this app on your device you might want to get rid it soon for obvious reasons.



Known Issues:

Service class doesn't have onStop() callback and onDestroy() is not guaranteed. So have to be careful while saving any state.




References:

Fused Location Provider
(https://developers.google.com/android/reference/com/google/android/gms/location/FusedLocationProviderApi#public-method-summary)

Receiving Location Updates
(http://developer.android.com/training/location/receive-location-updates.html)


