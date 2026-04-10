package com.yuewen;

/* JADX INFO: loaded from: classes12.dex */
public class t3 extends wh2 {
    public static t3 d;

    public static synchronized t3 k() {
        if (d == null) {
            d = new t3();
        }
        return d;
    }

    @Override // com.yuewen.wh2
    public String[] c() {
        return new String[]{"android.permission.READ_PHONE_STATE"};
    }
}
