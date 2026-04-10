package com.bytedance.sdk.gromore.z.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.z.g.z.dl;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private com.bytedance.sdk.openadsdk.mediation.init.z.g.z.z dl;
    private com.bytedance.sdk.openadsdk.ls.dl.dl.z g;
    private PluginValueSet z;

    public static z z(PluginValueSet pluginValueSet) {
        return new z(pluginValueSet);
    }

    private z(PluginValueSet pluginValueSet) {
        this.z = pluginValueSet;
        if (pluginValueSet != null) {
            com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar = new com.bytedance.sdk.openadsdk.ls.dl.dl.z(pluginValueSet.sparseArray());
            this.g = zVar;
            this.dl = zVar.pf();
        }
    }

    public boolean z() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar = this.g;
        if (zVar != null) {
            return zVar.ls();
        }
        return false;
    }

    public PluginValueSet g() {
        return this.z;
    }

    public Function<SparseArray<Object>, Object> dl() {
        PluginValueSet pluginValueSet = this.z;
        if (pluginValueSet != null) {
            return (Function) pluginValueSet.objectValue(15, Function.class);
        }
        return null;
    }

    public boolean a() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar = this.g;
        if (zVar != null) {
            return zVar.gz();
        }
        return false;
    }

    public String gc() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar = this.g;
        if (zVar != null) {
            return zVar.z();
        }
        return null;
    }

    public String m() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar = this.g;
        if (zVar != null) {
            return zVar.g();
        }
        return null;
    }

    public boolean e() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar = this.g;
        if (zVar != null) {
            return zVar.dl();
        }
        return false;
    }

    public String gz() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar = this.g;
        if (zVar != null) {
            return zVar.a();
        }
        return null;
    }

    public String fo() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar = this.g;
        if (zVar != null) {
            return zVar.gc();
        }
        return null;
    }

    public int uy() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar = this.g;
        if (zVar != null) {
            return zVar.m();
        }
        return 0;
    }

    public boolean kb() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar = this.g;
        if (zVar != null) {
            return zVar.e();
        }
        return false;
    }

    public boolean wp() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar = this.g;
        if (zVar != null) {
            return zVar.uy();
        }
        return false;
    }

    public int[] i() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar = this.g;
        if (zVar != null) {
            return zVar.fo();
        }
        return null;
    }

    public Map<String, Object> v() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar = this.g;
        if (zVar != null) {
            return zVar.p();
        }
        return null;
    }

    public String pf() {
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.z zVar = this.dl;
        if (zVar != null) {
            return zVar.z();
        }
        return null;
    }

    public boolean ls() {
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.z zVar = this.dl;
        if (zVar != null) {
            return zVar.g();
        }
        return false;
    }

    public dl p() {
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.z zVar = this.dl;
        if (zVar != null) {
            return zVar.dl();
        }
        return null;
    }

    public Map<String, Object> fv() {
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.z zVar = this.dl;
        if (zVar != null) {
            return zVar.a();
        }
        return null;
    }

    public boolean js() {
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.z zVar = this.dl;
        if (zVar != null) {
            return zVar.gc();
        }
        return false;
    }

    public JSONObject tb() {
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.z zVar = this.dl;
        if (zVar != null) {
            return zVar.m();
        }
        return null;
    }

    public String q() {
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.z zVar = this.dl;
        return zVar != null ? zVar.e() : "";
    }

    public boolean iq() {
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.z zVar = this.dl;
        if (zVar != null) {
            return zVar.gz();
        }
        return false;
    }

    public boolean zw() {
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.z zVar = this.dl;
        if (zVar != null) {
            return zVar.fo();
        }
        return false;
    }

    public boolean io() {
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.z zVar = this.dl;
        if (zVar != null) {
            return zVar.uy();
        }
        return false;
    }

    public Function<SparseArray<Object>, Object> uf() {
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.z zVar = this.dl;
        if (zVar != null && zVar.a() != null) {
            Object obj = this.dl.a().get("qa_config_tool");
            if (obj instanceof Function) {
                return (Function) obj;
            }
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> sy() {
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.z zVar = this.dl;
        if (zVar != null && zVar.a() != null) {
            Object obj = this.dl.a().get("qa_event_tool");
            if (obj instanceof Function) {
                return (Function) obj;
            }
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> hh() {
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.z zVar = this.dl;
        if (zVar != null && zVar.a() != null) {
            Object obj = this.dl.a().get("qa_onetap_tool");
            if (obj instanceof Function) {
                return (Function) obj;
            }
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> l() {
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.z zVar = this.dl;
        if (zVar != null && zVar.a() != null) {
            Object obj = this.dl.a().get("qa_preview_tool");
            if (obj instanceof Function) {
                return (Function) obj;
            }
        }
        return null;
    }
}
