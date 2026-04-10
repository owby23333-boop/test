package com.bytedance.sdk.openadsdk.ls.dl.dl;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public final PluginValueSet z;

    public z(SparseArray<Object> sparseArray) {
        this.z = com.bykv.z.z.z.z.z.z(sparseArray).g();
    }

    public String z() {
        return (String) this.z.objectValue(261001, String.class);
    }

    public String g() {
        return (String) this.z.objectValue(261002, String.class);
    }

    public boolean dl() {
        return this.z.booleanValue(261003);
    }

    public String a() {
        return (String) this.z.objectValue(261004, String.class);
    }

    public String gc() {
        return (String) this.z.objectValue(261005, String.class);
    }

    public int m() {
        return this.z.intValue(261006);
    }

    public boolean e() {
        return this.z.booleanValue(261007);
    }

    public boolean gz() {
        return this.z.booleanValue(261008);
    }

    public int[] fo() {
        return (int[]) this.z.objectValue(261009, int[].class);
    }

    public boolean uy() {
        return this.z.booleanValue(261011);
    }

    public a kb() {
        SparseArray sparseArray = (SparseArray) this.z.objectValue(261012, SparseArray.class);
        if (sparseArray != null) {
            return new a(sparseArray);
        }
        return null;
    }

    public int wp() {
        return this.z.intValue(261013);
    }

    public int i() {
        return this.z.intValue(261014);
    }

    public int v() {
        return this.z.intValue(261015);
    }

    public com.bytedance.sdk.openadsdk.mediation.init.z.g.z.z pf() {
        SparseArray sparseArray = (SparseArray) this.z.objectValue(261016, SparseArray.class);
        if (sparseArray != null) {
            return new com.bytedance.sdk.openadsdk.mediation.init.z.g.z.z(sparseArray);
        }
        return null;
    }

    public boolean ls() {
        return this.z.booleanValue(261017);
    }

    public Map<String, Object> p() {
        return (Map) this.z.objectValue(261018, Map.class);
    }
}
