package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.drake.statelayout.StateLayout;
import com.funny.audio.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentHomepageTabPageBinding implements ViewBinding {
    public final NestedScrollView nsv;
    public final SmartRefreshLayout refreshLayout;
    private final StateLayout rootView;
    public final RecyclerView rvGroups;
    public final StateLayout state;

    private FragmentHomepageTabPageBinding(StateLayout rootView, NestedScrollView nsv, SmartRefreshLayout refreshLayout, RecyclerView rvGroups, StateLayout state) {
        this.rootView = rootView;
        this.nsv = nsv;
        this.refreshLayout = refreshLayout;
        this.rvGroups = rvGroups;
        this.state = state;
    }

    @Override // androidx.viewbinding.ViewBinding
    public StateLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomepageTabPageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentHomepageTabPageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_homepage_tab_page, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHomepageTabPageBinding bind(View rootView) {
        int i = R.id.nsv;
        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, i);
        if (nestedScrollView != null) {
            i = R.id.refreshLayout;
            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(rootView, i);
            if (smartRefreshLayout != null) {
                i = R.id.rvGroups;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                if (recyclerView != null) {
                    StateLayout stateLayout = (StateLayout) rootView;
                    return new FragmentHomepageTabPageBinding(stateLayout, nestedScrollView, smartRefreshLayout, recyclerView, stateLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
