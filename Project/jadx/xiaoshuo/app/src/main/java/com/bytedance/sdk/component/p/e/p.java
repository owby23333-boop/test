package com.bytedance.sdk.component.p.e;

import android.content.ContentValues;
import android.net.Uri;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface p extends IInterface {
    int delete(Uri uri, String str, String[] strArr) throws RemoteException;

    String getType(Uri uri) throws RemoteException;

    String insert(Uri uri, ContentValues contentValues) throws RemoteException;

    Map query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) throws RemoteException;

    int update(Uri uri, ContentValues contentValues, String str, String[] strArr) throws RemoteException;
}
