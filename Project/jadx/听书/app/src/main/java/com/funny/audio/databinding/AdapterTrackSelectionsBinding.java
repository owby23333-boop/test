package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;
import com.funny.audio.view.core.MarqueeTextView;
import com.qmuiteam.qmui.layout.QMUILinearLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class AdapterTrackSelectionsBinding implements ViewBinding {
    public final QMUILinearLayout lySelection;
    private final ConstraintLayout rootView;
    public final MarqueeTextView tvSelection;

    private AdapterTrackSelectionsBinding(ConstraintLayout rootView, QMUILinearLayout lySelection, MarqueeTextView tvSelection) {
        this.rootView = rootView;
        this.lySelection = lySelection;
        this.tvSelection = tvSelection;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AdapterTrackSelectionsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdapterTrackSelectionsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.adapter_track_selections, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AdapterTrackSelectionsBinding bind(View rootView) {
        int i = R.id.lySelection;
        QMUILinearLayout qMUILinearLayout = (QMUILinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (qMUILinearLayout != null) {
            i = R.id.tvSelection;
            MarqueeTextView marqueeTextView = (MarqueeTextView) ViewBindings.findChildViewById(rootView, i);
            if (marqueeTextView != null) {
                return new AdapterTrackSelectionsBinding((ConstraintLayout) rootView, qMUILinearLayout, marqueeTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
