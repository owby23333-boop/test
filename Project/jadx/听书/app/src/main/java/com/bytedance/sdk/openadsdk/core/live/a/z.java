package com.bytedance.sdk.openadsdk.core.live.a;

import com.bytedance.sdk.openadsdk.core.io;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public final List<String> g = new ArrayList();
    public final String z;

    public z(String str) {
        this.z = str;
    }

    public static void z(String str, String str2) {
        z zVar = (z) io.z(str, z.class);
        if (zVar == null) {
            z zVar2 = new z(str);
            zVar2.z(str2);
            io.z(str, zVar2, z.class);
            return;
        }
        zVar.z(str2);
    }

    public void z(String str) {
        this.g.add(str);
    }
}
