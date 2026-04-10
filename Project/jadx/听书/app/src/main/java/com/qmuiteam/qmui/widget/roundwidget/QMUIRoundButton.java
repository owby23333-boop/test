package com.qmuiteam.qmui.widget.roundwidget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.collection.SimpleArrayMap;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.alpha.QMUIAlphaButton;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider;
import com.qmuiteam.qmui.util.QMUIViewHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIRoundButton extends QMUIAlphaButton implements IQMUISkinDefaultAttrProvider {
    private static SimpleArrayMap<String, Integer> sDefaultSkinAttrs;
    private QMUIRoundButtonDrawable mRoundBg;

    static {
        SimpleArrayMap<String, Integer> simpleArrayMap = new SimpleArrayMap<>(3);
        sDefaultSkinAttrs = simpleArrayMap;
        simpleArrayMap.put(QMUISkinValueBuilder.BACKGROUND, Integer.valueOf(R.attr.qmui_skin_support_round_btn_bg_color));
        sDefaultSkinAttrs.put(QMUISkinValueBuilder.BORDER, Integer.valueOf(R.attr.qmui_skin_support_round_btn_border_color));
        sDefaultSkinAttrs.put(QMUISkinValueBuilder.TEXT_COLOR, Integer.valueOf(R.attr.qmui_skin_support_round_btn_text_color));
    }

    public QMUIRoundButton(Context context) {
        super(context);
        init(context, null, 0);
    }

    public QMUIRoundButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.QMUIButtonStyle);
        init(context, attributeSet, R.attr.QMUIButtonStyle);
    }

    public QMUIRoundButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        QMUIRoundButtonDrawable qMUIRoundButtonDrawableFromAttributeSet = QMUIRoundButtonDrawable.fromAttributeSet(context, attributeSet, i);
        this.mRoundBg = qMUIRoundButtonDrawableFromAttributeSet;
        QMUIViewHelper.setBackgroundKeepingPadding(this, qMUIRoundButtonDrawableFromAttributeSet);
        setChangeAlphaWhenDisable(false);
        setChangeAlphaWhenPress(false);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mRoundBg.setBgData(ColorStateList.valueOf(i));
    }

    public void setBgData(ColorStateList colorStateList) {
        this.mRoundBg.setBgData(colorStateList);
    }

    public void setStrokeData(int i, ColorStateList colorStateList) {
        this.mRoundBg.setStrokeData(i, colorStateList);
    }

    public int getStrokeWidth() {
        return this.mRoundBg.getStrokeWidth();
    }

    public void setStrokeColors(ColorStateList colorStateList) {
        this.mRoundBg.setStrokeColors(colorStateList);
    }

    @Override // com.qmuiteam.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider
    public SimpleArrayMap<String, Integer> getDefaultSkinAttrs() {
        return sDefaultSkinAttrs;
    }
}
