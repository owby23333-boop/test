package com.kwad.components.core.webview.tachikoma;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: classes4.dex */
public final class h {
    private final Map<String, HashMap<Integer, String>> afd = new ConcurrentHashMap();
    private Map<String, Integer> afe = new ConcurrentSkipListMap();
    private int aff = 0;

    static class a {
        private static final h afg = new h();
    }

    public static h uS() {
        return a.afg;
    }

    public final void b(String str, int i, String str2) {
        if (TextUtils.isEmpty(str2) || com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBz) == 0) {
            return;
        }
        if (this.afd.containsKey(str)) {
            HashMap<Integer, String> map = this.afd.get(str);
            if (map != null && map.containsKey(Integer.valueOf(i))) {
                return;
            } else {
                this.afd.remove(str);
            }
        }
        bh(ba(str2));
        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(Integer.valueOf(i), str2);
        this.afd.put(str, map2);
        r(str, str2);
    }

    public final String n(String str, int i) {
        HashMap<Integer, String> map;
        return (com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBz) != 0 && this.afd.containsKey(str) && (map = this.afd.get(str)) != null && map.containsKey(Integer.valueOf(i))) ? map.get(Integer.valueOf(i)) : "";
    }

    private static int ba(String str) {
        return ((((str.length() * 2) + 12) + 16) + 16) / 1024;
    }

    private void r(String str, String str2) {
        int iBa = ba(str2);
        this.aff += iBa;
        this.afe.put(str, Integer.valueOf(iBa));
    }

    private void bh(int i) {
        if (this.aff + i > com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBz)) {
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, Integer>> it = this.afe.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Integer> next = it.next();
                arrayList.add(next.getKey());
                this.aff -= next.getValue().intValue();
                it.remove();
                if (this.aff <= com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBz) - i) {
                    break;
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.afd.remove((String) it2.next());
            }
        }
    }
}
