package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.widget.webview.QMUIWebView;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentAlertNoticeDialogBinding implements ViewBinding {
    public final QMUIFrameLayout btnInactive;
    public final QMUIFrameLayout btnPositive;
    private final QMUIConstraintLayout rootView;
    public final TextView tvContent;
    public final TextView tvInactive;
    public final TextView tvPositive;
    public final TextView tvTitle;
    public final QMUIWebView webview;

    private FragmentAlertNoticeDialogBinding(QMUIConstraintLayout rootView, QMUIFrameLayout btnInactive, QMUIFrameLayout btnPositive, TextView tvContent, TextView tvInactive, TextView tvPositive, TextView tvTitle, QMUIWebView webview) {
        this.rootView = rootView;
        this.btnInactive = btnInactive;
        this.btnPositive = btnPositive;
        this.tvContent = tvContent;
        this.tvInactive = tvInactive;
        this.tvPositive = tvPositive;
        this.tvTitle = tvTitle;
        this.webview = webview;
    }

    @Override // androidx.viewbinding.ViewBinding
    public QMUIConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAlertNoticeDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentAlertNoticeDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_alert_notice_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAlertNoticeDialogBinding bind(View rootView) {
        int i = R.id.btnInactive;
        QMUIFrameLayout qMUIFrameLayout = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (qMUIFrameLayout != null) {
            i = R.id.btnPositive;
            QMUIFrameLayout qMUIFrameLayout2 = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
            if (qMUIFrameLayout2 != null) {
                i = R.id.tvContent;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.tvInactive;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.tvPositive;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.tvTitle;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView4 != null) {
                                i = R.id.webview;
                                QMUIWebView qMUIWebView = (QMUIWebView) ViewBindings.findChildViewById(rootView, i);
                                if (qMUIWebView != null) {
                                    return new FragmentAlertNoticeDialogBinding((QMUIConstraintLayout) rootView, qMUIFrameLayout, qMUIFrameLayout2, textView, textView2, textView3, textView4, qMUIWebView);
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
