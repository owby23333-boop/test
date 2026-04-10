package com.xiaomi.passport.data;

/* JADX INFO: loaded from: classes8.dex */
public class LoginPreference {
    public String idcZone;
    public PhoneLoginType phoneLoginType;
    public String userRegion;

    public enum PhoneLoginType {
        ticket("ticket"),
        password("password");

        private final String value;

        PhoneLoginType(String str) {
            this.value = str;
        }
    }

    public LoginPreference(String str, String str2, PhoneLoginType phoneLoginType) {
        this.idcZone = str;
        this.userRegion = str2;
        this.phoneLoginType = phoneLoginType;
    }
}
