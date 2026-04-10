package com.anythink.basead.a.b;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
class d {
    public static final String a = "d";
    private static volatile d b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<a> f5796c = new CopyOnWriteArrayList();

    public interface a {
        void a(String str, int i2);

        void a(String str, com.anythink.basead.c.e eVar);
    }

    private d() {
    }

    public static d a() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    public final synchronized void b(a aVar) {
        int size = this.f5796c.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (aVar == this.f5796c.get(i2)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            this.f5796c.remove(i2);
        }
    }

    public final synchronized void a(a aVar) {
        this.f5796c.add(aVar);
    }

    public final void a(String str, int i2) {
        List<a> list = this.f5796c;
        if (list != null) {
            Iterator<a> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(str, i2);
            }
        }
    }

    public final void a(String str, com.anythink.basead.c.e eVar) {
        List<a> list = this.f5796c;
        if (list != null) {
            Iterator<a> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(str, eVar);
            }
        }
    }
}
