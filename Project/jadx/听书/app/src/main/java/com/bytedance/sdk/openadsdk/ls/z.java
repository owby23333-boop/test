package com.bytedance.sdk.openadsdk.ls;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PluginValueSet f1441a;
    private String dl;
    private int g;
    private boolean z;

    public z(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
            this.z = pluginValueSetG.booleanValue(-999903);
            this.g = pluginValueSetG.intValue(-999900);
            this.dl = pluginValueSetG.stringValue(-999901);
            this.f1441a = com.bykv.z.z.z.z.z.z((SparseArray<Object>) pluginValueSetG.objectValue(-999902, SparseArray.class)).g();
        }
    }

    public boolean z() {
        return this.z;
    }

    public int g() {
        return this.g;
    }

    public String dl() {
        return this.dl;
    }

    public PluginValueSet a() {
        return this.f1441a;
    }
}
