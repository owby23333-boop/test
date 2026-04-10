package com.ss.android.downloadlib.addownload.b;

import android.content.Context;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.lz;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.ww;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ox implements hj {
    private static com.ss.android.downloadlib.addownload.mb.b mb;

    public static com.ss.android.downloadlib.addownload.mb.b mb() {
        return mb;
    }

    @Override // com.ss.android.downloadlib.addownload.b.hj
    public boolean mb(final com.ss.android.downloadad.api.mb.ox oxVar, int i2, final b bVar) {
        DownloadInfo downloadInfoOx;
        if (oxVar == null || oxVar.kg() || !mb(oxVar) || (downloadInfoOx = ww.mb((Context) null).ox(oxVar.mb())) == null) {
            return false;
        }
        long curBytes = downloadInfoOx.getCurBytes();
        long totalBytes = downloadInfoOx.getTotalBytes();
        if (curBytes > 0 && totalBytes > 0) {
            int iMb = lz.mb(downloadInfoOx.getId(), (int) ((curBytes * 100) / totalBytes));
            if (iMb > mb(oxVar.m())) {
                mb = new com.ss.android.downloadlib.addownload.mb.b() { // from class: com.ss.android.downloadlib.addownload.b.ox.1
                    @Override // com.ss.android.downloadlib.addownload.mb.b
                    public void mb() {
                        com.ss.android.downloadlib.addownload.mb.b unused = ox.mb = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_TYPE, "download_percent");
                            jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_ACTION, "confirm");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        AdEventHandler.mb().mb(EventConstants.UnityLabel.PAUSE_OPTIMISE, jSONObject, oxVar);
                    }

                    @Override // com.ss.android.downloadlib.addownload.mb.b
                    public void ox() {
                        com.ss.android.downloadlib.addownload.mb.b unused = ox.mb = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_TYPE, "download_percent");
                            jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_ACTION, com.anythink.expressad.d.a.b.dO);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        AdEventHandler.mb().mb(EventConstants.UnityLabel.PAUSE_OPTIMISE, jSONObject, oxVar);
                        bVar.mb(oxVar);
                    }
                };
                TTDelegateActivity.ox(oxVar, String.format("已下载%s%%，即将下载完成，是否继续下载？", Integer.valueOf(iMb)), "继续", "暂停");
                oxVar.lc(true);
                return true;
            }
        }
        return false;
    }

    private int mb(int i2) {
        return DownloadSetting.obtain(i2).optInt("pause_optimise_download_percent", 50);
    }

    private boolean mb(com.ss.android.downloadad.api.mb.mb mbVar) {
        return com.ss.android.downloadlib.utils.hj.mb(mbVar).optInt("pause_optimise_download_percent_switch", 0) == 1 && mbVar.e();
    }
}
