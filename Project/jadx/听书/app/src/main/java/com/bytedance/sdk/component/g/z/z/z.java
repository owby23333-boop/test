package com.bytedance.sdk.component.g.z.z;

import com.bytedance.sdk.component.g.z.wp;
import com.bytedance.sdk.component.g.z.z.g.dl;
import com.bytedance.sdk.component.g.z.z.z.m;
import com.bytedance.sdk.component.utils.wp;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static AtomicBoolean g = new AtomicBoolean(true);
    private static volatile z z;

    private z() {
    }

    public static z z() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    public void z(boolean z2) {
        wp.z("NetClientAdapter", "set useOkHttp:".concat(String.valueOf(z2)));
        g.set(z2);
    }

    public boolean g() {
        AtomicBoolean atomicBoolean = g;
        if (atomicBoolean == null) {
            return true;
        }
        return atomicBoolean.get();
    }

    public static com.bytedance.sdk.component.g.z.wp z(wp.z zVar) {
        return new dl(zVar);
    }

    public static com.bytedance.sdk.component.g.z.wp g(wp.z zVar) {
        return new m(zVar);
    }
}
