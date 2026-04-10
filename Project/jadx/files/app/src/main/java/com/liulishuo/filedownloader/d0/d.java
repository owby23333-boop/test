package com.liulishuo.filedownloader.d0;

import com.liulishuo.filedownloader.h0.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: RedirectHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static b a(Map<String, List<String>> map, b bVar, List<String> list) throws IllegalAccessException, IOException {
        int responseCode = bVar.getResponseCode();
        String responseHeaderField = bVar.getResponseHeaderField("Location");
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (a(responseCode)) {
            if (responseHeaderField == null) {
                throw new IllegalAccessException(f.a("receive %d (redirect) but the location is null with response [%s]", Integer.valueOf(responseCode), bVar.c()));
            }
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.a(d.class, "redirect to %s with %d, %s", responseHeaderField, Integer.valueOf(responseCode), arrayList);
            }
            bVar.a();
            bVar = a(map, responseHeaderField);
            arrayList.add(responseHeaderField);
            bVar.execute();
            responseCode = bVar.getResponseCode();
            responseHeaderField = bVar.getResponseHeaderField("Location");
            i2++;
            if (i2 >= 10) {
                throw new IllegalAccessException(f.a("redirect too many times! %s", arrayList));
            }
        }
        if (list != null) {
            list.addAll(arrayList);
        }
        return bVar;
    }

    private static boolean a(int i2) {
        return i2 == 301 || i2 == 302 || i2 == 303 || i2 == 300 || i2 == 307 || i2 == 308;
    }

    private static b a(Map<String, List<String>> map, String str) throws IOException {
        b bVarA = com.liulishuo.filedownloader.download.c.i().a(str);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    bVarA.addHeader(key, it.next());
                }
            }
        }
        return bVarA;
    }
}
