package com.bytedance.msdk.api.v2;

import android.app.Activity;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IGMLiveTokenInjectionAuth extends Serializable {
    GMLiveToken getTokenInfo();

    boolean isLogin();

    void onTokenInvalid(GMLiveToken gMLiveToken, GMLiveAuthCallback gMLiveAuthCallback, Activity activity, Map<String, String> map);
}
