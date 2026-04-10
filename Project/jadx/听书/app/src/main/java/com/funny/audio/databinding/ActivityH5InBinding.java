package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.funny.audio.R;
import com.qmuiteam.qmui.widget.webview.QMUIWebView;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityH5InBinding implements ViewBinding {
    public final ImageView appBack;
    public final ConstraintLayout container;
    public final LottieAnimationView loading;
    private final ConstraintLayout rootView;
    public final ConstraintLayout topBar;
    public final TextView tvTitle;
    public final QMUIWebView webview;

    private ActivityH5InBinding(ConstraintLayout rootView, ImageView appBack, ConstraintLayout container, LottieAnimationView loading, ConstraintLayout topBar, TextView tvTitle, QMUIWebView webview) {
        this.rootView = rootView;
        this.appBack = appBack;
        this.container = container;
        this.loading = loading;
        this.topBar = topBar;
        this.tvTitle = tvTitle;
        this.webview = webview;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityH5InBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityH5InBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_h5_in, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityH5InBinding bind(View rootView) {
        int i = R.id.appBack;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            i = R.id.loading;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(rootView, i);
            if (lottieAnimationView != null) {
                i = R.id.topBar;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout2 != null) {
                    i = R.id.tvTitle;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.webview;
                        QMUIWebView qMUIWebView = (QMUIWebView) ViewBindings.findChildViewById(rootView, i);
                        if (qMUIWebView != null) {
                            return new ActivityH5InBinding(constraintLayout, imageView, constraintLayout, lottieAnimationView, constraintLayout2, textView, qMUIWebView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
