package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.drake.statelayout.StateLayout;
import com.funny.audio.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentHomepageUpdateBinding implements ViewBinding {
    public final SmartRefreshLayout refreshLayout;
    private final StateLayout rootView;
    public final RecyclerView rvUpdates;
    public final StateLayout state;

    private FragmentHomepageUpdateBinding(StateLayout rootView, SmartRefreshLayout refreshLayout, RecyclerView rvUpdates, StateLayout state) {
        this.rootView = rootView;
        this.refreshLayout = refreshLayout;
        this.rvUpdates = rvUpdates;
        this.state = state;
    }

    @Override // androidx.viewbinding.ViewBinding
    public StateLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomepageUpdateBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentHomepageUpdateBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_homepage_update, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHomepageUpdateBinding bind(View rootView) {
        int i = R.id.refreshLayout;
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(rootView, i);
        if (smartRefreshLayout != null) {
            i = R.id.rvUpdates;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
            if (recyclerView != null) {
                StateLayout stateLayout = (StateLayout) rootView;
                return new FragmentHomepageUpdateBinding(stateLayout, smartRefreshLayout, recyclerView, stateLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
