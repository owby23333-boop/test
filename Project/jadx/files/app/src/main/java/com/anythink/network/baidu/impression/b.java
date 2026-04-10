package com.anythink.network.baidu.impression;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
final class b {
    static final int a = 50;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f12395d = 1000;
    final ViewTreeObserver.OnPreDrawListener b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    WeakReference<ViewTreeObserver> f12396c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArrayList<View> f12397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f12398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<View, a> f12399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final C0235b f12400h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private d f12401i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final c f12402j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Handler f12403k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f12404l;

    static class a {
        int a;
        int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f12405c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        View f12406d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Integer f12407e;

        a() {
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.baidu.impression.b$b, reason: collision with other inner class name */
    static class C0235b {
        private final Rect a = new Rect();

        C0235b() {
        }

        private static boolean a(long j2, int i2) {
            return SystemClock.uptimeMillis() - j2 >= ((long) i2);
        }

        final boolean a(View view, View view2, int i2, Integer num) {
            if (view2 == null || view2.getVisibility() != 0 || view.getParent() == null || view2.getWindowVisibility() != 0 || !view2.getGlobalVisibleRect(this.a)) {
                return false;
            }
            long jHeight = ((long) this.a.height()) * ((long) this.a.width());
            long height = ((long) view2.getHeight()) * ((long) view2.getWidth());
            if (height <= 0) {
                return false;
            }
            return (num == null || num.intValue() <= 0) ? jHeight * 100 >= ((long) i2) * height : jHeight >= ((long) num.intValue());
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ArrayList<View> f12408c = new ArrayList<>();
        private final ArrayList<View> b = new ArrayList<>();

        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.a(b.this);
            for (Map.Entry entry : b.this.f12399g.entrySet()) {
                View view = (View) entry.getKey();
                int i2 = ((a) entry.getValue()).a;
                int i3 = ((a) entry.getValue()).b;
                Integer num = ((a) entry.getValue()).f12407e;
                View view2 = ((a) entry.getValue()).f12406d;
                if (b.this.f12400h.a(view2, view, i2, num)) {
                    this.b.add(view);
                } else if (!b.this.f12400h.a(view2, view, i3, null)) {
                    this.f12408c.add(view);
                }
            }
            if (b.this.f12401i != null) {
                b.this.f12401i.onVisibilityChanged(this.b, this.f12408c);
            }
            this.b.clear();
            this.f12408c.clear();
        }
    }

    interface d {
        void onVisibilityChanged(List<View> list, List<View> list2);
    }

    public b(Context context) {
        this(context, new WeakHashMap(10), new C0235b(), new Handler(Looper.getMainLooper()));
    }

    static /* synthetic */ boolean a(b bVar) {
        bVar.f12404l = false;
        return false;
    }

    private void a(Context context, View view) {
        View topmostView;
        ViewTreeObserver viewTreeObserver = this.f12396c.get();
        if ((viewTreeObserver == null || !viewTreeObserver.isAlive()) && (topmostView = BDViews.getTopmostView(context, view)) != null) {
            ViewTreeObserver viewTreeObserver2 = topmostView.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                this.f12396c = new WeakReference<>(viewTreeObserver2);
                viewTreeObserver2.addOnPreDrawListener(this.b);
            }
        }
    }

    final void b() {
        a();
        ViewTreeObserver viewTreeObserver = this.f12396c.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.b);
        }
        this.f12396c.clear();
        this.f12401i = null;
    }

    final void c() {
        if (this.f12404l) {
            return;
        }
        this.f12404l = true;
        this.f12403k.postDelayed(this.f12402j, f12395d);
    }

    public b(Context context, int i2) {
        this(context, new WeakHashMap(10), new C0235b(), new Handler(Looper.getMainLooper()));
        f12395d = i2;
    }

    private b(Context context, Map<View, a> map, C0235b c0235b, Handler handler) {
        this.f12398f = 0L;
        this.f12399g = map;
        this.f12400h = c0235b;
        this.f12403k = handler;
        this.f12402j = new c();
        this.f12397e = new ArrayList<>(50);
        this.b = new ViewTreeObserver.OnPreDrawListener() { // from class: com.anythink.network.baidu.impression.b.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                b.this.c();
                return true;
            }
        };
        this.f12396c = new WeakReference<>(null);
        a(context, null);
    }

    final void a(d dVar) {
        this.f12401i = dVar;
    }

    private void a(View view, View view2, int i2, Integer num) {
        a(view, view2, i2, i2, num);
    }

    final void a(View view, View view2, int i2, int i3, Integer num) {
        try {
            a(view2.getContext(), view2);
            a aVar = this.f12399g.get(view2);
            if (aVar == null) {
                aVar = new a();
                this.f12399g.put(view2, aVar);
                c();
            }
            int iMin = Math.min(i3, i2);
            aVar.f12406d = view;
            aVar.a = i2;
            aVar.b = iMin;
            aVar.f12405c = this.f12398f;
            aVar.f12407e = num;
            this.f12398f++;
            if (this.f12398f % 50 == 0) {
                a(this.f12398f - 50);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(long j2) {
        for (Map.Entry<View, a> entry : this.f12399g.entrySet()) {
            if (entry.getValue().f12405c < j2) {
                this.f12397e.add(entry.getKey());
            }
        }
        Iterator<View> it = this.f12397e.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.f12397e.clear();
    }

    final void a(View view) {
        this.f12399g.remove(view);
    }

    final void a() {
        this.f12399g.clear();
        this.f12403k.removeMessages(0);
        this.f12404l = false;
    }

    private void a(View view, int i2, Integer num) {
        a(view, view, i2, i2, num);
    }
}
