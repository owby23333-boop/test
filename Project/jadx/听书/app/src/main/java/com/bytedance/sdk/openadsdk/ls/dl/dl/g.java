package com.bytedance.sdk.openadsdk.ls.dl.dl;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public final PluginValueSet z;

    public g(SparseArray<Object> sparseArray) {
        this.z = com.bykv.z.z.z.z.z.z(sparseArray).g();
    }

    public String z() {
        return (String) this.z.objectValue(260001, String.class);
    }

    public String g() {
        return (String) this.z.objectValue(260002, String.class);
    }

    public String dl() {
        return (String) this.z.objectValue(260003, String.class);
    }

    public String a() {
        return (String) this.z.objectValue(260004, String.class);
    }

    public boolean gc() {
        return this.z.booleanValue(260005);
    }

    public int m() {
        return this.z.intValue(260006);
    }

    public int e() {
        return this.z.intValue(260007);
    }

    public float gz() {
        return this.z.floatValue(260008);
    }

    public float fo() {
        return this.z.floatValue(260009);
    }

    public boolean uy() {
        return this.z.booleanValue(260010);
    }

    public boolean kb() {
        return this.z.booleanValue(260011);
    }

    public int wp() {
        return this.z.intValue(2600012);
    }

    public String i() {
        return (String) this.z.objectValue(260013, String.class);
    }

    public String v() {
        return (String) this.z.objectValue(260014, String.class);
    }

    public int pf() {
        return this.z.intValue(260015);
    }

    public int ls() {
        return this.z.intValue(260016);
    }

    public int[] p() {
        return (int[]) this.z.objectValue(260017, int[].class);
    }

    public int fv() {
        return this.z.intValue(260018);
    }

    public String js() {
        return (String) this.z.objectValue(260019, String.class);
    }

    public int tb() {
        return this.z.intValue(260020);
    }

    public String q() {
        return (String) this.z.objectValue(260021, String.class);
    }

    public String iq() {
        return (String) this.z.objectValue(260022, String.class);
    }

    public Object zw() {
        return this.z.objectValue(260023, Object.class);
    }

    public String io() {
        return (String) this.z.objectValue(260024, String.class);
    }

    public int uf() {
        return this.z.intValue(260025);
    }

    public boolean sy() {
        return this.z.booleanValue(260026);
    }

    public static class z {
        private final com.bykv.z.z.z.z.z z;

        public z() {
            this.z = com.bykv.z.z.z.z.z.z();
        }

        public z(g gVar) {
            this.z = com.bykv.z.z.z.z.z.z(gVar.z);
        }

        public z z(String str) {
            this.z.z(260001, str);
            return this;
        }

        public z g(String str) {
            this.z.z(260002, str);
            return this;
        }

        public z dl(String str) {
            this.z.z(260003, str);
            return this;
        }

        public z a(String str) {
            this.z.z(260004, str);
            return this;
        }

        public z z(boolean z) {
            this.z.z(260005, z);
            return this;
        }

        public z z(int i) {
            this.z.z(260006, i);
            return this;
        }

        public z g(int i) {
            this.z.z(260007, i);
            return this;
        }

        public z z(float f) {
            this.z.z(260008, f);
            return this;
        }

        public z g(float f) {
            this.z.z(260009, f);
            return this;
        }

        public z g(boolean z) {
            this.z.z(260010, z);
            return this;
        }

        public z dl(boolean z) {
            this.z.z(260011, z);
            return this;
        }

        public z dl(int i) {
            this.z.z(2600012, i);
            return this;
        }

        public z gc(String str) {
            this.z.z(260013, str);
            return this;
        }

        public z m(String str) {
            this.z.z(260014, str);
            return this;
        }

        public z a(int i) {
            this.z.z(260015, i);
            return this;
        }

        public z gc(int i) {
            this.z.z(260016, i);
            return this;
        }

        public z z(int[] iArr) {
            this.z.z(260017, iArr);
            return this;
        }

        public z m(int i) {
            this.z.z(260018, i);
            return this;
        }

        public z e(String str) {
            this.z.z(260019, str);
            return this;
        }

        public z e(int i) {
            this.z.z(260020, i);
            return this;
        }

        public z gz(String str) {
            this.z.z(260021, str);
            return this;
        }

        public z fo(String str) {
            this.z.z(260022, str);
            return this;
        }

        public z z(Object obj) {
            this.z.z(260023, obj);
            return this;
        }

        public z uy(String str) {
            this.z.z(260024, str);
            return this;
        }

        public z gz(int i) {
            this.z.z(260025, i);
            return this;
        }

        public z a(boolean z) {
            this.z.z(260026, z);
            return this;
        }

        public g z() {
            return new g(this.z.g().sparseArray());
        }
    }
}
