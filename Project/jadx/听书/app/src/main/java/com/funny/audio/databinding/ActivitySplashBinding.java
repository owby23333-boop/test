package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivitySplashBinding implements ViewBinding {
    public final QMUIFrameLayout btnOverTime;
    public final ConstraintLayout container;
    public final FrameLayout lyAdContainer;
    public final LinearLayout lyWelcomeTips;
    private final ConstraintLayout rootView;

    private ActivitySplashBinding(ConstraintLayout rootView, QMUIFrameLayout btnOverTime, ConstraintLayout container, FrameLayout lyAdContainer, LinearLayout lyWelcomeTips) {
        this.rootView = rootView;
        this.btnOverTime = btnOverTime;
        this.container = container;
        this.lyAdContainer = lyAdContainer;
        this.lyWelcomeTips = lyWelcomeTips;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySplashBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySplashBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_splash, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySplashBinding bind(View rootView) {
        int i = R.id.btnOverTime;
        QMUIFrameLayout qMUIFrameLayout = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (qMUIFrameLayout != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            i = R.id.lyAdContainer;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
            if (frameLayout != null) {
                i = R.id.lyWelcomeTips;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout != null) {
                    return new ActivitySplashBinding(constraintLayout, qMUIFrameLayout, constraintLayout, frameLayout, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
