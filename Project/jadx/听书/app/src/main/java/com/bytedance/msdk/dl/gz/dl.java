package com.bytedance.msdk.dl.gz;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.core.uy.fo;
import com.bytedance.msdk.gz.gk;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static com.bytedance.msdk.dl.z.z z(com.bytedance.msdk.dl.m.g.g gVar, com.bytedance.msdk.api.z.g gVar2, com.bytedance.msdk.dl.z.g gVar3) {
        com.bytedance.msdk.core.uy.z zVarZ;
        com.bytedance.msdk.api.a.z.g.dl.z zVarZ2;
        if (gVar == null || gVar2 == null) {
            return null;
        }
        gVar.z(z(gVar2, gVar));
        gVar.g(gVar2.zw());
        if (!gVar.uy()) {
            if (gVar.kb()) {
                return com.bytedance.msdk.dl.dl.g.z.a.z(gVar, gVar3);
            }
            if (com.bytedance.msdk.core.e.dl.z(gVar.gz())) {
                return new com.bytedance.msdk.dl.dl.g.z.dl(gVar3);
            }
            return null;
        }
        com.bytedance.msdk.m.g.z(com.bytedance.msdk.core.g.getContext(), gVar != null ? gVar.i() : "");
        if (com.bytedance.msdk.m.g.z.z(gVar.i()) == null || (zVarZ = com.bytedance.msdk.e.z.g.z().z(gVar.i())) == null || zVarZ.a() == null || (zVarZ2 = zVarZ.a().z(gVar.sy(), gVar.pf())) == null || !z(zVarZ2)) {
            return null;
        }
        return com.bytedance.msdk.dl.dl.g.z.a.z(zVarZ2.z(), gVar, gVar3);
    }

    public static String z(com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.dl.m.g.g gVar2) {
        if (gVar == null || gVar2 == null) {
            return null;
        }
        String strZ = TextUtils.isEmpty(gVar.z()) ? null : gVar.z();
        if (TextUtils.isEmpty(gVar2.wp())) {
            return strZ;
        }
        return (strZ + "_") + gVar2.wp();
    }

    public static boolean z(com.bytedance.msdk.api.a.z.g.dl.z zVar) {
        if (zVar == null) {
            return false;
        }
        Function<SparseArray<Object>, Object> functionE = com.bytedance.msdk.core.kb.z.z().e();
        if (functionE != null) {
            if (!TextUtils.isEmpty(zVar.z())) {
                com.bykv.z.z.z.z.z zVarZ = com.bykv.z.z.z.z.z.z();
                zVarZ.z(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, zVar.z());
                com.bytedance.msdk.z.gc.dl.g("TMe", "custom className is " + zVar.z());
                zVarZ.z(-99999987, 8229);
                zVarZ.z(-99999985, Boolean.class);
                return ((Boolean) functionE.apply(zVarZ.g().sparseArray())).booleanValue();
            }
            com.bytedance.msdk.z.gc.dl.g("TMe", "custom className is empty");
        } else {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "load ad check custom name class loader is null ");
        }
        return false;
    }

    public static Map<String, Object> z(com.bytedance.msdk.dl.m.g.g gVar, com.bytedance.msdk.api.z.g gVar2, Map<String, Object> map) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (gVar != null && gVar2 != null) {
            com.bytedance.msdk.core.uy.z zVarZ = com.bytedance.msdk.core.g.g().z(gVar.i());
            if (zVarZ != null) {
                concurrentHashMap.put("tt_ad_network_config_appid", zVarZ.g());
                concurrentHashMap.put("tt_ad_network_config_appKey", zVarZ.dl());
            }
            concurrentHashMap.put("tt_ad_origin_type", Integer.valueOf(gVar.v()));
            concurrentHashMap.put("tt_ad_sub_type", Integer.valueOf(gVar.pf()));
            if (gVar2 != null) {
                Map<String, Object> mapOq = gVar2.oq();
                if (mapOq != null && mapOq.size() > 0) {
                    for (Map.Entry<String, Object> entry : mapOq.entrySet()) {
                        if (entry.getKey() != null && entry.getValue() != null) {
                            concurrentHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                int iUf = gVar2.uf();
                int iSy = gVar2.sy();
                if (iUf < 0) {
                    iUf = 0;
                }
                if (iSy < 0) {
                    iSy = 0;
                }
                concurrentHashMap.put("ad_height", Integer.valueOf(iSy));
                concurrentHashMap.put("ad_width", Integer.valueOf(iUf));
                concurrentHashMap.put("ad_type", Integer.valueOf(gVar2.iq()));
            }
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                    if (entry2.getKey() != null && entry2.getValue() != null) {
                        concurrentHashMap.put(entry2.getKey(), entry2.getValue());
                    }
                }
            }
        }
        return concurrentHashMap;
    }

    public static void z(com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.dl.m.g.g gVar2, fo foVar, String str) {
        if (dlVar == null || gVar2 == null || gVar == null) {
            return;
        }
        if ((gVar2.js() == 0 || gVar2.js() == 100) && gVar2.l() != 0.0d) {
            dlVar.z(gVar2.l());
        }
        if (gVar2.zw()) {
            dlVar.g(gVar2.h());
            dlVar.dl(gVar2.gk());
            if (gVar2.x() != null) {
                dlVar.gc(gVar2.x().dl());
                dlVar.m(gVar2.x().a());
                dlVar.dl(gVar2.x().gz());
                dlVar.a(gVar2.x().fo());
                dlVar.a(gVar2.x().z());
            }
        }
        dlVar.pf(gVar2.js());
        dlVar.p(gVar2.tb());
        dlVar.ls(gVar2.q());
        if (str == null) {
            str = "";
        }
        dlVar.fv(str);
        dlVar.ls(gVar2.i());
        dlVar.p(gVar2.gz() != null ? gVar2.gz().ls() : "");
        dlVar.pf(gVar2.lq());
        dlVar.z(SystemClock.elapsedRealtime());
        dlVar.tb(gVar2.wp());
        dlVar.js(gVar2.g());
        dlVar.i(com.bytedance.msdk.g.z.g(gVar2.i()));
        dlVar.e(gVar2.e());
        dlVar.gz(gVar2.m());
        dlVar.e(gVar.z());
        dlVar.fo(gVar2.e());
        dlVar.uy(gVar2.m());
        dlVar.m(gVar2.v());
        dlVar.gc(gVar2.pf());
        dlVar.v(gVar.iq());
        dlVar.dl(gVar2.mc());
        dlVar.z(gVar2.hh());
        gk.z(dlVar, gVar2.gz(), gVar, false);
        if (foVar != null) {
            dlVar.g("if_test", Integer.valueOf(foVar.g == 1 ? foVar.g : 0));
            dlVar.g("server_bidding_extra", foVar.z);
            int iGz = dlVar.gz(gVar != null ? gVar.z() : null);
            if (iGz == 1 || iGz == 2) {
                dlVar.dl(foVar.gc);
            }
        }
        if (gVar2.x() == null || gVar2.x() == null) {
            return;
        }
        dlVar.z("extra_data_and_no_parse", gVar2.x().g());
    }
}
