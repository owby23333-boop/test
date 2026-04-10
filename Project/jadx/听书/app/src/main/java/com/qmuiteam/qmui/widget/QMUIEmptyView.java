package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.skin.annotation.QMUISkinChangeNotAdapted;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIEmptyView extends ConstraintLayout {
    protected Button mButton;
    private TextView mDetailTextView;
    private QMUILoadingView mLoadingView;
    private TextView mTitleTextView;

    public QMUIEmptyView(Context context) {
        this(context, null);
    }

    public QMUIEmptyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIEmptyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIEmptyView);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUIEmptyView_qmui_show_loading, false);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.QMUIEmptyView_qmui_title_text);
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.QMUIEmptyView_qmui_detail_text);
        String string3 = typedArrayObtainStyledAttributes.getString(R.styleable.QMUIEmptyView_qmui_btn_text);
        typedArrayObtainStyledAttributes.recycle();
        show(z, string, string2, string3, null);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.qmui_empty_view, (ViewGroup) this, true);
        this.mLoadingView = (QMUILoadingView) findViewById(R.id.empty_view_loading);
        this.mTitleTextView = (TextView) findViewById(R.id.empty_view_title);
        this.mDetailTextView = (TextView) findViewById(R.id.empty_view_detail);
        this.mButton = (Button) findViewById(R.id.empty_view_button);
    }

    public void show(boolean z, String str, String str2, String str3, View.OnClickListener onClickListener) {
        setLoadingShowing(z);
        setTitleText(str);
        setDetailText(str2);
        setButton(str3, onClickListener);
        show();
    }

    public void show(boolean z) {
        setLoadingShowing(z);
        setTitleText(null);
        setDetailText(null);
        setButton(null, null);
        show();
    }

    public void show(String str, String str2) {
        setLoadingShowing(false);
        setTitleText(str);
        setDetailText(str2);
        setButton(null, null);
        show();
    }

    public void show() {
        setVisibility(0);
    }

    public void hide() {
        setVisibility(8);
        setLoadingShowing(false);
        setTitleText(null);
        setDetailText(null);
        setButton(null, null);
    }

    public boolean isShowing() {
        return getVisibility() == 0;
    }

    public boolean isLoading() {
        return this.mLoadingView.getVisibility() == 0;
    }

    public void setLoadingShowing(boolean z) {
        this.mLoadingView.setVisibility(z ? 0 : 8);
    }

    public void setTitleText(String str) {
        this.mTitleTextView.setText(str);
        this.mTitleTextView.setVisibility(str != null ? 0 : 8);
    }

    public void setDetailText(String str) {
        this.mDetailTextView.setText(str);
        this.mDetailTextView.setVisibility(str != null ? 0 : 8);
    }

    @QMUISkinChangeNotAdapted
    public void setTitleColor(int i) {
        this.mTitleTextView.setTextColor(i);
    }

    @QMUISkinChangeNotAdapted
    public void setDetailColor(int i) {
        this.mDetailTextView.setTextColor(i);
    }

    public void setTitleSkinValue(QMUISkinValueBuilder qMUISkinValueBuilder) {
        QMUISkinHelper.setSkinValue(this.mTitleTextView, qMUISkinValueBuilder);
    }

    public void setDetailSkinValue(QMUISkinValueBuilder qMUISkinValueBuilder) {
        QMUISkinHelper.setSkinValue(this.mDetailTextView, qMUISkinValueBuilder);
    }

    public void setLoadingSkinValue(QMUISkinValueBuilder qMUISkinValueBuilder) {
        QMUISkinHelper.setSkinValue(this.mLoadingView, qMUISkinValueBuilder);
    }

    public void setBtnSkinValue(QMUISkinValueBuilder qMUISkinValueBuilder) {
        QMUISkinHelper.setSkinValue(this.mButton, qMUISkinValueBuilder);
    }

    public void setButton(String str, View.OnClickListener onClickListener) {
        this.mButton.setText(str);
        this.mButton.setVisibility(str != null ? 0 : 8);
        this.mButton.setOnClickListener(onClickListener);
    }
}
