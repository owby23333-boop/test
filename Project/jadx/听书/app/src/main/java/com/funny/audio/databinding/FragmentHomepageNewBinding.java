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
public final class FragmentHomepageNewBinding implements ViewBinding {
    public final SmartRefreshLayout refreshLayout;
    private final StateLayout rootView;
    public final RecyclerView rvNews;
    public final StateLayout state;

    private FragmentHomepageNewBinding(StateLayout rootView, SmartRefreshLayout refreshLayout, RecyclerView rvNews, StateLayout state) {
        this.rootView = rootView;
        this.refreshLayout = refreshLayout;
        this.rvNews = rvNews;
        this.state = state;
    }

    @Override // androidx.viewbinding.ViewBinding
    public StateLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomepageNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentHomepageNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_homepage_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHomepageNewBinding bind(View rootView) {
        int i = R.id.refreshLayout;
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(rootView, i);
        if (smartRefreshLayout != null) {
            i = R.id.rvNews;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
            if (recyclerView != null) {
                StateLayout stateLayout = (StateLayout) rootView;
                return new FragmentHomepageNewBinding(stateLayout, smartRefreshLayout, recyclerView, stateLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
