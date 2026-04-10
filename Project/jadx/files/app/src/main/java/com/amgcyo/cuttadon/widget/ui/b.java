package com.amgcyo.cuttadon.widget.ui;

import android.content.Context;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: Gloading.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static volatile b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f5737c;
    private InterfaceC0125b a;

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.widget.ui.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Gloading.java */
    public interface InterfaceC0125b {
        View a(c cVar, View view, int i2);
    }

    /* JADX INFO: compiled from: Gloading.java */
    public static class c {
        private InterfaceC0125b a;
        private Context b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Runnable f5738c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private View f5739d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ViewGroup f5740e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f5741f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private SparseArray<View> f5742g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Object f5743h;

        private boolean g() {
            if (this.a == null) {
                b.b("Gloading.Adapter is not specified.");
            }
            if (this.b == null) {
                b.b("Context is null.");
            }
            if (this.f5740e == null) {
                b.b("The mWrapper of loading status view is null.");
            }
            return (this.a == null || this.b == null || this.f5740e == null) ? false : true;
        }

        public c a(Runnable runnable) {
            this.f5738c = runnable;
            return this;
        }

        public Runnable b() {
            return this.f5738c;
        }

        public ViewGroup c() {
            return this.f5740e;
        }

        public void d() {
            a(4);
        }

        public void e() {
            a(3);
        }

        public void f() {
            a(2);
        }

        public Context getContext() {
            return this.b;
        }

        private c(InterfaceC0125b interfaceC0125b, Context context, ViewGroup viewGroup) {
            this.f5742g = new SparseArray<>(4);
            this.a = interfaceC0125b;
            this.b = context;
            this.f5740e = viewGroup;
        }

        public void a(int i2) {
            if (this.f5741f == i2 || !g()) {
                return;
            }
            this.f5741f = i2;
            View view = this.f5742g.get(i2);
            if (view == null) {
                view = this.f5739d;
            }
            try {
                View viewA = this.a.a(this, view, i2);
                if (viewA == null) {
                    b.b(this.a.getClass().getName() + ".getView returns null");
                    return;
                }
                if (viewA != this.f5739d || this.f5740e.indexOfChild(viewA) < 0) {
                    if (this.f5739d != null) {
                        this.f5740e.removeView(this.f5739d);
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        viewA.setElevation(Float.MAX_VALUE);
                    }
                    this.f5740e.addView(viewA);
                    ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = -1;
                        layoutParams.height = -1;
                    }
                } else if (this.f5740e.indexOfChild(viewA) != this.f5740e.getChildCount() - 1) {
                    viewA.bringToFront();
                }
                this.f5739d = viewA;
                this.f5742g.put(i2, viewA);
            } catch (Exception e2) {
                if (b.f5737c) {
                    e2.printStackTrace();
                }
            }
        }

        public <T> T a() {
            try {
                return (T) this.f5743h;
            } catch (Exception e2) {
                if (!b.f5737c) {
                    return null;
                }
                e2.printStackTrace();
                return null;
            }
        }
    }

    private b() {
    }

    public static b b() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
    }

    public static void a(boolean z2) {
        f5737c = z2;
    }

    public static void a(InterfaceC0125b interfaceC0125b) {
        b().a = interfaceC0125b;
    }

    public c a(View view) {
        FrameLayout frameLayout = new FrameLayout(view.getContext());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            frameLayout.setLayoutParams(layoutParams);
        }
        if (view.getParent() != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            viewGroup.addView(frameLayout, iIndexOfChild);
        }
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        return new c(this.a, view.getContext(), frameLayout);
    }
}
