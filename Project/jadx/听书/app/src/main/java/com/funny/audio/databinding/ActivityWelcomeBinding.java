package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityWelcomeBinding implements ViewBinding {
    public final ConstraintLayout container;
    public final LinearLayout lyWelcomeTips;
    private final ConstraintLayout rootView;

    private ActivityWelcomeBinding(ConstraintLayout rootView, ConstraintLayout container, LinearLayout lyWelcomeTips) {
        this.rootView = rootView;
        this.container = container;
        this.lyWelcomeTips = lyWelcomeTips;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityWelcomeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityWelcomeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_welcome, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityWelcomeBinding bind(View rootView) {
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        int i = R.id.lyWelcomeTips;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            return new ActivityWelcomeBinding(constraintLayout, constraintLayout, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
