package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityLoginBinding implements ViewBinding {
    public final ImageView appBack;
    public final QMUIFrameLayout btnLogin;
    public final ConstraintLayout container;
    public final EditText etAccount;
    public final EditText etPassword;
    public final LottieAnimationView loading;
    private final ConstraintLayout rootView;
    public final LinearLayout topBar;
    public final TextView tvForgetPassword;
    public final TextView tvRegister;

    private ActivityLoginBinding(ConstraintLayout rootView, ImageView appBack, QMUIFrameLayout btnLogin, ConstraintLayout container, EditText etAccount, EditText etPassword, LottieAnimationView loading, LinearLayout topBar, TextView tvForgetPassword, TextView tvRegister) {
        this.rootView = rootView;
        this.appBack = appBack;
        this.btnLogin = btnLogin;
        this.container = container;
        this.etAccount = etAccount;
        this.etPassword = etPassword;
        this.loading = loading;
        this.topBar = topBar;
        this.tvForgetPassword = tvForgetPassword;
        this.tvRegister = tvRegister;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLoginBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityLoginBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_login, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityLoginBinding bind(View rootView) {
        int i = R.id.appBack;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.btnLogin;
            QMUIFrameLayout qMUIFrameLayout = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
            if (qMUIFrameLayout != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                i = R.id.etAccount;
                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                if (editText != null) {
                    i = R.id.etPassword;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, i);
                    if (editText2 != null) {
                        i = R.id.loading;
                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(rootView, i);
                        if (lottieAnimationView != null) {
                            i = R.id.topBar;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                            if (linearLayout != null) {
                                i = R.id.tvForgetPassword;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView != null) {
                                    i = R.id.tvRegister;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView2 != null) {
                                        return new ActivityLoginBinding(constraintLayout, imageView, qMUIFrameLayout, constraintLayout, editText, editText2, lottieAnimationView, linearLayout, textView, textView2);
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
