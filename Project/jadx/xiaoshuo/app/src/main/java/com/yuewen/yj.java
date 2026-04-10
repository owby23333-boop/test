package com.yuewen;

import com.duokan.reader.ui.reading.ReadingTheme;

/* JADX INFO: loaded from: classes5.dex */
public class yj {
    public static String a(ReadingTheme readingTheme) {
        if (readingTheme == ReadingTheme.NIGHT) {
            return "night";
        }
        if (readingTheme == ReadingTheme.CUSTOM) {
            return "X";
        }
        ReadingTheme[] readingThemeArr = {ReadingTheme.THEME7, ReadingTheme.THEME1, ReadingTheme.THEME2, ReadingTheme.THEME3, ReadingTheme.THEME4, ReadingTheme.THEME6, ReadingTheme.THEME9, ReadingTheme.THEME8, ReadingTheme.THEME10, ReadingTheme.THEME11, ReadingTheme.THEME12};
        for (int i = 0; i < 11; i++) {
            if (readingThemeArr[i] == readingTheme) {
                return "A" + (i + 1);
            }
        }
        ReadingTheme[] readingThemeArr2 = {ReadingTheme.THEME17, ReadingTheme.THEME13, ReadingTheme.THEME15, ReadingTheme.THEME14, ReadingTheme.THEME16, ReadingTheme.THEME18};
        for (int i2 = 0; i2 < 6; i2++) {
            if (readingThemeArr2[i2] == readingTheme) {
                return "B" + (i2 + 1);
            }
        }
        ReadingTheme[] readingThemeArr3 = {ReadingTheme.THEME20, ReadingTheme.THEME21, ReadingTheme.THEME22, ReadingTheme.THEME23};
        for (int i3 = 0; i3 < 4; i3++) {
            if (readingThemeArr3[i3] == readingTheme) {
                return "C" + (i3 + 1);
            }
        }
        return null;
    }
}
