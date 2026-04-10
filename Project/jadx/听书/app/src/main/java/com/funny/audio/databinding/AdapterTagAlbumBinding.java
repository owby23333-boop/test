package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class AdapterTagAlbumBinding implements ViewBinding {
    public final QMUIRadiusImageView ivCover;
    private final ConstraintLayout rootView;
    public final TextView tvBottomLine;
    public final TextView tvDesc;
    public final TextView tvTitle;

    private AdapterTagAlbumBinding(ConstraintLayout rootView, QMUIRadiusImageView ivCover, TextView tvBottomLine, TextView tvDesc, TextView tvTitle) {
        this.rootView = rootView;
        this.ivCover = ivCover;
        this.tvBottomLine = tvBottomLine;
        this.tvDesc = tvDesc;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AdapterTagAlbumBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdapterTagAlbumBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.adapter_tag_album, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AdapterTagAlbumBinding bind(View rootView) {
        int i = R.id.ivCover;
        QMUIRadiusImageView qMUIRadiusImageView = (QMUIRadiusImageView) ViewBindings.findChildViewById(rootView, i);
        if (qMUIRadiusImageView != null) {
            i = R.id.tvBottomLine;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.tvDesc;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.tvTitle;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        return new AdapterTagAlbumBinding((ConstraintLayout) rootView, qMUIRadiusImageView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
