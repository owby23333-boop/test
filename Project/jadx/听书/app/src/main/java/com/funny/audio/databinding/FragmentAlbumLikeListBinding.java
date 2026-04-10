package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.drake.statelayout.StateLayout;
import com.funny.audio.R;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentAlbumLikeListBinding implements ViewBinding {
    private final StateLayout rootView;
    public final RecyclerView rvLikes;
    public final StateLayout state;

    private FragmentAlbumLikeListBinding(StateLayout rootView, RecyclerView rvLikes, StateLayout state) {
        this.rootView = rootView;
        this.rvLikes = rvLikes;
        this.state = state;
    }

    @Override // androidx.viewbinding.ViewBinding
    public StateLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAlbumLikeListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentAlbumLikeListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_album_like_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAlbumLikeListBinding bind(View rootView) {
        int i = R.id.rvLikes;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
        if (recyclerView != null) {
            StateLayout stateLayout = (StateLayout) rootView;
            return new FragmentAlbumLikeListBinding(stateLayout, recyclerView, stateLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
