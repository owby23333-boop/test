package com.bykv.vk.openvk.component.video.api.tg;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public interface bf<T> extends com.bykv.vk.openvk.component.video.api.bf.e {

    public enum e {
        hideCloseBtn,
        alwayShowBackBtn,
        alwayShowMediaView,
        fixedSize,
        hideBackBtn,
        hideTopMoreBtn
    }

    void bf();

    View d();

    void e();

    void e(int i);

    void e(Drawable drawable2);

    void e(T t, WeakReference<Context> weakReference, boolean z);

    void e(boolean z);
}
