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
public final class AdapterSearchHistoryBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvSearchHistory;

    private AdapterSearchHistoryBinding(ConstraintLayout rootView, TextView tvSearchHistory) {
        this.rootView = rootView;
        this.tvSearchHistory = tvSearchHistory;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AdapterSearchHistoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdapterSearchHistoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.adapter_search_history, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AdapterSearchHistoryBinding bind(View rootView) {
        int i = R.id.tvSearchHistory;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            return new AdapterSearchHistoryBinding((ConstraintLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
