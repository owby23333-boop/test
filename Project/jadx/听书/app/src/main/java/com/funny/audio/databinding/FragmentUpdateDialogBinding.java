package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.widget.QMUISlider;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentUpdateDialogBinding implements ViewBinding {
    public final QMUIFrameLayout btnCancel;
    public final QMUIFrameLayout btnUpdate;
    public final LinearLayout lyManualUpdate;
    public final LinearLayout lyUpdateProgress;
    private final QMUIConstraintLayout rootView;
    public final QMUISlider sliderUpdateProgress;
    public final TextView tvContent;
    public final TextView tvManualUpdate;
    public final TextView tvTitle;

    private FragmentUpdateDialogBinding(QMUIConstraintLayout rootView, QMUIFrameLayout btnCancel, QMUIFrameLayout btnUpdate, LinearLayout lyManualUpdate, LinearLayout lyUpdateProgress, QMUISlider sliderUpdateProgress, TextView tvContent, TextView tvManualUpdate, TextView tvTitle) {
        this.rootView = rootView;
        this.btnCancel = btnCancel;
        this.btnUpdate = btnUpdate;
        this.lyManualUpdate = lyManualUpdate;
        this.lyUpdateProgress = lyUpdateProgress;
        this.sliderUpdateProgress = sliderUpdateProgress;
        this.tvContent = tvContent;
        this.tvManualUpdate = tvManualUpdate;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public QMUIConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentUpdateDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentUpdateDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_update_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentUpdateDialogBinding bind(View rootView) {
        int i = R.id.btnCancel;
        QMUIFrameLayout qMUIFrameLayout = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (qMUIFrameLayout != null) {
            i = R.id.btnUpdate;
            QMUIFrameLayout qMUIFrameLayout2 = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
            if (qMUIFrameLayout2 != null) {
                i = R.id.lyManualUpdate;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout != null) {
                    i = R.id.lyUpdateProgress;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout2 != null) {
                        i = R.id.sliderUpdateProgress;
                        QMUISlider qMUISlider = (QMUISlider) ViewBindings.findChildViewById(rootView, i);
                        if (qMUISlider != null) {
                            i = R.id.tvContent;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                i = R.id.tvManualUpdate;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.tvTitle;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        return new FragmentUpdateDialogBinding((QMUIConstraintLayout) rootView, qMUIFrameLayout, qMUIFrameLayout2, linearLayout, linearLayout2, qMUISlider, textView, textView2, textView3);
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
