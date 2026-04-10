package com.kuaishou.weapon.p0;

import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class di {
    private static String b(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            ArrayList arrayList = new ArrayList();
            do {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (line.contains("TCP") && !line.contains(":443")) {
                    arrayList.add(line);
                }
            } while (arrayList.size() <= 5);
            bufferedReader.close();
            if (arrayList.size() > 0) {
                return arrayList.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a() {
        try {
            return b(String.format(" lsof -p %1$s ", Integer.valueOf(Process.myPid())));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b() throws Throwable {
        try {
            String strA = a(" pidof adbd ");
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            return strA.length() > 10 ? strA.substring(0, 10) : strA;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            String line = bufferedReader.readLine();
            String str2 = line != null ? "" + line : "";
            try {
                bufferedReader.close();
            } catch (Exception unused2) {
            }
            return str2;
        } catch (Exception unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused4) {
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|40|3|(6:42|4|(3:6|(1:51)(3:47|12|52)|48)(1:44)|34|17|29)|13|(3:36|15|16)|34|17|29|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Set c() throws java.lang.Throwable {
        /*
            r0 = 0
            java.util.HashSet r1 = new java.util.HashSet     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            r1.<init>()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            java.lang.String r2 = " netstat -nap "
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            java.lang.Process r2 = r3.exec(r2)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
        L1e:
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5a
            if (r2 == 0) goto L40
            java.lang.String r4 = "tcp"
            boolean r4 = r2.contains(r4)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5a
            if (r4 == 0) goto L1e
            java.lang.String r4 = "ESTABLISHED"
            boolean r4 = r2.contains(r4)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5a
            if (r4 == 0) goto L1e
            java.lang.String r4 = ":5555 "
            boolean r4 = r2.contains(r4)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5a
            if (r4 == 0) goto L1e
            r1.add(r2)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5a
            goto L1e
        L40:
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5a
            if (r2 <= 0) goto L4a
            r3.close()     // Catch: java.lang.Exception -> L49
        L49:
            return r1
        L4a:
            r3.close()     // Catch: java.lang.Exception -> L5d
            goto L5d
        L4e:
            r0 = move-exception
            goto L53
        L50:
            r1 = move-exception
            r3 = r0
            r0 = r1
        L53:
            if (r3 == 0) goto L58
            r3.close()     // Catch: java.lang.Exception -> L58
        L58:
            throw r0
        L59:
            r3 = r0
        L5a:
            if (r3 == 0) goto L5d
            goto L4a
        L5d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.di.c():java.util.Set");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d() throws java.lang.Throwable {
        /*
            r0 = 0
            r1 = 0
            java.lang.String r2 = " netstat -apn | grep scrcpy "
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
            java.lang.Process r2 = r3.exec(r2)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
        L1a:
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L34
            if (r1 == 0) goto L2d
            java.lang.String r2 = "scrcpy"
            boolean r1 = r1.contains(r2)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L34
            if (r1 == 0) goto L1a
            r3.close()     // Catch: java.lang.Exception -> L2b
        L2b:
            r0 = 1
            return r0
        L2d:
            r3.close()     // Catch: java.lang.Exception -> L30
        L30:
            return r0
        L31:
            r0 = move-exception
            r1 = r3
            goto L37
        L34:
            r1 = r3
            goto L3d
        L36:
            r0 = move-exception
        L37:
            if (r1 == 0) goto L3c
            r1.close()     // Catch: java.lang.Exception -> L3c
        L3c:
            throw r0
        L3d:
            if (r1 == 0) goto L42
            r1.close()     // Catch: java.lang.Exception -> L42
        L42:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.di.d():int");
    }

    public static JSONObject e() throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(" netstat -an ").getInputStream()));
        } catch (Exception unused) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (line.contains("/") || line.contains("@")) {
                    if (line.contains("/")) {
                        line = line.substring(line.indexOf("/"));
                    } else if (line.contains("@")) {
                        line = line.substring(line.indexOf("@"));
                    }
                    if (line.contains("/ddy")) {
                        jSONObject.put("0", line);
                    } else if (line.contains("scrcpy")) {
                        jSONObject.put("1", line);
                    } else if (line.contains("supersu")) {
                        jSONObject.put("2", line);
                    } else if (line.contains("/adbd")) {
                        jSONObject.put("3", line);
                    }
                }
            }
            if (jSONObject.length() > 0) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                return jSONObject;
            }
            try {
                bufferedReader.close();
            } catch (Exception unused3) {
            }
            return null;
        } catch (Exception unused4) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception unused5) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused6) {
                }
            }
            throw th;
        }
    }
}
