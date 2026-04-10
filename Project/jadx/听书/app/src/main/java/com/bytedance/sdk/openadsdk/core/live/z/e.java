package com.bytedance.sdk.openadsdk.core.live.z;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.i.z;
import com.bytedance.sdk.openadsdk.core.io;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.oq;
import com.bytedance.sdk.openadsdk.core.iq.sv;
import com.bytedance.sdk.openadsdk.core.iq.wj;
import com.bytedance.sdk.openadsdk.core.live.z.m;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.kb;
import com.funny.audio.core.utils.FileUtils;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class e extends m {
    private volatile Set<String> uy;
    private final AtomicBoolean gz = new AtomicBoolean(false);
    public volatile com.bytedance.sdk.openadsdk.pf.a e = null;
    private volatile int fo = -5;
    private volatile boolean kb = false;
    private final long wp = System.currentTimeMillis();
    private volatile boolean i = false;
    private long v = -1;
    private long pf = -1;

    public e() {
        if (com.bytedance.sdk.openadsdk.hh.e.z()) {
            com.bytedance.sdk.openadsdk.hh.e.dl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.z.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.fo();
                }
            });
        } else {
            fo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fo() {
        v();
        uy.ls().z("com.byted.live.lite", dl(kb.g("com.byted.live.lite")), this.gc, null);
        if (!zw.g().fq()) {
            this.fo = -4;
            wp.g("TTLiveSDkBridge", "forbiddom init live");
        } else {
            uy();
            this.v = com.bytedance.sdk.openadsdk.core.g.z().get("live_last_init_time", 0L);
        }
    }

    private void uy() {
        if (this.i) {
            wp.z("TTLiveSDkBridge", "tryLoad saas hasLoaded");
        } else if (!wp()) {
            wp.z("TTLiveSDkBridge", "tryLoad saas failed mHasSaasMetaClicked = " + this.kb);
        } else {
            this.i = true;
            gz.dl().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.z.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.i();
                }
            }, kb());
        }
    }

    private long kb() {
        com.bytedance.sdk.openadsdk.core.gk.g gVarPo = zw.g().po();
        long jG = com.bytedance.sdk.openadsdk.core.gk.a.z;
        if (gVarPo != null) {
            jG = gVarPo.g();
        }
        if (System.currentTimeMillis() - this.wp > jG) {
            return 0L;
        }
        return jG;
    }

    private boolean wp() {
        if (uy.ls().uy() && this.e == null) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.gk.g gVarPo = zw.g().po();
        if (gVarPo != null) {
            if (gVarPo.gc()) {
                return this.kb;
            }
            return true;
        }
        if (com.bytedance.sdk.openadsdk.core.gk.a.g) {
            return this.kb;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Object objApply;
        wp.z("TTLiveSDkBridge", "doInitLive");
        v.z().dl();
        this.pf = SystemClock.elapsedRealtime();
        if (this.z == null) {
            this.z = uy.ls().m(2);
        }
        boolean zBooleanValue = false;
        if (this.z != null) {
            this.z.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(9).z(Void.class).z(0, new com.bytedance.sdk.openadsdk.core.live.g.z(this)).g());
        } else {
            wp.g("TTLiveSDkBridge", "No bridge for live");
        }
        Function<SparseArray<Object>, Object> functionGb = uy.ls().gb();
        if (functionGb != null && (objApply = functionGb.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(6).z(Boolean.class).z(0, "com.byted.live.lite").g())) != null) {
            zBooleanValue = ((Boolean) objApply).booleanValue();
        }
        if (zBooleanValue && this.fo != 2) {
            this.fo = 1;
        }
        com.bytedance.sdk.openadsdk.tools.g.dl(21, g() > 0 ? "1" : "0");
        com.bytedance.sdk.openadsdk.tools.g.dl(20, g() != 2 ? "0" : "1");
    }

    private void v() {
        Function<SparseArray<Object>, Object> functionGb = uy.ls().gb();
        if (functionGb == null) {
            return;
        }
        a_((String) z(functionGb, 8, String.class));
    }

    private <T> T z(Function<SparseArray<Object>, Object> function, int i, Class<T> cls) {
        T t = (T) function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(i).z((Class<?>) cls).z(0, "com.byted.live.lite").g());
        if (t != null) {
            return t;
        }
        return null;
    }

    private String dl(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
            }
        }
        return sb.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.z, com.bytedance.sdk.openadsdk.core.live.z.a
    public void z() {
        if (this.gz.get()) {
            wp.g("TTLiveSDkBridge", "already init!");
            return;
        }
        if (this.fo != 5) {
            wp.g("TTLiveSDkBridge", "plugin not Load! " + this.fo);
            return;
        }
        if (this.fo == 2) {
            wp.g("TTLiveSDkBridge", "init started or successed:" + this.fo);
            return;
        }
        if (!pf()) {
            wp.g("TTLiveSDkBridge", "init live failed！ not valid env！");
            return;
        }
        if (!com.bytedance.sdk.openadsdk.core.live.gc.g.dl(this.gc)) {
            com.bytedance.sdk.openadsdk.core.live.gc.g.a(this.gc);
            return;
        }
        this.gz.set(true);
        com.bytedance.sdk.openadsdk.core.live.gc.g.z(this.gc);
        this.fo = 4;
        if (this.z != null) {
            wp.z("TTLiveSDkBridge", "liveSDkBridge init invoke 5500");
            this.z.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(5).z(Void.class).z(0, ls()).g());
        }
        com.bytedance.sdk.openadsdk.core.live.gc.g.g(this.gc);
    }

    private boolean pf() {
        try {
            if (gk.dl >= 7000) {
                int iDl = Integer.parseInt(this.gc.replaceAll("\\.", ""));
                if (iDl == 0) {
                    iDl = kb.dl("com.byted.live.lite");
                }
                if (iDl <= 211413) {
                    return false;
                }
            }
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.core.gk.uy uyVarG = zw.g();
        wj wjVarJa = uyVarG.ja();
        int iG = uy.ls().uf().g();
        return (wjVarJa == null || !wjVarJa.gc() || !uyVarG.fq() || iG == 4 || iG == 5) ? false : true;
    }

    private Map ls() {
        JSONObject jSONObjectDl;
        String strG;
        Map map = new HashMap();
        map.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, zw.getContext().getPackageName());
        wj wjVarJa = zw.g().ja();
        if (wjVarJa != null) {
            map.put("partner", wjVarJa.dl());
            map.put("p_secret", wjVarJa.a());
            map.put("g_appid", String.valueOf(wjVarJa.g()));
        }
        map.put("channel", "csj_channel");
        map.put("debug", Boolean.valueOf(wp.dl()));
        map.put("ec_host_appid", "1371");
        HashMap map2 = new HashMap();
        if (!uy.ls().gz()) {
            map2.put("enable_init_oaid", "false");
        }
        if (!uy.ls().gc()) {
            map2.put("can_use_sensor", "false");
        }
        if (uy.ls().uy()) {
            String strDl = com.bytedance.sdk.openadsdk.core.un.uy.dl(false);
            if (com.bytedance.sdk.openadsdk.core.a.z.dl() && !TextUtils.isEmpty(strDl)) {
                map2.remove("enable_init_oaid");
                strG = com.bytedance.sdk.openadsdk.core.un.zw.g(strDl);
            } else {
                strG = com.bytedance.sdk.openadsdk.core.un.zw.g(this.e);
            }
            if (!TextUtils.isEmpty(strG)) {
                map2.put("oaid_object", strG);
            }
        }
        com.bytedance.sdk.openadsdk.core.gk.g gVarPo = zw.g().po();
        if (gVarPo != null) {
            boolean z = gVarPo.z();
            wp.z("TTLiveSDkBridge", "INIT_SUB_PROCESS=", Boolean.valueOf(z));
            map.put("sub_process", Boolean.valueOf(z));
        }
        map.put("c_control", uy.ls().p());
        com.bytedance.sdk.openadsdk.core.gk.g gVarPo2 = zw.g().po();
        if (gVarPo2 != null && (jSONObjectDl = gVarPo2.dl()) != null) {
            Iterator<String> itKeys = jSONObjectDl.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map2.put(next, String.valueOf(jSONObjectDl.opt(next)));
            }
            map.put("live_tob_init_extra", map2);
        } else {
            z(map, map2);
        }
        return map;
    }

    private void z(Map map, Map<String, Object> map2) {
        map2.put("allow_apm_init", com.bytedance.sdk.openadsdk.core.gk.a.dl);
        map2.put("allow_npth_init", com.bytedance.sdk.openadsdk.core.gk.a.f1106a);
        map2.put("allow_vlog_init", com.bytedance.sdk.openadsdk.core.gk.a.gc);
        map2.put("sec_init_use_thread", com.bytedance.sdk.openadsdk.core.gk.a.m);
        map.put("live_tob_init_extra", map2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public int g() {
        return this.fo;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public void a() {
        if (this.z == null || !m()) {
            return;
        }
        g("warmingUpBeforeEnter");
    }

    private Object g(String str) {
        if (this.fo != 2) {
            wp.g("TTLiveSDkBridge", "callSimpleExpandMethod " + str + " failed for plugin state = " + this.fo);
            return null;
        }
        HashMap map = new HashMap();
        map.put("expand_method_name", str);
        if (this.z != null) {
            return this.z.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(7).z(Void.class).z(0, map).g());
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public int gc() {
        Object objG;
        return (this.z == null || !m() || (objG = g("hasAuthenticated")) == null || !(objG instanceof Boolean)) ? false : ((Boolean) objG).booleanValue() ? 2 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public boolean m() {
        return this.fo == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Object objG = g("getLiveSdkConfig");
        if (objG == null || !(objG instanceof JSONObject)) {
            return;
        }
        this.dl = (JSONObject) objG;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public JSONObject gz() {
        return this.dl;
    }

    public void z(int i, String str, boolean z) {
        this.fo = i;
        if (i == -3) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(NotificationCompat.CATEGORY_MESSAGE, str);
                jSONObject.putOpt("pkg", "com.byted.live.lite");
                jSONObject.putOpt("only", Boolean.valueOf(z));
            } catch (JSONException unused) {
            }
            v.z().z(false, SystemClock.elapsedRealtime() - this.pf, jSONObject);
            return;
        }
        if (i == 1) {
            com.bytedance.sdk.openadsdk.tools.g.dl(21, "1");
            return;
        }
        if (i != 2) {
            return;
        }
        this.v = SystemClock.elapsedRealtime();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("only", Boolean.valueOf(z));
        } catch (JSONException unused2) {
        }
        v.z().z(true, this.v - this.pf, jSONObject2);
        com.bytedance.sdk.openadsdk.tools.g.dl(21, "1");
        com.bytedance.sdk.openadsdk.tools.g.dl(20, "1");
        v();
        p();
        com.bytedance.sdk.openadsdk.core.g.z().put("live_last_init_time", this.v);
    }

    public void z(boolean z, String str) {
        com.bytedance.sdk.openadsdk.ls.dl.z.g gVar;
        com.bytedance.sdk.openadsdk.hh.e.z(new fo("getLiveSdk") { // from class: com.bytedance.sdk.openadsdk.core.live.z.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.p();
            }
        });
        if (this.m != null && this.m.get() != null) {
            com.bytedance.sdk.openadsdk.core.i.a.z(z ? 2 : 1, this.g != null ? this.g : "", this.m.get());
        }
        if (!z || this.f1241a == null || (gVar = (com.bytedance.sdk.openadsdk.ls.dl.z.g) io.z(this.f1241a, com.bytedance.sdk.openadsdk.ls.dl.z.g.class)) == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("open_uid", str);
        gVar.z(1, map);
        z(AVMDLDataLoader.KeyIsStoPlayDldWinSizeKBLS, this.f1241a);
    }

    private JSONObject z(int i, String str) {
        JSONObject jSONObjectG = g(i, str);
        if (jSONObjectG != null) {
            try {
                jSONObjectG.putOpt(NotificationCompat.CATEGORY_STATUS, 1);
            } catch (JSONException unused) {
            }
            na naVar = this.m.get();
            if (naVar != null) {
                com.bytedance.sdk.openadsdk.core.live.a.z.z(str, naVar.mj() + "_" + i);
            }
        }
        return jSONObjectG;
    }

    private JSONObject g(int i, String str) {
        oq oqVarMg;
        JSONArray jSONArrayGz;
        if (this.m != null && this.m.get() != null) {
            na naVar = this.m.get();
            if (TextUtils.equals(naVar.dc(), str) && (oqVarMg = naVar.mg()) != null && (jSONArrayGz = oqVarMg.gz()) != null && jSONArrayGz.length() != 0) {
                int length = jSONArrayGz.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayGz.optJSONObject(i2);
                    if (jSONObjectOptJSONObject.optInt("type") == i) {
                        return jSONObjectOptJSONObject;
                    }
                }
            }
        }
        return null;
    }

    public void z(Map<String, String> map) {
        String str = map.get("label");
        final String str2 = map.get("req_id");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!dl(str)) {
            wp.g("TTLiveSDkBridge", "not valid label " + str);
            return;
        }
        na naVar = this.m != null ? this.m.get() : null;
        final String str3 = map.get("ad_extra_data");
        com.bytedance.sdk.openadsdk.m.z.z zVar = new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.live.z.e.4
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(str3);
                jSONObject2.put("req_id", str2);
                jSONObject.put("ad_extra_data", jSONObject2);
            }
        };
        if (naVar != null) {
            com.bytedance.sdk.openadsdk.core.i.a.z(naVar, this.g, str, zVar);
            String strAq = naVar.aq();
            if (TextUtils.equals(strAq, str2)) {
                return;
            }
            z(str2, str, "mate req is " + strAq);
            return;
        }
        new z.C0178z().z(this.g).g(str).z(zVar);
        z(str2, str, TTAdConstant.MATE_IS_NULL_MSG);
    }

    private void z(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("req_id", str);
            jSONObject.putOpt("label", str2);
            jSONObject.putOpt("mesage", str3);
        } catch (JSONException unused) {
        }
        v.z().z("reportPangleEvent", jSONObject, (Throwable) null);
    }

    private boolean dl(String str) {
        if (str.startsWith("csj_saas")) {
            return true;
        }
        if (this.uy == null) {
            this.uy = new HashSet(11);
            this.uy.add("saas_easyplayable");
            this.uy.add("real_auth_status");
            this.uy.add("live_panel");
            this.uy.add("live_exit");
            this.uy.add("mnpl_user_close");
            this.uy.add("clickarea");
            this.uy.add("enterSection");
            this.uy.add("mini_playable_real_show");
            this.uy.add("mnpl_user_close");
            this.uy.add("mnpl_sdk_lifecycle_status");
        }
        return this.uy.contains(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.z, com.bytedance.sdk.openadsdk.core.live.z.a
    public void a(na naVar) {
        if (naVar == null || this.kb || !gc(naVar)) {
            return;
        }
        this.kb = true;
        fo();
    }

    private boolean gc(na naVar) {
        JSONObject jSONObjectEn = naVar.en();
        if (jSONObjectEn == null) {
            return false;
        }
        if (jSONObjectEn.optInt("landing_type", 0) != 4 && TextUtils.isEmpty(naVar.nz())) {
            return com.bytedance.sdk.openadsdk.core.live.gc.z.z(naVar);
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.m, com.bytedance.sdk.openadsdk.core.live.z.a
    public int z(final na naVar, final dl dlVar, final String str) {
        if (naVar == null) {
            return 0;
        }
        final String strBv = naVar.bv();
        if (TextUtils.isEmpty(strBv)) {
            return 0;
        }
        if (this.fo != 2) {
            return -1;
        }
        this.g = str;
        this.m = new SoftReference<>(naVar);
        sv svVarDz = naVar.dz();
        if (2 != gc() && svVarDz != null) {
            boolean z = svVarDz != null && svVarDz.a() == 1;
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            final boolean z2 = z;
            if (z(naVar, new m.z() { // from class: com.bytedance.sdk.openadsdk.core.live.z.e.5
                @Override // com.bytedance.sdk.openadsdk.core.live.z.m.z
                public void z(boolean z3) {
                    boolean z4;
                    if (atomicBoolean.compareAndSet(false, true)) {
                        e.this.z(naVar, dlVar, strBv, z3, z2, str, 1);
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    v.z().z(naVar, System.currentTimeMillis() - jCurrentTimeMillis, z3, z4);
                }
            }, true)) {
                long jGc = svVarDz.gc();
                if (jGc <= 0) {
                    return 2;
                }
                final boolean z3 = z;
                gz.g().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.z.e.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (atomicBoolean.compareAndSet(false, true)) {
                            e.this.z(naVar, dlVar, strBv, false, z3, str, 2);
                        }
                    }
                }, jGc);
                return 2;
            }
        }
        int iZ = z(strBv);
        z(iZ, naVar, false, 0);
        return iZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(na naVar, dl dlVar, String str, boolean z, boolean z2, String str2, int i) {
        int iZ = z(str);
        wp.z("TTLiveSDkBridge", "auth result:" + z + ", schema handle:" + iZ);
        z(iZ, naVar, z, i);
        if (iZ != 1) {
            if (dlVar != null) {
                dlVar.z(iZ);
            }
        } else {
            if (z || !z2) {
                return;
            }
            new com.bytedance.sdk.openadsdk.core.live.dl.z().z(str2).z(zw.getContext(), naVar);
        }
    }

    private void z(int i, na naVar, boolean z, int i2) {
        if (naVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("handle_result", Integer.valueOf(i));
            jSONObject.put("req_id", naVar.aq());
            jSONObject.put("auth", z);
            sv svVarDz = naVar.dz();
            if (svVarDz != null) {
                jSONObject.put("saas_info", svVarDz.z());
            }
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, i2);
            jSONObject.put("ext", naVar.vk());
        } catch (Exception unused) {
        }
        v.z().g(jSONObject);
    }

    public void g(Map<String, String> map) {
        com.bytedance.sdk.openadsdk.ls.dl.z.g gVar;
        if (map == null || map.size() == 0) {
            return;
        }
        String str = map.get("type");
        String str2 = map.get(NotificationCompat.CATEGORY_STATUS);
        String str3 = map.get("open_uid");
        String str4 = map.get("task_key");
        if ("1".equals(str2) && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObjectOptJSONObject = g(Integer.parseInt(str), str4).optJSONObject("extra");
                if (jSONObjectOptJSONObject == null) {
                    return;
                }
                String strOptString = jSONObjectOptJSONObject.optString("callback");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(strOptString);
                if (TextUtils.isEmpty(jSONObject.optString("name")) || (gVar = (com.bytedance.sdk.openadsdk.ls.dl.z.g) io.z(this.f1241a, com.bytedance.sdk.openadsdk.ls.dl.z.g.class)) == null) {
                    return;
                }
                HashMap map2 = new HashMap();
                map2.put("open_uid", str3);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map2.put(next, jSONObject.opt(next));
                }
                gVar.z(3, map2);
                return;
            } catch (Exception e) {
                wp.g("TTLiveSDkBridge", "onTaskFinish parse extra error", e);
                return;
            }
        }
        wp.g("TTLiveSDkBridge", "onTaskFinish status is :" + str2);
    }

    public void dl(Map<String, String> map) {
        com.bytedance.sdk.openadsdk.ls.dl.z.g gVar = (com.bytedance.sdk.openadsdk.ls.dl.z.g) io.z(this.f1241a, com.bytedance.sdk.openadsdk.ls.dl.z.g.class);
        if (gVar == null) {
            return;
        }
        gVar.z(4, map);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public void z(com.bytedance.sdk.openadsdk.pf.a aVar) {
        this.e = aVar;
        fo();
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.z, com.bytedance.sdk.openadsdk.core.live.z.a
    public long dl() {
        return this.v;
    }
}
