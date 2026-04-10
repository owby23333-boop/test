package com.duokan.dkcategory_export.data;

import com.yuewen.h60;
import com.yuewen.we2;

/* JADX INFO: loaded from: classes13.dex */
public enum CategoryChannel {
    FICTION_FREE_MALE("1", h60.h, 0, 0, we2.z7),
    FICTION_FREE_FEMALE("2", h60.i, 0, 0, we2.A7),
    FICTION_PAID("yw", "精选", 1, 0, we2.E7),
    BOOK_PUB("book", h60.l, null, 1, we2.B7),
    BOOK_MAGAZINE("magazine", "杂志", null, 4, we2.C7),
    BOOK_AUDIO("audio", h60.m, null, 2, we2.D7);

    private final String channelId;
    private final String channelName;
    private final Integer contentType;
    private final Integer freeType;

    @we2
    private final String page;

    CategoryChannel(String str, String str2, Integer num, Integer num2, @we2 String str3) {
        this.channelId = str;
        this.channelName = str2;
        this.freeType = num;
        this.contentType = num2;
        this.page = str3;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public Integer getContentType() {
        return this.contentType;
    }

    public Integer getFreeType() {
        return this.freeType;
    }

    public String getPage() {
        return this.page;
    }
}
