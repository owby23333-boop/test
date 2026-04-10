package com.qmuiteam.qmui.qqface;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes4.dex */
public class QMUINoQQFaceManager implements IQMUIQQFaceManager {
    @Override // com.qmuiteam.qmui.qqface.IQMUIQQFaceManager
    public int getDoubleUnicodeEmoji(int i, int i2) {
        return 0;
    }

    @Override // com.qmuiteam.qmui.qqface.IQMUIQQFaceManager
    public int getEmojiResource(int i) {
        return 0;
    }

    @Override // com.qmuiteam.qmui.qqface.IQMUIQQFaceManager
    public int getQQfaceResource(CharSequence charSequence) {
        return 0;
    }

    @Override // com.qmuiteam.qmui.qqface.IQMUIQQFaceManager
    public int getSoftbankEmojiResource(char c) {
        return 0;
    }

    @Override // com.qmuiteam.qmui.qqface.IQMUIQQFaceManager
    public Drawable getSpecialBoundsDrawable(CharSequence charSequence) {
        return null;
    }

    @Override // com.qmuiteam.qmui.qqface.IQMUIQQFaceManager
    public int getSpecialDrawableMaxHeight() {
        return 0;
    }

    @Override // com.qmuiteam.qmui.qqface.IQMUIQQFaceManager
    public boolean maybeEmoji(int i) {
        return false;
    }

    @Override // com.qmuiteam.qmui.qqface.IQMUIQQFaceManager
    public boolean maybeSoftBankEmoji(char c) {
        return false;
    }
}
