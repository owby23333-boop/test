package com.ss.android.downloadlib.addownload.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class u {
    private final ConcurrentHashMap<Long, DownloadEventConfig> b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ConcurrentHashMap<Long, com.ss.android.downloadad.api.mb.ox> f18013h;
    private final ConcurrentHashMap<Long, DownloadController> hj;
    private volatile boolean mb;
    private final ConcurrentHashMap<Long, DownloadModel> ox;

    private static class mb {
        private static u mb = new u();
    }

    public DownloadController b(long j2) {
        return this.hj.get(Long.valueOf(j2));
    }

    @NonNull
    public h h(long j2) {
        h hVar = new h();
        hVar.mb = j2;
        hVar.ox = mb(j2);
        hVar.b = ox(j2);
        if (hVar.b == null) {
            hVar.b = new com.ss.android.download.api.download.b();
        }
        hVar.hj = b(j2);
        if (hVar.hj == null) {
            hVar.hj = new com.ss.android.download.api.download.ox();
        }
        return hVar;
    }

    public com.ss.android.downloadad.api.mb.ox hj(long j2) {
        return this.f18013h.get(Long.valueOf(j2));
    }

    public void u(long j2) {
        this.ox.remove(Long.valueOf(j2));
        this.b.remove(Long.valueOf(j2));
        this.hj.remove(Long.valueOf(j2));
    }

    private u() {
        this.mb = false;
        this.ox = new ConcurrentHashMap<>();
        this.b = new ConcurrentHashMap<>();
        this.hj = new ConcurrentHashMap<>();
        this.f18013h = new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.mb.ox> b() {
        return this.f18013h;
    }

    public void ox() {
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.addownload.model.u.1
            @Override // java.lang.Runnable
            public void run() {
                if (u.this.mb) {
                    return;
                }
                synchronized (u.class) {
                    if (!u.this.mb) {
                        u.this.f18013h.putAll(ww.mb().ox());
                        u.this.mb = true;
                    }
                }
            }
        }, true);
    }

    public static u mb() {
        return mb.mb;
    }

    public DownloadEventConfig ox(long j2) {
        return this.b.get(Long.valueOf(j2));
    }

    public void mb(DownloadModel downloadModel) {
        if (downloadModel != null) {
            this.ox.put(Long.valueOf(downloadModel.getId()), downloadModel);
            if (downloadModel.getDeepLink() != null) {
                downloadModel.getDeepLink().setId(downloadModel.getId());
                downloadModel.getDeepLink().setPackageName(downloadModel.getPackageName());
            }
        }
    }

    public com.ss.android.downloadad.api.mb.ox ox(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.mb.ox oxVar : this.f18013h.values()) {
            if (oxVar != null && str.equals(oxVar.mb())) {
                return oxVar;
            }
        }
        return null;
    }

    public void ox(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (DownloadModel downloadModel : this.ox.values()) {
            if ((downloadModel instanceof AdDownloadModel) && TextUtils.equals(downloadModel.getDownloadUrl(), str)) {
                ((AdDownloadModel) downloadModel).setPackageName(str2);
            }
        }
    }

    public void mb(long j2, DownloadEventConfig downloadEventConfig) {
        if (downloadEventConfig != null) {
            this.b.put(Long.valueOf(j2), downloadEventConfig);
        }
    }

    public void mb(long j2, DownloadController downloadController) {
        if (downloadController != null) {
            this.hj.put(Long.valueOf(j2), downloadController);
        }
    }

    public synchronized void mb(com.ss.android.downloadad.api.mb.ox oxVar) {
        if (oxVar == null) {
            return;
        }
        this.f18013h.put(Long.valueOf(oxVar.ox()), oxVar);
        ww.mb().mb(oxVar);
    }

    public DownloadModel mb(long j2) {
        return this.ox.get(Long.valueOf(j2));
    }

    public com.ss.android.downloadad.api.mb.ox mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.mb.ox oxVar : this.f18013h.values()) {
            if (oxVar != null && str.equals(oxVar.h())) {
                return oxVar;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.mb.ox mb(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        for (com.ss.android.downloadad.api.mb.ox oxVar : this.f18013h.values()) {
            if (oxVar != null && oxVar.m() == downloadInfo.getId()) {
                return oxVar;
            }
        }
        if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
            try {
                long jMb = jb.mb(new JSONObject(downloadInfo.getExtra()), "extra");
                if (jMb != 0) {
                    for (com.ss.android.downloadad.api.mb.ox oxVar2 : this.f18013h.values()) {
                        if (oxVar2 != null && oxVar2.ox() == jMb) {
                            return oxVar2;
                        }
                    }
                    com.ss.android.downloadlib.exception.b.mb().mb("getNativeModelByInfo");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        for (com.ss.android.downloadad.api.mb.ox oxVar3 : this.f18013h.values()) {
            if (oxVar3 != null && TextUtils.equals(oxVar3.mb(), downloadInfo.getUrl())) {
                return oxVar3;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.mb.ox mb(int i2) {
        for (com.ss.android.downloadad.api.mb.ox oxVar : this.f18013h.values()) {
            if (oxVar != null && oxVar.m() == i2) {
                return oxVar;
            }
        }
        return null;
    }

    @NonNull
    public Map<Long, com.ss.android.downloadad.api.mb.ox> mb(String str, String str2) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (com.ss.android.downloadad.api.mb.ox oxVar : this.f18013h.values()) {
                if (oxVar != null && TextUtils.equals(oxVar.mb(), str)) {
                    oxVar.ox(str2);
                    map.put(Long.valueOf(oxVar.ox()), oxVar);
                }
            }
        }
        return map;
    }

    public synchronized void mb(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            arrayList.add(String.valueOf(jLongValue));
            this.f18013h.remove(Long.valueOf(jLongValue));
        }
        ww.mb().mb((List<String>) arrayList);
    }
}
