package com.bykv.vk.openvk.component.video.z.dl;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.z.g.fo;
import com.bykv.vk.openvk.component.video.z.g.g.dl;
import com.bykv.vk.openvk.component.video.z.g.gc;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.e;
import com.google.common.net.HttpHeaders;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class z {
    private static final Handler g = new Handler(Looper.getMainLooper());
    public static final Charset z = Charset.forName("UTF-8");

    public static void z(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void z(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void z(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void z(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean z(String str) {
        if (str != null) {
            return str.startsWith("http://") || str.startsWith("https://");
        }
        return false;
    }

    public static int g(String str) {
        return z(str, 0);
    }

    public static int z(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static String z(com.bykv.vk.openvk.component.video.z.g.gc.z zVar, int i) {
        int iZ;
        if (zVar == null || !zVar.g()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(zVar.gc().toUpperCase()).append(' ').append(zVar.z()).append(' ').append(zVar.m()).append("\r\n");
        if (gc.dl) {
            wp.z("TAG_PROXY_headers", zVar.gc().toUpperCase() + " " + zVar.z() + " " + zVar.m());
        }
        List<fo.g> listZ = z(zVar.dl());
        boolean z2 = true;
        if (listZ != null) {
            int size = listZ.size();
            for (int i2 = 0; i2 < size; i2++) {
                fo.g gVar = listZ.get(i2);
                if (gVar != null) {
                    String str = gVar.z;
                    String str2 = gVar.g;
                    sb.append(str).append(": ").append(str2).append("\r\n");
                    if (HttpHeaders.CONTENT_RANGE.equalsIgnoreCase(str) || (HttpHeaders.ACCEPT_RANGES.equalsIgnoreCase(str) && "bytes".equalsIgnoreCase(str2))) {
                        z2 = false;
                    }
                }
            }
        }
        if (z2 && (iZ = z(zVar)) > 0) {
            sb.append("Content-Range: bytes ").append(Math.max(i, 0)).append("-").append(iZ - 1).append("/").append(iZ).append("\r\n");
        }
        sb.append("Connection: close\r\n\r\n");
        String string = sb.toString();
        if (gc.dl) {
            wp.z("TAG_PROXY_WRITE_TO_MP", string);
        }
        return string;
    }

    public static String z(int i, int i2) {
        String strG = g(i, i2);
        if (strG == null) {
            return null;
        }
        return "bytes=" + strG;
    }

    public static String g(int i, int i2) {
        if (i >= 0 && i2 > 0) {
            return i + "-" + i2;
        }
        if (i > 0) {
            return i + "-";
        }
        if (i >= 0 || i2 <= 0) {
            return null;
        }
        return "-" + i2;
    }

    public static List<String> z(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (z(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static String z(com.bykv.vk.openvk.component.video.z.g.g.z zVar, int i) {
        StringBuilder sb = new StringBuilder();
        if (i <= 0) {
            sb.append("HTTP/1.1 200 OK\r\n");
        } else {
            sb.append("HTTP/1.1 206 Partial Content\r\n");
        }
        sb.append("Accept-Ranges: bytes\r\nContent-Type: ");
        sb.append(zVar.g).append("\r\n");
        if (i <= 0) {
            sb.append("Content-Length: ").append(zVar.dl).append("\r\n");
        } else {
            sb.append("Content-Range: bytes ").append(i).append("-").append(zVar.dl - 1).append("/").append(zVar.dl).append("\r\nContent-Length: ");
            sb.append(zVar.dl - i).append("\r\n");
        }
        sb.append("Connection: close\r\n\r\n");
        String string = sb.toString();
        if (gc.dl) {
            wp.z("TAG_PROXY_WRITE_TO_MP", string);
        }
        return string;
    }

    public static int z() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 1);
    }

    /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.z.dl.z$1, reason: invalid class name */
    static class AnonymousClass1 implements FilenameFilter {
        private Pattern z = Pattern.compile("^cpu[0-9]+$");

        AnonymousClass1() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.z.matcher(str).matches();
        }
    }

    public static int z(com.bykv.vk.openvk.component.video.z.g.gc.z zVar) {
        int iLastIndexOf;
        if (zVar == null) {
            return -1;
        }
        if (zVar.z() == 200) {
            return z(zVar.z(HttpHeaders.CONTENT_LENGTH, null), -1);
        }
        if (zVar.z() == 206) {
            String strZ = zVar.z(HttpHeaders.CONTENT_RANGE, null);
            if (!TextUtils.isEmpty(strZ) && (iLastIndexOf = strZ.lastIndexOf("/")) >= 0 && iLastIndexOf < strZ.length() - 1) {
                return z(strZ.substring(iLastIndexOf + 1), -1);
            }
        }
        return -1;
    }

    public static String z(com.bykv.vk.openvk.component.video.z.g.gc.z zVar, boolean z2, boolean z3) {
        String strZ;
        if (zVar == null) {
            if (gc.dl) {
                wp.a("TAG_PROXY_Response", "response null");
            }
            return "response null";
        }
        if (!zVar.g()) {
            if (gc.dl) {
                wp.a("TAG_PROXY_Response", "response code: " + zVar.z());
            }
            return "response code: " + zVar.z();
        }
        String strZ2 = zVar.z(HttpHeaders.CONTENT_TYPE, null);
        if (!dl(strZ2)) {
            if (gc.dl) {
                wp.a("TAG_PROXY_Response", "Content-Type: " + strZ2);
            }
            return "Content-Type: " + strZ2;
        }
        int iZ = z(zVar);
        if (iZ <= 0) {
            if (gc.dl) {
                wp.a("TAG_PROXY_Response", "Content-Length: " + iZ);
            }
            return "Content-Length: " + iZ;
        }
        if (z2 && ((strZ = zVar.z(HttpHeaders.ACCEPT_RANGES, null)) == null || !strZ.contains("bytes"))) {
            if (gc.dl) {
                wp.a("TAG_PROXY_Response", "Accept-Ranges: " + strZ);
            }
            return "Accept-Ranges: " + strZ;
        }
        if (!z3 || zVar.a() != null) {
            return null;
        }
        if (gc.dl) {
            wp.a("TAG_PROXY_Response", "response body null");
        }
        return "response body null";
    }

    public static boolean dl(String str) {
        if (str != null) {
            return str.startsWith("video/") || "application/octet-stream".equals(str) || "binary/octet-stream".equals(str);
        }
        return false;
    }

    public static boolean g() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static void z(com.bytedance.sdk.component.uy.fo foVar) {
        if (foVar != null) {
            if (g()) {
                e.g(foVar);
                if (gc.dl) {
                    wp.a("TAG_PROXY_UTIL", "invoke in pool thread");
                    return;
                }
                return;
            }
            foVar.run();
            if (gc.dl) {
                wp.a("TAG_PROXY_UTIL", "invoke calling thread");
            }
        }
    }

    public static void z(Runnable runnable) {
        if (runnable != null) {
            if (g()) {
                runnable.run();
            } else {
                g.post(runnable);
            }
        }
    }

    public static List<fo.g> z(List<fo.g> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (gc.dl) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                fo.g gVar = list.get(i);
                if (gVar != null) {
                    wp.z("TAG_PROXY_PRE_FILTER", gVar.z + ": " + gVar.z);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (fo.g gVar2 : list) {
            if (HttpHeaders.HOST.equals(gVar2.z) || HttpHeaders.KEEP_ALIVE.equals(gVar2.z) || HttpHeaders.CONNECTION.equals(gVar2.z) || "Proxy-Connection".equals(gVar2.z)) {
                arrayList.add(gVar2);
            }
        }
        list.removeAll(arrayList);
        if (gc.dl) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                fo.g gVar3 = list.get(i2);
                if (gVar3 != null) {
                    wp.z("TAG_PROXY_POST_FILTER", gVar3.z + ": " + gVar3.g);
                }
            }
        }
        return list;
    }

    public static List<fo.g> z(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            try {
                Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : setEntrySet) {
                    arrayList.add(new fo.g(entry.getKey(), entry.getValue()));
                }
                return arrayList;
            } catch (Throwable th) {
                wp.z(th);
            }
        }
        return null;
    }

    public static com.bykv.vk.openvk.component.video.z.g.g.z z(com.bykv.vk.openvk.component.video.z.g.gc.z zVar, dl dlVar, String str, int i) {
        String strG;
        String str2;
        String string;
        com.bykv.vk.openvk.component.video.z.g.g.z zVarQuery = dlVar.query(str, i);
        if (zVarQuery != null) {
            return zVarQuery;
        }
        int iZ = z(zVar);
        String strZ = zVar.z(HttpHeaders.CONTENT_TYPE, null);
        if (iZ <= 0 || TextUtils.isEmpty(strZ)) {
            return zVarQuery;
        }
        com.bykv.vk.openvk.component.video.z.g.gc.gc gcVarE = zVar.e();
        if (gcVarE != null) {
            str2 = gcVarE.g;
            strG = g(gcVarE.gc);
        } else {
            strG = "";
            str2 = strG;
        }
        String strG2 = g(zVar.dl());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestUrl", str2);
            jSONObject.put("requestHeaders", strG);
            jSONObject.put("responseHeaders", strG2);
            string = jSONObject.toString();
        } catch (Throwable unused) {
            string = "";
        }
        com.bykv.vk.openvk.component.video.z.g.g.z zVar2 = new com.bykv.vk.openvk.component.video.z.g.g.z(str, strZ, iZ, i, string);
        dlVar.insert(zVar2);
        return zVar2;
    }

    public static String g(List<fo.g> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            fo.g gVar = list.get(0);
            if (gVar != null) {
                sb.append(gVar.z).append(": ").append(gVar.g).append("\r\n");
            }
        }
        return sb.toString();
    }

    public static String g(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append((Object) entry.getKey()).append(": ").append((Object) entry.getValue()).append("\r\n");
        }
        return sb.toString();
    }
}
