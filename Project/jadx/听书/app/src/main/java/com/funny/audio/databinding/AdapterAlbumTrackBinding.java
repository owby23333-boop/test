package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUILinearLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class AdapterAlbumTrackBinding implements ViewBinding {
    private final QMUILinearLayout rootView;
    public final LottieAnimationView trackPlaying;
    public final TextView tvPublishTime;
    public final TextView tvTrackTitle;

    private AdapterAlbumTrackBinding(QMUILinearLayout rootView, LottieAnimationView trackPlaying, TextView tvPublishTime, TextView tvTrackTitle) {
        this.rootView = rootView;
        this.trackPlaying = trackPlaying;
        this.tvPublishTime = tvPublishTime;
        this.tvTrackTitle = tvTrackTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public QMUILinearLayout getRoot() {
        return this.rootView;
    }

    public static AdapterAlbumTrackBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdapterAlbumTrackBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.adapter_album_track, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AdapterAlbumTrackBinding bind(View rootView) {
        int i = R.id.trackPlaying;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(rootView, i);
        if (lottieAnimationView != null) {
            i = R.id.tvPublishTime;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.tvTrackTitle;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    return new AdapterAlbumTrackBinding((QMUILinearLayout) rootView, lottieAnimationView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
