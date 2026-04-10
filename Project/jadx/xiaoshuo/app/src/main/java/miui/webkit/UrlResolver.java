package miui.webkit;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

/* JADX INFO: loaded from: classes8.dex */
public class UrlResolver {
    private UrlResolver() {
    }

    public static ResolveInfo checkMiuiIntent(Context context, PackageManager packageManager, Intent intent) {
        return checkMiuiIntent(context, true, packageManager, intent, null, 0, null, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0049 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.pm.ResolveInfo checkMiuiIntent(android.content.Context r6, boolean r7, android.content.pm.PackageManager r8, android.content.Intent r9, java.lang.String r10, int r11, java.util.List<android.content.pm.ResolveInfo> r12, int r13) {
        /*
            r10 = 0
            if (r7 == 0) goto L7
            java.util.List r12 = r8.queryIntentActivities(r9, r10)
        L7:
            r11 = -1
            r13 = r10
            r0 = r11
        La:
            int r1 = r12.size()
            r2 = 1
            r3 = 0
            if (r13 >= r1) goto L4c
            java.lang.Object r1 = r12.get(r13)
            android.content.pm.ResolveInfo r1 = (android.content.pm.ResolveInfo) r1
            android.content.pm.ActivityInfo r4 = r1.activityInfo
            java.lang.String r4 = r4.packageName
            java.lang.String r5 = "com.android.browser"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L26
            r0 = r13
            goto L49
        L26:
            android.content.pm.ActivityInfo r4 = r1.activityInfo
            java.lang.String r4 = r4.packageName
            boolean r4 = miui.webkit.UrlResolverHelper.isWhiteListPackage(r4)
            if (r4 == 0) goto L31
            return r1
        L31:
            boolean r4 = com.yuewen.l32.f()
            if (r4 == 0) goto L49
            if (r7 == 0) goto L41
            android.content.pm.ActivityInfo r3 = r1.activityInfo     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L49
            java.lang.String r3 = r3.packageName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L49
            android.content.pm.PackageInfo r3 = r8.getPackageInfo(r3, r10)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L49
        L41:
            android.content.pm.ApplicationInfo r3 = r3.applicationInfo
            int r3 = r3.flags
            r2 = r2 & r3
            if (r2 == 0) goto L49
            return r1
        L49:
            int r13 = r13 + 1
            goto La
        L4c:
            android.net.Uri r13 = r9.getData()
            if (r13 != 0) goto L53
            return r3
        L53:
            java.lang.String r1 = r13.getHost()
            if (r1 != 0) goto L5a
            return r3
        L5a:
            boolean r1 = miui.webkit.UrlResolverHelper.isMiHost(r13)
            if (r1 != 0) goto L61
            return r3
        L61:
            java.lang.String r13 = miui.webkit.UrlResolverHelper.getFallbackParameter(r13)
            if (r13 == 0) goto L93
            android.net.Uri r11 = android.net.Uri.parse(r13)
            java.lang.String r12 = r11.getScheme()
            boolean r12 = miui.webkit.UrlResolverHelper.isBrowserFallbackScheme(r12)
            if (r12 == 0) goto L7a
            android.net.Uri r11 = miui.webkit.UrlResolverHelper.getBrowserFallbackUri(r13)
            r10 = r2
        L7a:
            r9.setData(r11)
            if (r7 == 0) goto L8f
            if (r10 == 0) goto L8a
            r6.startActivity(r9)
            android.content.pm.ResolveInfo r6 = new android.content.pm.ResolveInfo
            r6.<init>()
            return r6
        L8a:
            android.content.pm.ResolveInfo r6 = checkMiuiIntent(r6, r8, r9)
            return r6
        L8f:
            r9.setData(r11)
            return r3
        L93:
            if (r0 == r11) goto L9e
            if (r7 != 0) goto L9e
            java.lang.Object r6 = r12.get(r0)
            android.content.pm.ResolveInfo r6 = (android.content.pm.ResolveInfo) r6
            return r6
        L9e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: miui.webkit.UrlResolver.checkMiuiIntent(android.content.Context, boolean, android.content.pm.PackageManager, android.content.Intent, java.lang.String, int, java.util.List, int):android.content.pm.ResolveInfo");
    }
}
