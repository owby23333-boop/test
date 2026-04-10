package com.bytedance.sdk.openadsdk.core.un;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.media3.session.MediaController;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile long f1372a = 0;
    private static volatile dl dl = null;
    private static long g = 60000;
    private static volatile long gc = 0;
    private static long z = 1800000;

    public static com.bytedance.sdk.component.a.z.dl z(Context context) {
        return z(context, !com.bytedance.sdk.openadsdk.core.dl.z.g());
    }

    public static dl z(final Context context, boolean z2) {
        if ((dl != null && !z()) || !g()) {
            return dl;
        }
        String strDl = com.bytedance.sdk.component.utils.z.dl(com.bytedance.sdk.openadsdk.core.dl.a.z().a("new_sdk_ad_location", 2147483647L));
        if (strDl != null) {
            try {
                JSONObject jSONObject = new JSONObject(strDl);
                String strOptString = jSONObject.optString("latitude");
                String strOptString2 = jSONObject.optString("longitude");
                long jOptLong = jSONObject.optLong("lbstime");
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                    dl = new dl(Float.valueOf(strOptString).floatValue(), Float.valueOf(strOptString2).floatValue(), jOptLong);
                    gc = jOptLong;
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.z(th);
            }
            if (z2) {
                return dl;
            }
        }
        if (dl != null && !z()) {
            return dl;
        }
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP = com.bytedance.sdk.openadsdk.core.uy.ls().p();
        if (!aVarP.z()) {
            com.bytedance.sdk.openadsdk.ls.dl.dl.dl dlVarFo = aVarP.fo();
            if (dlVarFo != null) {
                gc = System.currentTimeMillis();
                dl = new dl((float) dlVarFo.z(), (float) dlVarFo.g(), System.currentTimeMillis());
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (dl != null) {
                    jSONObject2.put("latitude", Float.toString(dl.z));
                    jSONObject2.put("longitude", Float.toString(dl.g));
                    jSONObject2.put("lbstime", dl.dl);
                }
                String string = jSONObject2.toString();
                String strG = com.bytedance.sdk.component.utils.z.g(string);
                com.bytedance.sdk.openadsdk.core.dl.a.z().a("sdk_ad_location", string);
                com.bytedance.sdk.openadsdk.core.dl.a.z().a("new_sdk_ad_location", strG);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
            return dl;
        }
        gc = System.currentTimeMillis();
        f1372a = System.currentTimeMillis();
        if (com.bytedance.sdk.openadsdk.core.a.z.gz()) {
            new com.bytedance.sdk.openadsdk.core.a.g("device_locate").z(5).z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.a.2
                @Override // java.lang.Runnable
                public void run() {
                    long unused = a.f1372a = 0L;
                }
            }).g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.a(context);
                }
            });
        } else {
            a(context);
        }
        return dl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final Context context) {
        com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("getLocation c") { // from class: com.bytedance.sdk.openadsdk.core.un.a.3
            @Override // java.lang.Runnable
            public void run() {
                Context context2 = context;
                dl dlVarGc = a.gc(context2 == null ? com.bytedance.sdk.openadsdk.core.zw.getContext() : context2.getApplicationContext());
                long unused = a.f1372a = 0L;
                if (dlVarGc != null) {
                    dl unused2 = a.dl = dlVarGc;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("latitude", Float.toString(dlVarGc.z));
                        jSONObject.put("longitude", Float.toString(dlVarGc.g));
                        jSONObject.put("lbstime", dlVarGc.dl);
                        String string = jSONObject.toString();
                        String strG = com.bytedance.sdk.component.utils.z.g(string);
                        com.bytedance.sdk.openadsdk.core.dl.a.z().a("sdk_ad_location", string);
                        com.bytedance.sdk.openadsdk.core.dl.a.z().a("new_sdk_ad_location", strG);
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.wp.z(e);
                    }
                }
            }
        });
    }

    private static boolean z() {
        return System.currentTimeMillis() - gc > z;
    }

    private static boolean g() {
        return System.currentTimeMillis() - f1372a > g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static dl gc(final Context context) {
        dl dlVar = null;
        if (!com.bytedance.sdk.openadsdk.core.uy.ls().p().z()) {
            try {
                com.bytedance.sdk.openadsdk.ls.dl.dl.dl dlVarDl = dl();
                if (dlVarDl != null) {
                    return new dl(Double.valueOf(dlVarDl.z()).floatValue(), Double.valueOf(dlVarDl.g()).floatValue(), System.currentTimeMillis());
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        final LocationManager locationManagerM = m(context);
        if (locationManagerM != null) {
            try {
                Location locationZ = z(locationManagerM);
                if (locationZ != null && g(locationZ)) {
                    dlVar = new dl((float) locationZ.getLatitude(), (float) locationZ.getLongitude(), System.currentTimeMillis());
                }
                com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.g(context, locationManagerM);
                    }
                });
            } catch (Throwable th) {
                if (com.bytedance.sdk.component.utils.wp.dl()) {
                    com.bytedance.sdk.component.utils.wp.z(th);
                }
            }
        }
        return dlVar;
    }

    private static LocationManager m(Context context) {
        try {
            return (LocationManager) context.getSystemService("location");
        } catch (Exception unused) {
            return null;
        }
    }

    private static Location z(LocationManager locationManager) {
        Location locationZ = z(locationManager, "gps");
        if (locationZ == null) {
            locationZ = z(locationManager, "network");
        }
        return locationZ == null ? z(locationManager, "passive") : locationZ;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Location z(LocationManager locationManager, String str) {
        try {
            final com.bytedance.sdk.component.uy.gz gzVar = new com.bytedance.sdk.component.uy.gz(new g(locationManager, str), 1, 2);
            com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("getLastKnownLocation") { // from class: com.bytedance.sdk.openadsdk.core.un.a.5
                @Override // java.lang.Runnable
                public void run() {
                    gzVar.run();
                }
            });
            return (Location) gzVar.get(1L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static com.bytedance.sdk.openadsdk.ls.dl.dl.dl dl() {
        try {
            final com.bytedance.sdk.component.uy.gz gzVar = new com.bytedance.sdk.component.uy.gz(new z(), 1, 2);
            com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("getLastKnownLocation") { // from class: com.bytedance.sdk.openadsdk.core.un.a.6
                @Override // java.lang.Runnable
                public void run() {
                    gzVar.run();
                }
            });
            return (com.bytedance.sdk.openadsdk.ls.dl.dl.dl) gzVar.get(1L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static class g implements Callable<Location> {
        private String g;
        private LocationManager z;

        public g(LocationManager locationManager, String str) {
            this.z = locationManager;
            this.g = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Location call() throws Exception {
            System.currentTimeMillis();
            Location lastKnownLocation = this.z.getLastKnownLocation(this.g);
            System.currentTimeMillis();
            return lastKnownLocation;
        }
    }

    private static class z implements Callable<com.bytedance.sdk.openadsdk.ls.dl.dl.dl> {
        private z() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.bytedance.sdk.openadsdk.ls.dl.dl.dl call() throws Exception {
            return com.bytedance.sdk.openadsdk.core.uy.ls().p().fo();
        }
    }

    private static String g(LocationManager locationManager) {
        if (locationManager.isProviderEnabled("gps")) {
            return "gps";
        }
        if (locationManager.isProviderEnabled("network")) {
            return "network";
        }
        if (locationManager.isProviderEnabled("passive")) {
            return "passive";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Context context, final LocationManager locationManager) {
        if (context == null || locationManager == null) {
            return;
        }
        final LocationListener locationListener = new LocationListener() { // from class: com.bytedance.sdk.openadsdk.core.un.a.7
            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i, Bundle bundle) {
            }

            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                if (location != null) {
                    a.g(location);
                }
                a.g(locationManager, this);
            }
        };
        try {
            if (TextUtils.isEmpty(g(locationManager))) {
                return;
            }
            locationManager.requestSingleUpdate("network", locationListener, Looper.myLooper());
            com.bytedance.sdk.component.utils.gz.z().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.a.8
                @Override // java.lang.Runnable
                public void run() {
                    a.g(locationManager, locationListener);
                }
            }, MediaController.RELEASE_UNBIND_TIMEOUT_MS);
        } catch (Throwable th) {
            if (com.bytedance.sdk.component.utils.wp.dl()) {
                com.bytedance.sdk.component.utils.wp.z(th);
            }
            g(locationManager, locationListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(LocationManager locationManager, LocationListener locationListener) {
        if (locationManager == null || locationListener == null) {
            return;
        }
        try {
            locationManager.removeUpdates(locationListener);
        } catch (Throwable th) {
            if (com.bytedance.sdk.component.utils.wp.dl()) {
                com.bytedance.sdk.component.utils.wp.z(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(Location location) {
        return (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true;
    }
}
