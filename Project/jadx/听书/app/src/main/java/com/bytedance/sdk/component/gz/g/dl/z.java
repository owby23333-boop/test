package com.bytedance.sdk.component.gz.g.dl;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.gz.z.a;
import com.bytedance.sdk.component.gz.z.gc;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static final LinkedList<String> z = new LinkedList<>();
    private static final LinkedList<String> g = new LinkedList<>();
    private static final LinkedList<String> dl = new LinkedList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final LinkedList<String> f730a = new LinkedList<>();
    private static final Map<String, Integer> gc = new HashMap();
    private static String m = "upload_init";
    private static int e = 0;
    private static int gz = 0;
    private static AtomicLong fo = new AtomicLong();

    public static boolean dl(String str) {
        return false;
    }

    public static String g(int i) {
        switch (i) {
            case 71:
                return "flush once";
            case 72:
                return "flush memory db";
            case 73:
                return "flush memory";
            case 74:
                return "new event";
            case 75:
            default:
                return "default";
            case 76:
                return "empty message";
            case 77:
                return "net error";
        }
    }

    public static boolean z(int i) {
        return i == 72 || i == 71;
    }

    public static synchronized int z(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Map<String, Integer> map = gc;
        Integer num = map.get(str);
        if (num == null) {
            map.put(str, 1);
            return 1;
        }
        int iIntValue = num.intValue() + 1;
        map.put(str, Integer.valueOf(iIntValue));
        return iIntValue;
    }

    public static synchronized String g(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = z;
        if (linkedList.size() >= 10) {
            linkedList.removeFirst();
            linkedList.add(str);
        } else {
            linkedList.add(str);
        }
        sb = new StringBuilder();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        return sb.toString();
    }

    private static synchronized String a(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = g;
        if (linkedList.size() >= 10) {
            linkedList.removeFirst();
            linkedList.add(str);
        } else {
            linkedList.add(str);
        }
        sb = new StringBuilder();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        return sb.toString();
    }

    private static synchronized String gc(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = dl;
        if (linkedList.size() >= 10) {
            linkedList.removeFirst();
            linkedList.add(str);
        } else {
            linkedList.add(str);
        }
        sb = new StringBuilder();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        return sb.toString();
    }

    private static synchronized String g() {
        StringBuilder sb;
        sb = new StringBuilder();
        Iterator<String> it = f730a.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        return sb.toString();
    }

    private static synchronized void m(String str) {
        LinkedList<String> linkedList = f730a;
        if (linkedList.size() >= 10) {
            linkedList.removeFirst();
            linkedList.add(str);
        } else {
            linkedList.add(str);
        }
    }

    public static String z(com.bytedance.sdk.component.gz.z.g gVar, gc gcVar) {
        if (gVar == null || gVar.e() == null || g(gcVar) || a(gcVar)) {
            return null;
        }
        if (gVar.g() == 3) {
            return gVar.e().optString(NotificationCompat.CATEGORY_EVENT);
        }
        return gVar.e().optString("label");
    }

    public static String g(com.bytedance.sdk.component.gz.z.g gVar, gc gcVar) {
        if (gVar == null || gVar.e() == null || g(gcVar) || a(gcVar)) {
            return null;
        }
        return gVar.e().optString("type");
    }

    public static String dl(com.bytedance.sdk.component.gz.z.g gVar, gc gcVar) {
        if (gcVar == null || gcVar.a() == null || !gcVar.a().z()) {
            return "";
        }
        String strZ = z(gVar, gcVar);
        if (TextUtils.isEmpty(strZ)) {
            if (TextUtils.isEmpty(g(gVar, gcVar))) {
                return null;
            }
            return "type:" + g(gVar, gcVar);
        }
        return "label:" + strZ;
    }

    public static int a(com.bytedance.sdk.component.gz.z.g gVar, gc gcVar) {
        if (gVar != null && gVar.e() != null && gVar.a() == 1) {
            try {
                return new JSONObject(gVar.e().optString("event_extra")).optInt("stats_index");
            } catch (JSONException e2) {
                wp.z(e2);
            }
        }
        return -1;
    }

    public static void z(List<com.bytedance.sdk.component.gz.z.g> list, String str, com.bytedance.sdk.component.gz.g.z.g gVar) {
        JSONObject jSONObjectE;
        if (list != null) {
            try {
                if (list.size() != 0) {
                    com.bytedance.sdk.component.gz.z.g gVar2 = list.get(0);
                    if (gVar2 == null || gVar2.a() == 0) {
                        long jIncrementAndGet = fo.incrementAndGet();
                        for (com.bytedance.sdk.component.gz.z.g gVar3 : list) {
                            if (gVar3 != null && (jSONObjectE = gVar3.e()) != null) {
                                String strOptString = jSONObjectE.optString("ad_extra_data");
                                if (!TextUtils.isEmpty(strOptString)) {
                                    JSONObject jSONObject = new JSONObject(strOptString);
                                    jSONObject.put("upload_count", jIncrementAndGet);
                                    jSONObject.put("upload_ts", System.currentTimeMillis());
                                    if (gVar != null) {
                                        String strG = gVar.g();
                                        boolean z2 = gVar.z();
                                        if (!TextUtils.isEmpty(strG)) {
                                            jSONObject.put("delete_msg", strG + " success:" + z2);
                                        }
                                    }
                                    jSONObjectE.put("ad_extra_data", jSONObject.toString());
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                wp.z(th);
            }
        }
    }

    public static synchronized int gc(com.bytedance.sdk.component.gz.z.g gVar, gc gcVar) {
        if (gVar != null) {
            if (gVar.e() != null) {
                try {
                    return new JSONObject(gVar.e().optString("ad_extra_data")).optInt("sdk_event_self_count");
                } catch (Exception e2) {
                    wp.z(e2);
                    return 0;
                }
            }
        }
        return 0;
    }

    public static String z(JSONObject jSONObject, gc gcVar) {
        if (jSONObject != null && !g(gcVar) && !a(gcVar)) {
            String strOptString = jSONObject.optString(MediationConstant.EXTRA_LOG_EXTRA);
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    return new JSONObject(strOptString).optString("rit");
                } catch (JSONException e2) {
                    wp.z(e2);
                }
            }
        }
        return "";
    }

    public static String m(com.bytedance.sdk.component.gz.z.g gVar, gc gcVar) {
        if (gVar != null && gVar.e() != null && !g(gcVar) && !a(gcVar)) {
            String strOptString = gVar.e().optString(MediationConstant.EXTRA_LOG_EXTRA);
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    return new JSONObject(strOptString).optString("req_id");
                } catch (JSONException e2) {
                    wp.z(e2);
                }
            }
        }
        return null;
    }

    public static void z(List<com.bytedance.sdk.component.gz.z.g> list, gc gcVar) {
        try {
            if (gcVar.a().dl()) {
                for (com.bytedance.sdk.component.gz.z.g gVar : list) {
                    if (gVar != null && gVar.fo() != 0) {
                        long jCurrentTimeMillis = System.currentTimeMillis() - gVar.fo();
                        com.bytedance.sdk.component.gz.g.g.g.z.gz().incrementAndGet();
                        com.bytedance.sdk.component.gz.g.g.g.z.i().getAndAdd(jCurrentTimeMillis);
                        gVar.dl(System.currentTimeMillis());
                    }
                    if (gVar != null) {
                        e(gVar, gcVar);
                    }
                }
                com.bytedance.sdk.component.gz.g.g.g.z.uy().getAndAdd(list.size());
            }
        } catch (Exception e2) {
            wp.z(e2);
        }
    }

    public static void e(com.bytedance.sdk.component.gz.z.g gVar, gc gcVar) {
        try {
            if (gVar.a() == 0 && gcVar.a() != null && gcVar.a().v()) {
                JSONObject jSONObjectE = gVar.e();
                String strZ = z(gVar, gcVar);
                if (dl(strZ)) {
                    return;
                }
                String strOptString = jSONObjectE.optString("ad_extra_data");
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject = new JSONObject(strOptString);
                    if (TextUtils.isEmpty(jSONObject.optString("will_send_labels"))) {
                        jSONObject.put("will_send_labels", gc(strZ));
                        jSONObject.put("send_success_valid_labels", g());
                    }
                    jSONObjectE.put("ad_extra_data", jSONObject.toString());
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("will_send_labels", gc(strZ));
                jSONObject2.put("send_success_valid_labels", g());
                jSONObjectE.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception e2) {
            wp.z(e2);
        }
    }

    public static void gz(com.bytedance.sdk.component.gz.z.g gVar, gc gcVar) {
        if (gcVar == null || gcVar.a() == null || !gcVar.a().dl()) {
            return;
        }
        try {
            com.bytedance.sdk.component.gz.g.g.g.z.z(System.currentTimeMillis() - gVar.gz());
            gVar.g(System.currentTimeMillis());
            if (gVar.a() == 0 && gcVar.a() != null && gcVar.a().v()) {
                String strZ = z(gVar, gcVar);
                if (dl(strZ)) {
                    return;
                }
                JSONObject jSONObjectE = gVar.e();
                String strOptString = gVar.e().optString("ad_extra_data");
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject = new JSONObject(strOptString);
                    if (TextUtils.isEmpty(jSONObject.optString("save_success_labels"))) {
                        jSONObject.put("save_success_labels", a(strZ));
                    }
                    jSONObjectE.put("ad_extra_data", jSONObject.toString());
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("save_success_labels", a(strZ));
                jSONObjectE.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception unused) {
        }
    }

    public static boolean z(gc gcVar) {
        return gcVar != null && TextUtils.equals(gcVar.gc(), "csj");
    }

    public static boolean g(gc gcVar) {
        return gcVar != null && TextUtils.equals(gcVar.gc(), "csj_mediation");
    }

    public static boolean dl(gc gcVar) {
        return gcVar != null && TextUtils.equals(gcVar.gc(), MediationConstant.ADN_PANGLE);
    }

    public static boolean a(gc gcVar) {
        return gcVar != null && TextUtils.equals(gcVar.gc(), "pgl_mediation");
    }

    public static boolean gc(gc gcVar) {
        return z(gcVar) || dl(gcVar);
    }

    public static void z(JSONObject jSONObject, com.bytedance.sdk.component.gz.g.a.z.z zVar, gc gcVar, int i) {
        a aVarA;
        if (gcVar != null && (aVarA = gcVar.a()) != null && aVarA.z() && gc(gcVar)) {
            jSONObject.optString("label");
        }
    }

    public static void z(List<com.bytedance.sdk.component.gz.z.g> list, int i, String str, gc gcVar) {
        a aVarA;
        if (gcVar == null || (aVarA = gcVar.a()) == null || !aVarA.z() || list == null || g(gcVar) || a(gcVar)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        boolean z2 = false;
        for (com.bytedance.sdk.component.gz.z.g gVar : list) {
            if (gVar.a() == 0) {
                JSONObject jSONObjectE = gVar.e();
                String strZ = z(gVar, gcVar);
                if (gVar.g() == 3) {
                    if (jSONObjectE != null) {
                        strZ = jSONObjectE.optString(NotificationCompat.CATEGORY_EVENT);
                    }
                    sb.append(" [v3:").append(strZ).append("] ");
                } else {
                    long jZ = z(gcVar, gVar);
                    int iGc = gc(gVar, gcVar);
                    sb.append(" [").append(jZ).append("_").append(strZ);
                    if (iGc == 0) {
                        sb.append("] ");
                    } else {
                        sb.append("_").append(iGc).append("] ");
                    }
                }
                z2 = true;
            } else if (gVar.a() == 1) {
                sb.append(" [").append(a(gVar, gcVar)).append("_").append(g(gVar, gcVar)).append("] ");
            }
        }
        if (z2) {
            dl.g("_upload", "ads:" + ((Object) sb) + g(i) + "," + str + ",total:" + list.size(), gcVar);
        } else {
            dl.g("_upload", "stats:" + ((Object) sb) + g(i) + "," + str + ",total:" + list.size(), gcVar);
        }
    }

    public static boolean z(com.bytedance.sdk.component.gz.z.g gVar) {
        return gVar != null && gVar.a() == 0 && gVar.gc() == 1;
    }

    public static boolean g(List<com.bytedance.sdk.component.gz.z.g> list, gc gcVar) {
        com.bytedance.sdk.component.gz.z.g gVar;
        return (list == null || list.size() == 0 || (gVar = list.get(0)) == null || gVar.a() != 0 || !z(gcVar)) ? false : true;
    }

    public static boolean fo(com.bytedance.sdk.component.gz.z.g gVar, gc gcVar) {
        return gVar != null && gVar.a() == 0 && z(gcVar);
    }

    public static boolean g(com.bytedance.sdk.component.gz.z.g gVar) {
        return gVar != null && gVar.a() == 3 && gVar.gc() == 2;
    }

    public static boolean dl(com.bytedance.sdk.component.gz.z.g gVar) {
        return gVar != null && gVar.a() == 0 && gVar.gc() == 2;
    }

    public static boolean a(com.bytedance.sdk.component.gz.z.g gVar) {
        return gVar != null && gVar.a() == 1 && gVar.gc() == 2;
    }

    public static boolean gc(com.bytedance.sdk.component.gz.z.g gVar) {
        return gVar != null && gVar.a() == 1 && gVar.gc() == 3;
    }

    public static boolean m(com.bytedance.sdk.component.gz.z.g gVar) {
        return gVar != null && gVar.a() == 2 && gVar.gc() == 3;
    }

    private static void z(com.bytedance.sdk.component.gz.z.g gVar, String str, a aVar, gc gcVar) {
        String strZ = z(gVar, gcVar);
        if (dl(strZ)) {
            return;
        }
        String strM = m(gVar, gcVar);
        if (gVar.a() == 0 && aVar.v()) {
            m(strZ + "_" + strM + "_" + str);
        }
    }

    public static long z(gc gcVar, com.bytedance.sdk.component.gz.z.g gVar) {
        if (gVar != null && gVar.e() != null) {
            try {
                return new JSONObject(gVar.e().optString("ad_extra_data")).optLong("sdk_event_index");
            } catch (Exception e2) {
                dl.dl(e2.getMessage(), gcVar);
            }
        }
        return 0L;
    }

    public static void z(boolean z2, int i, String str, String str2, int i2, String str3) {
        e++;
        if (z2) {
            gz++;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("suc", z2);
            jSONObject.put("scnt", gz);
            jSONObject.put("acnt", e);
            jSONObject.put("code", i);
            jSONObject.put("reqid", str2);
            jSONObject.put("len:", i2);
            jSONObject.put("rit", str3);
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
            a aVarGc = com.bytedance.sdk.component.gz.g.z.dl("csj").gc();
            if (aVarGc != null) {
                jSONObject.put("url", aVarGc.wp().m());
            } else {
                jSONObject.put("url", "emptyurl");
            }
            m = jSONObject.toString();
        } catch (Exception unused) {
            m = "unknown_json";
        }
    }

    public static String z() {
        return m;
    }

    public static void z(com.bytedance.sdk.component.gz.z.g gVar, gc gcVar, String str) {
        a aVarGc;
        if (g(gcVar) || gcVar == null || a(gcVar) || (aVarGc = com.bytedance.sdk.component.gz.g.z.dl(gcVar.gc()).gc()) == null || !aVarGc.z()) {
            return;
        }
        if (!TextUtils.isEmpty(g(gVar, gcVar))) {
            a(gVar, gcVar);
        }
        if (TextUtils.isEmpty(z(gVar, gcVar))) {
            return;
        }
        z(gcVar, gVar);
    }

    public static void z(List<com.bytedance.sdk.component.gz.z.g> list, gc gcVar, String str) {
        if (gcVar == null) {
            return;
        }
        try {
            a aVarA = gcVar.a();
            if (aVarA == null || !aVarA.z()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (com.bytedance.sdk.component.gz.z.g gVar : list) {
                if (gVar.a() == 1) {
                    sb.append(g(gVar, gcVar)).append("_").append(a(gVar, gcVar)).append("; ");
                } else if (gVar.a() == 0) {
                    if (gVar.g() == 3) {
                        if (gVar.e() != null) {
                            sb.append(gVar.e().optString(NotificationCompat.CATEGORY_EVENT));
                            long jZ = z(gcVar, gVar);
                            if (jZ != 0) {
                                sb.append("_").append(jZ);
                            }
                            sb.append("; ");
                        } else {
                            dl.g("_delete", "v3_error", gcVar);
                        }
                    } else {
                        sb.append(z(gVar, gcVar));
                        long jZ2 = z(gcVar, gVar);
                        if (jZ2 != 0) {
                            sb.append("_").append(jZ2);
                        }
                        sb.append("; ");
                    }
                }
            }
            sb.append("]").append(" total:" + list.size()).append(" table:" + str);
            dl.g("_remove", sb.toString(), gcVar);
        } catch (Exception e2) {
            dl.dl("_delete error", e2.getMessage(), gcVar);
        }
    }

    public static void z(int i, List<com.bytedance.sdk.component.gz.z.g> list, long j, gc gcVar, com.bytedance.sdk.component.gz.g.g.dl.g gVar) {
        com.bytedance.sdk.component.gz.z.g gVar2;
        if (gcVar != null) {
            try {
                if (gcVar.a().dl()) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - j;
                    if (i == 200) {
                        com.bytedance.sdk.component.gz.g.g.g.z.zw().getAndAdd(jCurrentTimeMillis);
                        com.bytedance.sdk.component.gz.g.g.g.z.q().incrementAndGet();
                        com.bytedance.sdk.component.gz.g.g.g.z.fv().getAndAdd(list.size());
                        com.bytedance.sdk.component.gz.g.g.g.z.gc().getAndAdd(list.size());
                        return;
                    }
                    dl.dl("-------AdThread code is " + i + " error  ------------", gcVar);
                    byte bA = -1;
                    if (i == -1) {
                        com.bytedance.sdk.component.gz.g.g.g.z.js().getAndAdd(list.size());
                    } else {
                        com.bytedance.sdk.component.gz.g.g.g.z.e().getAndAdd(list.size());
                    }
                    com.bytedance.sdk.component.gz.g.g.g.z.io().getAndAdd(jCurrentTimeMillis);
                    com.bytedance.sdk.component.gz.g.g.g.z.iq().incrementAndGet();
                    if (!list.isEmpty() && (gVar2 = list.get(0)) != null) {
                        bA = gVar2.a();
                    }
                    if (gVar != null) {
                        com.bytedance.sdk.component.gz.g.g.g.z.uf().append((int) bA).append("_").append(gVar.f735a).append("_").append(gVar.g).append("_").append(gVar.dl).append(" ");
                        return;
                    }
                    com.bytedance.sdk.component.gz.g.g.g.z.uf().append((int) bA).append("_").append(i).append(" ");
                }
            } catch (Exception unused) {
            }
        }
    }

    public static int dl(List<com.bytedance.sdk.component.gz.z.g> list, gc gcVar) {
        JSONObject jSONObjectE;
        String strOptString;
        if (list != null && list.size() == 1) {
            try {
                com.bytedance.sdk.component.gz.z.g gVar = list.get(0);
                if (gVar != null && gVar.gc() == 1 && (jSONObjectE = gVar.e()) != null && gVar.a() == 0) {
                    JSONObject jSONObjectOptJSONObject = jSONObjectE.optJSONObject("params");
                    if (jSONObjectOptJSONObject == null) {
                        strOptString = jSONObjectE.optString("ad_extra_data");
                    } else {
                        strOptString = jSONObjectOptJSONObject.optString("ad_extra_data");
                    }
                    JSONObject jSONObject = new JSONObject(strOptString);
                    int iOptInt = jSONObject.optInt("inner_appid", 0);
                    if (iOptInt != 0) {
                        jSONObject.remove("inner_appid");
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectE.put("ad_extra_data", jSONObject.toString());
                        } else {
                            jSONObjectOptJSONObject.put("ad_extra_data", jSONObject.toString());
                            jSONObjectE.put("params", jSONObjectOptJSONObject);
                        }
                        return iOptInt;
                    }
                }
            } catch (Throwable th) {
                wp.z(th);
            }
        }
        return 0;
    }

    public static void z(List<com.bytedance.sdk.component.gz.z.g> list, String str, gc gcVar) {
        try {
            a aVarA = gcVar.a();
            if (aVarA != null && aVarA.dl() && list != null && aVarA.v()) {
                for (com.bytedance.sdk.component.gz.z.g gVar : list) {
                    if (gVar != null) {
                        z(gVar, str, aVarA, gcVar);
                    }
                }
            }
        } catch (Exception e2) {
            dl.dl(e2.getMessage(), gcVar);
        }
    }
}
