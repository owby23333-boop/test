package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Color;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.animation.AnimationUtils;
import com.yuewen.j91;
import com.yuewen.n91;
import com.yuewen.q91;
import com.yuewen.t91;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes5.dex */
public class GlView extends GLSurfaceView {
    public static final /* synthetic */ boolean f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t91 f5448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5449b;
    public LinkedList<n91> c;
    public LinkedList<Runnable> d;
    public LinkedHashMap<n91, f> e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q91 f5450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n91 f5451b;

        public a(q91 q91Var, n91 n91Var) {
            this.f5450a = q91Var;
            this.f5451b = n91Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = new f();
            fVar.f5460b = this.f5450a;
            fVar.f5459a = null;
            GlView.this.e.put(this.f5451b, fVar);
        }
    }

    public class b implements Runnable {
        public static final /* synthetic */ boolean c = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n91 f5452a;

        public b(n91 n91Var) {
            this.f5452a = n91Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = (f) GlView.this.e.get(this.f5452a);
            j91 j91Var = fVar.f5459a;
            if (j91Var != null) {
                j91Var.d();
                fVar.f5459a = null;
            }
            GlView.this.e.remove(this.f5452a);
            GlView.this.c.add(this.f5452a);
            GlView.this.k(this.f5452a);
        }
    }

    public class c implements Runnable {
        public static final /* synthetic */ boolean d = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n91 f5454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q91 f5455b;

        public c(n91 n91Var, q91 q91Var) {
            this.f5454a = n91Var;
            this.f5455b = q91Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = (f) GlView.this.e.get(this.f5454a);
            j91 j91Var = fVar.f5459a;
            if (j91Var != null) {
                j91Var.d();
                fVar.f5459a = null;
            }
            fVar.f5460b = this.f5455b;
        }
    }

    public class d implements Runnable {
        public static final /* synthetic */ boolean d = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n91 f5456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j91 f5457b;

        public d(n91 n91Var, j91 j91Var) {
            this.f5456a = n91Var;
            this.f5457b = j91Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = (f) GlView.this.e.get(this.f5456a);
            j91 j91Var = fVar.f5459a;
            if (j91Var != null) {
                j91Var.d();
                fVar.f5459a = null;
            }
            fVar.f5459a = this.f5457b;
        }
    }

    public class e implements Handler.Callback {
        public e() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (GlView.this.e) {
                Iterator it = GlView.this.d.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
            }
            GlView.this.d.clear();
            return true;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public j91 f5459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public q91 f5460b;

        public f() {
            this.f5459a = null;
            this.f5460b = null;
        }
    }

    public class g implements GLSurfaceView.Renderer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float[] f5461a;

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            GLES20.glClearColor(Color.red(GlView.this.f5449b) / 255.0f, Color.green(GlView.this.f5449b) / 255.0f, Color.blue(GlView.this.f5449b) / 255.0f, Color.alpha(GlView.this.f5449b) / 255.0f);
            GLES20.glClear(16384);
            synchronized (GlView.this.e) {
                Iterator it = GlView.this.c.iterator();
                while (it.hasNext()) {
                    ((n91) it.next()).a();
                }
                GlView.this.c.clear();
                for (Map.Entry entry : GlView.this.e.entrySet()) {
                    n91 n91Var = (n91) entry.getKey();
                    f fVar = (f) entry.getValue();
                    if (!n91Var.i()) {
                        n91Var.j(this.f5461a);
                    }
                    j91 j91Var = fVar.f5459a;
                    if (j91Var != null) {
                        if (j91Var.k() == null) {
                            fVar.f5459a.t(fVar.f5460b);
                        }
                        fVar.f5459a.q(AnimationUtils.currentAnimationTimeMillis());
                        fVar.f5460b = fVar.f5459a.f();
                        if (fVar.f5459a.l()) {
                            fVar.f5459a = null;
                        }
                    }
                    n91Var.l(fVar.f5460b.a());
                    n91Var.k(fVar.f5460b.b());
                    n91Var.e();
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
            float[] fArr = new float[16];
            float f = (-i) / 2.0f;
            float f2 = i2 / 2.0f;
            Matrix.orthoM(fArr, 0, f, i / 2.0f, (-i2) / 2.0f, f2, 0.0f, 2.1474836E9f);
            float[] fArr2 = new float[16];
            Matrix.setIdentityM(fArr2, 0);
            Matrix.translateM(fArr2, 0, f, f2, 0.0f);
            Matrix.rotateM(fArr2, 0, 180.0f, 1.0f, 0.0f, 0.0f);
            Matrix.multiplyMM(this.f5461a, 0, fArr, 0, fArr2, 0);
            synchronized (GlView.this.e) {
                Iterator it = GlView.this.e.entrySet().iterator();
                while (it.hasNext()) {
                    ((n91) ((Map.Entry) it.next()).getKey()).j(this.f5461a);
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        }

        public g() {
            this.f5461a = new float[16];
        }
    }

    public GlView(Context context) {
        this(context, null);
    }

    public void f(n91 n91Var, q91 q91Var) {
        g(new a(q91Var, n91Var));
    }

    public final void g(Runnable runnable) {
        if (this.d.size() == 0) {
            new Handler(new e()).sendEmptyMessage(0);
        }
        this.d.add(runnable);
    }

    public void h(n91 n91Var, j91 j91Var) {
        g(new d(n91Var, j91Var));
    }

    public final boolean i() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public q91 j(n91 n91Var) {
        q91 q91Var;
        synchronized (this.e) {
            f fVar = this.e.get(n91Var);
            q91Var = fVar != null ? fVar.f5460b : null;
        }
        return q91Var;
    }

    public final void k(n91 n91Var) {
        t91 t91Var = this.f5448a;
        if (t91Var != null) {
            t91Var.a(this, n91Var);
        }
    }

    public void l(n91 n91Var) {
        g(new b(n91Var));
    }

    public void m(n91 n91Var, q91 q91Var) {
        g(new c(n91Var, q91Var));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f5449b = i;
    }

    public void setGlViewListener(t91 t91Var) {
        this.f5448a = t91Var;
    }

    public GlView(Context context, t91 t91Var) {
        super(context);
        this.f5449b = Color.argb(0, 0, 0, 0);
        this.c = new LinkedList<>();
        this.d = new LinkedList<>();
        this.e = new LinkedHashMap<>();
        this.f5448a = t91Var;
        setEGLContextClientVersion(2);
        setZOrderOnTop(true);
        getHolder().setFormat(-3);
        setRenderer(new g());
    }
}
