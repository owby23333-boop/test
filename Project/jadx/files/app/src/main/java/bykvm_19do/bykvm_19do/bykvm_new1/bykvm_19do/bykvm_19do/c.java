package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_19do;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.m;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i;
import com.taobao.accs.common.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static volatile boolean f1927f = true;
    private a a;
    private final Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long f1928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f1929d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SharedPreferences f1930e;

    public c(Context context) {
        if (context == null || !(context instanceof Application)) {
            throw new IllegalArgumentException("context must not be null or not application");
        }
        this.b = context;
        this.f1930e = this.b.getSharedPreferences("anr_monitor_table", 0);
        this.f1928c = this.f1930e.getLong("trace_anr_happen_time", 0L);
        g.a(100, 100);
    }

    private String a(BufferedReader bufferedReader) throws IOException {
        if (bufferedReader == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null || line.trim().length() <= 0) {
                break;
            }
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString();
    }

    private static void a(String str) {
        Iterator<bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.f> it = i.d().a().iterator();
        while (it.hasNext()) {
            it.next().a(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c.ANR, str, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0020, code lost:
    
        r0 = new java.lang.Object[2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
    
        r0[0] = r5;
        r0[1] = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object[] a(java.io.BufferedReader r8, java.util.regex.Pattern... r9) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L2c
            if (r9 == 0) goto L2c
            int r1 = r9.length
            if (r1 > 0) goto L9
            goto L2c
        L9:
            java.lang.String r1 = r8.readLine()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L2c
            int r2 = r9.length     // Catch: java.lang.Throwable -> L2c
            r3 = 0
            r4 = 0
        L12:
            if (r4 >= r2) goto L9
            r5 = r9[r4]
            java.util.regex.Matcher r6 = r5.matcher(r1)     // Catch: java.lang.Throwable -> L2c
            boolean r6 = r6.matches()     // Catch: java.lang.Throwable -> L2c
            if (r6 == 0) goto L29
            r8 = 2
            java.lang.Object[] r0 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> L2c
            r0[r3] = r5
            r8 = 1
            r0[r8] = r1
            goto L2c
        L29:
            int r4 = r4 + 1
            goto L12
        L2c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_19do.c.a(java.io.BufferedReader, java.util.regex.Pattern[]):java.lang.Object[]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    public JSONObject a(String str, int i2, String str2) throws Throwable {
        BufferedReader bufferedReader;
        int i3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        ?? CanRead = file.canRead();
        try {
            if (CanRead == 0) {
                return null;
            }
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (Exception e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                CanRead = 0;
                bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.f.a(CanRead);
                throw th;
            }
            try {
                Pattern patternCompile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                Pattern patternCompile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                Pattern patternCompile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                Pattern patternCompile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                boolean z2 = false;
                Object[] objArrA = a(bufferedReader, patternCompile);
                if (objArrA != null) {
                    long j2 = Long.parseLong(objArrA[1].toString().split("\\s")[2]);
                    long time = simpleDateFormat.parse(objArrA[1].toString().split("\\s")[4] + " " + objArrA[1].toString().split("\\s")[5]).getTime();
                    Object[] objArrA2 = a(bufferedReader, patternCompile3);
                    if (objArrA2 != null) {
                        String str3 = objArrA2[1].toString().split("\\s")[2];
                        if (j2 == i2 && str3.equalsIgnoreCase(str2) && (this.f1928c == 0 || Math.abs(this.f1928c - time) >= 20000)) {
                            this.f1928c = time;
                            if (this.f1930e != null) {
                                this.f1930e.edit().putLong("trace_anr_happen_time", this.f1928c).apply();
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("anrTime", time);
                            while (true) {
                                Object[] objArrA3 = a(bufferedReader, patternCompile2, patternCompile4);
                                if (objArrA3 != null && objArrA3[0] == patternCompile4) {
                                    Matcher matcher = Pattern.compile("\".+\"").matcher(objArrA3[1].toString());
                                    String strSubstring = matcher.find() ? matcher.group().substring(1, matcher.group().length() - 1) : "";
                                    Matcher matcher2 = Pattern.compile("tid=\\d+").matcher(objArrA3[1].toString());
                                    if (matcher2.find()) {
                                        String strGroup = matcher2.group();
                                        i3 = Integer.parseInt(strGroup.substring(strGroup.indexOf("=") + 1));
                                    } else {
                                        i3 = -1;
                                    }
                                    String strA = a(bufferedReader);
                                    if (i3 != -1 && !TextUtils.isEmpty(strSubstring) && !TextUtils.isEmpty(strA) && strSubstring.equalsIgnoreCase("main")) {
                                        jSONObject.put("mainStackFromTrace", strA);
                                        z2 = true;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            if (z2) {
                                jSONObject.put("thread_number", 1);
                                bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.f.a(bufferedReader);
                                return jSONObject;
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
            }
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.f.a(bufferedReader);
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void a() {
        if (this.f1929d) {
            return;
        }
        if (Build.VERSION.SDK_INT < 21) {
            this.a = new a(this, "/data/anr/", 8);
            this.a.startWatching();
        } else {
            new d(this);
        }
        this.f1929d = true;
    }

    boolean a(int i2, String str, int i3) {
        JSONObject jSONObjectA;
        JSONObject jSONObjectA2;
        JSONArray jSONArrayQ = g.q();
        long jUptimeMillis = SystemClock.uptimeMillis();
        JSONObject jSONObjectC = g.c(jUptimeMillis);
        JSONArray jSONArrayA = g.a(100, jUptimeMillis);
        try {
            jSONObjectA = e.a(f1927f);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONObjectA = null;
        }
        String strA = e.a(this.b, i3);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        if (i2 != 200 || (jSONObjectA2 = a(str, Process.myPid(), this.b.getPackageName())) == null || jSONObjectA2.length() <= 0) {
            jSONObjectA2 = jSONObjectA;
        }
        if (jSONObjectA2 == null || jSONObjectA2.length() <= 0) {
            return true;
        }
        try {
            jSONObjectA2.put(com.anythink.expressad.d.a.b.aB, Process.myPid());
            jSONObjectA2.put(Constants.KEY_PACKAGE, this.b.getPackageName());
            jSONObjectA2.put("is_remote_process", 0);
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a aVar = new bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a(new JSONObject());
            aVar.a("data", jSONObjectA2.toString());
            aVar.a("is_anr", (Object) 1);
            aVar.a("timestamp", Long.valueOf(System.currentTimeMillis()));
            aVar.a("event_type", "anr");
            aVar.a("history_message", jSONArrayQ);
            aVar.a("current_message", jSONObjectC);
            aVar.a("pending_messages", jSONArrayA);
            aVar.a("anr_time", Long.valueOf(System.currentTimeMillis()));
            aVar.a("crash_time", Long.valueOf(System.currentTimeMillis()));
            aVar.a("anr_info", strA);
            aVar.a("all_thread_stacks", m.a((String) null));
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a aVarA = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.bykvm_19do.e.a().a(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c.ANR, aVar);
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.d.a(this.b, bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c.ANR.a(), (String) null);
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.a.a().b(aVarA.a());
            a(strA);
            return true;
        } catch (Throwable th) {
            j.b(th);
            return true;
        }
    }
}
