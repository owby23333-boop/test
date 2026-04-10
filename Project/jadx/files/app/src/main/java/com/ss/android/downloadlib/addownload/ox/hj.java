package com.ss.android.downloadlib.addownload.ox;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class hj {
    private static volatile hj mb;
    private long ox = 0;
    private ConcurrentHashMap<String, h> b = new ConcurrentHashMap<>();
    private HashMap<String, Integer> hj = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<String> f18014h = new CopyOnWriteArrayList();

    public static hj mb() {
        if (mb == null) {
            synchronized (hj.class) {
                if (mb == null) {
                    mb = new hj();
                }
            }
        }
        return mb;
    }

    void b() {
        this.ox = System.currentTimeMillis();
    }

    long ox() {
        return this.ox;
    }

    public int ox(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.hj == null) {
            this.hj = new HashMap<>();
        }
        if (this.hj.containsKey(str)) {
            return this.hj.get(str).intValue();
        }
        return 0;
    }

    public void mb(String str, h hVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.put(str, hVar);
    }

    public void mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.remove(str);
    }

    @WorkerThread
    public static void mb(com.ss.android.downloadad.api.mb.ox oxVar) {
        DownloadInfo downloadInfo;
        if (oxVar == null || oxVar.ox() <= 0 || (downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(oxVar.m())) == null) {
            return;
        }
        mb(downloadInfo);
    }

    @WorkerThread
    public static void mb(DownloadInfo downloadInfo) {
        if (downloadInfo == null || DownloadSetting.obtain(downloadInfo.getId()).optInt("delete_file_after_install", 0) == 0) {
            return;
        }
        try {
            String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
