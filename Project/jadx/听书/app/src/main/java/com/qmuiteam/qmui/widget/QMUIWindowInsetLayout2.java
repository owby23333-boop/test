package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.WindowInsetsCompat;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import com.qmuiteam.qmui.util.QMUIWindowInsetHelper;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class QMUIWindowInsetLayout2 extends QMUIConstraintLayout {
    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
    }

    public QMUIWindowInsetLayout2(Context context) {
        this(context, null);
    }

    public QMUIWindowInsetLayout2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIWindowInsetLayout2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        QMUIWindowInsetHelper.handleWindowInsets(view, WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.displayCutout());
    }
}
