package com.bytedance.sdk.openadsdk.core.multipro.d;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.component.utils.wu;
import com.bytedance.sdk.openadsdk.ITTProvider;
import com.bytedance.sdk.openadsdk.core.lc;
import com.bytedance.sdk.openadsdk.core.multipro.ga;
import com.duokan.reader.domain.payment.a;
import com.iflytek.aikit.media.param.MscKeys;

/* JADX INFO: loaded from: classes10.dex */
public class e implements ITTProvider {
    private Context e;

    public static String bf() {
        if (lc.getContext() == null) {
            return null;
        }
        try {
            ContentResolver contentResolverD = d();
            if (contentResolverD != null) {
                return contentResolverD.getType(Uri.parse(tg() + "maxRit"));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static ContentResolver d() {
        try {
            if (lc.getContext() != null) {
                return lc.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean e(String str) {
        if (lc.getContext() == null) {
            return false;
        }
        try {
            ContentResolver contentResolverD = d();
            if (contentResolverD != null) {
                return a.c.equals(contentResolverD.getType(Uri.parse(tg() + "checkFrequency?rit=" + String.valueOf(str))));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private Context getContext() {
        Context context = this.e;
        return context == null ? lc.getContext() : context;
    }

    private static String tg() {
        return ga.bf + "/t_frequent/";
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getTableName() {
        return "t_frequent";
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getType(Uri uri) {
        wu.bf("FrequentCallProviderImpl", "get type uri: " + String.valueOf(uri));
        String str = uri.getPath().split("/")[2];
        if ("checkFrequency".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.xu.e.e().e(uri.getQueryParameter("rit")) ? a.c : MscKeys.VAL_FALSE;
        }
        if ("isSilent".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.xu.e.e().bf() ? a.c : MscKeys.VAL_FALSE;
        }
        if ("maxRit".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.xu.e.e().d();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void injectContext(Context context) {
        this.e = context;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public static boolean e() {
        if (lc.getContext() == null) {
            return false;
        }
        try {
            ContentResolver contentResolverD = d();
            if (contentResolverD != null) {
                return a.c.equals(contentResolverD.getType(Uri.parse(tg() + "isSilent")));
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
