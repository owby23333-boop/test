package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class AdapterHotSearchAlbumBinding implements ViewBinding {
    public final QMUIRadiusImageView ivCover;
    private final LinearLayout rootView;
    public final TextView tvSerialize;
    public final TextView tvTitle;

    private AdapterHotSearchAlbumBinding(LinearLayout rootView, QMUIRadiusImageView ivCover, TextView tvSerialize, TextView tvTitle) {
        this.rootView = rootView;
        this.ivCover = ivCover;
        this.tvSerialize = tvSerialize;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AdapterHotSearchAlbumBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdapterHotSearchAlbumBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.adapter_hot_search_album, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AdapterHotSearchAlbumBinding bind(View rootView) {
        int i = R.id.ivCover;
        QMUIRadiusImageView qMUIRadiusImageView = (QMUIRadiusImageView) ViewBindings.findChildViewById(rootView, i);
        if (qMUIRadiusImageView != null) {
            i = R.id.tvSerialize;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.tvTitle;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    return new AdapterHotSearchAlbumBinding((LinearLayout) rootView, qMUIRadiusImageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
