package com.iflytek.aikit.plugin;

import com.iflytek.aikit.utils.constants.ErrorCode;
import com.yuewen.to2;

/* JADX INFO: loaded from: classes7.dex */
public enum RateType {
    RATE8K(8000),
    RATE16K(16000),
    RATE24K(ErrorCode.ERROR_TTS_INVALID_PARA),
    RATE32K(to2.a.h),
    RATE44K(44000);

    private final int value;

    RateType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
