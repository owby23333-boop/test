package com.bytedance.msdk.api.base;

import com.bytedance.msdk.api.AdLoadInfo;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface TTLoadBase {
    List<AdLoadInfo> getAdLoadInfoList();

    int getAdNetworkPlatformId();

    String getAdNetworkRitId();

    GMAdEcpmInfo getBestEcpm();

    List<GMAdEcpmInfo> getCacheList();

    List<GMAdEcpmInfo> getMultiBiddingEcpm();

    String getPreEcpm();

    GMAdEcpmInfo getShowEcpm();
}
