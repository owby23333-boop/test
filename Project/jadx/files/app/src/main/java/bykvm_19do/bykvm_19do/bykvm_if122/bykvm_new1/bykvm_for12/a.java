package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_for12;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.k;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.b;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile a f1756h;
    private Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> f1757c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, c> f1758d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1759e = 100;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1760f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f1761g = 120000;
    private e0 a = d.S();

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_for12.a$a, reason: collision with other inner class name */
    class RunnableC0056a implements Runnable {
        final /* synthetic */ c a;

        RunnableC0056a(a aVar, c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = this.a;
            if (cVar == null || cVar.q() == null) {
                return;
            }
            if (this.a.H()) {
                if (m.b().a(this.a.g())) {
                    m.b().b(this.a.g());
                }
                if (m.b().a(this.a.f())) {
                    m.b().b(this.a.f());
                }
            } else {
                m.b().e(this.a.q() + "");
                m.b().d(this.a.q() + "");
            }
            for (j jVar : this.a.B()) {
                if (jVar.D()) {
                    if (l.b().a(jVar.o())) {
                        l.b().b(jVar.o());
                    }
                    if (k.b().a(jVar.n())) {
                        k.b().b(jVar.n());
                    }
                } else {
                    l.b().b(this.a.q() + "", jVar.d());
                    k.b().c(this.a.q() + "", jVar.d());
                }
            }
        }
    }

    private a() {
    }

    private static List<String> a(Context context) {
        String str;
        List<ProviderInfo> listQueryContentProviders = context.getPackageManager().queryContentProviders(context.getApplicationInfo().processName, context.getApplicationInfo().uid, 131072);
        if (listQueryContentProviders == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        context.getPackageName();
        Iterator<ProviderInfo> it = listQueryContentProviders.iterator();
        while (it.hasNext()) {
            switch (it.next().name) {
                case "com.bytedance.sdk.openadsdk.TTFileProvider":
                    str = "pangle";
                    arrayList.add(str);
                    break;
                case "com.bykv.vk.openvk.TTFileProvider":
                    str = "pangle_custom";
                    arrayList.add(str);
                    break;
                case "com.qq.e.comm.GDTFileProvider":
                    str = "gdt";
                    arrayList.add(str);
                    break;
                case "com.baidu.mobads.sdk.api.BdFileProvider":
                    str = "baidu";
                    arrayList.add(str);
                    break;
                case "com.sigmob.sdk.SigmobFileProvider":
                    str = "sigmob";
                    arrayList.add(str);
                    break;
                case "com.tencent.klevin.utils.FileProvider":
                    str = "klevin";
                    arrayList.add(str);
                    break;
                case "com.google.android.gms.ads.MobileAdsInitProvider":
                    str = "admob";
                    arrayList.add(str);
                    break;
                case "com.kwad.sdk.api.proxy.app.AdSdkFileProvider":
                    str = "ks";
                    arrayList.add(str);
                    break;
                case "com.mbridge.msdk.foundation.tools.MBFileProvider":
                    str = "mintegral";
                    arrayList.add(str);
                    break;
                case "com.unity":
                    str = "unity";
                    arrayList.add(str);
                    break;
            }
        }
        return arrayList;
    }

    private void a(c cVar) {
        ThreadHelper.runOnThreadPool(new RunnableC0056a(this, cVar));
    }

    private String b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        this.f1758d.clear();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            try {
                c cVarB = c.b(jSONArray.getJSONObject(i2));
                if (cVarB != null) {
                    this.f1758d.put(cVarB.q(), cVarB);
                    a(cVarB);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    private String c(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 == null) {
            return null;
        }
        i();
        Iterator<String> itKeys = jSONObject.keys();
        if (itKeys != null) {
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(next);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("app_id");
                    String strOptString2 = jSONObjectOptJSONObject.optString("app_key");
                    String strOptString3 = jSONObjectOptJSONObject.optString("custom_type");
                    if (TextUtils.equals(strOptString3, "1")) {
                        this.f1757c.put(next, new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a(next, strOptString, strOptString2, jSONObjectOptJSONObject.optString("init_class_name"), jSONObjectOptJSONObject.optString("banner_class_name"), jSONObjectOptJSONObject.optString("interstitial_class_name"), jSONObjectOptJSONObject.optString("reward_class_name"), jSONObjectOptJSONObject.optString("full_video_class_name"), jSONObjectOptJSONObject.optString("splash_class_name"), jSONObjectOptJSONObject.optString("feed_class_name"), jSONObjectOptJSONObject.optString("draw_class_name"), strOptString3));
                    } else {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a aVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a(strOptString, strOptString2);
                        if (TextUtils.equals(next, "pangle") && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().A()) {
                            this.b.put("pangle_custom", aVar);
                        }
                        this.b.put(next, aVar);
                    }
                }
                jSONObject2 = jSONObject;
            }
        }
        return jSONObject.toString();
    }

    private void i() {
        this.b.clear();
        this.f1757c.clear();
    }

    public static a j() {
        if (f1756h == null) {
            synchronized (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.b.class) {
                if (f1756h == null) {
                    f1756h = new a();
                }
            }
        }
        return f1756h;
    }

    private void k() throws JSONException {
        String strD = this.a.d("adn_init_conf");
        if (TextUtils.isEmpty(strD)) {
            return;
        }
        if (!strD.startsWith("[") && !strD.startsWith("{")) {
            strD = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.a(strD, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
        }
        c(new JSONObject(strD));
    }

    private void l() throws JSONException {
        String strD = this.a.d("tt_app_common_config");
        if (!TextUtils.isEmpty(strD)) {
            JSONObject jSONObject = new JSONObject(strD);
            this.f1759e = jSONObject.optInt("event_batch_size", 100);
            int i2 = this.f1759e;
            if (i2 <= 0 || i2 > 1000) {
                this.f1759e = 100;
            }
            this.f1760f = jSONObject.optInt("event_send_type", 0);
            this.f1761g = jSONObject.optLong("event_routine_interval", 120000L);
            long j2 = this.f1761g;
            if (j2 < 10000 || j2 > 300000) {
                this.f1761g = 120000L;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(jSONObject.optInt("pre_fetch_count", 20));
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(jSONObject.optInt("if_use_new_loglib", 0));
        }
        Logger.e("TTSETTING", "load--mEventBatchSize=" + this.f1759e + ",mEventSendType=" + this.f1760f + ", routineInterval=" + this.f1761g);
    }

    private void m() throws JSONException {
        String strD = this.a.d("rit_conf");
        if (TextUtils.isEmpty(strD)) {
            return;
        }
        if (!strD.startsWith("[") && !strD.startsWith("{")) {
            strD = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.a(strD, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
        }
        b(new JSONArray(strD));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a a(String str) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a aVar = this.b.get(str);
        return aVar != null ? aVar : this.f1757c.get(str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a>> it = this.f1757c.entrySet().iterator();
        while (it.hasNext()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a value = it.next().getValue();
            if (value != null && value.d()) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.g
    public void a(JSONArray jSONArray) {
        String strB;
        String strB2 = b(jSONArray);
        if (strB2 == null || (strB = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.b(strB2, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a())) == null) {
            return;
        }
        this.a.b("rit_conf", strB);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f1759e = jSONObject.optInt("event_batch_size", 100);
            int i2 = this.f1759e;
            if (i2 <= 0 || i2 > 1000) {
                this.f1759e = 100;
            }
            this.f1760f = jSONObject.optInt("event_send_type", 0);
            this.f1761g = jSONObject.optLong("event_routine_interval", 120000L);
            long j2 = this.f1761g;
            if (j2 < 10000 || j2 > 300000) {
                this.f1761g = 120000L;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(jSONObject.optInt("pre_fetch_count", 20));
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(jSONObject.optInt("if_use_new_loglib", 0));
            Logger.e("TTSETTING", "save--mEventBatchSize=" + this.f1759e + ",mEventSendType=" + this.f1760f + ", routineInterval=" + this.f1761g);
            this.a.b("tt_app_common_config", jSONObject.toString());
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public int b() {
        return this.f1759e;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.g
    public c b(String str) {
        return this.f1758d.get(str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public void b(JSONObject jSONObject) {
        String strB;
        String strC = c(jSONObject);
        if (strC == null || (strB = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.b(strC, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a())) == null) {
            return;
        }
        this.a.b("adn_init_conf", strB);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public long c() {
        return this.f1761g;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public void d() {
        Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> map;
        List<String> listA;
        Context contextD = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d();
        if (contextD == null || (map = this.b) == null) {
            return;
        }
        int i2 = contextD.getApplicationInfo().targetSdkVersion;
        Logger.i("TTMediationSDK_SDK_Init", "------------------ GroMore 接入信息 start ---------------------");
        Logger.d("TTMediationSDK_SDK_Init", "当前接入的GroMore SDK版本是：3.9.0.2");
        if ((Build.VERSION.SDK_INT >= 24 || i2 >= 24) && (listA = a(contextD)) != null) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!"unity".equals(next) && !"pangle_custom".equals(next)) {
                    if ("pangle".equals(next) && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().A()) {
                        next = "pangle_custom";
                    }
                    if (listA.contains(next)) {
                        Logger.i("TTMediationSDK_SDK_Init", "已按要求接入三方广告sdk【" + next + "】");
                    } else {
                        Logger.e("TTMediationSDK_SDK_Init", "未按要求接入三方广告sdk【" + next + "】，请检查接入配置");
                    }
                }
            }
        }
        Logger.i("TTMediationSDK_SDK_Init", "------------------ GroMore 接入信息 end ---------------------");
        Logger.i("TTMediationSDK_SDK_Init", "------------------ GroMore 版本信息 start ---------------------");
        Map<String, ITTAdapterConfiguration> mapE = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.e();
        Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> map2 = this.b;
        if (mapE != null && map2 != null) {
            for (String str : map2.keySet()) {
                try {
                    if (!"pangle_custom".equals(str) && !TextUtils.isEmpty(str)) {
                        ITTAdapterConfiguration iTTAdapterConfiguration = mapE.get(DefaultAdapterClasses.getClassNameByAdnName(str));
                        if (iTTAdapterConfiguration != null) {
                            iTTAdapterConfiguration.checkVersion();
                        } else {
                            Logger.e("TTMediationSDK_InitChecker", "没有引入" + str + "Adapter,请检查相关引入情况");
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        Logger.i("TTMediationSDK_SDK_Init", "------------------ GroMore 版本信息 end ---------------------");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public boolean e() {
        return this.b.isEmpty() && this.f1757c.isEmpty();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public int f() {
        return this.f1760f;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.g
    public boolean g() {
        return this.f1758d.isEmpty();
    }

    public void h() throws JSONException {
        k();
        m();
        l();
    }
}
