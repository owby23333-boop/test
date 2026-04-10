package com.bytedance.msdk.api.a;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.a.a;
import com.bytedance.msdk.api.a.gz;
import com.bytedance.msdk.api.a.wp;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f356a;
    private boolean dl;
    private gz e;
    private m fo;
    private String g;
    private boolean gc;
    private a gz;
    private Map<String, Object> i;
    private boolean kb;
    private wp m;
    private boolean pf;
    private Map<String, Object> uy;
    private PluginValueSet v;
    private JSONObject wp;
    private String z;

    private z(C0067z c0067z) {
        this.z = c0067z.z;
        this.g = c0067z.g;
        this.dl = c0067z.dl;
        this.f356a = c0067z.f357a;
        this.gc = c0067z.gc;
        if (c0067z.m == null) {
            this.m = new wp.z().z();
        } else {
            this.m = c0067z.m;
        }
        if (c0067z.e == null) {
            this.e = new gz.z().z();
        } else {
            this.e = c0067z.e;
        }
        if (c0067z.gz == null) {
            this.gz = new a.z().z();
        } else {
            this.gz = c0067z.gz;
        }
        if (c0067z.fo == null) {
            this.fo = new m();
        } else {
            this.fo = c0067z.fo;
        }
        this.uy = c0067z.uy;
        this.kb = c0067z.kb;
        this.wp = c0067z.wp;
        this.i = c0067z.i;
        this.v = c0067z.v;
        this.pf = c0067z.pf;
    }

    /* JADX INFO: renamed from: com.bytedance.msdk.api.a.z$z, reason: collision with other inner class name */
    public static class C0067z {
        private gz e;
        private m fo;
        private String g;
        private a gz;
        private Map<String, Object> i;
        private wp m;
        private boolean pf;
        private Map<String, Object> uy;
        private PluginValueSet v;
        private JSONObject wp;
        private String z;
        private boolean dl = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f357a = "";
        private boolean gc = false;
        private boolean kb = false;

        public C0067z z(String str) {
            this.z = str;
            return this;
        }

        public C0067z g(String str) {
            this.g = str;
            return this;
        }

        public C0067z z(boolean z) {
            this.dl = z;
            return this;
        }

        public C0067z dl(String str) {
            this.f357a = str;
            return this;
        }

        public C0067z g(boolean z) {
            this.gc = z;
            return this;
        }

        public C0067z z(wp wpVar) {
            this.m = wpVar;
            return this;
        }

        public C0067z z(gz gzVar) {
            this.e = gzVar;
            return this;
        }

        public C0067z z(m mVar) {
            this.fo = mVar;
            return this;
        }

        public C0067z z(Map<String, Object> map) {
            if (map != null && !map.isEmpty()) {
                if (this.uy == null) {
                    this.uy = new HashMap();
                }
                this.uy.putAll(map);
            }
            return this;
        }

        public C0067z dl(boolean z) {
            this.kb = z;
            return this;
        }

        public C0067z z(JSONObject jSONObject) {
            this.wp = jSONObject;
            return this;
        }

        public C0067z z(PluginValueSet pluginValueSet) {
            this.v = pluginValueSet;
            return this;
        }

        public C0067z a(boolean z) {
            this.pf = z;
            return this;
        }

        public z z() {
            return new z(this);
        }
    }

    public String z() {
        return this.z;
    }

    public String g() {
        return this.g;
    }

    public boolean dl() {
        return this.dl;
    }

    public String a() {
        return this.f356a;
    }

    public boolean gc() {
        return this.gc;
    }

    public wp m() {
        return this.m;
    }

    public gz e() {
        return this.e;
    }

    public a gz() {
        return this.gz;
    }

    public m fo() {
        return this.fo;
    }

    public Map<String, Object> uy() {
        return this.uy;
    }

    public boolean kb() {
        return this.kb;
    }

    public JSONObject wp() {
        return this.wp;
    }

    public Map<String, Object> i() {
        return this.i;
    }

    public PluginValueSet v() {
        return this.v;
    }

    public boolean pf() {
        return this.pf;
    }
}
