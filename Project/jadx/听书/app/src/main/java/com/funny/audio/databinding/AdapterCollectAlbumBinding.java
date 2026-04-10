package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class AdapterCollectAlbumBinding implements ViewBinding {
    public final QMUIRadiusImageView ivCover;
    public final ImageView ivSelect;
    public final QMUIFrameLayout lyCover;
    public final QMUIFrameLayout lySelect;
    public final QMUIFrameLayout lyUpdateTip;
    private final ConstraintLayout rootView;
    public final TextView tvPlayProgress;
    public final TextView tvTitle;
    public final TextView tvUpdate;

    private AdapterCollectAlbumBinding(ConstraintLayout rootView, QMUIRadiusImageView ivCover, ImageView ivSelect, QMUIFrameLayout lyCover, QMUIFrameLayout lySelect, QMUIFrameLayout lyUpdateTip, TextView tvPlayProgress, TextView tvTitle, TextView tvUpdate) {
        this.rootView = rootView;
        this.ivCover = ivCover;
        this.ivSelect = ivSelect;
        this.lyCover = lyCover;
        this.lySelect = lySelect;
        this.lyUpdateTip = lyUpdateTip;
        this.tvPlayProgress = tvPlayProgress;
        this.tvTitle = tvTitle;
        this.tvUpdate = tvUpdate;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AdapterCollectAlbumBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdapterCollectAlbumBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.adapter_collect_album, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AdapterCollectAlbumBinding bind(View rootView) {
        int i = R.id.ivCover;
        QMUIRadiusImageView qMUIRadiusImageView = (QMUIRadiusImageView) ViewBindings.findChildViewById(rootView, i);
        if (qMUIRadiusImageView != null) {
            i = R.id.ivSelect;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.lyCover;
                QMUIFrameLayout qMUIFrameLayout = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
                if (qMUIFrameLayout != null) {
                    i = R.id.lySelect;
                    QMUIFrameLayout qMUIFrameLayout2 = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
                    if (qMUIFrameLayout2 != null) {
                        i = R.id.lyUpdateTip;
                        QMUIFrameLayout qMUIFrameLayout3 = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
                        if (qMUIFrameLayout3 != null) {
                            i = R.id.tvPlayProgress;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                i = R.id.tvTitle;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.tvUpdate;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        return new AdapterCollectAlbumBinding((ConstraintLayout) rootView, qMUIRadiusImageView, imageView, qMUIFrameLayout, qMUIFrameLayout2, qMUIFrameLayout3, textView, textView2, textView3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
