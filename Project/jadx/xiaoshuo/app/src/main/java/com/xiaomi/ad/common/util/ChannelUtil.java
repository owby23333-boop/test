package com.xiaomi.ad.common.util;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes5.dex */
public class ChannelUtil {
    public static final String KEY_CHANNEL_ID = "channel_id";
    public static final String PREF_CHANNEL_ID_FILE = "channel_id_file";
    public static final String TAG = "ChannelUtil";
    public static volatile SharedPreferencesWrapper sSPWrapper;

    public static String getChannel(Context context) {
        return getSPWrapper(context).getString("channel_id", "");
    }

    public static String getChannelId(Context context) {
        String str;
        String str2 = null;
        try {
            str = (String) Class.forName("com.xiaomi.gamecenter.channel.v1reader.ChannelUtil").getMethod("readChannelId", Context.class).invoke(null, context);
        } catch (ClassNotFoundException e) {
            e = e;
        } catch (IllegalAccessException e2) {
            e = e2;
        } catch (NoSuchMethodException e3) {
            e = e3;
        } catch (InvocationTargetException e4) {
            e = e4;
        }
        try {
            MLog.d(TAG, "channel = " + str);
            return str;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e5) {
            e = e5;
            str2 = str;
            e.printStackTrace();
            return str2;
        }
    }

    public static SharedPreferencesWrapper getSPWrapper(Context context) {
        if (sSPWrapper == null) {
            synchronized (ChannelUtil.class) {
                if (sSPWrapper == null) {
                    sSPWrapper = new SharedPreferencesWrapper(context, PREF_CHANNEL_ID_FILE);
                }
            }
        }
        return sSPWrapper;
    }

    public static void updateChannel(Context context, String str) {
        SharedPreferencesWrapper sPWrapper = getSPWrapper(context);
        if (TextUtils.equals(sPWrapper.getString("channel_id", ""), str)) {
            return;
        }
        sPWrapper.putString("channel_id", str);
    }
}
