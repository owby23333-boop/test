package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.yxcorp.kuaishou.addfp.android.b.g;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile d f20607d;
    private e a;
    private ConcurrentHashMap b = new ConcurrentHashMap(10);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f20608c;

    private d(Context context) {
        this.a = null;
        try {
            this.f20608c = context;
            this.a = new e(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static d a(Context context) {
        if (f20607d == null) {
            synchronized (d.class) {
                if (f20607d == null) {
                    f20607d = new d(context);
                }
            }
        }
        return f20607d;
    }

    private String a(HashMap map) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
            objectOutputStream = null;
        }
        try {
            objectOutputStream.writeObject(map);
            String str = new String(Base64.encode(com.yxcorp.kuaishou.addfp.android.b.b.c(byteArrayOutputStream.toByteArray(), "20212102sjcudiab".getBytes()), 0));
            try {
                objectOutputStream.close();
            } catch (IOException unused) {
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
            try {
                th.printStackTrace();
                if (objectOutputStream == null) {
                    return "";
                }
                try {
                    objectOutputStream.close();
                    return "";
                } catch (IOException unused2) {
                    return "";
                }
            } catch (Throwable th3) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th3;
            }
        }
    }

    public static void a(Context context, String str) {
        Throwable th;
        FileWriter fileWriter;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                File file = new File(com.yxcorp.kuaishou.addfp.android.b.b.a(context, false), new String(Base64.decode("Lm91a2R0ZnQ=", 0)));
                new File(file.getParent()).mkdirs();
                fileWriter = new FileWriter(file, false);
            } catch (Throwable th2) {
                th = th2;
                fileWriter = null;
            }
            try {
                fileWriter.write(str);
                fileWriter.flush();
                fileWriter.close();
                fileWriter.close();
            } catch (Throwable th3) {
                th = th3;
                try {
                    th.printStackTrace();
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                } catch (Throwable th4) {
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th4;
                }
            }
        } catch (IOException unused2) {
        }
    }

    public synchronized Pair a() {
        byte[] bArrDecode;
        try {
            if (this.b != null) {
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty((String) this.b.get("cache_e"))) {
                    return Pair.create(Pair.create(Boolean.TRUE, sb.toString()), this.b);
                }
            }
            this.b.clear();
            String strB = this.a.b();
            if (!TextUtils.isEmpty(strB)) {
                try {
                    bArrDecode = Base64.decode(strB, 0);
                } catch (Throwable unused) {
                    bArrDecode = null;
                }
                if (bArrDecode == null) {
                    try {
                        bArrDecode = Base64.decode(strB, 8);
                    } catch (Throwable unused2) {
                    }
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(com.yxcorp.kuaishou.addfp.android.b.b.b(bArrDecode, "20212102sjcudiab".getBytes())));
                    this.b.put("cache_e", jSONObject.optString("cache_e", ""));
                    this.b.put("cache_m", jSONObject.optString("cache_m", ""));
                    this.b.put("c_time", Long.toString(jSONObject.optLong("c_time", 0L)));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            ConcurrentHashMap concurrentHashMap = this.b;
            if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                StringBuilder sb2 = new StringBuilder();
                if (!TextUtils.isEmpty((String) this.b.get("cache_e"))) {
                    return Pair.create(Pair.create(Boolean.TRUE, sb2.toString()), this.b);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return Pair.create(Pair.create(Boolean.TRUE, "8"), null);
    }

    public String a(String str) {
        try {
            File file = new File(com.yxcorp.kuaishou.addfp.android.b.b.a(this.f20608c, false), new String(Base64.decode(str, 0)));
            if (!file.exists()) {
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return sb.toString().trim();
                }
                sb.append(line);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public synchronized void a(String str, String str2) {
        byte[] bArrEncode;
        LinkedHashMap linkedHashMap = null;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.b.put("c_time", Long.toString(jCurrentTimeMillis));
            this.b.put("cache_e", str);
            this.b.put("cache_m", str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("c_time", jCurrentTimeMillis);
            jSONObject.put("cache_e", str);
            jSONObject.put("cache_m", str2);
            byte[] bArrC = com.yxcorp.kuaishou.addfp.android.b.b.c(jSONObject.toString().getBytes(), "20212102sjcudiab".getBytes());
            try {
                bArrEncode = Base64.encode(bArrC, 0);
            } catch (Throwable unused) {
                bArrEncode = null;
            }
            if (bArrEncode == null) {
                try {
                    bArrEncode = Base64.encode(bArrC, 8);
                } catch (Throwable unused2) {
                }
            }
            if (bArrEncode != null) {
                this.a.a(new String(bArrEncode));
            }
        } catch (Throwable unused3) {
        }
        try {
            String strA = com.yxcorp.kuaishou.addfp.c.a.a.a(this.f20608c, "k_w_o_d_out_dtt");
            if (TextUtils.isEmpty(strA) && g.a(this.f20608c, new String[]{com.kuaishou.weapon.p0.g.f16729i, "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                strA = a("Lm91a2R0ZnQ=");
            }
            if (!TextUtils.isEmpty(strA) && (linkedHashMap = b(strA)) != null) {
                c cVar = b.a;
                String strA2 = cVar.a();
                if (!TextUtils.isEmpty(strA2)) {
                    if (linkedHashMap.containsKey(strA2)) {
                        linkedHashMap.remove(strA2);
                    }
                    linkedHashMap.put(cVar.a(), str);
                }
            }
            if (linkedHashMap == null || linkedHashMap.size() == 0) {
                linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(b.a.a(), str);
            }
            String strA3 = a(linkedHashMap);
            if (!TextUtils.isEmpty(strA3)) {
                try {
                    Settings.System.putString(this.f20608c.getContentResolver(), "k_w_o_d_out_dtt", strA3);
                } catch (Throwable unused4) {
                }
                if (g.a(this.f20608c, new String[]{com.kuaishou.weapon.p0.g.f16729i, "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                    a(this.f20608c, strA3);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public LinkedHashMap b(String str) {
        Throwable th;
        ObjectInputStream objectInputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(com.yxcorp.kuaishou.addfp.android.b.b.b(Base64.decode(str.getBytes(), 0), "20212102sjcudiab".getBytes())));
                try {
                    LinkedHashMap linkedHashMap = (LinkedHashMap) objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                    } catch (IOException unused) {
                    }
                    return linkedHashMap;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return new LinkedHashMap();
                    } catch (Throwable th3) {
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th3;
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
        }
        return new LinkedHashMap();
    }
}
