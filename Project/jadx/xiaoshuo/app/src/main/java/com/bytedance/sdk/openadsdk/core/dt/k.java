package com.bytedance.sdk.openadsdk.core.dt;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.bf.tg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class k implements com.bytedance.sdk.component.adexpress.d {
    public final float bf;
    public final String bh;
    public final float d;
    public final float e;
    public final long ga;
    private JSONObject l;
    public final int m;
    public final int p;
    public final boolean s;
    public final String t;
    public final float tg;
    public final int v;
    public final long vn;
    public SparseArray<tg.e> w;
    public final String wu;
    public final String xu;
    public final int zk;

    public static class e {
        private long bf;
        private String bh;
        private long d;
        protected SparseArray<tg.e> e = new SparseArray<>();
        private float ga;
        private JSONObject l;
        private int m;
        private float p;
        private String s;
        private String t;
        private float tg;
        private int v;
        private float vn;
        private boolean w;
        private int wu;
        private String xu;
        private int zk;

        public e bf(long j) {
            this.d = j;
            return this;
        }

        public e d(float f) {
            this.vn = f;
            return this;
        }

        public e e(boolean z) {
            this.w = z;
            return this;
        }

        public e tg(float f) {
            this.p = f;
            return this;
        }

        public e bf(float f) {
            this.ga = f;
            return this;
        }

        public e d(int i) {
            this.m = i;
            return this;
        }

        public e e(long j) {
            this.bf = j;
            return this;
        }

        public e tg(int i) {
            this.wu = i;
            return this;
        }

        public e bf(int i) {
            this.zk = i;
            return this;
        }

        public e d(String str) {
            this.t = str;
            return this;
        }

        public e e(float f) {
            this.tg = f;
            return this;
        }

        public e tg(String str) {
            this.s = str;
            return this;
        }

        public e bf(String str) {
            this.bh = str;
            return this;
        }

        public e e(int i) {
            this.v = i;
            return this;
        }

        public e e(String str) {
            this.xu = str;
            return this;
        }

        public e e(SparseArray<tg.e> sparseArray) {
            this.e = sparseArray;
            return this;
        }

        public e e(JSONObject jSONObject) {
            this.l = jSONObject;
            return this;
        }

        public k e() {
            return new k(this);
        }
    }

    public JSONObject e() {
        if (this.l == null) {
            this.l = new JSONObject();
        }
        return this.l;
    }

    private k(e eVar) {
        this.e = eVar.p;
        this.bf = eVar.vn;
        this.d = eVar.ga;
        this.tg = eVar.tg;
        this.ga = eVar.d;
        this.vn = eVar.bf;
        this.p = eVar.v;
        this.v = eVar.zk;
        this.zk = eVar.m;
        this.m = eVar.wu;
        this.wu = eVar.xu;
        this.w = eVar.e;
        this.s = eVar.w;
        this.l = eVar.l;
        this.xu = eVar.bh;
        this.bh = eVar.t;
        this.t = eVar.s;
    }
}
