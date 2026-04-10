package com.ss.android.downloadlib.addownload.a;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class m implements fo {
    private static com.ss.android.downloadlib.addownload.z.a z;

    public static com.ss.android.downloadlib.addownload.z.a z() {
        return z;
    }

    @Override // com.ss.android.downloadlib.addownload.a.fo
    public boolean z(final com.ss.android.g.z.g.g gVar, int i, final gz gzVar) {
        com.ss.android.socialbase.downloader.e.dl dlVarG;
        if (gVar == null || gVar.lw() || !z(gVar)) {
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
        if (jSf > 0 && jS > 0) {
            int iZ = com.ss.android.downloadlib.addownload.uy.z(dlVarG.e(), (int) ((jSf * 100) / jS));
            if (iZ > z(gVar.js())) {
                z = new com.ss.android.downloadlib.addownload.z.a() { // from class: com.ss.android.downloadlib.addownload.a.m.1
                    @Override // com.ss.android.downloadlib.addownload.z.a
                    public void z() {
                        com.ss.android.downloadlib.addownload.z.a unused = m.z = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "confirm");
                        } catch (JSONException e) {
                            com.bytedance.sdk.component.utils.wp.z(e);
                        }
                        com.ss.android.downloadlib.a.z.z().z("pause_optimise", jSONObject, gVar);
                    }

                    @Override // com.ss.android.downloadlib.addownload.z.a
                    public void g() {
                        com.ss.android.downloadlib.addownload.z.a unused = m.z = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "cancel");
                        } catch (JSONException e) {
                            com.bytedance.sdk.component.utils.wp.z(e);
                        }
                        com.ss.android.downloadlib.a.z.z().z("pause_optimise", jSONObject, gVar);
                        gzVar.z(gVar);
                    }
                };
                TTDelegateActivity.g(gVar, String.format("已下载%s%%，即将下载完成，是否继续下载？", Integer.valueOf(iZ)), "继续", "暂停");
                gVar.pf(true);
                return true;
            }
        }
        return false;
    }

    private int z(int i) {
        return com.ss.android.socialbase.downloader.i.z.z(i).z("pause_optimise_download_percent", 50);
    }

    private boolean z(com.ss.android.g.z.g.z zVar) {
        return com.ss.android.downloadlib.e.gc.z(zVar).z("pause_optimise_download_percent_switch", 0) == 1 && zVar.p();
    }
}
