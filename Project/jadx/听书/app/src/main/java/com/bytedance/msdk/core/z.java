package com.bytedance.msdk.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.a.m;
import com.bytedance.msdk.api.a.v;
import com.bytedance.msdk.gz.l;
import com.bytedance.msdk.gz.mc;
import com.bytedance.msdk.gz.q;
import com.bytedance.msdk.gz.uf;
import com.bytedance.msdk.m.g.gc;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.ls.a;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static final z xl = new z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f422a;
    private String dl;
    private Object eo;
    private boolean fo;
    private String[] g;
    private String gk;
    private v gp;
    private String gz;
    private boolean h;
    private String hh;
    private String i;
    private boolean io;
    private int[] j;
    private m js;
    private Map<String, String> kb;
    private boolean l;
    private boolean lq;
    private PluginValueSet mc;
    private final Map<String, Float> na;
    private long oq;
    private boolean sy;
    private com.bytedance.msdk.z.dl.dl ti;
    private JSONObject uf;
    private String uy;
    private final Map<String, Integer> wj;
    private String wp;
    private com.bytedance.msdk.api.a.z.fo.z x;
    private List<String> zw;
    private int z = 0;
    private boolean gc = true;
    private boolean m = false;
    private boolean e = false;
    private Set<String> v = new HashSet();
    private Map<String, Map<String, String>> pf = new HashMap();
    private Map<String, Map<String, String>> ls = new HashMap();
    private boolean p = false;
    private final Map<String, Object> fv = new q();
    private long tb = -1;
    private Map<String, Object> q = new ConcurrentHashMap();
    private Map<String, Object> iq = new ConcurrentHashMap();
    private int un = -1;

    public void z(boolean z) {
        this.p = z;
    }

    public boolean z() {
        return this.p;
    }

    public com.bytedance.msdk.z.dl.dl g() {
        if (this.ti == null) {
            a aVarZ = a.z();
            gc.z(aVarZ);
            this.ti = com.bytedance.msdk.z.dl.dl.z(aVarZ.g());
        }
        return this.ti;
    }

    public void z(String str, float f) {
        this.na.put(str, Float.valueOf(f));
    }

    public float z(String str) {
        return this.na.get(str).floatValue();
    }

    public void z(long j) {
        com.bytedance.msdk.e.g.z.z().z(j);
    }

    public long dl() {
        long j = this.tb;
        if (j != -1) {
            return j;
        }
        long jG = com.bytedance.msdk.e.g.z.z().g();
        this.tb = jG;
        return jG;
    }

    private z() {
        HashMap map = new HashMap();
        this.wj = map;
        this.na = new ConcurrentHashMap();
        if (g.g().eo()) {
            map.put(MediationConstant.KEY_USE_POLICY_AD_GAP, 1);
            map.put(MediationConstant.KEY_USE_POLICY_AD_LOAD, 1);
            map.put(MediationConstant.KEY_USE_POLICY_SECTION_ID, 1);
            map.put(MediationConstant.KEY_USE_POLICY_PAGE_ID, 1);
            map.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, 1);
        }
    }

    public Map<String, Integer> a() {
        return this.wj;
    }

    public long gc() {
        return this.oq;
    }

    public void g(long j) {
        this.oq = j;
    }

    public String m() {
        return this.gk;
    }

    public void g(String str) {
        this.gk = str;
    }

    public boolean e() {
        return this.fo;
    }

    public void g(boolean z) {
        this.fo = z;
    }

    public String gz() {
        if (("com.union_test.toutiao".equals(g.getContext().getPackageName()) && "5001121".equals(this.dl)) || ("com.bytedance.mediation_demo".equals(g.getContext().getPackageName()) && "5001121".equals(this.dl))) {
            try {
                return l.z("tt_mediation_ppe_info", g.getContext()).g("tt_ppe_content");
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean fo() {
        return "com.bytedance.mediation_demo_csj".equals(g.getContext().getPackageName()) && uy();
    }

    public boolean uy() {
        String path = com.bytedance.sdk.openadsdk.api.plugin.g.dl(g.getContext()).getPath();
        if (this.un < 0) {
            if (new File(path + "/e2e.text").exists()) {
                this.un = 1;
            } else {
                this.un = 0;
            }
        }
        return this.un > 0;
    }

    public static z kb() {
        return xl;
    }

    public String wp() {
        return this.dl;
    }

    public void dl(String str) {
        fo(str);
        this.dl = str;
    }

    public void dl(boolean z) {
        this.lq = z;
    }

    public boolean i() {
        return this.lq;
    }

    public boolean v() {
        return this.e;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void a(String str) {
        this.gz = str;
    }

    public String pf() {
        return this.uy;
    }

    public void gc(String str) {
        this.uy = str;
    }

    public Map<String, String> ls() {
        return this.kb;
    }

    public void z(Map<String, String> map) {
        this.kb = map;
    }

    public String p() {
        return this.gz;
    }

    public void gc(boolean z) {
        this.gc = z;
    }

    public void z(int... iArr) {
        this.j = iArr;
    }

    public void m(boolean z) {
        this.m = z;
    }

    public String fv() {
        return this.f422a;
    }

    public static String z(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getApplicationInfo().packageName, 0);
            String str = (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "");
            return str;
        } catch (Throwable th) {
            wp.z(th);
            return "";
        }
    }

    public void m(String str) {
        if (TextUtils.isEmpty(str)) {
            str = z(g.getContext());
        }
        this.f422a = str;
    }

    public void z(int i) {
        this.z = i;
    }

    public void z(String[] strArr) {
        this.g = strArr;
    }

    private static void fo(String str) {
        uf.z(str, "appid不能为空");
    }

    public String js() {
        if (!TextUtils.isEmpty(this.i)) {
            return this.i;
        }
        String strZ = l.z((String) null, g.getContext()).z();
        this.i = strZ;
        if (!TextUtils.isEmpty(strZ)) {
            return this.i;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        l.z((String) null, g.getContext()).z(strValueOf);
        this.i = strValueOf;
        return strValueOf;
    }

    public boolean tb() {
        try {
            if ("com.union_test.toutiao".equals(g.getContext().getPackageName()) && "5001121".equals(this.dl)) {
                return true;
            }
            if ("com.pangolin_demo.toutiao".equals(g.getContext().getPackageName()) && "5001121".equals(this.dl)) {
                return true;
            }
            if ("com.bytedance.mediation_demo".equals(g.getContext().getPackageName()) && "5001121".equals(this.dl)) {
                return true;
            }
            if ("com.msdk.qa.monkey".equals(g.getContext().getPackageName()) && "5001121".equals(this.dl)) {
                return true;
            }
            if (g.getContext().getPackageName().contains("com.bytedance.mediation_demo_csj")) {
                return "5001121".equals(this.dl);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean q() {
        String strZ = mc.z();
        return "com.union_test.toutiao".equals(strZ) || "com.bytedance.mediation_demo".equals(strZ) || "com.msdk.qa.monkey".equals(strZ);
    }

    public void e(String str) {
        this.wp = str;
    }

    public m iq() {
        return this.js;
    }

    public void z(m mVar, boolean z) {
        boolean zEquals;
        if (!z) {
            m mVar2 = this.js;
            if (mVar2 == null && mVar == null) {
                zEquals = true;
            } else {
                zEquals = (mVar2 == null || mVar == null) ? false : mVar2.equals(mVar);
            }
            this.js = mVar;
            if (zEquals) {
                return;
            }
            com.bytedance.msdk.core.v.g.z(g.g()).z().z(3);
            return;
        }
        this.js = mVar;
    }

    public v zw() {
        if (this.gp == null) {
            this.gp = v.z(kb().g());
        }
        return this.gp;
    }

    public void io() {
        this.gp = v.z(kb().g());
    }

    public Map<String, Object> uf() {
        return this.q;
    }

    public void g(Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        this.q.putAll(map);
    }

    public Map<String, Object> sy() {
        return this.iq;
    }

    public void dl(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.iq.putAll(map);
    }

    public List<String> hh() {
        return this.zw;
    }

    public void z(List<String> list) {
        this.zw = list;
    }

    public boolean l() {
        return this.io;
    }

    public void e(boolean z) {
        this.io = z;
    }

    public JSONObject h() {
        return this.uf;
    }

    public void z(JSONObject jSONObject) {
        this.uf = jSONObject;
    }

    public boolean gk() {
        return this.sy;
    }

    public void gz(boolean z) {
        this.sy = z;
    }

    public String x() {
        return this.hh;
    }

    public void gz(String str) {
        this.hh = str;
    }

    public boolean lq() {
        return this.l;
    }

    public void fo(boolean z) {
        this.l = z;
    }

    public boolean mc() {
        return this.h;
    }

    public void uy(boolean z) {
        this.h = z;
    }

    public Map<String, Object> un() {
        this.fv.put(MediationConstant.KEY_GM_USB, com.bytedance.msdk.core.fo.gc.gc());
        return this.fv;
    }

    public PluginValueSet ti() {
        PluginValueSet pluginValueSet = this.mc;
        return pluginValueSet != null ? pluginValueSet : com.bykv.z.z.z.z.z.z().g();
    }

    public void z(PluginValueSet pluginValueSet) {
        this.mc = pluginValueSet;
    }

    public com.bytedance.msdk.api.a.z.fo.z eo() {
        return this.x;
    }

    public void z(com.bytedance.msdk.api.a.z.fo.z zVar) {
        this.x = zVar;
    }

    public Object oq() {
        return this.eo;
    }

    public void z(Object obj) {
        this.eo = obj;
    }
}
