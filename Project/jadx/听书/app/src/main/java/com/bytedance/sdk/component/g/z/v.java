package com.bytedance.sdk.component.g.z;

import com.bytedance.sdk.component.g.z.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v {
    public wp z;

    public abstract Map<String, List<String>> a();

    public abstract String dl();

    public abstract e g();

    public abstract com.bytedance.sdk.component.g.z.z gc();

    public pf m() {
        return null;
    }

    public abstract Object z();

    public void z(wp wpVar) {
        this.z = wpVar;
    }

    public z e() {
        return new z(this);
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f722a;
        e dl;
        m.z e;
        public Map<String, List<String>> g;
        Object gc;
        pf m;
        com.bytedance.sdk.component.g.z.z z;

        public z() {
            this.g = new HashMap();
            this.e = new m.z();
        }

        public z z(com.bytedance.sdk.component.g.z.z zVar) {
            this.z = zVar;
            return this;
        }

        z(v vVar) {
            this.dl = vVar.g();
            this.f722a = vVar.dl();
            this.g = vVar.a();
            this.gc = vVar.z();
            this.m = vVar.m();
            this.z = vVar.gc();
        }

        public z z(Object obj) {
            this.gc = obj;
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
            e eVarDl = e.dl(str);
            if (eVarDl == null) {
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(str)));
            }
            return z(eVarDl);
        }

        public z z(e eVar) {
            this.dl = eVar;
            return this;
        }

        public z z(String str, String str2) {
            return g(str, str2);
        }

        public z z(m mVar) {
            if (mVar != null) {
                this.g = mVar.g();
            }
            return this;
        }

        public z g(String str, String str2) {
            if (!this.g.containsKey(str)) {
                this.g.put(str, new ArrayList());
            }
            this.g.get(str).add(str2);
            return this;
        }

        public z z() {
            return z("GET", (pf) null);
        }

        public z z(String str, pf pfVar) {
            this.f722a = str;
            this.m = pfVar;
            return this;
        }

        public z z(pf pfVar) {
            return z("POST", pfVar);
        }

        public v g() {
            return new v() { // from class: com.bytedance.sdk.component.g.z.v.z.1
                public String toString() {
                    return "";
                }

                @Override // com.bytedance.sdk.component.g.z.v
                public Object z() {
                    return z.this.gc;
                }

                @Override // com.bytedance.sdk.component.g.z.v
                public e g() {
                    return z.this.dl;
                }

                @Override // com.bytedance.sdk.component.g.z.v
                public String dl() {
                    return z.this.f722a;
                }

                @Override // com.bytedance.sdk.component.g.z.v
                public Map a() {
                    return z.this.g;
                }

                @Override // com.bytedance.sdk.component.g.z.v
                public com.bytedance.sdk.component.g.z.z gc() {
                    return z.this.z;
                }

                @Override // com.bytedance.sdk.component.g.z.v
                public pf m() {
                    return z.this.m;
                }
            };
        }
    }
}
