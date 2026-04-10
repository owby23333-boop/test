package ms.bz.bd.c.Pgl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes4.dex */
public final class z0 {
    private final Context z;

    public z0(Context context) {
        this.z = context;
    }

    public final String z() {
        Bundle bundleCall;
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.z.getContentResolver().acquireContentProviderClient(Uri.parse((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "67b91f", new byte[]{36, 58, Ascii.US, 89, 11, 127, 33, 76, 124, 38, 36, 59, 95, 67, Ascii.ESC, 115, 60, Ascii.ETB, 125, 96, 35, 48, Ascii.US, 89, 7, 101, 44, 89, 58, 109, 34, 59, 5, 68, Ascii.SUB, 104})));
            bundleCall = contentProviderClientAcquireContentProviderClient.call((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "917490", new byte[]{47, 54, 80, 111, 39, 14, Ascii.RS}), null, null);
            contentProviderClientAcquireContentProviderClient.close();
        } catch (Exception unused) {
        }
        if (bundleCall.getInt((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "639cf5", new byte[]{36, 62, 78, Ascii.DC2}), -1) == 0) {
            return bundleCall.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3a5c36", new byte[]{43, 103}));
        }
        bundleCall.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "61451e", new byte[]{42, 54, 84, 82, 15, 117, 48}));
        return null;
    }
}
