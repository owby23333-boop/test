package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.drake.statelayout.StateLayout;
import com.funny.audio.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentCategoryPageBinding implements ViewBinding {
    public final SmartRefreshLayout refreshLayout;
    private final ConstraintLayout rootView;
    public final RecyclerView rvAlbums;
    public final StateLayout state;

    private FragmentCategoryPageBinding(ConstraintLayout rootView, SmartRefreshLayout refreshLayout, RecyclerView rvAlbums, StateLayout state) {
        this.rootView = rootView;
        this.refreshLayout = refreshLayout;
        this.rvAlbums = rvAlbums;
        this.state = state;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCategoryPageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentCategoryPageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_category_page, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCategoryPageBinding bind(View rootView) {
        int i = R.id.refreshLayout;
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(rootView, i);
        if (smartRefreshLayout != null) {
            i = R.id.rvAlbums;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
            if (recyclerView != null) {
                i = R.id.state;
                StateLayout stateLayout = (StateLayout) ViewBindings.findChildViewById(rootView, i);
                if (stateLayout != null) {
                    return new FragmentCategoryPageBinding((ConstraintLayout) rootView, smartRefreshLayout, recyclerView, stateLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
