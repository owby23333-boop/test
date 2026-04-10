package com.bytedance.sdk.openadsdk.core.g.z;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.iq.uy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f1070a;
    private uy dl;
    private final com.bytedance.sdk.openadsdk.core.g.a e;
    private volatile int gc;
    private List<z> z = new ArrayList();
    private Map<String, Object> g = new HashMap();
    private volatile int m = 0;

    public dl(com.bytedance.sdk.openadsdk.core.g.a aVar) {
        this.e = aVar;
    }

    public void z(View view) {
        this.f1070a = view;
    }

    public void z(z zVar) {
        this.z.add(zVar);
    }

    public void z(uy uyVar) {
        this.dl = uyVar;
        Iterator<z> it = this.z.iterator();
        while (it.hasNext()) {
            it.next().z(this.dl);
        }
    }

    private void g() {
        this.gc = 0;
        this.m = 0;
    }

    public void z() {
        ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) this.e.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(false);
        g();
        z(0);
    }

    private void z(int i) {
        int size = this.z.size();
        while (i < size) {
            int i2 = i + 1;
            this.gc = i2;
            z zVar = this.z.get(i);
            zVar.z(this.f1070a);
            this.m = zVar.z(this.g, this);
            if (this.m != 0) {
                if (this.m == 2) {
                    ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) this.e.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(this.g, this);
                    return;
                }
                return;
            }
            i = i2;
        }
    }

    public <T extends z> T z(Class<T> cls) {
        return (T) this.e.z(cls);
    }
}
