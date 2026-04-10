package cn.bmob.v3.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.widget.Toast;
import com.anythink.expressad.foundation.g.a;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    public static String byte2String(byte[] bArr) {
        return new String(bArr, Charset.forName(a.bN));
    }

    public static int calculatePercent(int i2, int i3) {
        if (i2 >= i3) {
            return 100;
        }
        double d2 = i2;
        double d3 = i3;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return (int) ((d2 / d3) * 100.0d);
    }

    public static void checkBmobContentProvider(Context context) {
        if (checkProviderAuthority(context, context.getPackageName() + ".BmobContentProvider")) {
            return;
        }
        Toast.makeText(context, "Please add provider in AndroidManifest:" + context.getPackageName() + ".BmobContentProvider", 0).show();
        String str = "Please add provider in AndroidManifest:" + context.getPackageName() + ".BmobContentProvider";
    }

    public static boolean checkPermission(Context context, String str) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null && strArr.length > 0) {
                for (String str2 : strArr) {
                    if (str2.equals(str)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static boolean checkProviderAuthority(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 8);
            if (packageInfo.providers != null) {
                for (int i2 = 0; i2 < packageInfo.providers.length; i2++) {
                    if (str.equals(packageInfo.providers[i2].authority)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean checkTableName(String str, int i2, int i3) {
        return startCheck("^[a-zA-Z]\\w{" + i2 + "," + i3 + "}$", str);
    }

    public static String convertFileSize(long j2) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j2 <= 0) {
            return "0B";
        }
        if (j2 < 1024) {
            return decimalFormat.format(j2) + "B";
        }
        if (j2 < 1048576) {
            StringBuilder sb = new StringBuilder();
            double d2 = j2;
            Double.isNaN(d2);
            sb.append(decimalFormat.format(d2 / 1024.0d));
            sb.append("K");
            return sb.toString();
        }
        if (j2 < DownloadConstants.GB) {
            StringBuilder sb2 = new StringBuilder();
            double d3 = j2;
            Double.isNaN(d3);
            sb2.append(decimalFormat.format(d3 / 1048576.0d));
            sb2.append("M");
            return sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        double d4 = j2;
        Double.isNaN(d4);
        sb3.append(decimalFormat.format(d4 / 1.073741824E9d));
        sb3.append("G");
        return sb3.toString();
    }

    public static String convertUrl(String str) {
        if (!str.startsWith("https")) {
            if (str.startsWith("http")) {
                str = str.replace("http://" + str.split("/")[2] + "/", "");
            }
            return str;
        }
        str = str.replace("https://" + str.split("/")[2] + "/", "");
        return str;
    }

    public static void forceMkdir(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            throw new IOException("File " + file + " exists and is not a directory. Unable to create directory.");
        }
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        throw new IOException("Unable to create directory " + file);
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static ArrayList<Object> jsonArray2List(JSONArray jSONArray) {
        ArrayList<Object> arrayList = new ArrayList<>();
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        arrayList.add(jSONArray.get(i2));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return arrayList;
    }

    public static JSONArray list2JSONArray(ArrayList arrayList) {
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null) {
            try {
                if (arrayList.size() > 0) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        jSONArray.put(arrayList.get(i2));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return jSONArray;
    }

    public static boolean mkdirs(File file) {
        try {
            forceMkdir(file);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static Map<String, Map<String, Object>> parse2Map(JSONObject jSONObject) {
        HashMap map = new HashMap();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                HashMap map2 = new HashMap();
                if (jSONObject2 != null) {
                    Iterator<String> itKeys2 = jSONObject2.keys();
                    while (itKeys2.hasNext()) {
                        String next2 = itKeys2.next();
                        map2.put(next2, jSONObject2.get(next2));
                    }
                    map.put(next, map2);
                }
            }
        } catch (Exception unused) {
        }
        return map;
    }

    public static String parseArray2String(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (i2 != length - 1) {
                    sb.append(strArr[i2]);
                    sb.append(",");
                } else {
                    sb.append(strArr[i2]);
                }
            }
        }
        return sb.toString();
    }

    public static ArrayList removeDuplicate(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!arrayList2.contains(obj)) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    private static boolean startCheck(String str, String str2) {
        return Pattern.compile(str).matcher(str2).matches();
    }

    public static byte[] string2Byte(String str) {
        return (str == null || str.length() <= 0) ? "".getBytes(Charset.forName(a.bN)) : str.getBytes(Charset.forName(a.bN));
    }
}
