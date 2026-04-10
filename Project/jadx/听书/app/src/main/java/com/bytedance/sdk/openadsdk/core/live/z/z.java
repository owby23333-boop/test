package com.bytedance.sdk.openadsdk.core.live.z;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.iq;
import com.bytedance.sdk.openadsdk.core.iq.ls;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.wj;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements a {
    protected JSONObject dl;
    protected volatile String g;
    protected volatile Function<SparseArray<Object>, Object> z = null;

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public void a(na naVar) {
    }

    public void a_(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public long dl() {
        return -1L;
    }

    protected abstract boolean x_();

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public void z() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public void z(String str, na naVar, long j) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public void z(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return;
        }
        this.z = function;
    }

    protected boolean a_(na naVar) {
        if (naVar == null) {
            return false;
        }
        return z(naVar.nz(), naVar.wm());
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public boolean z(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Long.parseLong(str) <= 0) {
                return false;
            }
            switch (i) {
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    protected long g(na naVar) {
        if (naVar == null) {
            return 0L;
        }
        String strNz = naVar.nz();
        if (TextUtils.isEmpty(strNz)) {
            strNz = z(naVar.vy());
        }
        try {
            return Long.parseLong(strNz);
        } catch (Exception unused) {
            return 0L;
        }
    }

    protected String z(ls lsVar) {
        Map<String, String> mapZ;
        if (lsVar == null) {
            return null;
        }
        String strG = lsVar.g();
        if (TextUtils.isEmpty(strG)) {
            return null;
        }
        if ((strG.startsWith("snssdk2329") || strG.startsWith("snssdk1128")) && (mapZ = wj.z(strG)) != null) {
            return mapZ.get("room_id");
        }
        return null;
    }

    protected String z(na naVar, String str, Map map) {
        if (map == null) {
            return str;
        }
        try {
            String str2 = (String) map.get("dpa_tag");
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            String strGc = iq.gc(naVar, str2);
            if (TextUtils.isEmpty(strGc)) {
                return str;
            }
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(strGc);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.putOpt(next, jSONObject2.opt(next));
            }
            return jSONObject.toString();
        } catch (Exception e) {
            wp.g("TTLiveSDkBridge", e);
            v.z().z("getEcomLiveParams", e);
            return str;
        }
    }

    protected void z(na naVar, String str, int i, int i2, int i3) {
        com.bytedance.sdk.openadsdk.core.i.a.z(naVar, str, i, i2, i3, x_());
    }

    protected boolean z(na naVar, int i) {
        return naVar.wm() == 7 || i == 103;
    }

    protected int dl(na naVar) {
        ls lsVarVy;
        if (1 != com.bytedance.sdk.openadsdk.core.live.g.z().gc()) {
            return 2;
        }
        if (!com.bytedance.sdk.openadsdk.core.live.gc.z.z(naVar)) {
            return 3;
        }
        if (naVar != null && eo.g(zw.getContext()) && (lsVarVy = naVar.vy()) != null) {
            String strG = lsVarVy.g();
            if (!TextUtils.isEmpty(strG)) {
                Uri uri = Uri.parse(strG);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                return eo.g(zw.getContext(), intent, true) ? 0 : 4;
            }
        }
        return 0;
    }
}
