package com.anythink.expressad.foundation.h;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.expressad.out.p;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends f {
    public static boolean a = false;
    public static char[] b = {'a', 'n', 'd', 'r', 'o', 'i', 'd', 'c', 'o', 'n', 't', 'e', 'n', 't', 'p', 'm', 'g', 'e', 't', 'C', 'o', 'n', 't', 'e', 'x', 't'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10707c = "SDKUtil";

    public static class a {
        public static final String a = "com.android.vending";
        public static final String b = "market";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f10708c = "play.google.com";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f10709d = "market.android.com";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f10710e = "google.com";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f10711f = "market://";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f10712g = "details?id=";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f10713h = "market://details?id=com.package.name";

        private static Intent a() {
            return new Intent("android.intent.action.VIEW", Uri.parse(f10713h));
        }

        private static boolean b(Context context) {
            List<ResolveInfo> listA = a(context);
            return listA != null && listA.size() > 0;
        }

        private static boolean c(String str) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    Uri uri = Uri.parse(str);
                    if (uri.getHost().equals("play.google.com")) {
                        return true;
                    }
                    return uri.getHost().equals("market.android.com");
                }
            } catch (Throwable th) {
                o.d(s.f10707c, Log.getStackTraceString(th));
            }
            return false;
        }

        private static String d(String str) {
            if (b(str)) {
                return str;
            }
            if (c(str)) {
                return "market://".concat(String.valueOf(str.substring(str.indexOf(f10712g))));
            }
            return null;
        }

        private static List<ResolveInfo> a(Context context) {
            try {
                return context.getPackageManager().queryIntentActivities(a(), 0);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public static boolean b(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return Uri.parse(str).getScheme().equals("market");
            } catch (Throwable th) {
                o.d(s.f10707c, Log.getStackTraceString(th));
                return false;
            }
        }

        public static boolean a(String str) {
            return b(str) || c(str);
        }

        public static boolean a(Context context, String str, p.c cVar) {
            try {
                if (!b(str)) {
                    str = c(str) ? "market://".concat(String.valueOf(str.substring(str.indexOf(f10712g)))) : null;
                }
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                Intent intentA = a();
                intentA.setData(Uri.parse(str));
                intentA.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                context.startActivity(intentA);
                s.a(cVar);
                return true;
            } catch (Throwable th) {
                o.d(s.f10707c, Log.getStackTraceString(th));
                return false;
            }
        }
    }

    public static void a(p.c cVar) {
        if (cVar instanceof p.e) {
            ((p.e) cVar).b();
        }
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.lastIndexOf("/") == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.hashCode());
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str.hashCode() + str.substring(str.lastIndexOf("/") + 1).hashCode());
        return sb2.toString();
    }

    public static void a(Context context, String str, com.anythink.expressad.foundation.d.c cVar, p.c cVar2) {
        if (context == null) {
            return;
        }
        if (a) {
            a(context, str, cVar2);
            return;
        }
        try {
            Class.forName("com.anythink.expressad.activity.ATCommonActivity");
            Intent intent = new Intent(context, Class.forName("com.anythink.expressad.activity.ATCommonActivity"));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (a.b(str)) {
                str = "https://play.google.com/store/apps/details?id=".concat(String.valueOf(str.replace(BaseConstants.MARKET_PREFIX, "")));
            }
            intent.putExtra("url", str);
            o.b("url", "webview url = ".concat(String.valueOf(str)));
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            intent.putExtra("mvcommon", cVar);
            context.startActivity(intent);
        } catch (Exception unused) {
            a(context, str, cVar2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
    
        r8.startActivity(r1);
        a(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0067, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0068, code lost:
    
        a(r8, "https://play.google.com/store/apps/details?id=".concat(java.lang.String.valueOf(r9.replace(com.ss.android.download.api.constant.BaseConstants.MARKET_PREFIX, ""))), r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0077, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(android.content.Context r8, java.lang.String r9, com.anythink.expressad.out.p.c r10) {
        /*
            java.lang.String r0 = "com.android.vending"
            android.content.Intent r1 = new android.content.Intent     // Catch: java.lang.Exception -> L90
            java.lang.String r2 = "android.intent.action.VIEW"
            android.net.Uri r3 = android.net.Uri.parse(r9)     // Catch: java.lang.Exception -> L90
            r1.<init>(r2, r3)     // Catch: java.lang.Exception -> L90
            r2 = 268435456(0x10000000, float:2.524355E-29)
            r1.addFlags(r2)     // Catch: java.lang.Exception -> L90
            android.content.pm.PackageManager r2 = r8.getPackageManager()     // Catch: java.lang.Exception -> L90
            r3 = 0
            java.util.List r2 = r2.queryIntentActivities(r1, r3)     // Catch: java.lang.Exception -> L90
            int r4 = r2.size()     // Catch: java.lang.Exception -> L90
            if (r4 <= 0) goto L22
            r3 = 1
        L22:
            java.lang.String r4 = "market://"
            boolean r4 = r9.startsWith(r4)     // Catch: java.lang.Exception -> L90
            java.lang.String r5 = "https://play.google.com/store/apps/details?id="
            java.lang.String r6 = ""
            java.lang.String r7 = "market://details?id="
            if (r4 == 0) goto L78
            if (r3 != 0) goto L42
            java.lang.String r9 = r9.replace(r7, r6)     // Catch: java.lang.Exception -> L90
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch: java.lang.Exception -> L90
            java.lang.String r9 = r5.concat(r9)     // Catch: java.lang.Exception -> L90
            a(r8, r9, r10)     // Catch: java.lang.Exception -> L90
            return
        L42:
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Exception -> L90
        L46:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Exception -> L90
            if (r3 == 0) goto L61
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Exception -> L90
            android.content.pm.ResolveInfo r3 = (android.content.pm.ResolveInfo) r3     // Catch: java.lang.Exception -> L90
            android.content.pm.ActivityInfo r3 = r3.activityInfo     // Catch: java.lang.Exception -> L90
            java.lang.String r3 = r3.packageName     // Catch: java.lang.Exception -> L90
            boolean r3 = r3.equals(r0)     // Catch: java.lang.Exception -> L90
            if (r3 == 0) goto L46
            java.lang.String r2 = "com.android.vending.AssetBrowserActivity"
            r1.setClassName(r0, r2)     // Catch: java.lang.Exception -> L90
        L61:
            r8.startActivity(r1)     // Catch: java.lang.Exception -> L68
            a(r10)     // Catch: java.lang.Exception -> L68
            return
        L68:
            java.lang.String r9 = r9.replace(r7, r6)     // Catch: java.lang.Exception -> L90
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch: java.lang.Exception -> L90
            java.lang.String r9 = r5.concat(r9)     // Catch: java.lang.Exception -> L90
            a(r8, r9, r10)     // Catch: java.lang.Exception -> L90
            return
        L78:
            java.lang.String r0 = "https://play.google.com/"
            boolean r0 = r9.startsWith(r0)     // Catch: java.lang.Exception -> L90
            if (r0 == 0) goto L8f
            java.lang.String r9 = r9.replace(r5, r6)     // Catch: java.lang.Exception -> L90
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch: java.lang.Exception -> L90
            java.lang.String r9 = r7.concat(r9)     // Catch: java.lang.Exception -> L90
            b(r8, r9, r10)     // Catch: java.lang.Exception -> L90
        L8f:
            return
        L90:
            r8 = move-exception
            java.lang.String r8 = r8.getMessage()
            java.lang.String r9 = "SDKUtil"
            com.anythink.expressad.foundation.h.o.d(r9, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.h.s.b(android.content.Context, java.lang.String, com.anythink.expressad.out.p$c):void");
    }

    public static void a(Context context, String str, p.c cVar) {
        if (str == null || context == null) {
            return;
        }
        try {
            if (a.b(str)) {
                str = "https://play.google.com/store/apps/details?id=".concat(String.valueOf(str.replace(BaseConstants.MARKET_PREFIX, "")));
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            if (resolveInfoResolveActivity != null) {
                intent.setClassName(resolveInfoResolveActivity.activityInfo.packageName, resolveInfoResolveActivity.activityInfo.name);
            }
            context.startActivity(intent);
            a(cVar);
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent2.addFlags(268468224);
                context.startActivity(intent2);
                a(cVar);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public static String a(String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File fileA = com.anythink.expressad.foundation.g.c.d.a(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_IMG);
        if (TextUtils.isEmpty(str)) {
            string = "";
        } else if (str.lastIndexOf("/") == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.hashCode());
            string = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str.hashCode() + str.substring(str.lastIndexOf("/") + 1).hashCode());
            string = sb2.toString();
        }
        return new File(fileA, string).getAbsolutePath();
    }

    private static String a() {
        return com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.AD_ANYTHINK_700);
    }
}
