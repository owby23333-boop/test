package com.xiaomi.accountsdk.utils;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.xiaomi.passport.utils.HttpCookies;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class WebViewCookieUtil extends AbstractAccountWebViewSingleCookieUtil {
    @Override // com.xiaomi.accountsdk.utils.AbstractAccountWebViewSingleCookieUtil
    public String getCookieName() {
        return "";
    }

    @Override // com.xiaomi.accountsdk.utils.AbstractAccountWebViewSingleCookieUtil
    public String getCookieValue() {
        return "";
    }

    public void setupCookiesForAccountWeb(WebView webView, Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        CookieSyncManager.createInstance(webView.getContext());
        CookieManager cookieManagerOrNull = HttpCookies.getCookieManagerOrNull();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            AbstractAccountWebViewSingleCookieUtil.setAccountCookie(cookieManagerOrNull, entry.getKey(), entry.getValue());
        }
        CookieSyncManager.getInstance().sync();
    }
}
