package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;
import com.qmuiteam.qmui.widget.QMUISeekBar;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentTrackPlayerSpeedBinding implements ViewBinding {
    public final LinearLayout container;
    public final LinearLayout lySpeed;
    private final LinearLayout rootView;
    public final QMUISeekBar seekBarSpeed;
    public final TextView tvSpeed;

    private FragmentTrackPlayerSpeedBinding(LinearLayout rootView, LinearLayout container, LinearLayout lySpeed, QMUISeekBar seekBarSpeed, TextView tvSpeed) {
        this.rootView = rootView;
        this.container = container;
        this.lySpeed = lySpeed;
        this.seekBarSpeed = seekBarSpeed;
        this.tvSpeed = tvSpeed;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTrackPlayerSpeedBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentTrackPlayerSpeedBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_track_player_speed, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTrackPlayerSpeedBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.lySpeed;
        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout2 != null) {
            i = R.id.seekBarSpeed;
            QMUISeekBar qMUISeekBar = (QMUISeekBar) ViewBindings.findChildViewById(rootView, i);
            if (qMUISeekBar != null) {
                i = R.id.tvSpeed;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    return new FragmentTrackPlayerSpeedBinding(linearLayout, linearLayout, linearLayout2, qMUISeekBar, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
