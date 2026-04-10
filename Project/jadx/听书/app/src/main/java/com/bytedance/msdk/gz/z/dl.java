package com.bytedance.msdk.gz.z;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static volatile dl z;
    private Uri g;

    public static dl z() {
        if (z == null) {
            synchronized (dl.class) {
                if (z == null) {
                    z = new dl();
                }
            }
        }
        return z;
    }

    private dl() {
        if (com.bytedance.msdk.core.g.getContext() != null) {
            this.g = Uri.parse("content://" + com.bytedance.msdk.core.g.getContext().getPackageName() + ".TTMultiProvider/gromore_prime_rit_adn_perform");
        }
    }

    public void insert(String str, String str2, String str3, String str4) {
        if (com.bytedance.msdk.core.g.getContext() == null || this.g == null) {
            return;
        }
        ContentResolver contentResolver = com.bytedance.msdk.core.g.getContext().getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediationConstant.EXTRA_ADN_NAME, str);
        contentValues.put(MediationConstant.KEY_GM_PRIME_RIT, str2);
        contentValues.put("adn_rit", str3);
        contentValues.put("ad_action", str4);
        contentValues.put("time_stamp", Long.valueOf(System.currentTimeMillis()));
        contentResolver.insert(this.g, contentValues);
    }

    public List<g> query(String str, String str2, long j, long j2) {
        String str3;
        String[] strArr;
        if (com.bytedance.msdk.core.g.getContext() == null || this.g == null) {
            return null;
        }
        ContentResolver contentResolver = com.bytedance.msdk.core.g.getContext().getContentResolver();
        String[] strArr2 = {str, str2, String.valueOf(j), String.valueOf(j2)};
        if (TextUtils.isEmpty(str)) {
            strArr = new String[]{str2, String.valueOf(j), String.valueOf(j2)};
            str3 = "prime_rit=? AND time_stamp>=? AND time_stamp<?";
        } else {
            str3 = "adn_name=? AND prime_rit=? AND time_stamp>=? AND time_stamp<?";
            strArr = strArr2;
        }
        Cursor cursorQuery = contentResolver.query(this.g, null, str3, strArr, null);
        if (cursorQuery == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        while (cursorQuery.moveToNext()) {
            try {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(MediationConstant.EXTRA_ADN_NAME));
                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(MediationConstant.KEY_GM_PRIME_RIT));
                String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("adn_rit"));
                String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("ad_action"));
                long j3 = cursorQuery.getLong(cursorQuery.getColumnIndex("time_stamp"));
                g gVar = new g();
                gVar.dl(string);
                gVar.z(string2);
                gVar.g(string3);
                gVar.a(string4);
                gVar.z(j3);
                linkedList.add(gVar);
            } finally {
                cursorQuery.close();
            }
        }
        return linkedList;
    }

    public void z(String str, long j) {
        if (com.bytedance.msdk.core.g.getContext() == null || this.g == null || j <= 0) {
            return;
        }
        try {
            com.bytedance.msdk.core.g.getContext().getContentResolver().delete(this.g, "prime_rit=? AND time_stamp<?", new String[]{str, String.valueOf(j)});
        } catch (IllegalStateException unused) {
        }
    }
}
