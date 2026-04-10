package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUILinearLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivitySystemSettingBinding implements ViewBinding {
    public final ImageView appBack;
    public final ConstraintLayout container;
    public final QMUILinearLayout lyAudioTop;
    public final QMUILinearLayout lyNotificationPlayer;
    public final QMUILinearLayout lySettingGroups3;
    private final ConstraintLayout rootView;
    public final ConstraintLayout topBar;
    public final TextView tvAudioTop;
    public final TextView tvNotificationPlayer;

    private ActivitySystemSettingBinding(ConstraintLayout rootView, ImageView appBack, ConstraintLayout container, QMUILinearLayout lyAudioTop, QMUILinearLayout lyNotificationPlayer, QMUILinearLayout lySettingGroups3, ConstraintLayout topBar, TextView tvAudioTop, TextView tvNotificationPlayer) {
        this.rootView = rootView;
        this.appBack = appBack;
        this.container = container;
        this.lyAudioTop = lyAudioTop;
        this.lyNotificationPlayer = lyNotificationPlayer;
        this.lySettingGroups3 = lySettingGroups3;
        this.topBar = topBar;
        this.tvAudioTop = tvAudioTop;
        this.tvNotificationPlayer = tvNotificationPlayer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySystemSettingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySystemSettingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_system_setting, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySystemSettingBinding bind(View rootView) {
        int i = R.id.appBack;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            i = R.id.lyAudioTop;
            QMUILinearLayout qMUILinearLayout = (QMUILinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (qMUILinearLayout != null) {
                i = R.id.lyNotificationPlayer;
                QMUILinearLayout qMUILinearLayout2 = (QMUILinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (qMUILinearLayout2 != null) {
                    i = R.id.lySettingGroups3;
                    QMUILinearLayout qMUILinearLayout3 = (QMUILinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (qMUILinearLayout3 != null) {
                        i = R.id.topBar;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                        if (constraintLayout2 != null) {
                            i = R.id.tvAudioTop;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                i = R.id.tvNotificationPlayer;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    return new ActivitySystemSettingBinding(constraintLayout, imageView, constraintLayout, qMUILinearLayout, qMUILinearLayout2, qMUILinearLayout3, constraintLayout2, textView, textView2);
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
