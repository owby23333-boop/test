package com.bytedance.sdk.openadsdk.core.kb.dl.dl;

import android.content.Context;
import com.bytedance.sdk.component.utils.hh;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.uy;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f1220a = true;
    protected int dl;
    protected na g;
    protected Context z;

    abstract boolean dl();

    public void z(Context context) {
        this.z = context;
    }

    public void z(na naVar) {
        this.g = naVar;
    }

    public void z(boolean z) {
        this.f1220a = z;
    }

    public boolean z() {
        Context context;
        if (this.g == null || (context = this.z) == null) {
            return true;
        }
        if (!this.f1220a) {
            return false;
        }
        if (v.dl(context) == 0) {
            try {
                Context context2 = this.z;
                hh.z(context2, tb.z(context2, "tt_no_network"), 0);
            } catch (Throwable unused) {
            }
        }
        boolean zDl = dl();
        if (zDl) {
            m.z = true;
            m.dl = true;
        }
        return zDl;
    }

    public int g() {
        return this.dl;
    }

    protected boolean a() {
        int iDl = v.dl(this.z);
        na naVar = this.g;
        if (naVar == null) {
            return false;
        }
        int iPf = com.bytedance.sdk.openadsdk.core.iq.tb.pf(naVar);
        if (iPf == -1) {
            return !uy.ls().dl(iDl);
        }
        if (iPf == 0) {
            return false;
        }
        if (iPf != 2) {
            if (iPf != 3) {
                if (uy.ls().dl(iDl)) {
                    return false;
                }
                com.bytedance.sdk.openadsdk.core.iq.gc gcVarC = this.g.c();
                if (((gcVarC == null || gcVarC.e() <= 0) ? 104857600 : gcVarC.e()) <= com.bytedance.sdk.openadsdk.core.iq.tb.ls(this.g)) {
                    return false;
                }
            }
        } else if (iDl == 4) {
            return false;
        }
        return true;
    }
}
