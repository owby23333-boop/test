package com.qmuiteam.qmui.widget.dialog;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIBottomSheetGridItemModel {
    Object tag;
    CharSequence text;
    Typeface typeface;
    Drawable image = null;
    int imageRes = 0;
    int imageSkinTintColorAttr = 0;
    int imageSkinSrcAttr = 0;
    int textSkinColorAttr = 0;
    Drawable subscript = null;
    int subscriptRes = 0;
    int subscriptSkinTintColorAttr = 0;
    int subscriptSkinSrcAttr = 0;

    public QMUIBottomSheetGridItemModel(CharSequence charSequence, Object obj) {
        this.text = charSequence;
        this.tag = obj;
    }

    public QMUIBottomSheetGridItemModel image(Drawable drawable) {
        this.image = drawable;
        return this;
    }

    public QMUIBottomSheetGridItemModel image(int i) {
        this.imageRes = i;
        return this;
    }

    public QMUIBottomSheetGridItemModel subscript(Drawable drawable) {
        this.subscript = drawable;
        return this;
    }

    public QMUIBottomSheetGridItemModel subscript(int i) {
        this.subscriptRes = i;
        return this;
    }

    public QMUIBottomSheetGridItemModel skinTextColorAttr(int i) {
        this.textSkinColorAttr = i;
        return this;
    }

    public QMUIBottomSheetGridItemModel skinImageTintColorAttr(int i) {
        this.imageSkinTintColorAttr = i;
        return this;
    }

    public QMUIBottomSheetGridItemModel skinImageSrcAttr(int i) {
        this.imageSkinSrcAttr = i;
        return this;
    }

    public QMUIBottomSheetGridItemModel skinSubscriptTintColorAttr(int i) {
        this.subscriptSkinTintColorAttr = i;
        return this;
    }

    public QMUIBottomSheetGridItemModel skinSubscriptSrcAttr(int i) {
        this.subscriptSkinSrcAttr = i;
        return this;
    }

    public QMUIBottomSheetGridItemModel typeface(Typeface typeface) {
        this.typeface = typeface;
        return this;
    }

    public CharSequence getText() {
        return this.text;
    }

    public Drawable getImage() {
        return this.image;
    }

    public Drawable getSubscript() {
        return this.subscript;
    }

    public int getImageRes() {
        return this.imageRes;
    }

    public int getImageSkinSrcAttr() {
        return this.imageSkinSrcAttr;
    }

    public int getImageSkinTintColorAttr() {
        return this.imageSkinTintColorAttr;
    }

    public int getSubscriptRes() {
        return this.subscriptRes;
    }

    public int getSubscriptSkinSrcAttr() {
        return this.subscriptSkinSrcAttr;
    }

    public int getSubscriptSkinTintColorAttr() {
        return this.subscriptSkinTintColorAttr;
    }

    public int getTextSkinColorAttr() {
        return this.textSkinColorAttr;
    }

    public Object getTag() {
        return this.tag;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }
}
