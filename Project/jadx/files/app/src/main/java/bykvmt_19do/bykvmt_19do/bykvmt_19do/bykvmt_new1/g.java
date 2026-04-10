package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

/* JADX INFO: compiled from: TTestToast.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    private static Toast a;

    public static void a(Context context, String str) {
        a(context, str, 0);
    }

    public static void a(Context context, String str, int i2) {
        Toast toastA = a(context);
        if (toastA != null) {
            toastA.setDuration(i2);
            toastA.setText(String.valueOf(str));
            toastA.show();
        } else {
            String str2 = "toast msg: " + String.valueOf(str);
        }
    }

    @SuppressLint({"ShowToast"})
    private static Toast a(Context context) {
        if (context == null) {
            return a;
        }
        a = Toast.makeText(context.getApplicationContext(), "", 0);
        return a;
    }
}
