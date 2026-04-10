package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Long> f8305a = new HashMap();

    public static boolean a(byte[] bArr, String str) {
        boolean z = false;
        if (bArr != null && bArr.length > 0 && !TextUtils.isEmpty(str)) {
            String strA = com.xiaomi.push.bo.a(bArr);
            if (!TextUtils.isEmpty(strA)) {
                Map<String, Long> map = f8305a;
                synchronized (map) {
                    if (map.get(strA + str) != null) {
                        z = true;
                    } else {
                        map.put(strA + str, Long.valueOf(SystemClock.elapsedRealtime()));
                    }
                    a();
                }
            }
        }
        return z;
    }

    private static void a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Map<String, Long> map = f8305a;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (jElapsedRealtime - entry.getValue().longValue() > 60000) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f8305a.remove((String) it.next());
        }
    }
}
