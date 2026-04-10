package com.bytedance.msdk.core.gz;

import android.text.TextUtils;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private Map<String, ConcurrentHashMap<String, com.bytedance.msdk.core.gz.z>> g;
    private Map<String, g> z;

    private dl() {
        this.g = new ConcurrentHashMap();
    }

    public static dl z() {
        return z.z;
    }

    private static class z {
        private static dl z = new dl();
    }

    public void z(ConcurrentHashMap<String, g> concurrentHashMap) {
        this.z = concurrentHashMap;
        if (concurrentHashMap != null) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_AdnShowControl", "mAdnControlMap = ".concat(String.valueOf(concurrentHashMap)));
        } else {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_AdnShowControl", "mAdnControlMap is null ");
        }
    }

    public void z(String str, String str2, String str3) {
        boolean z2;
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_AdnShowControl", "setAdnError adnName = " + str + " slotId = " + str2 + " error = " + str3);
        Map<String, g> map = this.z;
        g gVar = map != null ? map.get(str) : null;
        if (gVar != null) {
            for (String str4 : gVar.g()) {
                if (TextUtils.equals(str4, str3)) {
                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_AdnShowControl", "setAdnError 命中errorCode = ".concat(String.valueOf(str4)));
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        } else {
            z2 = false;
        }
        if (z2) {
            long time = new Date().getTime() + gVar.z();
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_AdnShowControl", "setAdnError 更新时间 = " + m.g(time));
            com.bytedance.msdk.core.gz.z zVar = new com.bytedance.msdk.core.gz.z(str, str2, time);
            if (this.g != null) {
                ConcurrentHashMap<String, com.bytedance.msdk.core.gz.z> concurrentHashMap = new ConcurrentHashMap<>();
                concurrentHashMap.put(str2, zVar);
                this.g.put(str, concurrentHashMap);
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_AdnShowControl", "setAdnError mAdnControlMap = " + this.g);
            }
        }
    }

    public com.bytedance.msdk.api.z z(String str, String str2) {
        com.bytedance.msdk.core.gz.z zVar;
        ConcurrentHashMap<String, com.bytedance.msdk.core.gz.z> concurrentHashMap;
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_AdnShowControl", "checkLoad adnName = " + str + " slotId = " + str2);
        Map<String, ConcurrentHashMap<String, com.bytedance.msdk.core.gz.z>> map = this.g;
        if (map == null || (concurrentHashMap = map.get(str)) == null) {
            zVar = null;
        } else {
            zVar = concurrentHashMap.get(str2);
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_AdnShowControl", "checkLoad 取出的showBean = ".concat(String.valueOf(zVar)));
        }
        if (zVar != null && zVar.z() != 0) {
            long time = new Date().getTime();
            if (time <= zVar.z()) {
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_AdnShowControl", "checkLoad 当前时间 = " + m.g(time));
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_AdnShowControl", "checkLoad 规则有效时间 = " + m.g(zVar.z()));
                return new com.bytedance.msdk.api.g.z(40044, com.bytedance.msdk.api.z.z(40044));
            }
        }
        return null;
    }
}
