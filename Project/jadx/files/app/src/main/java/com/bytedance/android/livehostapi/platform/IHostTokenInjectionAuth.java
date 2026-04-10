package com.bytedance.android.livehostapi.platform;

import android.app.Activity;
import com.bytedance.android.live.base.IService;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IHostTokenInjectionAuth extends IService {
    TokenInfo getTokenInfo();

    boolean isLogin();

    void onTokenInvalid(TokenInfo tokenInfo, TokenRefreshCallback tokenRefreshCallback, Activity activity, Map<String, String> map);
}
