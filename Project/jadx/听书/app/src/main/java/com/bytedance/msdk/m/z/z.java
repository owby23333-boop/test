package com.bytedance.msdk.m.z;

import android.text.TextUtils;
import com.bytedance.msdk.api.a.kb;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z extends g {
    protected kb g;
    protected com.bytedance.msdk.core.uy.z z;

    @Override // com.bytedance.msdk.m.z.g
    protected String dl() {
        return "";
    }

    public z(com.bytedance.msdk.core.uy.z zVar) {
        this.z = zVar;
    }

    public z(kb kbVar) {
        this.g = kbVar;
    }

    @Override // com.bytedance.msdk.m.z.g
    protected Map<String, Object> z() {
        HashMap map = new HashMap();
        map.put(PluginConstants.KEY_APP_ID, gc());
        map.put("app_key", m());
        map.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, com.bytedance.msdk.core.z.kb().fv());
        if ("baidu".equals(g())) {
            map.put("baidu_https", Boolean.valueOf(com.bytedance.msdk.core.z.kb().l()));
            if (!TextUtils.isEmpty(com.bytedance.msdk.core.z.kb().m())) {
                map.put("baidu_wx_app_id", com.bytedance.msdk.core.z.kb().m());
            }
            Map<String, Object> mapUf = com.bytedance.msdk.core.z.kb().uf();
            if (mapUf != null) {
                map.put(MediationConstant.GM_EXTRA_KEY_CLOSE_SHAKE, mapUf.get(MediationConstant.GM_EXTRA_KEY_CLOSE_SHAKE));
            }
        }
        return map;
    }

    @Override // com.bytedance.msdk.m.z.g
    protected String g() {
        com.bytedance.msdk.core.uy.z zVar = this.z;
        if (zVar != null) {
            return zVar.z();
        }
        kb kbVar = this.g;
        return kbVar != null ? kbVar.gc() : "";
    }

    private String gc() {
        com.bytedance.msdk.core.uy.z zVar = this.z;
        if (zVar != null) {
            return zVar.g();
        }
        kb kbVar = this.g;
        return kbVar != null ? kbVar.dl() : "";
    }

    private String m() {
        com.bytedance.msdk.core.uy.z zVar = this.z;
        if (zVar != null) {
            return zVar.dl();
        }
        kb kbVar = this.g;
        return kbVar != null ? kbVar.a() : "";
    }
}
