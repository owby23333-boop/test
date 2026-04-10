package com.bytedance.msdk.core.a;

import android.text.TextUtils;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static Map<String, C0069z> z = new ConcurrentHashMap();

    public static void z(com.bytedance.msdk.api.z.g gVar, uy uyVar, Map<String, Object> map) {
        C0069z c0069z;
        if (gVar == null || uyVar == null || map == null || !uyVar.x() || !"baidu".equals(uyVar.pf()) || (c0069z = z.get(gVar.zw())) == null) {
            return;
        }
        map.put(MediationConstant.BIDDING_WIN_ADN, c0069z.z);
        map.put(MediationConstant.BIDDING_WIN_PRICE, Double.valueOf(c0069z.dl));
        Boolean boolValueOf = Boolean.valueOf(com.bytedance.msdk.core.g.g().yx());
        map.put(MediationConstant.BIDDING_IS_OPEN_ECPM, boolValueOf);
        if (boolValueOf.booleanValue()) {
            map.put(MediationConstant.BIDDING_REQUEST_ID_MAP, c0069z.f374a);
            map.put(MediationConstant.BIDDING_WIN_ADN_ID, c0069z.g);
        }
    }

    public static void z(com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.core.uy.g gVar2, List<com.bytedance.msdk.g.dl> list, List<com.bytedance.msdk.g.dl> list2) {
        HashMap map;
        com.bytedance.msdk.g.dl next;
        if (gVar == null || gVar2 == null || list == null || list.size() == 0 || !gVar.eo() || !z(gVar2)) {
            return;
        }
        Iterator<com.bytedance.msdk.g.dl> it = list.iterator();
        while (true) {
            map = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != null && "baidu".equals(next.zx())) {
                break;
            }
        }
        if (next == null) {
            next = list.get(0);
        }
        if (next != null) {
            if (com.bytedance.msdk.core.g.g().yx() && (list2 != null || list2.size() != 0)) {
                map = new HashMap();
                for (com.bytedance.msdk.g.dl dlVar : list2) {
                    map.put(dlVar.yz(), dlVar.mn());
                }
            }
            z.put(gVar2.un(), new C0069z(next.yz(), next.zx(), next.u(), map));
        }
    }

    private static boolean z(com.bytedance.msdk.core.uy.g gVar) {
        if (gVar == null) {
            return false;
        }
        for (uy uyVar : gVar.t()) {
            if (TextUtils.equals(uyVar.pf(), "baidu") && uyVar.x()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: com.bytedance.msdk.core.a.z$z, reason: collision with other inner class name */
    static class C0069z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Map<String, String> f374a;
        double dl;
        String g;
        String z;

        public C0069z(String str, String str2, double d, Map<String, String> map) {
            this.z = str2;
            this.dl = d;
            this.f374a = map;
            this.g = str;
        }
    }
}
