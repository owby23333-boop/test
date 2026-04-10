package com.bytedance.msdk.dl.dl.g.z;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.z.gc.m;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends com.bytedance.sdk.openadsdk.core.ti.a implements com.bytedance.msdk.dl.z.g, com.bytedance.msdk.dl.z.z {
    protected com.bytedance.msdk.dl.z.g z;
    private boolean g = false;
    private boolean dl = false;

    @Override // com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        return null;
    }

    public abstract void g(Context context, com.bytedance.msdk.dl.m.g.g gVar, com.bytedance.msdk.api.z.g gVar2, Map<String, Object> map);

    public String z(Context context, com.bytedance.msdk.dl.m.g.g gVar, com.bytedance.msdk.api.z.g gVar2) {
        return null;
    }

    public g(com.bytedance.msdk.dl.z.g gVar) {
        this.z = gVar;
    }

    @Override // com.bytedance.msdk.dl.z.z
    public final void z(final Context context, final com.bytedance.msdk.dl.m.g.g gVar, final com.bytedance.msdk.api.z.g gVar2, final Map<String, Object> map) {
        if (gVar != null && (TextUtils.equals(MediationConstant.ADN_MINTEGRAL, gVar.i()) || TextUtils.equals("baidu", gVar.i()) || TextUtils.equals(MediationConstant.ADN_ADMOB, gVar.i()))) {
            m.dl(new Runnable() { // from class: com.bytedance.msdk.dl.dl.g.z.g.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.dl(context, gVar, gVar2, map);
                }
            });
        } else {
            dl(context, gVar, gVar2, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(Context context, com.bytedance.msdk.dl.m.g.g gVar, com.bytedance.msdk.api.z.g gVar2, Map<String, Object> map) {
        this.g = false;
        this.dl = false;
        if (com.bytedance.msdk.core.z.kb().tb()) {
            g(context, gVar, gVar2, map);
            z(gVar);
            return;
        }
        try {
            g(context, gVar, gVar2, map);
            z(gVar);
        } catch (Throwable th) {
            z(new com.bytedance.msdk.api.z(com.bytedance.msdk.core.v.g.z(th)));
            wp.z(th);
        }
    }

    private void z(com.bytedance.msdk.dl.m.g.g gVar) {
        if (gVar != null) {
            com.bytedance.msdk.core.dl.dl.g(gVar.i(), gVar.g(), gVar.wp());
        }
    }

    public void z(com.bytedance.msdk.g.dl dlVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(dlVar);
        z(arrayList);
    }

    @Override // com.bytedance.msdk.dl.z.g
    public void z(List<com.bytedance.msdk.g.dl> list) {
        if (this.g) {
            return;
        }
        this.g = true;
        com.bytedance.msdk.dl.z.g gVar = this.z;
        if (gVar != null) {
            gVar.z(list);
        }
    }

    @Override // com.bytedance.msdk.dl.z.g
    public void z(com.bytedance.msdk.api.z zVar) {
        this.dl = true;
        if (this.g) {
            return;
        }
        this.g = true;
        com.bytedance.msdk.dl.z.g gVar = this.z;
        if (gVar != null) {
            gVar.z(zVar);
        }
    }

    public void z(com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.api.z zVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(dlVar);
        z(arrayList, zVar);
    }

    @Override // com.bytedance.msdk.dl.z.g
    public void z(List<com.bytedance.msdk.g.dl> list, com.bytedance.msdk.api.z zVar) {
        com.bytedance.msdk.dl.z.g gVar;
        if (this.dl || (gVar = this.z) == null) {
            return;
        }
        gVar.z(list, zVar);
    }

    @Override // com.bytedance.msdk.dl.z.g
    public void z(com.bytedance.msdk.g.dl dlVar, String str) {
        com.bytedance.msdk.dl.z.g gVar = this.z;
        if (gVar != null) {
            gVar.z(dlVar, str);
        }
    }

    public boolean z() {
        return this.dl;
    }

    public boolean g() {
        return this.g;
    }
}
