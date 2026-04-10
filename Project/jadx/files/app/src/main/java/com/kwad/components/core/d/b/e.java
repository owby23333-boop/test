package com.kwad.components.core.d.b;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static boolean JA = false;

    private static void K(final AdTemplate adTemplate) {
        if (nO()) {
            return;
        }
        aw(true);
        int iAbs = Math.abs(com.kwad.sdk.core.config.d.uz());
        if (iAbs > 0) {
            bh.a(new Runnable() { // from class: com.kwad.components.core.d.b.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    e.aw(false);
                    com.kwad.sdk.core.b.b.we();
                    if (com.kwad.sdk.core.b.b.isAppOnForeground()) {
                        return;
                    }
                    com.kwad.sdk.core.report.a.a(adTemplate, "wxsmallapp", 1);
                }
            }, null, ((long) iAbs) * 1000);
        } else {
            aw(false);
        }
    }

    public static int a(Context context, String str, String str2, String str3, AdTemplate adTemplate) throws Throwable {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            com.kwad.sdk.core.report.a.j(adTemplate, 1);
            return -1;
        }
        Cursor cursor = null;
        try {
            try {
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                intent.setComponent(launchIntentForPackage.getComponent());
                context.startActivity(intent);
                Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{str, str2, str3, "0", ""}, null);
                if (cursorQuery != null) {
                    try {
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
                    } catch (Exception unused) {
                        cursor = cursorQuery;
                        com.kwad.sdk.core.report.a.j(adTemplate, 2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return -1;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        throw th;
                    }
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
                com.kwad.sdk.core.report.a.a(adTemplate, "wxsmallapp", 1, (y.b) null);
                K(adTemplate);
                return 1;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aw(boolean z2) {
        JA = z2;
    }

    public static int e(Context context, AdTemplate adTemplate) {
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (com.kwad.sdk.core.response.a.a.L(adInfoCb) || com.kwad.sdk.core.response.a.a.M(adInfoCb)) {
            return 0;
        }
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = adInfoCb.adConversionInfo.smallAppJumpInfo;
        return a(context, smallAppJumpInfo.mediaSmallAppId, smallAppJumpInfo.originId, smallAppJumpInfo.smallAppJumpUrl, adTemplate);
    }

    private static boolean nO() {
        return JA;
    }
}
