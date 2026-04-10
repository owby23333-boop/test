package com.amgcyo.cuttadon.f;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: JingxuanImageAutoListener.java */
/* JADX INFO: loaded from: classes.dex */
public class r extends RecyclerView.OnScrollListener {
    private Context a;
    private a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3718c = 0;

    /* JADX INFO: compiled from: JingxuanImageAutoListener.java */
    public interface a {
        void a(int i2);
    }

    public r(Context context, a aVar) {
        this.a = context;
        this.b = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
        super.onScrollStateChanged(recyclerView, i2);
        if (i2 == 0) {
            try {
                if (this.a != null) {
                    com.bumptech.glide.c.e(this.a).resumeRequests();
                    return;
                }
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (i2 == 1 || i2 == 2) {
            try {
                if (this.a != null) {
                    com.bumptech.glide.c.e(this.a).pauseRequests();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i3) {
        super.onScrolled(recyclerView, i2, i3);
        a aVar = this.b;
        if (aVar != null) {
            this.f3718c += i3;
            aVar.a(this.f3718c);
        }
    }
}
