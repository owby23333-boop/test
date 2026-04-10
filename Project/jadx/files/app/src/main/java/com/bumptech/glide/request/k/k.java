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
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.R$id;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ViewTarget.java */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class k<T extends View, Z> extends com.bumptech.glide.request.k.a<Z> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static int f13878x = R$id.glide_custom_view_target_tag;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected final T f13879s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final a f13880t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private View.OnAttachStateChangeListener f13881u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f13882v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f13883w;

    public k(@NonNull T t2) {
        com.bumptech.glide.util.k.a(t2);
        this.f13879s = t2;
        this.f13880t = new a(t2);
    }

    @Nullable
    private Object c() {
        return this.f13879s.getTag(f13878x);
    }

    private void d() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f13881u;
        if (onAttachStateChangeListener == null || this.f13883w) {
            return;
        }
        this.f13879s.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f13883w = true;
    }

    private void e() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f13881u;
        if (onAttachStateChangeListener == null || !this.f13883w) {
            return;
        }
        this.f13879s.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f13883w = false;
    }

    @Override // com.bumptech.glide.request.k.a, com.bumptech.glide.request.k.j
    @CallSuper
    public void a(@Nullable Drawable drawable) {
        super.a(drawable);
        d();
    }

    @Override // com.bumptech.glide.request.k.j
    @CallSuper
    public void b(@NonNull i iVar) {
        this.f13880t.a(iVar);
    }

    public String toString() {
        return "Target for: " + this.f13879s;
    }

    /* JADX INFO: compiled from: ViewTarget.java */
    @VisibleForTesting
    static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        @VisibleForTesting
        static Integer f13884e;
        private final View a;
        private final List<i> b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f13885c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private ViewTreeObserverOnPreDrawListenerC0278a f13886d;

        /* JADX INFO: renamed from: com.bumptech.glide.request.k.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ViewTarget.java */
        private static final class ViewTreeObserverOnPreDrawListenerC0278a implements ViewTreeObserver.OnPreDrawListener {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            private final WeakReference<a> f13887s;

            ViewTreeObserverOnPreDrawListenerC0278a(@NonNull a aVar) {
                this.f13887s = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    String str = "OnGlobalLayoutListener called attachStateListener=" + this;
                }
                a aVar = this.f13887s.get();
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
            if (f13884e == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                com.bumptech.glide.util.k.a(windowManager);
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f13884e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f13884e.intValue();
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
                viewTreeObserver.removeOnPreDrawListener(this.f13886d);
            }
            this.f13886d = null;
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
            if (this.f13886d == null) {
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                this.f13886d = new ViewTreeObserverOnPreDrawListenerC0278a(this);
                viewTreeObserver.addOnPreDrawListener(this.f13886d);
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
            if (this.f13885c && this.a.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.a.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            Log.isLoggable("ViewTarget", 4);
            return a(this.a.getContext());
        }
    }

    @Override // com.bumptech.glide.request.k.a, com.bumptech.glide.request.k.j
    @CallSuper
    public void b(@Nullable Drawable drawable) {
        super.b(drawable);
        this.f13880t.b();
        if (this.f13882v) {
            return;
        }
        e();
    }

    @Override // com.bumptech.glide.request.k.j
    @CallSuper
    public void a(@NonNull i iVar) {
        this.f13880t.b(iVar);
    }

    @Override // com.bumptech.glide.request.k.j
    public void a(@Nullable com.bumptech.glide.request.e eVar) {
        a((Object) eVar);
    }

    @Override // com.bumptech.glide.request.k.j
    @Nullable
    public com.bumptech.glide.request.e a() {
        Object objC = c();
        if (objC == null) {
            return null;
        }
        if (objC instanceof com.bumptech.glide.request.e) {
            return (com.bumptech.glide.request.e) objC;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    private void a(@Nullable Object obj) {
        this.f13879s.setTag(f13878x, obj);
    }
}
