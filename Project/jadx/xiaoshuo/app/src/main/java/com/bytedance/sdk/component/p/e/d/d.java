package com.bytedance.sdk.component.p.e.d;

import android.util.Log;
import com.bytedance.sdk.component.p.e.vn;
import com.bytedance.sdk.component.p.e.zk;
import com.iflytek.aikit.media.param.MscKeys;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static void bf(String str) {
        try {
            vn vnVarBh = zk.ga().bh();
            if (vnVarBh == null || !vnVarBh.bf()) {
                return;
            }
            String strD = vnVarBh.d();
            if (strD == null) {
                strD = "";
            }
            Log.i(strD + MscKeys.KEY_LOG_PATH, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void d(String str) {
        try {
            vn vnVarBh = zk.ga().bh();
            if (vnVarBh == null || !vnVarBh.bf()) {
                return;
            }
            String strD = vnVarBh.d();
            if (strD == null) {
                strD = "";
            }
            Log.w(strD + MscKeys.KEY_LOG_PATH, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void e(String str) {
        try {
            vn vnVarBh = zk.ga().bh();
            if (vnVarBh == null || !vnVarBh.bf()) {
                return;
            }
            String strD = vnVarBh.d();
            if (strD == null) {
                strD = "";
            }
            Log.d(strD + MscKeys.KEY_LOG_PATH, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tg(String str) {
        try {
            vn vnVarBh = zk.ga().bh();
            if (vnVarBh == null || !vnVarBh.bf()) {
                return;
            }
            String strD = vnVarBh.d();
            if (strD == null) {
                strD = "";
            }
            Log.e(strD + MscKeys.KEY_LOG_PATH, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void bf(String str, String str2) {
        try {
            vn vnVarBh = zk.ga().bh();
            if (vnVarBh == null || !vnVarBh.bf()) {
                return;
            }
            String strD = vnVarBh.d();
            if (strD == null) {
                strD = "";
            }
            Log.i((strD + MscKeys.KEY_LOG_PATH) + str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void d(String str, String str2) {
        try {
            vn vnVarBh = zk.ga().bh();
            if (vnVarBh == null || !vnVarBh.bf()) {
                return;
            }
            String strD = vnVarBh.d();
            if (strD == null) {
                strD = "";
            }
            Log.w((strD + MscKeys.KEY_LOG_PATH) + str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void e(String str, String str2) {
        try {
            vn vnVarBh = zk.ga().bh();
            if (vnVarBh == null || !vnVarBh.bf()) {
                return;
            }
            String strD = vnVarBh.d();
            if (strD == null) {
                strD = "";
            }
            Log.d((strD + MscKeys.KEY_LOG_PATH) + str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tg(String str, String str2) {
        try {
            vn vnVarBh = zk.ga().bh();
            if (vnVarBh == null || !vnVarBh.bf()) {
                return;
            }
            String strD = vnVarBh.d();
            if (strD == null) {
                strD = "";
            }
            Log.e((strD + MscKeys.KEY_LOG_PATH) + str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
