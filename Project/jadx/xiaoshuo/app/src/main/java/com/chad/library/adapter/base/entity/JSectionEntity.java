package com.chad.library.adapter.base.entity;

/* JADX INFO: loaded from: classes10.dex */
public abstract class JSectionEntity implements SectionEntity {
    @Override // com.chad.library.adapter.base.entity.SectionEntity, com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return isHeader() ? -99 : -100;
    }
}
