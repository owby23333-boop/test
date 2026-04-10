package com.ss.android.downloadlib.addownload.ox;

import com.ss.android.downloadlib.addownload.model.u;
import com.ss.android.downloadlib.addownload.model.ww;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ox implements Runnable {
    private DownloadInfo mb;

    public ox(DownloadInfo downloadInfo) {
        this.mb = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        final com.ss.android.downloadad.api.mb.ox oxVarMb;
        if (this.mb == null || (oxVarMb = u.mb().mb(this.mb)) == null) {
            return;
        }
        AdEventHandler.mb().mb(EventConstants.UnityLabel.CLEAN_SPACE_TASK, oxVarMb);
        double dMb = com.ss.android.downloadlib.utils.hj.mb(this.mb.getId()) + 1.0d;
        double totalBytes = this.mb.getTotalBytes();
        Double.isNaN(totalBytes);
        long jLongValue = Double.valueOf(dMb * totalBytes).longValue() - this.mb.getCurBytes();
        long jMb = jb.mb(0L);
        if (x.je() != null) {
            x.je().h();
        }
        b.mb();
        b.ox();
        if (com.ss.android.downloadlib.utils.hj.ko(oxVarMb.m())) {
            b.mb(x.getContext());
        }
        long jMb2 = jb.mb(0L);
        if (jMb2 >= jLongValue) {
            oxVarMb.je("1");
            ww.mb().mb(oxVarMb);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(EventConstants.ExtraJson.QUITE_CLEAN_SIZE, Long.valueOf(jMb2 - jMb));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            AdEventHandler.mb().mb(EventConstants.UnityLabel.DOWNLOAD_AFTER_QUITE_CLEAN, jSONObject, oxVarMb);
            Downloader.getInstance(x.getContext()).restart(this.mb.getId());
            return;
        }
        if (x.je() != null) {
            oxVarMb.hj(false);
            hj.mb().mb(oxVarMb.mb(), new h() { // from class: com.ss.android.downloadlib.addownload.ox.ox.1
            });
            if (x.je().mb(this.mb.getId(), this.mb.getUrl(), true, jLongValue)) {
                oxVarMb.h(true);
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt(EventConstants.ExtraJson.CLEAN_SHOW_DIALOG_RESULT, 3);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        AdEventHandler.mb().mb(EventConstants.UnityLabel.CLEAN_SHOW_DIALOG, jSONObject2, oxVarMb);
    }
}
