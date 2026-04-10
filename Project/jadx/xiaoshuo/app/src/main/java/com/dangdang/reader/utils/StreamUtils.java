package com.dangdang.reader.utils;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public class StreamUtils {
    public static void closeStream(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String[] convertStringToArray(String str, char c) {
        if (str == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (c == cCharAt) {
                String strTrim = stringBuffer.toString().trim();
                if (strTrim.length() > 0) {
                    arrayList.add(strTrim);
                }
                stringBuffer.delete(0, stringBuffer.length());
            } else {
                stringBuffer.append(cCharAt);
            }
        }
        String strTrim2 = stringBuffer.toString().trim();
        if (strTrim2.length() > 0) {
            arrayList.add(strTrim2);
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    public static byte[] getBytesFromStream(InputStream inputStream) {
        return getBytesFromStream(inputStream, 2048);
    }

    public static int stringToInt(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return Integer.valueOf(str.trim()).intValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static byte[] getBytesFromStream(InputStream inputStream, int i) {
        byte[] byteArray = null;
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[i];
        while (true) {
            try {
                try {
                    int i2 = inputStream.read(bArr);
                    if (i2 <= -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return byteArray;
            } finally {
                closeStream(inputStream);
                closeStream(byteArrayOutputStream);
            }
        }
        byteArray = byteArrayOutputStream.toByteArray();
        return byteArray;
    }
}
