package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityFeedbackBinding implements ViewBinding {
    public final ImageView appBack;
    public final QMUIFrameLayout btnSubmit;
    public final ConstraintLayout container;
    public final EditText etContact;
    public final EditText etContent;
    public final LottieAnimationView loading;
    public final QMUIFrameLayout lyType0;
    public final QMUIFrameLayout lyType1;
    public final QMUIFrameLayout lyType2;
    public final QMUIFrameLayout lyType3;
    private final ConstraintLayout rootView;
    public final ConstraintLayout topBar;
    public final TextView tvType0;
    public final TextView tvType1;
    public final TextView tvType2;
    public final TextView tvType3;

    private ActivityFeedbackBinding(ConstraintLayout rootView, ImageView appBack, QMUIFrameLayout btnSubmit, ConstraintLayout container, EditText etContact, EditText etContent, LottieAnimationView loading, QMUIFrameLayout lyType0, QMUIFrameLayout lyType1, QMUIFrameLayout lyType2, QMUIFrameLayout lyType3, ConstraintLayout topBar, TextView tvType0, TextView tvType1, TextView tvType2, TextView tvType3) {
        this.rootView = rootView;
        this.appBack = appBack;
        this.btnSubmit = btnSubmit;
        this.container = container;
        this.etContact = etContact;
        this.etContent = etContent;
        this.loading = loading;
        this.lyType0 = lyType0;
        this.lyType1 = lyType1;
        this.lyType2 = lyType2;
        this.lyType3 = lyType3;
        this.topBar = topBar;
        this.tvType0 = tvType0;
        this.tvType1 = tvType1;
        this.tvType2 = tvType2;
        this.tvType3 = tvType3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFeedbackBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityFeedbackBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_feedback, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFeedbackBinding bind(View rootView) {
        int i = R.id.appBack;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.btnSubmit;
            QMUIFrameLayout qMUIFrameLayout = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
            if (qMUIFrameLayout != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                i = R.id.etContact;
                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                if (editText != null) {
                    i = R.id.etContent;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, i);
                    if (editText2 != null) {
                        i = R.id.loading;
                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(rootView, i);
                        if (lottieAnimationView != null) {
                            i = R.id.lyType0;
                            QMUIFrameLayout qMUIFrameLayout2 = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
                            if (qMUIFrameLayout2 != null) {
                                i = R.id.lyType1;
                                QMUIFrameLayout qMUIFrameLayout3 = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
                                if (qMUIFrameLayout3 != null) {
                                    i = R.id.lyType2;
                                    QMUIFrameLayout qMUIFrameLayout4 = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (qMUIFrameLayout4 != null) {
                                        i = R.id.lyType3;
                                        QMUIFrameLayout qMUIFrameLayout5 = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (qMUIFrameLayout5 != null) {
                                            i = R.id.topBar;
                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (constraintLayout2 != null) {
                                                i = R.id.tvType0;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView != null) {
                                                    i = R.id.tvType1;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView2 != null) {
                                                        i = R.id.tvType2;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView3 != null) {
                                                            i = R.id.tvType3;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView4 != null) {
                                                                return new ActivityFeedbackBinding(constraintLayout, imageView, qMUIFrameLayout, constraintLayout, editText, editText2, lottieAnimationView, qMUIFrameLayout2, qMUIFrameLayout3, qMUIFrameLayout4, qMUIFrameLayout5, constraintLayout2, textView, textView2, textView3, textView4);
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
