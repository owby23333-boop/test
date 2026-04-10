package com.kwai.filedownloader.a;

import android.util.SparseArray;
import com.kwai.filedownloader.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.kwai.filedownloader.a.a {
    final SparseArray<com.kwai.filedownloader.c.c> aEW = new SparseArray<>();
    final SparseArray<List<com.kwai.filedownloader.c.a>> aEX = new SparseArray<>();

    class a implements a.InterfaceC0462a {
        a() {
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0462a
        public final void Hm() {
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0462a
        public final void a(int i2, com.kwai.filedownloader.c.c cVar) {
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0462a
        public final void c(com.kwai.filedownloader.c.c cVar) {
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwai.filedownloader.c.c> iterator() {
            return b.this.new C0463b();
        }
    }

    /* JADX INFO: renamed from: com.kwai.filedownloader.a.b$b, reason: collision with other inner class name */
    class C0463b implements Iterator<com.kwai.filedownloader.c.c> {
        C0463b() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final /* bridge */ /* synthetic */ com.kwai.filedownloader.c.c next() {
            return null;
        }

        @Override // java.util.Iterator
        public final void remove() {
        }
    }

    private void d(com.kwai.filedownloader.c.c cVar) {
        synchronized (this.aEW) {
            this.aEW.put(cVar.getId(), cVar);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final a.InterfaceC0462a Hl() {
        return new a();
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, int i3, long j2) {
        List<com.kwai.filedownloader.c.a> list;
        synchronized (this.aEX) {
            list = this.aEX.get(i2);
        }
        if (list == null) {
            return;
        }
        for (com.kwai.filedownloader.c.a aVar : list) {
            if (aVar.getIndex() == i3) {
                aVar.am(j2);
                return;
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, long j2, String str, String str2) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, String str, long j2, long j3, int i3) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, Throwable th) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, Throwable th, long j2) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(com.kwai.filedownloader.c.a aVar) {
        List<com.kwai.filedownloader.c.a> arrayList;
        try {
            int id = aVar.getId();
            synchronized (this.aEX) {
                arrayList = this.aEX.get(id);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.aEX.put(id, arrayList);
                }
            }
            arrayList.add(aVar);
        } catch (Exception unused) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void b(com.kwai.filedownloader.c.c cVar) {
        if (cVar == null) {
            com.kwai.filedownloader.e.d.h(this, "update but model == null!", new Object[0]);
            return;
        }
        if (cD(cVar.getId()) == null) {
            d(cVar);
            return;
        }
        synchronized (this.aEW) {
            this.aEW.remove(cVar.getId());
            this.aEW.put(cVar.getId(), cVar);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cC(int i2) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final com.kwai.filedownloader.c.c cD(int i2) {
        com.kwai.filedownloader.c.c cVar;
        synchronized (this.aEW) {
            cVar = this.aEW.get(i2);
        }
        return cVar;
    }

    @Override // com.kwai.filedownloader.a.a
    public final List<com.kwai.filedownloader.c.a> cE(int i2) {
        List<com.kwai.filedownloader.c.a> list;
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (this.aEX) {
                list = this.aEX.get(i2);
            }
            if (list != null) {
                arrayList.addAll(list);
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cF(int i2) {
        try {
            synchronized (this.aEX) {
                this.aEX.remove(i2);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final boolean cG(int i2) {
        synchronized (this.aEW) {
            this.aEW.remove(i2);
        }
        return true;
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cH(int i2) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void clear() {
        synchronized (this.aEW) {
            this.aEW.clear();
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void d(int i2, long j2) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void e(int i2, long j2) {
        cG(i2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void f(int i2, long j2) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void z(int i2, int i3) {
    }
}
