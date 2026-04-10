package com.bytedance.msdk.gz;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.media3.session.MediaController;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private static Handler g = new Handler(Looper.getMainLooper());
    private static long z = 1800000;

    public static gc z(Context context) {
        if (!com.bytedance.msdk.core.z.kb().zw().z()) {
            return null;
        }
        Context context2 = context == null ? com.bytedance.msdk.core.g.getContext() : context.getApplicationContext();
        if (context2 == null) {
            return null;
        }
        gc gcVarDl = dl(context2);
        if (!g(context2)) {
            return gcVarDl;
        }
        int iZ = com.bytedance.msdk.core.wp.dl.z(context2, com.kuaishou.weapon.p0.g.g);
        int iZ2 = com.bytedance.msdk.core.wp.dl.z(context2, com.kuaishou.weapon.p0.g.h);
        if (iZ == 0 || iZ2 == 0) {
            return a(context2);
        }
        return null;
    }

    private static boolean g(Context context) {
        long jG = l.z((String) null, context).g("lbstime", -1L);
        return jG == -1 || System.currentTimeMillis() - jG > z;
    }

    private static gc dl(Context context) {
        l lVarZ = l.z((String) null, context);
        float fG = lVarZ.g("latitude", -1.0f);
        float fG2 = lVarZ.g("longitude", -1.0f);
        if (fG == -1.0f || fG2 == -1.0f) {
            return null;
        }
        return new gc(fG, fG2);
    }

    private static gc a(final Context context) {
        final LocationManager locationManager = (LocationManager) context.getSystemService("location");
        gc gcVar = null;
        if (locationManager != null) {
            try {
                Location locationZ = z(locationManager);
                if (locationZ != null && g(locationZ)) {
                    g(context, locationZ);
                    gcVar = new gc((float) locationZ.getLatitude(), (float) locationZ.getLongitude());
                }
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.msdk.gz.m.1
                        @Override // java.lang.Runnable
                        public void run() {
                            m.g(context, locationManager);
                        }
                    });
                } else {
                    g(context, locationManager);
                }
            } catch (Throwable th) {
                if (com.bytedance.msdk.z.gc.dl.g()) {
                    com.bytedance.sdk.component.utils.wp.z(th);
                }
            }
        }
        return gcVar;
    }

    private static Location z(LocationManager locationManager) {
        Location locationZ = z(locationManager, "gps");
        if (locationZ == null) {
            locationZ = z(locationManager, "network");
        }
        return locationZ == null ? z(locationManager, "passive") : locationZ;
    }

    private static Location z(LocationManager locationManager, String str) {
        try {
            FutureTask futureTask = new FutureTask(new z(locationManager, str));
            com.bytedance.msdk.z.gc.m.a(futureTask);
            Location location = (Location) futureTask.get(1L, TimeUnit.SECONDS);
            com.bytedance.msdk.z.gc.dl.z("AdLocationUtils", "location:".concat(String.valueOf(location)));
            return location;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static class z implements Callable<Location> {
        private String g;
        private LocationManager z;

        public z(LocationManager locationManager, String str) {
            this.z = locationManager;
            this.g = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Location call() throws Exception {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Location lastKnownLocation = this.z.getLastKnownLocation(this.g);
            com.bytedance.msdk.z.gc.dl.z("AdLocationUtils", "location:" + lastKnownLocation + ",getLastKnownLocation use time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
            return lastKnownLocation;
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
    public static void g(final Context context, final LocationManager locationManager) {
        if (context == null || locationManager == null) {
            return;
        }
        final LocationListener locationListener = new LocationListener() { // from class: com.bytedance.msdk.gz.m.2
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
                if (location != null && m.g(location)) {
                    m.g(context, location);
                }
                m.g(locationManager, this);
            }
        };
        try {
            String strG = g(locationManager);
            if (TextUtils.isEmpty(strG)) {
                return;
            }
            locationManager.requestSingleUpdate(strG, locationListener, Looper.getMainLooper());
            g.postDelayed(new Runnable() { // from class: com.bytedance.msdk.gz.m.3
                @Override // java.lang.Runnable
                public void run() {
                    m.g(locationManager, locationListener);
                }
            }, MediaController.RELEASE_UNBIND_TIMEOUT_MS);
        } catch (Throwable th) {
            if (com.bytedance.msdk.z.gc.dl.g()) {
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
            if (com.bytedance.msdk.z.gc.dl.g()) {
                com.bytedance.sdk.component.utils.wp.z(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Context context, Location location) {
        if (g(location)) {
            l lVarZ = l.z((String) null, context);
            lVarZ.z("latitude", (float) location.getLatitude());
            lVarZ.z("longitude", (float) location.getLongitude());
            lVarZ.z("lbstime", System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(Location location) {
        return (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true;
    }
}
