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
public final class ActivityRegisterBinding implements ViewBinding {
    public final ImageView appBack;
    public final QMUIFrameLayout btnRegister;
    public final ConstraintLayout container;
    public final EditText etAccount;
    public final EditText etPassword1;
    public final EditText etPassword2;
    public final LottieAnimationView loading;
    private final ConstraintLayout rootView;
    public final LinearLayout topBar;
    public final TextView tvAccountTips;
    public final TextView tvPassword1Tips;
    public final TextView tvPassword2Tips;

    private ActivityRegisterBinding(ConstraintLayout rootView, ImageView appBack, QMUIFrameLayout btnRegister, ConstraintLayout container, EditText etAccount, EditText etPassword1, EditText etPassword2, LottieAnimationView loading, LinearLayout topBar, TextView tvAccountTips, TextView tvPassword1Tips, TextView tvPassword2Tips) {
        this.rootView = rootView;
        this.appBack = appBack;
        this.btnRegister = btnRegister;
        this.container = container;
        this.etAccount = etAccount;
        this.etPassword1 = etPassword1;
        this.etPassword2 = etPassword2;
        this.loading = loading;
        this.topBar = topBar;
        this.tvAccountTips = tvAccountTips;
        this.tvPassword1Tips = tvPassword1Tips;
        this.tvPassword2Tips = tvPassword2Tips;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityRegisterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityRegisterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_register, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityRegisterBinding bind(View rootView) {
        int i = R.id.appBack;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.btnRegister;
            QMUIFrameLayout qMUIFrameLayout = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
            if (qMUIFrameLayout != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                i = R.id.etAccount;
                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                if (editText != null) {
                    i = R.id.etPassword1;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, i);
                    if (editText2 != null) {
                        i = R.id.etPassword2;
                        EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, i);
                        if (editText3 != null) {
                            i = R.id.loading;
                            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(rootView, i);
                            if (lottieAnimationView != null) {
                                i = R.id.topBar;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                if (linearLayout != null) {
                                    i = R.id.tvAccountTips;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView != null) {
                                        i = R.id.tvPassword1Tips;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView2 != null) {
                                            i = R.id.tvPassword2Tips;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView3 != null) {
                                                return new ActivityRegisterBinding(constraintLayout, imageView, qMUIFrameLayout, constraintLayout, editText, editText2, editText3, lottieAnimationView, linearLayout, textView, textView2, textView3);
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
