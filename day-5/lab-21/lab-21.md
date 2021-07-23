# 🖥 Lab 21: Requesting a User’s Location
Let's implement a permission request workflow to access the current device location

## Objectives
1. Declare `ACCESS_FINE_LOCATION` permission in `AndroidManifest.xml
2. Add a menu item to trigger location request
    1. Add item to `main_toolbar.xml` with title `Get Location`
    2. In `MainActivity` create a method call `getLocation()`
    3. When the `Get Location` menu item is clicked, call `getLocation()`
3. Integrate Google Play Services Location dependency
    1. Add play-services-location dependency `implementation 'com.google.android.gms:play-services-location:18.0.0'`
    2. Within `MainActivity.onCreate()`, get a reference to a `FusedLocationProviderClient` using `LocationServices.getFusedLocationProviderClient(this)`
3. Implement permissions request flow in `getLocation()`
    1. Check if permission is already granted with `ContextCompat.checkSelfPermisison(this, Manifest.permission.ACCESS_FINE_LOCATION)`
        1. If it is granted, request a location using `FusedLocationProviderClient`
    2. If not granted, check if you should show rationale to user using `shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)`
        1. If you should show rationale, display some feedback to the user
        2. The feedback should explain why you need the permission
        3. The feedback should include an action to either request the permission, or to cancel and continue without it
    3. If do not need to show rationale, request permission `ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_LOCATION_PERMISSIONS)`
4. Handle granted permission
    1. Override `onRequestPermissionsResult()`
    2. Check if the request matches the request for location permission
    3. Check if the `grantResults` include `PackageManager.PERMISSION_GRANTED`
    4. If it does, request a location using `FusedLocationProviderClient`