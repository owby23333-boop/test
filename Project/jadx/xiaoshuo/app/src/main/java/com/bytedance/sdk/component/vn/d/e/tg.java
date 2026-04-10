package com.bytedance.sdk.component.vn.d.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class tg {
    private Context e;

    private Context getContext() {
        Context context = this.e;
        return context == null ? com.bytedance.sdk.component.vn.d.getContext() : context;
    }

    public void bf() {
    }

    public int delete(Uri uri, String str, String[] strArr) {
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit[2].equals("clean")) {
            d.e(getContext(), uri.getQueryParameter("sp_file_name"));
            return 0;
        }
        String str2 = strArrSplit[3];
        if (d.e(getContext(), uri.getQueryParameter("sp_file_name"), str2)) {
            d.bf(getContext(), uri.getQueryParameter("sp_file_name"), str2);
        }
        return 0;
    }

    public String e() {
        return "t_sp";
    }

    public String getType(Uri uri) {
        String[] strArrSplit = uri.getPath().split("/");
        String str = strArrSplit[2];
        String str2 = strArrSplit[3];
        if (str.equals("contain")) {
            return d.e(com.bytedance.sdk.component.vn.d.getContext(), uri.getQueryParameter("sp_file_name"), str2) + "";
        }
        return "" + d.e(getContext(), uri.getQueryParameter("sp_file_name"), str2, str);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        String[] strArrSplit = uri.getPath().split("/");
        String str = strArrSplit[2];
        String str2 = strArrSplit[3];
        Object obj = contentValues.get("value");
        if (obj != null) {
            d.e(getContext(), uri.getQueryParameter("sp_file_name"), str2, obj);
        }
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Map<String, ?> mapBf;
        if (!uri.getPath().split("/")[2].equals("get_all") || (mapBf = d.bf(getContext(), uri.getQueryParameter("sp_file_name"))) == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
        for (String str3 : mapBf.keySet()) {
            Object[] objArr = new Object[3];
            objArr[0] = str3;
            Object obj = mapBf.get(str3);
            objArr[2] = obj;
            if (obj instanceof Boolean) {
                objArr[1] = TypedValues.Custom.S_BOOLEAN;
            } else if (obj instanceof String) {
                objArr[1] = TypedValues.Custom.S_STRING;
            } else if (obj instanceof Integer) {
                objArr[1] = "int";
            } else if (obj instanceof Long) {
                objArr[1] = "long";
            } else if (obj instanceof Float) {
                objArr[1] = "float";
            }
            matrixCursor.addRow(objArr);
        }
        return matrixCursor;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (contentValues == null) {
            return 0;
        }
        insert(uri, contentValues);
        return 0;
    }

    public void e(Context context) {
        this.e = context;
    }
}
