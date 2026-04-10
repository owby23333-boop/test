package com.baidu.tts.enumtype;

/* JADX INFO: loaded from: classes2.dex */
public enum SpeedEnum {
    MIN(0, 0.0f),
    MAX(9, 99.0f),
    DEFAULT(5, 50.0f);

    private final float mFloatValue;
    private final int mIntValue;

    SpeedEnum(int i2, float f2) {
        this.mIntValue = i2;
        this.mFloatValue = f2;
    }

    public static int getMiddleSpeedInt() {
        return (MIN.getIntValue() + MAX.getIntValue()) / 2;
    }

    public static String getStringDefaultSpeedInt() {
        return String.valueOf(DEFAULT.getIntValue());
    }

    public static boolean isValidSpeed(int i2) {
        return i2 >= MIN.getIntValue() && i2 <= MAX.getIntValue();
    }

    public float getFloatValue() {
        return this.mFloatValue;
    }

    public int getIntValue() {
        return this.mIntValue;
    }
}
