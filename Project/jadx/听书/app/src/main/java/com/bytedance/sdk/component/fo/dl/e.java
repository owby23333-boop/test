package com.bytedance.sdk.component.fo.dl;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static HashMap<Integer, z> dl;
    private static HashMap<Integer, gc> g;
    private static volatile e z;

    private e() {
        g = new HashMap<>();
        dl = new HashMap<>();
    }

    public static synchronized e z() {
        if (z == null) {
            synchronized (e.class) {
                if (z == null) {
                    z = new e();
                }
            }
        }
        return z;
    }

    public gc z(int i) {
        gc gcVar = g.get(Integer.valueOf(i));
        if (gcVar != null) {
            return gcVar;
        }
        gc gcVar2 = new gc(i);
        g.put(Integer.valueOf(i), gcVar2);
        return gcVar2;
    }

    public z z(int i, Context context) {
        z zVar = dl.get(Integer.valueOf(i));
        if (zVar != null) {
            return zVar;
        }
        z zVar2 = new z(context, i);
        dl.put(Integer.valueOf(i), zVar2);
        return zVar2;
    }
}
