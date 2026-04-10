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
public final class AdapterGroupAlbumBinding implements ViewBinding {
    public final QMUIRadiusImageView ivCover;
    private final QMUIConstraintLayout rootView;
    public final TextView tvTitle;

    private AdapterGroupAlbumBinding(QMUIConstraintLayout rootView, QMUIRadiusImageView ivCover, TextView tvTitle) {
        this.rootView = rootView;
        this.ivCover = ivCover;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public QMUIConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AdapterGroupAlbumBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdapterGroupAlbumBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.adapter_group_album, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AdapterGroupAlbumBinding bind(View rootView) {
        int i = R.id.ivCover;
        QMUIRadiusImageView qMUIRadiusImageView = (QMUIRadiusImageView) ViewBindings.findChildViewById(rootView, i);
        if (qMUIRadiusImageView != null) {
            i = R.id.tvTitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new AdapterGroupAlbumBinding((QMUIConstraintLayout) rootView, qMUIRadiusImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
