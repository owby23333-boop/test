package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class f {
    private static long a = 1800000;
    private static Handler b = new Handler(Looper.getMainLooper());

    static final class a implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ LocationManager b;

        a(Context context, LocationManager locationManager) {
            this.a = context;
            this.b = locationManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.b(this.a, this.b);
        }
    }

    static final class b implements LocationListener {
        final /* synthetic */ Context a;
        final /* synthetic */ LocationManager b;

        b(Context context, LocationManager locationManager) {
            this.a = context;
            this.b = locationManager;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location != null && f.b(location)) {
                f.b(this.a, location);
            }
            f.b(this.b, this);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i2, Bundle bundle) {
        }
    }

    static final class c implements Runnable {
        final /* synthetic */ LocationManager a;
        final /* synthetic */ LocationListener b;

        c(LocationManager locationManager, LocationListener locationListener) {
            this.a = locationManager;
            this.b = locationListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.b(this.a, this.b);
        }
    }

    private static class d implements Callable<Location> {
        private LocationManager a;
        private String b;

        public d(LocationManager locationManager, String str) {
            this.a = locationManager;
            this.b = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Location call() throws Exception {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Location lastKnownLocation = this.a.getLastKnownLocation(this.b);
            Logger.d("AdLocationUtils", "location:" + lastKnownLocation + ",getLastKnownLocation use time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
            return lastKnownLocation;
        }
    }

    private static Location a(LocationManager locationManager) {
        Location locationA = a(locationManager, "gps");
        if (locationA == null) {
            locationA = a(locationManager, "network");
        }
        return locationA == null ? a(locationManager, "passive") : locationA;
    }

    private static Location a(LocationManager locationManager, String str) {
        try {
            FutureTask futureTask = new FutureTask(new d(locationManager, str));
            ThreadHelper.runOnThreadPool(futureTask);
            Location location = (Location) futureTask.get(1L, TimeUnit.SECONDS);
            Logger.d("AdLocationUtils", "location:" + location);
            return location;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    private static e a(Context context) {
        e0 e0VarA = e0.a((String) null, context);
        float fA = e0VarA.a("latitude", -1.0f);
        float fA2 = e0VarA.a("longitude", -1.0f);
        if (fA == -1.0f || fA2 == -1.0f) {
            return null;
        }
        return new e(fA, fA2);
    }

    @Nullable
    public static e b(Context context) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().s().isCanUseLocation()) {
            Context contextD = context == null ? bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d() : context.getApplicationContext();
            if (contextD != null) {
                e eVarA = a(contextD);
                if (!c(contextD)) {
                    return eVarA;
                }
                int iA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.c.a(contextD, com.kuaishou.weapon.p0.g.f16727g);
                int iA2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.c.a(contextD, com.kuaishou.weapon.p0.g.f16728h);
                if (iA == 0 || iA2 == 0) {
                    return d(contextD);
                }
            }
        }
        return null;
    }

    private static String b(LocationManager locationManager) {
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
    public static void b(Context context, Location location) {
        if (b(location)) {
            e0 e0VarA = e0.a((String) null, context);
            e0VarA.b("latitude", (float) location.getLatitude());
            e0VarA.b("longitude", (float) location.getLongitude());
            e0VarA.b("lbstime", System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, LocationManager locationManager) {
        if (context == null || locationManager == null) {
            return;
        }
        b bVar = new b(context, locationManager);
        try {
            String strB = b(locationManager);
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            locationManager.requestSingleUpdate(strB, bVar, Looper.getMainLooper());
            b.postDelayed(new c(locationManager, bVar), 30000L);
        } catch (Throwable th) {
            if (Logger.isDebug()) {
                th.printStackTrace();
            }
            b(locationManager, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(LocationManager locationManager, LocationListener locationListener) {
        if (locationManager == null || locationListener == null) {
            return;
        }
        try {
            locationManager.removeUpdates(locationListener);
        } catch (Throwable th) {
            if (Logger.isDebug()) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Location location) {
        return (location.getLatitude() == PangleAdapterUtils.CPM_DEFLAUT_VALUE || location.getLongitude() == PangleAdapterUtils.CPM_DEFLAUT_VALUE) ? false : true;
    }

    private static boolean c(Context context) {
        long jA = e0.a((String) null, context).a("lbstime", -1L);
        return jA == -1 || System.currentTimeMillis() - jA > a;
    }

    private static e d(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        e eVar = null;
        if (locationManager != null) {
            try {
                Location locationA = a(locationManager);
                if (locationA != null && b(locationA)) {
                    b(context, locationA);
                    eVar = new e((float) locationA.getLatitude(), (float) locationA.getLongitude());
                }
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    new Handler(Looper.getMainLooper()).post(new a(context, locationManager));
                } else {
                    b(context, locationManager);
                }
            } catch (Throwable th) {
                if (Logger.isDebug()) {
                    th.printStackTrace();
                }
            }
        }
        return eVar;
    }
}
