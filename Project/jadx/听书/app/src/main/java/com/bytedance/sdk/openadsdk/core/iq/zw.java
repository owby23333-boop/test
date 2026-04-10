package com.bytedance.sdk.openadsdk.core.iq;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.g.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class zw implements com.bytedance.sdk.component.adexpress.dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f1208a;
    public final float dl;
    public final int e;
    public final int fo;
    public int fv;
    public final float g;
    public final long gc;
    public final int gz;
    public final String i;
    private JSONObject js;
    public final String kb;
    public SparseArray<a.z> ls;
    public final long m;
    public String p;
    public final boolean pf;
    public final int uy;
    public final String v;
    public final String wp;
    public final float z;

    private zw(z zVar) {
        this.fv = -1;
        this.z = zVar.e;
        this.g = zVar.m;
        this.dl = zVar.gc;
        this.f1208a = zVar.f1209a;
        this.gc = zVar.dl;
        this.m = zVar.g;
        this.e = zVar.gz;
        this.gz = zVar.fo;
        this.fo = zVar.uy;
        this.uy = zVar.kb;
        this.kb = zVar.wp;
        this.ls = zVar.z;
        this.pf = zVar.ls;
        this.js = zVar.p;
        this.wp = zVar.i;
        this.i = zVar.v;
        this.v = zVar.pf;
        this.p = zVar.fv;
        this.fv = zVar.js;
    }

    public JSONObject z() {
        if (this.js == null) {
            this.js = new JSONObject();
        }
        return this.js;
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f1209a;
        private long dl;
        private float e;
        private int fo;
        private String fv;
        private long g;
        private float gc;
        private int gz;
        private String i;
        private int kb;
        private boolean ls;
        private float m;
        private JSONObject p;
        private String pf;
        private int uy;
        private String v;
        private String wp;
        protected SparseArray<a.z> z = new SparseArray<>();
        private int js = -1;

        public z z(boolean z) {
            this.ls = z;
            return this;
        }

        public z z(long j) {
            this.g = j;
            return this;
        }

        public z g(long j) {
            this.dl = j;
            return this;
        }

        public z z(float f) {
            this.f1209a = f;
            return this;
        }

        public z g(float f) {
            this.gc = f;
            return this;
        }

        public z dl(float f) {
            this.m = f;
            return this;
        }

        public z a(float f) {
            this.e = f;
            return this;
        }

        public z z(int i) {
            this.gz = i;
            return this;
        }

        public z g(int i) {
            this.fo = i;
            return this;
        }

        public z dl(int i) {
            this.uy = i;
            return this;
        }

        public z a(int i) {
            this.kb = i;
            return this;
        }

        public z z(String str) {
            this.wp = str;
            return this;
        }

        public z z(SparseArray<a.z> sparseArray) {
            this.z = sparseArray;
            return this;
        }

        public z z(JSONObject jSONObject) {
            this.p = jSONObject;
            return this;
        }

        public z g(String str) {
            this.i = str;
            return this;
        }

        public z dl(String str) {
            this.v = str;
            return this;
        }

        public z a(String str) {
            this.pf = str;
            return this;
        }

        public z gc(String str) {
            this.fv = str;
            return this;
        }

        public z gc(int i) {
            this.js = i;
            return this;
        }

        public zw z() {
            return new zw(this);
        }
    }
}
