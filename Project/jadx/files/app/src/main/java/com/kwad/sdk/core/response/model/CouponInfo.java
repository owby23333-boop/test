package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes3.dex */
public class CouponInfo extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
    private static final float COUPON_DISCOUNT_THRESHOLD = 20.0f;
    public static final String JINNIIU_DISCOUNT = "2";
    public static final String JINNIIU_PRICE_BREAK_DISCOUNT = "1";
    private static final long serialVersionUID = -9143537899646897962L;
    public String displayActionWords;
    public String displayBase;
    public String displayDiscount;
    public String displayName;
    public String displayTitle;
    public String displayType;
    public String displayValue;

    @Nullable
    public static String jinniuFormatCoupon(CouponInfo couponInfo) {
        StringBuilder sb;
        String str = null;
        if (couponInfo == null) {
            return null;
        }
        String displayType = couponInfo.getDisplayType();
        String strRinToYuan = rinToYuan(couponInfo.getDisplayValue());
        byte b = -1;
        int iHashCode = displayType.hashCode();
        if (iHashCode != 49) {
            if (iHashCode == 50 && displayType.equals("2")) {
                b = 1;
            }
        } else if (displayType.equals("1")) {
            b = 0;
        }
        if (b == 0) {
            String strRinToYuan2 = rinToYuan(couponInfo.getDisplayBase());
            if (TextUtils.isEmpty(strRinToYuan2) || TextUtils.isEmpty(strRinToYuan)) {
                return null;
            }
            if (couponInfo.isNoPreRequirement()) {
                sb = new StringBuilder("¥");
            } else {
                sb = new StringBuilder();
                sb.append(strRinToYuan2);
                sb.append("减");
            }
            sb.append(strRinToYuan);
            return sb.toString();
        }
        if (b != 1 || TextUtils.isEmpty(strRinToYuan)) {
            return null;
        }
        try {
            if (Float.parseFloat(strRinToYuan) >= COUPON_DISCOUNT_THRESHOLD) {
                str = "¥" + strRinToYuan;
            } else {
                str = couponInfo.getFormattedDisplayDiscount() + "折";
            }
            return str;
        } catch (Exception unused) {
            return str;
        }
    }

    @Nullable
    public static String rinToYuan(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new DecimalFormat("#.#").format(Float.parseFloat(str) / 1000.0f);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return null;
        }
    }

    public String getDisplayActionWords() {
        return this.displayActionWords;
    }

    public String getDisplayBase() {
        return this.displayBase;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getDisplayTitle() {
        return this.displayTitle;
    }

    public String getDisplayType() {
        return this.displayType;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }

    @Nullable
    public String getFormattedDisplayDiscount() {
        try {
            return new DecimalFormat("#.#").format(Float.valueOf(this.displayDiscount).floatValue() / 10.0f);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return null;
        }
    }

    public String getFormattedJinniuPrefix() {
        String displayType = getDisplayType();
        if (isNoPreRequirement()) {
            return "券";
        }
        if ("1".equals(displayType)) {
            return "满";
        }
        if ("2".equals(displayType)) {
            return "券";
        }
        return null;
    }

    public boolean isNoPreRequirement() {
        String str = this.displayBase;
        if (str == null) {
            return false;
        }
        try {
            return Float.parseFloat(str) <= 0.0f;
        } catch (Exception unused) {
            return false;
        }
    }

    public void setDisplayDiscount(String str) {
        this.displayDiscount = str;
    }
}
