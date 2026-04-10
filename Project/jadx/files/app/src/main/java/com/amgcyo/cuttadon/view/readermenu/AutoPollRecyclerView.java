package com.amgcyo.cuttadon.view.readermenu;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class AutoPollRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    b f5326s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f5327t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f5328u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f5329v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f5330w;

    private static class b implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final WeakReference<AutoPollRecyclerView> f5331s;

        @Override // java.lang.Runnable
        public void run() {
            AutoPollRecyclerView autoPollRecyclerView = this.f5331s.get();
            if (autoPollRecyclerView != null && autoPollRecyclerView.f5327t && autoPollRecyclerView.f5329v) {
                if (AutoPollRecyclerView.a((RecyclerView) autoPollRecyclerView)) {
                    if (autoPollRecyclerView.f5330w) {
                        return;
                    }
                    autoPollRecyclerView.f5330w = true;
                } else {
                    autoPollRecyclerView.f5330w = false;
                    autoPollRecyclerView.scrollBy(0, autoPollRecyclerView.f5328u);
                    autoPollRecyclerView.postDelayed(autoPollRecyclerView.f5326s, 1L);
                }
            }
        }

        private b(AutoPollRecyclerView autoPollRecyclerView) {
            this.f5331s = new WeakReference<>(autoPollRecyclerView);
        }
    }

    public AutoPollRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5326s = new b();
    }

    public void b() {
        this.f5327t = false;
        removeCallbacks(this.f5326s);
    }

    public void a(int i2) {
        if (this.f5327t) {
            b();
        }
        this.f5329v = true;
        this.f5327t = true;
        this.f5328u = i2;
        postDelayed(this.f5326s, i2);
    }

    public static boolean a(RecyclerView recyclerView) {
        return recyclerView != null && recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange();
    }
}
