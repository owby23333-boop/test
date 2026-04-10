package ms.bz.bd.c.Pgl;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public final class pblv {
    private static final pblv z = new pblv();
    private Context g;

    public static pblv z() {
        return z;
    }

    public final Context g() {
        return this.g;
    }

    public final void z(Context context) {
        this.g = context != null ? context.getApplicationContext() : null;
    }
}
