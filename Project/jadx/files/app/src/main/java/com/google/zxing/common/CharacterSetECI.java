package com.google.zxing.common;

import com.google.zxing.FormatException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public enum CharacterSetECI {
    Cp437(new int[]{0, 2}, new String[0]),
    ISO8859_1(new int[]{1, 3}, "ISO-8859-1"),
    ISO8859_2(4, "ISO-8859-2"),
    ISO8859_3(5, "ISO-8859-3"),
    ISO8859_4(6, "ISO-8859-4"),
    ISO8859_5(7, "ISO-8859-5"),
    ISO8859_6(8, "ISO-8859-6"),
    ISO8859_7(9, "ISO-8859-7"),
    ISO8859_8(10, "ISO-8859-8"),
    ISO8859_9(11, "ISO-8859-9"),
    ISO8859_10(12, "ISO-8859-10"),
    ISO8859_11(13, "ISO-8859-11"),
    ISO8859_13(15, "ISO-8859-13"),
    ISO8859_14(16, "ISO-8859-14"),
    ISO8859_15(17, "ISO-8859-15"),
    ISO8859_16(18, "ISO-8859-16"),
    SJIS(20, "Shift_JIS"),
    Cp1250(21, "windows-1250"),
    Cp1251(22, "windows-1251"),
    Cp1252(23, "windows-1252"),
    Cp1256(24, "windows-1256"),
    UnicodeBigUnmarked(25, com.umeng.message.proguard.k.f20481d, "UnicodeBig"),
    UTF8(26, "UTF-8"),
    ASCII(new int[]{27, 170}, "US-ASCII"),
    Big5(28),
    GB18030(29, "GB2312", "EUC_CN", "GBK"),
    EUC_KR(30, "EUC-KR");

    private static final Map<Integer, CharacterSetECI> V = new HashMap();
    private static final Map<String, CharacterSetECI> W = new HashMap();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int[] f16141s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String[] f16142t;

    static {
        for (CharacterSetECI characterSetECI : values()) {
            for (int i2 : characterSetECI.f16141s) {
                V.put(Integer.valueOf(i2), characterSetECI);
            }
            W.put(characterSetECI.name(), characterSetECI);
            for (String str : characterSetECI.f16142t) {
                W.put(str, characterSetECI);
            }
        }
    }

    CharacterSetECI(int i2) {
        this(new int[]{i2}, new String[0]);
    }

    public static CharacterSetECI a(String str) {
        return W.get(str);
    }

    public static CharacterSetECI b(int i2) throws FormatException {
        if (i2 < 0 || i2 >= 900) {
            throw FormatException.f();
        }
        return V.get(Integer.valueOf(i2));
    }

    public int f() {
        return this.f16141s[0];
    }

    CharacterSetECI(int i2, String... strArr) {
        this.f16141s = new int[]{i2};
        this.f16142t = strArr;
    }

    CharacterSetECI(int[] iArr, String... strArr) {
        this.f16141s = iArr;
        this.f16142t = strArr;
    }
}
