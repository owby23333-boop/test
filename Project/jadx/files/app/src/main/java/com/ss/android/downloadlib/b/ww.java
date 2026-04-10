package com.ss.android.downloadlib.b;

import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ww {

    private static class mb {
        private static ww mb = new ww();
    }

    private ww() {
    }

    private void b(@NonNull final com.ss.android.downloadad.api.mb.ox oxVar, long j2) {
        final int iM = oxVar.m();
        if (DownloadSetting.obtain(iM).optInt("notification_opt_2") != 1) {
            return;
        }
        mb(iM);
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.b.ww.2
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(iM);
                JSONObject jSONObject = new JSONObject();
                jb.mb(jSONObject, EventConstants.ExtraJson.KEY_TYPE, (Object) 2);
                com.ss.android.downloadlib.utils.h.b(downloadInfo, jSONObject);
                if (jb.ox(oxVar)) {
                    jb.mb(jSONObject, "error_code", (Object) 1002);
                } else {
                    ww.this.mb(iM, oxVar, jSONObject);
                }
                AdEventHandler.mb().ox(EventConstants.Label.NOTIFICATION_TRY_SHOW, jSONObject, oxVar);
            }
        }, j2 * 1000);
    }

    public static ww mb() {
        return mb.mb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(int i2, com.ss.android.downloadad.api.mb.ox oxVar, JSONObject jSONObject) {
        if (!com.ss.android.socialbase.appdownloader.h.hj.mb()) {
            jb.mb(jSONObject, "error_code", (Object) 1004);
            return;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(i2);
        if (downloadInfo == null) {
            jb.mb(jSONObject, "error_code", (Object) 1005);
            return;
        }
        if (DownloadNotificationManager.getInstance().getNotificationItem(i2) != null) {
            DownloadNotificationManager.getInstance().cancelNotification(i2);
        }
        com.ss.android.socialbase.appdownloader.h.mb mbVar = new com.ss.android.socialbase.appdownloader.h.mb(x.getContext(), i2, downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
        mbVar.setCurBytes(downloadInfo.getCurBytes());
        mbVar.setTotalBytes(downloadInfo.getTotalBytes());
        mbVar.refreshStatus(downloadInfo.getStatus(), null, false, false);
        DownloadNotificationManager.getInstance().addNotification(mbVar);
        mbVar.updateNotification(null, false);
        AdEventHandler.mb().ox(EventConstants.Label.NOTIFICATION_SHOW, jSONObject, oxVar);
    }

    private void ox(@NonNull final com.ss.android.downloadad.api.mb.ox oxVar, long j2) {
        final int iM = oxVar.m();
        if (DownloadSetting.obtain(iM).optInt("notification_opt_2") != 1) {
            return;
        }
        mb(iM);
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.b.ww.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(iM);
                JSONObject jSONObject = new JSONObject();
                jb.mb(jSONObject, EventConstants.ExtraJson.KEY_TYPE, (Object) 1);
                com.ss.android.downloadlib.utils.h.b(downloadInfo, jSONObject);
                if (downloadInfo == null || -2 != downloadInfo.getRealStatus() || downloadInfo.isPauseReserveOnWifi()) {
                    jb.mb(jSONObject, "error_code", (Object) 1001);
                } else {
                    ww.this.mb(iM, oxVar, jSONObject);
                }
                AdEventHandler.mb().ox(EventConstants.Label.NOTIFICATION_TRY_SHOW, jSONObject, oxVar);
            }
        }, j2 * 1000);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0013. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0009. Please report as an issue. */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public static java.lang.String ww1672829046017dc(java.lang.String r4) {
        /*
        L0:
            r0 = 73
            r1 = 96
        L4:
            r2 = 0
            switch(r0) {
                case 72: goto L55;
                case 73: goto L9;
                case 74: goto Lc;
                default: goto L8;
            }
        L8:
            goto L5a
        L9:
            switch(r1) {
                case 94: goto L0;
                case 95: goto L10;
                case 96: goto L55;
                default: goto Lc;
            }
        Lc:
            switch(r1) {
                case 55: goto L3f;
                case 56: goto L55;
                case 57: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L0
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
            goto L55
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
            r0 = 74
            r1 = 55
            goto L4
        L5a:
            r0 = 72
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.b.ww.ww1672829046017dc(java.lang.String):java.lang.String");
    }

    public void b(@NonNull com.ss.android.downloadad.api.mb.ox oxVar) {
        b(oxVar, 5L);
    }

    public void h(@NonNull com.ss.android.downloadad.api.mb.ox oxVar) {
        mb(oxVar, 5L);
    }

    public void hj(@NonNull com.ss.android.downloadad.api.mb.ox oxVar) {
        b(oxVar, DownloadSetting.obtain(oxVar.m()).optInt("noti_install_delay_secs", 5));
    }

    public void mb(int i2) {
        DownloadInfo downloadInfo;
        if (com.ss.android.socialbase.appdownloader.h.b.mb().mb(i2) != null || (downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(i2)) == null) {
            return;
        }
        com.ss.android.socialbase.appdownloader.h.b.mb().mb(i2, downloadInfo.getIconUrl());
    }

    public void mb(com.ss.android.downloadad.api.mb.ox oxVar) {
        ox(oxVar, 5L);
    }

    public void mb(@NonNull final com.ss.android.downloadad.api.mb.ox oxVar, long j2) {
        final int iM = oxVar.m();
        if (DownloadSetting.obtain(iM).optInt("notification_opt_2") != 1) {
            return;
        }
        mb(iM);
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.b.ww.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(iM);
                JSONObject jSONObject = new JSONObject();
                jb.mb(jSONObject, EventConstants.ExtraJson.KEY_TYPE, (Object) 3);
                com.ss.android.downloadlib.utils.h.b(downloadInfo, jSONObject);
                if (jb.b(oxVar.h())) {
                    jb.mb(jSONObject, "error_code", (Object) 1003);
                } else {
                    ww.this.mb(iM, oxVar, jSONObject);
                }
                AdEventHandler.mb().ox(EventConstants.Label.NOTIFICATION_TRY_SHOW, jSONObject, oxVar);
            }
        }, j2 * 1000);
    }

    public void ox(com.ss.android.downloadad.api.mb.ox oxVar) {
        if (oxVar == null) {
            return;
        }
        ox(oxVar, DownloadSetting.obtain(oxVar.m()).optInt("noti_continue_delay_secs", 5));
    }

    public void u(@NonNull com.ss.android.downloadad.api.mb.ox oxVar) {
        mb(oxVar, DownloadSetting.obtain(oxVar.m()).optInt("noti_open_delay_secs", 5));
    }
}
