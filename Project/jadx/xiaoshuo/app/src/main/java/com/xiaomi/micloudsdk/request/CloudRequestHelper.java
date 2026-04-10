package com.xiaomi.micloudsdk.request;

import android.text.TextUtils;
import android.util.Log;
import cn.kuaipan.kss.utils.NetworkUtils;
import com.duokan.reader.domain.payment.a;
import com.xiaomi.micloudsdk.exception.CloudServerException;
import com.xiaomi.micloudsdk.utils.CloudUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

/* JADX INFO: loaded from: classes8.dex */
public class CloudRequestHelper {
    private static final String ENCODING_GZIP = "gzip";
    private static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static final int HTTP_URL_LENGTH_LIMIT = 1024;
    private static final int MAX_FILTER_TAG_COUNT = 100;
    public static final String MICLOUD_TAG = "Micloud";
    private static final String PARAM_SYNC_FILTER_TAG = "filterTag";

    private CloudRequestHelper() {
    }

    public static InputStream decodeGZip(HttpResponse httpResponse) throws IllegalStateException, IOException {
        Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
        return (firstHeader == null || !firstHeader.getValue().equalsIgnoreCase("gzip")) ? httpResponse.getEntity().getContent() : new GZIPInputStream(httpResponse.getEntity().getContent());
    }

    private static String httpGetRequest(String str, Header header, String str2, int i) throws BadPaddingException, CloudServerException, IllegalBlockSizeException, IOException {
        HttpGet httpGet = new HttpGet(str);
        httpGet.setHeader(header);
        httpGet.setHeader("Accept-Encoding", "gzip");
        if (i > 0) {
            httpGet.setHeader(CloudUtils.X_XIAOMI_REDIRECT_COUNT, i + "");
        }
        httpGet.setHeader(CloudUtils.X_XIAOMI_SUPPORT_REDIRECT, a.c);
        if (Log.isLoggable(MICLOUD_TAG, 3)) {
            Log.d(MICLOUD_TAG, "http get url : " + str);
            Log.d(MICLOUD_TAG, "http get cookies : " + header.toString());
        }
        HttpResponse httpResponseExecute = NetworkUtils.getHttpClient().execute(httpGet);
        int statusCode = httpResponseExecute.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            String strDecodeData = NetworkUtils.decodeData(str2, decodeGZip(httpResponseExecute));
            String strCheckRedirect = CloudUtils.checkRedirect(strDecodeData, i);
            return !TextUtils.isEmpty(strCheckRedirect) ? httpGetRequest(strCheckRedirect, header, str2, i + 1) : strDecodeData;
        }
        if (CloudServerException.isMiCloudServerException(statusCode)) {
            Log.e(MICLOUD_TAG, "MiCloudServerException: " + statusCode + " " + httpResponseExecute.getStatusLine());
            throw new CloudServerException(statusCode, httpResponseExecute);
        }
        Log.e(MICLOUD_TAG, "Server error: " + statusCode + " " + httpResponseExecute.getStatusLine());
        throw new IOException("Server error: " + statusCode + " " + httpResponseExecute.getStatusLine());
    }

    public static String httpGetRequestWithDecodeData(String str, Header header, String str2) throws BadPaddingException, CloudServerException, IllegalBlockSizeException, IOException {
        String strHttpGetRequest = httpGetRequest(str, header, str2, 0);
        if (Log.isLoggable(MICLOUD_TAG, 3)) {
            Log.d(MICLOUD_TAG, strHttpGetRequest);
        }
        return strHttpGetRequest;
    }

    private static String httpPostRequest(String str, HttpEntity httpEntity, Header header, String str2, int i) throws BadPaddingException, CloudServerException, IllegalBlockSizeException, IOException {
        HttpPost httpPost = new HttpPost(str);
        if (httpEntity != null) {
            httpPost.setHeader(httpEntity.getContentType());
            httpPost.setEntity(httpEntity);
        }
        if (header != null) {
            httpPost.setHeader(header);
        }
        httpPost.setHeader("Accept-Encoding", "gzip");
        if (i > 0) {
            httpPost.setHeader(CloudUtils.X_XIAOMI_REDIRECT_COUNT, i + "");
        }
        httpPost.setHeader(CloudUtils.X_XIAOMI_SUPPORT_REDIRECT, a.c);
        if (Log.isLoggable(MICLOUD_TAG, 3)) {
            Log.d(MICLOUD_TAG, "http post url : " + str);
            Log.d(MICLOUD_TAG, "http post cookies : " + header.toString());
        }
        HttpResponse httpResponseExecute = NetworkUtils.getHttpClient().execute(httpPost);
        int statusCode = httpResponseExecute.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            String strDecodeData = NetworkUtils.decodeData(str2, decodeGZip(httpResponseExecute));
            String strCheckRedirect = CloudUtils.checkRedirect(strDecodeData, i);
            return !TextUtils.isEmpty(strCheckRedirect) ? httpPostRequest(strCheckRedirect, httpEntity, header, str2, i + 1) : strDecodeData;
        }
        if (CloudServerException.isMiCloudServerException(statusCode)) {
            Log.e(MICLOUD_TAG, "MiCloudServerException: " + statusCode + " " + httpResponseExecute.getStatusLine());
            throw new CloudServerException(statusCode, httpResponseExecute);
        }
        Log.e(MICLOUD_TAG, "Server error: " + statusCode + " " + httpResponseExecute.getStatusLine());
        throw new IOException("Server error: " + statusCode + " " + httpResponseExecute.getStatusLine());
    }

    public static String httpPostRequestWithDecodeData(String str, HttpEntity httpEntity, Header header, String str2) throws BadPaddingException, CloudServerException, IllegalBlockSizeException, IOException {
        String strHttpPostRequest = httpPostRequest(str, httpEntity, header, str2, 0);
        if (Log.isLoggable(MICLOUD_TAG, 3)) {
            Log.d(MICLOUD_TAG, strHttpPostRequest);
        }
        return strHttpPostRequest;
    }
}
