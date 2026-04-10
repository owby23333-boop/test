package com.amgcyo.cuttadon.utils.otherutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: MkAssertUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class v {
    static Bitmap a(Context context, String str) {
        try {
            InputStream inputStreamOpen = context.getResources().getAssets().open(str);
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
            inputStreamOpen.close();
            return bitmapDecodeStream;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String b(Context context, String str) {
        try {
            return a(context.getAssets().open(str));
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static String a(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                } finally {
                }
            }
            bufferedReader.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return sb.toString();
    }
}
