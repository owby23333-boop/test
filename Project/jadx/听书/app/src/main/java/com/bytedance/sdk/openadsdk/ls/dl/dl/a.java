package com.bytedance.sdk.openadsdk.ls.dl.dl;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public final PluginValueSet g;

    public a(SparseArray<Object> sparseArray) {
        this.g = com.bykv.z.z.z.z.z.z(sparseArray).g();
    }

    public boolean z() {
        return this.g.booleanValue(262101);
    }

    public dl fo() {
        SparseArray sparseArray = (SparseArray) this.g.objectValue(262102, SparseArray.class);
        if (sparseArray != null) {
            return new dl(sparseArray);
        }
        return null;
    }

    public boolean g() {
        return this.g.booleanValue(262103);
    }

    public boolean dl() {
        return this.g.booleanValue(262104);
    }

    public String uy() {
        return (String) this.g.objectValue(262105, String.class);
    }

    public boolean a() {
        return this.g.booleanValue(262106);
    }

    public String kb() {
        return (String) this.g.objectValue(262107, String.class);
    }

    public boolean gc() {
        return this.g.booleanValue(262108);
    }

    public String wp() {
        return (String) this.g.objectValue(262109, String.class);
    }

    public boolean m() {
        return this.g.booleanValue(262110);
    }

    public com.bytedance.sdk.openadsdk.mediation.init.z.g.z.g ls() {
        SparseArray sparseArray = (SparseArray) this.g.objectValue(262113, SparseArray.class);
        if (sparseArray != null) {
            return new com.bytedance.sdk.openadsdk.mediation.init.z.g.z.g(sparseArray);
        }
        return null;
    }

    public String v() {
        return (String) this.g.objectValue(262112, String.class);
    }

    public boolean e() {
        return this.g.booleanValue(262111);
    }

    public Map<String, Object> pf() {
        return (Map) this.g.objectValue(262119, Map.class);
    }

    public boolean gz() {
        return this.g.booleanValue(262120);
    }

    public static class z {
        private final com.bykv.z.z.z.z.z z = com.bykv.z.z.z.z.z.z();

        public z z(boolean z) {
            this.z.z(262101, z);
            return this;
        }

        public z z(dl dlVar) {
            this.z.z(262102, dlVar);
            return this;
        }

        public z g(boolean z) {
            this.z.z(262103, z);
            return this;
        }

        public z dl(boolean z) {
            this.z.z(262104, z);
            return this;
        }

        public z z(String str) {
            this.z.z(262105, str);
            return this;
        }

        public z a(boolean z) {
            this.z.z(262106, z);
            return this;
        }

        public z g(String str) {
            this.z.z(262107, str);
            return this;
        }

        public z gc(boolean z) {
            this.z.z(262108, z);
            return this;
        }

        public z dl(String str) {
            this.z.z(262109, str);
            return this;
        }

        public z m(boolean z) {
            this.z.z(262110, z);
            return this;
        }

        public z a(String str) {
            this.z.z(262112, str);
            return this;
        }

        public z e(boolean z) {
            this.z.z(262111, z);
            return this;
        }

        public a z() {
            return new a(this.z.g().sparseArray());
        }
    }

    public boolean i() {
        return this.g.booleanValue(262121);
    }
}
