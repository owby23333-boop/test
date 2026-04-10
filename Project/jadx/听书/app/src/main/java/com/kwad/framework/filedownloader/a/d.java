package com.kwad.framework.filedownloader.a;

import com.google.common.net.HttpHeaders;
import com.kwad.framework.filedownloader.f.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class d {
    private static boolean bB(int i) {
        return i == 301 || i == 302 || i == 303 || i == 300 || i == 307 || i == 308;
    }

    public static b a(Map<String, List<String>> map, b bVar, List<String> list) throws IllegalAccessException {
        int responseCode = bVar.getResponseCode();
        String strBn = bVar.bn(HttpHeaders.LOCATION);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (bB(responseCode)) {
            if (strBn == null) {
                throw new IllegalAccessException(f.c("receive %d (redirect) but the location is null with response [%s]", Integer.valueOf(responseCode), bVar.xR()));
            }
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(d.class, "redirect to %s with %d, %s", strBn, Integer.valueOf(responseCode), arrayList);
            }
            bVar.xS();
            bVar = a(map, strBn);
            arrayList.add(strBn);
            bVar.execute();
            responseCode = bVar.getResponseCode();
            strBn = bVar.bn(HttpHeaders.LOCATION);
            i++;
            if (i >= 10) {
                throw new IllegalAccessException(f.c("redirect too many times! %s", arrayList));
            }
        }
        if (list != null) {
            list.addAll(arrayList);
        }
        return bVar;
    }

    private static b a(Map<String, List<String>> map, String str) {
        b bVarBr = com.kwad.framework.filedownloader.download.b.yc().br(str);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    bVarBr.addHeader(key, it.next());
                }
            }
        }
        return bVarBr;
    }
}
