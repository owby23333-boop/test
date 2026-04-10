package com.bytedance.sdk.openadsdk.core.gc.gc;

/* JADX INFO: loaded from: classes2.dex */
public class m<T> implements gc<T> {
    private final gc<T> z;

    public m(gc<T> gcVar) {
        this.z = gcVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.gc.gc
    public void z(final T t) {
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.gc.gc.m.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.z != null) {
                    m.this.z.z(t);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.gc.gc
    public void g(final T t) {
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.gc.gc.m.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.z != null) {
                    m.this.z.g(t);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.gc.gc
    public void z(final int i, final String str) {
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.gc.gc.m.3
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.z != null) {
                    m.this.z.z(i, str);
                }
            }
        });
    }
}
