package com.ss.android.downloadlib.addownload.a;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.e.i;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class z implements fo {
    private static com.ss.android.downloadlib.addownload.z.a z;

    public static com.ss.android.downloadlib.addownload.z.a z() {
        return z;
    }

    @Override // com.ss.android.downloadlib.addownload.a.fo
    public boolean z(final com.ss.android.g.z.g.g gVar, int i, final gz gzVar) {
        com.ss.android.socialbase.downloader.e.dl dlVarG;
        if (gVar == null || gVar.b() || !z(gVar)) {
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
        if (jZ <= 0 || jS <= 0 || jS > z(gVar.js())) {
            return false;
        }
        z = new com.ss.android.downloadlib.addownload.z.a() { // from class: com.ss.android.downloadlib.addownload.a.z.1
            @Override // com.ss.android.downloadlib.addownload.z.a
            public void z() {
                com.ss.android.downloadlib.addownload.z.a unused = z.z = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "confirm");
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
                com.ss.android.downloadlib.a.z.z().z("pause_optimise", jSONObject, gVar);
            }

            @Override // com.ss.android.downloadlib.addownload.z.a
            public void g() {
                com.ss.android.downloadlib.addownload.z.a unused = z.z = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "cancel");
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
                com.ss.android.downloadlib.a.z.z().z("pause_optimise", jSONObject, gVar);
                gzVar.z(gVar);
            }
        };
        TTDelegateActivity.z(gVar, String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", i.z(jS - jZ)), "继续", "暂停");
        gVar.v(true);
        return true;
    }

    private int z(int i) {
        return com.ss.android.socialbase.downloader.i.z.z(i).z("pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    private boolean z(com.ss.android.g.z.g.z zVar) {
        return com.ss.android.downloadlib.e.gc.z(zVar).z("pause_optimise_apk_size_switch", 0) == 1 && zVar.p();
    }
}
