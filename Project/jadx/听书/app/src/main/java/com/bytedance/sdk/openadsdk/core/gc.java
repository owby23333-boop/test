package com.bytedance.sdk.openadsdk.core;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.un.z;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements z.g {
    private final Map<Integer, WeakReference<z.g>> z = new HashMap();

    gc() {
    }

    public void z(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return;
        }
        function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(9).z(Boolean.class).z(0, new com.bytedance.sdk.openadsdk.core.ti.z() { // from class: com.bytedance.sdk.openadsdk.core.gc.1
            @Override // com.bytedance.sdk.openadsdk.core.ti.z
            public void z() {
                gc.this.g();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ti.z
            public void g() {
                gc.this.z();
            }
        }).g());
    }

    public void z(z.g gVar) {
        if (gVar == null) {
            return;
        }
        this.z.put(Integer.valueOf(gVar.hashCode()), new WeakReference<>(gVar));
    }

    @Override // com.bytedance.sdk.openadsdk.core.un.z.g
    public void g() {
        Iterator<Map.Entry<Integer, WeakReference<z.g>>> it = this.z.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<z.g> value = it.next().getValue();
            if (value != null) {
                z.g gVar = value.get();
                if (gVar != null) {
                    gVar.g();
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.un.z.g
    public void z() {
        Iterator<Map.Entry<Integer, WeakReference<z.g>>> it = this.z.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<z.g> value = it.next().getValue();
            if (value != null) {
                z.g gVar = value.get();
                if (gVar != null) {
                    gVar.z();
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }
}
