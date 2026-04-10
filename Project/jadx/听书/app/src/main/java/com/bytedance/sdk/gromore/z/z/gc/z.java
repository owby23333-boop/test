package com.bytedance.sdk.gromore.z.z.gc;

import com.bytedance.sdk.gromore.z.z.a.e;
import com.bytedance.sdk.gromore.z.z.a.gz;
import com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.m;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z extends m {
    private dl z;

    public z(dl dlVar) {
        this.z = dlVar;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.m
    public void destroy() {
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.dl
    public boolean isReady() {
        dl dlVar = this.z;
        if (dlVar != null) {
            return dlVar.z();
        }
        return false;
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
