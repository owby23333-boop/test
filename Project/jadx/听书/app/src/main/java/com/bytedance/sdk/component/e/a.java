package com.bytedance.sdk.component.e;

import android.content.Context;
import com.bytedance.sdk.component.a.fo;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile boolean f700a;
        private volatile int dl;
        private volatile String g;
        private volatile boolean gc;
        private volatile int m;
        private volatile Context z;

        public z z(Context context) {
            if (context == null) {
                return this;
            }
            this.z = context.getApplicationContext();
            dl.z(this.z);
            return this;
        }

        public z z(String str) {
            this.g = str;
            return this;
        }

        public z z(int i) {
            this.dl = i;
            return this;
        }

        public z z(boolean z) {
            this.f700a = z;
            return this;
        }

        public z g(int i) {
            this.m = i;
            return this;
        }

        public com.bytedance.sdk.component.a.g.dl z() {
            if (this.dl == 2) {
                return dl();
            }
            return g();
        }

        private com.bytedance.sdk.component.a.g.dl g() {
            if (this.f700a) {
                return com.bytedance.sdk.component.e.dl.z.z.z(this.g);
            }
            return ((fo) com.bytedance.sdk.openadsdk.ats.dl.z("kv_store_factory")).get(this.g);
        }

        private com.bytedance.sdk.component.a.g.dl dl() {
            com.bytedance.sdk.component.a.g.dl dlVarZ = com.bytedance.sdk.component.e.g.z.z.z(this.z, this.g, this.f700a, this.m);
            this.gc = true;
            if (dlVarZ != null) {
                return dlVarZ;
            }
            this.gc = false;
            return g();
        }
    }
}
