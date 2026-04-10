package com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z;

import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.bytedance.sdk.openadsdk.core.iq.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private Context g;
    private final Vibrator gc;
    private List<g> z;
    private final List<Long> dl = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Integer> f1341a = new ArrayList();
    private long m = 0;
    private long e = 0;

    private static float z(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    public z(Context context, h hVar) {
        this.g = context;
        this.gc = dl.dl(context);
        this.z = hVar.g();
        z();
    }

    public void z() {
        dl();
        List<g> list = this.z;
        if (list == null || list.isEmpty()) {
            return;
        }
        Collections.sort(this.z, new Comparator<g>() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z.z.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public int compare(g gVar, g gVar2) {
                return Long.compare(gVar.z(), gVar2.z());
            }
        });
        for (g gVar : this.z) {
            long jZ = ((long) gVar.z()) + gVar.g();
            if (jZ > this.e) {
                this.e = jZ;
            }
        }
        for (g gVar2 : this.z) {
            if (this.m < gVar2.z()) {
                z(((long) gVar2.z()) - this.m);
            }
            z(gVar2.g(), gVar2.dl(), gVar2.a());
        }
        long j = this.m;
        long j2 = this.e;
        if (j < j2) {
            z(j2 - j);
        }
    }

    public void g() {
        if (!dl.z(this.g) || this.dl.isEmpty() || this.f1341a.isEmpty()) {
            return;
        }
        this.gc.vibrate(VibrationEffect.createWaveform(z(this.dl), g(this.f1341a), -1));
    }

    private void z(long j) {
        if (j > 0) {
            this.dl.add(Long.valueOf(j));
            this.f1341a.add(0);
            this.m += j;
        }
    }

    private void z(long j, float f, float f2) {
        float fZ = z(f, 0.0f, 1.0f);
        float fZ2 = z(f2, 0.0f, 1.0f);
        int iPow = (int) (((float) Math.pow(fZ, 1.5d)) * 255.0f);
        int iMax = Math.max(1, (int) (fZ2 * ((int) (j / 22))));
        long j2 = j - (((long) iMax) * 20);
        for (int i = 0; i < iMax; i++) {
            this.dl.add(20L);
            this.f1341a.add(Integer.valueOf(iPow));
            int i2 = iMax - 1;
            if (i < i2) {
                this.dl.add(Long.valueOf(Math.max(2L, j2 / ((long) i2))));
                this.f1341a.add(0);
            }
        }
        this.m += j;
    }

    public void dl() {
        this.dl.clear();
        this.f1341a.clear();
        this.m = 0L;
        this.e = 0L;
    }

    private long[] z(List<Long> list) {
        long[] jArr = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            jArr[i] = list.get(i).longValue();
        }
        return jArr;
    }

    private int[] g(List<Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }
}
