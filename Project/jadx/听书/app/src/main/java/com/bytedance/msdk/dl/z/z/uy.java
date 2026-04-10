package com.bytedance.msdk.dl.z.z;

import android.util.SparseArray;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.wp;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class uy extends dl {
    public uy(com.bytedance.msdk.dl.dl.g.z.z.g gVar, Function<SparseArray<Object>, Object> function) {
        super(gVar, function);
    }

    @Override // com.bytedance.msdk.g.dl
    public void z(ViewGroup viewGroup) {
        try {
            g(viewGroup);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public void g(ViewGroup viewGroup) {
        if (this.fo != null) {
            this.fo.m();
        }
        if (this.uy != null) {
            this.uy.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(6152).z(20060, viewGroup).z(Void.class).g());
        }
    }
}
