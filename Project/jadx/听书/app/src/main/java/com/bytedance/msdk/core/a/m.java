package com.bytedance.msdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.core.a.a;
import com.bytedance.msdk.core.i.z;
import com.bytedance.msdk.core.uy.e;
import com.bytedance.msdk.core.uy.gz;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.gz.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m implements a {
    @Override // com.bytedance.msdk.core.a.a
    public void z(Map<String, com.bytedance.msdk.dl.z.z> map, Context context, final dl dlVar, final a.z zVar) {
        if (dlVar == null || dlVar.z == null || dlVar.f370a == null || h.z(dlVar.g)) {
            zVar.z(null);
            return;
        }
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(dlVar.z.zw()) + "开启server bidding网络请求......：");
        com.bytedance.msdk.gc.m.z(dlVar.z, (JSONObject) null);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final int[] iArr = {4};
        com.bytedance.msdk.core.i.z.z().z(map, context, dlVar.z, dlVar.g, dlVar.dl, dlVar.f370a, dlVar.gc, dlVar.m, new z.InterfaceC0074z() { // from class: com.bytedance.msdk.core.a.m.1
            @Override // com.bytedance.msdk.core.i.z.InterfaceC0074z
            public void z(e eVar) {
                m.this.z(jCurrentTimeMillis, dlVar.z, dlVar.f370a, iArr[0], eVar, zVar);
            }

            @Override // com.bytedance.msdk.core.i.z.InterfaceC0074z
            public void z(com.bytedance.msdk.api.z zVar2) {
                m.this.z(jCurrentTimeMillis, iArr[0], zVar2, dlVar.z, zVar);
            }
        });
    }

    public void z(String str, final long j, final com.bytedance.msdk.api.z.g gVar, final com.bytedance.msdk.core.uy.g gVar2, final a.z zVar) {
        com.bytedance.msdk.core.i.z.z().z(str, new z.InterfaceC0074z() { // from class: com.bytedance.msdk.core.a.m.2
            @Override // com.bytedance.msdk.core.i.z.InterfaceC0074z
            public void z(e eVar) {
                m.this.z(j, gVar, gVar2, 4, eVar, zVar);
            }

            @Override // com.bytedance.msdk.core.i.z.InterfaceC0074z
            public void z(com.bytedance.msdk.api.z zVar2) {
                m.this.z(j, 4, zVar2, gVar, zVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(long j, com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.core.uy.g gVar2, int i, e eVar, a.z zVar) {
        int i2;
        g gVar3;
        int i3;
        uy uyVarM;
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(gVar.zw()) + "server bidding网络请求响返回.............");
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        if (gVar2 != null && eVar != null && !h.z(eVar.a())) {
            List<gz> listA = eVar.a();
            gVar3 = new g();
            gVar3.wp = eVar.z();
            gVar3.i = eVar.g();
            gVar3.v = eVar.dl();
            gVar3.kb = eVar.e();
            gVar3.fo = listA.size();
            gVar3.z = eVar.fo();
            gVar3.uy = gVar2.e();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder("winners : {");
            for (gz gzVar : listA) {
                if (gzVar != null && (uyVarM = gVar2.m(gzVar.e())) != null) {
                    uy uyVarGc = uyVarM.gc();
                    sb.append(" [ AdnName:" + uyVarGc.pf() + ",slotId:" + uyVarGc.fv() + ",loadSort:" + uyVarGc.io() + ",showSort:" + uyVarGc.uf() + "] ");
                    uyVarGc.z(gzVar);
                    arrayList.add(uyVarGc);
                }
            }
            sb.append("}");
            if (h.z(arrayList)) {
                i2 = h.z(eVar.fo()) ? i : 2;
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(gVar.zw()) + "server bidding网络请求响应失败......：数据有返回，但没有返回winner数据......");
            } else {
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(gVar.zw()) + "server bidding网络请求响应成功......：" + sb.toString());
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.addAll(arrayList);
                List<uy> listZ = z(eVar.fo(), gVar2, gVar3);
                if (listZ != null && listZ.size() > 0) {
                    com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(gVar.zw()) + "server bidding网络请求响应成功......waterfall+server bidding物料......");
                    copyOnWriteArrayList.addAll(listZ);
                    i3 = 1;
                } else {
                    com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(gVar.zw()) + "server bidding网络请求响应成功......server bidding物料......");
                    i3 = 3;
                }
                gVar3.g = copyOnWriteArrayList;
                i2 = i3;
            }
        } else {
            i2 = (eVar == null || h.z(eVar.fo())) ? i : 2;
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(gVar.zw()) + "server bidding网络请求响应失败......没有返回serverBiddingModel相关数据");
            gVar3 = null;
        }
        if (eVar != null) {
            String strM = eVar.m();
            if (!TextUtils.isEmpty(strM)) {
                if (gVar3 == null) {
                    gVar3 = new g();
                }
                gVar3.f371a = strM;
            }
            if (eVar.gz()) {
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(gVar.zw()) + "server bidding发现config过期了，需要重新拉取配置......：");
                if (gVar3 == null) {
                    gVar3 = new g();
                }
                gVar3.dl = true;
            }
            if (!h.z(eVar.gc())) {
                if (gVar3 == null) {
                    gVar3 = new g();
                }
                gVar3.gc = eVar.gc();
            }
        }
        if (gVar3 == null) {
            gVar3 = new g();
        }
        gVar3.m = i2;
        gVar3.e = jCurrentTimeMillis;
        if (zVar != null) {
            zVar.z(gVar3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(long j, int i, com.bytedance.msdk.api.z zVar, com.bytedance.msdk.api.z.g gVar, a.z zVar2) {
        int i2 = (zVar == null || zVar.z != -1) ? 5 : 4;
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(gVar.zw()) + "server bidding网络请求响应失败......onFail  result:" + i2);
        g gVar2 = new g();
        gVar2.m = i2;
        gVar2.e = System.currentTimeMillis() - j;
        gVar2.gz = zVar;
        if (zVar2 != null) {
            zVar2.z(gVar2);
        }
    }

    private List<uy> z(List<uy> list, com.bytedance.msdk.core.uy.g gVar, g gVar2) {
        List<uy> listT;
        if (list == null || list.size() == 0 || gVar == null) {
            return null;
        }
        boolean zBooleanValue = gVar.m().get("serverBidding_timeout") instanceof Boolean ? ((Boolean) gVar.m().get("serverBidding_timeout")).booleanValue() : false;
        if (gVar.e() == 4 && !zBooleanValue) {
            com.bytedance.msdk.core.uy.g gVarZ = com.bytedance.msdk.e.z.dl.z().z(gVar.un(), gVar.ti(), 102);
            if (gVarZ == null) {
                return null;
            }
            listT = com.bytedance.msdk.core.fo.dl.z(gVarZ, gVarZ.un(), gVar2 == null ? 0.0d : gVar2.wp, gVar2 != null ? gVar2.v : 0.0d);
            gVar.m().putAll(gVarZ.m());
        } else {
            listT = gVar.t();
        }
        if (listT != null && listT.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (uy uyVar : listT) {
                Iterator<uy> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        uy next = it.next();
                        if (uyVar != null && next != null && uyVar.js() == 0 && !TextUtils.isEmpty(uyVar.fv()) && uyVar.fv().equals(next.fv())) {
                            arrayList.add(uyVar);
                            break;
                        }
                    }
                }
            }
            return arrayList;
        }
        return null;
    }
}
