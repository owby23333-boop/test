package me.jessyan.art.f;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/* JADX INFO: compiled from: ThirdViewUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class i {
    private static int a = -1;

    public static Unbinder a(Object obj, Object obj2) {
        return obj2 instanceof Activity ? ButterKnife.bind(obj, (Activity) obj2) : obj2 instanceof View ? ButterKnife.bind(obj, (View) obj2) : obj2 instanceof Dialog ? ButterKnife.bind(obj, (Dialog) obj2) : Unbinder.EMPTY;
    }

    @Nullable
    public static View a(String str, Context context, AttributeSet attributeSet) {
        if (!me.jessyan.art.base.e.a) {
            return null;
        }
        if (a == -1) {
            a = 1;
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("design_width") || !applicationInfo.metaData.containsKey("design_height")) {
                    a = 0;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                a = 0;
            }
        }
        if (a != 0 && !str.equals("FrameLayout") && !str.equals("LinearLayout")) {
            str.equals("RelativeLayout");
        }
        return null;
    }
}
