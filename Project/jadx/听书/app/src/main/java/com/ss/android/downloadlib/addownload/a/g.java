package com.ss.android.downloadlib.addownload.a;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.e.i;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class g implements e {
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
        long jZ = com.ss.android.downloadlib.addownload.uy.z(dlVarG.e(), dlVarG.sf(), dlVarG.s());
        long jS = dlVarG.s();
        if (jZ >= 0 && jS > 0) {
            if (jS <= z(gVar.js())) {
                final int i2 = (int) (jZ / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
                z = new com.ss.android.downloadlib.addownload.z.a() { // from class: com.ss.android.downloadlib.addownload.a.g.1
                    @Override // com.ss.android.downloadlib.addownload.z.a
                    public void z() {
                        com.ss.android.downloadlib.addownload.z.a unused = g.z = null;
                        g.this.z(i2, i2, gVar, "apk_size_cancel", "confirm");
                    }

                    @Override // com.ss.android.downloadlib.addownload.z.a
                    public void g() {
                        com.ss.android.downloadlib.addownload.z.a unused = g.z = null;
                        g.this.z(i2, i2, gVar, "apk_size_cancel", "cancel");
                        gzVar.z(gVar);
                    }
                };
                String str = String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", i.z(jS - jZ));
                if (dlVar != null) {
                    z(new com.ss.android.downloadlib.addownload.z.dl() { // from class: com.ss.android.downloadlib.addownload.a.g.2
                        @Override // com.ss.android.downloadlib.addownload.z.dl
                        public void delete() {
                            com.ss.android.downloadlib.addownload.z.a unused = g.z = null;
                            g.this.z(i2, i2, gVar, "apk_size_cancel", "delete");
                            dlVar.delete();
                        }
                    });
                }
                TTDelegateActivity.z(gVar, str, "继续", "暂停", "删除");
                return true;
            }
        }
        return false;
    }

    private int z(int i) {
        return com.ss.android.socialbase.downloader.i.z.z(i).z("cancel_pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    private boolean z(com.ss.android.g.z.g.z zVar) {
        return com.ss.android.downloadlib.e.gc.z(zVar).z("cancel_pause_optimise_apk_retain_switch", 0) == 1 && zVar.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, int i2, com.ss.android.g.z.g.g gVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i2));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        com.ss.android.downloadlib.a.z.z().z("pause_cancel_optimise", jSONObject, gVar);
    }
}
