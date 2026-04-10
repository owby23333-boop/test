package com.bytedance.sdk.openadsdk.l;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ITTProvider;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements ITTProvider {
    private Function<SparseArray<Object>, Object> z;

    public z(Object obj) {
        if (obj instanceof Function) {
            this.z = (Function) obj;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public void injectContext(Context context) {
        if (this.z != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, -7999900);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(-7999920, context);
            this.z.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public String getTableName() {
        if (this.z == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -7999901);
        sparseArray.put(-99999985, String.class);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public void init() {
        if (this.z != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, -7999902);
            sparseArray.put(-99999985, Void.class);
            this.z.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public String getType(Uri uri) {
        if (this.z == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -7999903);
        sparseArray.put(-99999985, String.class);
        sparseArray.put(-7999921, uri);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (this.z == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -7999904);
        sparseArray.put(-99999985, Cursor.class);
        sparseArray.put(-7999921, uri);
        sparseArray.put(-7999922, strArr);
        sparseArray.put(-7999923, str);
        sparseArray.put(-7999924, strArr2);
        sparseArray.put(-7999925, str2);
        return (Cursor) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (this.z == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -7999905);
        sparseArray.put(-99999985, Uri.class);
        sparseArray.put(-7999921, uri);
        sparseArray.put(-7999922, contentValues);
        return (Uri) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public int delete(Uri uri, String str, String[] strArr) {
        if (this.z != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, -7999906);
            sparseArray.put(-99999985, Integer.class);
            sparseArray.put(-7999921, uri);
            sparseArray.put(-7999923, str);
            sparseArray.put(-7999924, strArr);
            Integer num = (Integer) this.z.apply(sparseArray);
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.ti.z.a.z
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (this.z != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, -7999907);
            sparseArray.put(-99999985, Integer.class);
            sparseArray.put(-7999921, uri);
            sparseArray.put(-7999922, contentValues);
            sparseArray.put(-7999923, str);
            sparseArray.put(-7999924, strArr);
            Integer num = (Integer) this.z.apply(sparseArray);
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }
}
