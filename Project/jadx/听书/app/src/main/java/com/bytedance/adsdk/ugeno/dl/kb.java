package com.bytedance.adsdk.ugeno.dl;

import android.text.TextUtils;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class kb implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicInteger f227a;
    private AtomicInteger dl;
    private wp e;
    private js fo;
    private AtomicInteger g;
    private AtomicInteger gc;
    private iq gz;
    private float m;
    private AtomicInteger z;

    public void z(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if ((TextUtils.equals(str, QMUISkinValueBuilder.SRC) || TextUtils.equals(str, "backgroundImage")) && str2.startsWith("http")) {
            this.g.incrementAndGet();
        }
    }

    public int g() {
        int i = (int) (this.m * this.g.get());
        this.z.set(i);
        return i;
    }

    public boolean dl() {
        return this.z.get() > 0;
    }

    public void z(js jsVar) {
        this.fo = jsVar;
    }

    public void z(iq iqVar) {
        this.gz = iqVar;
    }

    @Override // com.bytedance.adsdk.ugeno.dl.e
    public void z() {
        this.f227a.incrementAndGet();
        if (this.f227a.get() == 1) {
            synchronized (this) {
                this.f227a.get();
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.dl.e
    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar, String str) {
        if (this.dl.incrementAndGet() == this.z.get()) {
            synchronized (this) {
                if (this.dl.get() == this.z.get()) {
                    if (this.e != null) {
                        this.g.get();
                    }
                    if (this.fo != null) {
                        q qVar = new q();
                        qVar.z(0);
                        qVar.z(dlVar.g(dlVar));
                    }
                }
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.dl.e
    public void g(com.bytedance.adsdk.ugeno.g.dl dlVar, String str) {
        int iIncrementAndGet = this.gc.incrementAndGet();
        if (iIncrementAndGet > this.g.get() - this.z.get()) {
            synchronized (this) {
                if (iIncrementAndGet > this.g.get() - this.z.get() && this.fo != null) {
                    q qVar = new q();
                    qVar.z(-3);
                    qVar.z("image download fail");
                    qVar.z(dlVar.g(dlVar));
                }
            }
        }
    }
}
