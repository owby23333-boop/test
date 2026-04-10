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
public final class ActivityUserEditBinding implements ViewBinding {
    public final ImageView appBack;
    public final QMUIFrameLayout btnSave;
    public final ConstraintLayout container;
    public final EditText etNickname;
    public final LottieAnimationView loading;
    private final ConstraintLayout rootView;
    public final ConstraintLayout topBar;
    public final TextView tvAccount;
    public final TextView tvEmail;
    public final TextView tvPhone;

    private ActivityUserEditBinding(ConstraintLayout rootView, ImageView appBack, QMUIFrameLayout btnSave, ConstraintLayout container, EditText etNickname, LottieAnimationView loading, ConstraintLayout topBar, TextView tvAccount, TextView tvEmail, TextView tvPhone) {
        this.rootView = rootView;
        this.appBack = appBack;
        this.btnSave = btnSave;
        this.container = container;
        this.etNickname = etNickname;
        this.loading = loading;
        this.topBar = topBar;
        this.tvAccount = tvAccount;
        this.tvEmail = tvEmail;
        this.tvPhone = tvPhone;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityUserEditBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityUserEditBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_user_edit, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityUserEditBinding bind(View rootView) {
        int i = R.id.appBack;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.btnSave;
            QMUIFrameLayout qMUIFrameLayout = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
            if (qMUIFrameLayout != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                i = R.id.etNickname;
                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                if (editText != null) {
                    i = R.id.loading;
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(rootView, i);
                    if (lottieAnimationView != null) {
                        i = R.id.topBar;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                        if (constraintLayout2 != null) {
                            i = R.id.tvAccount;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                i = R.id.tvEmail;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.tvPhone;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        return new ActivityUserEditBinding(constraintLayout, imageView, qMUIFrameLayout, constraintLayout, editText, lottieAnimationView, constraintLayout2, textView, textView2, textView3);
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
