package com.airbnb.lottie.network;

import com.airbnb.lottie.utils.Logger;
import com.dangdang.reader.utils.DangdangFileManager;
import com.yuewen.t50;

/* JADX INFO: loaded from: classes.dex */
public enum FileExtension {
    JSON(".json"),
    ZIP(DangdangFileManager.FONT_EXTEN);

    public final String extension;

    FileExtension(String str) {
        this.extension = str;
    }

    public static FileExtension forFile(String str) {
        for (FileExtension fileExtension : values()) {
            if (str.endsWith(fileExtension.extension)) {
                return fileExtension;
            }
        }
        Logger.warning("Unable to find correct extension for " + str);
        return JSON;
    }

    public String tempExtension() {
        return t50.f17863a + this.extension;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
