package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Build;
import com.google.common.primitives.SignedBytes;
import ms.bz.bd.c.Pgl.pblk;

/* JADX INFO: loaded from: classes4.dex */
public final class a1 {
    private static volatile a1 dl = null;
    public static String g = null;
    public static volatile boolean z = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private pblk f2536a;
    private String gc = null;

    final class pgla implements pblk.pblb {
        pgla() {
        }

        @Override // ms.bz.bd.c.Pgl.pblk.pblb
        public final void z(String str) {
            a1.this.gc = str;
        }
    }

    private a1(Context context) {
        try {
            this.f2536a = new pblk(new pgla());
            if (!z || Build.VERSION.SDK_INT > 32) {
                return;
            }
            this.f2536a.z(context);
        } catch (Throwable unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b802bc", new byte[]{124, 47, SignedBytes.MAX_POWER_OF_TWO});
        }
    }

    public static a1 z(Context context) {
        if (dl == null) {
            synchronized (a1.class) {
                if (dl == null) {
                    dl = new a1(context);
                }
            }
        }
        return dl;
    }

    public final String z() {
        String str = g;
        return str != null ? str : this.gc;
    }
}
