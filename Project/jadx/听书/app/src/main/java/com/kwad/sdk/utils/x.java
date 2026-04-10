package com.kwad.sdk.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class x {
    private static boolean aZq;
    private static com.kwad.sdk.utils.c.a aZr = new com.kwad.sdk.utils.c.a();

    public static com.kwad.sdk.utils.c.a cL(Context context) {
        com.kwad.sdk.utils.c.a aVar;
        com.kwad.sdk.internal.api.a aVarRo;
        com.kwad.sdk.utils.c.a aVar2 = new com.kwad.sdk.utils.c.a();
        if (bc.readLocationDisable() && (aVarRo = bc.Ro()) != null) {
            aVar2.bcT = aVarRo;
            aVar2.type = 1;
            return aVar2;
        }
        if (aZq || (((aVar = aZr) != null && aVar.bcT != null) || context == null)) {
            return aZr;
        }
        if (!bc.readLocationDisable() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(64L)) {
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager.isProviderEnabled("gps")) {
                    aZr.bcT = a(context, locationManager);
                }
                if (aZr == null && locationManager.isProviderEnabled("network")) {
                    aZr.bcT = b(context, locationManager);
                }
                if (aZr == null && locationManager.isProviderEnabled("passive")) {
                    aZr.bcT = c(context, locationManager);
                }
                aZr.type = 0;
                return aZr;
            } catch (Exception e) {
                aZq = true;
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
        }
        return null;
    }

    private static com.kwad.sdk.internal.api.a a(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
            if (lastKnownLocation == null) {
                aZq = true;
            }
            return com.kwad.sdk.internal.api.a.a(lastKnownLocation);
        } catch (Exception e) {
            aZq = true;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    private static com.kwad.sdk.internal.api.a b(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) != 0 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.h) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("network");
            if (lastKnownLocation == null) {
                aZq = true;
            }
            return com.kwad.sdk.internal.api.a.a(lastKnownLocation);
        } catch (Exception e) {
            aZq = true;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    private static com.kwad.sdk.internal.api.a c(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.h) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
            if (lastKnownLocation == null) {
                aZq = true;
            }
            return com.kwad.sdk.internal.api.a.a(lastKnownLocation);
        } catch (Exception e) {
            aZq = true;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }
}
