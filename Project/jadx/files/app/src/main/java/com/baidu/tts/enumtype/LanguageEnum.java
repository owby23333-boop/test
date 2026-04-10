package com.baidu.tts.enumtype;

/* JADX INFO: loaded from: classes2.dex */
public enum LanguageEnum {
    ZH("chinese", "ZH"),
    EN("english", "EN");

    private final String mFullName;
    private final String mShortName;

    LanguageEnum(String str, String str2) {
        this.mFullName = str;
        this.mShortName = str2;
    }

    public static LanguageEnum getLanguageEnum(String str) {
        for (LanguageEnum languageEnum : values()) {
            if (languageEnum.getShortName().equalsIgnoreCase(str)) {
                return languageEnum;
            }
        }
        return null;
    }

    public String getFullName() {
        return this.mFullName;
    }

    public String getShortName() {
        return this.mShortName;
    }
}
