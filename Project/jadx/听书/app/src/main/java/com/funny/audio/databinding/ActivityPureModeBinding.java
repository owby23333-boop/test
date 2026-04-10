package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityPureModeBinding implements ViewBinding {
    public final ImageView appBack;
    public final ConstraintLayout container;
    private final ConstraintLayout rootView;
    public final ConstraintLayout topBar;

    private ActivityPureModeBinding(ConstraintLayout rootView, ImageView appBack, ConstraintLayout container, ConstraintLayout topBar) {
        this.rootView = rootView;
        this.appBack = appBack;
        this.container = container;
        this.topBar = topBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPureModeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityPureModeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_pure_mode, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityPureModeBinding bind(View rootView) {
        int i = R.id.appBack;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            int i2 = R.id.topBar;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i2);
            if (constraintLayout2 != null) {
                return new ActivityPureModeBinding(constraintLayout, imageView, constraintLayout, constraintLayout2);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
