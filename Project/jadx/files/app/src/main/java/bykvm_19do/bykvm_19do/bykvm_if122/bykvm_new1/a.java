package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements e {
    private Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> b = new ConcurrentHashMap();
    private e0 a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d.O();

    a() {
    }

    private List<String> a(Context context) {
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

    private void a(JSONObject jSONObject) {
        this.b.clear();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a aVarA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a.a(next, jSONObjectOptJSONObject);
            if (jSONObjectOptJSONObject != null && aVarA != null) {
                if (TextUtils.equals(next, "pangle") && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().A()) {
                    this.b.put("pangle_custom", aVarA);
                } else {
                    this.b.put(next, aVarA);
                }
            }
        }
    }

    private Set<String> b() {
        HashSet hashSet = new HashSet();
        if (this.b.size() != 0) {
            for (Map.Entry<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> entry : this.b.entrySet()) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a value = entry.getValue();
                if (value != null && !value.d()) {
                    hashSet.add(entry.getKey());
                }
            }
        }
        return hashSet;
    }

    private void c() {
        String strA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.a(this.a.d("adn_init_config"), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
        if (strA == null || TextUtils.isEmpty(strA)) {
            return;
        }
        try {
            a(new JSONObject(strA));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a a(String str) {
        if (this.b.size() == 0) {
            c();
        }
        return this.b.get(str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> a() {
        if (this.b.size() == 0) {
            c();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a value = it.next().getValue();
            if (value != null && value.d()) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            a(jSONObject);
            String strB = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.b(jSONObject.toString(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
            if (strB != null && !TextUtils.isEmpty(strB)) {
                this.a.b("adn_init_config", strB);
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_for12.a.j().b(jSONObject);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public void d() {
        List<String> listA;
        synchronized (this) {
            Context contextD = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d();
            if (contextD != null) {
                Set<String> setB = b();
                if (setB.size() != 0) {
                    int i2 = contextD.getApplicationInfo().targetSdkVersion;
                    Logger.i("TTMediationSDK_SDK_Init", "------------------ GroMore 接入信息 start ---------------------");
                    Logger.d("TTMediationSDK_SDK_Init", "当前接入的GroMore SDK版本是：3.9.0.2");
                    if ((Build.VERSION.SDK_INT >= 24 || i2 >= 24) && (listA = a(contextD)) != null) {
                        Iterator<String> it = setB.iterator();
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
                    if (mapE != null) {
                        for (String str : setB) {
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
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public boolean e() {
        if (this.b.size() == 0) {
            c();
        }
        return this.b.isEmpty();
    }
}
