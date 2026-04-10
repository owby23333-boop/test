package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentPureModeRewardAdDialogBinding implements ViewBinding {
    public final QMUIFrameLayout btnInactive;
    public final QMUIFrameLayout btnPositive;
    public final LottieAnimationView loading;
    private final QMUIConstraintLayout rootView;
    public final TextView tvContent;
    public final TextView tvInactive;
    public final TextView tvPositive;
    public final TextView tvTitle;

    private FragmentPureModeRewardAdDialogBinding(QMUIConstraintLayout rootView, QMUIFrameLayout btnInactive, QMUIFrameLayout btnPositive, LottieAnimationView loading, TextView tvContent, TextView tvInactive, TextView tvPositive, TextView tvTitle) {
        this.rootView = rootView;
        this.btnInactive = btnInactive;
        this.btnPositive = btnPositive;
        this.loading = loading;
        this.tvContent = tvContent;
        this.tvInactive = tvInactive;
        this.tvPositive = tvPositive;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public QMUIConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPureModeRewardAdDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentPureModeRewardAdDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_pure_mode_reward_ad_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentPureModeRewardAdDialogBinding bind(View rootView) {
        int i = R.id.btnInactive;
        QMUIFrameLayout qMUIFrameLayout = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (qMUIFrameLayout != null) {
            i = R.id.btnPositive;
            QMUIFrameLayout qMUIFrameLayout2 = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
            if (qMUIFrameLayout2 != null) {
                i = R.id.loading;
                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(rootView, i);
                if (lottieAnimationView != null) {
                    i = R.id.tvContent;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.tvInactive;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.tvPositive;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                i = R.id.tvTitle;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView4 != null) {
                                    return new FragmentPureModeRewardAdDialogBinding((QMUIConstraintLayout) rootView, qMUIFrameLayout, qMUIFrameLayout2, lottieAnimationView, textView, textView2, textView3, textView4);
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
