package com.bytedance.sdk.openadsdk.core.live;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.gk.fo;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.oq;
import com.bytedance.sdk.openadsdk.core.live.z.a;
import com.bytedance.sdk.openadsdk.core.live.z.e;
import com.bytedance.sdk.openadsdk.core.live.z.gc;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private final a z;

    private g() {
        if (!fo.z()) {
            this.z = new com.bytedance.sdk.openadsdk.core.live.z.g();
            return;
        }
        if (gk.m) {
            this.z = new e();
        } else if (gk.e()) {
            this.z = new gc();
        } else {
            this.z = new com.bytedance.sdk.openadsdk.core.live.z.g();
        }
    }

    private static final class z {
        private static final g z = new g();
    }

    public static final g z() {
        return z.z;
    }

    public void z(Function<SparseArray<Object>, Object> function) {
        this.z.z(function);
    }

    public int z(Context context, na naVar, Map<String, Object> map) {
        if (context == null || naVar == null) {
            return 5;
        }
        return this.z.z(context, naVar, map);
    }

    public void z(String str, boolean z2) {
        this.z.z(str, z2);
    }

    public int z(na naVar, com.bytedance.sdk.openadsdk.core.live.z.dl dlVar, String str) {
        return this.z.z(naVar, dlVar, str);
    }

    public int g(Context context, na naVar, Map<String, Object> map) {
        return this.z.g(context, naVar, map);
    }

    public boolean z(na naVar) {
        return this.z.z(naVar);
    }

    public void z(String str, na naVar, long j) {
        this.z.z(str, naVar, j);
    }

    public boolean g(na naVar) {
        if (naVar == null || TextUtils.isEmpty(naVar.nz())) {
            return false;
        }
        return z(naVar.nz(), naVar.wm());
    }

    public boolean z(String str, int i) {
        return this.z.z(str, i);
    }

    public void g() {
        this.z.z();
    }

    public int dl() {
        return this.z.g();
    }

    public int dl(na naVar) {
        if (zw.g().to()) {
            return this.z.b_(naVar);
        }
        return 0;
    }

    public void a() {
        this.z.a();
    }

    public int gc() {
        return this.z.gc();
    }

    public void a(final na naVar) {
        if (naVar == null) {
            return;
        }
        gc(naVar);
        if (TextUtils.isEmpty(naVar.nz())) {
            return;
        }
        int iDl = com.bytedance.sdk.openadsdk.core.dl.a.z().dl() + 1;
        if (iDl > 100) {
            iDl = 100;
        }
        com.bytedance.sdk.openadsdk.core.dl.a.z().z(iDl);
        final int iDl2 = dl();
        final int iGc = gc();
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime();
        if (naVar.wm() == 1 && naVar.hu() == 1) {
            com.bytedance.sdk.openadsdk.core.q.g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.live.g.1
                @Override // com.bytedance.sdk.openadsdk.kb.z.z
                public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("ext", naVar.vk());
                        jSONObject.put("live_sdk_status", iDl2);
                        jSONObject.put("live_auth_status", iGc);
                        jSONObject.put("app_start_time", jElapsedRealtime);
                        jSONObject.put("is_web", naVar.z());
                    } catch (Throwable unused) {
                    }
                    return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("saas_miss").g(jSONObject.toString());
                }
            }, "saas_miss", true);
        }
    }

    public int m() {
        return com.bytedance.sdk.openadsdk.core.dl.a.z().dl();
    }

    public String e() {
        return this.z.e();
    }

    public void z(View view, oq oqVar, Map<String, Object> map, Map<String, Object> map2) {
        Object tag;
        if (view == null || oqVar == null || (tag = view.getTag(67108864)) == null || !(tag instanceof Integer)) {
            return;
        }
        int iIntValue = ((Integer) tag).intValue();
        int i = iIntValue & 255;
        int i2 = (iIntValue & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8;
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (i == 101 && !oqVar.dl()) {
            i = 102;
        }
        map.put("live_saas_param_interaction_type", Integer.valueOf(i));
        map2.put("click_saas_area", Integer.valueOf(i2));
    }

    public JSONObject gz() {
        return this.z.gz();
    }

    public int z(String str) {
        return this.z.z(str);
    }

    public int z(com.bytedance.sdk.openadsdk.core.live.g.g gVar, boolean z2) {
        return this.z.z(gVar, z2);
    }

    public void gc(na naVar) {
        this.z.a(naVar);
    }

    public void z(com.bytedance.sdk.openadsdk.pf.a aVar) {
        this.z.z(aVar);
    }

    public long fo() {
        return this.z.dl();
    }

    public boolean m(na naVar) {
        return naVar != null && naVar.eo() == 2;
    }
}
