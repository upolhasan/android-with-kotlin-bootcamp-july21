# 🖥 Lab 21 Hints: Requesting a User’s Location

## 💡 Helpful Resources
- [Requesting App Permissions](https://developer.android.com/training/permissions/requesting)
- [Setting Up Google Play Services Location](https://developers.google.com/android/guides/setup)

## 💡 How to use Google Play Services to get last known location?
Add the `play-services-location` dependency
`implementation 'com.google.android.gms:play-services-location:18.0.0'`

Get a reference to a `FusedLocationProviderClient` using `LocationServices.getFusedLocationProviderClient(context)`

With the `FusedLocationProviderClient` get the last location
```kotlin
fusedLocationClient.lastLocation.addOnSuccessListener { location ->
  // use the location
}
```

## 💡 How to check if location permission is granted?
```kotlin
if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
  // request and use location
} else if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
  // show rationale UI to user
  // give them an option to go ahead and accept the permission
  // on accept permission ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_LOCATION_PERMISSIONS)  
} else {
  ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_LOCATION_PERMISSIONS)
}
```