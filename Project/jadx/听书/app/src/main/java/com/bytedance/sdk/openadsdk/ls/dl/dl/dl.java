package com.bytedance.sdk.openadsdk.ls.dl.dl;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public PluginValueSet z;

    public dl(SparseArray<Object> sparseArray) {
        this.z = com.bykv.z.z.z.z.z.z(sparseArray).g();
    }

    public double z() {
        return this.z.doubleValue(262001);
    }

    public double g() {
        return this.z.doubleValue(262002);
    }

    public static class z {
        private final com.bytedance.sdk.openadsdk.ls.a z = com.bytedance.sdk.openadsdk.ls.a.z();

        public z z(double d) {
            this.z.z(262001, Double.valueOf(d));
            return this;
        }

        public z g(double d) {
            this.z.z(262002, Double.valueOf(d));
            return this;
        }

        public dl z() {
            return new dl(this.z.g());
        }
    }
}
