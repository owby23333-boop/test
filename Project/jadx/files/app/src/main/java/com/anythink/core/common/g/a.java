package com.anythink.core.common.g;

import android.content.Context;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    private static final String a = "http.loader";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected i f7435m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected boolean f7436n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected String f7437o;

    /* JADX INFO: renamed from: com.anythink.core.common.g.a$1, reason: invalid class name */
    final class AnonymousClass1 extends com.anythink.core.common.k.b.b {
        final /* synthetic */ int a;

        AnonymousClass1(int i2) {
            this.a = i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r10v1 */
        /* JADX WARN: Type inference failed for: r10v2, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v11, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v26 */
        /* JADX WARN: Type inference failed for: r1v44 */
        /* JADX WARN: Type inference failed for: r1v63 */
        /* JADX WARN: Type inference failed for: r1v64 */
        /* JADX WARN: Type inference failed for: r1v65 */
        /* JADX WARN: Type inference failed for: r1v66 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private void b(String str) throws Throwable {
            SocketTimeoutException e2;
            HttpURLConnection httpURLConnection;
            StackOverflowError e3;
            OutOfMemoryError e4;
            Exception e5;
            UnknownHostException e6;
            ConnectException e7;
            Error e8;
            int iA;
            byte[] bArrD;
            ?? r1 = 0;
            r1 = 0;
            try {
            } catch (Throwable th) {
                th = th;
                str = r1;
            }
            try {
                try {
                    a.this.f7437o = str;
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                } catch (Error e9) {
                    e8 = e9;
                    httpURLConnection = null;
                } catch (ConnectException e10) {
                    e7 = e10;
                    httpURLConnection = null;
                } catch (UnknownHostException e11) {
                    e6 = e11;
                    httpURLConnection = null;
                } catch (ConnectTimeoutException e12) {
                    e = e12;
                } catch (Exception e13) {
                    e5 = e13;
                    httpURLConnection = null;
                } catch (OutOfMemoryError e14) {
                    e4 = e14;
                    httpURLConnection = null;
                } catch (StackOverflowError e15) {
                    e3 = e15;
                    httpURLConnection = null;
                } catch (SocketTimeoutException e16) {
                    e2 = e16;
                    httpURLConnection = null;
                }
                try {
                    iA = a.this.a();
                    if (iA != 1 && iA != 2) {
                        iA = 2;
                    }
                    if (iA == 1) {
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setUseCaches(false);
                    }
                    if (iA == 2) {
                        httpURLConnection.setInstanceFollowRedirects(false);
                    }
                    Map<String, String> mapC = a.this.c();
                    if (mapC != null && mapC.size() > 0) {
                        for (String str2 : mapC.keySet()) {
                            httpURLConnection.addRequestProperty(str2, mapC.get(str2));
                        }
                    }
                } catch (OutOfMemoryError e17) {
                    e4 = e17;
                    System.gc();
                    String message = e4.getMessage();
                    if (e4.getMessage() != null) {
                        message = e4.getMessage();
                    }
                    a.this.a(this.a, g.f7500e, message, ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e4.getMessage()));
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                } catch (StackOverflowError e18) {
                    e3 = e18;
                    System.gc();
                    String message2 = e3.getMessage();
                    if (e3.getMessage() != null) {
                        message2 = e3.getMessage();
                    }
                    a.this.a(this.a, g.f7501f, message2, ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e3.getMessage()));
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                } catch (Error e19) {
                    e8 = e19;
                    System.gc();
                    String message3 = e8.getMessage();
                    if (e8.getMessage() != null) {
                        message3 = e8.getMessage();
                    }
                    a.this.a(this.a, g.f7503h, message3, ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e8.getMessage()));
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                } catch (ConnectException e20) {
                    e7 = e20;
                    a.this.a(ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e7.getMessage()));
                    a.this.a(this.a, g.b, "Connect error.", ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e7.getMessage()));
                    new StringBuilder("http connect error! ").append(e7.toString());
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                } catch (SocketTimeoutException e21) {
                    e2 = e21;
                    a.this.a(this.a, g.f7498c, "Connect timeout.", ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e2.getMessage()));
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                } catch (UnknownHostException e22) {
                    e6 = e22;
                    a.this.a(ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e6.getMessage()));
                    a.this.a(this.a, -1000, "UnknownHostException", ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e6.getMessage()));
                    new StringBuilder("UnknownHostException ").append(e6.toString());
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                } catch (ConnectTimeoutException e23) {
                    e = e23;
                    r1 = httpURLConnection;
                    a.this.a(this.a, e);
                    if (r1 != 0) {
                        r1.disconnect();
                        return;
                    }
                } catch (Exception e24) {
                    e5 = e24;
                    String message4 = e5.getMessage();
                    if (e5.getMessage() != null) {
                        message4 = e5.getMessage();
                    }
                    a.this.a(this.a, g.f7502g, message4, ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e5.getMessage()));
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                }
                if (a.this.f7436n) {
                    a.this.c(this.a);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                }
                if (n.a().c("ua")) {
                    httpURLConnection.addRequestProperty("User-Agent", com.anythink.core.common.k.g.a());
                }
                httpURLConnection.setConnectTimeout(BaseConstants.Time.MINUTE);
                httpURLConnection.setReadTimeout(BaseConstants.Time.MINUTE);
                httpURLConnection.connect();
                if (iA == 1 && (bArrD = a.this.d()) != null) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(bArrD);
                    outputStream.flush();
                    outputStream.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (!a.this.a(responseCode) && responseCode != 200) {
                    if (responseCode != 302 && responseCode != 301 && responseCode != 307) {
                        a.this.a(this.a, responseCode, "Http respond status code is ".concat(String.valueOf(responseCode)), ErrorCode.getErrorCode(ErrorCode.httpStatuException, String.valueOf(responseCode), httpURLConnection.getResponseMessage()));
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            return;
                        }
                        return;
                    }
                    if (a.this.f7436n) {
                        a.this.c(this.a);
                    } else {
                        String headerField = httpURLConnection.getHeaderField("Location");
                        if (headerField != null && headerField.toLowerCase().startsWith("http")) {
                            b(headerField);
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                }
                if (a.this.f7436n) {
                    a.this.c(this.a);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                }
                InputStream inputStreamA = a.a(httpURLConnection);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStreamA);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    } else {
                        sb.append(line);
                    }
                }
                bufferedReader.close();
                inputStreamReader.close();
                if (inputStreamA != null) {
                    inputStreamA.close();
                }
                if (a.this.n()) {
                    String strTrim = sb.toString().trim();
                    JSONObject jSONObject = new JSONObject(strTrim);
                    int iOptInt = jSONObject.optInt("code");
                    if (iOptInt == 0) {
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(g.c.f6826d);
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectOptJSONObject = new JSONObject();
                        }
                        String string = jSONObjectOptJSONObject.toString();
                        a aVar = a.this;
                        httpURLConnection.getHeaderFields();
                        Object objA = aVar.a(string);
                        a.this.a(this.a, objA);
                        r1 = objA;
                    } else {
                        a.this.a(this.a, g.f7504i, strTrim, ErrorCode.getErrorCode(ErrorCode.statuError, String.valueOf(iOptInt), strTrim));
                        r1 = strTrim;
                    }
                } else {
                    a aVar2 = a.this;
                    httpURLConnection.getHeaderFields();
                    Object objA2 = aVar2.a(sb.toString());
                    a.this.a(this.a, objA2);
                    r1 = objA2;
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th2) {
                th = th2;
                if (str != 0) {
                    str.disconnect();
                }
                throw th;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        @Override // com.anythink.core.common.k.b.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a() throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.String r0 = "9999"
                com.anythink.core.common.g.a r1 = com.anythink.core.common.g.a.this     // Catch: java.lang.Exception -> L1b java.lang.StackOverflowError -> L3e java.lang.OutOfMemoryError -> L40
                com.anythink.core.common.g.i r1 = r1.f7435m     // Catch: java.lang.Exception -> L1b java.lang.StackOverflowError -> L3e java.lang.OutOfMemoryError -> L40
                if (r1 == 0) goto L11
                com.anythink.core.common.g.a r1 = com.anythink.core.common.g.a.this     // Catch: java.lang.Exception -> L1b java.lang.StackOverflowError -> L3e java.lang.OutOfMemoryError -> L40
                com.anythink.core.common.g.i r1 = r1.f7435m     // Catch: java.lang.Exception -> L1b java.lang.StackOverflowError -> L3e java.lang.OutOfMemoryError -> L40
                int r2 = r5.a     // Catch: java.lang.Exception -> L1b java.lang.StackOverflowError -> L3e java.lang.OutOfMemoryError -> L40
                r1.onLoadStart(r2)     // Catch: java.lang.Exception -> L1b java.lang.StackOverflowError -> L3e java.lang.OutOfMemoryError -> L40
            L11:
                com.anythink.core.common.g.a r1 = com.anythink.core.common.g.a.this     // Catch: java.lang.Exception -> L1b java.lang.StackOverflowError -> L3e java.lang.OutOfMemoryError -> L40
                java.lang.String r1 = r1.b()     // Catch: java.lang.Exception -> L1b java.lang.StackOverflowError -> L3e java.lang.OutOfMemoryError -> L40
                r5.b(r1)     // Catch: java.lang.Exception -> L1b java.lang.StackOverflowError -> L3e java.lang.OutOfMemoryError -> L40
                return
            L1b:
                r1 = move-exception
                java.lang.String r2 = r1.getMessage()
                java.lang.String r3 = r1.getMessage()
                if (r3 == 0) goto L2a
                java.lang.String r2 = r1.getMessage()
            L2a:
                com.anythink.core.common.g.a r3 = com.anythink.core.common.g.a.this
                com.anythink.core.common.g.i r3 = r3.f7435m
                if (r3 == 0) goto L3d
                int r4 = r5.a
                java.lang.String r1 = r1.getMessage()
                com.anythink.core.api.AdError r0 = com.anythink.core.api.ErrorCode.getErrorCode(r0, r0, r1)
                r3.onLoadError(r4, r2, r0)
            L3d:
                return
            L3e:
                r1 = move-exception
                goto L41
            L40:
                r1 = move-exception
            L41:
                java.lang.System.gc()
                java.lang.String r2 = r1.getMessage()
                java.lang.String r3 = r1.getMessage()
                if (r3 == 0) goto L52
                java.lang.String r2 = r1.getMessage()
            L52:
                com.anythink.core.common.g.a r3 = com.anythink.core.common.g.a.this
                com.anythink.core.common.g.i r3 = r3.f7435m
                if (r3 == 0) goto L65
                int r4 = r5.a
                java.lang.String r1 = r1.getMessage()
                com.anythink.core.api.AdError r0 = com.anythink.core.api.ErrorCode.getErrorCode(r0, r0, r1)
                r3.onLoadError(r4, r2, r0)
            L65:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.g.a.AnonymousClass1.a():void");
        }
    }

    private void d(int i2) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(i2);
        if (o()) {
            com.anythink.core.common.k.b.a.a().a((com.anythink.core.common.k.b.b) anonymousClass1, 1);
        } else {
            com.anythink.core.common.k.b.a.a().a((com.anythink.core.common.k.b.b) anonymousClass1, 2);
        }
    }

    private void p() {
        this.f7436n = true;
    }

    protected abstract int a();

    protected abstract Object a(String str);

    public void a(int i2, i iVar) {
        this.f7436n = false;
        this.f7435m = iVar;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(i2);
        if (o()) {
            com.anythink.core.common.k.b.a.a().a((com.anythink.core.common.k.b.b) anonymousClass1, 1);
        } else {
            com.anythink.core.common.k.b.a.a().a((com.anythink.core.common.k.b.b) anonymousClass1, 2);
        }
    }

    protected abstract void a(AdError adError);

    protected abstract boolean a(int i2);

    protected abstract String b();

    protected void b(int i2) {
    }

    protected abstract void b(AdError adError);

    protected abstract Map<String, String> c();

    protected final void c(int i2) {
        i iVar = this.f7435m;
        if (iVar != null) {
            iVar.onLoadCanceled(i2);
        }
    }

    protected abstract byte[] d();

    protected JSONObject e() {
        return c.a(m());
    }

    protected JSONObject f() {
        return c.a();
    }

    protected String g() {
        HashMap map = new HashMap();
        String strA = com.anythink.core.common.k.c.a(e().toString());
        String strA2 = com.anythink.core.common.k.c.a(f().toString());
        map.put(c.O, "1.0");
        map.put("p", strA);
        map.put(c.X, strA2);
        ArrayList<String> arrayList = new ArrayList(map.size());
        arrayList.addAll(map.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            if (sb.length() > 0) {
                sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            }
            sb.append(str);
            sb.append("=");
            sb.append(map.get(str));
        }
        new StringBuilder(" sorted value list:").append(sb.toString());
        map.put("sign", com.anythink.core.common.k.f.c(j() + sb.toString()));
        if (l() != null) {
            map.putAll(l());
        }
        Set<String> setKeySet = map.keySet();
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str2 : setKeySet) {
                jSONObject.put(str2, String.valueOf(map.get(str2)));
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        } catch (OutOfMemoryError unused2) {
            System.gc();
            return null;
        }
    }

    protected abstract String h();

    protected abstract Context i();

    protected abstract String j();

    protected abstract String k();

    protected abstract Map<String, Object> l();

    protected int m() {
        return 0;
    }

    protected boolean n() {
        return false;
    }

    protected boolean o() {
        return false;
    }

    protected static byte[] c(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes(com.anythink.expressad.foundation.g.a.bN));
            gZIPOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    protected final void a(int i2, ConnectTimeoutException connectTimeoutException) {
        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, connectTimeoutException.getMessage());
        i iVar = this.f7435m;
        if (iVar != null) {
            iVar.onLoadError(i2, "Connect timeout.", errorCode);
        }
        b(errorCode);
        b(g.b);
    }

    protected final void a(int i2, int i3, String str, AdError adError) {
        i iVar = this.f7435m;
        if (iVar != null) {
            iVar.onLoadError(i2, str, adError);
        }
        b(adError);
        b(i3);
    }

    protected void a(int i2, Object obj) {
        i iVar = this.f7435m;
        if (iVar != null) {
            iVar.onLoadFinish(i2, obj);
        }
    }

    public static InputStream a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (Exception unused) {
        }
        if (!"gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"))) {
            return inputStream;
        }
        try {
            byte[] bArr = new byte[2];
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedInputStream.mark(2);
            int i2 = bufferedInputStream.read(bArr);
            bufferedInputStream.reset();
            return (i2 == -1 || (((bArr[1] & 255) << 8) | (bArr[0] & 255)) != 35615) ? bufferedInputStream : new GZIPInputStream(bufferedInputStream);
        } catch (Exception unused2) {
            return inputStream;
        }
    }
}
