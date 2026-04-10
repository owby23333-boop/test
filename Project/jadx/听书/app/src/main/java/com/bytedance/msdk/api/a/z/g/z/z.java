package com.bytedance.msdk.api.a.z.g.z;

import android.view.View;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z extends com.bytedance.msdk.api.a.z.g.g.z {
    public abstract View g();

    public final View z() {
        try {
            return g();
        } catch (Exception e) {
            wp.z(e);
            return null;
        }
    }
}
