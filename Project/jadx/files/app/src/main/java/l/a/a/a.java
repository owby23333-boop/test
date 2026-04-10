package l.a.a;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Choreographer;

/* JADX INFO: compiled from: AndroidSpringLooperFactory.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class a {

    /* JADX INFO: renamed from: l.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AndroidSpringLooperFactory.java */
    @TargetApi(16)
    private static class C0573a extends i {
        private final Choreographer b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Choreographer.FrameCallback f21005c = new ChoreographerFrameCallbackC0574a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f21006d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f21007e;

        /* JADX INFO: renamed from: l.a.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AndroidSpringLooperFactory.java */
        class ChoreographerFrameCallbackC0574a implements Choreographer.FrameCallback {
            ChoreographerFrameCallbackC0574a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j2) {
                if (!C0573a.this.f21006d || C0573a.this.a == null) {
                    return;
                }
                long jUptimeMillis = SystemClock.uptimeMillis();
                C0573a.this.a.b(jUptimeMillis - r0.f21007e);
                C0573a.this.f21007e = jUptimeMillis;
                C0573a.this.b.postFrameCallback(C0573a.this.f21005c);
            }
        }

        public C0573a(Choreographer choreographer) {
            this.b = choreographer;
        }

        public static C0573a c() {
            return new C0573a(Choreographer.getInstance());
        }

        @Override // l.a.a.i
        public void b() {
            this.f21006d = false;
            this.b.removeFrameCallback(this.f21005c);
        }

        @Override // l.a.a.i
        public void a() {
            if (this.f21006d) {
                return;
            }
            this.f21006d = true;
            this.f21007e = SystemClock.uptimeMillis();
            this.b.removeFrameCallback(this.f21005c);
            this.b.postFrameCallback(this.f21005c);
        }
    }

    /* JADX INFO: compiled from: AndroidSpringLooperFactory.java */
    private static class b extends i {
        private final Handler b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f21009c = new RunnableC0575a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f21010d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f21011e;

        /* JADX INFO: renamed from: l.a.a.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AndroidSpringLooperFactory.java */
        class RunnableC0575a implements Runnable {
            RunnableC0575a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!b.this.f21010d || b.this.a == null) {
                    return;
                }
                long jUptimeMillis = SystemClock.uptimeMillis();
                b.this.a.b(jUptimeMillis - r2.f21011e);
                b.this.f21011e = jUptimeMillis;
                b.this.b.post(b.this.f21009c);
            }
        }

        public b(Handler handler) {
            this.b = handler;
        }

        public static i c() {
            return new b(new Handler());
        }

        @Override // l.a.a.i
        public void b() {
            this.f21010d = false;
            this.b.removeCallbacks(this.f21009c);
        }

        @Override // l.a.a.i
        public void a() {
            if (this.f21010d) {
                return;
            }
            this.f21010d = true;
            this.f21011e = SystemClock.uptimeMillis();
            this.b.removeCallbacks(this.f21009c);
            this.b.post(this.f21009c);
        }
    }

    public static i a() {
        return Build.VERSION.SDK_INT >= 16 ? C0573a.c() : b.c();
    }
}
