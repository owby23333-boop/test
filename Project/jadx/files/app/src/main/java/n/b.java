package n;

import android.content.Context;
import com.sntech.ads.BuildConfig;
import com.sntech.net.DomainProvider;
import com.umeng.analytics.pro.d;
import java.io.File;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: Const.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static boolean a = false;

    public static File a(Context context) {
        File file = new File(context.getFilesDir(), "SNADS/Dex");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static boolean b() {
        try {
            Field declaredField = BuildConfig.class.getDeclaredField("DEBUG");
            declaredField.setAccessible(true);
            if (((Boolean) declaredField.get(null)).booleanValue()) {
                return true;
            }
            return a;
        } catch (Exception e2) {
            if (b()) {
                e2.printStackTrace();
            }
            return a;
        }
    }

    public static String a() {
        return DomainProvider.baseUrl() + d.W;
    }

    public static File b(Context context) {
        return new File(a(context), "NewVersion.jar");
    }
}
