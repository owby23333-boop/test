package com.bykv.vk.openvk.component.video.api.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public interface g<T> extends com.bykv.vk.openvk.component.video.api.g.z {

    public enum z {
        hideCloseBtn,
        alwayShowBackBtn,
        alwayShowMediaView,
        fixedSize,
        hideBackBtn,
        hideTopMoreBtn
    }

    View dl();

    void g();

    void z();

    void z(int i);

    void z(Drawable drawable);

    void z(T t, WeakReference<Context> weakReference, boolean z2);

    void z(boolean z2);
}
