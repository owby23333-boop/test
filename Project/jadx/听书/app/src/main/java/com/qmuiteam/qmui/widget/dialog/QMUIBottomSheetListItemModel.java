package com.qmuiteam.qmui.widget.dialog;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIBottomSheetListItemModel {
    String tag;
    CharSequence text;
    Typeface typeface;
    Drawable image = null;
    int imageRes = 0;
    int imageSkinTintColorAttr = 0;
    int imageSkinSrcAttr = 0;
    int textSkinColorAttr = 0;
    boolean hasRedPoint = false;
    boolean isDisabled = false;

    public QMUIBottomSheetListItemModel(CharSequence charSequence, String str) {
        this.text = charSequence;
        this.tag = str;
    }

    public QMUIBottomSheetListItemModel image(Drawable drawable) {
        this.image = drawable;
        return this;
    }

    public QMUIBottomSheetListItemModel image(int i) {
        this.imageRes = i;
        return this;
    }

    public QMUIBottomSheetListItemModel skinTextColorAttr(int i) {
        this.textSkinColorAttr = i;
        return this;
    }

    public QMUIBottomSheetListItemModel skinImageTintColorAttr(int i) {
        this.imageSkinTintColorAttr = i;
        return this;
    }

    public QMUIBottomSheetListItemModel skinImageSrcAttr(int i) {
        this.imageSkinSrcAttr = i;
        return this;
    }

    public QMUIBottomSheetListItemModel redPoint(boolean z) {
        this.hasRedPoint = z;
        return this;
    }

    public QMUIBottomSheetListItemModel disabled(boolean z) {
        this.isDisabled = z;
        return this;
    }

    public QMUIBottomSheetListItemModel typeface(Typeface typeface) {
        this.typeface = typeface;
        return this;
    }
}
