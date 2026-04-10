package com.bytedance.sdk.openadsdk.mediation;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.ls.z.z.pf;
import com.bytedance.sdk.openadsdk.mediation.g.z.z.g;

/* JADX INFO: loaded from: classes2.dex */
public class MediationManagerVisitor {
    private static volatile Object g;
    private static volatile MediationManagerVisitor z;
    private g dl;

    public static MediationManagerVisitor getInstance() {
        if (z == null) {
            synchronized (MediationManagerVisitor.class) {
                if (z == null) {
                    z = new MediationManagerVisitor();
                }
            }
        }
        return z;
    }

    private MediationManagerVisitor() {
    }

    public synchronized IMediationManager getMediationManager() {
        Bundle bundle = new Bundle();
        bundle.putString("mediation_manager", "mediation_manager");
        TTAdManager adManager = TTAdSdk.getAdManager();
        Object obj = g;
        if (adManager != null) {
            g = adManager.getExtra(null, bundle);
        }
        if (g == null) {
            return null;
        }
        if (this.dl == null) {
            this.dl = new g(pf.z(g));
        } else if (obj != g) {
            this.dl.z(pf.z(g));
        }
        return this.dl;
    }
}
