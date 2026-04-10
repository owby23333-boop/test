package com.xiaomi.accountsdk.utils;

import android.webkit.CookieManager;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes5.dex */
public final class WebViewUserSpaceIdUtil extends AbstractAccountWebViewSingleCookieUtil {
    @Override // com.xiaomi.accountsdk.utils.AbstractAccountWebViewSingleCookieUtil
    public String getCookieName() {
        return "userSpaceId";
    }

    @Override // com.xiaomi.accountsdk.utils.AbstractAccountWebViewSingleCookieUtil
    public String getCookieValue() {
        return UserSpaceIdUtil.getNullableUserSpaceIdCookie();
    }

    public void setupUserSpaceIdCookie(String str, CookieManager cookieManager) {
        super.setAccountCookie(cookieManager, str);
    }

    public void setupUserSpaceIdForAccountWeb(WebView webView) {
        super.setupNonNullCookieForAccountWeb(webView);
    }
}
