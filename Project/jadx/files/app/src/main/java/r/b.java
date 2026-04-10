package r;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.io.File;

/* JADX INFO: compiled from: ApkUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static void a(Context context, File file) {
        if (context == null || file == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(335544320);
        intent.setDataAndType(Uri.fromFile(file), AdBaseConstants.MIME_APK);
        intent.setDataAndType(FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".SNFileProvider", file), AdBaseConstants.MIME_APK);
        intent.addFlags(1);
        context.startActivity(intent);
    }
}
