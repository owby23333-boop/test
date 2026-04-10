package com.ss.android.downloadlib.addownload.a;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.e.i;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class dl implements e {
    private static com.ss.android.downloadlib.addownload.z.dl g;
    private static com.ss.android.downloadlib.addownload.z.a z;

    public static com.ss.android.downloadlib.addownload.z.a z() {
        return z;
    }

    public static com.ss.android.downloadlib.addownload.z.dl g() {
        return g;
    }

    public static void z(com.ss.android.downloadlib.addownload.z.dl dlVar) {
        g = dlVar;
    }

    @Override // com.ss.android.downloadlib.addownload.a.e
    public boolean z(final com.ss.android.g.z.g.g gVar, int i, final gz gzVar, final com.ss.android.downloadlib.addownload.z.dl dlVar) {
        com.ss.android.socialbase.downloader.e.dl dlVarG;
        String str;
        if (gVar == null || !z(gVar)) {
            return false;
        }
        if (!TextUtils.isEmpty(gVar.tc())) {
            dlVarG = com.ss.android.downloadlib.uy.z(com.ss.android.downloadlib.addownload.wp.getContext()).z(gVar.tc(), null, true);
        } else {
            dlVarG = com.ss.android.downloadlib.uy.z(com.ss.android.downloadlib.addownload.wp.getContext()).g(gVar.z());
        }
        if (dlVarG == null) {
            return false;
        }
        long jSf = dlVarG.sf();
        long jS = dlVarG.s();
        if (jSf < 0 || jS <= 0) {
            return false;
        }
        final int iZ = com.ss.android.downloadlib.addownload.uy.z(dlVarG.e(), (int) ((100 * jSf) / jS));
        final int i2 = (int) (jSf / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        boolean z2 = iZ > z(gVar.js());
        z = new com.ss.android.downloadlib.addownload.z.a() { // from class: com.ss.android.downloadlib.addownload.a.dl.1
            @Override // com.ss.android.downloadlib.addownload.z.a
            public void z() {
                com.ss.android.downloadlib.addownload.z.a unused = dl.z = null;
                dl.this.z(iZ, i2, i2, gVar, "download_percent_cancel", "confirm");
            }

            @Override // com.ss.android.downloadlib.addownload.z.a
            public void g() {
                com.ss.android.downloadlib.addownload.z.a unused = dl.z = null;
                dl.this.z(iZ, i2, i2, gVar, "download_percent_cancel", "cancel");
                gzVar.z(gVar);
            }
        };
        String strZ = i.z(com.ss.android.downloadlib.addownload.uy.z(gVar.js(), jSf, jS));
        if (z2) {
            str = String.format("该任务已下载%s，仅需%s即可下载完成，是否继续？", strZ, i.z(jS - jSf));
        } else {
            str = String.format("该任务已下载%s，即将下载完成，是否继续下载？", strZ);
        }
        String str2 = str;
        if (dlVar != null) {
            z(new com.ss.android.downloadlib.addownload.z.dl() { // from class: com.ss.android.downloadlib.addownload.a.dl.2
                @Override // com.ss.android.downloadlib.addownload.z.dl
                public void delete() {
                    com.ss.android.downloadlib.addownload.z.a unused = dl.z = null;
                    dl.this.z(iZ, i2, i2, gVar, "download_percent_cancel", "delete");
                    dlVar.delete();
                }
            });
        }
        TTDelegateActivity.g(gVar, str2, "继续", "暂停", "删除");
        return true;
    }

    private int z(int i) {
        return com.ss.android.socialbase.downloader.i.z.z(i).z("cancel_pause_optimise_download_percent_value", 50);
    }

    private boolean z(com.ss.android.g.z.g.z zVar) {
        return com.ss.android.downloadlib.e.gc.z(zVar).z("cancel_pause_optimise_download_percent_retain_switch", 0) == 1 && zVar.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, int i2, int i3, com.ss.android.g.z.g.g gVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_percent", Integer.valueOf(i));
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i2));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i3));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        com.ss.android.downloadlib.a.z.z().z("pause_cancel_optimise", jSONObject, gVar);
    }
}
