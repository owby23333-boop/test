package com.bytedance.msdk.e.z;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.text.TextUtils;
import com.bytedance.msdk.gz.l;
import com.bytedance.msdk.z.gc.m;
import com.bytedance.msdk.z.z.a;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static volatile g z;
    private Map<String, com.bytedance.msdk.core.uy.z> dl = new ConcurrentHashMap();
    private l g = com.bytedance.msdk.e.z.a();

    private g() {
    }

    public static g z() {
        if (z == null) {
            synchronized (g.class) {
                if (z == null) {
                    z = new g();
                }
            }
        }
        return z;
    }

    private void g(JSONObject jSONObject) {
        this.dl.clear();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
            com.bytedance.msdk.core.uy.z zVarZ = com.bytedance.msdk.core.uy.z.z(next, jSONObjectOptJSONObject);
            if (jSONObjectOptJSONObject != null && zVarZ != null) {
                this.dl.put(next, zVarZ);
            }
        }
    }

    private void m() {
        String strG = this.g.g("adn_init_config");
        if (TextUtils.isEmpty(strG)) {
            return;
        }
        if (!strG.startsWith("[") && !strG.startsWith("{")) {
            strG = com.bytedance.msdk.gz.z.g(strG, com.bytedance.msdk.gz.g.z());
        }
        if (TextUtils.isEmpty(strG)) {
            return;
        }
        try {
            g(new JSONObject(strG));
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    public void z(JSONObject jSONObject) {
        if (jSONObject != null) {
            g(jSONObject);
            String string = jSONObject.toString();
            if (!TextUtils.isEmpty(string)) {
                this.g.z("adn_init_config", string);
            }
        }
        dl(jSONObject);
    }

    private void dl(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        m.a(new Runnable() { // from class: com.bytedance.msdk.e.z.g.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.e.g.g.z().z(jSONObject);
            }
        });
    }

    public com.bytedance.msdk.core.uy.z z(String str) {
        if (this.dl.size() == 0) {
            m();
        }
        return this.dl.get(str);
    }

    public List<com.bytedance.msdk.core.uy.z> g() {
        if (this.dl.size() == 0) {
            m();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, com.bytedance.msdk.core.uy.z>> it = this.dl.entrySet().iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.core.uy.z value = it.next().getValue();
            if (value != null && value.gc()) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    public Map<String, com.bytedance.msdk.core.uy.z> dl() {
        if (this.dl.size() == 0) {
            m();
        }
        return new ConcurrentHashMap(this.dl);
    }

    public boolean g(String str) {
        com.bytedance.msdk.core.uy.z zVar;
        if (this.dl.size() == 0) {
            m();
        }
        Map<String, com.bytedance.msdk.core.uy.z> map = this.dl;
        return (map == null || (zVar = map.get(str)) == null || !zVar.gc()) ? false : true;
    }

    public boolean a() {
        if (this.dl.size() == 0) {
            m();
        }
        return this.dl.isEmpty();
    }

    private Set<String> e() {
        HashSet hashSet = new HashSet();
        if (this.dl.size() != 0) {
            for (Map.Entry<String, com.bytedance.msdk.core.uy.z> entry : this.dl.entrySet()) {
                com.bytedance.msdk.core.uy.z value = entry.getValue();
                if (value != null && !value.gc()) {
                    hashSet.add(entry.getKey());
                }
            }
        }
        return hashSet;
    }

    public synchronized void gc() {
        Context context = com.bytedance.msdk.core.g.getContext();
        if (context == null) {
            return;
        }
        Set<String> setE = e();
        if (setE.size() == 0) {
            return;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK_SDK_Init", "------------------ 聚合 接入信息 start ---------------------");
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_SDK_Init", "当前接入的聚合 SDK版本是：" + com.bytedance.msdk.g.g.g());
        List<String> listZ = z(context);
        if (listZ != null) {
            for (String str : setE) {
                if (!MediationConstant.ADN_UNITY.equals(str) && !MediationConstant.ADN_XIAOMI.equals(str)) {
                    if (!listZ.contains(str)) {
                        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK_SDK_Init", "未按要求接入三方广告sdk【" + str + "】，请检查接入配置");
                    } else {
                        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK_SDK_Init", "已按要求接入三方广告sdk【" + str + "】");
                    }
                }
            }
        }
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK_SDK_Init", "------------------ GroMore 接入信息 end ---------------------");
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK_SDK_Init", "------------------ GroMore 版本信息 start ---------------------");
        for (String str2 : setE) {
            if (!TextUtils.equals(str2, MediationConstant.ADN_PANGLE)) {
                a aVarZ = com.bytedance.msdk.m.g.g.z().z(str2);
                if (aVarZ != null) {
                    aVarZ.a();
                } else {
                    com.bytedance.msdk.z.gc.dl.a("TTMediationSDK_InitChecker", "没有引入" + str2 + "Adapter,请检查相关引入情况");
                }
            }
        }
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK_SDK_Init", "------------------ GroMore 版本信息 end ---------------------");
    }

    private List<String> z(Context context) {
        List<ProviderInfo> listQueryContentProviders = context.getPackageManager().queryContentProviders(context.getApplicationInfo().processName, context.getApplicationInfo().uid, 131072);
        if (listQueryContentProviders == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        context.getPackageName();
        Iterator<ProviderInfo> it = listQueryContentProviders.iterator();
        while (it.hasNext()) {
            String str = it.next().name;
            str.hashCode();
            switch (str) {
                case "com.baidu.mobads.sdk.api.BdFileProvider":
                    arrayList.add("baidu");
                    break;
                case "com.mbridge.msdk.foundation.tools.MBFileProvider":
                    arrayList.add(MediationConstant.ADN_MINTEGRAL);
                    break;
                case "com.sigmob.sdk.SigmobFileProvider":
                case "com.sigmob.sdk.SigmobFileV4Provider":
                    arrayList.add(MediationConstant.ADN_SIGMOB);
                    break;
                case "com.tencent.klevin.utils.FileProvider":
                    arrayList.add(MediationConstant.ADN_KLEVIN);
                    break;
                case "com.google.android.gms.ads.MobileAdsInitProvider":
                    arrayList.add(MediationConstant.ADN_ADMOB);
                    break;
                case "com.bykv.vk.openvk.TTFileProvider":
                case "com.bytedance.sdk.openadsdk.TTFileProvider":
                    arrayList.add(MediationConstant.ADN_PANGLE);
                    break;
                case "com.kwad.sdk.api.proxy.app.AdSdkFileProvider":
                    arrayList.add(MediationConstant.ADN_KS);
                    break;
                case "com.unity":
                    arrayList.add(MediationConstant.ADN_UNITY);
                    break;
                case "com.qq.e.comm.GDTFileProvider":
                    arrayList.add(MediationConstant.ADN_GDT);
                    break;
            }
        }
        return arrayList;
    }
}
