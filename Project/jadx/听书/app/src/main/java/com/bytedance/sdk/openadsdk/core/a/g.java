package com.bytedance.sdk.openadsdk.core.a;

import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.uy;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Runnable f912a;
    private long dl;
    private String g;
    private int z = 10000;

    public g(String str) {
        this.g = str;
    }

    public g z(int i) {
        this.z = i <= 0 ? 10000 : i * 1000;
        return this;
    }

    public g z(Runnable runnable) {
        this.f912a = runnable;
        return this;
    }

    public void g(final Runnable runnable) {
        this.dl = System.currentTimeMillis();
        if (!z.gc()) {
            g(1);
            dl(runnable);
        } else if (uy.ls().gk()) {
            g(2);
            z();
        } else if (!z.z()) {
            g(1);
            dl(runnable);
        } else {
            gz.z().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.g.1
                @Override // java.lang.Runnable
                public void run() {
                    if (uy.ls().gk()) {
                        g.this.g(2);
                        g.this.z();
                    } else {
                        g.this.g(1);
                        g.this.dl(runnable);
                    }
                }
            }, this.z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        Runnable runnable = this.f912a;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i) {
        StringBuilder sb = new StringBuilder(">> tk: ");
        sb.append(this.g).append(i == 1 ? " run" : " cancel").append(", isBst: true, tmgap: ").append((System.currentTimeMillis() - this.dl) / 1000);
        if (i == 1) {
            wp.z("bstsdk", sb.toString());
        } else {
            wp.g("bstsdk", sb.toString());
        }
    }
}
