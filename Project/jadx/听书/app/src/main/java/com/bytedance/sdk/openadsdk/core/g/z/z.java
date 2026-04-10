package com.bytedance.sdk.openadsdk.core.g.z;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.uy;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected View f1076a;
    protected uy dl;
    protected Context g;
    protected na z;

    public abstract int z(Map<String, Object> map, dl dlVar);

    public void z(uy uyVar) {
        this.dl = uyVar;
    }

    public void z(View view) {
        this.f1076a = view;
    }
}
