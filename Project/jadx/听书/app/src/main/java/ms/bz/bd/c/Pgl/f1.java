package ms.bz.bd.c.Pgl;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes4.dex */
final class f1 implements FilenameFilter {
    final /* synthetic */ String z;

    f1(String str) {
        this.z = str;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str.startsWith(this.z);
    }
}
