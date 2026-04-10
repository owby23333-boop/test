package cn.kuaipan.kss.utils;

import android.accounts.Account;
import android.util.Base64;
import android.util.Log;
import com.alipay.sdk.m.w.a;
import com.google.common.net.HttpHeaders;
import com.iflytek.aikit.media.param.MscKeys;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.accountsdk.utils.CloudCoder;
import com.xiaomi.micloudsdk.CloudHttpClient;
import com.yuewen.ia0;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: classes.dex */
public class NetworkUtils {
    private static boolean DBG = false;
    public static final int HTTP_REQUEST_TIMEOUT_MS = 30000;
    private static final String TAG = "NetworkUtils";

    public enum HttpMethod {
        GET,
        POST
    }

    private NetworkUtils() {
    }

    public static String appendUrl(String str, List<NameValuePair> list) throws BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        if (str == null) {
            throw new NullPointerException("origin is not allowed null");
        }
        StringBuilder sb = new StringBuilder(str);
        if (!str.contains("?")) {
            sb.append("?");
        }
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                sb.append(a.p);
            }
            String name = list.get(i).getName();
            String value = list.get(i).getValue();
            sb.append(name);
            sb.append(MscKeys.KEY_VAL_SEP);
            sb.append(URLEncoder.encode(value, "UTF-8"));
        }
        String string = sb.toString();
        if (DBG) {
            Log.d(TAG, "result url length is: " + string.length());
        }
        return string;
    }

    public static String decodeData(String str, InputStream inputStream) throws BadPaddingException, IllegalBlockSizeException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        while (true) {
            try {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } finally {
                bufferedReader.close();
            }
        }
        String string = sb.toString();
        if (string.length() == 0) {
            return string;
        }
        try {
            return new String(CloudCoder.newAESCipher(str, 2).doFinal(Base64.decode(string, 2)));
        } catch (IllegalArgumentException unused) {
            if (DBG) {
                Log.d(TAG, "base64 decode failed, content : " + sb.toString());
            }
            throw new IOException();
        }
    }

    public static String encodeData(String str, String str2) throws BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        Cipher cipherNewAESCipher = CloudCoder.newAESCipher(str, 1);
        if (cipherNewAESCipher != null) {
            return Base64.encodeToString(cipherNewAESCipher.doFinal(str2.getBytes("UTF-8")), 2);
        }
        ia0.w().o("encodeData coder is null:" + str);
        return "";
    }

    public static Header getCookies(Account account, ExtendedAuthToken extendedAuthToken) {
        return new BasicHeader(HttpHeaders.COOKIE, "serviceToken=" + extendedAuthToken.authToken + "; userId=" + account.name);
    }

    public static HttpClient getHttpClient() {
        CloudHttpClient cloudHttpClientNewInstance = CloudHttpClient.newInstance();
        HttpParams params = cloudHttpClientNewInstance.getParams();
        HttpConnectionParams.setConnectionTimeout(params, 30000);
        HttpConnectionParams.setSoTimeout(params, 30000);
        ConnManagerParams.setTimeout(params, 30000L);
        return cloudHttpClientNewInstance;
    }

    public static String getSignature(HttpMethod httpMethod, String str, ArrayList<NameValuePair> arrayList, String str2) throws UnsupportedEncodingException {
        TreeMap treeMap = new TreeMap();
        if (arrayList != null) {
            for (NameValuePair nameValuePair : arrayList) {
                treeMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
        }
        return CloudCoder.generateSignature(httpMethod.name(), str, treeMap, str2);
    }
}
