package com.bytedance.sdk.openadsdk.core.un;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public class un {
    private static final Set<Integer> z = new CopyOnWriteArraySet();
    private static final com.bytedance.sdk.component.utils.zw g = new com.bytedance.sdk.component.utils.zw() { // from class: com.bytedance.sdk.openadsdk.core.un.un.1
        @Override // com.bytedance.sdk.component.utils.zw
        public boolean z(int i) {
            if (com.bytedance.sdk.openadsdk.core.zw.g().sz()) {
                return un.z.contains(Integer.valueOf(i));
            }
            return true;
        }
    };

    public static com.bytedance.sdk.component.widget.g.z z(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (naVar == null) {
            return null;
        }
        com.bytedance.sdk.component.widget.g.z zVar = new com.bytedance.sdk.component.widget.g.z();
        zVar.z(naVar.gc());
        zVar.z(naVar.vk());
        zVar.g(naVar.mj());
        return zVar;
    }

    public static void z() {
        if (com.bytedance.sdk.openadsdk.core.zw.g().sz()) {
            com.bytedance.sdk.component.utils.iq.z(g);
        } else {
            z.clear();
        }
    }

    public static void z(int i) {
        if (com.bytedance.sdk.openadsdk.core.zw.g().sz()) {
            z.add(Integer.valueOf(i));
        }
        g.dl(i);
    }

    public static void g(int i) {
        z.remove(Integer.valueOf(i));
        g.g(i);
    }
}
