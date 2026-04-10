package e0;

import android.content.Context;
import android.util.Base64;
import com.sntech.okhttpconnection.log.Cif;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* JADX INFO: compiled from: HttpUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class f {
    public static byte[] a(Context context, String str, JSONObject jSONObject) throws Exception {
        if (str != null && str.length() > 22 && str.startsWith("file:///android_asset")) {
            InputStream inputStreamOpen = context.getAssets().open(str.substring(22));
            try {
                byte[] bArrEncode = Base64.encode(Cif.Cdo.m133if(a(inputStreamOpen), "x04VOtkJji86dsmn".getBytes(), "x04VOtkJji86dsmn".getBytes()), 0);
                inputStreamOpen.close();
                return bArrEncode;
            } catch (Throwable th) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        httpURLConnection.setDoOutput(true);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        byte[] bArrM136do = Cif.C0507if.m136do(jSONObject.toString().getBytes());
        outputStream.write(bArrM136do, 0, bArrM136do.length);
        InputStream inputStream = httpURLConnection.getInputStream();
        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getContentEncoding()) ? new GZIPInputStream(inputStream) : inputStream;
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            return a(gZIPInputStream);
        }
        throw new Exception(String.format("Http ResponseCode %s", Integer.valueOf(responseCode)));
    }

    public static byte[] a(Context context, String str) throws Exception {
        if (str != null && str.length() > 22 && str.startsWith("file:///android_asset")) {
            InputStream inputStreamOpen = context.getAssets().open(str.substring(22));
            try {
                byte[] bArrA = a(inputStreamOpen);
                inputStreamOpen.close();
                return bArrA;
            } catch (Throwable th) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        httpURLConnection.connect();
        InputStream inputStream = httpURLConnection.getInputStream();
        int responseCode = httpURLConnection.getResponseCode();
        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getContentEncoding()) ? new GZIPInputStream(inputStream) : inputStream;
        if (responseCode == 200) {
            return a(gZIPInputStream);
        }
        throw new Exception(String.format("Http ResponseCode %s", Integer.valueOf(responseCode)));
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 != -1) {
                byteArrayOutputStream.write(bArr, 0, i2);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
