package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUILinearLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class AdapterAssociateBinding implements ViewBinding {
    public final ImageView ivRelationType;
    private final QMUILinearLayout rootView;
    public final TextView tvAssociate;

    private AdapterAssociateBinding(QMUILinearLayout rootView, ImageView ivRelationType, TextView tvAssociate) {
        this.rootView = rootView;
        this.ivRelationType = ivRelationType;
        this.tvAssociate = tvAssociate;
    }

    @Override // androidx.viewbinding.ViewBinding
    public QMUILinearLayout getRoot() {
        return this.rootView;
    }

    public static AdapterAssociateBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdapterAssociateBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.adapter_associate, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AdapterAssociateBinding bind(View rootView) {
        int i = R.id.ivRelationType;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.tvAssociate;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new AdapterAssociateBinding((QMUILinearLayout) rootView, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
