package com.ss.android.downloadlib.addownload;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.h;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener;
import com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class hj {
    private AtomicBoolean b = new AtomicBoolean(false);
    private AtomicBoolean hj = new AtomicBoolean(false);
    private Handler mb;
    private com.ss.android.downloadlib.addownload.model.h ox;

    hj(Handler handler) {
        this.mb = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long hj() {
        return com.ss.android.downloadlib.utils.jb.mb(0L);
    }

    public static long ox() {
        if (x.je() != null) {
            return x.je().mb();
        }
        return 0L;
    }

    private void ox(com.ss.android.downloadad.api.mb.ox oxVar, JSONObject jSONObject, long j2, long j3) {
        oxVar.je("1");
        com.ss.android.downloadlib.addownload.model.ww.mb().mb(oxVar);
        try {
            jSONObject.putOpt(EventConstants.ExtraJson.QUITE_CLEAN_SIZE, Long.valueOf(j3 - j2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        AdEventHandler.mb().mb(EventConstants.UnityLabel.DOWNLOAD_AFTER_QUITE_CLEAN, jSONObject, oxVar);
    }

    public void mb(com.ss.android.downloadlib.addownload.model.h hVar) {
        this.ox = hVar;
    }

    public boolean mb() {
        return this.hj.get();
    }

    public void mb(boolean z2) {
        this.hj.set(z2);
    }

    void mb(final int i2, final long j2, long j3, final h.mb mbVar) {
        this.hj.set(false);
        if (mbVar == null) {
            return;
        }
        if (com.ss.android.downloadlib.utils.hj.u(i2) && com.ss.android.downloadlib.utils.hj.h(i2)) {
            long jB = com.ss.android.downloadlib.utils.hj.b(i2);
            this.b.set(false);
            final String downloadUrl = this.ox.ox.getDownloadUrl();
            com.ss.android.downloadad.api.mb.ox oxVarOx = com.ss.android.downloadlib.addownload.model.u.mb().ox(downloadUrl);
            if (oxVarOx == null) {
                com.ss.android.downloadlib.addownload.model.h hVar = this.ox;
                oxVarOx = new com.ss.android.downloadad.api.mb.ox(hVar.ox, hVar.b, hVar.hj, 0);
                com.ss.android.downloadlib.addownload.model.u.mb().mb(oxVarOx);
            }
            final com.ss.android.downloadad.api.mb.ox oxVar = oxVarOx;
            oxVar.h(false);
            if (x.je() != null) {
                x.je().mb(oxVar.ox());
            }
            com.ss.android.downloadlib.addownload.ox.hj.mb().mb(oxVar.mb());
            boolean zHj = com.ss.android.downloadlib.utils.hj.hj(i2);
            if (j3 > 0) {
                mb(i2, downloadUrl, j3, oxVar, j2, mbVar);
            } else if (zHj) {
                mb(downloadUrl, oxVar, new h.ox() { // from class: com.ss.android.downloadlib.addownload.hj.1
                    @Override // com.ss.android.downloadlib.addownload.h.ox
                    public void mb(long j4) throws Throwable {
                        hj.this.mb(i2, downloadUrl, j4, oxVar, j2, mbVar);
                    }
                });
            } else {
                jB = 0;
            }
            this.mb.postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.hj.2
                @Override // java.lang.Runnable
                public void run() {
                    if (hj.this.b.get()) {
                        return;
                    }
                    hj.this.b.set(true);
                    mbVar.mb();
                }
            }, jB);
            return;
        }
        mbVar.mb();
    }

    private void mb(String str, com.ss.android.downloadad.api.mb.ox oxVar, final h.ox oxVar2) {
        if (oxVar2 == null) {
            return;
        }
        DownloadPreconnecter.asyncFetchHttpHeadInfo(str, new IFetchHttpHeadInfoListener() { // from class: com.ss.android.downloadlib.addownload.hj.3
            @Override // com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener
            public void onFetchFinished(Map<String, String> map) {
                if (hj.this.b.get()) {
                    return;
                }
                hj.this.b.set(true);
                long jMb = hj.this.mb(map);
                if (jMb > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(EventConstants.ExtraJson.APK_SIZE, Long.valueOf(jMb));
                        jSONObject.putOpt("available_space", Long.valueOf(hj.hj()));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                oxVar2.mb(jMb);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long mb(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if ("content-length".equalsIgnoreCase(key)) {
                        return Long.parseLong(value);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(int i2, String str, long j2, final com.ss.android.downloadad.api.mb.ox oxVar, long j3, final h.mb mbVar) throws Throwable {
        this.b.set(true);
        boolean zMb = false;
        if (j2 > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(EventConstants.ExtraJson.APK_SIZE, Long.valueOf(j2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            double dMb = com.ss.android.downloadlib.utils.hj.mb(i2) + 1.0d;
            double d2 = j2;
            Double.isNaN(d2);
            long jLongValue = (Double.valueOf(dMb * d2).longValue() + com.ss.android.downloadlib.utils.hj.ox(i2)) - j3;
            long jHj = hj();
            if (jHj < jLongValue) {
                mb(oxVar, jSONObject, jLongValue, jHj);
                mb(oxVar);
                long jHj2 = hj();
                if (jHj2 < jLongValue) {
                    oxVar.hj(true);
                    final String strMb = oxVar.mb();
                    com.ss.android.downloadlib.addownload.ox.hj.mb().mb(strMb, new com.ss.android.downloadlib.addownload.ox.h() { // from class: com.ss.android.downloadlib.addownload.hj.4
                    });
                    zMb = mb(i2, oxVar, str, jLongValue);
                    if (zMb) {
                        oxVar.h(true);
                    }
                } else {
                    ox(oxVar, jSONObject, jHj, jHj2);
                }
            }
        }
        if (zMb) {
            return;
        }
        this.mb.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.hj.5
            @Override // java.lang.Runnable
            public void run() {
                mbVar.mb();
            }
        });
    }

    private boolean mb(int i2, @NonNull com.ss.android.downloadad.api.mb.ox oxVar, String str, long j2) {
        if (!com.ss.android.downloadlib.utils.hj.u(i2)) {
            return false;
        }
        if (x.je() != null) {
            return x.je().mb(i2, str, true, j2);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(EventConstants.ExtraJson.CLEAN_SHOW_DIALOG_RESULT, 3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        AdEventHandler.mb().mb(EventConstants.UnityLabel.CLEAN_SHOW_DIALOG, jSONObject, oxVar);
        return false;
    }

    public static boolean mb(final DownloadInfo downloadInfo, long j2) {
        int id = downloadInfo.getId();
        boolean zMb = false;
        if (!com.ss.android.downloadlib.utils.hj.u(id)) {
            return false;
        }
        if (x.je() != null && (zMb = x.je().mb(id, downloadInfo.getUrl(), false, j2))) {
            com.ss.android.downloadlib.addownload.ox.hj.mb().mb(downloadInfo.getUrl(), new com.ss.android.downloadlib.addownload.ox.h() { // from class: com.ss.android.downloadlib.addownload.hj.6
            });
        }
        return zMb;
    }

    public static JSONObject mb(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(EventConstants.ExtraJson.CLEAN_SPACE_INSTALL_PARAMS, str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static void mb(int i2) {
        if (com.ss.android.downloadlib.utils.hj.u(i2) && x.je() != null && x.je().ox()) {
            x.je().b();
        }
    }

    private static void mb(com.ss.android.downloadad.api.mb.ox oxVar) throws Throwable {
        long jHj = hj();
        if (x.je() != null) {
            x.je().h();
        }
        com.ss.android.downloadlib.addownload.ox.b.mb();
        com.ss.android.downloadlib.addownload.ox.b.ox();
        if (com.ss.android.downloadlib.utils.hj.ko(oxVar.m())) {
            com.ss.android.downloadlib.addownload.ox.b.mb(x.getContext());
        }
        long jHj2 = hj();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(EventConstants.ExtraJson.QUITE_CLEAN_SIZE, Long.valueOf(jHj2 - jHj));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        AdEventHandler.mb().mb(EventConstants.UnityLabel.CLEAN_QUITE_FINISH, jSONObject, oxVar);
    }

    private void mb(com.ss.android.downloadad.api.mb.ox oxVar, JSONObject jSONObject, long j2, long j3) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j3));
            jSONObject.putOpt(EventConstants.ExtraJson.APK_DOWNLOAD_NEED_SIZE, Long.valueOf(j2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        AdEventHandler.mb().mb(EventConstants.UnityLabel.CLEAN_SPACE_NO_ENOUGH, jSONObject, oxVar);
    }
}
