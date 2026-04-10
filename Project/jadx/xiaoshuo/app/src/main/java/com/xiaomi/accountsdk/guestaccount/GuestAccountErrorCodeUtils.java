package com.xiaomi.accountsdk.guestaccount;

import com.xiaomi.passport.StatConstants;
import com.yuewen.z10;

/* JADX INFO: loaded from: classes5.dex */
public class GuestAccountErrorCodeUtils {
    public static String descript(int i, String str) {
        if (i >= 100) {
            return i < 1000 ? f(i, "http_error") : i < 100000 ? f(i, z10.M1) : i < 101000 ? f(i, "server_fatal_error") : i < 102000 ? f(i, "server_argument_error") : i < 103000 ? f(i, "server_database_error") : i < 104000 ? f(i, StatConstants.ERROR_SERVER) : i < 105000 ? f(i, "server_coder_error") : i < 106000 ? f(i, "server_domain_error") : i < 107000 ? f(i, "server_token_error") : i < 108000 ? f(i, "server_json_error") : f(i, z10.M1);
        }
        switch (i) {
            case -1:
                return f(i, "UNKNOWN_ERROR");
            case 0:
                return f(i, "NO_ERROR");
            case 1:
                return f(i, "CANNOT_JUDGE_APP_PERMISSION_ERROR");
            case 2:
                return f(i, "NO_PERMISSION_ERROR");
            case 3:
                return f(i, "LOCAL_INTERRUPTED");
            case 4:
                return f(i, "LOCAL_CTA_ERROR");
            case 5:
                return f(i, "SERVER_UNKNOWN_ERROR");
            case 6:
                return f(i, "IO_ERROR");
            case 7:
                return f(i, "Local parameter error:" + str);
            default:
                return f(i, z10.M1);
        }
    }

    private static String f(int i, String str) {
        return String.format("code:%d(%s)", Integer.valueOf(i), str);
    }
}
