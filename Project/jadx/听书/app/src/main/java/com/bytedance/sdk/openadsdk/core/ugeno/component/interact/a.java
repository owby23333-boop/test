package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.sy;
import com.bytedance.sdk.openadsdk.core.un.eo;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    dl f1333a;
    m dl;
    gc g;
    na z;

    public a(na naVar, boolean z, z zVar) {
        this.z = naVar;
        this.f1333a = new dl(this.z);
        this.g = new gc(this.z, z, zVar, this.f1333a);
        this.dl = new m(this.z, z, zVar, this.f1333a);
    }

    private boolean z(boolean z) {
        int iGz = eo.gz(this.z);
        if (iGz == 5 || iGz == 9) {
            return true;
        }
        return (iGz == 3 || iGz == 4) ? z : iGz == 7 || iGz == 8;
    }

    public void z(ViewGroup viewGroup, View view) {
        g(viewGroup, view);
        if ((viewGroup instanceof FrameLayout) || (viewGroup instanceof RelativeLayout)) {
            if (this.g.dl()) {
                int iDl = sy.m(this.z).dl();
                boolean z = iDl == 0 || iDl == 2;
                if (z(true)) {
                    this.f1333a.z(this.g.z(), z);
                    gc gcVar = this.g;
                    if (z) {
                        view = viewGroup;
                    }
                    gcVar.z(viewGroup, view, true);
                    return;
                }
                return;
            }
            if (this.dl.dl()) {
                int iG = sy.gc(this.z).g();
                boolean z2 = iG == 0 || iG == 2;
                if (z(false)) {
                    this.f1333a.z(this.dl.z(), z2);
                    m mVar = this.dl;
                    if (z2) {
                        view = viewGroup;
                    }
                    mVar.z(viewGroup, view, iG != 2);
                }
            }
        }
    }

    private void g(ViewGroup viewGroup, View view) {
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if ("easy_pfwv".equals(childAt.getTag())) {
                    viewGroup.removeView(childAt);
                    this.g.a();
                    this.dl.a();
                }
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                View childAt2 = viewGroup2.getChildAt(i2);
                if ("easy_pfwv".equals(childAt2.getTag())) {
                    viewGroup2.removeView(childAt2);
                    this.g.a();
                    this.dl.a();
                }
            }
        }
    }

    public e z() {
        if (this.g.dl()) {
            return this.g.g();
        }
        if (this.dl.dl()) {
            return this.dl.g();
        }
        return new e() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.a.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e
            public void dl() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e
            public void g() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e
            public void z() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e
            public void z(boolean z) {
            }
        };
    }

    public void z(com.bytedance.sdk.openadsdk.io.z.g.z.g gVar) {
        m mVar = this.dl;
        if (mVar != null) {
            mVar.z(gVar);
        }
        gc gcVar = this.g;
        if (gcVar != null) {
            gcVar.z(gVar);
        }
    }

    public void g() {
        this.g.a();
        this.dl.a();
    }
}
