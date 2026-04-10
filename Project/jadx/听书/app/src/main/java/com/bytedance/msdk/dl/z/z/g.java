package com.bytedance.msdk.dl.z.z;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.component.utils.wp;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g extends dl {
    public g(com.bytedance.msdk.dl.dl.g.z.z.g gVar, Function<SparseArray<Object>, Object> function) {
        super(gVar, function);
    }

    @Override // com.bytedance.msdk.g.dl
    public View fo() {
        return qz();
    }

    public View qz() {
        try {
            if (this.uy != null) {
                Object objApply = this.uy.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8113).z(View.class).g());
                if (objApply instanceof View) {
                    return (View) objApply;
                }
                return null;
            }
        } catch (Exception e) {
            wp.z(e);
        }
        return null;
    }
}
