package com.bytedance.sdk.component.gz.g.z.z.g;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f751a;
    protected List<String> dl;
    protected com.bytedance.sdk.component.gz.z.gc g;
    private com.bytedance.sdk.component.gz.g.a.g.z gc;

    public byte dl() {
        return (byte) 0;
    }

    public byte g() {
        return (byte) 2;
    }

    public m(Context context, com.bytedance.sdk.component.gz.g.a.g.z zVar, com.bytedance.sdk.component.gz.z.gc gcVar) {
        super(context, gcVar, zVar == null ? com.bytedance.sdk.component.gz.g.a.g.z.dl() : zVar);
        this.dl = new ArrayList();
        this.f751a = context;
        this.gc = zVar;
        this.g = gcVar;
        if (zVar == null) {
            this.gc = com.bytedance.sdk.component.gz.g.a.g.z.dl();
        }
    }

    @Override // com.bytedance.sdk.component.gz.g.z.z
    public boolean z(com.bytedance.sdk.component.gz.z.g gVar) {
        return com.bytedance.sdk.component.gz.g.dl.z.dl(gVar);
    }

    @Override // com.bytedance.sdk.component.gz.g.z.z.g.g
    com.bytedance.sdk.component.gz.z.gc a() {
        return this.g;
    }

    @Override // com.bytedance.sdk.component.gz.g.z.z.g.g
    public String z() {
        com.bytedance.sdk.component.gz.z.m mVarG = this.g.g();
        if (mVarG != null) {
            return mVarG.g();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.gz.g.z.z.g.dl
    public List<com.bytedance.sdk.component.gz.z.g> z(int i, String str, int i2, boolean z) {
        com.bytedance.sdk.component.gz.z.a aVar;
        String str2;
        String str3;
        String string;
        String string2;
        int i3;
        int i4;
        long jZ = com.bytedance.sdk.component.gz.g.g.z.z(i, getContext(), this.g);
        com.bytedance.sdk.component.gz.g.dl.dl.g(z() + " query db max :" + jZ + " limit:" + i, this.g);
        if (jZ <= 0) {
            jZ = 1;
        } else if (jZ > 100) {
            jZ = 100;
        }
        List<com.bytedance.sdk.component.gz.z.g> arrayList = new ArrayList<>();
        this.dl.clear();
        String str4 = "retry";
        String str5 = "ad_extra_data";
        Cursor cursorQuery = com.bytedance.sdk.component.gz.g.z.z.g.query(getContext(), z(), new String[]{"id", "value", "encrypt", "retry"}, null, null, null, null, str + " DESC limit " + jZ, this.g);
        if (cursorQuery != null) {
            try {
                com.bytedance.sdk.component.gz.z.a aVarA = this.g.a();
                while (cursorQuery.moveToNext()) {
                    try {
                        string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        string2 = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                        i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("encrypt"));
                        str2 = str4;
                    } catch (Throwable th) {
                        th = th;
                        aVar = aVarA;
                        str2 = str4;
                    }
                    try {
                        i4 = cursorQuery.getInt(cursorQuery.getColumnIndex(str2));
                        if (i3 == 1) {
                            string2 = aVarA.z(string2);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        aVar = aVarA;
                        str3 = str5;
                        com.bytedance.sdk.component.gz.g.dl.dl.dl(th.getMessage(), this.g);
                        str5 = str3;
                        str4 = str2;
                        aVarA = aVar;
                    }
                    if (TextUtils.isEmpty(string2)) {
                        this.dl.add(string);
                        str4 = str2;
                    } else {
                        if (arrayList.size() > 100) {
                            break;
                        }
                        JSONObject jSONObject = new JSONObject(string2);
                        str3 = str5;
                        try {
                            String strOptString = jSONObject.optString(str3);
                            if (TextUtils.isEmpty(strOptString)) {
                                aVar = aVarA;
                            } else {
                                JSONObject jSONObject2 = new JSONObject(strOptString);
                                jSONObject2.put("retry_count", i4);
                                aVar = aVarA;
                                try {
                                    jSONObject2.put("db_rd", System.currentTimeMillis());
                                    jSONObject.put(str3, jSONObject2.toString());
                                } catch (Throwable th3) {
                                    th = th3;
                                    com.bytedance.sdk.component.gz.g.dl.dl.dl(th.getMessage(), this.g);
                                }
                            }
                            com.bytedance.sdk.component.gz.g.a.z.z zVar = new com.bytedance.sdk.component.gz.g.a.z.z(string, jSONObject);
                            zVar.z(dl());
                            zVar.g(g());
                            com.bytedance.sdk.component.gz.g.dl.z.z(jSONObject, zVar, this.g, i4);
                            arrayList.add(zVar);
                        } catch (Throwable th4) {
                            th = th4;
                            aVar = aVarA;
                        }
                        str5 = str3;
                        str4 = str2;
                        aVarA = aVar;
                    }
                }
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                        if (!this.dl.isEmpty()) {
                            dl(this.dl);
                            this.dl.clear();
                        }
                        if (com.bytedance.sdk.component.gz.g.dl.z.z(i2) && !z) {
                            z(arrayList, 5, 604800000L);
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th5) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                        if (!this.dl.isEmpty()) {
                            dl(this.dl);
                            this.dl.clear();
                        }
                        if (com.bytedance.sdk.component.gz.g.dl.z.z(i2) && !z) {
                            z(arrayList, 5, 604800000L);
                        }
                    } catch (Exception unused2) {
                    }
                }
                throw th5;
            }
        }
        com.bytedance.sdk.component.gz.g.dl.dl.g(z() + " query db actually size :" + arrayList.size(), this.g);
        return arrayList;
    }

    @Override // com.bytedance.sdk.component.gz.g.z.z.g.dl
    public List<com.bytedance.sdk.component.gz.z.g> z(String str, int i, boolean z) {
        com.bytedance.sdk.component.gz.g.a.g.z zVar = this.gc;
        if (zVar == null) {
            return new ArrayList();
        }
        return z(zVar.g(), str, i, z);
    }

    protected String dl(List<String> list) {
        z();
        list.size();
        String strZ = com.bytedance.sdk.component.gz.g.z.z.g.z(getContext(), "DELETE FROM " + z() + " WHERE " + z("id", (List<?>) list, 1000, true), this.g);
        com.bytedance.sdk.component.gz.g.dl.g.z(com.bytedance.sdk.component.gz.g.g.g.z.pf(), list.size(), this.g);
        z(list);
        return strZ;
    }

    @Override // com.bytedance.sdk.component.gz.g.z.z.g.dl
    public String delete(List<com.bytedance.sdk.component.gz.z.g> list) {
        if (list == null || list.size() == 0) {
            return "list is empty";
        }
        LinkedList linkedList = new LinkedList();
        Iterator<com.bytedance.sdk.component.gz.z.g> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().dl());
        }
        com.bytedance.sdk.component.gz.g.dl.z.z(list, this.g, z());
        String strZ = com.bytedance.sdk.component.gz.g.z.z.g.z(getContext(), "DELETE FROM " + z() + " WHERE " + z("id", (List<?>) linkedList, 1000, true), this.g);
        z(linkedList);
        return strZ;
    }

    private void z(int i, long j) {
        com.bytedance.sdk.component.gz.g.z.z.g.delete(getContext(), z(), "gen_time <? OR retry >?", new String[]{new StringBuilder().append(System.currentTimeMillis() - j).toString(), new StringBuilder().append(i).toString()}, this.g);
    }

    public void z(List<com.bytedance.sdk.component.gz.z.g> list, int i, long j) {
        if (list == null || list.size() == 0) {
            return;
        }
        try {
            a(list);
            z(i, j);
        } catch (Exception unused) {
        }
    }

    private void a(List<com.bytedance.sdk.component.gz.z.g> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<com.bytedance.sdk.component.gz.z.g> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().dl());
        }
        com.bytedance.sdk.component.gz.g.z.z.g.z(getContext(), "UPDATE " + z() + " SET retry = retry+1 WHERE " + z("id", (List<?>) linkedList, 1000, true), this.g);
    }

    public static String a(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    public static String gc(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }

    private static String z(String str, List<?> list, int i, boolean z) {
        int i2;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int iMin = Math.min(i, 1000);
        int size = list.size();
        if (size % iMin == 0) {
            i2 = size / iMin;
        } else {
            i2 = (size / iMin) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * iMin;
            String strZ = z(TextUtils.join("','", list.subList(i4, Math.min(i4 + iMin, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            sb.append(str).append(str2).append("('").append(strZ).append("')");
        }
        return z(sb.toString(), str + str2 + "('')");
    }

    private static String z(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
