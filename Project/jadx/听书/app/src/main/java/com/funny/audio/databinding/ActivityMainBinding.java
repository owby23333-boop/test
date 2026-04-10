package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.angcyo.tablayout.DslTabLayout;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.widget.QMUIProgressBar;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.QMUIViewPager;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityMainBinding implements ViewBinding {
    public final ConstraintLayout container;
    public final QMUIRadiusImageView ivFloatPlayerCover;
    public final ImageView ivNavBookshelf;
    public final ImageView ivNavHomepage;
    public final ImageView ivNavMine;
    public final ImageView ivNavSquare;
    public final QMUIRadiusImageView ivPlay;
    public final LottieAnimationView loading;
    public final FrameLayout lyFloatPlayer;
    public final QMUIFrameLayout lyTab;
    public final QMUIProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final DslTabLayout tabSegment;
    public final TextView tvNavBookshelf;
    public final TextView tvNavHomepage;
    public final TextView tvNavMine;
    public final TextView tvNavSquare;
    public final QMUIViewPager viewPager;

    private ActivityMainBinding(ConstraintLayout rootView, ConstraintLayout container, QMUIRadiusImageView ivFloatPlayerCover, ImageView ivNavBookshelf, ImageView ivNavHomepage, ImageView ivNavMine, ImageView ivNavSquare, QMUIRadiusImageView ivPlay, LottieAnimationView loading, FrameLayout lyFloatPlayer, QMUIFrameLayout lyTab, QMUIProgressBar progressBar, DslTabLayout tabSegment, TextView tvNavBookshelf, TextView tvNavHomepage, TextView tvNavMine, TextView tvNavSquare, QMUIViewPager viewPager) {
        this.rootView = rootView;
        this.container = container;
        this.ivFloatPlayerCover = ivFloatPlayerCover;
        this.ivNavBookshelf = ivNavBookshelf;
        this.ivNavHomepage = ivNavHomepage;
        this.ivNavMine = ivNavMine;
        this.ivNavSquare = ivNavSquare;
        this.ivPlay = ivPlay;
        this.loading = loading;
        this.lyFloatPlayer = lyFloatPlayer;
        this.lyTab = lyTab;
        this.progressBar = progressBar;
        this.tabSegment = tabSegment;
        this.tvNavBookshelf = tvNavBookshelf;
        this.tvNavHomepage = tvNavHomepage;
        this.tvNavMine = tvNavMine;
        this.tvNavSquare = tvNavSquare;
        this.viewPager = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_main, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityMainBinding bind(View rootView) {
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        int i = R.id.ivFloatPlayerCover;
        QMUIRadiusImageView qMUIRadiusImageView = (QMUIRadiusImageView) ViewBindings.findChildViewById(rootView, i);
        if (qMUIRadiusImageView != null) {
            i = R.id.ivNavBookshelf;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.ivNavHomepage;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.ivNavMine;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView3 != null) {
                        i = R.id.ivNavSquare;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView4 != null) {
                            i = R.id.ivPlay;
                            QMUIRadiusImageView qMUIRadiusImageView2 = (QMUIRadiusImageView) ViewBindings.findChildViewById(rootView, i);
                            if (qMUIRadiusImageView2 != null) {
                                i = R.id.loading;
                                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(rootView, i);
                                if (lottieAnimationView != null) {
                                    i = R.id.lyFloatPlayer;
                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (frameLayout != null) {
                                        i = R.id.lyTab;
                                        QMUIFrameLayout qMUIFrameLayout = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (qMUIFrameLayout != null) {
                                            i = R.id.progressBar;
                                            QMUIProgressBar qMUIProgressBar = (QMUIProgressBar) ViewBindings.findChildViewById(rootView, i);
                                            if (qMUIProgressBar != null) {
                                                i = R.id.tabSegment;
                                                DslTabLayout dslTabLayout = (DslTabLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (dslTabLayout != null) {
                                                    i = R.id.tvNavBookshelf;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView != null) {
                                                        i = R.id.tvNavHomepage;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView2 != null) {
                                                            i = R.id.tvNavMine;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView3 != null) {
                                                                i = R.id.tvNavSquare;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView4 != null) {
                                                                    i = R.id.viewPager;
                                                                    QMUIViewPager qMUIViewPager = (QMUIViewPager) ViewBindings.findChildViewById(rootView, i);
                                                                    if (qMUIViewPager != null) {
                                                                        return new ActivityMainBinding(constraintLayout, constraintLayout, qMUIRadiusImageView, imageView, imageView2, imageView3, imageView4, qMUIRadiusImageView2, lottieAnimationView, frameLayout, qMUIFrameLayout, qMUIProgressBar, dslTabLayout, textView, textView2, textView3, textView4, qMUIViewPager);
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
