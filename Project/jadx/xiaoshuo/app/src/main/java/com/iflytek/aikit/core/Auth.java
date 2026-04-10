package com.iflytek.aikit.core;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import com.iflytek.aikit.core.BaseLibrary;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes7.dex */
public class Auth {
    private static String SDK_VERSION;
    private final String TAG;
    private AuthListener authListener;
    private int code;
    private Context context;
    private CoreListener coreListener;
    public boolean isInitOver;
    private String oaid;
    private int type;
    private boolean waitInit;

    public static class Holder {
        private static Auth instance = new Auth();

        private Holder() {
        }
    }

    static {
        try {
            System.loadLibrary("AIKIT");
        } catch (Exception e) {
            Log.e("AEE", "loadLibrary:" + e.toString());
        }
        SDK_VERSION = "1.0.0";
    }

    public static Auth getInst() {
        return Holder.instance;
    }

    private String getResDirFromSDKAssets(Context context) throws Throwable {
        FileOutputStream fileOutputStream;
        AssetManager assets = getContext().getAssets();
        if (assets == null) {
            return "";
        }
        try {
            String[] list = assets.list("aikit_resources");
            if (list.length <= 0) {
                return "";
            }
            String str = context.getFilesDir().toString() + "/aikit_resources/";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
            Log.d(this.TAG, "resources in assets,count = " + list.length);
            int length = list.length;
            for (int i = 0; i < length; i++) {
                String str2 = list[i];
                if (!new File(str + str2).exists()) {
                    InputStream inputStream = null;
                    try {
                        InputStream inputStreamOpen = assets.open("aikit_resources/" + str2);
                        try {
                            fileOutputStream = new FileOutputStream(str + str2);
                        } catch (Exception unused) {
                            fileOutputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = null;
                        }
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i2 = inputStreamOpen.read(bArr);
                                if (i2 <= -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i2);
                            }
                            Log.d(this.TAG, "resources:" + str2 + " copy from assets to:" + str + "success!");
                            inputStreamOpen.close();
                            fileOutputStream.close();
                        } catch (Exception unused2) {
                            inputStream = inputStreamOpen;
                            try {
                                Log.e(this.TAG, "resources:" + str2 + "copy from assets failed!:");
                                inputStream.close();
                                fileOutputStream.close();
                                return "";
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream.close();
                                fileOutputStream.close();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = inputStreamOpen;
                            inputStream.close();
                            fileOutputStream.close();
                            throw th;
                        }
                    } catch (Exception unused3) {
                        fileOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                    }
                }
            }
            return str;
        } catch (IOException unused4) {
            Log.d(this.TAG, "auth init info:no resources dir in aar");
            assets.close();
            return "";
        }
    }

    public Context getContext() {
        return this.context;
    }

    public String getDeviceId() {
        return getDeviceId(this.context);
    }

    public native String getDeviceId(Context context);

    public native int getOaIdWeightValue();

    public String getOaid() {
        return this.oaid;
    }

    public native int getState();

    public String getVersion() {
        return SDK_VERSION;
    }

    public void init(Context context, BaseLibrary.Params params) {
        Auth auth;
        this.code = -1;
        if (params.resDir.isEmpty()) {
            params.resDir = getResDirFromSDKAssets(context);
        }
        int iInitAndCheck = initAndCheck(context, params.getAppId(), params.getApiKey(), params.getApiSecret(), params.getAuthType(), params.getLicenseFile(), params.getWorkDir(), params.isLogOpen(), params.isiLogOpen(), params.getiLogMaxCount(), params.getiLogMaxSize(), params.isRecordOpen(), params.getCustomDeviceId(), params.getAuthInterval(), params.getResDir(), params.getLibDir(), params.getBatchID(), params.getCfgFile(), params.getAbility());
        if (iInitAndCheck == 0) {
            auth = this;
            Log.i(auth.TAG, "auth init ret:" + iInitAndCheck);
        } else {
            auth = this;
            Log.e(auth.TAG, "auth init ret:" + iInitAndCheck);
        }
        auth.sdkStateChange(ErrType.AUTH.getValue(), iInitAndCheck);
        auth.isInitOver = true;
    }

    public native int initAndCheck(Context context, String str, String str2, String str3, int i, String str4, String str5, boolean z, boolean z2, int i2, long j, boolean z3, String str6, int i3, String str7, String str8, String str9, String str10, String str11);

    public void initWithOaid(Context context, BaseLibrary.Params params) {
        Log.i(this.TAG, "require oaid");
        init(context, params);
    }

    public void registerListener(CoreListener coreListener) {
        this.coreListener = coreListener;
    }

    public native int release();

    public void reset() {
        reset(this.context);
    }

    public native void reset(Context context);

    public void sdkStateChange(int i, int i2) {
        this.type = i;
        this.code = i2;
        AuthListener authListener = this.authListener;
        if (authListener != null) {
            authListener.onAuthStateChange(ErrType.valueOf(i), i2);
            return;
        }
        CoreListener coreListener = this.coreListener;
        if (coreListener != null) {
            coreListener.onAuthStateChange(ErrType.valueOf(i), i2);
        }
    }

    public void setContext(Context context) {
        this.context = context;
        if (context == null) {
            this.type = -1;
            this.code = -1;
        }
    }

    private Auth() {
        this.TAG = getClass().getSimpleName();
        this.type = -1;
        this.code = -1;
        this.coreListener = null;
        this.authListener = null;
        this.isInitOver = false;
    }

    public void registerListener(AuthListener authListener) {
        this.authListener = authListener;
    }
}
