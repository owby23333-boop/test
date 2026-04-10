package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.drake.statelayout.StateLayout;
import com.funny.audio.R;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentAlbumTrackListBinding implements ViewBinding {
    public final QMUIRoundButton btnBottom;
    public final QMUIRoundButton btnCurrent;
    public final QMUIRoundButton btnTop;
    public final LinearLayout lyTrackAscending;
    public final RelativeLayout lyTrackHeader;
    public final LinearLayout lyTrackSelections;
    private final StateLayout rootView;
    public final RecyclerView rvTrackSelections;
    public final RecyclerView rvTracks;
    public final StateLayout state;
    public final TextView tvTrackAscending;
    public final TextView tvTrackCount;

    private FragmentAlbumTrackListBinding(StateLayout rootView, QMUIRoundButton btnBottom, QMUIRoundButton btnCurrent, QMUIRoundButton btnTop, LinearLayout lyTrackAscending, RelativeLayout lyTrackHeader, LinearLayout lyTrackSelections, RecyclerView rvTrackSelections, RecyclerView rvTracks, StateLayout state, TextView tvTrackAscending, TextView tvTrackCount) {
        this.rootView = rootView;
        this.btnBottom = btnBottom;
        this.btnCurrent = btnCurrent;
        this.btnTop = btnTop;
        this.lyTrackAscending = lyTrackAscending;
        this.lyTrackHeader = lyTrackHeader;
        this.lyTrackSelections = lyTrackSelections;
        this.rvTrackSelections = rvTrackSelections;
        this.rvTracks = rvTracks;
        this.state = state;
        this.tvTrackAscending = tvTrackAscending;
        this.tvTrackCount = tvTrackCount;
    }

    @Override // androidx.viewbinding.ViewBinding
    public StateLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAlbumTrackListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentAlbumTrackListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_album_track_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAlbumTrackListBinding bind(View rootView) {
        int i = R.id.btnBottom;
        QMUIRoundButton qMUIRoundButton = (QMUIRoundButton) ViewBindings.findChildViewById(rootView, i);
        if (qMUIRoundButton != null) {
            i = R.id.btnCurrent;
            QMUIRoundButton qMUIRoundButton2 = (QMUIRoundButton) ViewBindings.findChildViewById(rootView, i);
            if (qMUIRoundButton2 != null) {
                i = R.id.btnTop;
                QMUIRoundButton qMUIRoundButton3 = (QMUIRoundButton) ViewBindings.findChildViewById(rootView, i);
                if (qMUIRoundButton3 != null) {
                    i = R.id.lyTrackAscending;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null) {
                        i = R.id.lyTrackHeader;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                        if (relativeLayout != null) {
                            i = R.id.lyTrackSelections;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                            if (linearLayout2 != null) {
                                i = R.id.rvTrackSelections;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                if (recyclerView != null) {
                                    i = R.id.rvTracks;
                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                    if (recyclerView2 != null) {
                                        StateLayout stateLayout = (StateLayout) rootView;
                                        i = R.id.tvTrackAscending;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView != null) {
                                            i = R.id.tvTrackCount;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView2 != null) {
                                                return new FragmentAlbumTrackListBinding(stateLayout, qMUIRoundButton, qMUIRoundButton2, qMUIRoundButton3, linearLayout, relativeLayout, linearLayout2, recyclerView, recyclerView2, stateLayout, textView, textView2);
                                            }
                                        }
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
