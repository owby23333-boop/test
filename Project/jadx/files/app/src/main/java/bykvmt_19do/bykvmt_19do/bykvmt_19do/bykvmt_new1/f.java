package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.msdk.api.v2.GMMediationAdSdk;
import com.example.adtesttool.R$mipmap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTTestToolUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public static Map<String, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.c> a = new HashMap();
    public static Map<Integer, List<bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.d>> b = new HashMap();

    private static void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            a.clear();
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys != null) {
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                    if (jSONObjectOptJSONObject != null) {
                        bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.c cVar = new bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.c(jSONObjectOptJSONObject.optString("app_id"), jSONObjectOptJSONObject.optString("app_key"));
                        cVar.b(next);
                        a(cVar);
                        a.put(next, cVar);
                    }
                }
            }
        }
    }

    public static List<bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.c> b() {
        if (a == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = a.keySet().iterator();
        while (it.hasNext()) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.c cVar = a.get(it.next());
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public static void b(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("tt_sdk_settings_" + GMMediationAdSdk.getAppId(), 0);
        sharedPreferences.getInt("use_new_sdk_init", 0);
        try {
            String string = sharedPreferences.getString("adn_init_conf", "");
            if (!TextUtils.isEmpty(string)) {
                if (!string.startsWith("[") && !string.startsWith("{")) {
                    string = a.a(string, b.a());
                }
                a(new JSONObject(string));
            }
            String string2 = sharedPreferences.getString("rit_conf", "");
            if (TextUtils.isEmpty(string2)) {
                return;
            }
            if (!string2.startsWith("[") && !string2.startsWith("{")) {
                string2 = a.a(string2, b.a());
            }
            a(new JSONArray(string2));
        } catch (Exception unused) {
        }
    }

    private static void a(JSONArray jSONArray) throws JSONException {
        if (jSONArray != null) {
            b.clear();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.d dVar = null;
                if (jSONObject != null) {
                    dVar = new bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.d();
                    dVar.a(jSONObject.optString("rit_id"));
                    dVar.b(jSONObject.optInt("rit_type"));
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adn_rit_conf");
                    ArrayList<bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.e> arrayList = new ArrayList<>();
                    if (jSONArrayOptJSONArray != null) {
                        for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                            JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i3);
                            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.e eVar = new bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.e();
                            eVar.c(jSONObject2.optString("adn_name"));
                            eVar.c(jSONObject2.optInt("load_sort"));
                            eVar.g(jSONObject2.optInt("show_sort"));
                            eVar.b(jSONObject2.optString("adn_slot_id"));
                            eVar.b(jSONObject2.optInt("req_bidding_type"));
                            eVar.e(jSONObject2.optInt("origin_type"));
                            eVar.f(dVar.c());
                            eVar.d(dVar.b());
                            a(eVar);
                            arrayList.add(eVar);
                        }
                    }
                    Collections.sort(arrayList);
                    dVar.a(arrayList);
                }
                if (dVar != null) {
                    int iC = dVar.c();
                    List<bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.d> arrayList2 = b.get(Integer.valueOf(iC));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    arrayList2.add(dVar);
                    b.put(Integer.valueOf(iC), arrayList2);
                }
            }
        }
    }

    private static void a(bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.c cVar) {
        int i2;
        String strC;
        if (cVar == null || TextUtils.isEmpty(cVar.c())) {
            return;
        }
        switch (cVar.c()) {
            case "gdt":
                i2 = R$mipmap.ttt_icon_gdt;
                strC = "优量汇";
                break;
            case "admob":
                i2 = R$mipmap.ttt_icon_admob;
                strC = "Admob";
                break;
            case "pangle":
                i2 = R$mipmap.ttt_icon_pangle;
                strC = "穿山甲";
                break;
            case "mintegral":
                i2 = R$mipmap.ttt_icon_mintegral;
                strC = "Mintegral";
                break;
            case "unity":
                i2 = R$mipmap.ttt_icon_unity;
                strC = "Unity";
                break;
            case "baidu":
                i2 = R$mipmap.ttt_icon_baidu;
                strC = "百度";
                break;
            case "ks":
                i2 = R$mipmap.ttt_icon_ks;
                strC = "快手";
                break;
            case "sigmob":
                i2 = R$mipmap.ttt_icon_sigmob;
                strC = "Sigmob";
                break;
            case "klevin":
                i2 = R$mipmap.ttt_icon_klevin;
                strC = "游可赢";
                break;
            default:
                strC = cVar.c();
                i2 = R$mipmap.ttt_icon_custom;
                break;
        }
        cVar.a(strC);
        cVar.a(i2);
    }

    private static void a(bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.e eVar) {
        int i2;
        String strD;
        if (eVar == null || TextUtils.isEmpty(eVar.d())) {
            return;
        }
        switch (eVar.d()) {
            case "gdt":
                i2 = R$mipmap.ttt_icon_gdt;
                strD = "优量汇";
                break;
            case "admob":
                i2 = R$mipmap.ttt_icon_admob;
                strD = "Admob";
                break;
            case "pangle":
                i2 = R$mipmap.ttt_icon_pangle;
                strD = "穿山甲";
                break;
            case "mintegral":
                i2 = R$mipmap.ttt_icon_mintegral;
                strD = "Mintegral";
                break;
            case "unity":
                i2 = R$mipmap.ttt_icon_unity;
                strD = "Unity";
                break;
            case "baidu":
                i2 = R$mipmap.ttt_icon_baidu;
                strD = "百度";
                break;
            case "ks":
                i2 = R$mipmap.ttt_icon_ks;
                strD = "快手";
                break;
            case "sigmob":
                i2 = R$mipmap.ttt_icon_sigmob;
                strD = "Sigmob";
                break;
            case "klevin":
                i2 = R$mipmap.ttt_icon_klevin;
                strD = "游可赢";
                break;
            default:
                strD = eVar.d();
                i2 = R$mipmap.ttt_icon_custom;
                break;
        }
        eVar.a(i2);
        eVar.a(strD);
    }

    public static List<bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.b> a() {
        Map<Integer, List<bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.d>> map = b;
        if (map == null || map.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : b.keySet()) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.b bVar = new bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.b();
            bVar.a(num.intValue());
            bVar.a(com.bytedance.mtesttools.base.a.a(num.intValue()) + "广告");
            bVar.a(b.get(num));
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public static void a(String str, int i2) {
        Map<Integer, List<bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.d>> map = b;
        if (map == null || map.size() == 0 || i2 == 0) {
            return;
        }
        Iterator<Integer> it = b.keySet().iterator();
        while (it.hasNext()) {
            List<bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.d> list = b.get(it.next());
            if (list != null && list.size() > 0) {
                for (bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.d dVar : list) {
                    if (dVar != null && dVar.d() != null) {
                        for (bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.e eVar : dVar.d()) {
                            if (str.equals(eVar.c())) {
                                eVar.d(i2);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getDeviceId();
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
