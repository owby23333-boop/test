package com.bytedance.msdk.dl.dl.g.z;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.api.a.fo;
import com.bytedance.msdk.m.g.gc;
import com.uc.crashsdk.export.LogType;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.msdk.api.z.g f434a;
    private com.bytedance.msdk.dl.m.g.g dl;
    private z g;

    public dl(com.bytedance.msdk.dl.z.g gVar) {
        super(gVar);
    }

    @Override // com.bytedance.msdk.dl.dl.g.z.g
    public void g(Context context, com.bytedance.msdk.dl.m.g.g gVar, com.bytedance.msdk.api.z.g gVar2, Map<String, Object> map) {
        this.dl = gVar;
        this.f434a = gVar2;
        com.bytedance.sdk.openadsdk.ls.a aVarZ = z(gVar, gVar2, map);
        if (aVarZ != null) {
            this.g = new z(gVar2, gVar, this);
            aVarZ.z(8429, gVar.ls());
            aVarZ.z(8430, gVar.p());
            aVarZ.z(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, this.g);
            aVarZ.z(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, gVar.fv());
            aVarZ.z(8561, Integer.valueOf(gVar.eo()));
            com.bytedance.msdk.m.g.z.g(gVar.i());
            z(context, aVarZ);
        }
    }

    @Override // com.bytedance.msdk.dl.dl.g.z.g, com.bytedance.msdk.dl.z.z
    public String z(Context context, com.bytedance.msdk.dl.m.g.g gVar, com.bytedance.msdk.api.z.g gVar2) {
        if (gVar != null && gVar2 != null) {
            HashMap map = new HashMap();
            map.put("bidding_token", "true");
            if (this.g == null) {
                this.g = new z(gVar2, gVar, this);
                com.bytedance.sdk.openadsdk.ls.a aVarZ = com.bytedance.sdk.openadsdk.ls.a.z();
                aVarZ.z(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, this.g);
                aVarZ.z(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, gVar.fv());
                com.bytedance.sdk.openadsdk.ls.a aVarZ2 = com.bytedance.sdk.openadsdk.ls.a.z();
                aVarZ2.z(8449, map);
                com.bytedance.sdk.openadsdk.ls.a aVarZ3 = com.bytedance.sdk.openadsdk.ls.a.z();
                aVarZ3.z(8443, aVarZ2.g());
                aVarZ.z(8090, com.bytedance.sdk.openadsdk.ls.a.z(gVar2.wj()).z(8089, aVarZ3.g()).g());
                Function<SparseArray<Object>, Object> functionE = com.bytedance.msdk.core.kb.z.z().e();
                if (functionE != null) {
                    com.bytedance.sdk.openadsdk.ls.a aVarZ4 = com.bytedance.sdk.openadsdk.ls.a.z();
                    aVarZ4.z(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.bytedance.msdk.z.gc.z.z(context)).z(8106).z(Void.class);
                    gc.z(aVarZ4, aVarZ);
                    functionE.apply(aVarZ4.g());
                } else {
                    com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "load ad class loader is null ");
                }
            }
            if (this.g != null && gVar2.q() != null) {
                com.bytedance.sdk.openadsdk.mediation.g.g.g gVarL = gVar2.q().l();
                return this.g.z(context, gVar.wp(), com.bytedance.msdk.core.ls.z.z(gVarL != null ? gVarL.m() : null));
            }
        }
        return null;
    }

    private void z(Context context, com.bytedance.sdk.openadsdk.ls.a aVar) {
        com.bytedance.msdk.dl.m.g.g gVar = this.dl;
        Function<SparseArray<Object>, Object> functionZ = (gVar == null || this.f434a == null) ? null : com.bytedance.msdk.core.z.z.gc.z(gVar.i(), this.f434a.iq(), this.dl.pf());
        if (functionZ != null) {
            functionZ.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8241).z(Void.class).z(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.bytedance.msdk.z.gc.z.z(context)).z(8424, aVar.g()).g());
        } else {
            g(context, aVar);
        }
    }

    private void g(Context context, com.bytedance.sdk.openadsdk.ls.a aVar) {
        Function<SparseArray<Object>, Object> functionE = com.bytedance.msdk.core.kb.z.z().e();
        if (functionE != null) {
            if (com.bytedance.sdk.gromore.init.z.z() >= 5900) {
                com.bytedance.sdk.openadsdk.ls.a aVarZ = com.bytedance.sdk.openadsdk.ls.a.z().z(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.bytedance.msdk.z.gc.z.z(context)).z(8106).z(Void.class);
                gc.z(aVarZ, aVar);
                functionE.apply(aVarZ.g());
                return;
            } else {
                aVar.z(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.bytedance.msdk.z.gc.z.z(context)).z(8106).z(Void.class);
                functionE.apply(aVar.g());
                return;
            }
        }
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "load ad class loader is null ");
    }

    private com.bytedance.sdk.openadsdk.ls.a z(com.bytedance.msdk.dl.m.g.g gVar, com.bytedance.msdk.api.z.g gVar2, Map<String, Object> map) {
        HashMap map2 = null;
        if (gVar == null || gVar2 == null || gVar2.q() == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.ls.a aVarZ = com.bytedance.sdk.openadsdk.ls.a.z();
        com.bytedance.sdk.openadsdk.mediation.g.g.z zVarQ = gVar2.q();
        com.bytedance.sdk.openadsdk.mediation.g.g.g gVarL = zVarQ.l();
        com.bytedance.sdk.openadsdk.ls.a aVarZ2 = com.bytedance.sdk.openadsdk.ls.a.z(gVar2.wj()).z(15, zVarQ.v()).z(13, Integer.valueOf(gVar2.hh())).z(7, Integer.valueOf(zVarQ.m())).z(8, Integer.valueOf(zVarQ.e())).z(16, Integer.valueOf(zVarQ.pf())).z(20, Integer.valueOf(zVarQ.fv())).z(11, Boolean.valueOf(zVarQ.uy())).z(17, Integer.valueOf(gVar2.p()));
        com.bytedance.sdk.openadsdk.ls.a aVarZ3 = com.bytedance.sdk.openadsdk.ls.a.z();
        HashMap map3 = new HashMap();
        if (gVarL != null) {
            if (gVarL.m() != null) {
                map3.putAll(gVarL.m());
            }
            if (gVar.gz() != null) {
                map3.put("waterfall_config", gVar.gz());
            }
            map3.put("dynamic_adapter_type", Integer.valueOf(com.bytedance.msdk.e.z.z.z().a()));
            map3.put("wf_dynamic_adapter_type", Integer.valueOf(com.bytedance.msdk.e.z.z.z().gc()));
            com.bytedance.msdk.core.a.z.z(gVar2, gVar.gz(), map3);
            aVarZ3.z(8444, Boolean.valueOf(gVarL.dl())).z(8445, Boolean.valueOf(gVarL.z())).z(8446, Boolean.valueOf(gVarL.g())).z(8447, Float.valueOf(gVarL.a())).z(LogType.UNEXP_EXIT, Boolean.valueOf(gVarL.gc())).z(8450, Boolean.valueOf(gVarL.e())).z(8451, gVarL.gz()).z(8454, Boolean.valueOf(gVarL.fo())).z(8455, Float.valueOf(gVarL.kb())).z(8456, Float.valueOf(gVarL.wp()));
        } else {
            map3.put("dynamic_adapter_type", Integer.valueOf(com.bytedance.msdk.e.z.z.z().a()));
            map3.put("wf_dynamic_adapter_type", Integer.valueOf(com.bytedance.msdk.e.z.z.z().gc()));
        }
        fo foVarG = com.bytedance.msdk.core.z.kb().zw().g();
        if (foVarG != null) {
            map3.put(d.D, Double.valueOf(foVarG.g()));
            map3.put(d.C, Double.valueOf(foVarG.z()));
            map3.put("loc_time", Long.valueOf(System.currentTimeMillis() / 1000));
        } else {
            map3.put(d.D, -1);
            map3.put(d.C, -1);
            map3.put("loc_time", -1);
        }
        map3.put("load_type", com.bytedance.msdk.core.z.z.gc.z());
        map3.put("load_can_log", Boolean.valueOf(com.bytedance.msdk.e.z.z.z().fo()));
        aVarZ3.z(8449, map3);
        aVarZ3.z(8044, map3);
        z(aVarZ3, zVarQ, gVarL);
        aVarZ2.z(8443, aVarZ3.g());
        aVarZ.z(8090, com.bytedance.sdk.openadsdk.ls.dl.a.z(com.bytedance.sdk.openadsdk.ls.a.z(gVar2.wj()).z(8089, aVarZ2.g()).g()));
        aVarZ.z(AVMDLDataLoader.KeyIsLiveCacheThresholdP2pToHttp, gVar.wp());
        aVarZ.z(4, gVar2.zw());
        aVarZ.z(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec, gVar.i());
        aVarZ.z(17, Integer.valueOf(gVar2.p()));
        if (gVar2.oq() != null) {
            HashMap map4 = new HashMap();
            for (Map.Entry<String, Object> entry : gVar2.oq().entrySet()) {
                Object value = entry.getValue();
                map4.put(entry.getKey(), value == null ? null : value.toString());
            }
            map2 = map4;
        }
        if (map2 != null) {
            aVarZ.z(8013, map2);
        }
        if (map != null) {
            aVarZ.z(8096, Integer.valueOf(map.get("ad_load_timeout") != null ? ((Integer) map.get("ad_load_timeout")).intValue() : 3000));
        }
        Object obj = map.get("contentUrl");
        if (obj instanceof String) {
            aVarZ.z(8083, (String) obj);
        }
        Object obj2 = map.get("testDevices");
        if (obj2 instanceof String) {
            aVarZ.z(8084, (String) obj2);
        }
        Object obj3 = map.get("tt_ad_origin_type");
        if (obj3 != null) {
            int iIntValue = ((Integer) obj3).intValue();
            if (iIntValue == 1 || iIntValue == 3) {
                aVarZ.z(8033, Boolean.TRUE);
            }
            aVarZ.z(8085, Integer.valueOf(iIntValue));
        }
        Object obj4 = map.get("tt_ad_sub_type");
        if (obj4 != null) {
            aVarZ.z(8094, Integer.valueOf(((Integer) obj4).intValue()));
        }
        Object obj5 = map.get("render_control");
        if (obj5 instanceof Integer) {
            aVarZ.z(8553, Integer.valueOf(((Integer) obj5).intValue()));
        }
        return aVarZ;
    }

    private void z(com.bytedance.sdk.openadsdk.ls.a aVar, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar, com.bytedance.sdk.openadsdk.mediation.g.g.g gVar) {
        if (aVar == null || zVar == null) {
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.v()) && gVar.pf() != 0) {
            aVar.z(8452, gVar.v());
            aVar.z(8453, Integer.valueOf(gVar.pf()));
        } else {
            if (TextUtils.isEmpty(zVar.io()) || zVar.uf() == 0) {
                return;
            }
            aVar.z(8452, zVar.io());
            aVar.z(8453, Integer.valueOf(zVar.uf()));
        }
    }

    @Override // com.bytedance.msdk.dl.z.z
    public String z(String str) {
        com.bytedance.msdk.z.z.a aVarZ = com.bytedance.msdk.m.g.g.z().z(str);
        if (aVarZ != null) {
            return aVarZ.g();
        }
        return null;
    }
}
