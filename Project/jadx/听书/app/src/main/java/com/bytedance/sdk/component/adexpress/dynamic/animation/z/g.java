package com.bytedance.sdk.component.adexpress.dynamic.animation.z;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g implements com.bytedance.sdk.component.adexpress.dynamic.dynamicview.gc {
    List<a> z = new ArrayList();

    public g(View view, List<com.bytedance.sdk.component.adexpress.dynamic.dl.z> list) {
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.dl.z> it = list.iterator();
        while (it.hasNext()) {
            a aVarZ = dl.z().z(view, it.next());
            if (aVarZ != null) {
                this.z.add(aVarZ);
            }
        }
    }

    public void z() {
        Iterator<a> it = this.z.iterator();
        while (it.hasNext()) {
            try {
                it.next().dl();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.gc
    public void g() {
        Iterator<a> it = this.z.iterator();
        while (it.hasNext()) {
            try {
                it.next().g();
            } catch (Exception unused) {
            }
        }
    }
}
