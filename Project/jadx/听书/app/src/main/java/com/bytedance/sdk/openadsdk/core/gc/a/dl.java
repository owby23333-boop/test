package com.bytedance.sdk.openadsdk.core.gc.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.sdk.openadsdk.core.gc.a.m;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements g {
    @Override // com.bytedance.sdk.openadsdk.core.gc.a.g
    public void z(String str, m.g gVar, boolean z, long j, m.z zVar, z zVar2) {
        if (zVar.dl() <= 0) {
            return;
        }
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.z.z.query(zw.getContext(), "meta_cache", null, "rit =?", new String[]{str}, null, null, "create_time ASC");
        if (cursorQuery != null) {
            if (zVar.dl() > 0 && cursorQuery.getCount() >= zVar.dl()) {
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("uuid"));
                if (zVar2 != null) {
                    zVar2.z(new m.g(cursorQuery.getString(cursorQuery.getColumnIndex("meta_data")), cursorQuery.getLong(cursorQuery.getColumnIndex("create_time")), cursorQuery.getLong(cursorQuery.getColumnIndex("expire_time")), cursorQuery.getString(cursorQuery.getColumnIndex("uuid"))));
                }
                com.bytedance.sdk.openadsdk.core.multipro.z.z.delete(zw.getContext(), "meta_cache", "rit=? AND uuid=?", new String[]{str, string});
            }
            cursorQuery.close();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", str);
        contentValues.put("uuid", gVar.gc);
        contentValues.put("create_time", Long.valueOf(gVar.z));
        contentValues.put("meta_data", gVar.dl);
        contentValues.put("save_version", Integer.valueOf(gVar.f1080a));
        contentValues.put("expire_time", Long.valueOf(gVar.g));
        contentValues.put("slot_type", zVar.z());
        contentValues.put("is_using", Integer.valueOf(z ? 1 : 0));
        contentValues.put("priority", Long.valueOf(j));
        com.bytedance.sdk.openadsdk.core.multipro.z.z.insert(zw.getContext(), "meta_cache", contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.a.g
    public m.g z(String str, m.z zVar, long j) {
        Cursor cursorZ = z(zVar, str);
        if (cursorZ == null) {
            return null;
        }
        while (cursorZ.moveToNext()) {
            try {
                String string = cursorZ.getString(cursorZ.getColumnIndex("meta_data"));
                long j2 = cursorZ.getLong(cursorZ.getColumnIndex("create_time"));
                long j3 = cursorZ.getLong(cursorZ.getColumnIndex("expire_time"));
                if (j <= 0 || j2 >= j) {
                    return new m.g(string, j2, j3, cursorZ.getString(cursorZ.getColumnIndex("uuid")));
                }
            } finally {
                cursorZ.close();
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.a.g
    public m.g z(String str, m.z zVar, long j, List<String> list) {
        Cursor cursorZ = z(zVar, str);
        if (cursorZ == null) {
            return null;
        }
        while (cursorZ.moveToNext()) {
            try {
                String string = cursorZ.getString(cursorZ.getColumnIndex("uuid"));
                if (string == null || list == null || !list.contains(string)) {
                    String string2 = cursorZ.getString(cursorZ.getColumnIndex("meta_data"));
                    long j2 = cursorZ.getLong(cursorZ.getColumnIndex("create_time"));
                    long j3 = cursorZ.getLong(cursorZ.getColumnIndex("expire_time"));
                    if (j <= 0 || j2 >= j) {
                        return new m.g(string2, j2, j3, string);
                    }
                }
            } finally {
                cursorZ.close();
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.a.g
    public void z(String str) {
        com.bytedance.sdk.openadsdk.core.multipro.z.z.delete(zw.getContext(), "meta_cache", "rit =?", new String[]{str});
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.a.g
    public void z(m.z zVar) {
        com.bytedance.sdk.openadsdk.core.multipro.z.z.delete(zw.getContext(), "meta_cache", "slot_type =?", new String[]{zVar.z()});
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.a.g
    public void z(String str, m.z zVar, z zVar2) {
        Cursor cursorQuery;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (zVar2 != null && (cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.z.z.query(zw.getContext(), "meta_cache", null, "expire_time <? AND rit =?", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, null)) != null) {
            while (cursorQuery.moveToNext()) {
                zVar2.z(new m.g(cursorQuery.getString(cursorQuery.getColumnIndex("meta_data")), cursorQuery.getLong(cursorQuery.getColumnIndex("create_time")), cursorQuery.getLong(cursorQuery.getColumnIndex("expire_time")), cursorQuery.getString(cursorQuery.getColumnIndex("uuid"))));
            }
            cursorQuery.close();
        }
        if (zVar.g()) {
            com.bytedance.sdk.openadsdk.core.multipro.z.z.delete(zw.getContext(), "meta_cache", "rit =? AND (save_version!=? OR expire_time <?)", new String[]{str, "7105", String.valueOf(jCurrentTimeMillis)});
        } else {
            com.bytedance.sdk.openadsdk.core.multipro.z.z.delete(zw.getContext(), "meta_cache", "rit =? AND expire_time <?", new String[]{str, String.valueOf(jCurrentTimeMillis)});
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.a.g
    public void z(String str, String str2) {
        com.bytedance.sdk.openadsdk.core.multipro.z.z.delete(zw.getContext(), "meta_cache", "rit =? AND uuid =?", new String[]{str, str2});
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.a.g
    public void g(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_using", (Integer) 0);
        com.bytedance.sdk.openadsdk.core.multipro.z.z.update(zw.getContext(), "meta_cache", contentValues, "rit =?", new String[]{str});
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.a.g
    public void z(String str, String str2, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_using", Boolean.valueOf(z));
        com.bytedance.sdk.openadsdk.core.multipro.z.z.update(zw.getContext(), "meta_cache", contentValues, "rit =? AND uuid =?", new String[]{str, str2});
    }

    private Cursor z(m.z zVar, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i = AnonymousClass1.z[zVar.a().ordinal()];
        return i != 1 ? i != 2 ? zVar.g() ? com.bytedance.sdk.openadsdk.core.multipro.z.z.query(zw.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7105"}, null, null, null) : com.bytedance.sdk.openadsdk.core.multipro.z.z.query(zw.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, null) : zVar.g() ? com.bytedance.sdk.openadsdk.core.multipro.z.z.query(zw.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7105"}, null, null, "priority DESC") : com.bytedance.sdk.openadsdk.core.multipro.z.z.query(zw.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, "priority DESC") : zVar.g() ? com.bytedance.sdk.openadsdk.core.multipro.z.z.query(zw.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7105"}, null, null, "create_time DESC") : com.bytedance.sdk.openadsdk.core.multipro.z.z.query(zw.getContext(), "meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, "create_time DESC");
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.gc.a.dl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[m.z.g.values().length];
            z = iArr;
            try {
                iArr[m.z.g.TimeLast.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[m.z.g.CustomPriority.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
