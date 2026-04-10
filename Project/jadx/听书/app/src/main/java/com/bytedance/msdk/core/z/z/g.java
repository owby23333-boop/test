package com.bytedance.msdk.core.z.z;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.iq.fv;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g implements m {
    private String g;
    private Function<SparseArray<Object>, Object> z;

    @Override // com.bytedance.msdk.core.z.z.m
    public String a() {
        return "g_adn_version";
    }

    @Override // com.bytedance.msdk.core.z.z.m
    public String dl() {
        return "g_class_name";
    }

    @Override // com.bytedance.msdk.core.z.z.m
    public String gz() {
        return MediationConstant.ADN_GDT;
    }

    @Override // com.bytedance.msdk.core.z.z.m
    public boolean z() {
        return fv.z();
    }

    @Override // com.bytedance.msdk.core.z.z.m
    public Function<SparseArray<Object>, Object> g() {
        return gc.g(MediationConstant.ADN_GDT);
    }

    @Override // com.bytedance.msdk.core.z.z.m
    public String gc() {
        return uy.ls().un();
    }

    @Override // com.bytedance.msdk.core.z.z.m
    public void z(Function<SparseArray<Object>, Object> function) {
        this.z = function;
    }

    @Override // com.bytedance.msdk.core.z.z.m
    public Function<SparseArray<Object>, Object> m() {
        return this.z;
    }

    @Override // com.bytedance.msdk.core.z.z.m
    public void z(String str) {
        this.g = str;
    }

    @Override // com.bytedance.msdk.core.z.z.m
    public String e() {
        return this.g;
    }
}
