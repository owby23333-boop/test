package ho;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: loaded from: classes8.dex */
public final class q {
    public static Bundle a(ContentResolver contentResolver, String str, Bundle bundle) {
        try {
            return Build.VERSION.SDK_INT >= 29 ? contentResolver.call("com.xiaomi.mirror.callprovider", str, (String) null, bundle) : contentResolver.call(new Uri.Builder().scheme("content").authority("com.xiaomi.mirror.callprovider").build(), str, (String) null, bundle);
        } catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}
