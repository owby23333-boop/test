package com.bytedance.sdk.component.dl.g;

import com.bytedance.sdk.component.dl.g.fv;
import com.google.common.net.HttpHeaders;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public final class sy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final hh f643a;
    final fv dl;
    private volatile a e;
    final String g;
    final Object gc;
    public l m;
    final js z;

    sy(z zVar) {
        this.z = zVar.z;
        this.g = zVar.g;
        this.dl = zVar.dl.z();
        this.f643a = zVar.f644a;
        this.gc = zVar.gc != null ? zVar.gc : this;
        if (zVar.m != null) {
            this.m = zVar.m;
        } else {
            this.m = new l();
        }
    }

    public js z() {
        return this.z;
    }

    public String g() {
        return this.g;
    }

    public fv dl() {
        return this.dl;
    }

    public String z(String str) {
        return this.dl.z(str);
    }

    public hh a() {
        return this.f643a;
    }

    public Object gc() {
        return this.gc;
    }

    public z m() {
        return new z(this);
    }

    public a e() {
        a aVar = this.e;
        if (aVar != null) {
            return aVar;
        }
        a aVarZ = a.z(this.dl);
        this.e = aVarZ;
        return aVarZ;
    }

    public boolean gz() {
        return this.z.a();
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Request{method=").append(this.g).append(", url=").append(this.z).append(", tag=");
        Object obj = this.gc;
        if (obj == this) {
            obj = null;
        }
        return sbAppend.append(obj).append('}').toString();
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        hh f644a;
        fv.z dl;
        String g;
        Object gc;
        l m;
        js z;

        public z() {
            this.g = "GET";
            this.dl = new fv.z();
        }

        z(sy syVar) {
            this.z = syVar.z;
            this.g = syVar.g;
            this.f644a = syVar.f643a;
            this.gc = syVar.gc;
            this.dl = syVar.dl.g();
            this.m = syVar.m;
        }

        public z z(js jsVar) {
            if (jsVar == null) {
                throw new NullPointerException("url == null");
            }
            this.z = jsVar;
            return this;
        }

        public z z(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            js jsVarGc = js.gc(str);
            if (jsVarGc == null) {
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(str)));
            }
            return z(jsVarGc);
        }

        public z z(URL url) {
            if (url == null) {
                throw new NullPointerException("url == null");
            }
            js jsVarZ = js.z(url);
            if (jsVarZ == null) {
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(url)));
            }
            return z(jsVarZ);
        }

        public z z(String str, String str2) {
            this.dl.dl(str, str2);
            return this;
        }

        public z g(String str, String str2) {
            this.dl.z(str, str2);
            return this;
        }

        public z g(String str) {
            this.dl.g(str);
            return this;
        }

        public z z(fv fvVar) {
            this.dl = fvVar.g();
            return this;
        }

        public z z(a aVar) {
            String string = aVar.toString();
            return string.isEmpty() ? g(HttpHeaders.CACHE_CONTROL) : z(HttpHeaders.CACHE_CONTROL, string);
        }

        public z delete(hh hhVar) {
            return z("DELETE", hhVar);
        }

        public z delete() {
            return delete(com.bytedance.sdk.component.dl.g.z.dl.f653a);
        }

        public z z(String str, hh hhVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (hhVar != null && !com.bytedance.sdk.component.dl.g.z.dl.m.dl(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (hhVar == null && com.bytedance.sdk.component.dl.g.z.dl.m.g(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
            this.g = str;
            this.f644a = hhVar;
            return this;
        }

        public z z(Object obj) {
            this.gc = obj;
            return this;
        }

        public sy z() {
            if (this.z == null) {
                throw new IllegalStateException("url == null");
            }
            return new sy(this);
        }
    }
}
