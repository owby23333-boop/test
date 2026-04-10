package cn.bmob.v3.util;

import android.content.Context;
import android.content.res.Resources;
import com.anythink.expressad.foundation.h.i;
import com.umeng.message.proguard.ad;

/* JADX INFO: loaded from: classes.dex */
public class BmobResource {
    private static BmobResource sBmobResource;
    private final String mPackageName;
    private Resources mResources;

    private BmobResource(Context context) {
        this.mResources = context.getResources();
        this.mPackageName = context.getPackageName();
    }

    public static synchronized BmobResource getInstance(Context context) {
        if (sBmobResource == null) {
            sBmobResource = new BmobResource(context.getApplicationContext());
        }
        return sBmobResource;
    }

    private int getRes(String str, String str2) {
        int identifier = this.mResources.getIdentifier(str, str2, this.mPackageName);
        if (identifier != 0) {
            return identifier;
        }
        BLog.i("getRes(" + str2 + "/ " + str + ad.f20406s);
        BLog.e("Error getting resource. Make sure you have copied all resources (res/) from SDK to your project. ");
        return 0;
    }

    public int getAnim(String str) {
        return getRes(str, i.f10648f);
    }

    public int getArray(String str) {
        return getRes(str, "array");
    }

    public int getDrawable(String str) {
        return getRes(str, i.f10645c);
    }

    public int getId(String str) {
        return getRes(str, "id");
    }

    public int getLayout(String str) {
        return getRes(str, "layout");
    }

    public int getString(String str) {
        return getRes(str, i.f10649g);
    }

    public int getStyle(String str) {
        return getRes(str, i.f10647e);
    }
}
