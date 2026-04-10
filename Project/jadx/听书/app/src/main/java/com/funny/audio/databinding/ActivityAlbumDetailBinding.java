package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.angcyo.tablayout.DslTabLayout;
import com.funny.audio.R;
import com.funny.audio.view.core.MarqueeTextView;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.QMUIViewPager;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityAlbumDetailBinding implements ViewBinding {
    public final ImageView albumShare;
    public final ImageView appBack;
    public final QMUIFrameLayout btnPlay;
    public final ConstraintLayout container;
    public final ImageButton expandCollapse;
    public final TextView expandableText;
    public final ImageView ivCollectFlag;
    public final QMUIRadiusImageView ivCover;
    public final ImageView ivPlay;
    public final LinearLayout linearLayout;
    public final LinearLayout lyCollect;
    public final LinearLayout lyCollectFlag;
    public final LinearLayout lyPlayCount;
    public final LinearLayout lyScore;
    public final DslTabLayout lyTab;
    private final ConstraintLayout rootView;
    public final RecyclerView rvAlbumTags;
    public final QMUIConstraintLayout topBar;
    public final TextView tvAnnouncer;
    public final TextView tvCollect;
    public final TextView tvCollectFlag;
    public final TextView tvCollectUnit;
    public final ExpandableTextView tvDesc;
    public final TextView tvPlayCount;
    public final TextView tvPlayCountUnit;
    public final MarqueeTextView tvPlayText;
    public final TextView tvScore;
    public final TextView tvScoreUnit;
    public final TextView tvSerialize;
    public final MarqueeTextView tvTitle;
    public final QMUIViewPager viewPager;

    private ActivityAlbumDetailBinding(ConstraintLayout rootView, ImageView albumShare, ImageView appBack, QMUIFrameLayout btnPlay, ConstraintLayout container, ImageButton expandCollapse, TextView expandableText, ImageView ivCollectFlag, QMUIRadiusImageView ivCover, ImageView ivPlay, LinearLayout linearLayout, LinearLayout lyCollect, LinearLayout lyCollectFlag, LinearLayout lyPlayCount, LinearLayout lyScore, DslTabLayout lyTab, RecyclerView rvAlbumTags, QMUIConstraintLayout topBar, TextView tvAnnouncer, TextView tvCollect, TextView tvCollectFlag, TextView tvCollectUnit, ExpandableTextView tvDesc, TextView tvPlayCount, TextView tvPlayCountUnit, MarqueeTextView tvPlayText, TextView tvScore, TextView tvScoreUnit, TextView tvSerialize, MarqueeTextView tvTitle, QMUIViewPager viewPager) {
        this.rootView = rootView;
        this.albumShare = albumShare;
        this.appBack = appBack;
        this.btnPlay = btnPlay;
        this.container = container;
        this.expandCollapse = expandCollapse;
        this.expandableText = expandableText;
        this.ivCollectFlag = ivCollectFlag;
        this.ivCover = ivCover;
        this.ivPlay = ivPlay;
        this.linearLayout = linearLayout;
        this.lyCollect = lyCollect;
        this.lyCollectFlag = lyCollectFlag;
        this.lyPlayCount = lyPlayCount;
        this.lyScore = lyScore;
        this.lyTab = lyTab;
        this.rvAlbumTags = rvAlbumTags;
        this.topBar = topBar;
        this.tvAnnouncer = tvAnnouncer;
        this.tvCollect = tvCollect;
        this.tvCollectFlag = tvCollectFlag;
        this.tvCollectUnit = tvCollectUnit;
        this.tvDesc = tvDesc;
        this.tvPlayCount = tvPlayCount;
        this.tvPlayCountUnit = tvPlayCountUnit;
        this.tvPlayText = tvPlayText;
        this.tvScore = tvScore;
        this.tvScoreUnit = tvScoreUnit;
        this.tvSerialize = tvSerialize;
        this.tvTitle = tvTitle;
        this.viewPager = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAlbumDetailBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityAlbumDetailBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_album_detail, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityAlbumDetailBinding bind(View rootView) {
        int i = R.id.albumShare;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.appBack;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                i = R.id.btnPlay;
                QMUIFrameLayout qMUIFrameLayout = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
                if (qMUIFrameLayout != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                    i = com.ms.square.android.expandabletextview.R.id.expand_collapse;
                    ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, i);
                    if (imageButton != null) {
                        i = com.ms.square.android.expandabletextview.R.id.expandable_text;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            i = R.id.ivCollectFlag;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView3 != null) {
                                i = R.id.ivCover;
                                QMUIRadiusImageView qMUIRadiusImageView = (QMUIRadiusImageView) ViewBindings.findChildViewById(rootView, i);
                                if (qMUIRadiusImageView != null) {
                                    i = R.id.ivPlay;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (imageView4 != null) {
                                        i = R.id.linearLayout;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (linearLayout != null) {
                                            i = R.id.lyCollect;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (linearLayout2 != null) {
                                                i = R.id.lyCollectFlag;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (linearLayout3 != null) {
                                                    i = R.id.lyPlayCount;
                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (linearLayout4 != null) {
                                                        i = R.id.lyScore;
                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (linearLayout5 != null) {
                                                            i = R.id.lyTab;
                                                            DslTabLayout dslTabLayout = (DslTabLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (dslTabLayout != null) {
                                                                i = R.id.rvAlbumTags;
                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                if (recyclerView != null) {
                                                                    i = R.id.topBar;
                                                                    QMUIConstraintLayout qMUIConstraintLayout = (QMUIConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                    if (qMUIConstraintLayout != null) {
                                                                        i = R.id.tvAnnouncer;
                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView2 != null) {
                                                                            i = R.id.tvCollect;
                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView3 != null) {
                                                                                i = R.id.tvCollectFlag;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (textView4 != null) {
                                                                                    i = R.id.tvCollectUnit;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (textView5 != null) {
                                                                                        i = R.id.tvDesc;
                                                                                        ExpandableTextView expandableTextView = (ExpandableTextView) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (expandableTextView != null) {
                                                                                            i = R.id.tvPlayCount;
                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (textView6 != null) {
                                                                                                i = R.id.tvPlayCountUnit;
                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (textView7 != null) {
                                                                                                    i = R.id.tvPlayText;
                                                                                                    MarqueeTextView marqueeTextView = (MarqueeTextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (marqueeTextView != null) {
                                                                                                        i = R.id.tvScore;
                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                        if (textView8 != null) {
                                                                                                            i = R.id.tvScoreUnit;
                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                            if (textView9 != null) {
                                                                                                                i = R.id.tvSerialize;
                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                if (textView10 != null) {
                                                                                                                    i = R.id.tvTitle;
                                                                                                                    MarqueeTextView marqueeTextView2 = (MarqueeTextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                                    if (marqueeTextView2 != null) {
                                                                                                                        i = R.id.viewPager;
                                                                                                                        QMUIViewPager qMUIViewPager = (QMUIViewPager) ViewBindings.findChildViewById(rootView, i);
                                                                                                                        if (qMUIViewPager != null) {
                                                                                                                            return new ActivityAlbumDetailBinding(constraintLayout, imageView, imageView2, qMUIFrameLayout, constraintLayout, imageButton, textView, imageView3, qMUIRadiusImageView, imageView4, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, dslTabLayout, recyclerView, qMUIConstraintLayout, textView2, textView3, textView4, textView5, expandableTextView, textView6, textView7, marqueeTextView, textView8, textView9, textView10, marqueeTextView2, qMUIViewPager);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
