package com.xiaomi.passport.ui.logiccontroller;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes8.dex */
public class CountryNameChooser {
    private static final int REQ_CODE_CHOOSE_COUNTRY = 8880;
    private final Intent chooserIntent;

    public static class ChooseNoneException extends Exception {
    }

    public static class NotChooseActionException extends Exception {
    }

    public CountryNameChooser(Intent intent) {
        this.chooserIntent = intent;
    }

    @Nullable
    public String getCountryNameWhenActivityResult(int i, int i2, Intent intent) throws ChooseNoneException, NotChooseActionException {
        if (i != REQ_CODE_CHOOSE_COUNTRY) {
            throw new NotChooseActionException();
        }
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra("countryName");
            if (!TextUtils.isEmpty(stringExtra)) {
                return stringExtra;
            }
        }
        throw new ChooseNoneException();
    }

    public void startActivityForGetCountryNameResult(@NonNull Activity activity) {
        activity.startActivityForResult(this.chooserIntent, REQ_CODE_CHOOSE_COUNTRY);
    }
}
