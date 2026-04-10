package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.WindowInsetsCompat;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.alpha.QMUIAlphaImageButton;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.qqface.QMUIQQFaceView;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider;
import com.qmuiteam.qmui.util.QMUIWindowInsetHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView;

/* JADX INFO: loaded from: classes4.dex */
public class QMUITopBarLayout extends QMUIFrameLayout implements IQMUISkinDefaultAttrProvider {
    private SimpleArrayMap<String, Integer> mDefaultSkinAttrs;
    private QMUITopBar mTopBar;

    public QMUITopBarLayout(Context context) {
        this(context, null);
    }

    public QMUITopBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUITopBarStyle);
    }

    public QMUITopBarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        SimpleArrayMap<String, Integer> simpleArrayMap = new SimpleArrayMap<>(2);
        this.mDefaultSkinAttrs = simpleArrayMap;
        simpleArrayMap.put(QMUISkinValueBuilder.BOTTOM_SEPARATOR, Integer.valueOf(R.attr.qmui_skin_support_topbar_separator_color));
        this.mDefaultSkinAttrs.put(QMUISkinValueBuilder.BACKGROUND, Integer.valueOf(R.attr.qmui_skin_support_topbar_bg));
        QMUITopBar qMUITopBar = new QMUITopBar(context, attributeSet, i);
        this.mTopBar = qMUITopBar;
        qMUITopBar.setBackground(null);
        this.mTopBar.setVisibility(0);
        this.mTopBar.setFitsSystemWindows(false);
        this.mTopBar.setId(View.generateViewId());
        this.mTopBar.updateBottomDivider(0, 0, 0, 0);
        addView(this.mTopBar, new FrameLayout.LayoutParams(-1, this.mTopBar.getTopBarHeight()));
        QMUIWindowInsetHelper.handleWindowInsets(this, WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.displayCutout(), true);
    }

    public QMUITopBar getTopBar() {
        return this.mTopBar;
    }

    public void setCenterView(View view) {
        this.mTopBar.setCenterView(view);
    }

    public QMUIQQFaceView setTitle(int i) {
        return this.mTopBar.setTitle(i);
    }

    public QMUIQQFaceView setTitle(String str) {
        return this.mTopBar.setTitle(str);
    }

    public void showTitleView(boolean z) {
        this.mTopBar.showTitleView(z);
    }

    public QMUISpanTouchFixTextView setSubTitle(int i) {
        return this.mTopBar.setSubTitle(i);
    }

    public QMUISpanTouchFixTextView setSubTitle(CharSequence charSequence) {
        return this.mTopBar.setSubTitle(charSequence);
    }

    public QMUIQQFaceView getTitleView() {
        return this.mTopBar.getTitleView();
    }

    public QMUISpanTouchFixTextView getSubTitleView() {
        return this.mTopBar.getSubTitleView();
    }

    public void setTitleGravity(int i) {
        this.mTopBar.setTitleGravity(i);
    }

    public void addLeftView(View view, int i) {
        this.mTopBar.addLeftView(view, i);
    }

    public void addLeftView(View view, int i, RelativeLayout.LayoutParams layoutParams) {
        this.mTopBar.addLeftView(view, i, layoutParams);
    }

    public void addRightView(View view, int i) {
        this.mTopBar.addRightView(view, i);
    }

    public void addRightView(View view, int i, RelativeLayout.LayoutParams layoutParams) {
        this.mTopBar.addRightView(view, i, layoutParams);
    }

    public QMUIAlphaImageButton addRightImageButton(int i, int i2) {
        return this.mTopBar.addRightImageButton(i, i2);
    }

    public QMUIAlphaImageButton addRightImageButton(int i, boolean z, int i2) {
        return this.mTopBar.addRightImageButton(i, z, i2);
    }

    public QMUIAlphaImageButton addRightImageButton(int i, boolean z, int i2, int i3, int i4) {
        return this.mTopBar.addRightImageButton(i, z, i2, i3, i4);
    }

    public QMUIAlphaImageButton addLeftImageButton(int i, int i2) {
        return this.mTopBar.addLeftImageButton(i, i2);
    }

    public QMUIAlphaImageButton addLeftImageButton(int i, boolean z, int i2) {
        return this.mTopBar.addLeftImageButton(i, z, i2);
    }

    public QMUIAlphaImageButton addLeftImageButton(int i, boolean z, int i2, int i3, int i4) {
        return this.mTopBar.addLeftImageButton(i, z, i2, i3, i4);
    }

    public Button addLeftTextButton(int i, int i2) {
        return this.mTopBar.addLeftTextButton(i, i2);
    }

    public Button addLeftTextButton(String str, int i) {
        return this.mTopBar.addLeftTextButton(str, i);
    }

    public Button addRightTextButton(int i, int i2) {
        return this.mTopBar.addRightTextButton(i, i2);
    }

    public Button addRightTextButton(String str, int i) {
        return this.mTopBar.addRightTextButton(str, i);
    }

    public QMUIAlphaImageButton addLeftBackImageButton() {
        return this.mTopBar.addLeftBackImageButton();
    }

    public void removeAllLeftViews() {
        this.mTopBar.removeAllLeftViews();
    }

    public void removeAllRightViews() {
        this.mTopBar.removeAllRightViews();
    }

    public void removeCenterViewAndTitleView() {
        this.mTopBar.removeCenterViewAndTitleView();
    }

    public void setBackgroundAlpha(int i) {
        getBackground().mutate().setAlpha(i);
    }

    public int computeAndSetBackgroundAlpha(int i, int i2, int i3) {
        int iMax = (int) (Math.max(0.0d, Math.min((i - i2) / (i3 - i2), 1.0d)) * 255.0d);
        setBackgroundAlpha(iMax);
        return iMax;
    }

    public void setDefaultSkinAttr(String str, int i) {
        this.mDefaultSkinAttrs.put(str, Integer.valueOf(i));
    }

    @Override // com.qmuiteam.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider
    public SimpleArrayMap<String, Integer> getDefaultSkinAttrs() {
        return this.mDefaultSkinAttrs;
    }

    public void eachLeftRightView(QMUITopBar.Action action) {
        this.mTopBar.eachLeftRightView(action);
    }
}
