package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class AdapterDetailLikeAlbumBinding implements ViewBinding {
    public final QMUIRadiusImageView ivCover;
    public final QMUIConstraintLayout lyCover;
    private final QMUIConstraintLayout rootView;
    public final TextView tvTitle;

    private AdapterDetailLikeAlbumBinding(QMUIConstraintLayout rootView, QMUIRadiusImageView ivCover, QMUIConstraintLayout lyCover, TextView tvTitle) {
        this.rootView = rootView;
        this.ivCover = ivCover;
        this.lyCover = lyCover;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public QMUIConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AdapterDetailLikeAlbumBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdapterDetailLikeAlbumBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.adapter_detail_like_album, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AdapterDetailLikeAlbumBinding bind(View rootView) {
        int i = R.id.ivCover;
        QMUIRadiusImageView qMUIRadiusImageView = (QMUIRadiusImageView) ViewBindings.findChildViewById(rootView, i);
        if (qMUIRadiusImageView != null) {
            i = R.id.lyCover;
            QMUIConstraintLayout qMUIConstraintLayout = (QMUIConstraintLayout) ViewBindings.findChildViewById(rootView, i);
            if (qMUIConstraintLayout != null) {
                i = R.id.tvTitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    return new AdapterDetailLikeAlbumBinding((QMUIConstraintLayout) rootView, qMUIRadiusImageView, qMUIConstraintLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
