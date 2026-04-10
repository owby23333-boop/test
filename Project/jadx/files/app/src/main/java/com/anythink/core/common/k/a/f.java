package com.anythink.core.common.k.a;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    final int a;
    final ViewTreeObserver.OnPreDrawListener b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayList<View> f7642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<View, a> f7644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final b f7645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d f7646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final c f7647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Handler f7648j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f7649k;

    static class a {
        int a;
        int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f7650c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        View f7651d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Integer f7652e;

        a() {
        }
    }

    public static class b {
        private final Rect a = new Rect();

        private static boolean a(long j2, int i2) {
            return SystemClock.uptimeMillis() - j2 >= ((long) i2);
        }

        public final boolean a(View view, View view2, int i2, Integer num) {
            if (view2 == null || !view2.isShown() || view.getParent() == null || view2.getWindowVisibility() != 0 || !view2.getGlobalVisibleRect(this.a)) {
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
        private final ArrayList<View> f7653c = new ArrayList<>();
        private final ArrayList<View> b = new ArrayList<>();

        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            for (Map.Entry entry : f.this.f7644f.entrySet()) {
                View view = (View) entry.getKey();
                int i2 = ((a) entry.getValue()).a;
                int i3 = ((a) entry.getValue()).b;
                Integer num = ((a) entry.getValue()).f7652e;
                View view2 = ((a) entry.getValue()).f7651d;
                if (f.this.f7645g.a(view2, view, i2, num)) {
                    this.b.add(view);
                    try {
                        view.getViewTreeObserver().removeOnPreDrawListener(f.this.b);
                    } catch (Throwable unused) {
                    }
                } else if (!f.this.f7645g.a(view2, view, i3, null)) {
                    this.f7653c.add(view);
                }
            }
            if (f.this.f7646h != null) {
                f.this.f7646h.a(this.b);
            }
            this.b.clear();
            this.f7653c.clear();
            f.d(f.this);
        }
    }

    interface d {
        void a(List<View> list);
    }

    public f() {
        this(new WeakHashMap(10), new b(), new Handler(Looper.getMainLooper()));
    }

    static /* synthetic */ boolean d(f fVar) {
        fVar.f7649k = false;
        return false;
    }

    final void a(d dVar) {
        this.f7646h = dVar;
    }

    final void b() {
        a();
        this.f7646h = null;
    }

    final void c() {
        if (this.f7649k) {
            return;
        }
        this.f7649k = true;
        this.f7648j.postDelayed(this.f7647i, this.f7641c);
    }

    private void a(View view, View view2, int i2, Integer num) {
        a(view, view2, i2, i2, num);
    }

    public f(int i2) {
        this(new WeakHashMap(10), new b(), new Handler(Looper.getMainLooper()));
        this.f7641c = i2;
    }

    final void a(View view, View view2, int i2, int i3, Integer num) {
        try {
            if (a(view2.getContext(), view2)) {
                a aVar = this.f7644f.get(view2);
                if (aVar == null) {
                    aVar = new a();
                    this.f7644f.put(view2, aVar);
                    c();
                }
                int iMin = Math.min(i3, i2);
                aVar.f7651d = view;
                aVar.a = i2;
                aVar.b = iMin;
                aVar.f7650c = this.f7643e;
                aVar.f7652e = num;
                view2.getViewTreeObserver().addOnPreDrawListener(this.b);
                this.f7643e++;
                if (this.f7643e % 50 == 0) {
                    a(this.f7643e - 50);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private f(Map<View, a> map, b bVar, Handler handler) {
        this.f7641c = 100;
        this.a = 50;
        this.f7643e = 0L;
        this.f7644f = map;
        this.f7645g = bVar;
        this.f7648j = handler;
        this.f7647i = new c();
        this.f7642d = new ArrayList<>(50);
        this.b = new ViewTreeObserver.OnPreDrawListener() { // from class: com.anythink.core.common.k.a.f.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                f.this.c();
                return true;
            }
        };
    }

    private void a(long j2) {
        for (Map.Entry<View, a> entry : this.f7644f.entrySet()) {
            if (entry.getValue().f7650c < j2) {
                this.f7642d.add(entry.getKey());
            }
        }
        Iterator<View> it = this.f7642d.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.f7642d.clear();
    }

    final void a(View view) {
        this.f7644f.remove(view);
    }

    final void a() {
        this.f7644f.clear();
        this.f7648j.removeMessages(0);
        this.f7649k = false;
    }

    private static boolean a(Context context, View view) {
        View rootView;
        View viewFindViewById = null;
        View viewFindViewById2 = !(context instanceof Activity) ? null : ((Activity) context).getWindow().getDecorView().findViewById(R.id.content);
        if (view != null && (rootView = view.getRootView()) != null && (viewFindViewById = rootView.findViewById(R.id.content)) == null) {
            viewFindViewById = rootView;
        }
        if (viewFindViewById2 == null) {
            viewFindViewById2 = viewFindViewById;
        }
        return viewFindViewById2 != null && viewFindViewById2.getViewTreeObserver().isAlive();
    }

    private void a(View view, int i2, Integer num) {
        a(view, view, i2, i2, num);
    }
}
