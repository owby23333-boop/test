package com.xiaomi.passport.ui.internal;

import com.xiaomi.passport.snscorelib.internal.entity.SNSBindParameter;

/* JADX INFO: loaded from: classes8.dex */
public class NeedBindSnsException extends PassportUIException {
    public final SNSBindParameter snsBindParams;

    public NeedBindSnsException(SNSBindParameter sNSBindParameter) {
        this.snsBindParams = sNSBindParameter;
    }
}
