package com.bytedance.msdk.dl.dl.z;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.gz.h;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class uy extends g {
    private final List<com.bytedance.msdk.core.uy.uy> e;
    private final com.bytedance.msdk.dl.m.z.g gc;
    private final HashSet<String> gz = new HashSet<>();
    private final com.bytedance.msdk.core.uy.g m;

    public uy(com.bytedance.msdk.dl.m.z.g gVar, com.bytedance.msdk.core.uy.g gVar2, List<com.bytedance.msdk.core.uy.uy> list) {
        this.gc = gVar;
        this.m = gVar2;
        this.e = list;
    }

    @Override // com.bytedance.msdk.dl.dl.z.g
    public boolean g(com.bytedance.msdk.core.uy.uy uyVar, int i) {
        com.bytedance.msdk.core.uy.uy uyVarM;
        if (i == 1) {
            com.bytedance.msdk.core.uy.uy uyVarM2 = m();
            if (uyVarM2 != null && uyVar != null && TextUtils.equals(uyVarM2.fv(), uyVar.fv())) {
                dl();
                return true;
            }
        } else if (i == 2) {
            if (uyVar != null) {
                this.gz.add(uyVar.fv());
                CopyOnWriteArrayList<com.bytedance.msdk.g.dl> copyOnWriteArrayListGz = this.gc.gz();
                com.bytedance.msdk.g.dl dlVar = (copyOnWriteArrayListGz == null || copyOnWriteArrayListGz.size() <= 0) ? null : copyOnWriteArrayListGz.get(0);
                if (dlVar != null && (uyVarM = m()) != null && TextUtils.equals(uyVarM.fv(), dlVar.yz())) {
                    dl();
                    return true;
                }
            }
            if (this.g.gz()) {
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "全部广告完成响应...");
                if (h.z(this.gc.gz())) {
                    z(new com.bytedance.msdk.api.z(20005, com.bytedance.msdk.api.z.z(20005)));
                }
                return true;
            }
        } else if (this.g.gc()) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "触发总超时或全部代码位响应结束.....totalTimeout：" + this.g.gc() + "  allWtfFinish:" + this.g.gz());
            if (!h.z(this.gc.gz())) {
                dl();
            } else {
                z(new com.bytedance.msdk.api.z(AVMDLDataLoader.KeyIsStoRingBufferSizeKB, com.bytedance.msdk.api.z.z(AVMDLDataLoader.KeyIsStoRingBufferSizeKB)));
            }
            return true;
        }
        return false;
    }

    private com.bytedance.msdk.core.uy.uy m() {
        List<com.bytedance.msdk.core.uy.uy> list = this.e;
        if (list == null) {
            return null;
        }
        for (com.bytedance.msdk.core.uy.uy uyVar : list) {
            if (uyVar != null) {
                if (!this.gz.contains(uyVar.fv())) {
                    return uyVar;
                }
            }
        }
        return null;
    }
}
