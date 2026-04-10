package com.bytedance.adsdk.ugeno.dl.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.adsdk.ugeno.dl.fv;
import com.bytedance.adsdk.ugeno.dl.ls;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private ls e;
    private String fo;
    private ls gz;
    private z i;
    private boolean kb;
    private Context uy;
    private boolean wp;
    private float z = Float.MIN_VALUE;
    private float g = Float.MIN_VALUE;
    private int dl = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f224a = Integer.MAX_VALUE;
    private int gc = Integer.MAX_VALUE;
    private AtomicBoolean m = new AtomicBoolean(true);

    public gc(Context context, ls lsVar, boolean z, boolean z2) {
        this.uy = context;
        this.e = lsVar;
        this.kb = z;
        this.wp = z2;
        dl();
    }

    public gc(Context context, ls lsVar, ls lsVar2, boolean z, boolean z2) {
        this.uy = context;
        this.e = lsVar;
        this.gz = lsVar2;
        this.kb = z;
        this.wp = z2;
        dl();
    }

    private void dl() {
        if (this.wp) {
            this.i = new z();
        }
        ls lsVar = this.e;
        if (lsVar == null) {
            return;
        }
        this.dl = lsVar.dl().optInt("slideThreshold");
        this.fo = this.e.dl().optString("slideDirection");
        this.f224a = this.e.dl().optInt("frequency", Integer.MAX_VALUE);
        this.gc = this.e.dl().optInt("effectiveDuration", Integer.MAX_VALUE);
        this.m.get();
    }

    public void z() {
        if (this.gc == Integer.MAX_VALUE) {
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.adsdk.ugeno.dl.g.gc.1
            @Override // java.lang.Runnable
            public void run() {
                gc.this.m.set(false);
            }
        }, this.gc);
    }

    public void g() {
        this.z = Float.MIN_VALUE;
        this.g = Float.MIN_VALUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean z(com.bytedance.adsdk.ugeno.dl.fv r7, com.bytedance.adsdk.ugeno.g.dl r8, android.view.MotionEvent r9, boolean r10) {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.dl.g.gc.z(com.bytedance.adsdk.ugeno.dl.fv, com.bytedance.adsdk.ugeno.g.dl, android.view.MotionEvent, boolean):boolean");
    }

    private void z(com.bytedance.adsdk.ugeno.g.dl dlVar) {
        z zVar = this.i;
        if (zVar != null) {
            zVar.z(dlVar);
        }
    }

    private void z(fv fvVar, ls lsVar, com.bytedance.adsdk.ugeno.g.dl dlVar) {
        if (this.f224a <= 0) {
            z(dlVar);
            return;
        }
        if (!this.m.get()) {
            z(dlVar);
            return;
        }
        fvVar.z(lsVar, dlVar, dlVar);
        int i = this.f224a;
        if (i != Integer.MAX_VALUE) {
            this.f224a = i - 1;
        }
    }
}
