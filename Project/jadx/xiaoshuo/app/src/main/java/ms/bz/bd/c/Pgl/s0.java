package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Build;
import ms.bz.bd.c.Pgl.u0;

/* JADX INFO: loaded from: classes9.dex */
public class s0 {
    private static volatile s0 e;
    private u0 bf;
    private String d = null;

    public class pgla implements u0.pblb {
        public pgla() {
        }

        @Override // ms.bz.bd.c.Pgl.u0.pblb
        public void e(String str) {
            s0.this.d = str;
        }
    }

    private s0(Context context) {
        this.bf = null;
        try {
            u0 u0Var = new u0(new pgla());
            this.bf = u0Var;
            if (Build.VERSION.SDK_INT <= 32) {
                u0Var.e(context);
            }
        } catch (Throwable unused) {
        }
    }

    public String e() {
        return this.d;
    }

    public static s0 e(Context context) {
        if (e == null) {
            synchronized (s0.class) {
                if (e == null) {
                    e = new s0(context);
                }
            }
        }
        return e;
    }
}
