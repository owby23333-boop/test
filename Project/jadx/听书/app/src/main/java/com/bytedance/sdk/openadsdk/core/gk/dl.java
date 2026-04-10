package com.bytedance.sdk.openadsdk.core.gk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.tb;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.hh;
import com.bytedance.sdk.openadsdk.core.un.na;
import com.bytedance.sdk.openadsdk.core.un.sy;
import com.bytedance.sdk.openadsdk.core.un.x;
import com.bytedance.sdk.openadsdk.core.zw;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.an;
import com.umeng.umcrash.UMCrash;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends com.bytedance.sdk.component.uy.fo {
    private static volatile dl z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f1107a;
    private final z dl;
    private Comparator<JSONObject> e;
    private final Context g;
    private boolean gc;
    private volatile AtomicBoolean m;

    public static dl z() {
        if (z == null) {
            synchronized (dl.class) {
                if (z == null) {
                    z = new dl();
                }
            }
        }
        return z;
    }

    private dl() {
        super("ApplistHelper");
        this.f1107a = new AtomicBoolean(false);
        this.gc = false;
        this.m = new AtomicBoolean(true);
        this.e = new Comparator<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.gk.dl.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                return jSONObject.optString(an.o).compareTo(jSONObject2.optString(an.o));
            }
        };
        Context context = zw.getContext();
        this.g = context;
        this.dl = new z(context);
    }

    public void g() {
        if (eo.g()) {
            this.gc = zw.g().kp() && com.bytedance.sdk.openadsdk.core.uy.ls().p().g();
            if (gz.a() && this.m.get() && !this.f1107a.get()) {
                this.f1107a.set(true);
                try {
                    com.bytedance.sdk.component.uy.e.z(this, 1);
                } catch (Throwable unused) {
                    this.f1107a.set(false);
                }
            }
        }
    }

    private List<JSONObject> g(Context context) {
        List list;
        ArrayList arrayList = new ArrayList();
        if (context == null || !this.gc || (sy.iq() && Build.VERSION.SDK_INT >= 29)) {
            return arrayList;
        }
        try {
            JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.z.dl(g.z("6;37988e9g6h::3<4f9;g437;iei3:d66i5fd<9dde7;f579fUPZmGK\\lXZ2Szig5dHFs58}Sis:eU4fg3JFRho|eROK9Y8U2tY2yOyLKL7yl7YtV}meo.{v;:Oxm#h|Wyszi:Petp;UwqLh9NQq;XiZe3w9]dTjf|jsp}3X5\\dhKrjlho|4Wh4.\\o;vipTtn5oi[i8<tR#H{T7S.\\u5nNpQJV|7khNsW8iH[iLhey;PfqgLhff")));
            Object objInvoke = com.bytedance.sdk.component.utils.sy.z(jSONObject.optString("pn"), jSONObject.optString("m2"), Integer.TYPE).invoke(com.bytedance.sdk.component.utils.sy.z(jSONObject.optString("cn"), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]), Integer.valueOf(jSONObject.optInt("f")));
            if ((objInvoke instanceof List) && (list = (List) objInvoke) != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof PackageInfo) {
                        PackageInfo packageInfo = (PackageInfo) obj;
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(an.o, packageInfo.packageName);
                        jSONObject2.put("first_install_time", packageInfo.firstInstallTime);
                        jSONObject2.put("last_update_time", packageInfo.lastUpdateTime);
                        jSONObject2.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, packageInfo.versionName);
                        jSONObject2.put("version_code", packageInfo.versionCode);
                        jSONObject2.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, "unknown");
                        jSONObject2.put("app_type", z(packageInfo));
                        jSONObject2.put("apk_dir", packageInfo.applicationInfo != null ? packageInfo.applicationInfo.sourceDir : "unknown");
                        arrayList.add(jSONObject2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public List<String> z(Context context) {
        List list;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.z.dl(g.z("6;37988e9g6h::3<4f9;g437;iei3:d66i5fd<9dde7;f579fUPZmGK\\lXZ2Szig5dHFs58}Sis:eU4fg3JFRho|eROK9Y8U2tY2yOyLKL7yl7YtV}meo.{v;:Oxm#h|Wyszi:Petp;UwqLh9NQq;XiZe3w9]dTjf|jsp}3X5\\dhKrjlho|4Wh4.\\o;vipTtn5oi[i8<tR#H{T7S.\\u5nNpQJV|7khNsW8iH[iLhey;PfqgLhff")));
            Object objInvoke = com.bytedance.sdk.component.utils.sy.z(jSONObject.optString("pn"), jSONObject.optString("m2"), Integer.TYPE).invoke(com.bytedance.sdk.component.utils.sy.z(jSONObject.optString("cn"), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]), Integer.valueOf(jSONObject.optInt("f")));
            if ((objInvoke instanceof List) && (list = (List) objInvoke) != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof PackageInfo) {
                        PackageInfo packageInfo = (PackageInfo) obj;
                        if (z(packageInfo) != 1) {
                            arrayList.add("unknown:" + packageInfo.packageName);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private int z(PackageInfo packageInfo) {
        if (packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 1) == 1) {
            return 1;
        }
        if (String.valueOf(packageInfo.firstInstallTime).endsWith("000")) {
            return 2;
        }
        return 1 & packageInfo.applicationInfo.flags;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!v.z(this.g)) {
            this.f1107a.set(false);
            return;
        }
        try {
            boolean zDl = this.dl.dl();
            this.m.set(false);
            if (zDl) {
                g(g(this.g));
            } else {
                this.f1107a.set(false);
            }
        } catch (Throwable th) {
            this.f1107a.set(false);
            wp.g("ApplistHelper", "upload sdk runnable error: ", th);
        }
    }

    private boolean z(List<JSONObject> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Collections.sort(list, this.e);
        String strDl = com.bytedance.sdk.component.utils.z.dl(this.dl.g());
        if (TextUtils.isEmpty(strDl)) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(strDl);
            int length = jSONArray.length();
            if (length != list.size()) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                arrayList.add(jSONArray.getJSONObject(i));
            }
            Collections.sort(arrayList, this.e);
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = list.get(i2);
                JSONObject jSONObject2 = (JSONObject) arrayList.get(i2);
                String strOptString = jSONObject.optString(an.o);
                String strOptString2 = jSONObject.optString("last_update_time");
                if (strOptString == null || strOptString2 == null || !strOptString.equals(jSONObject2.optString(an.o)) || !strOptString2.equals(jSONObject2.optString("last_update_time"))) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            wp.dl("ApplistHelper", "is app change error: ", th);
            return true;
        }
    }

    private void g(final List<JSONObject> list) {
        boolean z2 = z(list);
        JSONObject jSONObjectZ = z(z2 ? list : new ArrayList<>(), zw.g().zb(), zw.g().hy());
        if (list != null) {
            list.size();
        }
        na naVar = new na(com.bytedance.sdk.openadsdk.core.io.gc.z().g().m());
        naVar.z(eo.gz("/api/ad/union/sdk/upload/app_info/"));
        naVar.dl(jSONObjectZ, "applist");
        naVar.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.gk.dl.2
            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
                if (gVar == null || !gVar.gz() || TextUtils.isEmpty(gVar.a())) {
                    dl.this.m.set(true);
                } else {
                    try {
                        if ("20000".equals(new JSONObject(gVar.a()).optString(NotificationCompat.CATEGORY_STATUS))) {
                            dl.this.dl.z();
                            dl.this.dl.z(com.bytedance.sdk.component.utils.z.g(new JSONArray((Collection) list).toString()));
                        }
                    } catch (JSONException e) {
                        wp.z(e);
                    }
                }
                dl.this.f1107a.set(false);
            }

            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                dl.this.f1107a.set(false);
                dl.this.m.set(true);
            }
        });
    }

    private JSONObject z(List<JSONObject> list, List<String> list2, List<String> list3) {
        int i;
        Object obj;
        JSONObject jSONObject = new JSONObject();
        try {
            String strGz = com.bytedance.sdk.openadsdk.core.un.uy.gz();
            Object obj2 = "";
            if (TextUtils.isEmpty(strGz)) {
                strGz = "";
            }
            if (TextUtils.isEmpty(strGz)) {
                i = -1;
                obj = "";
            } else {
                obj = strGz;
                i = 1;
            }
            int i2 = 0;
            String strDl = com.bytedance.sdk.openadsdk.core.un.uy.dl(false);
            if (TextUtils.isEmpty(strDl)) {
                strDl = "";
            }
            if (i < 0 && !TextUtils.isEmpty(strDl)) {
                i = 4;
                obj = strDl;
            }
            String strZ = com.bytedance.sdk.openadsdk.core.un.uy.z();
            if (TextUtils.isEmpty(strZ)) {
                strZ = "";
            }
            String strP = com.bytedance.sdk.openadsdk.core.un.uy.p();
            if (!TextUtils.isEmpty(strP)) {
                obj2 = strP;
            }
            if (i < 0) {
                i = 3;
                obj = strZ;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<JSONObject> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().optString(an.o));
            }
            jSONObject.put("app_list", jSONArray);
            jSONObject.put("app_info", new JSONArray((Collection) list));
            jSONObject.put(UMCrash.SP_KEY_TIMESTAMP, System.currentTimeMillis());
            jSONObject.put("device_id", obj);
            jSONObject.put("did", tb.dl());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put(an.y, Build.VERSION.RELEASE);
            jSONObject.put("device_platform", "android");
            jSONObject.put("device_model", com.bytedance.sdk.openadsdk.core.un.uy.g());
            jSONObject.put(PluginConstants.KEY_APP_ID, com.bytedance.sdk.openadsdk.core.uy.ls().q());
            jSONObject.put("app_list_type", 1);
            jSONObject.put("sdk_version", gk.f1105a);
            jSONObject.put("device_id_type", i);
            jSONObject.put("imei", strGz);
            jSONObject.put("oaid", strDl);
            jSONObject.put("applog_did", obj2);
            jSONObject.put("android_id", strZ);
            if (list2 != null && !list2.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                for (String str : list2) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            if (eo.dl(zw.getContext(), str)) {
                                jSONArray2.put(str);
                            } else {
                                jSONArray3.put(str);
                            }
                        } catch (Throwable unused) {
                            jSONArray3.put(str);
                        }
                    }
                }
                jSONObject.put("have_applist", jSONArray2);
                jSONObject.put("no_applist", jSONArray3);
            }
            boolean zHn = zw.g().hn();
            if (!zHn) {
                i2 = 1;
            }
            jSONObject.put("scheme_get_type", i2);
            if (list3 != null && !list3.isEmpty() && zHn) {
                for (String str2 : list3) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            Uri uri = Uri.parse(str2);
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(uri);
                            eo.z(zw.getContext(), intent, true);
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
            Map<String, Boolean> mapZ = hh.z(259200000L);
            if (mapZ != null && mapZ.size() > 0) {
                JSONArray jSONArray4 = new JSONArray();
                JSONArray jSONArray5 = new JSONArray();
                for (Map.Entry<String, Boolean> entry : mapZ.entrySet()) {
                    if (entry.getValue().booleanValue()) {
                        jSONArray4.put(entry.getKey());
                    } else {
                        jSONArray5.put(entry.getKey());
                    }
                }
                jSONObject.put("scheme_success_list", jSONArray4);
                jSONObject.put("scheme_fail_list", jSONArray5);
            }
            List<String> listZ = eo.z();
            if (listZ.size() > 0) {
                jSONObject.put("query_all_package", listZ);
            }
        } catch (Exception unused3) {
        }
        return jSONObject;
    }

    class z {
        private com.bytedance.sdk.component.a.g.dl g;

        z(Context context) {
            try {
                this.g = z(context);
            } catch (Throwable unused) {
            }
        }

        private com.bytedance.sdk.component.a.g.dl z(Context context) {
            try {
                return x.z("tt_sp_app_list");
            } catch (Exception e) {
                wp.z(e);
                return null;
            }
        }

        void z(String str) {
            com.bytedance.sdk.component.a.g.dl dlVar;
            if (TextUtils.isEmpty(str) || (dlVar = this.g) == null) {
                return;
            }
            dlVar.put("old_app_list", str);
        }

        void z() {
            com.bytedance.sdk.component.a.g.dl dlVar = this.g;
            if (dlVar == null) {
                return;
            }
            dlVar.put("day_update_time", System.currentTimeMillis());
        }

        String g() {
            com.bytedance.sdk.component.a.g.dl dlVar = this.g;
            return dlVar == null ? "" : dlVar.get("old_app_list", "");
        }

        boolean dl() {
            com.bytedance.sdk.component.a.g.dl dlVar = this.g;
            return !eo.z(dlVar != null ? dlVar.get("day_update_time", 0L) : 0L, System.currentTimeMillis());
        }
    }

    private static class g {
        static String z(String str) {
            byte[] bytes = str.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] - 3);
            }
            return new String(bytes);
        }
    }
}
