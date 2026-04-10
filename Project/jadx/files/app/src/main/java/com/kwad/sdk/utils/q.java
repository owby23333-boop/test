package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class q {
    private static boolean ayD;
    private static Location ayE;

    @SuppressLint({"MissingPermission"})
    private static Location a(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f16727g) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
            if (lastKnownLocation == null) {
                ayD = true;
            }
            return lastKnownLocation;
        } catch (Exception e2) {
            ayD = true;
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    private static Location b(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f16727g) != 0 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f16728h) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("network");
            if (lastKnownLocation == null) {
                ayD = true;
            }
            return lastKnownLocation;
        } catch (Exception e2) {
            ayD = true;
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return null;
        }
    }

    @Nullable
    public static Location bX(Context context) {
        if (as.DQ() && as.DR() != null) {
            return as.DR();
        }
        if (ayD || ayE != null || context == null) {
            return ayE;
        }
        if (!as.DQ() && !((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(64L)) {
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager.isProviderEnabled("gps")) {
                    ayE = a(context, locationManager);
                }
                if (ayE == null && locationManager.isProviderEnabled("network")) {
                    ayE = b(context, locationManager);
                }
                if (ayE == null && locationManager.isProviderEnabled("passive")) {
                    ayE = c(context, locationManager);
                }
                return ayE;
            } catch (Exception e2) {
                ayD = true;
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    private static Location c(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f16728h) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
            if (lastKnownLocation == null) {
                ayD = true;
            }
            return lastKnownLocation;
        } catch (Exception e2) {
            ayD = true;
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return null;
        }
    }
}
