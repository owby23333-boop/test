package com.yuewen;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;

/* JADX INFO: loaded from: classes5.dex */
public class h62 {
    public static int a(Activity activity) {
        if (!b(activity)) {
            return 0;
        }
        Resources resources = activity.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static boolean b(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        return point2.y != point.y;
    }
}
