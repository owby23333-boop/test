package com.amgcyo.cuttadon.view.read.page;

import com.amgcyo.cuttadon.api.entity.other.MkCatalog;
import com.amgcyo.cuttadon.api.entity.other.MkConfigSource;
import com.amgcyo.cuttadon.api.entity.reader.ReadConfig;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.utils.otherutils.z;
import com.amgcyo.cuttadon.view.read.page.j;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: BookPageLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends j {
    h(PageView pageView, ReadConfig readConfig, j.b bVar, k kVar, MkConfigSource mkConfigSource) {
        super(pageView, readConfig, bVar, kVar, mkConfigSource);
    }

    private void F() {
        int size;
        if (this.f5270d != null) {
            int i2 = this.U;
            if (i2 < this.a.size()) {
                size = i2 + 1;
                if (size >= this.a.size()) {
                    size = this.a.size() - 1;
                }
            } else {
                size = i2;
            }
            if (i2 != 0 && i2 - 1 < 0) {
                i2 = 0;
            }
            b(i2, size);
        }
    }

    private void G() {
        if (this.f5270d != null) {
            int i2 = this.U + 1;
            int size = i2 + 1;
            if (i2 >= this.a.size()) {
                return;
            }
            if (size >= this.a.size()) {
                size = this.a.size() - 1;
            }
            b(i2, size);
        }
    }

    private void H() {
        if (this.f5270d != null) {
            int i2 = this.U;
            int i3 = i2 - 2;
            if (i3 < 0) {
                i3 = 0;
            }
            b(i3, i2);
        }
    }

    private void b(int i2, int i3) {
        String str = "start:" + i2 + " end " + i3;
    }

    @Override // com.amgcyo.cuttadon.view.read.page.j
    protected List<String> a(MkCatalog mkCatalog) {
        File file;
        boolean z2 = false;
        if (mkCatalog == null) {
            file = new File(z.l("章节缺失"));
        } else if (mkCatalog.isIs_content()) {
            File fileA = z.a(String.valueOf(this.b.getBookId()), this.b.getSiteId(), com.amgcyo.cuttadon.utils.otherutils.g.a(mkCatalog.getPath(), mkCatalog.getUpdated_at()));
            if (fileA.exists()) {
                file = fileA;
            } else {
                this.f5306v = 1;
                if (mkCatalog.isOnErrorReturn()) {
                    file = new File(z.l());
                } else {
                    j.b bVar = this.f5270d;
                    if (bVar != null) {
                        bVar.loadChapterAgain(mkCatalog.getCatalogId());
                    }
                    file = fileA;
                    z2 = true;
                }
            }
        } else {
            file = new File(z.l(mkCatalog.getName()));
        }
        if (z2) {
            return null;
        }
        if (this.f5285k0 == null) {
            this.f5285k0 = AppDatabase.i().c().a(this.b.getSiteId());
        }
        return z.a(file.getAbsolutePath(), this.f5285k0);
    }

    @Override // com.amgcyo.cuttadon.view.read.page.j
    public void c() {
        super.c();
    }

    @Override // com.amgcyo.cuttadon.view.read.page.j
    boolean s() {
        boolean zS = super.s();
        if (this.f5306v == 1) {
            F();
        }
        return zS;
    }

    @Override // com.amgcyo.cuttadon.view.read.page.j
    boolean t() {
        boolean zT = super.t();
        int i2 = this.f5306v;
        if (i2 == 2) {
            G();
        } else if (i2 == 1) {
            F();
        }
        return zT;
    }

    @Override // com.amgcyo.cuttadon.view.read.page.j
    boolean u() {
        boolean zU = super.u();
        int i2 = this.f5306v;
        if (i2 == 2) {
            H();
        } else if (i2 == 1) {
            F();
        }
        return zU;
    }

    @Override // com.amgcyo.cuttadon.view.read.page.j
    public void x() {
        ReadConfig readConfig = this.b;
        if (readConfig == null || readConfig.getChapterList() == null) {
            return;
        }
        this.a = this.b.getChapterList();
        this.f5308w = true;
        if (l()) {
            return;
        }
        q();
    }
}
