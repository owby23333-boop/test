package com.kwad.framework.filedownloader.b;

import android.util.SparseArray;
import com.kwad.framework.filedownloader.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.kwad.framework.filedownloader.b.a {
    final SparseArray<com.kwad.framework.filedownloader.d.c> amG = new SparseArray<>();
    final SparseArray<List<com.kwad.framework.filedownloader.d.a>> amH = new SparseArray<>();

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, long j, String str, String str2) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, String str, long j, long j2, int i2) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th, long j) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i, long j) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bC(int i) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bH(int i) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i, long j) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void t(int i, int i2) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bD(int i) {
        com.kwad.framework.filedownloader.d.c cVar;
        synchronized (this.amG) {
            cVar = this.amG.get(i);
        }
        return cVar;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> bE(int i) {
        List<com.kwad.framework.filedownloader.d.a> list;
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (this.amH) {
                list = this.amH.get(i);
            }
            if (list != null) {
                arrayList.addAll(list);
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bF(int i) {
        try {
            synchronized (this.amH) {
                this.amH.remove(i);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        List<com.kwad.framework.filedownloader.d.a> arrayList;
        try {
            int id = aVar.getId();
            synchronized (this.amH) {
                arrayList = this.amH.get(id);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.amH.put(id, arrayList);
                }
            }
            arrayList.add(aVar);
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, int i2, long j) {
        List<com.kwad.framework.filedownloader.d.a> list;
        synchronized (this.amH) {
            list = this.amH.get(i);
        }
        if (list == null) {
            return;
        }
        for (com.kwad.framework.filedownloader.d.a aVar : list) {
            if (aVar.getIndex() == i2) {
                aVar.X(j);
                return;
            }
        }
    }

    private void d(com.kwad.framework.filedownloader.d.c cVar) {
        synchronized (this.amG) {
            this.amG.put(cVar.getId(), cVar);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
            return;
        }
        if (bD(cVar.getId()) != null) {
            synchronized (this.amG) {
                this.amG.remove(cVar.getId());
                this.amG.put(cVar.getId(), cVar);
            }
            return;
        }
        d(cVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bG(int i) {
        synchronized (this.amG) {
            this.amG.remove(i);
        }
        return true;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        synchronized (this.amG) {
            this.amG.clear();
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i, long j) {
        bG(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0371a xT() {
        return new a();
    }

    class a implements a.InterfaceC0371a {
        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0371a
        public final void a(int i, com.kwad.framework.filedownloader.d.c cVar) {
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0371a
        public final void c(com.kwad.framework.filedownloader.d.c cVar) {
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0371a
        public final void xU() {
        }

        a() {
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwad.framework.filedownloader.d.c> iterator() {
            return b.this.new C0372b();
        }
    }

    /* JADX INFO: renamed from: com.kwad.framework.filedownloader.b.b$b, reason: collision with other inner class name */
    class C0372b implements Iterator<com.kwad.framework.filedownloader.d.c> {
        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final /* bridge */ /* synthetic */ com.kwad.framework.filedownloader.d.c next() {
            return null;
        }

        @Override // java.util.Iterator
        public final void remove() {
        }

        C0372b() {
        }
    }
}
