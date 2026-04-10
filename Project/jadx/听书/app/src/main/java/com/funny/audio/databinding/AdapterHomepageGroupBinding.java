package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import com.qmuiteam.qmui.layout.QMUIRelativeLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class AdapterHomepageGroupBinding implements ViewBinding {
    public final QMUIRelativeLayout lyGroupHeader;
    public final LinearLayout lyMore;
    private final QMUIConstraintLayout rootView;
    public final RecyclerView rvGroupItems;
    public final TextView tvGroupName;

    private AdapterHomepageGroupBinding(QMUIConstraintLayout rootView, QMUIRelativeLayout lyGroupHeader, LinearLayout lyMore, RecyclerView rvGroupItems, TextView tvGroupName) {
        this.rootView = rootView;
        this.lyGroupHeader = lyGroupHeader;
        this.lyMore = lyMore;
        this.rvGroupItems = rvGroupItems;
        this.tvGroupName = tvGroupName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public QMUIConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AdapterHomepageGroupBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdapterHomepageGroupBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.adapter_homepage_group, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AdapterHomepageGroupBinding bind(View rootView) {
        int i = R.id.lyGroupHeader;
        QMUIRelativeLayout qMUIRelativeLayout = (QMUIRelativeLayout) ViewBindings.findChildViewById(rootView, i);
        if (qMUIRelativeLayout != null) {
            i = R.id.lyMore;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.rvGroupItems;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                if (recyclerView != null) {
                    i = R.id.tvGroupName;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        return new AdapterHomepageGroupBinding((QMUIConstraintLayout) rootView, qMUIRelativeLayout, linearLayout, recyclerView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
