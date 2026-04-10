package com.baidu.tts.tools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.tts.enumtype.CharSetEnum;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.param.TextParams;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes2.dex */
public class ResourceTools {
    public static final int TEXT_LENGTH_LIMIT = 120;

    public static TextParams format(String str, String str2, TextParams textParams) {
        try {
            textParams.setText(new String(textParams.getText().getBytes(str), str2));
            textParams.setTextEncode(str2);
            return textParams;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getAppFilesDirPath(Context context) {
        return context.getFilesDir().getAbsolutePath() + "/";
    }

    public static String getAppFilesPath(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.dataDir + "/files/";
        } catch (Exception unused) {
            return context.getFilesDir().getAbsolutePath() + "/";
        }
    }

    public static String getByteMapAbsName(Context context, String str) {
        return getModelFileAbsName(context, str + ".bm");
    }

    public static String getDefaultResourcePath(Context context, String str) {
        return getSdcardFilesDirPath(context) + str;
    }

    public static String getModelFileAbsName(Context context, String str) {
        return FileTools.jointPathAndName(getAppFilesPath(context) + "modelDir/", str);
    }

    @SuppressLint({"SdCardPath"})
    public static String getSdcardFilesDirPath(Context context) {
        return "/sdcard/tts/";
    }

    public static TtsErrorEnum isTextValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return TtsErrorEnum.TEXT_IS_EMPTY;
        }
        try {
            if (str.getBytes(CharSetEnum.GBK.getCharset()).length > 120) {
                return TtsErrorEnum.TEXT_IS_TOO_LONG;
            }
            return null;
        } catch (UnsupportedEncodingException unused) {
            return TtsErrorEnum.TEXT_ENCODE_IS_WRONG;
        }
    }

    public static byte[] stringToByteArrayAddNull(String str) {
        if (str == null) {
            str = "";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = {0};
        byte[] bArr2 = new byte[bytes.length + 1];
        System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
        System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
        return bArr2;
    }
}
