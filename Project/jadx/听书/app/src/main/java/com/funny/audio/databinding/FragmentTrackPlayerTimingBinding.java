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
public final class FragmentTrackPlayerTimingBinding implements ViewBinding {
    public final LinearLayout container;
    public final LinearLayout lyTimingEpisode;
    public final LinearLayout lyTimingMinute;
    private final LinearLayout rootView;
    public final QMUISeekBar seekBarTimingEpisode;
    public final QMUISeekBar seekBarTimingMinute;
    public final TextView tvTimingEpisode;
    public final TextView tvTimingEpisodeLabel;
    public final TextView tvTimingMinute;
    public final TextView tvTimingMinuteLabel;

    private FragmentTrackPlayerTimingBinding(LinearLayout rootView, LinearLayout container, LinearLayout lyTimingEpisode, LinearLayout lyTimingMinute, QMUISeekBar seekBarTimingEpisode, QMUISeekBar seekBarTimingMinute, TextView tvTimingEpisode, TextView tvTimingEpisodeLabel, TextView tvTimingMinute, TextView tvTimingMinuteLabel) {
        this.rootView = rootView;
        this.container = container;
        this.lyTimingEpisode = lyTimingEpisode;
        this.lyTimingMinute = lyTimingMinute;
        this.seekBarTimingEpisode = seekBarTimingEpisode;
        this.seekBarTimingMinute = seekBarTimingMinute;
        this.tvTimingEpisode = tvTimingEpisode;
        this.tvTimingEpisodeLabel = tvTimingEpisodeLabel;
        this.tvTimingMinute = tvTimingMinute;
        this.tvTimingMinuteLabel = tvTimingMinuteLabel;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTrackPlayerTimingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentTrackPlayerTimingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_track_player_timing, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTrackPlayerTimingBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.lyTimingEpisode;
        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout2 != null) {
            i = R.id.lyTimingMinute;
            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout3 != null) {
                i = R.id.seekBarTimingEpisode;
                QMUISeekBar qMUISeekBar = (QMUISeekBar) ViewBindings.findChildViewById(rootView, i);
                if (qMUISeekBar != null) {
                    i = R.id.seekBarTimingMinute;
                    QMUISeekBar qMUISeekBar2 = (QMUISeekBar) ViewBindings.findChildViewById(rootView, i);
                    if (qMUISeekBar2 != null) {
                        i = R.id.tvTimingEpisode;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            i = R.id.tvTimingEpisodeLabel;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView2 != null) {
                                i = R.id.tvTimingMinute;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    i = R.id.tvTimingMinuteLabel;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView4 != null) {
                                        return new FragmentTrackPlayerTimingBinding(linearLayout, linearLayout, linearLayout2, linearLayout3, qMUISeekBar, qMUISeekBar2, textView, textView2, textView3, textView4);
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
