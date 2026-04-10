package com.ss.android.downloadlib.addownload.dl;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.socialbase.downloader.downloader.e;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static volatile a z;
    private long g = 0;
    private ConcurrentHashMap<String, gc> dl = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Integer> f1982a = new HashMap<>();
    private List<String> gc = new CopyOnWriteArrayList();

    public static a z() {
        if (z == null) {
            synchronized (a.class) {
                if (z == null) {
                    z = new a();
                }
            }
        }
        return z;
    }

    public void z(String str, gc gcVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.dl.put(str, gcVar);
    }

    public void z(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.dl.remove(str);
    }

    long g() {
        return this.g;
    }

    void dl() {
        this.g = System.currentTimeMillis();
    }

    public int g(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.f1982a == null) {
            this.f1982a = new HashMap<>();
        }
        if (this.f1982a.containsKey(str)) {
            return this.f1982a.get(str).intValue();
        }
        return 0;
    }

    public static void z(com.ss.android.g.z.g.g gVar) {
        com.ss.android.socialbase.downloader.e.dl dlVarGz;
        if (gVar == null || gVar.g() <= 0 || (dlVarGz = e.g(wp.getContext()).gz(gVar.js())) == null) {
            return;
        }
        z(dlVarGz);
    }

    public static void z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null || com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).z("delete_file_after_install", 0) == 0) {
            return;
        }
        try {
            String str = dlVar.kb() + File.separator + dlVar.gz();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }
}
