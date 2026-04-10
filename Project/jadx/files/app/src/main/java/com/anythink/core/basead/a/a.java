package com.anythink.core.basead.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.anythink.core.c.b;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.am;
import com.anythink.core.common.k.l;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final String a = "play.google.com";
    public static final String b = "market.android.com";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6583c = "details?";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f6584d = "market";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f6585e = "market://";

    public static am a(String str) {
        am amVar = new am();
        amVar.f7205l = 8;
        amVar.f7207n = false;
        amVar.f7206m = true;
        amVar.f7208o = str;
        try {
            if (Uri.parse(str).getScheme().equals("intent")) {
                Intent uri = Intent.parseUri(str, 1);
                uri.addCategory("android.intent.category.BROWSABLE");
                uri.setComponent(null);
                if (Build.VERSION.SDK_INT >= 15) {
                    uri.setSelector(null);
                }
                String stringExtra = uri.getStringExtra("browser_fallback_url");
                if (!TextUtils.isEmpty(stringExtra) && stringExtra.startsWith("http")) {
                    amVar.f7205l = 10;
                    amVar.f7208o = stringExtra;
                    return amVar;
                }
            }
        } catch (Throwable unused) {
        }
        if (c(str)) {
            String strD = d(str);
            amVar.f7205l = 9;
            amVar.f7208o = strD;
        }
        return amVar;
    }

    private static void b(Context context, String str) {
        l.a(context, str);
    }

    private static boolean c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return Uri.parse(str).getScheme().equals("market");
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String d(String str) {
        try {
            return "https://play.google.com/store/apps/details?id=".concat(String.valueOf(str.replace(BaseConstants.MARKET_PREFIX, "")));
        } catch (Throwable unused) {
            return str;
        }
    }

    private static String e(String str) {
        try {
            return "market://".concat(String.valueOf(str.substring(str.indexOf(f6583c))));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean b(String str) {
        Uri uri;
        try {
            if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && uri.getHost() != null) {
                if (uri.getHost().equals("play.google.com")) {
                    return true;
                }
                return uri.getHost().equals("market.android.com");
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static am a(Context context, String str) {
        am amVar = new am();
        amVar.f7207n = !str.startsWith("http");
        amVar.f7208o = str;
        if (c(str)) {
            amVar.f7208o = str;
            boolean zEquals = TextUtils.equals(b.a(context).b(n.a().p()).l(), "1");
            if (a(context, str, false, zEquals)) {
                amVar.f7206m = true;
                if (zEquals) {
                    amVar.f7205l = 3;
                } else {
                    amVar.f7205l = 4;
                }
            } else if (a(context, str, false, false)) {
                amVar.f7206m = true;
                amVar.f7205l = 4;
            }
            return amVar;
        }
        if (!str.startsWith("http")) {
            amVar.f7208o = str;
            if (a(context, str, false, false)) {
                amVar.f7206m = true;
                amVar.f7205l = 5;
            }
            return amVar;
        }
        if (b(str)) {
            String strE = e(str);
            amVar.f7207n = true;
            amVar.f7208o = strE;
            if (a(context, strE, false, true)) {
                amVar.f7206m = true;
                amVar.f7205l = 1;
            } else if (a(context, strE, false, false)) {
                amVar.f7206m = true;
                amVar.f7205l = 2;
            }
        }
        return amVar;
    }

    public static boolean a(Context context, String str, boolean z2) {
        if (b(str)) {
            return a(context, e(str), z2, true);
        }
        String scheme = Uri.parse(str).getScheme();
        if (scheme == null || scheme.startsWith("http")) {
            return false;
        }
        return a(context, str, z2, scheme.startsWith("market") && TextUtils.equals(b.a(context).b(n.a().p()).l(), "1"));
    }

    private static boolean a(final Context context, String str, boolean z2, boolean z3) {
        Intent intent;
        try {
            Uri uri = Uri.parse(str);
            if (uri.getScheme().equals("intent")) {
                intent = Intent.parseUri(str, 1);
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setComponent(null);
                if (Build.VERSION.SDK_INT >= 15) {
                    intent.setSelector(null);
                }
            } else {
                intent = new Intent("android.intent.action.VIEW", uri);
                intent.setData(uri);
            }
            if (z3 && TextUtils.isEmpty(intent.getPackage())) {
                intent.setPackage("com.android.vending");
            }
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            if (!z2) {
                return false;
            }
            n.a().a(new Runnable() { // from class: com.anythink.core.basead.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    Toast.makeText(context, "Detect that the App Market is not installed and cannot be opened through the App Market.", 1).show();
                }
            });
            return false;
        }
    }
}
