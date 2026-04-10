package ms.bz.bd.c.Pgl;

import android.content.Context;

/* JADX INFO: loaded from: classes9.dex */
public class pblt {

    public interface pblb {
    }

    public interface pblc {
        void e();

        void e(Throwable th);
    }

    public interface pgla {
    }

    public static boolean e(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static void e(Context context, String str) throws Throwable {
        new pblu(new pblw(), new pblr()).e(context, str, (String) null, (pblc) null);
    }
}
