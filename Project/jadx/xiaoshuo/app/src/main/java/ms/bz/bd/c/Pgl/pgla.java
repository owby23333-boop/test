package ms.bz.bd.c.Pgl;

import android.content.Context;

/* JADX INFO: loaded from: classes9.dex */
public final class pgla {
    private static final pgla e = new pgla();
    private Context bf;

    public static pgla e() {
        return e;
    }

    public Context bf() {
        return this.bf;
    }

    public void e(Context context) {
        this.bf = context != null ? context.getApplicationContext() : null;
    }
}
