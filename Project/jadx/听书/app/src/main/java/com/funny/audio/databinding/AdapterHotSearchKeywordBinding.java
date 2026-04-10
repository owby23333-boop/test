package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;

/* JADX INFO: loaded from: classes3.dex */
public final class AdapterHotSearchKeywordBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvHotSearchKeyword;

    private AdapterHotSearchKeywordBinding(ConstraintLayout rootView, TextView tvHotSearchKeyword) {
        this.rootView = rootView;
        this.tvHotSearchKeyword = tvHotSearchKeyword;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AdapterHotSearchKeywordBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdapterHotSearchKeywordBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.adapter_hot_search_keyword, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AdapterHotSearchKeywordBinding bind(View rootView) {
        int i = R.id.tvHotSearchKeyword;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            return new AdapterHotSearchKeywordBinding((ConstraintLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
