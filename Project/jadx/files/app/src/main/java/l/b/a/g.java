package l.b.a;

import android.annotation.TargetApi;
import android.app.Application;
import android.os.Handler;
import android.widget.Toast;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: SafeToast.java */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(19)
public final class g extends e {
    public g(Application application) {
        super(application);
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Field declaredField2 = declaredField.getType().getDeclaredField("mHandler");
            declaredField2.setAccessible(true);
            declaredField2.set(obj, new f((Handler) declaredField2.get(obj)));
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
    }
}
