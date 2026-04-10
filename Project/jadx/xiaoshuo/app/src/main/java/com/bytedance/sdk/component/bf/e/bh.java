package com.bytedance.sdk.component.bf.e;

import com.bytedance.sdk.component.bf.e.vn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class bh {
    public wu e;

    public static class e {
        public Map<String, List<String>> bf;
        p d;
        com.bytedance.sdk.component.bf.e.e e;
        Object ga;
        vn.e p;
        String tg;
        t vn;

        public e() {
            this.bf = new HashMap();
            this.p = new vn.e();
        }

        public e bf(String str, String str2) {
            if (!this.bf.containsKey(str)) {
                this.bf.put(str, new ArrayList());
            }
            this.bf.get(str).add(str2);
            return this;
        }

        public e e(com.bytedance.sdk.component.bf.e.e eVar) {
            this.e = eVar;
            return this;
        }

        public e e(Object obj) {
            this.ga = obj;
            return this;
        }

        public e e(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
                p pVarD = p.d(str);
                if (pVarD != null) {
                    return e(pVarD);
                }
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            throw new NullPointerException("url == null");
        }

        public e(bh bhVar) {
            this.d = bhVar.bf();
            this.tg = bhVar.d();
            this.bf = bhVar.tg();
            this.ga = bhVar.e();
            this.vn = bhVar.vn();
            this.e = bhVar.ga();
        }

        public bh bf() {
            return new bh() { // from class: com.bytedance.sdk.component.bf.e.bh.e.1
                @Override // com.bytedance.sdk.component.bf.e.bh
                public p bf() {
                    return e.this.d;
                }

                @Override // com.bytedance.sdk.component.bf.e.bh
                public String d() {
                    return e.this.tg;
                }

                @Override // com.bytedance.sdk.component.bf.e.bh
                public Object e() {
                    return e.this.ga;
                }

                @Override // com.bytedance.sdk.component.bf.e.bh
                public com.bytedance.sdk.component.bf.e.e ga() {
                    return e.this.e;
                }

                @Override // com.bytedance.sdk.component.bf.e.bh
                public Map tg() {
                    return e.this.bf;
                }

                public String toString() {
                    return "";
                }

                @Override // com.bytedance.sdk.component.bf.e.bh
                public t vn() {
                    return e.this.vn;
                }
            };
        }

        public e e(p pVar) {
            this.d = pVar;
            return this;
        }

        public e e(String str, String str2) {
            return bf(str, str2);
        }

        public e e(vn vnVar) {
            if (vnVar != null) {
                this.bf = vnVar.bf();
            }
            return this;
        }

        public e e() {
            return e("GET", (t) null);
        }

        public e e(String str, t tVar) {
            this.tg = str;
            this.vn = tVar;
            return this;
        }

        public e e(t tVar) {
            return e("POST", tVar);
        }
    }

    public abstract p bf();

    public abstract String d();

    public abstract Object e();

    public void e(wu wuVar) {
        this.e = wuVar;
    }

    public abstract com.bytedance.sdk.component.bf.e.e ga();

    public e p() {
        return new e(this);
    }

    public abstract Map<String, List<String>> tg();

    public t vn() {
        return null;
    }
}
