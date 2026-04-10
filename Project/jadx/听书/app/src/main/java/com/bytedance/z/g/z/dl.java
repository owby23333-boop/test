package com.bytedance.z.g.z;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.z.g.gz;
import com.bytedance.z.g.gz.uy;
import com.uc.crashsdk.export.LogType;
import com.umeng.umcrash.UMCrash;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    static volatile boolean z = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1523a;
    private a dl;
    private final SharedPreferences e;
    private z g;
    private volatile long gc;
    private volatile boolean m = false;

    public dl(Context context) {
        if (context == null || !(context instanceof Application)) {
            throw new IllegalArgumentException("context must not be null or not application");
        }
        this.f1523a = context;
        SharedPreferences sharedPreferencesG = com.bytedance.sdk.openadsdk.api.plugin.g.g(context, "anr_monitor_table", 0);
        this.e = sharedPreferencesG;
        this.gc = sharedPreferencesG.getLong("trace_anr_happen_time", 0L);
    }

    public void z() {
        if (this.m) {
            return;
        }
        this.dl = new a(this);
        this.m = true;
    }

    boolean z(int i, String str, int i2) {
        JSONObject jSONObjectZ;
        JSONObject jSONObjectZ2;
        try {
            jSONObjectZ = gc.z(z);
        } catch (Throwable th) {
            wp.z(th);
            jSONObjectZ = null;
        }
        String strZ = gc.z(this.f1523a, i2);
        if (TextUtils.isEmpty(strZ)) {
            return false;
        }
        try {
            com.bytedance.z.g.m mVarA = gz.g().a();
            if (mVarA != null) {
                if (mVarA.z()) {
                    if (i == 200 && (jSONObjectZ2 = z(str, Process.myPid(), this.f1523a.getPackageName())) != null && jSONObjectZ2.length() > 0) {
                        jSONObjectZ = jSONObjectZ2;
                    }
                    if (jSONObjectZ != null && jSONObjectZ.length() > 0) {
                        try {
                            jSONObjectZ.put("pid", Process.myPid());
                            jSONObjectZ.put("package", this.f1523a.getPackageName());
                            jSONObjectZ.put("is_remote_process", 0);
                            com.bytedance.z.g.dl.z zVar = new com.bytedance.z.g.dl.z(new JSONObject());
                            zVar.z("data", jSONObjectZ.toString());
                            zVar.z("is_anr", (Object) 1);
                            zVar.z(UMCrash.SP_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
                            zVar.z("event_type", LogType.ANR_TYPE);
                            zVar.z("anr_time", Long.valueOf(System.currentTimeMillis()));
                            zVar.z("crash_time", Long.valueOf(System.currentTimeMillis()));
                            zVar.z("anr_info", strZ);
                            com.bytedance.z.g.dl.z zVarZ = com.bytedance.z.g.gc.z.gc.z().z(com.bytedance.z.g.dl.ANR, zVar);
                            com.bytedance.z.g.gz.a.z(this.f1523a, com.bytedance.z.g.dl.ANR.z(), (String) null);
                            com.bytedance.z.g.e.z.z().g(zVarZ.z());
                            z(strZ);
                        } catch (Throwable th2) {
                            uy.g(th2);
                        }
                    }
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static void z(String str) {
        Iterator<Object> it = gz.g().dl().iterator();
        while (it.hasNext()) {
            it.next();
            com.bytedance.z.g.dl dlVar = com.bytedance.z.g.dl.ANR;
        }
    }

    public JSONObject z(String str, int i, String str2) throws Throwable {
        BufferedReader bufferedReader;
        int i2;
        BufferedReader bufferedReader2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.canRead()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (Exception e) {
            e = e;
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                Pattern patternCompile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                Pattern patternCompile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                Pattern patternCompile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                Pattern patternCompile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                boolean z2 = false;
                Object[] objArrZ = z(bufferedReader, patternCompile);
                if (objArrZ == null) {
                    com.bytedance.z.g.gz.m.z(bufferedReader);
                    return null;
                }
                long j = Long.parseLong(objArrZ[1].toString().split("\\s")[2]);
                long time = simpleDateFormat.parse(objArrZ[1].toString().split("\\s")[4] + " " + objArrZ[1].toString().split("\\s")[5]).getTime();
                Object[] objArrZ2 = z(bufferedReader, patternCompile3);
                if (objArrZ2 == null) {
                    com.bytedance.z.g.gz.m.z(bufferedReader);
                    return null;
                }
                String str3 = objArrZ2[1].toString().split("\\s")[2];
                if (j == i && str3.equalsIgnoreCase(str2)) {
                    if (this.gc != 0 && Math.abs(this.gc - time) < 20000) {
                        com.bytedance.z.g.gz.m.z(bufferedReader);
                        return null;
                    }
                    this.gc = time;
                    SharedPreferences sharedPreferences = this.e;
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putLong("trace_anr_happen_time", this.gc).apply();
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("anrTime", time);
                    while (true) {
                        Object[] objArrZ3 = z(bufferedReader, patternCompile2, patternCompile4);
                        if (objArrZ3 != null && objArrZ3[0] == patternCompile4) {
                            Matcher matcher = Pattern.compile("\".+\"").matcher(objArrZ3[1].toString());
                            String strSubstring = matcher.find() ? matcher.group().substring(1, matcher.group().length() - 1) : "";
                            Matcher matcher2 = Pattern.compile("tid=\\d+").matcher(objArrZ3[1].toString());
                            if (matcher2.find()) {
                                String strGroup = matcher2.group();
                                i2 = Integer.parseInt(strGroup.substring(strGroup.indexOf("=") + 1));
                            } else {
                                i2 = -1;
                            }
                            String strZ = z(bufferedReader);
                            if (i2 != -1 && !TextUtils.isEmpty(strSubstring) && !TextUtils.isEmpty(strZ) && strSubstring.equalsIgnoreCase("main")) {
                                jSONObject.put("mainStackFromTrace", strZ);
                                z2 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!z2) {
                        com.bytedance.z.g.gz.m.z(bufferedReader);
                        return null;
                    }
                    jSONObject.put("thread_number", 1);
                    com.bytedance.z.g.gz.m.z(bufferedReader);
                    return jSONObject;
                }
                com.bytedance.z.g.gz.m.z(bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
            }
        } catch (Exception e2) {
            e = e2;
            wp.z(e);
            com.bytedance.z.g.gz.m.z(bufferedReader);
            return null;
        }
        th = th2;
        bufferedReader2 = bufferedReader;
        com.bytedance.z.g.gz.m.z(bufferedReader2);
        throw th;
    }

    private Object[] z(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader != null && patternArr != null && patternArr.length > 0) {
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    for (Pattern pattern : patternArr) {
                        if (pattern.matcher(line).matches()) {
                            return new Object[]{pattern, line};
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }

    private String z(BufferedReader bufferedReader) throws IOException {
        if (bufferedReader == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null || line.trim().length() <= 0) {
                break;
            }
            sb.append(line).append("\n");
        }
        return sb.toString();
    }
}
