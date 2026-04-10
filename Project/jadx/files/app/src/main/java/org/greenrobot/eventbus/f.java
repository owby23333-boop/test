package org.greenrobot.eventbus;

import android.util.Log;
import java.util.logging.Level;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes3.dex */
public interface f {

    /* JADX INFO: compiled from: Logger.java */
    public static class a implements f {
        static final boolean b;
        private final String a;

        static {
            boolean z2 = false;
            try {
                if (Class.forName("android.util.Log") != null) {
                    z2 = true;
                }
            } catch (ClassNotFoundException unused) {
            }
            b = z2;
        }

        public a(String str) {
            this.a = str;
        }

        public static boolean a() {
            return b;
        }

        @Override // org.greenrobot.eventbus.f
        public void a(Level level, String str) {
            if (level != Level.OFF) {
                Log.println(a(level), this.a, str);
            }
        }

        @Override // org.greenrobot.eventbus.f
        public void a(Level level, String str, Throwable th) {
            if (level != Level.OFF) {
                Log.println(a(level), this.a, str + "\n" + Log.getStackTraceString(th));
            }
        }

        protected int a(Level level) {
            int iIntValue = level.intValue();
            if (iIntValue < 800) {
                return iIntValue < 500 ? 2 : 3;
            }
            if (iIntValue < 900) {
                return 4;
            }
            return iIntValue < 1000 ? 5 : 6;
        }
    }

    /* JADX INFO: compiled from: Logger.java */
    public static class b implements f {
        @Override // org.greenrobot.eventbus.f
        public void a(Level level, String str) {
            System.out.println("[" + level + "] " + str);
        }

        @Override // org.greenrobot.eventbus.f
        public void a(Level level, String str, Throwable th) {
            System.out.println("[" + level + "] " + str);
            th.printStackTrace(System.out);
        }
    }

    void a(Level level, String str);

    void a(Level level, String str, Throwable th);
}
