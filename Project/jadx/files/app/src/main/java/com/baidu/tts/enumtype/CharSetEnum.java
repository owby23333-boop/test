package com.baidu.tts.enumtype;

import com.anythink.expressad.foundation.g.a;

/* JADX INFO: loaded from: classes2.dex */
public enum CharSetEnum {
    GB18030("gb18030", "0"),
    BIG5("big5", "1"),
    UTF8(a.bN, "2"),
    GBK("gbk", "4"),
    UNICODE("unicode", "5");

    private final String mCharset;
    private final String mTag;

    CharSetEnum(String str, String str2) {
        this.mCharset = str;
        this.mTag = str2;
    }

    public static CharSetEnum getCharSetEnum(String str) {
        for (CharSetEnum charSetEnum : values()) {
            if (charSetEnum.getTag().equals(str)) {
                return charSetEnum;
            }
        }
        return null;
    }

    public String getCharset() {
        return this.mCharset;
    }

    public String getTag() {
        return this.mTag;
    }

    public static String getCharset(String str) {
        CharSetEnum charSetEnum = getCharSetEnum(str);
        if (charSetEnum == null) {
            return null;
        }
        return charSetEnum.getCharset();
    }
}
