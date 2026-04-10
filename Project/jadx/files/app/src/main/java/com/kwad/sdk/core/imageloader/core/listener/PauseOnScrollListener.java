package com.kwad.sdk.core.imageloader.core.listener;

import android.widget.AbsListView;
import com.kwad.sdk.core.imageloader.core.ImageLoader;

/* JADX INFO: loaded from: classes3.dex */
public class PauseOnScrollListener implements AbsListView.OnScrollListener {
    private final AbsListView.OnScrollListener externalListener;
    private ImageLoader imageLoader;
    private final boolean pauseOnFling;
    private final boolean pauseOnScroll;

    public PauseOnScrollListener(ImageLoader imageLoader, boolean z2, boolean z3) {
        this(imageLoader, z2, z3, null);
    }

    public PauseOnScrollListener(ImageLoader imageLoader, boolean z2, boolean z3, AbsListView.OnScrollListener onScrollListener) {
        this.imageLoader = imageLoader;
        this.pauseOnScroll = z2;
        this.pauseOnFling = z3;
        this.externalListener = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AbsListView.OnScrollListener onScrollListener = this.externalListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i2, i3, i4);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 == 0) {
            this.imageLoader.resume();
        } else if (i2 == 1 ? this.pauseOnScroll : !(i2 != 2 || !this.pauseOnFling)) {
            this.imageLoader.pause();
        }
        AbsListView.OnScrollListener onScrollListener = this.externalListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i2);
        }
    }
}
