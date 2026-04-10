package y0.a;

import java.util.ArrayList;
import org.jetbrains.annotations.NonNls;

/* JADX INFO: compiled from: Timber.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final b[] a = new b[0];
    static volatile b[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final b f21744c;

    /* JADX INFO: compiled from: Timber.java */
    public static abstract class b {
        public b() {
            new ThreadLocal();
        }

        public abstract void a(String str, Object... objArr);

        public abstract void a(Throwable th, String str, Object... objArr);

        public abstract void b(String str, Object... objArr);

        public abstract void c(String str, Object... objArr);
    }

    static {
        new ArrayList();
        b = a;
        f21744c = new C0604a();
    }

    public static void a(Throwable th, @NonNls String str, Object... objArr) {
        f21744c.a(th, str, objArr);
    }

    public static void b(@NonNls String str, Object... objArr) {
        f21744c.b(str, objArr);
    }

    public static void c(@NonNls String str, Object... objArr) {
        f21744c.c(str, objArr);
    }

    public static void a(@NonNls String str, Object... objArr) {
        f21744c.a(str, objArr);
    }

    /* JADX INFO: renamed from: y0.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Timber.java */
    static class C0604a extends b {
        C0604a() {
        }

        @Override // y0.a.a.b
        public void a(Throwable th, String str, Object... objArr) {
            for (b bVar : a.b) {
                bVar.a(th, str, objArr);
            }
        }

        @Override // y0.a.a.b
        public void b(String str, Object... objArr) {
            for (b bVar : a.b) {
                bVar.b(str, objArr);
            }
        }

        @Override // y0.a.a.b
        public void c(String str, Object... objArr) {
            for (b bVar : a.b) {
                bVar.c(str, objArr);
            }
        }

        @Override // y0.a.a.b
        public void a(String str, Object... objArr) {
            for (b bVar : a.b) {
                bVar.a(str, objArr);
            }
        }
    }
}
