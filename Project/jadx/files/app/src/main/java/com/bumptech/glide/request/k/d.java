package com.bumptech.glide.request.k;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.R$id;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: CustomViewTarget.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d<T extends View, Z> implements j<Z> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @IdRes
    private static final int f13865x = R$id.glide_custom_view_target_tag;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final a f13866s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected final T f13867t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private View.OnAttachStateChangeListener f13868u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f13869v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f13870w;

    public d(@NonNull T t2) {
        com.bumptech.glide.util.k.a(t2);
        this.f13867t = t2;
        this.f13866s = new a(t2);
    }

    private void c() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f13868u;
        if (onAttachStateChangeListener == null || this.f13870w) {
            return;
        }
        this.f13867t.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f13870w = true;
    }

    private void d() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f13868u;
        if (onAttachStateChangeListener == null || !this.f13870w) {
            return;
        }
        this.f13867t.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f13870w = false;
    }

    @Override // com.bumptech.glide.request.k.j
    public final void a(@NonNull i iVar) {
        this.f13866s.b(iVar);
    }

    @Override // com.bumptech.glide.request.k.j
    public final void b(@NonNull i iVar) {
        this.f13866s.a(iVar);
    }

    protected abstract void d(@Nullable Drawable drawable);

    protected void e(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.l.m
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.l.m
    public void onStart() {
    }

    @Override // com.bumptech.glide.l.m
    public void onStop() {
    }

    public String toString() {
        return "Target for: " + this.f13867t;
    }

    /* JADX INFO: compiled from: CustomViewTarget.java */
    @VisibleForTesting
    static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        @VisibleForTesting
        static Integer f13871e;
        private final View a;
        private final List<i> b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f13872c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private ViewTreeObserverOnPreDrawListenerC0277a f13873d;

        /* JADX INFO: renamed from: com.bumptech.glide.request.k.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CustomViewTarget.java */
        private static final class ViewTreeObserverOnPreDrawListenerC0277a implements ViewTreeObserver.OnPreDrawListener {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            private final WeakReference<a> f13874s;

            ViewTreeObserverOnPreDrawListenerC0277a(@NonNull a aVar) {
                this.f13874s = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    String str = "OnGlobalLayoutListener called attachStateListener=" + this;
                }
                a aVar = this.f13874s.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        a(@NonNull View view) {
            this.a = view;
        }

        private static int a(@NonNull Context context) {
            if (f13871e == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                com.bumptech.glide.util.k.a(windowManager);
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f13871e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f13871e.intValue();
        }

        private boolean a(int i2) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }

        private void b(int i2, int i3) {
            Iterator it = new ArrayList(this.b).iterator();
            while (it.hasNext()) {
                ((i) it.next()).a(i2, i3);
            }
        }

        private int c() {
            int paddingTop = this.a.getPaddingTop() + this.a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            return a(this.a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int d() {
            int paddingLeft = this.a.getPaddingLeft() + this.a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            return a(this.a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        void b(@NonNull i iVar) {
            this.b.remove(iVar);
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f13873d);
            }
            this.f13873d = null;
            this.b.clear();
        }

        void a() {
            if (this.b.isEmpty()) {
                return;
            }
            int iD = d();
            int iC = c();
            if (a(iD, iC)) {
                b(iD, iC);
                b();
            }
        }

        void a(@NonNull i iVar) {
            int iD = d();
            int iC = c();
            if (a(iD, iC)) {
                iVar.a(iD, iC);
                return;
            }
            if (!this.b.contains(iVar)) {
                this.b.add(iVar);
            }
            if (this.f13873d == null) {
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                this.f13873d = new ViewTreeObserverOnPreDrawListenerC0277a(this);
                viewTreeObserver.addOnPreDrawListener(this.f13873d);
            }
        }

        private boolean a(int i2, int i3) {
            return a(i2) && a(i3);
        }

        private int a(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            if (this.f13872c && this.a.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.a.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            Log.isLoggable("CustomViewTarget", 4);
            return a(this.a.getContext());
        }
    }

    @Override // com.bumptech.glide.request.k.j
    public final void a(@Nullable Drawable drawable) {
        c();
        e(drawable);
    }

    @Override // com.bumptech.glide.request.k.j
    public final void b(@Nullable Drawable drawable) {
        this.f13866s.b();
        d(drawable);
        if (this.f13869v) {
            return;
        }
        d();
    }

    @Override // com.bumptech.glide.request.k.j
    public final void a(@Nullable com.bumptech.glide.request.e eVar) {
        a((Object) eVar);
    }

    @Override // com.bumptech.glide.request.k.j
    @Nullable
    public final com.bumptech.glide.request.e a() {
        Object objB = b();
        if (objB == null) {
            return null;
        }
        if (objB instanceof com.bumptech.glide.request.e) {
            return (com.bumptech.glide.request.e) objB;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    @Nullable
    private Object b() {
        return this.f13867t.getTag(f13865x);
    }

    private void a(@Nullable Object obj) {
        this.f13867t.setTag(f13865x, obj);
    }
}
