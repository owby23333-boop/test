package com.anythink.expressad.exoplayer.scheduler;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.PowerManager;
import com.anythink.expressad.exoplayer.k.af;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final int a = 0;
    public static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f10046c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f10047d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f10048e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f10049f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f10050g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f10051h = 7;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f10052i = "Requirements";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String[] f10053j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f10054k;

    /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.scheduler.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterfaceC0202a {
    }

    private a(int i2, boolean z2, boolean z3) {
        this(i2 | (z2 ? 16 : 0) | (z3 ? 8 : 0));
    }

    private static void e() {
    }

    public final int a() {
        return this.f10054k & 7;
    }

    public final boolean b() {
        return (this.f10054k & 16) != 0;
    }

    public final boolean c() {
        return (this.f10054k & 8) != 0;
    }

    public final int d() {
        return this.f10054k;
    }

    public final String toString() {
        return super.toString();
    }

    public a(int i2) {
        this.f10054k = i2;
    }

    private static boolean a(ConnectivityManager connectivityManager) {
        if (af.a < 23) {
            return true;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            return false;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        return !(networkCapabilities == null || !networkCapabilities.hasCapability(16));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(android.content.Context r9) {
        /*
            r8 = this;
            int r0 = r8.f10054k
            r1 = 7
            r0 = r0 & r1
            r2 = 1
            if (r0 != 0) goto L8
            return r2
        L8:
            java.lang.String r3 = "connectivity"
            java.lang.Object r9 = r9.getSystemService(r3)
            android.net.ConnectivityManager r9 = (android.net.ConnectivityManager) r9
            android.net.NetworkInfo r3 = r9.getActiveNetworkInfo()
            r4 = 0
            if (r3 == 0) goto L7c
            boolean r5 = r3.isConnected()
            if (r5 != 0) goto L1e
            goto L7c
        L1e:
            int r5 = com.anythink.expressad.exoplayer.k.af.a
            r6 = 23
            r7 = 16
            if (r5 >= r6) goto L28
        L26:
            r5 = 1
            goto L42
        L28:
            android.net.Network r5 = r9.getActiveNetwork()
            if (r5 == 0) goto L41
            android.net.NetworkCapabilities r5 = r9.getNetworkCapabilities(r5)
            if (r5 == 0) goto L3d
            boolean r5 = r5.hasCapability(r7)
            if (r5 != 0) goto L3b
            goto L3d
        L3b:
            r5 = 0
            goto L3e
        L3d:
            r5 = 1
        L3e:
            if (r5 != 0) goto L41
            goto L26
        L41:
            r5 = 0
        L42:
            if (r5 != 0) goto L45
            return r4
        L45:
            if (r0 != r2) goto L48
            return r2
        L48:
            r5 = 3
            if (r0 != r5) goto L53
            boolean r9 = r3.isRoaming()
            if (r9 != 0) goto L52
            return r2
        L52:
            return r4
        L53:
            int r5 = com.anythink.expressad.exoplayer.k.af.a
            if (r5 < r7) goto L5c
            boolean r9 = r9.isActiveNetworkMetered()
            goto L6b
        L5c:
            int r9 = r3.getType()
            if (r9 == r2) goto L6a
            if (r9 == r1) goto L6a
            r1 = 9
            if (r9 == r1) goto L6a
            r9 = 1
            goto L6b
        L6a:
            r9 = 0
        L6b:
            r1 = 2
            if (r0 != r1) goto L72
            if (r9 != 0) goto L71
            return r2
        L71:
            return r4
        L72:
            r1 = 4
            if (r0 != r1) goto L76
            return r9
        L76:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>()
            throw r9
        L7c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.scheduler.a.b(android.content.Context):boolean");
    }

    private boolean c(Context context) {
        if (!b()) {
            return true;
        }
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            return false;
        }
        int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    private boolean d(Context context) {
        if (!c()) {
            return true;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        int i2 = af.a;
        return i2 >= 23 ? !powerManager.isDeviceIdleMode() : i2 >= 20 ? !powerManager.isInteractive() : !powerManager.isScreenOn();
    }

    private static boolean a(ConnectivityManager connectivityManager, NetworkInfo networkInfo) {
        if (af.a >= 16) {
            return connectivityManager.isActiveNetworkMetered();
        }
        int type = networkInfo.getType();
        return (type == 1 || type == 7 || type == 9) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00d7 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(android.content.Context r11) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.scheduler.a.a(android.content.Context):boolean");
    }
}
