package com.bytedance.sdk.openadsdk.core.kb.dl;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.eo;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.multipro.g.z;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class dl implements com.bytedance.sdk.openadsdk.core.kb.g.dl {
    protected WeakReference<z.InterfaceC0190z> g;
    protected boolean z = true;

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void g(boolean z) {
        this.z = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z(z.InterfaceC0190z interfaceC0190z) {
        this.g = new WeakReference<>(interfaceC0190z);
    }

    protected boolean z(Context context, na naVar, String str) {
        if (!this.z || !com.bytedance.sdk.openadsdk.core.un.m.z(naVar) || !eo.z(context, naVar, com.bytedance.sdk.openadsdk.core.un.eo.g(str), str, m())) {
            return false;
        }
        TTNativePageActivity.z(this);
        return true;
    }

    private String m() {
        z.InterfaceC0190z interfaceC0190z;
        com.bytedance.sdk.openadsdk.core.multipro.g.z zVarX;
        WeakReference<z.InterfaceC0190z> weakReference = this.g;
        if (weakReference == null || (interfaceC0190z = weakReference.get()) == null || (zVarX = interfaceC0190z.x()) == null) {
            return null;
        }
        return zVarX.z().toString();
    }

    public int e() {
        return hashCode();
    }
}
