package com.bytedance.sdk.openadsdk.m.dl;

import com.bytedance.sdk.openadsdk.core.iq.na;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bykv.vk.openvk.component.video.api.dl.a f1449a;
    private int dl;
    private String g;
    private na gc;
    private long z;

    public p(long j, String str, int i, com.bykv.vk.openvk.component.video.api.dl.a aVar, na naVar) {
        this.z = j;
        this.g = str;
        this.dl = i;
        this.f1449a = aVar;
        this.gc = naVar;
    }

    public long z() {
        return this.z;
    }

    public String g() {
        return this.g;
    }

    public int dl() {
        return this.dl;
    }

    public com.bykv.vk.openvk.component.video.api.dl.a a() {
        return this.f1449a;
    }

    public na gc() {
        return this.gc;
    }

    public static class z {
        private int fo;
        private int gz;
        private int kb;
        private Map<String, Object> pf;
        private int uy;
        private JSONArray v;
        private int wp;
        private long z = 0;
        private long g = 0;
        private long dl = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1450a = false;
        private boolean gc = false;
        private int m = 0;
        private int e = 0;
        private boolean i = false;

        public void z(JSONArray jSONArray) {
            this.v = jSONArray;
        }

        public JSONArray z() {
            return this.v;
        }

        public long g() {
            return this.z;
        }

        public void z(long j) {
            this.z = j;
        }

        public long dl() {
            return this.g;
        }

        public void g(long j) {
            this.g = j;
        }

        public long a() {
            return this.dl;
        }

        public void dl(long j) {
            this.dl = j;
        }

        public int gc() {
            return this.m;
        }

        public void z(int i) {
            this.m = i;
        }

        public int m() {
            return this.e;
        }

        public void g(int i) {
            this.e = i;
        }

        public int e() {
            return this.gz;
        }

        public void dl(int i) {
            this.gz = i;
        }

        public int gz() {
            return this.fo;
        }

        public void a(int i) {
            this.fo = i;
        }

        public int fo() {
            long j = this.dl;
            if (j <= 0) {
                return 0;
            }
            return Math.min((int) ((this.z * 100) / j), 100);
        }

        public int uy() {
            return this.uy;
        }

        public void gc(int i) {
            this.uy = i;
        }

        public int kb() {
            return this.kb;
        }

        public int wp() {
            return this.wp;
        }

        public void m(int i) {
            this.wp = i;
        }

        public boolean i() {
            return this.i;
        }

        public void z(boolean z) {
            this.i = z;
        }

        public boolean v() {
            return this.f1450a;
        }

        public void g(boolean z) {
            this.f1450a = z;
        }

        public void dl(boolean z) {
            this.gc = z;
        }

        public boolean pf() {
            return this.gc;
        }

        public void z(Map<String, Object> map) {
            this.pf = map;
        }

        public Map<String, Object> ls() {
            return this.pf;
        }
    }
}
