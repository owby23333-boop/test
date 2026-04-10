package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.funny.audio.R;

/* JADX INFO: loaded from: classes3.dex */
public final class PageStateLoadingBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private PageStateLoadingBinding(ConstraintLayout rootView) {
        this.rootView = rootView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static PageStateLoadingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PageStateLoadingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.page_state_loading, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PageStateLoadingBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new PageStateLoadingBinding((ConstraintLayout) rootView);
    }
}
