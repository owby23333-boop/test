package com.bytedance.sdk.component.gz.g.z;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {
    public abstract List<com.bytedance.sdk.component.gz.z.g> g(int i, com.bytedance.sdk.component.gz.z.g gVar, boolean z, List<String> list, String str);

    public abstract boolean g(int i, String str, com.bytedance.sdk.component.gz.z.g gVar);

    public abstract boolean z(com.bytedance.sdk.component.gz.z.g gVar);

    public abstract boolean z(String str);

    public List<com.bytedance.sdk.component.gz.z.g> z(int i, com.bytedance.sdk.component.gz.z.g gVar, boolean z, List<String> list, String str) {
        if (com.bytedance.sdk.component.gz.g.dl.z.z(i)) {
            return g(i, gVar, z, list, str);
        }
        if (z(gVar)) {
            return g(i, gVar, z, list, str);
        }
        return null;
    }

    public boolean z(int i, String str, com.bytedance.sdk.component.gz.z.g gVar) {
        if (com.bytedance.sdk.component.gz.g.dl.z.z(i)) {
            return z(str);
        }
        if (z(gVar)) {
            return g(i, str, gVar);
        }
        return false;
    }
}
