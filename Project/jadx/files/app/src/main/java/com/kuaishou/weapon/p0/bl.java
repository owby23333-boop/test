package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class bl {
    public static int a(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                return displayMetrics.densityDpi;
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            TimeZone timeZone = Calendar.getInstance().getTimeZone();
            if (timeZone == null) {
                return null;
            }
            jSONObject.put("0", String.valueOf(timeZone.getOffset(System.currentTimeMillis()) / 1000));
            jSONObject.put("1", timeZone.getID());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b() {
        long blockSize = 0;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
            }
        } catch (Throwable unused) {
        }
        return String.valueOf(blockSize);
    }

    public static String c() {
        String string;
        try {
            string = Locale.getDefault().toString();
        } catch (Throwable unused) {
            string = "";
        }
        return string == null ? "" : string;
    }

    public static JSONObject d() {
        DataInputStream dataInputStream;
        JSONObject jSONObject = new JSONObject();
        BufferedReader bufferedReader = null;
        try {
            try {
                dataInputStream = new DataInputStream(Runtime.getRuntime().exec("lsmod").getInputStream());
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(dataInputStream));
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                try {
                                    break;
                                } catch (IOException unused) {
                                }
                            } else if (!TextUtils.isEmpty(line)) {
                                String strA = bn.a(line);
                                if (strA.contains("-") && strA.contains(";")) {
                                    String[] strArrSplit = strA.replace(";;;", ";").split(";");
                                    if (strArrSplit.length > 1) {
                                        jSONObject.put(strArrSplit[0], strArrSplit[1]);
                                    }
                                }
                            }
                        } catch (Throwable unused2) {
                            bufferedReader = bufferedReader2;
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (IOException unused3) {
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return jSONObject;
                        }
                    }
                    dataInputStream.close();
                    bufferedReader2.close();
                } catch (Throwable unused4) {
                }
            } catch (Throwable unused5) {
                dataInputStream = null;
            }
        } catch (IOException unused6) {
        }
        return jSONObject;
    }
}
