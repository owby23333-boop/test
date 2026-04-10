package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityNoticeBinding implements ViewBinding {
    public final ImageView appBack;
    public final ConstraintLayout container;
    private final ConstraintLayout rootView;
    public final RecyclerView rvNotices;
    public final ConstraintLayout topBar;

    private ActivityNoticeBinding(ConstraintLayout rootView, ImageView appBack, ConstraintLayout container, RecyclerView rvNotices, ConstraintLayout topBar) {
        this.rootView = rootView;
        this.appBack = appBack;
        this.container = container;
        this.rvNotices = rvNotices;
        this.topBar = topBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityNoticeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityNoticeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_notice, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityNoticeBinding bind(View rootView) {
        int i = R.id.appBack;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            i = R.id.rvNotices;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
            if (recyclerView != null) {
                i = R.id.topBar;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout2 != null) {
                    return new ActivityNoticeBinding(constraintLayout, imageView, constraintLayout, recyclerView, constraintLayout2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
