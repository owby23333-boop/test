package com.bytedance.sdk.openadsdk.core.iq;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f1204a;
    private static int dl;
    private static int fo;
    private static int fv;
    private static int g;
    private static int i;
    private static int kb;
    private static int ls;
    private static int p;
    private static int pf;
    private static int uy;
    private static int v;
    private static int wp;
    private static int z;
    private final String io;
    private final int iq;
    private final int js;
    private final int q;
    private final int tb;
    private final int zw;
    private static final ArrayList<int[]> gc = new ArrayList<>();
    private static final ArrayList<int[]> m = new ArrayList<>();
    private static final ArrayList<int[]> e = new ArrayList<>();
    private static final ArrayList<int[]> gz = new ArrayList<>();
    private static String uf = "已为您延迟到奖励下发后再播放下一个";
    private static int sy = 3;
    private static int hh = 0;
    private static int l = 0;

    public static void z(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                int iOptInt = jSONObjectOptJSONObject.optInt("insert_ad_control", 1);
                z = iOptInt;
                if (iOptInt < 0 || iOptInt > 1) {
                    z = 1;
                }
                int iOptInt2 = jSONObjectOptJSONObject.optInt("insert_ad_control_fs", 1);
                g = iOptInt2;
                if (iOptInt2 < 0 || iOptInt2 > 1) {
                    g = 1;
                }
                dl = jSONObjectOptJSONObject.optInt("insert_ad_req_num", 3);
                f1204a = jSONObjectOptJSONObject.optInt("insert_ad_req_num_fs", 2);
                fo = jSONObjectOptJSONObject.optInt("insert_ad_toast_max_time", 5);
                uy = jSONObjectOptJSONObject.optInt("insert_ad_tip_max_time", 0);
                kb = jSONObjectOptJSONObject.optInt("insert_ad_tip_max_time_fs", 3);
                wp = jSONObjectOptJSONObject.optInt("refresh_ad_tip_max_time", 3);
                i = jSONObjectOptJSONObject.optInt("refresh_ad_tip_max_time_fs", 3);
                int iOptInt3 = jSONObjectOptJSONObject.optInt("refresh_ad_control", 1);
                v = iOptInt3;
                if (iOptInt3 < 0 || iOptInt3 > 1) {
                    v = 1;
                }
                pf = jSONObjectOptJSONObject.optInt("refresh_ad_req_num", 3);
                int iOptInt4 = jSONObjectOptJSONObject.optInt("force_refresh_ad_control", 1);
                ls = iOptInt4;
                if (iOptInt4 < 0 || iOptInt4 > 1) {
                    ls = 1;
                }
                p = jSONObjectOptJSONObject.optInt("force_refresh_ad_pause_over_time", 5000);
                fv = jSONObjectOptJSONObject.optInt("refresh_ad_reduce_time", 0);
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("insert_ad_pt_show_time");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    gc.clear();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i2);
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() == 2) {
                            gc.add(new int[]{jSONArrayOptJSONArray2.optInt(0), jSONArrayOptJSONArray2.optInt(1)});
                        }
                    }
                } else {
                    gc.add(new int[]{0, 500});
                }
                JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("insert_ad_vd_show_time");
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    m.clear();
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                        JSONArray jSONArrayOptJSONArray4 = jSONArrayOptJSONArray3.optJSONArray(i3);
                        if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() == 2) {
                            m.add(new int[]{jSONArrayOptJSONArray4.optInt(0), jSONArrayOptJSONArray4.optInt(1)});
                        }
                    }
                } else {
                    m.add(new int[]{0, 500});
                }
                JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray("insert_ad_pt_show_time_fs");
                if (jSONArrayOptJSONArray5 != null && jSONArrayOptJSONArray5.length() > 0) {
                    e.clear();
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray5.length(); i4++) {
                        JSONArray jSONArrayOptJSONArray6 = jSONArrayOptJSONArray5.optJSONArray(i4);
                        if (jSONArrayOptJSONArray6 != null && jSONArrayOptJSONArray6.length() == 2) {
                            e.add(new int[]{jSONArrayOptJSONArray6.optInt(0), jSONArrayOptJSONArray6.optInt(1)});
                        }
                    }
                } else {
                    e.add(new int[]{0, 500});
                }
                JSONArray jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray("insert_ad_vd_show_time_fs");
                if (jSONArrayOptJSONArray7 != null && jSONArrayOptJSONArray7.length() > 0) {
                    gz.clear();
                    for (int i5 = 0; i5 < jSONArrayOptJSONArray7.length(); i5++) {
                        JSONArray jSONArrayOptJSONArray8 = jSONArrayOptJSONArray7.optJSONArray(i5);
                        if (jSONArrayOptJSONArray8 != null && jSONArrayOptJSONArray8.length() == 2) {
                            gz.add(new int[]{jSONArrayOptJSONArray8.optInt(0), jSONArrayOptJSONArray8.optInt(1)});
                        }
                    }
                } else {
                    gz.add(new int[]{0, 500});
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("reward_aggregation_config");
                if (jSONObjectOptJSONObject2 != null) {
                    uf = jSONObjectOptJSONObject2.optString("refresh_ad_clickafter_tip_content", "已为您延迟到奖励下发后再播放下一个");
                    sy = jSONObjectOptJSONObject2.optInt("refresh_ad_clickafter_tip_content_max_time", 3);
                    hh = jSONObjectOptJSONObject2.optInt("refresh_ad_ifclick_swtich");
                    l = jSONObjectOptJSONObject2.optInt("refresh_ad_ifclick_swtich_fs");
                }
            } catch (Exception unused) {
            }
        }
    }

    public static boolean z() {
        return z == 1;
    }

    public static boolean g() {
        return g == 1;
    }

    public static boolean dl() {
        return v == 1;
    }

    public static boolean a() {
        return ls == 1;
    }

    public static int gc() {
        return dl;
    }

    public static int m() {
        return f1204a;
    }

    public static int e() {
        return pf;
    }

    public static int gz() {
        return fo;
    }

    public static int z(boolean z2) {
        if (z2) {
            return uy;
        }
        return kb;
    }

    public static int g(boolean z2) {
        if (z2) {
            return wp;
        }
        return i;
    }

    public static boolean z(boolean z2, boolean z3, int i2) {
        return z2 ? z(z3, i2) : g(z3, i2);
    }

    private static boolean z(boolean z2, int i2) {
        if (z2) {
            for (int[] iArr : m) {
                if (i2 >= iArr[0] && i2 <= iArr[1]) {
                    return true;
                }
            }
        } else {
            for (int[] iArr2 : gc) {
                if (i2 >= iArr2[0] && i2 <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean g(boolean z2, int i2) {
        if (z2) {
            for (int[] iArr : gz) {
                if (i2 >= iArr[0] && i2 <= iArr[1]) {
                    return true;
                }
            }
        } else {
            for (int[] iArr2 : e) {
                if (i2 >= iArr2[0] && i2 <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean z(int i2, na naVar, boolean z2) {
        return gc(naVar) > 0 && i2 * 1000 >= gc(naVar) - (g(z2) * 1000);
    }

    public static boolean z(int i2, na naVar) {
        return gc(naVar) > 0 && i2 * 1000 >= gc(naVar);
    }

    public static int fo() {
        return p;
    }

    public static int uy() {
        return fv / 1000;
    }

    public x(JSONObject jSONObject) {
        this.zw = jSONObject.optInt("carousel_pos", -1);
        this.js = jSONObject.optInt("insert_ad_control", 0);
        this.tb = jSONObject.optInt("refresh_ad_control", 0);
        this.iq = jSONObject.optInt("refresh_ad_imp_max_time", 0);
        this.q = jSONObject.optInt("force_refresh_ad_control", 0);
        this.io = jSONObject.optString("carousel_tip_content", "秒后将继续播放下一个");
    }

    public static void z(com.bytedance.sdk.component.a.g.dl dlVar) {
        try {
            z = dlVar.getInt("insert_ad_control", 1);
            g = dlVar.getInt("insert_ad_control_fs", 1);
            dl = dlVar.getInt("insert_ad_req_num", 3);
            f1204a = dlVar.getInt("insert_ad_req_num_fs", 2);
            fo = dlVar.getInt("insert_ad_toast_max_time", 5);
            uy = dlVar.getInt("insert_ad_tip_max_time", 0);
            kb = dlVar.getInt("insert_ad_tip_max_time_fs", 3);
            wp = dlVar.getInt("refresh_ad_tip_max_time", 3);
            i = dlVar.getInt("refresh_ad_tip_max_time_fs", 3);
            v = dlVar.getInt("refresh_ad_control", 1);
            pf = dlVar.getInt("refresh_ad_req_num", 3);
            ls = dlVar.getInt("force_refresh_ad_control", 1);
            p = dlVar.getInt("force_refresh_ad_pause_over_time", 5000);
            fv = dlVar.getInt("refresh_ad_reduce_time", 0);
            Set<String> stringSet = dlVar.getStringSet("insert_ad_pt_show_time", null);
            if (stringSet != null && !stringSet.isEmpty()) {
                gc.clear();
                Iterator<String> it = stringSet.iterator();
                while (it.hasNext()) {
                    String[] strArrSplit = it.next().split(",");
                    if (strArrSplit.length == 2) {
                        gc.add(new int[]{Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1])});
                    }
                }
            }
            Set<String> stringSet2 = dlVar.getStringSet("insert_ad_vd_show_time", null);
            if (stringSet2 != null && !stringSet2.isEmpty()) {
                m.clear();
                Iterator<String> it2 = stringSet2.iterator();
                while (it2.hasNext()) {
                    String[] strArrSplit2 = it2.next().split(",");
                    if (strArrSplit2.length == 2) {
                        m.add(new int[]{Integer.parseInt(strArrSplit2[0]), Integer.parseInt(strArrSplit2[1])});
                    }
                }
            }
            Set<String> stringSet3 = dlVar.getStringSet("insert_ad_pt_show_time_fs", null);
            if (stringSet3 != null && !stringSet3.isEmpty()) {
                e.clear();
                Iterator<String> it3 = stringSet3.iterator();
                while (it3.hasNext()) {
                    String[] strArrSplit3 = it3.next().split(",");
                    if (strArrSplit3.length == 2) {
                        e.add(new int[]{Integer.parseInt(strArrSplit3[0]), Integer.parseInt(strArrSplit3[1])});
                    }
                }
            }
            Set<String> stringSet4 = dlVar.getStringSet("insert_ad_vd_show_time_fs", null);
            if (stringSet4 != null && !stringSet4.isEmpty()) {
                gz.clear();
                Iterator<String> it4 = stringSet4.iterator();
                while (it4.hasNext()) {
                    String[] strArrSplit4 = it4.next().split(",");
                    if (strArrSplit4.length == 2) {
                        gz.add(new int[]{Integer.parseInt(strArrSplit4[0]), Integer.parseInt(strArrSplit4[1])});
                    }
                }
            }
            uf = dlVar.getString("refresh_ad_clickafter_tip_content", "已为您延迟到奖励下发后再播放下一个");
            sy = dlVar.getInt("refresh_ad_clickafter_tip_content_max_time", 3);
            hh = dlVar.getInt("refresh_ad_ifclick_swtich", 0);
            l = dlVar.getInt("refresh_ad_ifclick_swtich_fs", 0);
        } catch (Exception unused) {
        }
    }

    public static void g(com.bytedance.sdk.component.a.g.dl dlVar) {
        try {
            dlVar.put("insert_ad_control", z);
            dlVar.put("insert_ad_control_fs", g);
            dlVar.put("insert_ad_req_num", dl);
            dlVar.put("insert_ad_req_num_fs", f1204a);
            dlVar.put("insert_ad_toast_max_time", fo);
            dlVar.put("insert_ad_tip_max_time", uy);
            dlVar.put("insert_ad_tip_max_time_fs", kb);
            dlVar.put("refresh_ad_tip_max_time", wp);
            dlVar.put("refresh_ad_tip_max_time_fs", i);
            dlVar.put("refresh_ad_control", v);
            dlVar.put("refresh_ad_req_num", pf);
            dlVar.put("force_refresh_ad_control", ls);
            dlVar.put("force_refresh_ad_pause_over_time", p);
            dlVar.put("refresh_ad_reduce_time", fv);
            ArrayList<int[]> arrayList = gc;
            if (!arrayList.isEmpty()) {
                HashSet hashSet = new HashSet();
                for (int[] iArr : arrayList) {
                    if (iArr != null && iArr.length == 2) {
                        hashSet.add(iArr[0] + "," + iArr[1]);
                    }
                }
                dlVar.put("insert_ad_pt_show_time", hashSet);
            }
            ArrayList<int[]> arrayList2 = m;
            if (!arrayList2.isEmpty()) {
                HashSet hashSet2 = new HashSet();
                for (int[] iArr2 : arrayList2) {
                    if (iArr2 != null && iArr2.length == 2) {
                        hashSet2.add(iArr2[0] + "," + iArr2[1]);
                    }
                }
                dlVar.put("insert_ad_vd_show_time", hashSet2);
            }
            ArrayList<int[]> arrayList3 = e;
            if (!arrayList3.isEmpty()) {
                HashSet hashSet3 = new HashSet();
                for (int[] iArr3 : arrayList3) {
                    if (iArr3 != null && iArr3.length == 2) {
                        hashSet3.add(iArr3[0] + "," + iArr3[1]);
                    }
                }
                dlVar.put("insert_ad_pt_show_time_fs", hashSet3);
            }
            ArrayList<int[]> arrayList4 = gz;
            if (!arrayList4.isEmpty()) {
                HashSet hashSet4 = new HashSet();
                for (int[] iArr4 : arrayList4) {
                    if (iArr4 != null && iArr4.length == 2) {
                        hashSet4.add(iArr4[0] + "," + iArr4[1]);
                    }
                }
                dlVar.put("insert_ad_vd_show_time_fs", hashSet4);
            }
            dlVar.put("refresh_ad_ifclick_swtich_fs", l);
            dlVar.put("refresh_ad_ifclick_swtich", hh);
            dlVar.put("refresh_ad_clickafter_tip_content", uf);
            dlVar.put("refresh_ad_clickafter_tip_content_max_time", sy);
        } catch (Exception unused) {
        }
    }

    public void g(JSONObject jSONObject) {
        try {
            jSONObject.put("carousel_pos", this.zw);
            jSONObject.put("insert_ad_control", this.js);
            jSONObject.put("refresh_ad_control", this.tb);
            jSONObject.put("refresh_ad_imp_max_time", this.iq);
            jSONObject.put("force_refresh_ad_control", this.q);
            jSONObject.put("carousel_tip_content", this.io);
        } catch (JSONException unused) {
        }
    }

    private static x e(na naVar) {
        if (naVar == null) {
            return null;
        }
        return naVar.gp();
    }

    public static int z(na naVar) {
        x xVarE = e(naVar);
        if (xVarE == null) {
            return 0;
        }
        return xVarE.js;
    }

    public static int g(na naVar) {
        x xVarE = e(naVar);
        if (xVarE == null) {
            return 0;
        }
        return xVarE.tb;
    }

    public static int dl(na naVar) {
        x xVarE = e(naVar);
        if (xVarE == null) {
            return 0;
        }
        return xVarE.q;
    }

    public static int a(na naVar) {
        x xVarE = e(naVar);
        if (xVarE == null) {
            return -1;
        }
        return xVarE.zw;
    }

    public static int gc(na naVar) {
        x xVarE = e(naVar);
        if (xVarE == null) {
            return 0;
        }
        return xVarE.iq;
    }

    public static String m(na naVar) {
        x xVarE = e(naVar);
        return xVarE == null ? "秒后将继续播放下一个" : xVarE.io;
    }

    public static boolean z(boolean z2, na naVar, boolean z3) {
        return z2 ? dl(naVar, z3) : a(naVar, z3);
    }

    private static boolean dl(na naVar, boolean z2) {
        return (!z2 || z == 1) && z(naVar) == 1 && a(naVar) > 0;
    }

    private static boolean a(na naVar, boolean z2) {
        return (!z2 || g == 1) && z(naVar) == 1 && a(naVar) > 0;
    }

    public static boolean z(na naVar, boolean z2) {
        return (!z2 || v == 1) && g(naVar) == 1 && a(naVar) > 0;
    }

    public static boolean g(na naVar, boolean z2) {
        return (!z2 || ls == 1) && dl(naVar) == 1 && a(naVar) > 0;
    }

    public static boolean g(boolean z2, na naVar, boolean z3) {
        return z(z2, naVar, z3) || z(naVar, z3) || g(naVar, z3);
    }

    public static String kb() {
        return uf;
    }

    public static int wp() {
        return sy;
    }

    public static int i() {
        return hh;
    }

    public static int v() {
        return l;
    }
}
