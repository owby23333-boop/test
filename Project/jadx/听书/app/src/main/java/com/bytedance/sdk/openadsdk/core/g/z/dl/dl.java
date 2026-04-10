package com.bytedance.sdk.openadsdk.core.g.z.dl;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.i.a;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends g {
    private Map<String, Object> e;
    private EmptyView fo;
    z gc;
    private Double gz;
    private String m;

    public interface z {
        boolean z();
    }

    public void z(z zVar) {
        this.gc = zVar;
    }

    public void z(String str) {
        this.m = str;
    }

    public void z(EmptyView emptyView) {
        this.fo = emptyView;
    }

    public void z(Map<String, Object> map) {
        Map<String, Object> map2 = this.e;
        if (map2 == null) {
            this.e = map;
        } else {
            map2.putAll(map);
        }
    }

    public void z(Double d) {
        this.gz = d;
    }

    public dl() {
    }

    public dl(na naVar, Context context) {
        this.z = naVar;
        this.g = context;
        this.e = new HashMap();
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.z.dl.g, com.bytedance.sdk.openadsdk.core.g.z.z
    public int z(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.g.z.dl dlVar) {
        z zVar;
        if (!zw.g().fn() || (zVar = this.gc) == null || zVar.z()) {
            return 0;
        }
        EmptyView emptyView = this.fo;
        if (emptyView == null) {
            this.e.put("show_send_type", 1);
            a.z(this.z, this.m, this.e, this.gz);
        } else {
            emptyView.z("checkWhenClicked");
        }
        return 0;
    }
}
