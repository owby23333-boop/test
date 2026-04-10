package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.drake.statelayout.StateLayout;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentCollectBinding implements ViewBinding {
    public final QMUIFrameLayout btnCancelCollect;
    public final QMUIFrameLayout btnPureMode;
    public final QMUIRadiusImageView btnPureModeClose;
    public final QMUIFrameLayout btnSelectAll;
    public final ConstraintLayout container;
    public final LinearLayout lyEditBottomTab;
    public final QMUIFrameLayout lyFilterRecentlyCollect;
    public final QMUIFrameLayout lyFilterRecentlyRead;
    public final QMUIFrameLayout lyFilterRecentlyUpdate;
    public final QMUILinearLayout lyPureModeTip;
    public final SmartRefreshLayout refreshLayout;
    private final ConstraintLayout rootView;
    public final RecyclerView rvCollect;
    public final StateLayout state;
    public final TextView tvCancelCollect;
    public final TextView tvEdit;
    public final TextView tvFilterRecentlyCollect;
    public final TextView tvFilterRecentlyRead;
    public final TextView tvFilterRecentlyUpdate;
    public final TextView tvSelectAll;

    private FragmentCollectBinding(ConstraintLayout rootView, QMUIFrameLayout btnCancelCollect, QMUIFrameLayout btnPureMode, QMUIRadiusImageView btnPureModeClose, QMUIFrameLayout btnSelectAll, ConstraintLayout container, LinearLayout lyEditBottomTab, QMUIFrameLayout lyFilterRecentlyCollect, QMUIFrameLayout lyFilterRecentlyRead, QMUIFrameLayout lyFilterRecentlyUpdate, QMUILinearLayout lyPureModeTip, SmartRefreshLayout refreshLayout, RecyclerView rvCollect, StateLayout state, TextView tvCancelCollect, TextView tvEdit, TextView tvFilterRecentlyCollect, TextView tvFilterRecentlyRead, TextView tvFilterRecentlyUpdate, TextView tvSelectAll) {
        this.rootView = rootView;
        this.btnCancelCollect = btnCancelCollect;
        this.btnPureMode = btnPureMode;
        this.btnPureModeClose = btnPureModeClose;
        this.btnSelectAll = btnSelectAll;
        this.container = container;
        this.lyEditBottomTab = lyEditBottomTab;
        this.lyFilterRecentlyCollect = lyFilterRecentlyCollect;
        this.lyFilterRecentlyRead = lyFilterRecentlyRead;
        this.lyFilterRecentlyUpdate = lyFilterRecentlyUpdate;
        this.lyPureModeTip = lyPureModeTip;
        this.refreshLayout = refreshLayout;
        this.rvCollect = rvCollect;
        this.state = state;
        this.tvCancelCollect = tvCancelCollect;
        this.tvEdit = tvEdit;
        this.tvFilterRecentlyCollect = tvFilterRecentlyCollect;
        this.tvFilterRecentlyRead = tvFilterRecentlyRead;
        this.tvFilterRecentlyUpdate = tvFilterRecentlyUpdate;
        this.tvSelectAll = tvSelectAll;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCollectBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentCollectBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_collect, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCollectBinding bind(View rootView) {
        int i = R.id.btnCancelCollect;
        QMUIFrameLayout qMUIFrameLayout = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (qMUIFrameLayout != null) {
            i = R.id.btnPureMode;
            QMUIFrameLayout qMUIFrameLayout2 = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
            if (qMUIFrameLayout2 != null) {
                i = R.id.btnPureModeClose;
                QMUIRadiusImageView qMUIRadiusImageView = (QMUIRadiusImageView) ViewBindings.findChildViewById(rootView, i);
                if (qMUIRadiusImageView != null) {
                    i = R.id.btnSelectAll;
                    QMUIFrameLayout qMUIFrameLayout3 = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
                    if (qMUIFrameLayout3 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                        i = R.id.lyEditBottomTab;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout != null) {
                            i = R.id.lyFilterRecentlyCollect;
                            QMUIFrameLayout qMUIFrameLayout4 = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
                            if (qMUIFrameLayout4 != null) {
                                i = R.id.lyFilterRecentlyRead;
                                QMUIFrameLayout qMUIFrameLayout5 = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
                                if (qMUIFrameLayout5 != null) {
                                    i = R.id.lyFilterRecentlyUpdate;
                                    QMUIFrameLayout qMUIFrameLayout6 = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (qMUIFrameLayout6 != null) {
                                        i = R.id.lyPureModeTip;
                                        QMUILinearLayout qMUILinearLayout = (QMUILinearLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (qMUILinearLayout != null) {
                                            i = R.id.refreshLayout;
                                            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (smartRefreshLayout != null) {
                                                i = R.id.rvCollect;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                if (recyclerView != null) {
                                                    i = R.id.state;
                                                    StateLayout stateLayout = (StateLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (stateLayout != null) {
                                                        i = R.id.tvCancelCollect;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView != null) {
                                                            i = R.id.tvEdit;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView2 != null) {
                                                                i = R.id.tvFilterRecentlyCollect;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView3 != null) {
                                                                    i = R.id.tvFilterRecentlyRead;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView4 != null) {
                                                                        i = R.id.tvFilterRecentlyUpdate;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView5 != null) {
                                                                            i = R.id.tvSelectAll;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView6 != null) {
                                                                                return new FragmentCollectBinding(constraintLayout, qMUIFrameLayout, qMUIFrameLayout2, qMUIRadiusImageView, qMUIFrameLayout3, constraintLayout, linearLayout, qMUIFrameLayout4, qMUIFrameLayout5, qMUIFrameLayout6, qMUILinearLayout, smartRefreshLayout, recyclerView, stateLayout, textView, textView2, textView3, textView4, textView5, textView6);
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
