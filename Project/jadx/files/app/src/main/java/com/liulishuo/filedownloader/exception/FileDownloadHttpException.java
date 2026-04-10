package com.liulishuo.filedownloader.exception;

import com.liulishuo.filedownloader.h0.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class FileDownloadHttpException extends IOException {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f17200s;

    public FileDownloadHttpException(int i2, Map<String, List<String>> map, Map<String, List<String>> map2) {
        super(f.a("response code error: %d, \n request headers: %s \n response headers: %s", Integer.valueOf(i2), map, map2));
        this.f17200s = i2;
        a(map);
        a(map);
    }

    private static Map<String, List<String>> a(Map<String, List<String>> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            map2.put(entry.getKey(), new ArrayList(entry.getValue()));
        }
        return map2;
    }

    public int f() {
        return this.f17200s;
    }
}
