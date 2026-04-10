package com.ss.android.downloadlib.addownload;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class m {
    private final ConcurrentHashMap<String, String> g;
    private final ConcurrentHashMap<String, String> z;

    public static class z {
        private static m z = new m();
    }

    public static m z() {
        return z.z;
    }

    private m() {
        this.z = new ConcurrentHashMap<>();
        this.g = new ConcurrentHashMap<>();
    }

    public void z(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || this.g.containsKey(str2)) {
            return;
        }
        this.g.put(str2, str);
    }

    public String z(String str) {
        if (TextUtils.isEmpty(str) || this.g.isEmpty() || !this.g.containsKey(str)) {
            return null;
        }
        String strDl = dl(str);
        if (this.z.containsValue(strDl)) {
            for (Map.Entry<String, String> entry : this.z.entrySet()) {
                if (TextUtils.equals(entry.getValue(), strDl)) {
                    String str2 = this.g.get(entry.getKey());
                    this.g.put(str, str2);
                    if (!this.z.containsKey(str)) {
                        this.z.put(str, strDl);
                    }
                    return str2;
                }
            }
        }
        return this.g.get(str);
    }

    public String z(com.ss.android.z.z.dl.dl dlVar) {
        String strDl = dl(dlVar.z());
        if (strDl == null || TextUtils.isEmpty(strDl)) {
            return null;
        }
        String strGc = com.ss.android.socialbase.downloader.pf.m.gc(strDl + dlVar.sy());
        this.g.put(dlVar.z(), strGc);
        return strGc;
    }

    private String dl(String str) {
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            String lastPathSegment = uri.getLastPathSegment();
            if (!TextUtils.equals("https", scheme) || !lastPathSegment.endsWith(".apk")) {
                return null;
            }
            this.z.put(str, lastPathSegment);
            return lastPathSegment;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    public void g(String str) {
        Iterator<Map.Entry<String, String>> it = this.g.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (TextUtils.equals(next.getValue(), str)) {
                it.remove();
                this.z.remove(next.getKey());
            }
        }
    }
}
