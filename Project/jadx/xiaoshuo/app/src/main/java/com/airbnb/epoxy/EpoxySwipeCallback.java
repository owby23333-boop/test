package com.airbnb.epoxy;

import android.graphics.Canvas;
import android.view.View;
import com.airbnb.epoxy.EpoxyModel;

/* JADX INFO: loaded from: classes.dex */
public interface EpoxySwipeCallback<T extends EpoxyModel> extends BaseEpoxyTouchCallback<T> {
    void onSwipeCompleted(T t, View view, int i, int i2);

    void onSwipeProgressChanged(T t, View view, float f, Canvas canvas);

    void onSwipeReleased(T t, View view);

    void onSwipeStarted(T t, View view, int i);
}
