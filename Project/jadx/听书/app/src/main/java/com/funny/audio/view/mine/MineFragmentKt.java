package com.funny.audio.view.mine;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;

/* JADX INFO: compiled from: MineFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"getNoMoreThanTwoDigits", "", "number", "", "app_normalRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MineFragmentKt {
    public static final String getNoMoreThanTwoDigits(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        return decimalFormat.format(d);
    }
}
