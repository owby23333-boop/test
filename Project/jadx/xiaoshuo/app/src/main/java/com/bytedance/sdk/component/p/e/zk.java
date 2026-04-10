package com.bytedance.sdk.component.p.e;

import android.content.Context;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class zk {
    private static zk wu;
    private static volatile com.bytedance.sdk.component.p.e.ga.e zk;
    private volatile com.bytedance.sdk.component.p.e.tg.bf.e bf;
    private volatile com.bytedance.sdk.component.p.e.tg.bf.e d;
    private volatile Context e;
    private volatile com.bytedance.sdk.component.p.e.tg.bf.e ga;
    private volatile com.bytedance.sdk.component.p.e.bf.d m;
    private volatile boolean p;
    private volatile com.bytedance.sdk.component.p.e.tg.bf.e tg;
    private volatile vn v;
    private volatile com.bytedance.sdk.component.p.e.e.ga vn;
    private final AtomicBoolean xu = new AtomicBoolean(false);

    private zk() {
    }

    public static synchronized zk ga() {
        if (wu == null) {
            wu = new zk();
        }
        return wu;
    }

    public static com.bytedance.sdk.component.p.e.ga.e tg() {
        if (zk == null) {
            synchronized (zk.class) {
                if (zk == null) {
                    zk = new com.bytedance.sdk.component.p.e.ga.bf();
                }
            }
        }
        return zk;
    }

    public boolean bf() {
        return this.p;
    }

    public vn bh() {
        return this.v;
    }

    public com.bytedance.sdk.component.p.e.e.ga d() {
        return this.vn;
    }

    public boolean e() {
        return this.xu.get();
    }

    public Context getContext() {
        return this.e;
    }

    public com.bytedance.sdk.component.p.e.tg.bf.e m() {
        return this.d;
    }

    public void p() {
        com.bytedance.sdk.component.p.e.bf.tg.e.bf();
    }

    public void v() {
        com.bytedance.sdk.component.p.e.bf.tg.e.d();
    }

    public com.bytedance.sdk.component.p.e.bf.d vn() {
        return this.m;
    }

    public com.bytedance.sdk.component.p.e.tg.bf.e wu() {
        return this.tg;
    }

    public com.bytedance.sdk.component.p.e.tg.bf.e xu() {
        return this.ga;
    }

    public com.bytedance.sdk.component.p.e.tg.bf.e zk() {
        return this.bf;
    }

    public void bf(boolean z) {
        this.p = z;
    }

    public void d(com.bytedance.sdk.component.p.e.tg.bf.e eVar) {
        this.tg = eVar;
    }

    public void e(boolean z) {
        this.xu.set(z);
    }

    public void bf(com.bytedance.sdk.component.p.e.tg.bf.e eVar) {
        this.d = eVar;
    }

    public void e(com.bytedance.sdk.component.p.e.e.ga gaVar) {
        this.vn = gaVar;
    }

    public void e(Context context) {
        this.e = context;
    }

    public void e(com.bytedance.sdk.component.p.e.bf.d dVar) {
        this.m = dVar;
    }

    public void e(com.bytedance.sdk.component.p.e.tg.e eVar) {
        if (eVar == null) {
            return;
        }
        eVar.e(System.currentTimeMillis());
        com.bytedance.sdk.component.p.e.bf.tg.e.e(eVar, eVar.tg());
    }

    public void tg(com.bytedance.sdk.component.p.e.tg.bf.e eVar) {
        this.ga = eVar;
    }

    public void e(String str) {
        com.bytedance.sdk.component.p.e.vn.e.e().e(str);
    }

    public void e(String str, List<String> list, boolean z) {
        com.bytedance.sdk.component.p.e.vn.e.e().e(str, list, z);
    }

    public void e(com.bytedance.sdk.component.p.e.tg.bf.e eVar) {
        this.bf = eVar;
    }

    public void e(vn vnVar) {
        this.v = vnVar;
    }
}
