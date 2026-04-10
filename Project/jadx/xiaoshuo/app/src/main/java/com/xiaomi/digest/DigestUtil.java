package com.xiaomi.digest;

import com.yuewen.so2;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes5.dex */
public class DigestUtil {
    private static final int MAX_CALCULATE_LINE = 20;
    public static final String[] MQS_JE_EXP_LIST = {"java.lang.OutOfMemoryError", "No space left on device"};
    private static final String REGEX = "((java:)|(length=)|(index=)|(Index:)|(Size:))\\d+";
    private static final String REGEX_$ = "\\$[0-9a-fA-F]{1,10}@[0-9a-fA-F]{1,10}";
    private static final String REGEX_A = "@[0-9a-fA-F]{1,10}";
    private static final String REGEX_Flg = "0x[0-9a-fA-F]{1,10}";
    private static final String REGEX_NUMBER = "\\d+[B,KB,MB]*";

    public static String calcuateJavaDigest(String str) {
        String[] strArrSplit = str.replaceAll("\\t", "").split("\\n");
        StringBuilder sb = new StringBuilder();
        int iMin = Math.min(strArrSplit.length, 20);
        for (int i = 0; i < iMin; i++) {
            strArrSplit[i] = strArrSplit[i].replaceAll(REGEX, "$1XX").replaceAll("\\$[0-9a-fA-F]{1,10}@[0-9a-fA-F]{1,10}|@[0-9a-fA-F]{1,10}|0x[0-9a-fA-F]{1,10}", "XX").replaceAll(REGEX_NUMBER, "");
        }
        for (int i2 = 0; i2 < iMin && (!strArrSplit[i2].contains("...") || !strArrSplit[i2].contains(so2.Tb)); i2++) {
            sb.append(strArrSplit[i2]);
            sb.append('\n');
        }
        return md5(sb.toString());
    }

    private static String md5(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b2 : bArrDigest) {
                int i = b2 & 255;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("NoSuchAlgorithmException", e2);
        }
    }
}
