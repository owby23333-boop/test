package com.bytedance.msdk.dl.z.z;

import android.app.Activity;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.wp;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class m extends dl {
    public m(com.bytedance.msdk.dl.dl.g.z.z.g gVar, Function<SparseArray<Object>, Object> function) {
        super(gVar, function);
    }

    @Override // com.bytedance.msdk.g.dl
    public void z(Activity activity, Object obj, String str) {
        try {
            dl(activity);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public void dl(Activity activity) {
        if (this.fo != null) {
            this.fo.m();
        }
        if (this.uy != null) {
            this.uy.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8113).z(Void.class).z(20033, activity).g());
        }
    }
}
