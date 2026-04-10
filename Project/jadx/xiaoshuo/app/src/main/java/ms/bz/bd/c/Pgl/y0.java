package ms.bz.bd.c.Pgl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.google.common.base.Ascii;
import okio.Utf8;

/* JADX INFO: loaded from: classes9.dex */
public class y0 {
    private final Context e;

    public y0(Context context) {
        this.e = context;
    }

    public String e() {
        Bundle bundleCall;
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.e.getContentResolver().acquireContentProviderClient(Uri.parse((String) pblk.a(16777217, 0, 0L, "aca171", new byte[]{115, 110, Ascii.FS, 81, Ascii.CR, 40, 118, Ascii.CAN, 127, 46, 115, 111, 92, 75, Ascii.GS, 36, 107, 67, 126, 104, 116, 100, Ascii.FS, 81, 1, 50, 123, Ascii.CR, 57, 101, 117, 111, 6, 76, Ascii.FS, Utf8.REPLACEMENT_BYTE})));
            bundleCall = contentProviderClientAcquireContentProviderClient.call((String) pblk.a(16777217, 0, 0L, "432967", new byte[]{34, 52, 85, 98, 40, 9, 19}), null, null);
            contentProviderClientAcquireContentProviderClient.close();
        } catch (Exception unused) {
        }
        if (bundleCall.getInt((String) pblk.a(16777217, 0, 0L, "3e8ccc", new byte[]{33, 104, 79, 18}), -1) == 0) {
            return bundleCall.getString((String) pblk.a(16777217, 0, 0L, "485123", new byte[]{44, 62}));
        }
        bundleCall.getString((String) pblk.a(16777217, 0, 0L, "0bd50b", new byte[]{44, 101, 4, 82, Ascii.SO, 114, 54}));
        return null;
    }
}
