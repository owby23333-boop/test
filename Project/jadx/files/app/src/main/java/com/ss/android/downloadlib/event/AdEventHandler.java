package com.ss.android.downloadlib.event;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.ox;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.model.u;
import com.ss.android.downloadlib.addownload.model.ww;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.exception.b;
import com.ss.android.downloadlib.utils.h;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.appdownloader.u.hj;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AdEventHandler {

    /* JADX INFO: loaded from: classes.dex */
    public @interface EventType {
        public static final int CLICK_CONTINUE = 4;
        public static final int CLICK_INSTALL = 5;
        public static final int CLICK_PAUSE = 3;
        public static final int CLICK_START = 2;
        public static final int STORAGE_DENY = 1;
    }

    private static class mb {
        private static AdEventHandler mb = new AdEventHandler();
    }

    private AdEventHandler() {
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0055 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0010  */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String AdEventHandler1672829046082dc(java.lang.String r4) {
        /*
        L0:
            r0 = 74
            r1 = 55
        L4:
            r2 = 0
            switch(r0) {
                case 72: goto L0;
                case 73: goto L9;
                case 74: goto Lc;
                default: goto L8;
            }
        L8:
            goto L5a
        L9:
            switch(r1) {
                case 94: goto L55;
                case 95: goto L10;
                case 96: goto L3f;
                default: goto Lc;
            }
        Lc:
            switch(r1) {
                case 55: goto L55;
                case 56: goto L55;
                case 57: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L55
        L10:
            r0 = 18
            r1 = 1
            switch(r1) {
                case 60: goto L17;
                case 61: goto L25;
                case 62: goto L34;
                default: goto L16;
            }
        L16:
            goto L3f
        L17:
            int r3 = 0 - r1
            int r3 = r3 * 0
            r2 = 0
            int r2 = r2 * 2
            int r2 = r2 - r1
            int r3 = r3 * r2
            int r3 = r3 % 6
            if (r3 == 0) goto L0
        L25:
            int r2 = 18 - r1
            int r2 = r2 * 18
            r3 = 18
            int r3 = r3 * 2
            int r3 = r3 - r1
            int r2 = r2 * r3
            int r2 = r2 % 6
            if (r2 == 0) goto L55
        L34:
            r1 = 99
            int r1 = r1 * r1
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r1 = r1 - r0
            r0 = -1
            goto L0
        L3f:
            char[] r4 = r4.toCharArray()
        L43:
            int r0 = r4.length
            if (r2 >= r0) goto L4f
            char r0 = r4[r2]
            r0 = r0 ^ r2
            char r0 = (char) r0
            r4[r2] = r0
            int r2 = r2 + 1
            goto L43
        L4f:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
            return r0
        L55:
            r0 = 73
            r1 = 96
            goto L4
        L5a:
            r0 = 72
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.event.AdEventHandler.AdEventHandler1672829046082dc(java.lang.String):java.lang.String");
    }

    public static AdEventHandler mb() {
        return mb.mb;
    }

    private JSONObject mb(com.ss.android.downloadad.api.mb.mb mbVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jb.mb(mbVar.ko(), jSONObject);
            jb.mb(mbVar.io(), jSONObject);
            jSONObject.putOpt(EventConstants.ExtraJson.DOWNLOAD_URL, mbVar.mb());
            jSONObject.putOpt("package_name", mbVar.h());
            jSONObject.putOpt(EventConstants.ExtraJson.ANDROID_INT, Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt(EventConstants.ExtraJson.ROM_NAME, hj.ko());
            jSONObject.putOpt(EventConstants.ExtraJson.ROM_VERSION, hj.ww());
            jSONObject.putOpt(EventConstants.ExtraJson.TTDOWNLOADER, 1);
            jSONObject.putOpt(EventConstants.ExtraJson.FUNNEL_TYPE, Integer.valueOf(mbVar.ww()));
            if (mbVar.ww() == 2) {
                h.ox(jSONObject, mbVar);
            }
        } catch (Exception e2) {
            x.m().mb(e2, "getBaseJson");
        }
        return jSONObject;
    }

    private void mb(com.ss.android.download.api.model.ox oxVar) {
        if (x.mb() == null) {
            return;
        }
        if (oxVar.nk()) {
            x.mb().mb(oxVar);
        } else {
            x.mb().ox(oxVar);
        }
    }

    private void mb(String str, String str2, JSONObject jSONObject, long j2, int i2, com.ss.android.downloadad.api.mb.mb mbVar) {
        b bVarMb;
        String str3;
        if (mbVar == null) {
            bVarMb = b.mb();
            str3 = "onEvent data null";
        } else {
            if (!(mbVar instanceof com.ss.android.downloadlib.addownload.model.h) || !((com.ss.android.downloadlib.addownload.model.h) mbVar).on()) {
                try {
                    ox.mb mbVarB = new ox.mb().mb(jb.mb(str, mbVar.x(), EventConstants.Tag.EMBEDED_AD)).ox(str2).ox(mbVar.b()).mb(mbVar.ox()).b(mbVar.hj());
                    if (j2 <= 0) {
                        j2 = mbVar.je();
                    }
                    ox.mb mbVarMb = mbVarB.ox(j2).hj(mbVar.lz()).mb(mbVar.o()).mb(jb.mb(mb(mbVar), jSONObject)).ox(mbVar.jb()).mb(mbVar.lc());
                    if (i2 <= 0) {
                        i2 = 2;
                    }
                    mb(mbVarMb.mb(i2).mb(mbVar.nk()).mb());
                    return;
                } catch (Exception e2) {
                    b.mb().mb(e2, "onEvent");
                    return;
                }
            }
            bVarMb = b.mb();
            str3 = "onEvent ModelBox notValid";
        }
        bVarMb.mb(str3);
    }

    public void mb(long j2, int i2) {
        com.ss.android.downloadlib.addownload.model.h hVarH = u.mb().h(j2);
        if (hVarH.on()) {
            b.mb().mb("sendClickEvent ModelBox notValid");
            return;
        }
        if (hVarH.b.isEnableClickEvent()) {
            int i3 = 1;
            DownloadEventConfig downloadEventConfig = hVarH.b;
            String clickItemTag = i2 == 1 ? downloadEventConfig.getClickItemTag() : downloadEventConfig.getClickButtonTag();
            String strMb = jb.mb(hVarH.b.getClickLabel(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(EventConstants.ExtraJson.CLICK_TYPE, Integer.valueOf(i2));
                jSONObject.putOpt(EventConstants.ExtraJson.PERMISSION_NOTIFICATION, Integer.valueOf(com.ss.android.socialbase.appdownloader.h.hj.mb() ? 1 : 2));
                if (!DownloadUtils.isNetworkConnected(x.getContext())) {
                    i3 = 2;
                }
                jSONObject.putOpt(EventConstants.ExtraJson.NETWORK_AVAILABLE, Integer.valueOf(i3));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            mb(clickItemTag, strMb, jSONObject, hVarH);
            if (!"click".equals(strMb) || hVarH.ox == null) {
                return;
            }
            ox.mb().mb(j2, hVarH.ox.getLogExtra());
        }
    }

    public void mb(long j2, @EventType int i2, DownloadInfo downloadInfo) {
        com.ss.android.downloadlib.addownload.model.h hVarH = u.mb().h(j2);
        if (hVarH.on()) {
            b.mb().mb("sendEvent ModelBox notValid");
            return;
        }
        String strMb = null;
        JSONObject jSONObject = new JSONObject();
        jb.mb(jSONObject, EventConstants.ExtraJson.DOWNLOAD_SCENE, Integer.valueOf(hVarH.gm()));
        if (i2 == 1) {
            strMb = jb.mb(hVarH.b.getStorageDenyLabel(), EventConstants.Label.STORAGE_DENY);
        } else if (i2 == 2) {
            strMb = jb.mb(hVarH.b.getClickStartLabel(), EventConstants.Label.CLICK_START);
            h.mb(downloadInfo, jSONObject);
        } else if (i2 == 3) {
            strMb = jb.mb(hVarH.b.getClickPauseLabel(), EventConstants.Label.CLICK_PAUSE);
            h.ox(downloadInfo, jSONObject);
        } else if (i2 == 4) {
            strMb = jb.mb(hVarH.b.getClickContinueLabel(), EventConstants.Label.CLICK_CONTINUE);
            h.b(downloadInfo, jSONObject);
        } else if (i2 == 5) {
            if (downloadInfo != null) {
                try {
                    h.mb(jSONObject, downloadInfo.getId());
                    com.ss.android.downloadlib.mb.ox(jSONObject, downloadInfo);
                } catch (Throwable unused) {
                }
            }
            strMb = jb.mb(hVarH.b.getClickInstallLabel(), EventConstants.Label.CLICK_INSTALL);
        }
        mb(null, strMb, jSONObject, 0L, 1, hVarH);
    }

    public void mb(long j2, BaseException baseException) {
        com.ss.android.downloadlib.addownload.model.h hVarH = u.mb().h(j2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", 0);
            if (baseException != null) {
                jSONObject.putOpt(EventConstants.ExtraJson.FAIL_STATUS, Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt(EventConstants.ExtraJson.FAIL_MSG, baseException.getErrorMessage());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        ox(EventConstants.Label.DOWNLOAD_FAILED, jSONObject, hVarH);
    }

    public void mb(long j2, boolean z2, int i2) {
        com.ss.android.downloadlib.addownload.model.h hVarH = u.mb().h(j2);
        if (hVarH.on()) {
            b.mb().mb("sendQuickAppEvent ModelBox notValid");
            return;
        }
        if (hVarH.ox.getQuickAppModel() == null) {
            return;
        }
        DownloadModel downloadModel = hVarH.ox;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(EventConstants.ExtraJson.CLICK_TYPE, Integer.valueOf(i2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        ox(z2 ? EventConstants.Label.DEEPLINK_QUICKAPP_SUCCESS : EventConstants.Label.DEEPLINK_QUICKAPP_FAILED, jSONObject, hVarH);
    }

    public void mb(DownloadInfo downloadInfo) {
        com.ss.android.downloadad.api.mb.ox oxVarMb = u.mb().mb(downloadInfo);
        if (oxVarMb == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            h.b(downloadInfo, jSONObject);
            oxVarMb.mb(System.currentTimeMillis());
            mb(oxVarMb.x(), EventConstants.Label.DOWNLOAD_RESUME, jSONObject, oxVarMb);
            ww.mb().mb(oxVarMb);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void mb(DownloadInfo downloadInfo, BaseException baseException) {
        com.ss.android.downloadad.api.mb.ox oxVarMb;
        if (downloadInfo == null || (oxVarMb = u.mb().mb(downloadInfo)) == null || oxVarMb.b.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.mb.mb(jSONObject, downloadInfo);
            jSONObject.putOpt(EventConstants.ExtraJson.FAIL_STATUS, Integer.valueOf(oxVarMb.fu()));
            jSONObject.putOpt(EventConstants.ExtraJson.FAIL_MSG, oxVarMb.ep());
            jSONObject.put(EventConstants.ExtraJson.KEY_DOWNLOAD_FAILED_TIMES, oxVarMb.on());
            if (downloadInfo.getTotalBytes() > 0) {
                double curBytes = downloadInfo.getCurBytes();
                double totalBytes = downloadInfo.getTotalBytes();
                Double.isNaN(curBytes);
                Double.isNaN(totalBytes);
                jSONObject.put("download_percent", curBytes / totalBytes);
            }
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (oxVarMb.wn() > 0) {
                jSONObject.put(EventConstants.ExtraJson.KEY_TIME_FROM_START_DOWNLOAD, jCurrentTimeMillis - oxVarMb.wn());
            }
            if (oxVarMb.ge() > 0) {
                jSONObject.put(EventConstants.ExtraJson.KEY_TIME_FROM_DOWNLOAD_RESUME, jCurrentTimeMillis - oxVarMb.ge());
            }
            int i2 = 1;
            jSONObject.put(EventConstants.ExtraJson.KEY_IS_UPDATE_DOWNLOAD, oxVarMb.qa() ? 1 : 2);
            jSONObject.put(EventConstants.ExtraJson.KEY_CAN_SHOW_NOTIFICATION, com.ss.android.socialbase.appdownloader.h.hj.mb() ? 1 : 2);
            if (!oxVarMb.hj.get()) {
                i2 = 2;
            }
            jSONObject.put(EventConstants.ExtraJson.KEY_HAS_SEND_DOWNLOAD_FAILED_FINALLY, i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        mb(oxVarMb.x(), EventConstants.Label.DOWNLOAD_CANCEL, jSONObject, oxVarMb);
    }

    public void mb(String str, int i2, com.ss.android.downloadlib.addownload.model.h hVar) {
        mb(null, str, null, i2, 0, hVar);
    }

    public void mb(String str, long j2) {
        com.ss.android.downloadad.api.mb.ox oxVarHj = u.mb().hj(j2);
        if (oxVarHj != null) {
            ox(str, oxVarHj);
        } else {
            ox(str, u.mb().h(j2));
        }
    }

    public void mb(String str, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        ox(str, new com.ss.android.downloadlib.addownload.model.h(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
    }

    public void mb(String str, com.ss.android.downloadad.api.mb.mb mbVar) {
        mb(str, (JSONObject) null, mbVar);
    }

    public void mb(String str, String str2, com.ss.android.downloadad.api.mb.mb mbVar) {
        mb(str, str2, (JSONObject) null, mbVar);
    }

    public void mb(String str, String str2, JSONObject jSONObject, com.ss.android.downloadad.api.mb.mb mbVar) {
        mb(str, str2, jSONObject, 0L, 0, mbVar);
    }

    public void mb(String str, JSONObject jSONObject, long j2) {
        com.ss.android.downloadad.api.mb.mb mbVarHj = u.mb().hj(j2);
        if (mbVarHj != null) {
            mb(str, jSONObject, mbVarHj);
            return;
        }
        com.ss.android.downloadlib.addownload.model.h hVarH = u.mb().h(j2);
        if (hVarH.on()) {
            b.mb().mb("sendUnityEvent ModelBox notValid");
        } else {
            mb(str, jSONObject, hVarH);
        }
    }

    public void mb(String str, JSONObject jSONObject, com.ss.android.downloadad.api.mb.mb mbVar) {
        JSONObject jSONObject2 = new JSONObject();
        jb.mb(jSONObject2, EventConstants.ExtraJson.UNITY_LABEL, str);
        mb(EventConstants.Tag.EMBEDED_AD, EventConstants.Label.UNITY, jb.mb(jSONObject, jSONObject2), mbVar);
    }

    public void mb(JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.mb.ox oxVar) {
        mb(oxVar.x(), EventConstants.Label.INSTALL_FINISH, jSONObject, oxVar);
    }

    public void ox(long j2, @EventType int i2) {
        mb(j2, i2, (DownloadInfo) null);
    }

    public void ox(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadad.api.mb.ox oxVarMb = u.mb().mb(downloadInfo);
        if (oxVarMb == null) {
            b.mb().mb("sendDownloadFailedEvent nativeModel null");
            return;
        }
        if (oxVarMb.b.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            h.b(downloadInfo, jSONObject);
            com.ss.android.downloadlib.mb.mb(jSONObject, downloadInfo);
            if (baseException != null) {
                jSONObject.putOpt(EventConstants.ExtraJson.FAIL_STATUS, Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt(EventConstants.ExtraJson.FAIL_MSG, baseException.getErrorMessage());
                oxVarMb.hj(baseException.getErrorCode());
                oxVarMb.mb(baseException.getErrorMessage());
            }
            oxVarMb.jq();
            jSONObject.put(EventConstants.ExtraJson.KEY_DOWNLOAD_FAILED_TIMES, oxVarMb.on());
            if (downloadInfo.getTotalBytes() > 0) {
                double curBytes = downloadInfo.getCurBytes();
                double totalBytes = downloadInfo.getTotalBytes();
                Double.isNaN(curBytes);
                Double.isNaN(totalBytes);
                jSONObject.put("download_percent", curBytes / totalBytes);
            }
            int i2 = 1;
            jSONObject.put(EventConstants.ExtraJson.KEY_HAS_SEND_DOWNLOAD_FAILED_FINALLY, oxVarMb.hj.get() ? 1 : 2);
            h.mb(oxVarMb, jSONObject);
            if (!oxVarMb.qa()) {
                i2 = 2;
            }
            jSONObject.put(EventConstants.ExtraJson.KEY_IS_UPDATE_DOWNLOAD, i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        mb(oxVarMb.x(), EventConstants.Label.DOWNLOAD_FAILED, jSONObject, oxVarMb);
        ww.mb().mb(oxVarMb);
    }

    public void ox(String str, com.ss.android.downloadad.api.mb.mb mbVar) {
        mb((String) null, str, mbVar);
    }

    public void ox(String str, JSONObject jSONObject, com.ss.android.downloadad.api.mb.mb mbVar) {
        mb((String) null, str, jSONObject, mbVar);
    }
}
