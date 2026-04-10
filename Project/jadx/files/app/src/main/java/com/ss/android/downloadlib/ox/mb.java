package com.ss.android.downloadlib.ox;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.m;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.model.OpenAppResult;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mb {
    public static boolean mb(@NonNull com.ss.android.downloadlib.addownload.model.h hVar) {
        boolean z2;
        DeepLink deepLink = hVar.ox.getDeepLink();
        String openUrl = deepLink == null ? null : deepLink.getOpenUrl();
        JSONObject jSONObjectMb = com.ss.android.downloadlib.utils.h.mb(new JSONObject(), hVar);
        jb.mb(jSONObjectMb, EventConstants.ExtraJson.APPLINK_SOURCE, EventConstants.AppLinkSource.CLICK_BY_SDK);
        AdEventHandler.mb().ox(EventConstants.Label.APPLINK_CLICK, jSONObjectMb, hVar);
        OpenAppResult openAppResultMb = com.ss.android.downloadlib.utils.ww.mb(openUrl, hVar);
        if (openAppResultMb.getType() == 2) {
            if (!TextUtils.isEmpty(openUrl)) {
                ox(EventConstants.AppLinkSource.BY_URL, openAppResultMb, jSONObjectMb, hVar);
            }
            openAppResultMb = com.ss.android.downloadlib.utils.ww.mb(com.ss.android.downloadlib.addownload.x.getContext(), hVar.ox.getPackageName(), hVar);
        }
        boolean z3 = false;
        if (mb(hVar.mb) && com.ss.android.downloadlib.addownload.x.lz().optInt("link_ad_click_event") == 1) {
            DownloadModel downloadModel = hVar.ox;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(4);
            }
            AdEventHandler.mb().mb(hVar.mb, 0);
            z2 = true;
        } else {
            z2 = false;
        }
        int type = openAppResultMb.getType();
        if (type == 1) {
            ox(EventConstants.AppLinkSource.BY_URL, jSONObjectMb, hVar);
        } else {
            if (type != 3) {
                if (type != 4) {
                    com.ss.android.downloadlib.exception.b.mb().ox("AppLinkClick default");
                } else {
                    mb(EventConstants.AppLinkSource.BY_PACKAGE, openAppResultMb, jSONObjectMb, hVar);
                }
                if (z3 && !z2 && ((com.ss.android.downloadlib.event.ox.mb().ox() && !com.ss.android.downloadlib.event.ox.mb().ox(hVar.mb, hVar.ox.getLogExtra())) || com.ss.android.downloadlib.event.ox.mb().b())) {
                    AdEventHandler.mb().mb(hVar.mb, 2);
                }
                return z3;
            }
            mb(EventConstants.AppLinkSource.BY_PACKAGE, jSONObjectMb, hVar);
        }
        z3 = true;
        if (z3) {
            AdEventHandler.mb().mb(hVar.mb, 2);
        }
        return z3;
    }

    public static void ox(com.ss.android.downloadad.api.mb.ox oxVar) {
        if (oxVar == null) {
            return;
        }
        String strU = DownloadSetting.obtainGlobal().optInt("app_link_opt") == 1 ? oxVar.u() : null;
        JSONObject jSONObjectMb = com.ss.android.downloadlib.utils.h.mb(new JSONObject(), oxVar);
        jb.mb(jSONObjectMb, EventConstants.ExtraJson.APPLINK_SOURCE, EventConstants.AppLinkSource.DIALOG_CLICK);
        AdEventHandler.mb().ox(EventConstants.Label.APPLINK_CLICK, jSONObjectMb, oxVar);
        OpenAppResult openAppResultMb = com.ss.android.downloadlib.utils.ww.mb(strU, oxVar);
        if (openAppResultMb.getType() == 2) {
            if (!TextUtils.isEmpty(strU)) {
                ox(EventConstants.AppLinkSource.DIALOG_BY_URL, openAppResultMb, jSONObjectMb, oxVar);
            }
            openAppResultMb = com.ss.android.downloadlib.utils.ww.mb(com.ss.android.downloadlib.addownload.x.getContext(), oxVar.h(), oxVar);
        }
        int type = openAppResultMb.getType();
        if (type == 1) {
            ox(EventConstants.AppLinkSource.DIALOG_BY_URL, jSONObjectMb, oxVar);
            return;
        }
        if (type == 3) {
            mb(EventConstants.AppLinkSource.DIALOG_BY_PACKAGE, jSONObjectMb, oxVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.exception.b.mb().ox("AppLinkClickDialog default");
        } else {
            mb(EventConstants.AppLinkSource.DIALOG_BY_PACKAGE, openAppResultMb, jSONObjectMb, oxVar);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void ox(java.lang.String r8, @androidx.annotation.NonNull final org.json.JSONObject r9, @androidx.annotation.NonNull final com.ss.android.downloadad.api.mb.mb r10) {
        /*
            java.lang.String r0 = "applink_source"
            com.ss.android.downloadlib.utils.jb.mb(r9, r0, r8)
            int r0 = r10.gm()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "download_scene"
            com.ss.android.downloadlib.utils.jb.mb(r9, r1, r0)
            com.ss.android.downloadlib.event.AdEventHandler r0 = com.ss.android.downloadlib.event.AdEventHandler.mb()
            java.lang.String r1 = "deeplink_url_open"
            r0.ox(r1, r9, r10)
            int r0 = r8.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case -1721882089: goto L44;
                case -1374618233: goto L3a;
                case -129544387: goto L30;
                case 829750366: goto L26;
                default: goto L25;
            }
        L25:
            goto L4e
        L26:
            java.lang.String r0 = "dialog_by_url"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L4e
            r0 = 3
            goto L4f
        L30:
            java.lang.String r0 = "notify_by_url"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L4e
            r0 = 0
            goto L4f
        L3a:
            java.lang.String r0 = "by_url"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L4e
            r0 = 2
            goto L4f
        L44:
            java.lang.String r0 = "auto_by_url"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L4e
            r0 = 1
            goto L4f
        L4e:
            r0 = -1
        L4f:
            if (r0 == 0) goto L58
            if (r0 == r3) goto L58
            if (r0 == r2) goto L58
            if (r0 == r1) goto L58
            goto L97
        L58:
            org.json.JSONObject r0 = com.ss.android.downloadlib.addownload.x.lz()
            java.lang.String r1 = "check_applink_mode"
            int r0 = r0.optInt(r1)
            r0 = r0 & r3
            if (r0 == 0) goto L7b
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            java.lang.String r0 = "check_applink_result_by_sdk"
            com.ss.android.downloadlib.utils.jb.mb(r9, r0, r8)
            com.ss.android.downloadlib.ox.h r8 = com.ss.android.downloadlib.ox.h.mb()
            com.ss.android.downloadlib.ox.mb$2 r0 = new com.ss.android.downloadlib.ox.mb$2
            r0.<init>()
            r8.mb(r0)
            goto L97
        L7b:
            com.ss.android.download.api.config.b r1 = com.ss.android.downloadlib.addownload.x.ox()
            android.content.Context r2 = com.ss.android.downloadlib.addownload.x.getContext()
            com.ss.android.download.api.download.DownloadModel r3 = r10.g()
            com.ss.android.download.api.download.DownloadController r4 = r10.r()
            com.ss.android.download.api.download.DownloadEventConfig r5 = r10.df()
            java.lang.String r6 = r10.h()
            r7 = r8
            r1.mb(r2, r3, r4, r5, r6, r7)
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.ox.mb.ox(java.lang.String, org.json.JSONObject, com.ss.android.downloadad.api.mb.mb):void");
    }

    public static void mb(@NonNull com.ss.android.downloadad.api.mb.ox oxVar) {
        String strU = oxVar.u();
        JSONObject jSONObjectMb = com.ss.android.downloadlib.utils.h.mb(new JSONObject(), oxVar);
        jb.mb(jSONObjectMb, EventConstants.ExtraJson.APPLINK_SOURCE, EventConstants.AppLinkSource.NOTIFY_CLICK);
        AdEventHandler.mb().ox(EventConstants.Label.APPLINK_CLICK, jSONObjectMb, oxVar);
        OpenAppResult openAppResultMb = com.ss.android.downloadlib.utils.ww.mb(strU, oxVar);
        if (openAppResultMb.getType() == 2) {
            if (!TextUtils.isEmpty(strU)) {
                ox(EventConstants.AppLinkSource.NOTIFY_BY_URL, openAppResultMb, jSONObjectMb, oxVar);
            }
            openAppResultMb = com.ss.android.downloadlib.utils.ww.mb(com.ss.android.downloadlib.addownload.x.getContext(), oxVar.h(), oxVar);
        }
        int type = openAppResultMb.getType();
        if (type == 1) {
            ox(EventConstants.AppLinkSource.NOTIFY_BY_URL, jSONObjectMb, oxVar);
            return;
        }
        if (type == 3) {
            mb(EventConstants.AppLinkSource.NOTIFY_BY_PACKAGE, jSONObjectMb, oxVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.exception.b.mb().ox("AppLinkClickNotification default");
        } else {
            mb(EventConstants.AppLinkSource.NOTIFY_BY_PACKAGE, openAppResultMb, jSONObjectMb, oxVar);
        }
    }

    public static void ox(String str, @NonNull OpenAppResult openAppResult, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.mb.mb mbVar) {
        jb.mb(jSONObject, EventConstants.ExtraJson.APPLINK_SOURCE, str);
        jb.mb(jSONObject, "error_code", Integer.valueOf(openAppResult.mb()));
        jb.mb(jSONObject, EventConstants.ExtraJson.DOWNLOAD_SCENE, Integer.valueOf(mbVar.gm()));
        AdEventHandler.mb().ox(EventConstants.Label.DEEPLINK_URL_OPEN_FAIL, jSONObject, mbVar);
    }

    public static boolean mb(String str, @NonNull com.ss.android.downloadad.api.mb.ox oxVar) {
        if (!com.ss.android.downloadlib.addownload.ww.ox(oxVar.yr())) {
            return false;
        }
        if (TextUtils.isEmpty(oxVar.u()) && TextUtils.isEmpty(str)) {
            return false;
        }
        DownloadNotificationManager.getInstance().cancelNotification(oxVar.m());
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.utils.h.mb(jSONObject, oxVar);
        jb.mb(jSONObject, EventConstants.ExtraJson.APPLINK_SOURCE, EventConstants.AppLinkSource.AUTO_CLICK);
        AdEventHandler.mb().ox(EventConstants.Label.APPLINK_CLICK, oxVar);
        OpenAppResult openAppResultMb = com.ss.android.downloadlib.utils.ww.mb(oxVar, oxVar.u(), oxVar.h());
        int type = openAppResultMb.getType();
        if (type == 1) {
            ox(EventConstants.AppLinkSource.AUTO_BY_URL, jSONObject, oxVar);
            return true;
        }
        if (type == 2) {
            ox(EventConstants.AppLinkSource.AUTO_BY_URL, openAppResultMb, jSONObject, oxVar);
            return false;
        }
        if (type == 3) {
            mb(EventConstants.AppLinkSource.AUTO_BY_PACKAGE, jSONObject, oxVar);
            return true;
        }
        if (type != 4) {
            return false;
        }
        mb(EventConstants.AppLinkSource.AUTO_BY_PACKAGE, openAppResultMb, jSONObject, oxVar);
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void mb(java.lang.String r8, @androidx.annotation.NonNull final org.json.JSONObject r9, @androidx.annotation.NonNull final com.ss.android.downloadad.api.mb.mb r10) {
        /*
            java.lang.String r0 = "applink_source"
            com.ss.android.downloadlib.utils.jb.mb(r9, r0, r8)
            int r0 = r10.gm()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "download_scene"
            com.ss.android.downloadlib.utils.jb.mb(r9, r1, r0)
            com.ss.android.downloadlib.event.AdEventHandler r0 = com.ss.android.downloadlib.event.AdEventHandler.mb()
            java.lang.String r1 = "deeplink_app_open"
            r0.ox(r1, r9, r10)
            int r0 = r8.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case -1282070764: goto L44;
                case -441514770: goto L3a;
                case -185950114: goto L30;
                case 368401333: goto L26;
                default: goto L25;
            }
        L25:
            goto L4e
        L26:
            java.lang.String r0 = "dialog_by_package"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L4e
            r0 = 3
            goto L4f
        L30:
            java.lang.String r0 = "by_package"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L4e
            r0 = 2
            goto L4f
        L3a:
            java.lang.String r0 = "auto_by_package"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L4e
            r0 = 1
            goto L4f
        L44:
            java.lang.String r0 = "notify_by_package"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L4e
            r0 = 0
            goto L4f
        L4e:
            r0 = -1
        L4f:
            if (r0 == 0) goto L58
            if (r0 == r3) goto L58
            if (r0 == r2) goto L58
            if (r0 == r1) goto L58
            goto L97
        L58:
            org.json.JSONObject r0 = com.ss.android.downloadlib.addownload.x.lz()
            java.lang.String r1 = "check_applink_mode"
            int r0 = r0.optInt(r1)
            r0 = r0 & r3
            if (r0 == 0) goto L7b
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            java.lang.String r0 = "check_applink_result_by_sdk"
            com.ss.android.downloadlib.utils.jb.mb(r9, r0, r8)
            com.ss.android.downloadlib.ox.h r8 = com.ss.android.downloadlib.ox.h.mb()
            com.ss.android.downloadlib.ox.mb$1 r0 = new com.ss.android.downloadlib.ox.mb$1
            r0.<init>()
            r8.mb(r0)
            goto L97
        L7b:
            com.ss.android.download.api.config.b r1 = com.ss.android.downloadlib.addownload.x.ox()
            android.content.Context r2 = com.ss.android.downloadlib.addownload.x.getContext()
            com.ss.android.download.api.download.DownloadModel r3 = r10.g()
            com.ss.android.download.api.download.DownloadController r4 = r10.r()
            com.ss.android.download.api.download.DownloadEventConfig r5 = r10.df()
            java.lang.String r6 = r10.h()
            r7 = r8
            r1.mb(r2, r3, r4, r5, r6, r7)
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.ox.mb.mb(java.lang.String, org.json.JSONObject, com.ss.android.downloadad.api.mb.mb):void");
    }

    public static void mb(String str, @NonNull OpenAppResult openAppResult, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.mb.mb mbVar) {
        jb.mb(jSONObject, EventConstants.ExtraJson.APPLINK_SOURCE, str);
        jb.mb(jSONObject, "error_code", Integer.valueOf(openAppResult.mb()));
        jb.mb(jSONObject, EventConstants.ExtraJson.DOWNLOAD_SCENE, Integer.valueOf(mbVar.gm()));
        AdEventHandler.mb().ox(EventConstants.Label.DEEPLINK_APP_OPEN_FAIL, jSONObject, mbVar);
    }

    public static boolean mb(@NonNull com.ss.android.downloadlib.addownload.model.h hVar, int i2) {
        JSONObject jSONObject = new JSONObject();
        jb.mb(jSONObject, EventConstants.ExtraJson.DOWNLOAD_SCENE, Integer.valueOf(hVar.gm()));
        AdEventHandler.mb().ox(EventConstants.Label.MARKET_CLICK_OPEN, jSONObject, hVar);
        OpenAppResult openAppResultMb = com.ss.android.downloadlib.utils.ww.mb(com.ss.android.downloadlib.addownload.x.getContext(), hVar, hVar.ox.getPackageName());
        String strMb = jb.mb(openAppResultMb.ox(), EventConstants.AppLinkSource.OPEN_MARKET);
        int type = openAppResultMb.getType();
        if (type == 5) {
            mb(strMb, jSONObject, hVar, true);
        } else {
            if (type == 6) {
                jb.mb(jSONObject, "error_code", Integer.valueOf(openAppResultMb.mb()));
                jb.mb(jSONObject, EventConstants.ExtraJson.DOWNLOAD_SCENE, Integer.valueOf(hVar.gm()));
                AdEventHandler.mb().ox(EventConstants.Label.MARKET_OPEN_FAILED, jSONObject, hVar);
                return false;
            }
            if (type != 7) {
                return false;
            }
        }
        AdEventHandler.mb().mb(hVar.mb, i2);
        return true;
    }

    public static void mb(final String str, @Nullable final JSONObject jSONObject, final com.ss.android.downloadlib.addownload.model.h hVar, boolean z2) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e2) {
                com.ss.android.downloadlib.exception.b.mb().mb(e2, "onMarketSuccess");
                return;
            }
        }
        jb.mb(jSONObject, EventConstants.ExtraJson.APPLINK_SOURCE, str);
        jb.mb(jSONObject, EventConstants.ExtraJson.DOWNLOAD_SCENE, Integer.valueOf(hVar.gm()));
        if (z2) {
            AdEventHandler.mb().ox(EventConstants.Label.MARKET_OPEN_SUCCESS, jSONObject, hVar);
        }
        if ((com.ss.android.downloadlib.addownload.x.lz().optInt("check_applink_mode") & 4) != 0) {
            h.mb().ox(new hj() { // from class: com.ss.android.downloadlib.ox.mb.3
                @Override // com.ss.android.downloadlib.ox.hj
                public void mb(boolean z3) {
                    if (!z3 && !EventConstants.AppLinkSource.OPEN_MARKET.equals(str)) {
                        mb.mb(com.ss.android.downloadlib.utils.ww.mb(com.ss.android.downloadlib.addownload.x.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + hVar.h())), hVar, false);
                    }
                    AdEventHandler.mb().mb(z3 ? EventConstants.UnityLabel.MARKET_DELAY_SUCCESS : EventConstants.UnityLabel.MARKET_DELAY_FAILED, jSONObject, hVar);
                    if (z3) {
                        m mVarGm = com.ss.android.downloadlib.addownload.x.gm();
                        Context context = com.ss.android.downloadlib.addownload.x.getContext();
                        com.ss.android.downloadlib.addownload.model.h hVar2 = hVar;
                        DownloadModel downloadModel = hVar2.ox;
                        mVarGm.mb(context, downloadModel, hVar2.hj, hVar2.b, downloadModel.getPackageName(), 2);
                    }
                }
            });
        } else {
            com.ss.android.downloadlib.addownload.x.ox().mb(com.ss.android.downloadlib.addownload.x.getContext(), hVar.ox, hVar.hj, hVar.b, hVar.ox.getPackageName(), str);
        }
        com.ss.android.downloadad.api.mb.ox oxVar = new com.ss.android.downloadad.api.mb.ox(hVar.ox, hVar.b, hVar.hj);
        oxVar.h(2);
        oxVar.u(System.currentTimeMillis());
        oxVar.ww(4);
        oxVar.lz(2);
        com.ss.android.downloadlib.addownload.model.u.mb().mb(oxVar);
    }

    public static void mb(OpenAppResult openAppResult, com.ss.android.downloadlib.addownload.model.h hVar, boolean z2) {
        String strMb = jb.mb(openAppResult.ox(), EventConstants.AppLinkSource.OPEN_MARKET);
        JSONObject jSONObject = new JSONObject();
        jb.mb(jSONObject, EventConstants.ExtraJson.KEY_TYPE, "backup");
        int type = openAppResult.getType();
        if (type == 5) {
            mb(strMb, jSONObject, hVar, z2);
        } else {
            if (type != 6) {
                return;
            }
            jb.mb(jSONObject, "error_code", Integer.valueOf(openAppResult.mb()));
            jb.mb(jSONObject, EventConstants.ExtraJson.DOWNLOAD_SCENE, Integer.valueOf(hVar.gm()));
            AdEventHandler.mb().ox(EventConstants.Label.MARKET_OPEN_FAILED, jSONObject, hVar);
        }
    }

    public static boolean mb(long j2) {
        return com.ss.android.downloadlib.addownload.model.u.mb().hj(j2) == null;
    }
}
