package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.qmuiteam.qmui.util.QMUINotchHelper;
import com.qmuiteam.qmui.util.QMUIWindowInsetHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUINotchConsumeLayout extends FrameLayout {
    public QMUINotchConsumeLayout(Context context) {
        this(context, null);
    }

    public QMUINotchConsumeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUINotchConsumeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        QMUIWindowInsetHelper.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: com.qmuiteam.qmui.widget.QMUINotchConsumeLayout.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                QMUINotchConsumeLayout.this.notifyInsetMaybeChanged();
                return windowInsetsCompat;
            }
        }, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (QMUINotchHelper.isNotchOfficialSupport()) {
            return;
        }
        notifyInsetMaybeChanged();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (QMUINotchHelper.isNotchOfficialSupport()) {
            return;
        }
        notifyInsetMaybeChanged();
    }

    public boolean notifyInsetMaybeChanged() {
        setPadding(QMUINotchHelper.getSafeInsetLeft(this), QMUINotchHelper.getSafeInsetTop(this), QMUINotchHelper.getSafeInsetRight(this), QMUINotchHelper.getSafeInsetBottom(this));
        return true;
    }
}
