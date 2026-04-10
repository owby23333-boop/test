package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.WindowInsetsCompat;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.util.QMUIWindowInsetHelper;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class QMUIWindowInsetLayout extends QMUIFrameLayout {
    public QMUIWindowInsetLayout(Context context) {
        this(context, null);
    }

    public QMUIWindowInsetLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIWindowInsetLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        QMUIWindowInsetHelper.handleWindowInsets(view, WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.displayCutout());
    }
}
