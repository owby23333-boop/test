package com.qmuiteam.qmui.skin.defaultAttr;

import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISkinSimpleDefaultAttrProvider implements IQMUISkinDefaultAttrProvider {
    private SimpleArrayMap<String, Integer> mSkinAttrs = new SimpleArrayMap<>();

    public void setDefaultSkinAttr(String str, int i) {
        this.mSkinAttrs.put(str, Integer.valueOf(i));
    }

    @Override // com.qmuiteam.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider
    public SimpleArrayMap<String, Integer> getDefaultSkinAttrs() {
        return this.mSkinAttrs;
    }
}
