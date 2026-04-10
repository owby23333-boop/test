package com.mibi.sdk.common.storage;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;

/* JADX INFO: loaded from: classes13.dex */
public class UserStorage {
    private Context mContext;
    private StorageDir mRootDir;
    private String mUserId;

    private UserStorage(Context context, String str) {
        this.mContext = context.getApplicationContext();
        this.mUserId = str;
        this.mRootDir = new StorageDir(context.getFilesDir(), "users" + File.separator + str);
    }

    public static UserStorage newUserStorage(Context context, String str) {
        return new UserStorage(context, str);
    }

    public SharedPreferences getPreference() {
        return this.mContext.getSharedPreferences(this.mUserId, 0);
    }

    public StorageDir getStorageDir() {
        return this.mRootDir;
    }

    public SharedPreferences getPreference(String str) {
        return this.mContext.getSharedPreferences(this.mUserId + "_" + str, 0);
    }

    public StorageDir getStorageDir(String str) {
        return new StorageDir(this.mRootDir, str);
    }
}
