package ms.bz.bd.c.Pgl;

import ms.bz.bd.c.Pgl.pblt;

/* JADX INFO: loaded from: classes9.dex */
final class pblw implements pblt.pblb {
    public String e(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }
}
