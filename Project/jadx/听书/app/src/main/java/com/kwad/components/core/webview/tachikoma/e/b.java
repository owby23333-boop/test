package com.kwad.components.core.webview.tachikoma.e;

import com.kwad.components.core.webview.tachikoma.f.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private final Set<Integer> ahN = new HashSet();
    private final ConcurrentHashMap<Integer, Set<f>> ahO = new ConcurrentHashMap<>();

    static class a {
        private static final b ahP = new b();
    }

    public static b vM() {
        return a.ahP;
    }

    public final boolean bn(int i) {
        if (this.ahN.contains(Integer.valueOf(i))) {
            return false;
        }
        this.ahN.add(Integer.valueOf(i));
        return true;
    }

    public final void a(int i, f fVar) {
        Set<f> set = this.ahO.get(Integer.valueOf(i));
        if (set != null) {
            set.add(fVar);
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(fVar);
        this.ahO.put(Integer.valueOf(i), hashSet);
    }

    private void a(int i, String str, String str2) {
        Set<f> set;
        this.ahN.remove(Integer.valueOf(i));
        if (this.ahO.isEmpty() || this.ahO.get(Integer.valueOf(i)) == null || (set = this.ahO.get(Integer.valueOf(i))) == null || set.isEmpty()) {
            return;
        }
        this.ahO.remove(Integer.valueOf(i));
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            it.next().vw();
        }
    }

    private void bo(int i) {
        Set<f> set;
        this.ahN.remove(Integer.valueOf(i));
        if (this.ahO.isEmpty() || this.ahO.get(Integer.valueOf(i)) == null || (set = this.ahO.get(Integer.valueOf(i))) == null || set.isEmpty()) {
            return;
        }
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            it.next().vx();
        }
        this.ahO.remove(Integer.valueOf(i));
    }

    public final void b(int i, String str, String str2) {
        a(i, str, str2);
    }

    public final void bp(int i) {
        bo(i);
    }
}
