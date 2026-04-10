package com.bytedance.sdk.openadsdk.core.bf.e;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.dt.h;
import com.bytedance.sdk.openadsdk.core.dt.zk;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public abstract class e {
    protected Context bf;
    protected zk d;
    protected h e;
    protected View tg;

    public void e(View view) {
        this.tg = view;
    }

    public abstract boolean e(Map<String, Object> map);

    public void e(zk zkVar) {
        this.d = zkVar;
    }
}
