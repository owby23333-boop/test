package g;

import android.os.AsyncTask;
import androidx.annotation.NonNull;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: C0014b.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public String a = null;
    public a b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f20808c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f20809d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, String> f20810e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, String> f20811f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f20812g = "GET";

    /* JADX INFO: compiled from: C0014b.java */
    public interface a {
    }

    /* JADX INFO: compiled from: C0014b.java */
    public class b {
        public b(c cVar, String str, Exception exc, int i2) {
        }
    }

    /* JADX INFO: renamed from: g.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: C0014b.java */
    public class AsyncTaskC0563c extends AsyncTask<Void, Void, b> {
        public c a;

        public AsyncTaskC0563c() {
            this.a = c.this;
        }

        @Override // android.os.AsyncTask
        public b doInBackground(Void[] voidArr) {
            String string;
            String str;
            StringBuilder sb;
            if (this.a.f20812g.equalsIgnoreCase("GET")) {
                c cVar = c.this;
                cVar.getClass();
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(cVar.a()).openConnection();
                    if (httpURLConnection != null) {
                        httpURLConnection.setConnectTimeout(20000);
                        httpURLConnection.setReadTimeout(10000);
                    }
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("User-Agent", g.a.a());
                    for (String str2 : cVar.f20809d.keySet()) {
                        if (!str2.isEmpty()) {
                            httpURLConnection.setRequestProperty(str2, cVar.f20809d.get(str2));
                        }
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    System.out.println("\nSending 'GET' request to URL : " + cVar.a);
                    System.out.println("Response Code : " + responseCode);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            bufferedReader.close();
                            return new b(cVar, sb2.toString(), null, responseCode);
                        }
                        sb2.append(line);
                    }
                } catch (Exception e2) {
                    return new b(cVar, null, e2, -1);
                }
            } else {
                c cVar2 = c.this;
                cVar2.getClass();
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(cVar2.a()).openConnection();
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.setConnectTimeout(20000);
                        httpURLConnection2.setReadTimeout(10000);
                    }
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setRequestProperty("User-Agent", g.a.a());
                    httpURLConnection2.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                    StringBuilder sb3 = new StringBuilder("");
                    if (cVar2.f20810e.isEmpty()) {
                        Object obj = cVar2.f20808c;
                        if (obj != null) {
                            if ((obj instanceof JSONObject) || (obj instanceof JSONArray)) {
                                string = obj.toString();
                            } else if (obj instanceof String) {
                                string = (String) obj;
                            } else {
                                sb = null;
                                str = null;
                                sb.append(str);
                            }
                            str = string;
                            sb = sb3;
                            sb.append(str);
                        }
                    } else {
                        for (String str3 : cVar2.f20810e.keySet()) {
                            sb3.append(str3);
                            sb3.append("=");
                            sb3.append(URLEncoder.encode(cVar2.f20810e.get(str3), "UTF-8"));
                            sb3.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
                        }
                    }
                    for (String str4 : cVar2.f20809d.keySet()) {
                        if (!str4.isEmpty()) {
                            httpURLConnection2.setRequestProperty(str4, cVar2.f20809d.get(str4));
                        }
                    }
                    String string2 = sb3.toString();
                    httpURLConnection2.setDoOutput(true);
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                    dataOutputStream.writeBytes(string2);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    int responseCode2 = httpURLConnection2.getResponseCode();
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream()));
                    StringBuilder sb4 = new StringBuilder();
                    while (true) {
                        String line2 = bufferedReader2.readLine();
                        if (line2 == null) {
                            bufferedReader2.close();
                            String string3 = sb4.toString();
                            c.a("\nPOST RESPONSE : " + string3);
                            return new b(cVar2, string3, null, responseCode2);
                        }
                        sb4.append(line2);
                    }
                } catch (Exception e3) {
                    return new b(cVar2, null, e3, -1);
                }
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(b bVar) {
            b bVar2 = bVar;
            super.onPostExecute(bVar2);
            if (c.this.b != null && bVar2 == null) {
                new Exception("Unknown Error");
            }
        }
    }

    public static void a(@NonNull String str) {
        v.c.a(c.class.getSimpleName(), str);
    }

    public final String a() {
        if (this.a == null) {
            throw new NullPointerException("URL IS NULL");
        }
        StringBuilder sb = new StringBuilder("");
        try {
            if (this.a.trim().endsWith("?")) {
                sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            } else {
                sb.append("?");
            }
            for (String str : this.f20811f.keySet()) {
                if (!str.isEmpty()) {
                    sb.append(str.trim());
                    sb.append("=");
                    sb.append(URLEncoder.encode(this.f20811f.get(str), "UTF-8"));
                    sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
                }
            }
        } catch (Exception unused) {
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.a);
        sb2.append(sb.toString().contains(DispatchConstants.SIGN_SPLIT_SYMBOL) ? sb.substring(0, sb.lastIndexOf(DispatchConstants.SIGN_SPLIT_SYMBOL)) : sb.toString());
        return sb2.toString();
    }
}
