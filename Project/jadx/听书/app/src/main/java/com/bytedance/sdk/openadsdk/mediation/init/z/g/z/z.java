package com.bytedance.sdk.openadsdk.mediation.init.z.g.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public final PluginValueSet z;

    public z(SparseArray<Object> sparseArray) {
        this.z = com.bykv.z.z.z.z.z.z(sparseArray).g();
    }

    public String z() {
        return (String) this.z.objectValue(264101, String.class);
    }

    public boolean g() {
        return this.z.booleanValue(264102);
    }

    public dl dl() {
        SparseArray sparseArray = (SparseArray) this.z.objectValue(264103, SparseArray.class);
        if (sparseArray == null) {
            return null;
        }
        return new dl(sparseArray);
    }

    public Map<String, Object> a() {
        return (Map) this.z.objectValue(264104, Map.class);
    }

    public boolean gc() {
        return this.z.booleanValue(264105);
    }

    public JSONObject m() {
        return (JSONObject) this.z.objectValue(264106, JSONObject.class);
    }

    public String e() {
        return (String) this.z.objectValue(264107, String.class);
    }

    public boolean gz() {
        return this.z.booleanValue(264108);
    }

    public boolean fo() {
        return this.z.booleanValue(264109);
    }

    public boolean uy() {
        return this.z.booleanValue(264110);
    }

    public String kb() {
        return (String) this.z.objectValue(264111, String.class);
    }
}
