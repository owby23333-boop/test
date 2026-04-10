package com.bytedance.msdk.dl.dl.z;

import android.text.TextUtils;
import com.bytedance.msdk.dl.dl.z.z;
import com.bytedance.msdk.gz.h;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements z {
    private int z(int i) {
        switch (i) {
            case 1:
                return 840032;
            case 2:
                return 840033;
            case 3:
                return 840034;
            case 4:
            case 6:
            default:
                return 840029;
            case 5:
                return 840035;
            case 7:
                return 840036;
            case 8:
                return 840037;
            case 9:
                return 840030;
            case 10:
                return 840039;
        }
    }

    @Override // com.bytedance.msdk.dl.dl.z.z
    public void z(z.InterfaceC0102z interfaceC0102z) {
        com.bytedance.msdk.dl.m.z.g gVarZ = interfaceC0102z.z();
        com.bytedance.msdk.api.z.g gVarJs = gVarZ.js();
        com.bytedance.msdk.api.g.z zVar = !com.bytedance.msdk.core.g.g().z(gVarZ.js().zw(), gVarZ.js().iq()) ? new com.bytedance.msdk.api.g.z(840031, com.bytedance.msdk.api.z.z(840031)) : null;
        if (zVar == null && !com.bytedance.msdk.core.g.g().z(gVarZ.js().iq())) {
            zVar = new com.bytedance.msdk.api.g.z(z(gVarZ.js().iq()), com.bytedance.msdk.api.z.z(z(gVarZ.js().iq())));
        }
        if (zVar == null && !com.bytedance.msdk.m.dl.g()) {
            zVar = new com.bytedance.msdk.api.g.z(1, com.bytedance.msdk.api.z.z(1));
        }
        if (zVar == null && gVarZ.m()) {
            zVar = new com.bytedance.msdk.api.g.z(41044, com.bytedance.msdk.api.z.z(41044));
        }
        if (zVar == null && gVarZ.getContext() == null) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "Context为null！！！");
            zVar = new com.bytedance.msdk.api.g.z(41005, com.bytedance.msdk.api.z.z(41005));
        }
        if (zVar == null && TextUtils.isEmpty(gVarZ.js().zw())) {
            zVar = new com.bytedance.msdk.api.g.z(840026, "广告位id不能为空");
        }
        if (zVar == null && (gVarZ.wp() == null || h.z(gVarZ.wp().t()))) {
            if (com.bytedance.msdk.e.z.dl.z().dl()) {
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(gVarJs.zw()) + "settings config.......没有settings config配置信息,AdUnitId = " + gVarJs.zw());
                zVar = new com.bytedance.msdk.api.g.z(840040, com.bytedance.msdk.api.z.z(840040));
                com.bytedance.msdk.gc.m.g(gVarJs, 1);
            } else if (gVarZ.wp() != null && h.z(gVarZ.wp().t())) {
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(gVarJs.zw()) + "settings config.......注意，AdUnitId = " + gVarJs.zw() + "  没有对应的waterfall配置信息");
                com.bytedance.msdk.gc.m.g(gVarJs, 3);
            } else {
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(gVarJs.zw()) + "settings config.......注意，AdUnitId = " + gVarJs.zw() + " 的配置信息为 null ！！");
                zVar = new com.bytedance.msdk.api.g.z(44406, "检查广告位ID的状态是否正常、初始化 useMediation 参数是否为 true、新建广告位ID生效期为20min左右");
                com.bytedance.msdk.gc.m.g(gVarJs, 2);
            }
            com.bytedance.msdk.core.v.g.z(com.bytedance.msdk.core.g.g()).g(1);
        }
        if (zVar == null) {
            String strXl = gVarJs.xl();
            if (!TextUtils.isEmpty(strXl) && !gVarJs.j() && !com.bytedance.msdk.dl.gz.a.z(gVarJs.zw(), strXl)) {
                zVar = new com.bytedance.msdk.api.g.z(840044, "本次请求未包含聚合广告位头层设价最高的代码位，导致聚合请求失败；请调整请求，确保包含聚合广告位头层设价最高的代码位。");
            }
        }
        com.bytedance.msdk.api.g.z zVar2 = zVar;
        if (zVar2 != null) {
            com.bytedance.msdk.gc.m.z(gVarJs, gVarZ.wp() != null ? gVarZ.wp().vm() : null, !gVarZ.zw(), gVarZ.un().z, zVar2.z, (Map<String, Object>) null);
            gVarZ.z(zVar2);
        } else {
            interfaceC0102z.z(interfaceC0102z.z());
        }
    }

    @Override // com.bytedance.msdk.dl.dl.z.z
    public void g(z.InterfaceC0102z interfaceC0102z) {
        com.bytedance.msdk.dl.m.z.g gVarZ = interfaceC0102z.z();
        if (gVarZ.m()) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "调用过销毁方法_destroy()！！！");
            gVarZ.z(new com.bytedance.msdk.api.z(41044, com.bytedance.msdk.api.z.z(41044)));
        } else if (gVarZ.i().gc()) {
            gVarZ.z(new com.bytedance.msdk.api.z(10010, "延长瀑布流总超时时长或者缩短层超时并添加兜底代码位"));
        } else {
            interfaceC0102z.z((String) null);
        }
    }
}
