package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.funny.audio.R;
import com.funny.audio.view.core.MarqueeTextView;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.QMUISlider;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityTrackPlayerBinding implements ViewBinding {
    public final ConstraintLayout container;
    public final ImageView ivAlbumDetail;
    public final ImageView ivBackward;
    public final ImageView ivBookShelf;
    public final QMUIRadiusImageView ivCover;
    public final ImageView ivForward;
    public final ImageView ivPlay;
    public final ImageView ivSeekToNext;
    public final ImageView ivSeekToPrevious;
    public final ImageView ivTrackRetract;
    public final FrameLayout lyAdContainer;
    public final LinearLayout lyBookshelf;
    public final LottieAnimationView lyLoading;
    public final FrameLayout lyPlay;
    public final LinearLayout lySkip;
    public final LinearLayout lySpeed;
    public final LinearLayout lyTiming;
    public final LinearLayout lyTrackList;
    private final ConstraintLayout rootView;
    public final QMUISlider slider;
    public final QMUIConstraintLayout topBar;
    public final ImageView trackReport;
    public final TextView tvAlbumTitle;
    public final TextView tvBookshelf;
    public final TextView tvProgressTime;
    public final TextView tvTiming;
    public final TextView tvTotalTime;
    public final MarqueeTextView tvTrackTitle;

    private ActivityTrackPlayerBinding(ConstraintLayout rootView, ConstraintLayout container, ImageView ivAlbumDetail, ImageView ivBackward, ImageView ivBookShelf, QMUIRadiusImageView ivCover, ImageView ivForward, ImageView ivPlay, ImageView ivSeekToNext, ImageView ivSeekToPrevious, ImageView ivTrackRetract, FrameLayout lyAdContainer, LinearLayout lyBookshelf, LottieAnimationView lyLoading, FrameLayout lyPlay, LinearLayout lySkip, LinearLayout lySpeed, LinearLayout lyTiming, LinearLayout lyTrackList, QMUISlider slider, QMUIConstraintLayout topBar, ImageView trackReport, TextView tvAlbumTitle, TextView tvBookshelf, TextView tvProgressTime, TextView tvTiming, TextView tvTotalTime, MarqueeTextView tvTrackTitle) {
        this.rootView = rootView;
        this.container = container;
        this.ivAlbumDetail = ivAlbumDetail;
        this.ivBackward = ivBackward;
        this.ivBookShelf = ivBookShelf;
        this.ivCover = ivCover;
        this.ivForward = ivForward;
        this.ivPlay = ivPlay;
        this.ivSeekToNext = ivSeekToNext;
        this.ivSeekToPrevious = ivSeekToPrevious;
        this.ivTrackRetract = ivTrackRetract;
        this.lyAdContainer = lyAdContainer;
        this.lyBookshelf = lyBookshelf;
        this.lyLoading = lyLoading;
        this.lyPlay = lyPlay;
        this.lySkip = lySkip;
        this.lySpeed = lySpeed;
        this.lyTiming = lyTiming;
        this.lyTrackList = lyTrackList;
        this.slider = slider;
        this.topBar = topBar;
        this.trackReport = trackReport;
        this.tvAlbumTitle = tvAlbumTitle;
        this.tvBookshelf = tvBookshelf;
        this.tvProgressTime = tvProgressTime;
        this.tvTiming = tvTiming;
        this.tvTotalTime = tvTotalTime;
        this.tvTrackTitle = tvTrackTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTrackPlayerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityTrackPlayerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_track_player, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityTrackPlayerBinding bind(View rootView) {
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        int i = R.id.ivAlbumDetail;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.ivBackward;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                i = R.id.ivBookShelf;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView3 != null) {
                    i = R.id.ivCover;
                    QMUIRadiusImageView qMUIRadiusImageView = (QMUIRadiusImageView) ViewBindings.findChildViewById(rootView, i);
                    if (qMUIRadiusImageView != null) {
                        i = R.id.ivForward;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView4 != null) {
                            i = R.id.ivPlay;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView5 != null) {
                                i = R.id.ivSeekToNext;
                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView6 != null) {
                                    i = R.id.ivSeekToPrevious;
                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (imageView7 != null) {
                                        i = R.id.ivTrackRetract;
                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                        if (imageView8 != null) {
                                            i = R.id.lyAdContainer;
                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (frameLayout != null) {
                                                i = R.id.lyBookshelf;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (linearLayout != null) {
                                                    i = R.id.lyLoading;
                                                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(rootView, i);
                                                    if (lottieAnimationView != null) {
                                                        i = R.id.lyPlay;
                                                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (frameLayout2 != null) {
                                                            i = R.id.lySkip;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (linearLayout2 != null) {
                                                                i = R.id.lySpeed;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (linearLayout3 != null) {
                                                                    i = R.id.lyTiming;
                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                    if (linearLayout4 != null) {
                                                                        i = R.id.lyTrackList;
                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                        if (linearLayout5 != null) {
                                                                            i = R.id.slider;
                                                                            QMUISlider qMUISlider = (QMUISlider) ViewBindings.findChildViewById(rootView, i);
                                                                            if (qMUISlider != null) {
                                                                                i = R.id.topBar;
                                                                                QMUIConstraintLayout qMUIConstraintLayout = (QMUIConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                if (qMUIConstraintLayout != null) {
                                                                                    i = R.id.trackReport;
                                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (imageView9 != null) {
                                                                                        i = R.id.tvAlbumTitle;
                                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (textView != null) {
                                                                                            i = R.id.tvBookshelf;
                                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (textView2 != null) {
                                                                                                i = R.id.tvProgressTime;
                                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (textView3 != null) {
                                                                                                    i = R.id.tvTiming;
                                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (textView4 != null) {
                                                                                                        i = R.id.tvTotalTime;
                                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (textView5 != null) {
                                                                                                            i = R.id.tvTrackTitle;
                                                                                                            MarqueeTextView marqueeTextView = (MarqueeTextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (marqueeTextView != null) {
                                                                                                                return new ActivityTrackPlayerBinding(constraintLayout, constraintLayout, imageView, imageView2, imageView3, qMUIRadiusImageView, imageView4, imageView5, imageView6, imageView7, imageView8, frameLayout, linearLayout, lottieAnimationView, frameLayout2, linearLayout2, linearLayout3, linearLayout4, linearLayout5, qMUISlider, qMUIConstraintLayout, imageView9, textView, textView2, textView3, textView4, textView5, marqueeTextView);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
