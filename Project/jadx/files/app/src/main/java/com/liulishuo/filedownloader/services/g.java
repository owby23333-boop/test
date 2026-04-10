package com.liulishuo.filedownloader.services;

import android.text.TextUtils;
import com.liulishuo.filedownloader.b0;
import com.liulishuo.filedownloader.download.DownloadLaunchRunnable;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.liulishuo.filedownloader.y;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FileDownloadManager.java */
/* JADX INFO: loaded from: classes3.dex */
class g implements y {
    private final com.liulishuo.filedownloader.e0.a a;
    private final h b;

    g() {
        com.liulishuo.filedownloader.download.c cVarI = com.liulishuo.filedownloader.download.c.i();
        this.a = cVarI.a();
        this.b = new h(cVarI.d());
    }

    public synchronized void a(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, FileDownloadHeader fileDownloadHeader, boolean z4) {
        FileDownloadModel fileDownloadModel;
        List<com.liulishuo.filedownloader.model.a> listC;
        boolean z5 = true;
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "request start the task with url(%s) path(%s) isDirectory(%B)", str, str2, Boolean.valueOf(z2));
        }
        b0.c();
        int iA = com.liulishuo.filedownloader.h0.f.a(str, str2, z2);
        FileDownloadModel fileDownloadModelD = this.a.d(iA);
        if (z2 || fileDownloadModelD != null) {
            fileDownloadModel = fileDownloadModelD;
            listC = null;
        } else {
            int iA2 = com.liulishuo.filedownloader.h0.f.a(str, com.liulishuo.filedownloader.h0.f.j(str2), true);
            FileDownloadModel fileDownloadModelD2 = this.a.d(iA2);
            if (fileDownloadModelD2 == null || !str2.equals(fileDownloadModelD2.i())) {
                listC = null;
            } else {
                if (com.liulishuo.filedownloader.h0.d.a) {
                    com.liulishuo.filedownloader.h0.d.a(this, "task[%d] find model by dirCaseId[%d]", Integer.valueOf(iA), Integer.valueOf(iA2));
                }
                listC = this.a.c(iA2);
            }
            fileDownloadModel = fileDownloadModelD2;
        }
        if (com.liulishuo.filedownloader.h0.c.a(iA, fileDownloadModel, (y) this, true)) {
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.a(this, "has already started download %d", Integer.valueOf(iA));
            }
            return;
        }
        String strI = fileDownloadModel != null ? fileDownloadModel.i() : com.liulishuo.filedownloader.h0.f.a(str2, z2, (String) null);
        if (com.liulishuo.filedownloader.h0.c.a(iA, strI, z3, true)) {
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.a(this, "has already completed downloading %d", Integer.valueOf(iA));
            }
            return;
        }
        if (com.liulishuo.filedownloader.h0.c.a(iA, fileDownloadModel != null ? fileDownloadModel.g() : 0L, fileDownloadModel != null ? fileDownloadModel.n() : com.liulishuo.filedownloader.h0.f.k(strI), strI, this)) {
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.a(this, "there is an another task with the same target-file-path %d %s", Integer.valueOf(iA), strI);
            }
            if (fileDownloadModel != null) {
                this.a.remove(iA);
                this.a.e(iA);
            }
            return;
        }
        if (fileDownloadModel == null || !(fileDownloadModel.h() == -2 || fileDownloadModel.h() == -1 || fileDownloadModel.h() == 1 || fileDownloadModel.h() == 6 || fileDownloadModel.h() == 2)) {
            if (fileDownloadModel == null) {
                fileDownloadModel = new FileDownloadModel();
            }
            fileDownloadModel.d(str);
            fileDownloadModel.a(str2, z2);
            fileDownloadModel.b(iA);
            fileDownloadModel.b(0L);
            fileDownloadModel.c(0L);
            fileDownloadModel.a((byte) 1);
            fileDownloadModel.a(1);
        } else if (fileDownloadModel.e() != iA) {
            this.a.remove(fileDownloadModel.e());
            this.a.e(fileDownloadModel.e());
            fileDownloadModel.b(iA);
            fileDownloadModel.a(str2, z2);
            if (listC != null) {
                for (com.liulishuo.filedownloader.model.a aVar : listC) {
                    aVar.a(iA);
                    this.a.a(aVar);
                }
            }
        } else if (TextUtils.equals(str, fileDownloadModel.p())) {
            z5 = false;
        } else {
            fileDownloadModel.d(str);
        }
        if (z5) {
            this.a.update(fileDownloadModel);
        }
        DownloadLaunchRunnable.b bVar = new DownloadLaunchRunnable.b();
        bVar.a(fileDownloadModel);
        bVar.a(fileDownloadHeader);
        bVar.a(this);
        bVar.c(Integer.valueOf(i3));
        bVar.a(Integer.valueOf(i2));
        bVar.a(Boolean.valueOf(z3));
        bVar.b(Boolean.valueOf(z4));
        bVar.b(Integer.valueOf(i4));
        this.b.a(bVar.a());
    }

    public long b(int i2) {
        FileDownloadModel fileDownloadModelD = this.a.d(i2);
        if (fileDownloadModelD == null) {
            return 0L;
        }
        int iA = fileDownloadModelD.a();
        if (iA <= 1) {
            return fileDownloadModelD.g();
        }
        List<com.liulishuo.filedownloader.model.a> listC = this.a.c(i2);
        if (listC == null || listC.size() != iA) {
            return 0L;
        }
        return com.liulishuo.filedownloader.model.a.a(listC);
    }

    public void c() {
        List<Integer> listB = this.b.b();
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "pause all tasks %d", Integer.valueOf(listB.size()));
        }
        Iterator<Integer> it = listB.iterator();
        while (it.hasNext()) {
            f(it.next().intValue());
        }
    }

    public long d(int i2) {
        FileDownloadModel fileDownloadModelD = this.a.d(i2);
        if (fileDownloadModelD == null) {
            return 0L;
        }
        return fileDownloadModelD.o();
    }

    public boolean e(int i2) {
        return a(this.a.d(i2));
    }

    public boolean f(int i2) {
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "request pause the task %d", Integer.valueOf(i2));
        }
        FileDownloadModel fileDownloadModelD = this.a.d(i2);
        if (fileDownloadModelD == null) {
            return false;
        }
        fileDownloadModelD.a((byte) -2);
        this.b.a(i2);
        return true;
    }

    public synchronized boolean g(int i2) {
        return this.b.c(i2);
    }

    public byte c(int i2) {
        FileDownloadModel fileDownloadModelD = this.a.d(i2);
        if (fileDownloadModelD == null) {
            return (byte) 0;
        }
        return fileDownloadModelD.h();
    }

    public boolean b() {
        return this.b.a() <= 0;
    }

    public boolean a(String str, String str2) {
        return e(com.liulishuo.filedownloader.h0.f.c(str, str2));
    }

    @Override // com.liulishuo.filedownloader.y
    public boolean a(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            return false;
        }
        boolean zB = this.b.b(fileDownloadModel.e());
        if (com.liulishuo.filedownloader.model.b.b(fileDownloadModel.h())) {
            if (!zB) {
                return false;
            }
        } else if (!zB) {
            com.liulishuo.filedownloader.h0.d.b(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(fileDownloadModel.e()), Byte.valueOf(fileDownloadModel.h()));
            return false;
        }
        return true;
    }

    @Override // com.liulishuo.filedownloader.y
    public int a(String str, int i2) {
        return this.b.a(str, i2);
    }

    public boolean a(int i2) {
        if (i2 == 0) {
            com.liulishuo.filedownloader.h0.d.e(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i2));
            return false;
        }
        if (e(i2)) {
            com.liulishuo.filedownloader.h0.d.e(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i2));
            return false;
        }
        this.a.remove(i2);
        this.a.e(i2);
        return true;
    }

    public void a() {
        this.a.clear();
    }
}
