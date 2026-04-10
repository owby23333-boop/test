package com.bytedance.sdk.component.p.e.bf.bf;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.p.e.d.d;
import com.bytedance.sdk.component.p.e.e.e.p;
import com.bytedance.sdk.component.p.e.e.e.vn;
import com.bytedance.sdk.component.p.e.zk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private Context e;

    public static void bf() {
        if (zk.ga().getContext() == null) {
            return;
        }
        try {
            ContentResolver contentResolverGa = ga();
            if (contentResolverGa != null) {
                contentResolverGa.getType(Uri.parse(vn() + "adLogStop"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void e() {
        d.e("start()");
        if (zk.ga().getContext() == null) {
            return;
        }
        try {
            ContentResolver contentResolverGa = ga();
            if (contentResolverGa != null) {
                contentResolverGa.getType(Uri.parse(vn() + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    private static ContentResolver ga() {
        try {
            if (zk.ga().getContext() != null) {
                return zk.ga().getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String vn() {
        return p.bf + "/ad_log_event/";
    }

    public String d() {
        return "ad_log_event";
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        int i;
        d.e("gettype()");
        String str = uri.getPath().split("/")[2];
        str.hashCode();
        switch (str) {
            case "trackAdFailed":
                zk.ga().e(uri.getQueryParameter("did"));
                break;
            case "adLogStart":
                d.e("EventProviderImpl====ad event function will be start====");
                zk.ga().p();
                break;
            case "adLogStop":
                d.e("EventProviderImpl", "====ad event function will be stop====");
                zk.ga().v();
                break;
            case "adLogDispatch":
                d.e("EventProviderImpl", "dispatch FUN_AD_EVENT_DISPATCH");
                com.bytedance.sdk.component.p.e.tg.e eVarTg = com.bytedance.sdk.component.p.e.tg.e.e.tg(vn.bf(uri.getQueryParameter("event")));
                if (eVarTg != null) {
                    zk.ga().e(eVarTg);
                    break;
                }
                break;
            case "trackAdUrl":
                try {
                    String queryParameter = uri.getQueryParameter("did");
                    boolean zBooleanValue = Boolean.valueOf(uri.getQueryParameter("replace")).booleanValue();
                    String[] strArrSplit = vn.bf(uri.getQueryParameter("track")).split(",");
                    if (strArrSplit.length > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (String str2 : strArrSplit) {
                            String strBf = vn.bf(str2);
                            if (!TextUtils.isEmpty(strBf)) {
                                arrayList.add(strBf);
                            }
                        }
                        zk.ga().e(queryParameter, arrayList, zBooleanValue);
                    }
                    break;
                } catch (Throwable unused) {
                    return null;
                }
                break;
        }
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public void tg() {
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public static void e(com.bytedance.sdk.component.p.e.tg.e eVar) {
        if (eVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverGa = ga();
            if (contentResolverGa != null) {
                contentResolverGa.getType(Uri.parse(vn() + "adLogDispatch?event=" + vn.e(eVar.vn())));
                d.e("dispatch event getType end ");
            }
        } catch (Throwable th) {
            d.tg("dispatch event Throwable:" + th.toString());
        }
    }

    public static void e(String str, List<String> list, boolean z) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(vn.e(it.next()));
                sb.append(",");
            }
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(vn.e(sb.toString())) + "&replace=" + String.valueOf(z);
            ContentResolver contentResolverGa = ga();
            if (contentResolverGa != null) {
                contentResolverGa.getType(Uri.parse(vn() + "trackAdUrl" + str2));
            }
        } catch (Throwable unused) {
        }
    }

    public static void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverGa = ga();
            if (contentResolverGa != null) {
                contentResolverGa.getType(Uri.parse(vn() + "trackAdFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }

    public void e(Context context) {
        this.e = context;
    }
}
