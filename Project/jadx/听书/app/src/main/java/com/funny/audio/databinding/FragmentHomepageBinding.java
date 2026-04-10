package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.angcyo.tablayout.DslTabLayout;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.widget.QMUIViewPager;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentHomepageBinding implements ViewBinding {
    public final ConstraintLayout container;
    public final QMUIFrameLayout lySearchBar;
    public final DslTabLayout lyTab;
    private final ConstraintLayout rootView;
    public final QMUIViewPager viewPager;

    private FragmentHomepageBinding(ConstraintLayout rootView, ConstraintLayout container, QMUIFrameLayout lySearchBar, DslTabLayout lyTab, QMUIViewPager viewPager) {
        this.rootView = rootView;
        this.container = container;
        this.lySearchBar = lySearchBar;
        this.lyTab = lyTab;
        this.viewPager = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomepageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentHomepageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_homepage, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHomepageBinding bind(View rootView) {
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        int i = R.id.lySearchBar;
        QMUIFrameLayout qMUIFrameLayout = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (qMUIFrameLayout != null) {
            i = R.id.lyTab;
            DslTabLayout dslTabLayout = (DslTabLayout) ViewBindings.findChildViewById(rootView, i);
            if (dslTabLayout != null) {
                i = R.id.viewPager;
                QMUIViewPager qMUIViewPager = (QMUIViewPager) ViewBindings.findChildViewById(rootView, i);
                if (qMUIViewPager != null) {
                    return new FragmentHomepageBinding(constraintLayout, constraintLayout, qMUIFrameLayout, dslTabLayout, qMUIViewPager);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
