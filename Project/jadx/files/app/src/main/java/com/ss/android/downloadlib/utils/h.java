package com.ss.android.downloadlib.utils;

import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.appdownloader.ko;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class h {
    public static void b(DownloadInfo downloadInfo, JSONObject jSONObject) {
        if (downloadInfo != null) {
            try {
                jSONObject.putOpt("total_bytes", Long.valueOf(downloadInfo.getTotalBytes()));
                jSONObject.putOpt("cur_bytes", Long.valueOf(downloadInfo.getCurBytes()));
                jSONObject.putOpt("chunk_count", Integer.valueOf(downloadInfo.getChunkCount()));
                jSONObject.putOpt("app_name", downloadInfo.getTitle());
                jSONObject.putOpt("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.putOpt("save_path", downloadInfo.getSavePath());
                jSONObject.putOpt(EventConstants.ExtraJson.FILE_NAME, downloadInfo.getName());
                jSONObject.putOpt("download_status", Integer.valueOf(downloadInfo.getRealStatus()));
                com.ss.android.downloadad.api.mb.ox oxVarMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo.getId());
                if (oxVarMb != null) {
                    jSONObject.putOpt(EventConstants.ExtraJson.CLICK_DOWNLOAD_TIME, Long.valueOf(oxVarMb.sa()));
                    jSONObject.putOpt(EventConstants.ExtraJson.CLICK_DOWNLOAD_SIZE, Long.valueOf(oxVarMb.sr()));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        int i2 = 1;
        jSONObject.putOpt(EventConstants.ExtraJson.PERMISSION_NOTIFICATION, Integer.valueOf(com.ss.android.socialbase.appdownloader.h.hj.mb() ? 1 : 2));
        jSONObject.putOpt(EventConstants.ExtraJson.NETWORK_AVAILABLE, Integer.valueOf(DownloadUtils.isNetworkConnected(com.ss.android.downloadlib.addownload.x.getContext()) ? 1 : 2));
        if (!DownloadUtils.isWifi(com.ss.android.downloadlib.addownload.x.getContext())) {
            i2 = 2;
        }
        jSONObject.putOpt(EventConstants.ExtraJson.NETWORK_IS_WIFI, Integer.valueOf(i2));
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
    public static java.lang.String h1672829046082dc(java.lang.String r4) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.utils.h.h1672829046082dc(java.lang.String):java.lang.String");
    }

    public static JSONObject mb(@NonNull JSONObject jSONObject, com.ss.android.downloadad.api.mb.mb mbVar) {
        jb.mb(jSONObject, EventConstants.ExtraJson.OPEN_URL, jb.mb(mbVar.u(), "open_url_not_exist"));
        return jSONObject;
    }

    public static void mb(com.ss.android.downloadad.api.mb.ox oxVar, JSONObject jSONObject) {
        if (jSONObject == null || oxVar == null) {
            return;
        }
        try {
            jSONObject.put(EventConstants.ExtraJson.KEY_IS_PATCH_APPLY_HANDLED, oxVar.n() ? 1 : 0);
            jSONObject.put(EventConstants.ExtraJson.KEY_ORIGIN_MIME_TYPE, oxVar.tl());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void mb(DownloadInfo downloadInfo, JSONObject jSONObject) {
        try {
            b(downloadInfo, jSONObject);
            com.ss.android.downloadad.api.mb.ox oxVarMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
            if (oxVarMb == null) {
                return;
            }
            jSONObject.put(EventConstants.ExtraJson.KEY_IS_UPDATE_DOWNLOAD, oxVarMb.qa() ? 1 : 2);
            mb(oxVarMb, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void mb(JSONObject jSONObject, int i2) {
        if (jSONObject == null) {
            return;
        }
        JSONArray jSONArrayOptJSONArray = DownloadSetting.obtain(i2).optJSONArray("ah_report_config");
        if (jSONArrayOptJSONArray != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                try {
                    String string = jSONArrayOptJSONArray.getString(i3);
                    ko.mb mbVarMb = com.ss.android.socialbase.appdownloader.u.mb.mb(string);
                    if (mbVarMb != null) {
                        jSONObject.put(string.replaceAll("\\.", "_"), mbVarMb.u() + "_" + mbVarMb.ko());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        try {
            jSONObject.put(EventConstants.ExtraJson.KEY_IS_UNKNOWN_SOURCE_ENABLED, com.ss.android.socialbase.appdownloader.ox.mb(DownloadComponentManager.getAppContext()) ? 1 : 2);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject ox(@NonNull JSONObject jSONObject, com.ss.android.downloadad.api.mb.mb mbVar) {
        jb.mb(jSONObject, com.ss.android.socialbase.appdownloader.u.hj.lz().replaceAll("\\.", "_"), Integer.valueOf(jb.ox(com.ss.android.downloadlib.addownload.x.getContext(), com.ss.android.socialbase.appdownloader.u.hj.lz())));
        return jSONObject;
    }

    public static void ox(DownloadInfo downloadInfo, JSONObject jSONObject) {
        com.ss.android.downloadad.api.mb.ox oxVarMb;
        double d2;
        if (jSONObject == null || (oxVarMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo)) == null) {
            return;
        }
        try {
            b(downloadInfo, jSONObject);
            jSONObject.putOpt(EventConstants.ExtraJson.TIME_AFTER_CLICK, Long.valueOf(System.currentTimeMillis() - oxVarMb.sa()));
            jSONObject.putOpt(EventConstants.ExtraJson.CLICK_DOWNLOAD_SIZE, Long.valueOf(oxVarMb.sr()));
            jSONObject.putOpt(EventConstants.ExtraJson.DOWNLOAD_LENGTH, Long.valueOf(downloadInfo.getCurBytes()));
            jSONObject.putOpt(EventConstants.ExtraJson.DOWNLOAD_APK_SIZE, Long.valueOf(downloadInfo.getTotalBytes()));
            oxVarMb.ng();
            com.ss.android.downloadlib.addownload.model.ww.mb().mb(oxVarMb);
            jSONObject.put(EventConstants.ExtraJson.KEY_CLICK_PAUSE_TIMES, oxVarMb.a());
            long totalBytes = downloadInfo.getTotalBytes();
            long curBytes = downloadInfo.getCurBytes();
            if (curBytes < 0 || totalBytes <= 0) {
                d2 = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
            } else {
                double d3 = curBytes;
                double d4 = totalBytes;
                Double.isNaN(d3);
                Double.isNaN(d4);
                d2 = d3 / d4;
            }
            jSONObject.put("download_percent", d2);
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jWn = oxVarMb.wn();
            if (jWn > 0) {
                jSONObject.put(EventConstants.ExtraJson.KEY_TIME_FROM_START_DOWNLOAD, jCurrentTimeMillis - jWn);
            }
            long jGe = oxVarMb.ge();
            if (jGe > 0) {
                jSONObject.put(EventConstants.ExtraJson.KEY_TIME_FROM_DOWNLOAD_RESUME, jCurrentTimeMillis - jGe);
            }
            jSONObject.putOpt(EventConstants.ExtraJson.FAIL_STATUS, Integer.valueOf(oxVarMb.fu()));
            jSONObject.putOpt(EventConstants.ExtraJson.FAIL_MSG, oxVarMb.ep());
            jSONObject.put(EventConstants.ExtraJson.KEY_DOWNLOAD_FAILED_TIMES, oxVarMb.on());
            jSONObject.put(EventConstants.ExtraJson.KEY_CAN_SHOW_NOTIFICATION, com.ss.android.socialbase.appdownloader.h.hj.mb() ? 1 : 2);
            jSONObject.put(EventConstants.ExtraJson.KEY_FIRST_SPEED_TIME, downloadInfo.getFirstSpeedTime());
            jSONObject.put(EventConstants.ExtraJson.KEY_ALL_CONNECT_TIME, downloadInfo.getAllConnectTime());
            jSONObject.put(EventConstants.ExtraJson.KEY_DOWNLOAD_PREPARE_TIME, downloadInfo.getDownloadPrepareTime());
            jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
