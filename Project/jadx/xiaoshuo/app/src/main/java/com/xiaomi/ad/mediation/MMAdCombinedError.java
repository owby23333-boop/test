package com.xiaomi.ad.mediation;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class MMAdCombinedError extends MMAdError {
    public List<MMAdError> adErrors;

    public MMAdCombinedError(int i) {
        super(i);
        this.adErrors = new ArrayList();
    }

    public void addError(MMAdError mMAdError) {
        String strValueOf;
        String str;
        this.adErrors.add(mMAdError);
        if (this.externalErrorCode == null) {
            strValueOf = String.valueOf(mMAdError.externalErrorCode);
        } else {
            strValueOf = this.externalErrorCode + " | " + mMAdError.externalErrorCode;
        }
        this.externalErrorCode = strValueOf;
        if (this.errorMessage == null) {
            str = mMAdError.errorMessage;
        } else {
            str = this.errorMessage + " | " + mMAdError.errorMessage;
        }
        this.errorMessage = str;
    }
}
