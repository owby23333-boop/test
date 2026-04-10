package com.funny.audio.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.funny.audio.R;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentMineBinding implements ViewBinding {
    public final QMUIFrameLayout btnClearCache;
    public final ConstraintLayout container;
    public final QMUIRadiusImageView ivUserCover;
    public final QMUILinearLayout lyCheckUpdate;
    public final QMUILinearLayout lyContact;
    public final QMUILinearLayout lyFeedback;
    public final QMUILinearLayout lyLogout;
    public final QMUIFrameLayout lyNotice;
    public final QMUILinearLayout lyPleaseAlbum;
    public final QMUILinearLayout lyPureMode;
    public final QMUILinearLayout lySettingGroups1;
    public final QMUILinearLayout lySettingGroups2;
    public final QMUILinearLayout lyShareApp;
    public final QMUILinearLayout lySystemSetting;
    public final LinearLayout lyUser;
    private final ConstraintLayout rootView;
    public final Space space;
    public final TextView tvAccount;
    public final TextView tvAppVersion;
    public final TextView tvContact;
    public final TextView tvLogoutAccount;
    public final TextView tvNickname;
    public final TextView tvPureMode;

    private FragmentMineBinding(ConstraintLayout rootView, QMUIFrameLayout btnClearCache, ConstraintLayout container, QMUIRadiusImageView ivUserCover, QMUILinearLayout lyCheckUpdate, QMUILinearLayout lyContact, QMUILinearLayout lyFeedback, QMUILinearLayout lyLogout, QMUIFrameLayout lyNotice, QMUILinearLayout lyPleaseAlbum, QMUILinearLayout lyPureMode, QMUILinearLayout lySettingGroups1, QMUILinearLayout lySettingGroups2, QMUILinearLayout lyShareApp, QMUILinearLayout lySystemSetting, LinearLayout lyUser, Space space, TextView tvAccount, TextView tvAppVersion, TextView tvContact, TextView tvLogoutAccount, TextView tvNickname, TextView tvPureMode) {
        this.rootView = rootView;
        this.btnClearCache = btnClearCache;
        this.container = container;
        this.ivUserCover = ivUserCover;
        this.lyCheckUpdate = lyCheckUpdate;
        this.lyContact = lyContact;
        this.lyFeedback = lyFeedback;
        this.lyLogout = lyLogout;
        this.lyNotice = lyNotice;
        this.lyPleaseAlbum = lyPleaseAlbum;
        this.lyPureMode = lyPureMode;
        this.lySettingGroups1 = lySettingGroups1;
        this.lySettingGroups2 = lySettingGroups2;
        this.lyShareApp = lyShareApp;
        this.lySystemSetting = lySystemSetting;
        this.lyUser = lyUser;
        this.space = space;
        this.tvAccount = tvAccount;
        this.tvAppVersion = tvAppVersion;
        this.tvContact = tvContact;
        this.tvLogoutAccount = tvLogoutAccount;
        this.tvNickname = tvNickname;
        this.tvPureMode = tvPureMode;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentMineBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentMineBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_mine, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentMineBinding bind(View rootView) {
        int i = R.id.btnClearCache;
        QMUIFrameLayout qMUIFrameLayout = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (qMUIFrameLayout != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            i = R.id.ivUserCover;
            QMUIRadiusImageView qMUIRadiusImageView = (QMUIRadiusImageView) ViewBindings.findChildViewById(rootView, i);
            if (qMUIRadiusImageView != null) {
                i = R.id.lyCheckUpdate;
                QMUILinearLayout qMUILinearLayout = (QMUILinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (qMUILinearLayout != null) {
                    i = R.id.lyContact;
                    QMUILinearLayout qMUILinearLayout2 = (QMUILinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (qMUILinearLayout2 != null) {
                        i = R.id.lyFeedback;
                        QMUILinearLayout qMUILinearLayout3 = (QMUILinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (qMUILinearLayout3 != null) {
                            i = R.id.lyLogout;
                            QMUILinearLayout qMUILinearLayout4 = (QMUILinearLayout) ViewBindings.findChildViewById(rootView, i);
                            if (qMUILinearLayout4 != null) {
                                i = R.id.lyNotice;
                                QMUIFrameLayout qMUIFrameLayout2 = (QMUIFrameLayout) ViewBindings.findChildViewById(rootView, i);
                                if (qMUIFrameLayout2 != null) {
                                    i = R.id.lyPleaseAlbum;
                                    QMUILinearLayout qMUILinearLayout5 = (QMUILinearLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (qMUILinearLayout5 != null) {
                                        i = R.id.lyPureMode;
                                        QMUILinearLayout qMUILinearLayout6 = (QMUILinearLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (qMUILinearLayout6 != null) {
                                            i = R.id.lySettingGroups1;
                                            QMUILinearLayout qMUILinearLayout7 = (QMUILinearLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (qMUILinearLayout7 != null) {
                                                i = R.id.lySettingGroups2;
                                                QMUILinearLayout qMUILinearLayout8 = (QMUILinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (qMUILinearLayout8 != null) {
                                                    i = R.id.lyShareApp;
                                                    QMUILinearLayout qMUILinearLayout9 = (QMUILinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (qMUILinearLayout9 != null) {
                                                        i = R.id.lySystemSetting;
                                                        QMUILinearLayout qMUILinearLayout10 = (QMUILinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (qMUILinearLayout10 != null) {
                                                            i = R.id.lyUser;
                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (linearLayout != null) {
                                                                i = R.id.space;
                                                                Space space = (Space) ViewBindings.findChildViewById(rootView, i);
                                                                if (space != null) {
                                                                    i = R.id.tvAccount;
                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView != null) {
                                                                        i = R.id.tvAppVersion;
                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView2 != null) {
                                                                            i = R.id.tvContact;
                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView3 != null) {
                                                                                i = R.id.tvLogoutAccount;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (textView4 != null) {
                                                                                    i = R.id.tvNickname;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (textView5 != null) {
                                                                                        i = R.id.tvPureMode;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (textView6 != null) {
                                                                                            return new FragmentMineBinding(constraintLayout, qMUIFrameLayout, constraintLayout, qMUIRadiusImageView, qMUILinearLayout, qMUILinearLayout2, qMUILinearLayout3, qMUILinearLayout4, qMUIFrameLayout2, qMUILinearLayout5, qMUILinearLayout6, qMUILinearLayout7, qMUILinearLayout8, qMUILinearLayout9, qMUILinearLayout10, linearLayout, space, textView, textView2, textView3, textView4, textView5, textView6);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
