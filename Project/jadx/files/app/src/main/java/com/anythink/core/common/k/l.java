package com.anythink.core.common.k;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.anythink.core.basead.ui.web.WebLandPageActivity;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    public static void a(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268468224);
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(Context context, String str) {
        try {
            WebLandPageActivity.a(context, str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
