package com.bytedance.sdk.openadsdk.mediation.init;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IMediationPrivacyConfig {
    List<String> getCustomAppList();

    List<String> getCustomDevImeis();

    boolean isCanUseOaid();

    boolean isLimitPersonalAds();

    boolean isProgrammaticRecommend();
}
