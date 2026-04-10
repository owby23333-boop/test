package com.liulishuo.filedownloader.e0;

import android.util.SparseArray;
import com.liulishuo.filedownloader.e0.a;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: NoDatabaseImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements com.liulishuo.filedownloader.e0.a {
    final SparseArray<FileDownloadModel> a = new SparseArray<>();
    final SparseArray<List<com.liulishuo.filedownloader.model.a>> b = new SparseArray<>();

    /* JADX INFO: compiled from: NoDatabaseImpl.java */
    class a implements a.InterfaceC0484a {
        a() {
        }

        @Override // com.liulishuo.filedownloader.e0.a.InterfaceC0484a
        public void a(int i2, FileDownloadModel fileDownloadModel) {
        }

        @Override // com.liulishuo.filedownloader.e0.a.InterfaceC0484a
        public void a(FileDownloadModel fileDownloadModel) {
        }

        @Override // com.liulishuo.filedownloader.e0.a.InterfaceC0484a
        public void b(FileDownloadModel fileDownloadModel) {
        }

        @Override // com.liulishuo.filedownloader.e0.a.InterfaceC0484a
        public void f() {
        }

        @Override // java.lang.Iterable
        public Iterator<FileDownloadModel> iterator() {
            return new C0485b(b.this);
        }
    }

    /* JADX INFO: renamed from: com.liulishuo.filedownloader.e0.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NoDatabaseImpl.java */
    class C0485b implements Iterator<FileDownloadModel> {
        C0485b(b bVar) {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public FileDownloadModel next() {
            return null;
        }

        @Override // java.util.Iterator
        public void remove() {
        }
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2) {
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, int i3) {
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, long j2, String str, String str2) {
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, String str, long j2, long j3, int i3) {
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, Throwable th) {
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, Throwable th, long j2) {
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(com.liulishuo.filedownloader.model.a aVar) {
        int iC = aVar.c();
        synchronized (this.b) {
            List<com.liulishuo.filedownloader.model.a> arrayList = this.b.get(iC);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.b.put(iC, arrayList);
            }
            arrayList.add(aVar);
        }
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void b(int i2) {
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void b(int i2, long j2) {
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public List<com.liulishuo.filedownloader.model.a> c(int i2) {
        List<com.liulishuo.filedownloader.model.a> list;
        ArrayList arrayList = new ArrayList();
        synchronized (this.b) {
            list = this.b.get(i2);
        }
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void c(int i2, long j2) {
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void clear() {
        synchronized (this.a) {
            this.a.clear();
        }
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public FileDownloadModel d(int i2) {
        FileDownloadModel fileDownloadModel;
        synchronized (this.a) {
            fileDownloadModel = this.a.get(i2);
        }
        return fileDownloadModel;
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void e(int i2) {
        synchronized (this.b) {
            this.b.remove(i2);
        }
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void insert(FileDownloadModel fileDownloadModel) {
        synchronized (this.a) {
            this.a.put(fileDownloadModel.e(), fileDownloadModel);
        }
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public boolean remove(int i2) {
        synchronized (this.a) {
            this.a.remove(i2);
        }
        return true;
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void update(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            com.liulishuo.filedownloader.h0.d.e(this, "update but model == null!", new Object[0]);
            return;
        }
        if (d(fileDownloadModel.e()) == null) {
            insert(fileDownloadModel);
            return;
        }
        synchronized (this.a) {
            this.a.remove(fileDownloadModel.e());
            this.a.put(fileDownloadModel.e(), fileDownloadModel);
        }
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, int i3, long j2) {
        synchronized (this.b) {
            List<com.liulishuo.filedownloader.model.a> list = this.b.get(i2);
            if (list == null) {
                return;
            }
            for (com.liulishuo.filedownloader.model.a aVar : list) {
                if (aVar.d() == i3) {
                    aVar.a(j2);
                    return;
                }
            }
        }
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, long j2) {
        remove(i2);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public a.InterfaceC0484a a() {
        return new a();
    }
}
