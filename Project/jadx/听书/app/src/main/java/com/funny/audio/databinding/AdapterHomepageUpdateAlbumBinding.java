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
public final class AdapterHomepageUpdateAlbumBinding implements ViewBinding {
    public final QMUIRadiusImageView ivCover;
    public final QMUIConstraintLayout lyCover;
    private final QMUIConstraintLayout rootView;
    public final TextView tvDesc;
    public final TextView tvTitle;
    public final TextView tvUpdate;

    private AdapterHomepageUpdateAlbumBinding(QMUIConstraintLayout rootView, QMUIRadiusImageView ivCover, QMUIConstraintLayout lyCover, TextView tvDesc, TextView tvTitle, TextView tvUpdate) {
        this.rootView = rootView;
        this.ivCover = ivCover;
        this.lyCover = lyCover;
        this.tvDesc = tvDesc;
        this.tvTitle = tvTitle;
        this.tvUpdate = tvUpdate;
    }

    @Override // androidx.viewbinding.ViewBinding
    public QMUIConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AdapterHomepageUpdateAlbumBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdapterHomepageUpdateAlbumBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.adapter_homepage_update_album, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AdapterHomepageUpdateAlbumBinding bind(View rootView) {
        int i = R.id.ivCover;
        QMUIRadiusImageView qMUIRadiusImageView = (QMUIRadiusImageView) ViewBindings.findChildViewById(rootView, i);
        if (qMUIRadiusImageView != null) {
            i = R.id.lyCover;
            QMUIConstraintLayout qMUIConstraintLayout = (QMUIConstraintLayout) ViewBindings.findChildViewById(rootView, i);
            if (qMUIConstraintLayout != null) {
                i = R.id.tvDesc;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.tvTitle;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.tvUpdate;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            return new AdapterHomepageUpdateAlbumBinding((QMUIConstraintLayout) rootView, qMUIRadiusImageView, qMUIConstraintLayout, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
