package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUIButton;

/* JADX INFO: loaded from: classes3.dex */
public final class PageStateErrorBinding implements ViewBinding {
    public final QMUIButton btnPageRetry;
    private final ConstraintLayout rootView;

    private PageStateErrorBinding(ConstraintLayout rootView, QMUIButton btnPageRetry) {
        this.rootView = rootView;
        this.btnPageRetry = btnPageRetry;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static PageStateErrorBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PageStateErrorBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.page_state_error, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PageStateErrorBinding bind(View rootView) {
        int i = R.id.btnPageRetry;
        QMUIButton qMUIButton = (QMUIButton) ViewBindings.findChildViewById(rootView, i);
        if (qMUIButton != null) {
            return new PageStateErrorBinding((ConstraintLayout) rootView, qMUIButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
