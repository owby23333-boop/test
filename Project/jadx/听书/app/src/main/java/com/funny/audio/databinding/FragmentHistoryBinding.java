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
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentHistoryBinding implements ViewBinding {
    public final QMUIFrameLayout btnDeleteHistory;
    public final QMUIFrameLayout btnSelectAll;
    public final ConstraintLayout container;
    public final LinearLayout lyEditBottomTab;
    public final QMUIFrameLayout lyFilterAll;
    public final QMUIFrameLayout lyFilterEarlier;
    public final QMUIFrameLayout lyFilterToday;
    public final QMUIFrameLayout lyFilterYesterday;
    public final SmartRefreshLayout refreshLayout;
    private final ConstraintLayout rootView;
    public final RecyclerView rvHistory;
    public final StateLayout state;
    public final TextView tvDeleteHistory;
    public final TextView tvEdit;
    public final TextView tvFilterAll;
    public final TextView tvFilterEarlier;
    public final TextView tvFilterToday;
    public final TextView tvFilterYesterday;
    public final TextView tvSelectAll;

    private FragmentHistoryBinding(ConstraintLayout rootView, QMUIFrameLayout btnDeleteHistory, QMUIFrameLayout btnSelectAll, ConstraintLayout container, LinearLayout lyEditBottomTab, QMUIFrameLayout lyFilterAll, QMUIFrameLayout lyFilterEarlier, QMUIFrameLayout lyFilterToday, QMUIFrameLayout lyFilterYesterday, SmartRefreshLayout refreshLayout, RecyclerView rvHistory, StateLayout state, TextView tvDeleteHistory, TextView tvEdit, TextView tvFilterAll, TextView tvFilterEarlier, TextView tvFilterToday, TextView tvFilterYesterday, TextView tvSelectAll) {
        this.rootView = rootView;
        this.btnDeleteHistory = btnDeleteHistory;
        this.btnSelectAll = btnSelectAll;
        this.container = container;
        this.lyEditBottomTab = lyEditBottomTab;
        this.lyFilterAll = lyFilterAll;
        this.lyFilterEarlier = lyFilterEarlier;
        this.lyFilterToday = lyFilterToday;
        this.lyFilterYesterday = lyFilterYesterday;
        this.refreshLayout = refreshLayout;
        this.rvHistory = rvHistory;
        this.state = state;
        this.tvDeleteHistory = tvDeleteHistory;
        this.tvEdit = tvEdit;
        this.tvFilterAll = tvFilterAll;
        this.tvFilterEarlier = tvFilterEarlier;
        this.tvFilterToday = tvFilterToday;
        this.tvFilterYesterday = tvFilterYesterday;
        this.tvSelectAll = tvSelectAll;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHistoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentHistoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_history, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHistoryBinding bind(View rootView) {
        int i = R.id.btnDeleteHistory;
        QMUIFrameLayout qMUIFrameLayout = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (qMUIFrameLayout != null) {
            i = R.id.btnSelectAll;
            QMUIFrameLayout qMUIFrameLayout2 = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
            if (qMUIFrameLayout2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                i = R.id.lyEditBottomTab;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout != null) {
                    i = R.id.lyFilterAll;
                    QMUIFrameLayout qMUIFrameLayout3 = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
                    if (qMUIFrameLayout3 != null) {
                        i = R.id.lyFilterEarlier;
                        QMUIFrameLayout qMUIFrameLayout4 = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
                        if (qMUIFrameLayout4 != null) {
                            i = R.id.lyFilterToday;
                            QMUIFrameLayout qMUIFrameLayout5 = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
                            if (qMUIFrameLayout5 != null) {
                                i = R.id.lyFilterYesterday;
                                QMUIFrameLayout qMUIFrameLayout6 = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
                                if (qMUIFrameLayout6 != null) {
                                    i = R.id.refreshLayout;
                                    SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (smartRefreshLayout != null) {
                                        i = R.id.rvHistory;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                        if (recyclerView != null) {
                                            i = R.id.state;
                                            StateLayout stateLayout = (StateLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (stateLayout != null) {
                                                i = R.id.tvDeleteHistory;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView != null) {
                                                    i = R.id.tvEdit;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView2 != null) {
                                                        i = R.id.tvFilterAll;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView3 != null) {
                                                            i = R.id.tvFilterEarlier;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView4 != null) {
                                                                i = R.id.tvFilterToday;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.tvFilterYesterday;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView6 != null) {
                                                                        i = R.id.tvSelectAll;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView7 != null) {
                                                                            return new FragmentHistoryBinding(constraintLayout, qMUIFrameLayout, qMUIFrameLayout2, constraintLayout, linearLayout, qMUIFrameLayout3, qMUIFrameLayout4, qMUIFrameLayout5, qMUIFrameLayout6, smartRefreshLayout, recyclerView, stateLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
