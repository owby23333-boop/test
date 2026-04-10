package com.bytedance.msdk.dl.gz;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static void z(Context context, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar, com.bytedance.sdk.openadsdk.tb.z.g.z.m mVar, boolean z) {
        com.bytedance.sdk.openadsdk.mediation.g.g.g gVarL;
        if (zVar != null && (gVarL = zVar.l()) != null && gVarL.uy() == null) {
            com.bytedance.msdk.z.gc.dl.a("TMe", "使用聚合信息流广告自渲染模版混用场景时，需设置MediationNativeToBannerListener监听回调否则会影响相关功能使用，具体可以参考接入文档，若不能及时设置，建议修改瀑布流配置为模版信息流广告暂不进行混用。");
        }
        new com.bytedance.sdk.gromore.z.z.e.a.gc(context, zVar, mVar, z).z();
    }

    public static void z(Context context, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar, com.bytedance.sdk.openadsdk.tb.z.g.z.dl dlVar, boolean z) {
        new com.bytedance.sdk.gromore.z.z.e.a.m(context, zVar, dlVar, z).z();
    }

    public static void z(Context context, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar, com.bytedance.sdk.openadsdk.tb.z.g.z.g gVar) {
        new com.bytedance.sdk.gromore.z.z.e.g.dl(context, zVar, gVar).z();
    }

    public static void z(Context context, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar, com.bytedance.sdk.openadsdk.tb.z.g.z.e eVar) {
        new com.bytedance.sdk.gromore.z.z.e.gc.dl(context, zVar, eVar).z();
    }

    public static void z(Context context, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar, com.bytedance.sdk.gromore.z.z.z.z zVar2, boolean z) {
        new com.bytedance.sdk.gromore.z.z.e.z.dl(context, zVar, zVar2, z).z();
    }

    public static void z(Context context, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar, com.bytedance.sdk.gromore.z.z zVar2, com.bytedance.sdk.openadsdk.tb.z.g.z.z zVar3, boolean z) {
        com.bytedance.sdk.gromore.z.z.e.m.dl dlVar = new com.bytedance.sdk.gromore.z.z.e.m.dl(context, zVar, zVar3, z);
        if (zVar2 != null && zVar2.fo() != 0) {
            dlVar.z(zVar2.fo());
        } else {
            dlVar.z();
        }
    }

    public static void z(Context context, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar, com.bytedance.sdk.openadsdk.tb.z.g.z.a aVar) {
        new com.bytedance.sdk.gromore.z.z.e.dl.dl(context, zVar, aVar).z();
    }

    public static void g(Context context, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar, com.bytedance.sdk.openadsdk.tb.z.g.z.a aVar) {
        new com.bytedance.sdk.gromore.z.z.e.dl.e(context, zVar, aVar).z();
    }
}
