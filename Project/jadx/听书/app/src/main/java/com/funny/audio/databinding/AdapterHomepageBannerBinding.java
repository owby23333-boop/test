package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class AdapterHomepageBannerBinding implements ViewBinding {
    public final QMUIRadiusImageView ivCover;
    private final QMUIConstraintLayout rootView;

    private AdapterHomepageBannerBinding(QMUIConstraintLayout rootView, QMUIRadiusImageView ivCover) {
        this.rootView = rootView;
        this.ivCover = ivCover;
    }

    @Override // androidx.viewbinding.ViewBinding
    public QMUIConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AdapterHomepageBannerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdapterHomepageBannerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.adapter_homepage_banner, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AdapterHomepageBannerBinding bind(View rootView) {
        int i = R.id.ivCover;
        QMUIRadiusImageView qMUIRadiusImageView = (QMUIRadiusImageView) ViewBindings.findChildViewById(rootView, i);
        if (qMUIRadiusImageView != null) {
            return new AdapterHomepageBannerBinding((QMUIConstraintLayout) rootView, qMUIRadiusImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
