package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class AdapterHistoryAlbumBinding implements ViewBinding {
    public final QMUIRadiusImageView ivCover;
    public final ImageView ivSelect;
    public final LinearLayout lySelect;
    public final LinearLayout lyTitle;
    private final LinearLayout rootView;
    public final TextView tvHistory;
    public final TextView tvProgress;
    public final TextView tvTitle;
    public final TextView tvUpdate;

    private AdapterHistoryAlbumBinding(LinearLayout rootView, QMUIRadiusImageView ivCover, ImageView ivSelect, LinearLayout lySelect, LinearLayout lyTitle, TextView tvHistory, TextView tvProgress, TextView tvTitle, TextView tvUpdate) {
        this.rootView = rootView;
        this.ivCover = ivCover;
        this.ivSelect = ivSelect;
        this.lySelect = lySelect;
        this.lyTitle = lyTitle;
        this.tvHistory = tvHistory;
        this.tvProgress = tvProgress;
        this.tvTitle = tvTitle;
        this.tvUpdate = tvUpdate;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AdapterHistoryAlbumBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdapterHistoryAlbumBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.adapter_history_album, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AdapterHistoryAlbumBinding bind(View rootView) {
        int i = R.id.ivCover;
        QMUIRadiusImageView qMUIRadiusImageView = (QMUIRadiusImageView) ViewBindings.findChildViewById(rootView, i);
        if (qMUIRadiusImageView != null) {
            i = R.id.ivSelect;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.lySelect;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout != null) {
                    i = R.id.lyTitle;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout2 != null) {
                        i = R.id.tvHistory;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            i = R.id.tvProgress;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView2 != null) {
                                i = R.id.tvTitle;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    i = R.id.tvUpdate;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView4 != null) {
                                        return new AdapterHistoryAlbumBinding((LinearLayout) rootView, qMUIRadiusImageView, imageView, linearLayout, linearLayout2, textView, textView2, textView3, textView4);
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
