package com.bytedance.sdk.component.d.bf;

import com.bytedance.sdk.component.d.bf.f;
import com.google.common.net.HttpHeaders;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public final class lc {
    final String bf;
    final f d;
    final k e;
    final Object ga;
    final a tg;
    private volatile tg vn;

    public static class e {
        String bf;
        f.e d;
        k e;
        Object ga;
        a tg;

        public e() {
            this.bf = "GET";
            this.d = new f.e();
        }

        public e delete(a aVar) {
            return e("DELETE", aVar);
        }

        public e e(k kVar) {
            if (kVar == null) {
                throw new NullPointerException("url == null");
            }
            this.e = kVar;
            return this;
        }

        public e delete() {
            return delete(com.bytedance.sdk.component.d.bf.e.d.tg);
        }

        public e e(URL url) {
            if (url != null) {
                k kVarE = k.e(url);
                if (kVarE != null) {
                    return e(kVarE);
                }
                throw new IllegalArgumentException("unexpected url: " + url);
            }
            throw new NullPointerException("url == null");
        }

        public e(lc lcVar) {
            this.e = lcVar.e;
            this.bf = lcVar.bf;
            this.tg = lcVar.tg;
            this.ga = lcVar.ga;
            this.d = lcVar.d.bf();
        }

        public e e(String str, String str2) {
            this.d.d(str, str2);
            return this;
        }

        public e e(String str) {
            this.d.bf(str);
            return this;
        }

        public e e(f fVar) {
            this.d = fVar.bf();
            return this;
        }

        public e e(tg tgVar) {
            String string = tgVar.toString();
            return string.isEmpty() ? e(HttpHeaders.CACHE_CONTROL) : e(HttpHeaders.CACHE_CONTROL, string);
        }

        public e e(String str, a aVar) {
            if (str != null) {
                if (str.length() != 0) {
                    if (aVar != null && !com.bytedance.sdk.component.d.bf.e.d.vn.d(str)) {
                        throw new IllegalArgumentException("method " + str + " must not have a request body.");
                    }
                    if (aVar == null && com.bytedance.sdk.component.d.bf.e.d.vn.bf(str)) {
                        throw new IllegalArgumentException("method " + str + " must have a request body.");
                    }
                    this.bf = str;
                    this.tg = aVar;
                    return this;
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public e e(Object obj) {
            this.ga = obj;
            return this;
        }

        public lc e() {
            if (this.e != null) {
                return new lc(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    public lc(e eVar) {
        this.e = eVar.e;
        this.bf = eVar.bf;
        this.d = eVar.d.e();
        this.tg = eVar.tg;
        Object obj = eVar.ga;
        this.ga = obj == null ? this : obj;
    }

    public String bf() {
        return this.bf;
    }

    public f d() {
        return this.d;
    }

    public k e() {
        return this.e;
    }

    public Object ga() {
        return this.ga;
    }

    public tg p() {
        tg tgVar = this.vn;
        if (tgVar != null) {
            return tgVar;
        }
        tg tgVarE = tg.e(this.d);
        this.vn = tgVarE;
        return tgVarE;
    }

    public a tg() {
        return this.tg;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.bf);
        sb.append(", url=");
        sb.append(this.e);
        sb.append(", tag=");
        Object obj = this.ga;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    public boolean v() {
        return this.e.tg();
    }

    public e vn() {
        return new e(this);
    }

    public String e(String str) {
        return this.d.e(str);
    }
}
