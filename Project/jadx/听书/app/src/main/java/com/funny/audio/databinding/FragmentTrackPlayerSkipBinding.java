package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.widget.QMUISlider;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentTrackPlayerSkipBinding implements ViewBinding {
    public final QMUIFrameLayout btnSaveSetting;
    public final LinearLayout container;
    private final LinearLayout rootView;
    public final QMUISlider sliderSkipEnd;
    public final QMUISlider sliderSkipStart;
    public final TextView tvSkipEnd;
    public final TextView tvSkipStart;

    private FragmentTrackPlayerSkipBinding(LinearLayout rootView, QMUIFrameLayout btnSaveSetting, LinearLayout container, QMUISlider sliderSkipEnd, QMUISlider sliderSkipStart, TextView tvSkipEnd, TextView tvSkipStart) {
        this.rootView = rootView;
        this.btnSaveSetting = btnSaveSetting;
        this.container = container;
        this.sliderSkipEnd = sliderSkipEnd;
        this.sliderSkipStart = sliderSkipStart;
        this.tvSkipEnd = tvSkipEnd;
        this.tvSkipStart = tvSkipStart;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTrackPlayerSkipBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentTrackPlayerSkipBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_track_player_skip, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTrackPlayerSkipBinding bind(View rootView) {
        int i = R.id.btnSaveSetting;
        QMUIFrameLayout qMUIFrameLayout = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (qMUIFrameLayout != null) {
            LinearLayout linearLayout = (LinearLayout) rootView;
            i = R.id.sliderSkipEnd;
            QMUISlider qMUISlider = (QMUISlider) ViewBindings.findChildViewById(rootView, i);
            if (qMUISlider != null) {
                i = R.id.sliderSkipStart;
                QMUISlider qMUISlider2 = (QMUISlider) ViewBindings.findChildViewById(rootView, i);
                if (qMUISlider2 != null) {
                    i = R.id.tvSkipEnd;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.tvSkipStart;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            return new FragmentTrackPlayerSkipBinding(linearLayout, qMUIFrameLayout, linearLayout, qMUISlider, qMUISlider2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
