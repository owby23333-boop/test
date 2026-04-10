package com.bytedance.sdk.openadsdk.core.uf;

import com.bytedance.sdk.openadsdk.core.q;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {
    private static final String z = "m";
    private final Set<String> g = new HashSet(1);

    public abstract void z();

    public abstract void z(String str);

    public synchronized boolean g(String str) {
        return true;
    }

    protected final synchronized boolean z(String str, int i) {
        if (i == 0) {
            return z(str, a.GRANTED);
        }
        return z(str, a.DENIED);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.uf.m$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[a.values().length];
            z = iArr;
            try {
                iArr[a.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[a.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                z[a.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    protected final synchronized boolean z(final String str, a aVar) {
        this.g.remove(str);
        int i = AnonymousClass5.z[aVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.uf.m.2
                    @Override // java.lang.Runnable
                    public void run() {
                        m.this.z(str);
                    }
                });
                return true;
            }
            if (i == 3) {
                if (g(str)) {
                    if (this.g.isEmpty()) {
                        q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.uf.m.3
                            @Override // java.lang.Runnable
                            public void run() {
                                m.this.z();
                            }
                        });
                        return true;
                    }
                } else {
                    q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.uf.m.4
                        @Override // java.lang.Runnable
                        public void run() {
                            m.this.z(str);
                        }
                    });
                    return true;
                }
            }
        } else if (this.g.isEmpty()) {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.uf.m.1
                @Override // java.lang.Runnable
                public void run() {
                    m.this.z();
                }
            });
            return true;
        }
        return false;
    }

    protected final synchronized void z(String[] strArr) {
        Collections.addAll(this.g, strArr);
    }
}
