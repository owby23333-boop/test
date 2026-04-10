package miui.webkit;

import android.net.Uri;
import android.text.TextUtils;
import com.yuewen.m94;
import com.yuewen.rf4;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes8.dex */
public class UrlResolverHelper {
    private static final String BROWSER_HTTPS_SCHEME = "mihttps";
    private static final String BROWSER_HTTP_SCHEME = "mihttp";
    private static final String BROWSER_SCHEME_PREFIX = "mi";
    private static final String FALLBACK_PARAMETER = "mifb";
    private static final String HTTPS_SCHEME = "https";
    private static final String HTTP_SCHEME = "http";
    private static Set<String> sBrowserFallbackSchemeSet;
    private static Set<String> sFallbackSchemeSet;
    private static final String[] MI_LIST = {".xiaomi.com", ".mi.com", ".miui.com"};
    private static final String[] WHITE_PACKAGE_LIST = {"com.xiaomi.channel", "com.duokan.reader", "com.duokan.hdreader", rf4.c, "com.xiaomi.router", "com.xiaomi.smarthome", "com.xiaomi.o2o", "com.xiaomi.shop"};
    private static final String[] DUOKAN_SAFE_URL = {"www.duokan.com", "www.in.duokan.com", "www.n.duokan.com", "m.duokan.com", "cdn.cnbj1.fds.api.mi-img.com", "ts.market.mi-img.com", "s01.mifile.cn", "privacy.mi.com", "account.xiaomi.com", "cdn.web-global.fds.api.mi-img.com", "ssl-cdn.static.browser.mi-img.com", "static-verify.sec.xiaomi.com"};

    static {
        HashSet hashSet = new HashSet();
        sBrowserFallbackSchemeSet = hashSet;
        hashSet.add(BROWSER_HTTP_SCHEME);
        sBrowserFallbackSchemeSet.add(BROWSER_HTTPS_SCHEME);
        HashSet hashSet2 = new HashSet();
        sFallbackSchemeSet = hashSet2;
        hashSet2.add("http");
        sFallbackSchemeSet.add("https");
        sFallbackSchemeSet.addAll(sBrowserFallbackSchemeSet);
    }

    public static Uri getBrowserFallbackUri(String str) {
        return Uri.parse(str.substring(2));
    }

    public static String getFallbackParameter(Uri uri) {
        String fallbackParameter = getFallbackParameter(uri, 0, null);
        if (fallbackParameter != null) {
            if (sFallbackSchemeSet.contains(Uri.parse(fallbackParameter).getScheme())) {
                return fallbackParameter;
            }
        }
        return null;
    }

    public static boolean isBrowserFallbackScheme(String str) {
        return sBrowserFallbackSchemeSet.contains(str);
    }

    public static boolean isDkHost(String str) {
        return isDkHost(m94.r(str));
    }

    public static boolean isMiHost(String str) {
        return isMiHost(m94.r(str));
    }

    public static boolean isWhiteListPackage(String str) {
        for (String str2 : WHITE_PACKAGE_LIST) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDkHost(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            String host = uri.getHost();
            if (TextUtils.isEmpty(host)) {
                return false;
            }
            return host.endsWith(".duokan.com");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isMiHost(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            String host = uri.getHost();
            if (TextUtils.isEmpty(host)) {
                return false;
            }
            for (String str : MI_LIST) {
                if (host.endsWith(str)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static String getFallbackParameter(Uri uri, int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(FALLBACK_PARAMETER);
        sb.append(i == 0 ? "" : Integer.valueOf(i));
        String queryParameter = uri.getQueryParameter(sb.toString());
        return queryParameter != null ? getFallbackParameter(uri, i + 1, queryParameter) : str;
    }
}
