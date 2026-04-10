package com.amgcyo.cuttadon.f;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: ImageAutoListener.java */
/* JADX INFO: loaded from: classes.dex */
public class q extends RecyclerView.OnScrollListener {
    private Context a;

    public q(Context context) {
        this.a = context;
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
}
