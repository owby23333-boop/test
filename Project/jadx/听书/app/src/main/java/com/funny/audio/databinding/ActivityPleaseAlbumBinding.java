package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityPleaseAlbumBinding implements ViewBinding {
    public final ImageView appBack;
    public final QMUIFrameLayout btnSubmit;
    public final ConstraintLayout container;
    public final EditText etAnnouncers;
    public final EditText etContent;
    public final EditText etPlatform;
    public final EditText etTitle;
    public final LottieAnimationView loading;
    private final ConstraintLayout rootView;
    public final ConstraintLayout topBar;

    private ActivityPleaseAlbumBinding(ConstraintLayout rootView, ImageView appBack, QMUIFrameLayout btnSubmit, ConstraintLayout container, EditText etAnnouncers, EditText etContent, EditText etPlatform, EditText etTitle, LottieAnimationView loading, ConstraintLayout topBar) {
        this.rootView = rootView;
        this.appBack = appBack;
        this.btnSubmit = btnSubmit;
        this.container = container;
        this.etAnnouncers = etAnnouncers;
        this.etContent = etContent;
        this.etPlatform = etPlatform;
        this.etTitle = etTitle;
        this.loading = loading;
        this.topBar = topBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPleaseAlbumBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityPleaseAlbumBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_please_album, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityPleaseAlbumBinding bind(View rootView) {
        int i = R.id.appBack;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.btnSubmit;
            QMUIFrameLayout qMUIFrameLayout = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
            if (qMUIFrameLayout != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                i = R.id.etAnnouncers;
                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                if (editText != null) {
                    i = R.id.etContent;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, i);
                    if (editText2 != null) {
                        i = R.id.etPlatform;
                        EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, i);
                        if (editText3 != null) {
                            i = R.id.etTitle;
                            EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, i);
                            if (editText4 != null) {
                                i = R.id.loading;
                                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(rootView, i);
                                if (lottieAnimationView != null) {
                                    i = R.id.topBar;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (constraintLayout2 != null) {
                                        return new ActivityPleaseAlbumBinding(constraintLayout, imageView, qMUIFrameLayout, constraintLayout, editText, editText2, editText3, editText4, lottieAnimationView, constraintLayout2);
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
