package com.xiaomi.passport;

import com.xiaomi.passport.PassportUserEnvironment;

/* JADX INFO: loaded from: classes8.dex */
public class PassportExternal {
    public static PassportUserEnvironment getEnvironment() {
        return PassportUserEnvironment.Holder.getInstance();
    }

    public static void initEnvironment(PassportUserEnvironment passportUserEnvironment) {
        PassportUserEnvironment.Holder.setInstance(passportUserEnvironment);
    }
}
