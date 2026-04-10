package com.bytedance.sdk.openadsdk.mediation.init;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IMediationConfig {
    JSONObject getCustomLocalConfig();

    boolean getHttps();

    Map<String, Object> getLocalExtra();

    MediationConfigUserInfoForSegment getMediationConfigUserInfoForSegment();

    String getOpensdkVer();

    String getPublisherDid();

    boolean isOpenAdnTest();

    boolean isSupportH265();

    boolean isSupportSplashZoomout();

    boolean isWxInstalled();

    String wxAppId();
}
