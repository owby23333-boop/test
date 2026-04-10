package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;
import com.qmuiteam.qmui.widget.QMUIWindowInsetLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivitySearchBinding implements ViewBinding {
    public final ImageView appBack;
    public final TextView btnSearch;
    public final QMUIWindowInsetLayout container;
    public final EditText etKeyword;
    public final ImageView ivClearSearchHistory;
    public final ImageView ivClearText;
    public final LinearLayout lyAssociate;
    public final LinearLayout lyHotSearchAlbum;
    public final LinearLayout lyHotSearchKeyword;
    public final LinearLayout lySearchHistory;
    public final LinearLayout lySearchResult;
    private final QMUIWindowInsetLayout rootView;
    public final RecyclerView rvAssociate;
    public final RecyclerView rvHotSearchAlbum;
    public final RecyclerView rvHotSearchKeyword;
    public final RecyclerView rvSearchHistory;
    public final RecyclerView rvSearchResult;
    public final LinearLayout topBar;
    public final TextView tvPleaseAlbum;

    private ActivitySearchBinding(QMUIWindowInsetLayout rootView, ImageView appBack, TextView btnSearch, QMUIWindowInsetLayout container, EditText etKeyword, ImageView ivClearSearchHistory, ImageView ivClearText, LinearLayout lyAssociate, LinearLayout lyHotSearchAlbum, LinearLayout lyHotSearchKeyword, LinearLayout lySearchHistory, LinearLayout lySearchResult, RecyclerView rvAssociate, RecyclerView rvHotSearchAlbum, RecyclerView rvHotSearchKeyword, RecyclerView rvSearchHistory, RecyclerView rvSearchResult, LinearLayout topBar, TextView tvPleaseAlbum) {
        this.rootView = rootView;
        this.appBack = appBack;
        this.btnSearch = btnSearch;
        this.container = container;
        this.etKeyword = etKeyword;
        this.ivClearSearchHistory = ivClearSearchHistory;
        this.ivClearText = ivClearText;
        this.lyAssociate = lyAssociate;
        this.lyHotSearchAlbum = lyHotSearchAlbum;
        this.lyHotSearchKeyword = lyHotSearchKeyword;
        this.lySearchHistory = lySearchHistory;
        this.lySearchResult = lySearchResult;
        this.rvAssociate = rvAssociate;
        this.rvHotSearchAlbum = rvHotSearchAlbum;
        this.rvHotSearchKeyword = rvHotSearchKeyword;
        this.rvSearchHistory = rvSearchHistory;
        this.rvSearchResult = rvSearchResult;
        this.topBar = topBar;
        this.tvPleaseAlbum = tvPleaseAlbum;
    }

    @Override // androidx.viewbinding.ViewBinding
    public QMUIWindowInsetLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySearchBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySearchBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_search, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySearchBinding bind(View rootView) {
        int i = R.id.appBack;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.btnSearch;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                QMUIWindowInsetLayout qMUIWindowInsetLayout = (QMUIWindowInsetLayout) rootView;
                i = R.id.etKeyword;
                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                if (editText != null) {
                    i = R.id.ivClearSearchHistory;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView2 != null) {
                        i = R.id.ivClearText;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView3 != null) {
                            i = R.id.lyAssociate;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                            if (linearLayout != null) {
                                i = R.id.lyHotSearchAlbum;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                if (linearLayout2 != null) {
                                    i = R.id.lyHotSearchKeyword;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (linearLayout3 != null) {
                                        i = R.id.lySearchHistory;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (linearLayout4 != null) {
                                            i = R.id.lySearchResult;
                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (linearLayout5 != null) {
                                                i = R.id.rvAssociate;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                if (recyclerView != null) {
                                                    i = R.id.rvHotSearchAlbum;
                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                    if (recyclerView2 != null) {
                                                        i = R.id.rvHotSearchKeyword;
                                                        RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                        if (recyclerView3 != null) {
                                                            i = R.id.rvSearchHistory;
                                                            RecyclerView recyclerView4 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                            if (recyclerView4 != null) {
                                                                i = R.id.rvSearchResult;
                                                                RecyclerView recyclerView5 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                if (recyclerView5 != null) {
                                                                    i = R.id.topBar;
                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                    if (linearLayout6 != null) {
                                                                        i = R.id.tvPleaseAlbum;
                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView2 != null) {
                                                                            return new ActivitySearchBinding(qMUIWindowInsetLayout, imageView, textView, qMUIWindowInsetLayout, editText, imageView2, imageView3, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, recyclerView, recyclerView2, recyclerView3, recyclerView4, recyclerView5, linearLayout6, textView2);
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
