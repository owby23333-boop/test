package com.bykv.vk.openvk.component.video.e.d;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import cn.kuaipan.android.http.multipart.FilePart;
import com.bykv.vk.openvk.component.video.e.bf.bf.d;
import com.bykv.vk.openvk.component.video.e.bf.ga;
import com.bykv.vk.openvk.component.video.e.bf.zk;
import com.bytedance.sdk.component.zk.p;
import com.google.common.net.HttpHeaders;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import net.oauth.http.HttpResponseMessage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    private static final Handler bf = new Handler(Looper.getMainLooper());
    public static final Charset e = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.e.d.e$1, reason: invalid class name */
    public static class AnonymousClass1 implements FilenameFilter {
        private Pattern e = Pattern.compile("^cpu[0-9]+$");

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.e.matcher(str).matches();
        }
    }

    public static int bf(String str) {
        return e(str, 0);
    }

    public static boolean d(String str) {
        return str != null && (str.startsWith("video/") || FilePart.DEFAULT_CONTENT_TYPE.equals(str) || "binary/octet-stream".equals(str));
    }

    public static void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static String bf(int i, int i2) {
        if (i >= 0 && i2 > 0) {
            return i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2;
        }
        if (i > 0) {
            return i + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        if (i >= 0 || i2 <= 0) {
            return null;
        }
        return Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2;
    }

    public static void e(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void e(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void e(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean bf() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static String bf(List<zk.bf> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            zk.bf bfVar = list.get(0);
            if (bfVar != null) {
                sb.append(bfVar.e);
                sb.append(": ");
                sb.append(bfVar.bf);
                sb.append(HttpResponseMessage.EOL);
            }
        }
        return sb.toString();
    }

    public static boolean e(String str) {
        return str != null && (str.startsWith("http://") || str.startsWith("https://"));
    }

    public static int e(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static String e(com.bykv.vk.openvk.component.video.e.bf.ga.e eVar, int i) {
        int iE;
        if (eVar == null || !eVar.bf()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(eVar.ga().toUpperCase());
        sb.append(' ');
        sb.append(eVar.e());
        sb.append(' ');
        sb.append(eVar.vn());
        sb.append(HttpResponseMessage.EOL);
        if (ga.d) {
            Log.i("TAG_PROXY_headers", eVar.ga().toUpperCase() + " " + eVar.e() + " " + eVar.vn());
        }
        List<zk.bf> listE = e(eVar.d());
        boolean z = true;
        if (listE != null) {
            int size = listE.size();
            for (int i2 = 0; i2 < size; i2++) {
                zk.bf bfVar = listE.get(i2);
                if (bfVar != null) {
                    String str = bfVar.e;
                    String str2 = bfVar.bf;
                    sb.append(str);
                    sb.append(": ");
                    sb.append(str2);
                    sb.append(HttpResponseMessage.EOL);
                    if (HttpHeaders.CONTENT_RANGE.equalsIgnoreCase(str) || ("Accept-Ranges".equalsIgnoreCase(str) && "bytes".equalsIgnoreCase(str2))) {
                        z = false;
                    }
                }
            }
        }
        if (z && (iE = e(eVar)) > 0) {
            sb.append("Content-Range: bytes ");
            sb.append(Math.max(i, 0));
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(iE - 1);
            sb.append("/");
            sb.append(iE);
            sb.append(HttpResponseMessage.EOL);
        }
        sb.append("Connection: close");
        sb.append(HttpResponseMessage.EOL);
        sb.append(HttpResponseMessage.EOL);
        String string = sb.toString();
        if (ga.d) {
            Log.i("TAG_PROXY_WRITE_TO_MP", string);
        }
        return string;
    }

    public static String bf(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append((Object) entry.getKey());
            sb.append(": ");
            sb.append((Object) entry.getValue());
            sb.append(HttpResponseMessage.EOL);
        }
        return sb.toString();
    }

    public static String e(int i, int i2) {
        String strBf = bf(i, i2);
        if (strBf == null) {
            return null;
        }
        return "bytes=" + strBf;
    }

    public static List<String> e(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (e(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static String e(com.bykv.vk.openvk.component.video.e.bf.bf.e eVar, int i) {
        StringBuilder sb = new StringBuilder();
        if (i <= 0) {
            sb.append("HTTP/1.1 200 OK");
            sb.append(HttpResponseMessage.EOL);
        } else {
            sb.append("HTTP/1.1 206 Partial Content");
            sb.append(HttpResponseMessage.EOL);
        }
        sb.append("Accept-Ranges: bytes");
        sb.append(HttpResponseMessage.EOL);
        sb.append("Content-Type: ");
        sb.append(eVar.bf);
        sb.append(HttpResponseMessage.EOL);
        if (i <= 0) {
            sb.append("Content-Length: ");
            sb.append(eVar.d);
            sb.append(HttpResponseMessage.EOL);
        } else {
            sb.append("Content-Range: bytes ");
            sb.append(i);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(eVar.d - 1);
            sb.append("/");
            sb.append(eVar.d);
            sb.append(HttpResponseMessage.EOL);
            sb.append("Content-Length: ");
            sb.append(eVar.d - i);
            sb.append(HttpResponseMessage.EOL);
        }
        sb.append("Connection: close");
        sb.append(HttpResponseMessage.EOL);
        sb.append(HttpResponseMessage.EOL);
        String string = sb.toString();
        if (ga.d) {
            Log.i("TAG_PROXY_WRITE_TO_MP", string);
        }
        return string;
    }

    public static int e() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 1);
    }

    public static int e(com.bykv.vk.openvk.component.video.e.bf.ga.e eVar) {
        int iLastIndexOf;
        if (eVar == null) {
            return -1;
        }
        if (eVar.e() == 200) {
            return e(eVar.e("Content-Length", null), -1);
        }
        if (eVar.e() == 206) {
            String strE = eVar.e(HttpHeaders.CONTENT_RANGE, null);
            if (!TextUtils.isEmpty(strE) && (iLastIndexOf = strE.lastIndexOf("/")) >= 0 && iLastIndexOf < strE.length() - 1) {
                return e(strE.substring(iLastIndexOf + 1), -1);
            }
        }
        return -1;
    }

    public static String e(com.bykv.vk.openvk.component.video.e.bf.ga.e eVar, boolean z, boolean z2) {
        String strE;
        if (eVar == null) {
            if (ga.d) {
                Log.e("TAG_PROXY_Response", "response null");
            }
            return "response null";
        }
        if (!eVar.bf()) {
            if (ga.d) {
                Log.e("TAG_PROXY_Response", "response code: " + eVar.e());
            }
            return "response code: " + eVar.e();
        }
        String strE2 = eVar.e("Content-Type", null);
        if (!d(strE2)) {
            if (ga.d) {
                Log.e("TAG_PROXY_Response", "Content-Type: " + strE2);
            }
            return "Content-Type: " + strE2;
        }
        int iE = e(eVar);
        if (iE <= 0) {
            if (ga.d) {
                Log.e("TAG_PROXY_Response", "Content-Length: " + iE);
            }
            return "Content-Length: " + iE;
        }
        if (z && ((strE = eVar.e("Accept-Ranges", null)) == null || !strE.contains("bytes"))) {
            if (ga.d) {
                Log.e("TAG_PROXY_Response", "Accept-Ranges: " + strE);
            }
            return "Accept-Ranges: " + strE;
        }
        if (!z2 || eVar.tg() != null) {
            return null;
        }
        if (ga.d) {
            Log.e("TAG_PROXY_Response", "response body null");
        }
        return "response body null";
    }

    public static void e(p pVar) {
        if (pVar != null) {
            if (bf()) {
                com.bytedance.sdk.component.zk.ga.bf(pVar);
                if (ga.d) {
                    Log.e("TAG_PROXY_UTIL", "invoke in pool thread");
                    return;
                }
                return;
            }
            pVar.run();
            if (ga.d) {
                Log.e("TAG_PROXY_UTIL", "invoke calling thread");
            }
        }
    }

    public static void e(Runnable runnable) {
        if (runnable != null) {
            if (bf()) {
                runnable.run();
            } else {
                bf.post(runnable);
            }
        }
    }

    public static List<zk.bf> e(List<zk.bf> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (ga.d) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                zk.bf bfVar = list.get(i);
                if (bfVar != null) {
                    Log.i("TAG_PROXY_PRE_FILTER", bfVar.e + ": " + bfVar.e);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (zk.bf bfVar2 : list) {
            if (HttpHeaders.HOST.equals(bfVar2.e) || "Keep-Alive".equals(bfVar2.e) || HttpHeaders.CONNECTION.equals(bfVar2.e) || "Proxy-Connection".equals(bfVar2.e)) {
                arrayList.add(bfVar2);
            }
        }
        list.removeAll(arrayList);
        if (ga.d) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                zk.bf bfVar3 = list.get(i2);
                if (bfVar3 != null) {
                    Log.i("TAG_PROXY_POST_FILTER", bfVar3.e + ": " + bfVar3.bf);
                }
            }
        }
        return list;
    }

    public static List<zk.bf> e(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            try {
                Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : setEntrySet) {
                    arrayList.add(new zk.bf(entry.getKey(), entry.getValue()));
                }
                return arrayList;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static com.bykv.vk.openvk.component.video.e.bf.bf.e e(com.bykv.vk.openvk.component.video.e.bf.ga.e eVar, d dVar, String str, int i) {
        String strBf;
        String str2;
        String string;
        com.bykv.vk.openvk.component.video.e.bf.bf.e eVarQuery = dVar.query(str, i);
        if (eVarQuery != null) {
            return eVarQuery;
        }
        int iE = e(eVar);
        String strE = eVar.e("Content-Type", null);
        if (iE <= 0 || TextUtils.isEmpty(strE)) {
            return eVarQuery;
        }
        com.bykv.vk.openvk.component.video.e.bf.ga.ga gaVarP = eVar.p();
        if (gaVarP != null) {
            str2 = gaVarP.bf;
            strBf = bf(gaVarP.ga);
        } else {
            strBf = "";
            str2 = strBf;
        }
        String strBf2 = bf(eVar.d());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestUrl", str2);
            jSONObject.put("requestHeaders", strBf);
            jSONObject.put("responseHeaders", strBf2);
            string = jSONObject.toString();
        } catch (Throwable unused) {
            string = "";
        }
        com.bykv.vk.openvk.component.video.e.bf.bf.e eVar2 = new com.bykv.vk.openvk.component.video.e.bf.bf.e(str, strE, iE, i, string);
        dVar.insert(eVar2);
        return eVar2;
    }
}
