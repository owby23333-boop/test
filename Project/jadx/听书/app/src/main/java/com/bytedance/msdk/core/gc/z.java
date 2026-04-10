package com.bytedance.msdk.core.gc;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.api.z.g;
import com.bytedance.msdk.core.gc.g.e;
import com.bytedance.msdk.z.gc.dl;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private final Map<String, Integer> z = new HashMap();
    private final Map<String, Integer> g = new HashMap();

    public void z(String str, String str2, int i) {
        this.z.put(str + "_" + str2, Integer.valueOf(i));
    }

    public int z(String str, String str2) {
        Integer num = this.z.get(str + "_" + str2);
        if (num != null) {
            return num.intValue();
        }
        return 1800000;
    }

    public void g(String str, String str2, int i) {
        this.g.put(str + "_" + str2, Integer.valueOf(i));
    }

    public int g(String str, String str2) {
        Integer num = this.g.get(str + "_" + str2);
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    protected int z(e eVar, g gVar, g gVar2, String str) {
        if (eVar == null || eVar.z == null) {
            return 4;
        }
        String strZw = gVar2 != null ? gVar2.zw() : "";
        String strZx = eVar.z.zx();
        String strYz = eVar.z.yz();
        Integer numM = eVar.z.m();
        if (numM.intValue() == 1) {
            if (eVar.z.jq()) {
                dl.z("TTMediationSDK", "--==-- " + str + ":广告已show过 ---: " + strZx + ", adSlotId: " + strYz);
                return 7;
            }
            if (z(strZw, eVar.z)) {
                dl.z("TTMediationSDK", "--==-- " + str + ":广告过期了(M配置) ---: " + strZx + ", adSlotId: " + strYz);
                return 2;
            }
            if (!z(gVar, gVar2, eVar.z)) {
                dl.z("TTMediationSDK", "--==-- " + str + ":AdSlot不符合 ---: " + strZx + ", adSlotId: " + strYz);
                return 6;
            }
            dl.z("TTMediationSDK", "--==-- " + str + ":复用成功：---" + strZx + ", adSlotId: " + strYz);
            return -1;
        }
        if (eVar.z.jq()) {
            dl.z("TTMediationSDK", "--==-- " + str + ":广告已show过 ---: " + strZx + ", adSlotId: " + strYz);
            return 7;
        }
        if (numM.intValue() == 3) {
            dl.z("TTMediationSDK", "--==-- " + str + ":广告过期了(adn api) ---: " + strZx + ", adSlotId: " + strYz);
            return 1;
        }
        if (numM.intValue() == 4) {
            dl.z("TTMediationSDK", "--==-- " + str + ":isReady是false ---: " + strZx + ", adSlotId: " + strYz);
            return 5;
        }
        if (!z(gVar, gVar2, eVar.z)) {
            dl.z("TTMediationSDK", "--==-- " + str + ":AdSlot不符合 ---: " + strZx + ", adSlotId: " + strYz);
            return 6;
        }
        dl.z("TTMediationSDK", "--==-- " + str + ":复用成功：---" + strZx + ", adSlotId: " + strYz);
        return -1;
    }

    public final boolean z(String str, com.bytedance.msdk.g.dl dlVar) {
        if (dlVar == null || dlVar.gc()) {
            dl.z("TTMediationSDK", "--==-- 广告已经destroy了，视为过期 ------");
            return true;
        }
        boolean z = SystemClock.elapsedRealtime() > dlVar.f() + ((long) z(str, dlVar.yz()));
        dl.z("TTMediationSDK", "--==-- 使用了配置的过期时间进行判断 ------");
        return z;
    }

    public static boolean z(g gVar, g gVar2, com.bytedance.msdk.g.dl dlVar) {
        if (gVar == null || gVar2 == null) {
            dl.z("TMe", "--==-- adSlot = null, a1: " + gVar + ", a2: " + gVar2);
            return false;
        }
        if (gVar.mc() != gVar2.mc()) {
            dl.z("TMe", "--==-- orientation, a1: " + gVar.mc() + ", a2: " + gVar2.mc());
            return false;
        }
        if (gVar.un() != gVar2.un()) {
            dl.z("TMe", "--==-- isMuted, a1: " + gVar.un() + ", a2: " + gVar2.un());
            return false;
        }
        if (gVar.uf() != gVar2.uf()) {
            dl.z("TMe", "--==-- ImgWidth, a1: " + gVar.uf() + ", a2: " + gVar2.uf());
            return false;
        }
        if (gVar.sy() != gVar2.sy()) {
            dl.z("TMe", "--==-- ImgHeight, a1: " + gVar.sy() + ", a2: " + gVar2.sy());
            return false;
        }
        if (gVar.h() != null && gVar2.h() != null) {
            if (!gVar.h().equals(gVar2.h())) {
                dl.z("TMe", "--==-- rewardName, a1: " + gVar.h() + ", a2: " + gVar2.h());
                return false;
            }
        } else if (gVar.h() != null || gVar2.h() != null) {
            dl.z("TMe", "--==-- rewardName=null, a1: " + gVar.h() + ", a2: " + gVar2.h());
            return false;
        }
        if (gVar.gk() != gVar2.gk()) {
            dl.z("TMe", "--==-- rewardAmount, a1: " + gVar.gk() + ", a2: " + gVar2.gk());
            return false;
        }
        if (gVar.lq() != null && gVar2.lq() != null) {
            if (!gVar.lq().equals(gVar2.lq())) {
                dl.z("TMe", "--==-- reward, userId, a1: " + gVar.lq() + ", a2: " + gVar2.lq());
                return false;
            }
        } else if (gVar.lq() != null || gVar2.lq() != null) {
            dl.z("TMe", "--==-- reward, userId=null, a1: " + gVar.lq() + ", a2: " + gVar2.lq());
            return false;
        }
        if (gVar.oq() != null && gVar2.oq() != null) {
            if (z(gVar.oq(), gVar2.oq())) {
                return true;
            }
            dl.z("TMe", "--==-- customData, a1: " + gVar.oq().toString() + ", a2: " + gVar2.oq().toString());
            return false;
        }
        if (gVar.oq() == null && gVar2.oq() == null) {
            return true;
        }
        dl.z("TMe", "--==-- customData=null, a1: " + gVar.oq() + ", a2: " + gVar2.oq());
        return false;
    }

    public static boolean z(Map<String, Object> map, Map<String, Object> map2) {
        if (map == null && map2 == null) {
            return true;
        }
        if (map == null || map2 == null || map.size() != map2.size()) {
            return false;
        }
        Set<String> setKeySet = map.keySet();
        if (setKeySet != null) {
            for (String str : setKeySet) {
                if (str != null) {
                    Object obj = map.get(str);
                    String str2 = obj instanceof String ? (String) obj : null;
                    Object obj2 = map2.get(str);
                    String str3 = obj2 instanceof String ? (String) obj2 : null;
                    if (str2 != null || str3 != null) {
                        if (!TextUtils.equals(str2, str3)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
