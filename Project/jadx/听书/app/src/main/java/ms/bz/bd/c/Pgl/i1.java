package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes4.dex */
public final class i1 {
    public static int g;
    public static int z;

    public static String z(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            z = point.x;
            g = point.y;
        } catch (Throwable unused) {
        }
        return z + "*" + g;
    }
}
