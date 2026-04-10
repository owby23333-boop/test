package com.bytedance.sdk.openadsdk.core.component.reward.dl;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.g;
import com.bytedance.sdk.openadsdk.core.iq.bm;
import com.bytedance.sdk.openadsdk.core.iq.na;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f944a;
    protected boolean dl;
    protected int g;
    protected boolean gc;
    protected boolean m;
    protected int z;

    public z(Activity activity, na naVar) {
        super(activity, naVar);
    }

    public z(Activity activity, na naVar, bm bmVar) {
        super(activity, naVar, bmVar);
    }

    public void z(int i) {
        this.z = i;
    }

    public void g(int i) {
        this.g = i;
    }

    public void z(boolean z) {
        this.dl = z;
    }

    public void g(boolean z) {
        this.f944a = z;
    }

    public void dl(boolean z) {
        this.m = z;
    }

    public void a(boolean z) {
        this.gc = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public g.z g(uy uyVar) {
        i iVar = new i(this.gz, this.e);
        iVar.g(this.f944a);
        iVar.z(this.dl);
        iVar.z(this.z);
        iVar.g(this.g);
        iVar.a(this.kb);
        iVar.dl(this.wp);
        iVar.z(this.ls);
        iVar.g(this.pf);
        iVar.dl(this.m);
        iVar.a(this.gc);
        return iVar.g(uyVar);
    }
}
