package com.bytedance.sdk.gromore.z.z.a;

import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class uy extends com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc {
    private v z;

    public uy(v vVar) {
        this.z = vVar;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc
    public boolean hasDislike() {
        v vVar = this.z;
        if (vVar != null) {
            return vVar.e();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc
    public void setUseCustomVideo(boolean z) {
        v vVar = this.z;
        if (vVar != null) {
            vVar.z(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc
    public void setShakeViewListener(final com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.m mVar) {
        v vVar = this.z;
        if (vVar != null) {
            vVar.z(new pf() { // from class: com.bytedance.sdk.gromore.z.z.a.uy.1
                @Override // com.bytedance.sdk.gromore.z.z.a.pf
                public void z() {
                    com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.m mVar2 = mVar;
                    if (mVar2 != null) {
                        mVar2.z();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc
    public void onResume() {
        v vVar = this.z;
        if (vVar != null) {
            vVar.fo();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc
    public void onPause() {
        v vVar = this.z;
        if (vVar != null) {
            vVar.uy();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc
    public boolean isExpress() {
        v vVar = this.z;
        if (vVar != null) {
            return vVar.gz();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.dl
    public boolean isReady() {
        v vVar = this.z;
        if (vVar != null) {
            return vVar.z();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.dl
    public List<com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.g> getAdLoadInfo() {
        if (this.z != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.z.g().size(); i++) {
                linkedList.add(new gz(this.z.g().get(i)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.dl
    public List<com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z> getMultiBiddingEcpm() {
        if (this.z != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.z.dl().size(); i++) {
                linkedList.add(new e(this.z.dl().get(i)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.dl
    public com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z getBestEcpm() {
        if (this.z != null) {
            return new e(this.z.a());
        }
        return new e(null);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.dl
    public List<com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z> getCacheList() {
        if (this.z != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.z.gc().size(); i++) {
                linkedList.add(new e(this.z.gc().get(i)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.dl
    public com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z getShowEcpm() {
        if (this.z != null) {
            return new e(this.z.m());
        }
        return new e(null);
    }
}
