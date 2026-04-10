package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUILinearLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class AdapterSystemNoticeBinding implements ViewBinding {
    private final QMUILinearLayout rootView;
    public final TextView tvContent;
    public final TextView tvTime;
    public final TextView tvTitle;

    private AdapterSystemNoticeBinding(QMUILinearLayout rootView, TextView tvContent, TextView tvTime, TextView tvTitle) {
        this.rootView = rootView;
        this.tvContent = tvContent;
        this.tvTime = tvTime;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public QMUILinearLayout getRoot() {
        return this.rootView;
    }

    public static AdapterSystemNoticeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdapterSystemNoticeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.adapter_system_notice, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AdapterSystemNoticeBinding bind(View rootView) {
        int i = R.id.tvContent;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.tvTime;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.tvTitle;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    return new AdapterSystemNoticeBinding((QMUILinearLayout) rootView, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
