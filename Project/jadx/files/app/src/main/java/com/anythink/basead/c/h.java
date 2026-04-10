package com.anythink.basead.c;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;

/* JADX INFO: loaded from: classes.dex */
public abstract class h implements SensorEventListener {
    public static final int a = 0;
    public static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5924c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f5925d = 0.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f5926e = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f5927f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f5928g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f5929h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f5930i;

    public h() {
        this.f5929h = 0;
        this.f5930i = 0L;
        this.f5929h = 10;
        this.f5930i = 5000L;
    }

    public final void a(int i2, long j2) {
        this.f5929h = i2;
        this.f5930i = j2;
    }

    public abstract boolean a();

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    @Override // android.hardware.SensorEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSensorChanged(android.hardware.SensorEvent r10) {
        /*
            r9 = this;
            float[] r10 = r10.values
            r0 = 0
            r0 = r10[r0]
            float r0 = -r0
            r1 = 1
            r1 = r10[r1]
            float r1 = -r1
            r2 = 2
            r10 = r10[r2]
            float r10 = -r10
            float r2 = r9.f5925d
            r3 = 0
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 == 0) goto L22
            float r2 = r0 - r2
            float r2 = java.lang.Math.abs(r2)
            int r4 = r9.f5929h
            float r4 = (float) r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L48
        L22:
            float r2 = r9.f5926e
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 == 0) goto L35
            float r2 = r1 - r2
            float r2 = java.lang.Math.abs(r2)
            int r4 = r9.f5929h
            float r4 = (float) r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L48
        L35:
            float r2 = r9.f5927f
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 == 0) goto L5e
            float r2 = r10 - r2
            float r2 = java.lang.Math.abs(r2)
            int r3 = r9.f5929h
            float r3 = (float) r3
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L5e
        L48:
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r9.f5928g
            long r4 = r2 - r4
            long r6 = r9.f5930i
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L5e
            boolean r4 = r9.a()
            if (r4 == 0) goto L5e
            r9.f5928g = r2
        L5e:
            r9.f5925d = r0
            r9.f5926e = r1
            r9.f5927f = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.c.h.onSensorChanged(android.hardware.SensorEvent):void");
    }
}
