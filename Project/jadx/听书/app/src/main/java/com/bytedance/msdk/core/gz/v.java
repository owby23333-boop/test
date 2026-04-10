package com.bytedance.msdk.core.gz;

import android.text.TextUtils;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class v {
    private static volatile v z;
    private Map<String, ConcurrentHashMap<String, z>> dl = new ConcurrentHashMap();
    private Map<String, List<g>> g;

    private v() {
    }

    public static v z() {
        if (z == null) {
            synchronized (v.class) {
                if (z == null) {
                    z = new v();
                }
            }
        }
        return z;
    }

    public void z(ConcurrentHashMap<String, List<g>> concurrentHashMap) {
        this.g = concurrentHashMap;
        if (concurrentHashMap != null) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_RitAdnShowControl", "mRitAdnControlConfigMap = " + this.g);
        } else {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_RitAdnShowControl", "mRitAdnControlConfigMap is null ");
        }
    }

    public void z(String str, String str2, String str3, String str4) {
        List<g> list;
        g next;
        boolean z2;
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_RitAdnShowControl", "setRitAdnError rit_level adnName = " + str2 + " slotId = " + str3 + " error = " + str4);
        Map<String, List<g>> map = this.g;
        if (map == null || (list = map.get(str2)) == null || list.size() == 0) {
            return;
        }
        Iterator<g> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                next = it.next();
                if (next.dl().contains(str)) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        if (next != null) {
            for (String str5 : next.g()) {
                if (TextUtils.equals(str5, str4)) {
                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_RitAdnShowControl", "setAdnError rit_level 命中errorCode = ".concat(String.valueOf(str5)));
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        } else {
            z2 = false;
        }
        if (z2) {
            long time = new Date().getTime() + next.z();
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_RitAdnShowControl", "setRitAdnError rit_level 更新时间 = " + m.g(time));
            z zVar = new z(str2, str3, time, str4);
            Map<String, ConcurrentHashMap<String, z>> map2 = this.dl;
            if (map2 != null) {
                ConcurrentHashMap<String, z> concurrentHashMap = map2.get(str2);
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                }
                concurrentHashMap.put(str + "_" + str3, zVar);
                this.dl.put(str2, concurrentHashMap);
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_RitAdnShowControl", "setRitAdnError rit_level mAdnControlMap = " + this.dl);
            }
        }
    }

    public com.bytedance.msdk.api.z z(String str, String str2, String str3) {
        z zVar;
        ConcurrentHashMap<String, z> concurrentHashMap;
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_RitAdnShowControl", "checkLoad rit_level adnName = " + str2 + " slotId = " + str3 + " primeRit = " + str);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            Map<String, ConcurrentHashMap<String, z>> map = this.dl;
            if (map == null || (concurrentHashMap = map.get(str2)) == null) {
                zVar = null;
            } else {
                zVar = concurrentHashMap.get(str + "_" + str3);
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_RitAdnShowControl", "checkLoad rit_level 取出的showBean = ".concat(String.valueOf(zVar)));
            }
            if (zVar != null && zVar.z() != 0) {
                long time = new Date().getTime();
                if (time <= zVar.z()) {
                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_RitAdnShowControl", "checkLoad rit_level 当前时间 = " + m.g(time));
                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_RitAdnShowControl", "checkLoad rit_level 规则有效时间 = " + m.g(zVar.z()));
                    return new com.bytedance.msdk.api.g.z(40064, com.bytedance.msdk.api.z.z(40064) + ", " + zVar.g());
                }
            }
        }
        return null;
    }

    public boolean z(String str, String str2) {
        Map<String, List<g>> map;
        List<g> list;
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_RitAdnShowControl", "hasRitAdnConfig rit_level adnName = " + str2 + " primeRit = " + str);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && (map = this.g) != null && map.size() != 0 && (list = this.g.get(str2)) != null && list.size() != 0) {
            Iterator<g> it = list.iterator();
            while (it.hasNext()) {
                List<String> listDl = it.next().dl();
                if (listDl != null && listDl.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
