package ms.bz.bd.c.Pgl;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes9.dex */
class pblv implements FilenameFilter {
    final /* synthetic */ String e;

    public pblv(pblu pbluVar, String str) {
        this.e = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.startsWith(this.e);
    }
}
