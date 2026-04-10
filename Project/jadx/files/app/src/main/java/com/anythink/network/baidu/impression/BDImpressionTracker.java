package com.anythink.network.baidu.impression;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import com.anythink.network.baidu.impression.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class BDImpressionTracker {
    private static final int a = 100;
    private final b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<View, BDImpressionInterface> f12389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<View, com.anythink.network.baidu.impression.a<BDImpressionInterface>> f12390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f12391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a f12392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final b.C0235b f12393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b.d f12394h;

    class a implements Runnable {
        private final ArrayList<View> b = new ArrayList<>();

        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            for (Map.Entry entry : BDImpressionTracker.this.f12390d.entrySet()) {
                View view = (View) entry.getKey();
                com.anythink.network.baidu.impression.a aVar = (com.anythink.network.baidu.impression.a) entry.getValue();
                b.C0235b unused = BDImpressionTracker.this.f12393g;
                if (SystemClock.uptimeMillis() - aVar.b >= ((long) ((BDImpressionInterface) aVar.a).getImpressionMinTimeViewed())) {
                    ((BDImpressionInterface) aVar.a).recordImpression(view);
                    ((BDImpressionInterface) aVar.a).setImpressionRecorded();
                    this.b.add(view);
                }
            }
            Iterator<View> it = this.b.iterator();
            while (it.hasNext()) {
                BDImpressionTracker.this.removeView(it.next());
            }
            this.b.clear();
            if (BDImpressionTracker.this.f12390d.isEmpty()) {
                return;
            }
            BDImpressionTracker.this.a();
        }
    }

    public BDImpressionTracker(Context context) {
        this(new WeakHashMap(), new WeakHashMap(), new b.C0235b(), new b(context), new Handler(Looper.getMainLooper()));
    }

    public void addView(View view, BDImpressionInterface bDImpressionInterface) {
        if (this.f12389c.get(view) == bDImpressionInterface) {
            return;
        }
        removeView(view);
        if (bDImpressionInterface.isImpressionRecorded()) {
            return;
        }
        this.f12389c.put(view, bDImpressionInterface);
        b bVar = this.b;
        int impressionMinPercentageViewed = bDImpressionInterface.getImpressionMinPercentageViewed();
        bVar.a(view, view, impressionMinPercentageViewed, impressionMinPercentageViewed, bDImpressionInterface.getImpressionMinVisiblePx());
    }

    public void clear() {
        this.f12389c.clear();
        this.f12390d.clear();
        this.b.a();
        this.f12391e.removeMessages(0);
    }

    public void destroy() {
        clear();
        this.b.b();
        this.f12394h = null;
    }

    public void removeView(View view) {
        this.f12389c.remove(view);
        this.f12390d.remove(view);
        this.b.a(view);
    }

    @Deprecated
    private b.d b() {
        return this.f12394h;
    }

    final void a() {
        if (this.f12391e.hasMessages(0)) {
            return;
        }
        this.f12391e.postDelayed(this.f12392f, 100L);
    }

    public BDImpressionTracker(Context context, int i2) {
        this(new WeakHashMap(), new WeakHashMap(), new b.C0235b(), new b(context, i2), new Handler(Looper.getMainLooper()));
    }

    private void a(View view) {
        this.f12390d.remove(view);
    }

    private BDImpressionTracker(Map<View, BDImpressionInterface> map, Map<View, com.anythink.network.baidu.impression.a<BDImpressionInterface>> map2, b.C0235b c0235b, b bVar, Handler handler) {
        this.f12389c = map;
        this.f12390d = map2;
        this.f12393g = c0235b;
        this.b = bVar;
        this.f12394h = new b.d() { // from class: com.anythink.network.baidu.impression.BDImpressionTracker.1
            @Override // com.anythink.network.baidu.impression.b.d
            public final void onVisibilityChanged(List<View> list, List<View> list2) {
                for (View view : list) {
                    BDImpressionInterface bDImpressionInterface = (BDImpressionInterface) BDImpressionTracker.this.f12389c.get(view);
                    if (bDImpressionInterface == null) {
                        BDImpressionTracker.this.removeView(view);
                    } else {
                        com.anythink.network.baidu.impression.a aVar = (com.anythink.network.baidu.impression.a) BDImpressionTracker.this.f12390d.get(view);
                        if (aVar == null || !bDImpressionInterface.equals(aVar.a)) {
                            BDImpressionTracker.this.f12390d.put(view, new com.anythink.network.baidu.impression.a(bDImpressionInterface));
                        }
                    }
                }
                Iterator<View> it = list2.iterator();
                while (it.hasNext()) {
                    BDImpressionTracker.this.f12390d.remove(it.next());
                }
                BDImpressionTracker.this.a();
            }
        };
        this.b.a(this.f12394h);
        this.f12391e = handler;
        this.f12392f = new a();
    }
}
