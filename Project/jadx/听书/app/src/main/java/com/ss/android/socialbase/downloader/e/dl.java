package com.ss.android.socialbase.downloader.e;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.wp;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.ss.android.socialbase.downloader.g.fo;
import com.umeng.analytics.pro.ar;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class dl implements Parcelable {
    public static final Parcelable.Creator<dl> CREATOR = new Parcelable.Creator<dl>() { // from class: com.ss.android.socialbase.downloader.e.dl.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public dl createFromParcel(Parcel parcel) {
            return new dl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public dl[] newArray(int i) {
            return new dl[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2065a;
    private long b;
    private long bm;
    private boolean bv;
    private JSONObject bw;
    private boolean cb;
    private String dh;
    private String dl;
    private String dt;
    private boolean e;
    private boolean ec;
    private boolean eo;
    private int f;
    private List<gc> fo;
    private int fv;
    private String g;
    private boolean gb;
    private String gc;
    private boolean gk;
    private boolean gp;
    private JSONObject gy;
    private String gz;
    private boolean h;
    private boolean hh;
    private boolean hn;
    private SoftReference<PackageInfo> hy;
    private int i;
    private String io;
    private boolean iq;
    private String j;
    private int ja;
    private boolean jq;
    private List<String> js;
    private long k;
    private String[] kb;
    private Boolean kp;
    private String l;
    private com.ss.android.socialbase.downloader.g.g lk;
    private int lq;
    private boolean ls;
    private long lt;
    private AtomicInteger lw;
    private volatile boolean ly;
    private String m;
    private fo mc;
    private long me;
    private AtomicLong n;
    private boolean na;
    private boolean nb;
    private long nh;
    private boolean o;
    private boolean oq;
    private int p;
    private boolean pf;
    private String q;
    private int qd;
    private boolean r;
    private boolean rv;
    private String s;
    private long sd;
    private String sf;
    private String sv;
    private AtomicLong sy;
    private String t;
    private boolean tb;
    private boolean tc;
    private boolean te;
    private StringBuffer tf;
    private com.ss.android.socialbase.downloader.g.z ti;
    private com.ss.android.socialbase.downloader.g.e u;
    private String uf;
    private boolean un;
    private int uy;
    private int v;
    private int[] vm;
    private List<String> vo;
    private boolean wj;
    private boolean wn;
    private int wo;
    private int[] wp;
    private boolean wx;
    private String x;

    @Deprecated
    private int xf;
    private String xl;
    private com.ss.android.socialbase.downloader.gc.z xo;
    private boolean y;
    private boolean yt;
    private int yw;
    private int yx;
    private boolean yz;
    private int z;
    private ConcurrentHashMap<String, Object> zb;
    private int zd;
    private String zw;
    private AtomicLong zx;
    private boolean zz;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean xo() {
        return false;
    }

    public dl() {
        this.h = true;
        this.mc = fo.DELAY_RETRY_NONE;
        this.un = false;
        this.ti = com.ss.android.socialbase.downloader.g.z.ASYNC_HANDLE_NONE;
        this.na = true;
        this.gp = true;
        this.y = false;
        this.ec = false;
        this.bv = false;
        this.qd = 1;
        this.rv = true;
        this.tc = true;
        this.lk = com.ss.android.socialbase.downloader.g.g.BYTE_INVALID_RETRY_STATUS_NONE;
        this.u = com.ss.android.socialbase.downloader.g.e.ENQUEUE_NONE;
        this.n = new AtomicLong(0L);
        this.kp = null;
    }

    private dl(z zVar) {
        this.h = true;
        this.mc = fo.DELAY_RETRY_NONE;
        this.un = false;
        this.ti = com.ss.android.socialbase.downloader.g.z.ASYNC_HANDLE_NONE;
        this.na = true;
        this.gp = true;
        this.y = false;
        this.ec = false;
        this.bv = false;
        this.qd = 1;
        this.rv = true;
        this.tc = true;
        this.lk = com.ss.android.socialbase.downloader.g.g.BYTE_INVALID_RETRY_STATUS_NONE;
        this.u = com.ss.android.socialbase.downloader.g.e.ENQUEUE_NONE;
        this.n = new AtomicLong(0L);
        this.kp = null;
        if (zVar == null) {
            return;
        }
        this.g = zVar.z;
        this.dl = zVar.g;
        this.f2065a = zVar.dl;
        String strGc = zVar.f2066a;
        if (TextUtils.isEmpty(strGc)) {
            try {
                strGc = com.ss.android.socialbase.downloader.pf.m.gc();
            } catch (Throwable th) {
                wp.z(th);
            }
        }
        this.gc = strGc;
        String str = zVar.gc;
        this.m = str;
        if (TextUtils.isEmpty(str) && !com.ss.android.socialbase.downloader.pf.m.gz(strGc)) {
            this.m = com.ss.android.socialbase.downloader.pf.m.m();
        }
        z("task_key", (Object) zVar.f);
        if (zVar.sv) {
            if (com.ss.android.socialbase.downloader.downloader.dl.io().g(e()) == null) {
                this.gc = com.ss.android.socialbase.downloader.pf.m.gc(this.gc, this.f2065a);
                this.m = com.ss.android.socialbase.downloader.pf.m.gc(this.m, this.f2065a);
            }
        } else {
            com.ss.android.socialbase.downloader.m.z.gc("DownloadInfo", "The distinct directory option is not set, which may cause 1005 problems and file downloads being covered");
        }
        this.lw = new AtomicInteger(0);
        this.zx = new AtomicLong(0L);
        this.gz = zVar.e;
        this.e = zVar.m;
        this.fo = zVar.gz;
        this.uy = zVar.fo;
        this.i = zVar.wp;
        this.v = zVar.i;
        this.pf = zVar.v;
        this.kb = zVar.uy;
        this.wp = zVar.kb;
        this.ls = zVar.pf;
        this.p = zVar.ls;
        this.fv = zVar.p;
        this.js = zVar.fv;
        this.tb = zVar.js;
        this.q = zVar.q;
        this.iq = zVar.iq;
        this.hh = zVar.gk;
        this.l = zVar.x;
        this.wn = zVar.zw;
        this.nb = zVar.io;
        this.h = zVar.uf;
        this.gk = zVar.sy;
        this.zw = zVar.hh;
        this.uf = zVar.l;
        this.un = zVar.lq;
        this.wj = zVar.mc;
        this.u = zVar.un;
        this.eo = zVar.ti;
        this.oq = zVar.eo;
        this.cb = zVar.j;
        this.o = zVar.oq;
        this.xl = zVar.wj;
        this.k = zVar.na;
        this.wx = zVar.xl;
        JSONObject jSONObject = zVar.gp;
        if (jSONObject != null) {
            z("download_setting", (Object) jSONObject.toString());
        }
        z("dbjson_key_expect_file_length", Long.valueOf(zVar.h));
        z("executor_group", Integer.valueOf(zVar.ec));
        z("auto_install", Integer.valueOf(zVar.tb ? 1 : 0));
        this.gp = zVar.t;
        this.t = zVar.vm;
        this.vm = zVar.y;
        this.y = zVar.bv;
        this.ec = zVar.gb;
        this.lt = zVar.jq;
        this.gb = zVar.sv;
        if (this.y && this.i <= 0) {
            this.i = 1;
        }
        rh();
    }

    public void z(boolean z2) {
        this.cb = z2;
    }

    private void rh() {
        z("need_sdk_monitor", Boolean.valueOf(this.gp));
        z("monitor_scene", this.t);
        try {
            JSONArray jSONArray = new JSONArray();
            int[] iArr = this.vm;
            if (iArr != null && iArr.length > 0) {
                int i = 0;
                while (true) {
                    int[] iArr2 = this.vm;
                    if (i >= iArr2.length) {
                        break;
                    }
                    jSONArray.put(iArr2[i]);
                    i++;
                }
            }
            z("extra_monitor_status", jSONArray);
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    private void tp() {
        st();
        this.gp = this.gy.optBoolean("need_sdk_monitor", false);
        this.t = this.gy.optString("monitor_scene", "");
        JSONArray jSONArrayOptJSONArray = this.gy.optJSONArray("extra_monitor_status");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return;
        }
        this.vm = new int[jSONArrayOptJSONArray.length()];
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            this.vm[i] = jSONArrayOptJSONArray.optInt(i);
        }
    }

    public void z(Parcel parcel) {
        this.z = parcel.readInt();
        this.g = parcel.readString();
        this.dl = parcel.readString();
        this.f2065a = parcel.readString();
        this.gc = parcel.readString();
        this.m = parcel.readString();
        this.e = parcel.readByte() != 0;
        this.gz = parcel.readString();
        this.fo = parcel.createTypedArrayList(gc.CREATOR);
        this.uy = parcel.readInt();
        this.kb = parcel.createStringArray();
        this.wp = parcel.createIntArray();
        this.i = parcel.readInt();
        this.v = parcel.readInt();
        this.pf = parcel.readByte() != 0;
        this.ls = parcel.readByte() != 0;
        this.p = parcel.readInt();
        this.fv = parcel.readInt();
        this.js = parcel.createStringArrayList();
        this.tb = parcel.readByte() != 0;
        this.q = parcel.readString();
        this.iq = parcel.readByte() != 0;
        this.zw = parcel.readString();
        this.uf = parcel.readString();
        this.hh = parcel.readByte() != 0;
        this.h = parcel.readByte() != 0;
        this.gk = parcel.readByte() != 0;
        this.l = parcel.readString();
        this.x = parcel.readString();
        this.lq = parcel.readInt();
        js(parcel.readInt());
        this.un = parcel.readByte() != 0;
        this.jq = parcel.readByte() != 0;
        this.sv = parcel.readString();
        this.f = parcel.readInt();
        this.yx = parcel.readInt();
        this.qd = parcel.readInt();
        gc(parcel.readLong());
        this.b = parcel.readLong();
        a(parcel.readInt());
        this.me = parcel.readLong();
        this.nh = parcel.readLong();
        this.r = parcel.readByte() != 0;
        this.yz = parcel.readByte() != 0;
        try {
            StringBuffer stringBuffer = this.tf;
            if (stringBuffer == null) {
                this.tf = new StringBuffer(parcel.readString());
            } else {
                stringBuffer.delete(0, stringBuffer.length()).append(parcel.readString());
            }
        } catch (Exception e) {
            wp.z(e);
        }
        this.wn = parcel.readByte() != 0;
        this.nb = parcel.readByte() != 0;
        this.zz = parcel.readByte() != 0;
        this.vo = parcel.createStringArrayList();
        this.wj = parcel.readByte() != 0;
        fv(parcel.readInt());
        this.eo = parcel.readByte() != 0;
        this.yw = parcel.readInt();
        this.s = parcel.readString();
        this.ly = parcel.readByte() != 0;
        this.hn = parcel.readByte() != 0;
        this.cb = parcel.readByte() != 0;
        this.o = parcel.readByte() != 0;
        this.yt = parcel.readByte() != 0;
        this.xo = (com.ss.android.socialbase.downloader.gc.z) parcel.readParcelable(com.ss.android.socialbase.downloader.gc.z.class.getClassLoader());
        this.xf = parcel.readInt();
        this.dh = parcel.readString();
        this.na = parcel.readByte() != 0;
        this.xl = parcel.readString();
        this.wo = parcel.readInt();
        this.j = parcel.readString();
        this.y = parcel.readByte() != 0;
        this.ec = parcel.readByte() != 0;
        this.bv = parcel.readByte() != 0;
        tp();
    }

    private String nv() {
        List<String> list;
        if (this.dt == null && (list = this.js) != null && !list.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (String str : this.js) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
                this.dt = jSONArray.toString();
            } catch (Exception e) {
                wp.z(e);
            }
        }
        if (this.dt == null) {
            this.dt = "";
        }
        return this.dt;
    }

    private void pf(String str) {
        if (TextUtils.isEmpty(str) || p() == -3) {
            return;
        }
        this.dt = str;
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    String strOptString = jSONArray.optString(i);
                    if (!TextUtils.isEmpty(strOptString)) {
                        arrayList.add(strOptString);
                    }
                }
                this.js = arrayList;
            }
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public boolean z() {
        long j = this.n.get();
        return j == 0 || SystemClock.uptimeMillis() - j > 20;
    }

    public void g() {
        this.n.set(SystemClock.uptimeMillis());
    }

    public String dl() {
        return this.sf;
    }

    public void z(String str) {
        this.sf = str;
    }

    protected dl(Parcel parcel) {
        this.h = true;
        this.mc = fo.DELAY_RETRY_NONE;
        this.un = false;
        this.ti = com.ss.android.socialbase.downloader.g.z.ASYNC_HANDLE_NONE;
        this.na = true;
        this.gp = true;
        this.y = false;
        this.ec = false;
        this.bv = false;
        this.qd = 1;
        this.rv = true;
        this.tc = true;
        this.lk = com.ss.android.socialbase.downloader.g.g.BYTE_INVALID_RETRY_STATUS_NONE;
        this.u = com.ss.android.socialbase.downloader.g.e.ENQUEUE_NONE;
        this.n = new AtomicLong(0L);
        this.kp = null;
        z(parcel);
    }

    private void fv(int i) {
        if (i == com.ss.android.socialbase.downloader.g.e.ENQUEUE_HEAD.ordinal()) {
            this.u = com.ss.android.socialbase.downloader.g.e.ENQUEUE_HEAD;
        } else if (i == com.ss.android.socialbase.downloader.g.e.ENQUEUE_TAIL.ordinal()) {
            this.u = com.ss.android.socialbase.downloader.g.e.ENQUEUE_TAIL;
        } else {
            this.u = com.ss.android.socialbase.downloader.g.e.ENQUEUE_NONE;
        }
    }

    private void js(int i) {
        if (i == fo.DELAY_RETRY_WAITING.ordinal()) {
            this.mc = fo.DELAY_RETRY_WAITING;
            return;
        }
        if (i == fo.DELAY_RETRY_DOWNLOADING.ordinal()) {
            this.mc = fo.DELAY_RETRY_DOWNLOADING;
        } else if (i == fo.DELAY_RETRY_DOWNLOADED.ordinal()) {
            this.mc = fo.DELAY_RETRY_DOWNLOADED;
        } else {
            this.mc = fo.DELAY_RETRY_NONE;
        }
    }

    public String a() {
        StringBuffer stringBuffer = this.tf;
        return (stringBuffer == null || stringBuffer.length() == 0) ? "" : this.tf.toString();
    }

    public dl(Cursor cursor) {
        boolean z2 = true;
        this.h = true;
        this.mc = fo.DELAY_RETRY_NONE;
        this.un = false;
        this.ti = com.ss.android.socialbase.downloader.g.z.ASYNC_HANDLE_NONE;
        this.na = true;
        this.gp = true;
        this.y = false;
        this.ec = false;
        this.bv = false;
        this.qd = 1;
        this.rv = true;
        this.tc = true;
        this.lk = com.ss.android.socialbase.downloader.g.g.BYTE_INVALID_RETRY_STATUS_NONE;
        this.u = com.ss.android.socialbase.downloader.g.e.ENQUEUE_NONE;
        this.n = new AtomicLong(0L);
        this.kp = null;
        if (cursor == null) {
            return;
        }
        try {
            int columnIndex = cursor.getColumnIndex(ar.d);
            if (columnIndex != -1) {
                this.z = cursor.getInt(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("name");
            if (columnIndex2 != -1) {
                this.g = cursor.getString(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("title");
            if (columnIndex3 != -1) {
                this.dl = cursor.getString(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex("url");
            if (columnIndex4 != -1) {
                this.f2065a = cursor.getString(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex("savePath");
            if (columnIndex5 != -1) {
                this.gc = cursor.getString(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex("tempPath");
            if (columnIndex6 != -1) {
                this.m = cursor.getString(columnIndex6);
            }
            int columnIndex7 = cursor.getColumnIndex("chunkCount");
            if (columnIndex7 != -1) {
                this.qd = cursor.getInt(columnIndex7);
            }
            int columnIndex8 = cursor.getColumnIndex(NotificationCompat.CATEGORY_STATUS);
            if (columnIndex8 != -1) {
                this.lw = new AtomicInteger(cursor.getInt(columnIndex8));
            } else {
                this.lw = new AtomicInteger(0);
            }
            int columnIndex9 = cursor.getColumnIndex("curBytes");
            if (columnIndex9 != -1) {
                this.zx = new AtomicLong(cursor.getLong(columnIndex9));
            } else {
                this.zx = new AtomicLong(0L);
            }
            int columnIndex10 = cursor.getColumnIndex("totalBytes");
            if (columnIndex10 != -1) {
                this.b = cursor.getLong(columnIndex10);
            }
            int columnIndex11 = cursor.getColumnIndex("eTag");
            if (columnIndex11 != -1) {
                this.x = cursor.getString(columnIndex11);
            }
            int columnIndex12 = cursor.getColumnIndex("onlyWifi");
            if (columnIndex12 != -1) {
                this.e = cursor.getInt(columnIndex12) != 0;
            }
            int columnIndex13 = cursor.getColumnIndex("force");
            if (columnIndex13 != -1) {
                this.pf = cursor.getInt(columnIndex13) != 0;
            }
            int columnIndex14 = cursor.getColumnIndex("retryCount");
            if (columnIndex14 != -1) {
                this.i = cursor.getInt(columnIndex14);
            }
            int columnIndex15 = cursor.getColumnIndex("extra");
            if (columnIndex15 != -1) {
                this.gz = cursor.getString(columnIndex15);
            }
            int columnIndex16 = cursor.getColumnIndex("mimeType");
            if (columnIndex16 != -1) {
                this.q = cursor.getString(columnIndex16);
            }
            int columnIndex17 = cursor.getColumnIndex("notificationEnable");
            if (columnIndex17 != -1) {
                this.tb = cursor.getInt(columnIndex17) != 0;
            }
            int columnIndex18 = cursor.getColumnIndex("notificationVisibility");
            if (columnIndex18 != -1) {
                this.yx = cursor.getInt(columnIndex18);
            }
            int columnIndex19 = cursor.getColumnIndex("isFirstDownload");
            if (columnIndex19 != -1) {
                this.rv = cursor.getInt(columnIndex19) == 1;
            }
            int columnIndex20 = cursor.getColumnIndex("isFirstSuccess");
            if (columnIndex20 != -1) {
                this.tc = cursor.getInt(columnIndex20) == 1;
            }
            int columnIndex21 = cursor.getColumnIndex("needHttpsToHttpRetry");
            if (columnIndex21 != -1) {
                this.iq = cursor.getInt(columnIndex21) == 1;
            }
            int columnIndex22 = cursor.getColumnIndex("downloadTime");
            if (columnIndex22 != -1) {
                this.me = cursor.getLong(columnIndex22);
            }
            int columnIndex23 = cursor.getColumnIndex("packageName");
            if (columnIndex23 != -1) {
                this.zw = cursor.getString(columnIndex23);
            }
            int columnIndex24 = cursor.getColumnIndex(TKDownloadReason.KSAD_TK_MD5);
            if (columnIndex24 != -1) {
                this.uf = cursor.getString(columnIndex24);
            }
            int columnIndex25 = cursor.getColumnIndex("retryDelay");
            if (columnIndex25 != -1) {
                this.hh = cursor.getInt(columnIndex25) == 1;
            }
            int columnIndex26 = cursor.getColumnIndex("curRetryTime");
            if (columnIndex26 != -1) {
                this.lq = cursor.getInt(columnIndex26);
            }
            int columnIndex27 = cursor.getColumnIndex("retryDelayStatus");
            if (columnIndex27 != -1) {
                int i = cursor.getInt(columnIndex27);
                if (i == fo.DELAY_RETRY_WAITING.ordinal()) {
                    this.mc = fo.DELAY_RETRY_WAITING;
                } else if (i == fo.DELAY_RETRY_DOWNLOADING.ordinal()) {
                    this.mc = fo.DELAY_RETRY_DOWNLOADING;
                } else if (i == fo.DELAY_RETRY_DOWNLOADED.ordinal()) {
                    this.mc = fo.DELAY_RETRY_DOWNLOADED;
                } else {
                    this.mc = fo.DELAY_RETRY_NONE;
                }
            }
            int columnIndex28 = cursor.getColumnIndex("defaultHttpServiceBackUp");
            if (columnIndex28 != -1) {
                this.h = cursor.getInt(columnIndex28) == 1;
            }
            int columnIndex29 = cursor.getColumnIndex("chunkRunnableReuse");
            if (columnIndex29 != -1) {
                this.gk = cursor.getInt(columnIndex29) == 1;
            }
            int columnIndex30 = cursor.getColumnIndex("retryDelayTimeArray");
            if (columnIndex30 != -1) {
                this.l = cursor.getString(columnIndex30);
            }
            int columnIndex31 = cursor.getColumnIndex("chunkDowngradeRetry");
            if (columnIndex31 != -1) {
                this.o = cursor.getInt(columnIndex31) == 1;
            }
            int columnIndex32 = cursor.getColumnIndex("backUpUrlsStr");
            if (columnIndex32 != -1) {
                pf(cursor.getString(columnIndex32));
            }
            int columnIndex33 = cursor.getColumnIndex("backUpUrlRetryCount");
            if (columnIndex33 != -1) {
                this.v = cursor.getInt(columnIndex33);
            }
            int columnIndex34 = cursor.getColumnIndex("realDownloadTime");
            if (columnIndex34 != -1) {
                this.nh = cursor.getLong(columnIndex34);
            }
            int columnIndex35 = cursor.getColumnIndex("retryScheduleMinutes");
            if (columnIndex35 != -1) {
                this.xf = cursor.getInt(columnIndex35);
            }
            int columnIndex36 = cursor.getColumnIndex("independentProcess");
            if (columnIndex36 != -1) {
                if (cursor.getInt(columnIndex36) != 1) {
                    z2 = false;
                }
                this.wj = z2;
            }
            int columnIndex37 = cursor.getColumnIndex("auxiliaryJsonobjectString");
            if (columnIndex37 != -1) {
                this.dh = cursor.getString(columnIndex37);
            }
            int columnIndex38 = cursor.getColumnIndex("iconUrl");
            if (columnIndex38 != -1) {
                this.xl = cursor.getString(columnIndex38);
            }
            int columnIndex39 = cursor.getColumnIndex("appVersionCode");
            if (columnIndex39 != -1) {
                this.wo = cursor.getInt(columnIndex39);
            }
            int columnIndex40 = cursor.getColumnIndex("taskId");
            if (columnIndex40 != -1) {
                this.j = cursor.getString(columnIndex40);
            }
            tp();
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public ContentValues gc() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ar.d, Integer.valueOf(this.z));
        contentValues.put("url", this.f2065a);
        contentValues.put("savePath", this.gc);
        contentValues.put("tempPath", this.m);
        contentValues.put("name", this.g);
        contentValues.put("chunkCount", Integer.valueOf(this.qd));
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(p()));
        contentValues.put("curBytes", Long.valueOf(sf()));
        contentValues.put("totalBytes", Long.valueOf(this.b));
        contentValues.put("eTag", this.x);
        contentValues.put("onlyWifi", Integer.valueOf(this.e ? 1 : 0));
        contentValues.put("force", Integer.valueOf(this.pf ? 1 : 0));
        contentValues.put("retryCount", Integer.valueOf(this.i));
        contentValues.put("extra", this.gz);
        contentValues.put("mimeType", this.q);
        contentValues.put("title", this.dl);
        contentValues.put("notificationEnable", Integer.valueOf(this.tb ? 1 : 0));
        contentValues.put("notificationVisibility", Integer.valueOf(this.yx));
        contentValues.put("isFirstDownload", Integer.valueOf(this.rv ? 1 : 0));
        contentValues.put("isFirstSuccess", Integer.valueOf(this.tc ? 1 : 0));
        contentValues.put("needHttpsToHttpRetry", Integer.valueOf(this.iq ? 1 : 0));
        contentValues.put("downloadTime", Long.valueOf(this.me));
        contentValues.put("packageName", this.zw);
        contentValues.put(TKDownloadReason.KSAD_TK_MD5, this.uf);
        contentValues.put("retryDelay", Integer.valueOf(this.hh ? 1 : 0));
        contentValues.put("curRetryTime", Integer.valueOf(this.lq));
        contentValues.put("retryDelayStatus", Integer.valueOf(this.mc.ordinal()));
        contentValues.put("defaultHttpServiceBackUp", Integer.valueOf(this.h ? 1 : 0));
        contentValues.put("chunkRunnableReuse", Integer.valueOf(this.gk ? 1 : 0));
        contentValues.put("retryDelayTimeArray", this.l);
        contentValues.put("chunkDowngradeRetry", Integer.valueOf(this.o ? 1 : 0));
        contentValues.put("backUpUrlsStr", nv());
        contentValues.put("backUpUrlRetryCount", Integer.valueOf(this.v));
        contentValues.put("realDownloadTime", Long.valueOf(this.nh));
        contentValues.put("retryScheduleMinutes", Integer.valueOf(this.xf));
        contentValues.put("independentProcess", Integer.valueOf(this.wj ? 1 : 0));
        contentValues.put("auxiliaryJsonobjectString", zr());
        contentValues.put("iconUrl", this.xl);
        contentValues.put("appVersionCode", Integer.valueOf(this.wo));
        contentValues.put("taskId", this.j);
        return contentValues;
    }

    private String zr() {
        String string;
        String str = this.dh;
        if (str != null) {
            return str;
        }
        st();
        synchronized (this.gy) {
            string = this.gy.toString();
            this.dh = string;
        }
        return string;
    }

    public void z(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.ja = 0;
        sQLiteStatement.clearBindings();
        int i = this.ja + 1;
        this.ja = i;
        sQLiteStatement.bindLong(i, this.z);
        int i2 = this.ja + 1;
        this.ja = i2;
        String str = this.f2065a;
        if (str == null) {
            str = "";
        }
        sQLiteStatement.bindString(i2, str);
        int i3 = this.ja + 1;
        this.ja = i3;
        String str2 = this.gc;
        if (str2 == null) {
            str2 = "";
        }
        sQLiteStatement.bindString(i3, str2);
        int i4 = this.ja + 1;
        this.ja = i4;
        String str3 = this.m;
        if (str3 == null) {
            str3 = "";
        }
        sQLiteStatement.bindString(i4, str3);
        int i5 = this.ja + 1;
        this.ja = i5;
        String str4 = this.g;
        if (str4 == null) {
            str4 = "";
        }
        sQLiteStatement.bindString(i5, str4);
        int i6 = this.ja + 1;
        this.ja = i6;
        sQLiteStatement.bindLong(i6, this.qd);
        int i7 = this.ja + 1;
        this.ja = i7;
        sQLiteStatement.bindLong(i7, p());
        int i8 = this.ja + 1;
        this.ja = i8;
        sQLiteStatement.bindLong(i8, sf());
        int i9 = this.ja + 1;
        this.ja = i9;
        sQLiteStatement.bindLong(i9, this.b);
        int i10 = this.ja + 1;
        this.ja = i10;
        String str5 = this.x;
        if (str5 == null) {
            str5 = "";
        }
        sQLiteStatement.bindString(i10, str5);
        int i11 = this.ja + 1;
        this.ja = i11;
        sQLiteStatement.bindLong(i11, this.e ? 1L : 0L);
        int i12 = this.ja + 1;
        this.ja = i12;
        sQLiteStatement.bindLong(i12, this.pf ? 1L : 0L);
        int i13 = this.ja + 1;
        this.ja = i13;
        sQLiteStatement.bindLong(i13, this.i);
        int i14 = this.ja + 1;
        this.ja = i14;
        String str6 = this.gz;
        if (str6 == null) {
            str6 = "";
        }
        sQLiteStatement.bindString(i14, str6);
        int i15 = this.ja + 1;
        this.ja = i15;
        String str7 = this.q;
        if (str7 == null) {
            str7 = "";
        }
        sQLiteStatement.bindString(i15, str7);
        int i16 = this.ja + 1;
        this.ja = i16;
        String str8 = this.dl;
        if (str8 == null) {
            str8 = "";
        }
        sQLiteStatement.bindString(i16, str8);
        int i17 = this.ja + 1;
        this.ja = i17;
        sQLiteStatement.bindLong(i17, this.tb ? 1L : 0L);
        int i18 = this.ja + 1;
        this.ja = i18;
        sQLiteStatement.bindLong(i18, this.yx);
        int i19 = this.ja + 1;
        this.ja = i19;
        sQLiteStatement.bindLong(i19, this.rv ? 1L : 0L);
        int i20 = this.ja + 1;
        this.ja = i20;
        sQLiteStatement.bindLong(i20, this.tc ? 1L : 0L);
        int i21 = this.ja + 1;
        this.ja = i21;
        sQLiteStatement.bindLong(i21, this.iq ? 1L : 0L);
        int i22 = this.ja + 1;
        this.ja = i22;
        sQLiteStatement.bindLong(i22, this.me);
        int i23 = this.ja + 1;
        this.ja = i23;
        String str9 = this.zw;
        if (str9 == null) {
            str9 = "";
        }
        sQLiteStatement.bindString(i23, str9);
        int i24 = this.ja + 1;
        this.ja = i24;
        String str10 = this.uf;
        if (str10 == null) {
            str10 = "";
        }
        sQLiteStatement.bindString(i24, str10);
        int i25 = this.ja + 1;
        this.ja = i25;
        sQLiteStatement.bindLong(i25, this.hh ? 1L : 0L);
        int i26 = this.ja + 1;
        this.ja = i26;
        sQLiteStatement.bindLong(i26, this.lq);
        int i27 = this.ja + 1;
        this.ja = i27;
        sQLiteStatement.bindLong(i27, this.mc.ordinal());
        int i28 = this.ja + 1;
        this.ja = i28;
        sQLiteStatement.bindLong(i28, this.h ? 1L : 0L);
        int i29 = this.ja + 1;
        this.ja = i29;
        sQLiteStatement.bindLong(i29, this.gk ? 1L : 0L);
        int i30 = this.ja + 1;
        this.ja = i30;
        String str11 = this.l;
        if (str11 == null) {
            str11 = "";
        }
        sQLiteStatement.bindString(i30, str11);
        int i31 = this.ja + 1;
        this.ja = i31;
        sQLiteStatement.bindLong(i31, this.o ? 1L : 0L);
        int i32 = this.ja + 1;
        this.ja = i32;
        sQLiteStatement.bindString(i32, nv());
        int i33 = this.ja + 1;
        this.ja = i33;
        sQLiteStatement.bindLong(i33, this.v);
        int i34 = this.ja + 1;
        this.ja = i34;
        sQLiteStatement.bindLong(i34, this.nh);
        int i35 = this.ja + 1;
        this.ja = i35;
        sQLiteStatement.bindLong(i35, this.xf);
        int i36 = this.ja + 1;
        this.ja = i36;
        sQLiteStatement.bindLong(i36, this.wj ? 1L : 0L);
        int i37 = this.ja + 1;
        this.ja = i37;
        sQLiteStatement.bindString(i37, zr());
        int i38 = this.ja + 1;
        this.ja = i38;
        String str12 = this.xl;
        if (str12 == null) {
            str12 = "";
        }
        sQLiteStatement.bindString(i38, str12);
        int i39 = this.ja + 1;
        this.ja = i39;
        sQLiteStatement.bindLong(i39, this.wo);
        int i40 = this.ja + 1;
        this.ja = i40;
        String str13 = this.j;
        sQLiteStatement.bindString(i40, str13 != null ? str13 : "");
    }

    public int m() {
        return this.ja;
    }

    public int e() {
        if (this.z == 0) {
            this.z = com.ss.android.socialbase.downloader.downloader.dl.z(this);
        }
        return this.z;
    }

    public String gz() {
        return this.g;
    }

    public String fo() {
        if (TextUtils.isEmpty(this.dl)) {
            return this.g;
        }
        return this.dl;
    }

    public String uy() {
        return this.f2065a;
    }

    public String kb() {
        return this.gc;
    }

    public String wp() {
        return com.ss.android.socialbase.downloader.pf.m.g(this.gc, this.m);
    }

    public String i() {
        return com.ss.android.socialbase.downloader.pf.m.dl(this.g);
    }

    public String v() {
        return com.ss.android.socialbase.downloader.pf.m.z(this.gc, this.g);
    }

    public boolean pf() {
        return this.h;
    }

    public boolean ls() {
        return this.gk;
    }

    public int p() {
        AtomicInteger atomicInteger = this.lw;
        if (atomicInteger == null) {
            return 0;
        }
        int i = atomicInteger.get();
        if (i == -5) {
            return -2;
        }
        return i;
    }

    public com.ss.android.socialbase.downloader.g.e fv() {
        return this.u;
    }

    public int js() {
        return this.f;
    }

    public boolean tb() {
        return this.yz;
    }

    public boolean q() {
        return this.wn;
    }

    public void g(boolean z2) {
        this.wn = z2;
    }

    public boolean iq() {
        return this.zz;
    }

    public void dl(boolean z2) {
        this.zz = z2;
    }

    public int zw() {
        AtomicInteger atomicInteger = this.lw;
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        return 0;
    }

    public boolean io() {
        return this.e;
    }

    public void a(boolean z2) {
        this.e = z2;
    }

    public long uf() {
        st();
        return this.gy.optLong("dbjson_key_first_speed_time");
    }

    public void z(long j) {
        z("dbjson_key_first_speed_time", Long.valueOf(j));
    }

    public String sy() {
        st();
        return this.gy.optString("task_key");
    }

    public int hh() {
        st();
        return this.gy.optInt("ttmd5_check_status", -1);
    }

    public void z(int i) {
        z("ttmd5_check_status", Integer.valueOf(i));
    }

    public long l() {
        st();
        if (this.sy == null) {
            this.sy = new AtomicLong(this.gy.optLong("dbjson_key_all_connect_time"));
        }
        return this.sy.get();
    }

    public void g(long j) {
        if (j > 0) {
            l();
            z("dbjson_key_all_connect_time", Long.valueOf(this.sy.addAndGet(j)));
        }
    }

    public long h() {
        st();
        return this.gy.optLong("dbjson_key_download_prepare_time");
    }

    public void dl(long j) {
        if (j > 0) {
            z("dbjson_key_download_prepare_time", Long.valueOf(h() + j));
        }
    }

    public String gk() {
        return this.gz;
    }

    public String x() {
        return this.zw;
    }

    public String lq() {
        return this.io;
    }

    public void g(String str) {
        this.io = str;
    }

    public String mc() {
        return this.uf;
    }

    public long un() {
        st();
        return this.gy.optLong("dbjson_key_expect_file_length");
    }

    public List<gc> ti() {
        return this.fo;
    }

    public int eo() {
        return this.uy;
    }

    public int oq() {
        return this.i;
    }

    public int wj() {
        return this.v;
    }

    public int na() {
        int i = this.i;
        List<String> list = this.js;
        return (list == null || list.isEmpty()) ? i : i + (this.v * this.js.size());
    }

    public int xl() {
        int i = this.lq;
        if (!this.r) {
            return i;
        }
        int i2 = i + this.i;
        int i3 = this.f;
        return i3 > 0 ? i2 + (i3 * this.v) : i2;
    }

    public List<String> j() {
        return this.vo;
    }

    public void z(List<String> list, boolean z2) {
        this.vo = list;
        ls(z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    private void ls(boolean z2) {
        List<String> list = this.vo;
        if (list == null || list.size() <= z2) {
            return;
        }
        List<String> list2 = this.js;
        if (list2 == null) {
            this.js = new ArrayList();
        } else {
            list2.clear();
        }
        this.r = false;
        this.f = 0;
        for (?? r3 = z2; r3 < this.vo.size(); r3++) {
            this.js.add(this.vo.get(r3));
        }
    }

    public String gp() {
        List<String> list;
        int i;
        List<String> list2;
        String str = this.f2065a;
        if (p() == 8 && (list2 = this.vo) != null && !list2.isEmpty() && !this.r) {
            return this.vo.get(0);
        }
        if (!this.r || (list = this.js) == null || list.size() <= 0 || (i = this.f) < 0 || i >= this.js.size()) {
            return (!TextUtils.isEmpty(this.f2065a) && this.f2065a.startsWith("https") && this.iq && this.yz) ? this.f2065a.replaceFirst("https", "http") : str;
        }
        String str2 = this.js.get(this.f);
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public boolean t() {
        return this.r;
    }

    public void vm() {
        this.bm = SystemClock.uptimeMillis();
        z("dbjson_last_start_download_time", Long.valueOf(System.currentTimeMillis()));
    }

    public void z(String str, Object obj) {
        st();
        synchronized (this.gy) {
            try {
                this.gy.put(str, obj);
            } catch (Exception unused) {
            }
            this.dh = null;
        }
    }

    public String y() {
        st();
        return this.gy.optString("download_setting");
    }

    public int ec() {
        st();
        return this.gy.optInt("retry_schedule_count", 0);
    }

    public void g(int i) {
        z("retry_schedule_count", Integer.valueOf(i));
    }

    public boolean bv() {
        return this.te;
    }

    public void gc(boolean z2) {
        this.te = z2;
    }

    public int gb() {
        st();
        return this.gy.optInt("link_mode");
    }

    public void dl(int i) {
        z("link_mode", Integer.valueOf(i));
    }

    public boolean jq() {
        return (tk() & 2) > 0;
    }

    public boolean sv() {
        return (tk() & 1) > 0;
    }

    public boolean f() {
        return zw() == -2 || zw() == -5;
    }

    private int tk() {
        mz();
        try {
            return this.bw.optInt("pause_reserve_on_wifi", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public void yx() {
        mz();
        try {
            this.bw.put("pause_reserve_on_wifi", 3);
            zt();
        } catch (Exception unused) {
        }
    }

    public void qd() {
        mz();
        try {
            this.bw.put("pause_reserve_on_wifi", 1);
            zt();
        } catch (Exception unused) {
        }
    }

    public void a(long j) {
        mz();
        try {
            this.bw.put("cache-control/expired_time", j);
            zt();
        } catch (Exception unused) {
        }
    }

    public long zx() {
        mz();
        try {
            return this.bw.optLong("cache-control/expired_time", -1L);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public void dl(String str) {
        mz();
        try {
            this.bw.put("cache-control", str);
            zt();
        } catch (Exception unused) {
        }
    }

    public String b() {
        mz();
        try {
            return this.bw.optString("cache-control", null);
        } catch (Exception unused) {
            return null;
        }
    }

    public void a(String str) {
        mz();
        try {
            this.bw.put("last-modified", str);
            zt();
        } catch (Exception unused) {
        }
    }

    public String lw() {
        mz();
        try {
            return this.bw.optString("last-modified", null);
        } catch (Exception unused) {
            return null;
        }
    }

    public void m(boolean z2) {
        z("rw_concurrent", Integer.valueOf(z2 ? 1 : 0));
    }

    public boolean rv() {
        st();
        return this.gy.optInt("rw_concurrent", 0) == 1;
    }

    public boolean tc() {
        return this.gp;
    }

    public String me() {
        return this.t;
    }

    public int[] nh() {
        return this.vm;
    }

    public void r() {
        if (this.bm == 0) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() - this.bm;
        if (this.me < 0) {
            this.me = 0L;
        }
        if (jUptimeMillis > 0) {
            this.me = jUptimeMillis;
        }
    }

    public void yz() {
        if (this.sd == 0) {
            this.sd = System.nanoTime();
        }
    }

    public void bm() {
        this.sd = 0L;
    }

    public void e(boolean z2) {
        long jNanoTime = System.nanoTime();
        long j = this.sd;
        if (j <= 0) {
            if (z2) {
                this.sd = jNanoTime;
                return;
            }
            return;
        }
        long j2 = jNanoTime - j;
        if (z2) {
            this.sd = jNanoTime;
        } else {
            this.sd = 0L;
        }
        if (j2 > 0) {
            this.nh += j2;
        }
    }

    public boolean sd() {
        return this.un;
    }

    public boolean tf() {
        return this.wj;
    }

    public boolean ja() {
        return this.ec;
    }

    public boolean wn() {
        return this.eo;
    }

    public boolean nb() {
        return this.oq;
    }

    public boolean zz() {
        return this.cb;
    }

    public boolean vo() {
        return this.pf;
    }

    public boolean lk() {
        if (com.ss.android.socialbase.downloader.i.z.dl().z("force_close_download_cache_check", 0) == 1) {
            com.ss.android.socialbase.downloader.m.z.dl("isExpiredRedownload force to false, reason(global setting) id=" + e() + " name=" + gz());
            return false;
        }
        return this.y;
    }

    public boolean u() {
        return this.bv;
    }

    public void gz(boolean z2) {
        this.bv = z2;
    }

    public long sf() {
        AtomicLong atomicLong = this.zx;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public void gc(long j) {
        AtomicLong atomicLong = this.zx;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.zx = new AtomicLong(j);
        }
    }

    public void z(long j, boolean z2) {
        if (z2) {
            gc(j);
        } else if (j > sf()) {
            gc(j);
        }
    }

    public com.ss.android.socialbase.downloader.g.g yw() {
        return this.lk;
    }

    public void z(com.ss.android.socialbase.downloader.g.g gVar) {
        this.lk = gVar;
    }

    public void fo(boolean z2) {
        this.rv = z2;
    }

    public void uy(boolean z2) {
        this.tc = z2;
    }

    public void m(long j) {
        this.zx.addAndGet(j);
    }

    public void gc(String str) {
        this.x = str;
    }

    public void m(String str) {
        this.g = str;
    }

    public void e(long j) {
        this.b = j;
    }

    public void a(int i) {
        AtomicInteger atomicInteger = this.lw;
        if (atomicInteger != null) {
            atomicInteger.set(i);
        } else {
            this.lw = new AtomicInteger(i);
        }
    }

    public void kb(boolean z2) {
        this.na = z2;
    }

    public void e(String str) {
        this.zw = str;
    }

    public long s() {
        return this.b;
    }

    public String n() {
        return this.x;
    }

    public String ly() {
        return this.sv;
    }

    public void gz(String str) {
        this.sv = str;
    }

    public void gc(int i) {
        this.qd = i;
    }

    public int hn() {
        return this.yx;
    }

    public void m(int i) {
        this.yx = i;
    }

    public void wp(boolean z2) {
        this.jq = z2;
    }

    public int wo() {
        return this.yw;
    }

    public void e(int i) {
        this.yw = i;
    }

    public void fo(String str) {
        this.s = str;
    }

    public boolean k() {
        boolean z2 = this.wn;
        if (!z2 && this.tb) {
            return true;
        }
        if (z2) {
            return this.nb || this.zz;
        }
        return false;
    }

    public boolean wx() {
        return this.tb;
    }

    public boolean cb() {
        if (this.kp == null) {
            if (!TextUtils.isEmpty(this.gz)) {
                try {
                    this.kp = Boolean.valueOf(new JSONObject(this.gz).optBoolean("auto_install_without_notification", false));
                } catch (JSONException unused) {
                    this.kp = Boolean.FALSE;
                }
            } else {
                this.kp = Boolean.FALSE;
            }
        }
        return this.kp.booleanValue();
    }

    public boolean o() {
        st();
        return this.gy.optInt("auto_install", 1) == 1;
    }

    public void uy(String str) {
        this.q = str;
    }

    public String yt() {
        return this.q;
    }

    public boolean dt() {
        return this.iq;
    }

    public String xf() {
        return this.l;
    }

    public int bw() {
        return this.lq;
    }

    public boolean gy() {
        return this.hn;
    }

    public void dh() {
        this.hn = true;
    }

    public String zb() {
        return this.xl;
    }

    public void gz(int i) {
        this.wo = i;
    }

    public int zd() {
        return this.wo;
    }

    public String te() {
        return this.j;
    }

    public void hy() {
        this.j = UUID.randomUUID().toString();
    }

    public boolean lt() {
        return this.o;
    }

    public boolean kp() {
        return this.yt;
    }

    public fo fp() {
        return this.mc;
    }

    public com.ss.android.socialbase.downloader.g.z vt() {
        return this.ti;
    }

    public boolean pd() {
        int iP = p();
        return iP == 7 || this.mc == fo.DELAY_RETRY_WAITING || iP == 8 || this.ti == com.ss.android.socialbase.downloader.g.z.ASYNC_HANDLE_WAITING || this.ti == com.ss.android.socialbase.downloader.g.z.ASYNC_HANDLE_RESTART || this.lk == com.ss.android.socialbase.downloader.g.g.BYTE_INVALID_RETRY_STATUS_RESTART;
    }

    public void gm() {
        int iP = p();
        if (iP == 7 || this.mc == fo.DELAY_RETRY_WAITING) {
            z(fo.DELAY_RETRY_DOWNLOADING);
        }
        if (iP == 8 || this.ti == com.ss.android.socialbase.downloader.g.z.ASYNC_HANDLE_WAITING || this.ti == com.ss.android.socialbase.downloader.g.z.ASYNC_HANDLE_RESTART) {
            z(com.ss.android.socialbase.downloader.g.z.ASYNC_HANDLE_DOWNLOADING);
        }
        if (this.lk == com.ss.android.socialbase.downloader.g.g.BYTE_INVALID_RETRY_STATUS_RESTART) {
            z(com.ss.android.socialbase.downloader.g.g.BYTE_INVALID_RETRY_STATUS_DOWNLOADING);
        }
    }

    public boolean mn() {
        return xo() && p() != -3 && this.mc == fo.DELAY_RETRY_WAITING;
    }

    public void z(fo foVar) {
        this.mc = foVar;
    }

    public boolean jz() {
        return p() != -3 && this.ti == com.ss.android.socialbase.downloader.g.z.ASYNC_HANDLE_WAITING;
    }

    public void z(com.ss.android.socialbase.downloader.g.z zVar) {
        this.ti = zVar;
    }

    public void fo(int i) {
        int i2 = (this.r ? this.v : this.i) - i;
        this.lq = i2;
        if (i2 < 0) {
            this.lq = 0;
        }
    }

    public long oz() {
        return this.me;
    }

    public long bb() {
        return TimeUnit.NANOSECONDS.toMillis(this.nh);
    }

    public void z(dl dlVar, boolean z2) {
        if (dlVar == null) {
            return;
        }
        gc(dlVar.ux());
        e(dlVar.s());
        z(dlVar.sf(), true);
        this.nh = dlVar.nh;
        if (!dlVar.pd() && !pd()) {
            this.lq = 0;
            this.hn = false;
            this.r = false;
            this.f = 0;
            this.yz = false;
        } else {
            this.lq = dlVar.bw();
        }
        gc(dlVar.n());
        if (z2) {
            a(dlVar.p());
        }
        this.rv = dlVar.by();
        this.tc = dlVar.li();
        this.mc = dlVar.fp();
        z(dlVar.gy);
    }

    public void z(dl dlVar) {
        if (dlVar == null) {
            return;
        }
        this.j = dlVar.te();
    }

    private void st() {
        if (this.gy == null) {
            synchronized (this) {
                if (this.gy == null) {
                    try {
                        if (!TextUtils.isEmpty(this.dh)) {
                            this.gy = new JSONObject(this.dh);
                            this.dh = null;
                        } else {
                            this.gy = new JSONObject();
                        }
                    } catch (Throwable unused) {
                        this.gy = new JSONObject();
                    }
                }
            }
        }
    }

    public void kb(String str) {
        this.uf = str;
    }

    private void z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        st();
        synchronized (this.gy) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object objOpt = jSONObject.opt(next);
                    if (!this.gy.has(next) && objOpt != null) {
                        this.gy.put(next, objOpt);
                    }
                }
            } catch (Exception unused) {
            }
            this.dh = null;
        }
        tp();
    }

    public boolean by() {
        return this.rv;
    }

    public boolean li() {
        return this.tc;
    }

    public boolean g(dl dlVar) {
        String str;
        String str2;
        return (dlVar == null || (str = this.f2065a) == null || !str.equals(dlVar.uy()) || (str2 = this.gc) == null || !str2.equals(dlVar.kb())) ? false : true;
    }

    public void uy(int i) {
        this.z = i;
    }

    public boolean jc() {
        return !io() || com.ss.android.socialbase.downloader.pf.m.g(com.ss.android.socialbase.downloader.downloader.dl.xl());
    }

    public boolean he() {
        if (this.te) {
            return jq() && com.ss.android.socialbase.downloader.pf.m.g(com.ss.android.socialbase.downloader.downloader.dl.xl());
        }
        return true;
    }

    public boolean no() {
        return com.ss.android.socialbase.downloader.g.m.z(p());
    }

    public List<String> mj() {
        return this.js;
    }

    public boolean c() {
        return com.ss.android.socialbase.downloader.pf.m.g(this.b);
    }

    public boolean gw() {
        return this.ls;
    }

    public int vy() {
        return this.p;
    }

    public long gz(long j) {
        int i = this.p;
        if (i <= 0) {
            i = 100;
        }
        long j2 = j / ((long) (i + 1));
        return j2 <= 0 ? PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : j2;
    }

    public int vk() {
        int i = this.fv;
        if (i < 1000) {
            return 1000;
        }
        return i;
    }

    public boolean pc() {
        return TextUtils.isEmpty(this.f2065a) || TextUtils.isEmpty(this.g) || TextUtils.isEmpty(this.gc);
    }

    public boolean qz() {
        return com.ss.android.socialbase.downloader.pf.m.dl(this);
    }

    public boolean aq() {
        if (this.r) {
            this.f++;
        }
        List<String> list = this.js;
        if (list != null && list.size() != 0 && this.f >= 0) {
            while (this.f < this.js.size()) {
                if (!TextUtils.isEmpty(this.js.get(this.f))) {
                    this.r = true;
                    return true;
                }
                this.f++;
            }
        }
        return false;
    }

    public boolean mk() {
        int i;
        List<String> list = this.js;
        if (list == null || list.size() <= 0) {
            return false;
        }
        return !this.r || ((i = this.f) >= 0 && i < this.js.size() - 1);
    }

    public boolean en() {
        return !TextUtils.isEmpty(this.f2065a) && this.f2065a.startsWith("https") && this.iq && !this.yz;
    }

    public void i(boolean z2) {
        this.yz = z2;
    }

    public void wp(String str) {
        z(0L, true);
        e(0L);
        gc(str);
        gc(1);
        this.me = 0L;
        this.sd = 0L;
        this.nh = 0L;
    }

    public void oc() {
        z(0L, true);
        this.b = 0L;
        this.qd = 1;
        this.me = 0L;
        this.sd = 0L;
        this.nh = 0L;
    }

    public void ou() {
        z(0L, true);
        this.b = 0L;
        this.qd = 1;
        this.me = 0L;
        this.sd = 0L;
        this.nh = 0L;
        this.lq = 0;
        this.rv = true;
        this.tc = true;
        this.r = false;
        this.yz = false;
        this.x = null;
        this.xo = null;
        this.zb = null;
        this.hy = null;
    }

    public boolean bp() {
        if (pc()) {
            return false;
        }
        File file = new File(wp(), i());
        boolean zExists = file.exists();
        boolean zIsDirectory = file.isDirectory();
        if (zExists && !zIsDirectory) {
            long length = file.length();
            long jSf = sf();
            if (com.ss.android.socialbase.downloader.i.z.dl().z("fix_file_data_valid")) {
                if (jSf > 0) {
                    long j = this.b;
                    if (j > 0 && this.qd > 0 && length >= jSf && length <= j) {
                        return true;
                    }
                }
                com.ss.android.socialbase.downloader.m.z.a("DownloadInfo", "isFileDataValid: cur = " + jSf + ",totalBytes =" + this.b + ",fileLength=" + length);
                return false;
            }
            if (length > 0 && jSf > 0) {
                long j2 = this.b;
                if (j2 > 0 && this.qd > 0 && length >= jSf && length <= j2 && jSf < j2) {
                    return true;
                }
            }
            com.ss.android.socialbase.downloader.m.z.a("DownloadInfo", "isFileDataValid: cur = " + jSf + ",totalBytes =" + this.b + ",fileLength=" + length);
        }
        return false;
    }

    public boolean mt() {
        com.ss.android.socialbase.downloader.downloader.wp wpVarIo;
        if (this.qd > 1 && (wpVarIo = com.ss.android.socialbase.downloader.downloader.dl.io()) != null) {
            List<g> listDl = wpVarIo.dl(e());
            if (listDl == null || listDl.size() != this.qd) {
                return false;
            }
            long jPf = 0;
            for (g gVar : listDl) {
                if (gVar != null) {
                    jPf += gVar.pf();
                }
            }
            if (jPf != sf()) {
                gc(jPf);
            }
        }
        return true;
    }

    public void v(boolean z2) {
        this.yt = z2;
    }

    public boolean um() {
        if (bp()) {
            return mt();
        }
        return false;
    }

    public boolean ey() {
        return (!this.rv || TextUtils.isEmpty(wp()) || TextUtils.isEmpty(i()) || new File(wp(), i()).exists()) ? false : true;
    }

    public int xt() {
        return com.ss.android.socialbase.downloader.pf.m.z(kb(), gz(), this.uf);
    }

    public boolean re() {
        int iP = p();
        return iP == 4 || iP == 3 || iP == -1 || iP == 5 || iP == 8 || ((iP == 1 || iP == 2) && sf() > 0);
    }

    public boolean jt() {
        return p() == 0;
    }

    public int ux() {
        return this.qd;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.z);
        parcel.writeString(this.g);
        parcel.writeString(this.dl);
        parcel.writeString(this.f2065a);
        parcel.writeString(this.gc);
        parcel.writeString(this.m);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeString(this.gz);
        parcel.writeTypedList(this.fo);
        parcel.writeInt(this.uy);
        parcel.writeStringArray(this.kb);
        parcel.writeIntArray(this.wp);
        parcel.writeInt(this.i);
        parcel.writeInt(this.v);
        parcel.writeByte(this.pf ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.ls ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.p);
        parcel.writeInt(this.fv);
        parcel.writeStringList(this.js);
        parcel.writeByte(this.tb ? (byte) 1 : (byte) 0);
        parcel.writeString(this.q);
        parcel.writeByte(this.iq ? (byte) 1 : (byte) 0);
        parcel.writeString(this.zw);
        parcel.writeString(this.uf);
        parcel.writeByte(this.hh ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.gk ? (byte) 1 : (byte) 0);
        parcel.writeString(this.l);
        parcel.writeString(this.x);
        parcel.writeInt(this.lq);
        parcel.writeInt(this.mc.ordinal());
        parcel.writeByte(this.un ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.jq ? (byte) 1 : (byte) 0);
        parcel.writeString(this.sv);
        parcel.writeInt(this.f);
        parcel.writeInt(this.yx);
        parcel.writeInt(this.qd);
        parcel.writeLong(sf());
        parcel.writeLong(this.b);
        parcel.writeInt(zw());
        parcel.writeLong(this.me);
        parcel.writeLong(this.nh);
        parcel.writeByte(this.r ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.yz ? (byte) 1 : (byte) 0);
        StringBuffer stringBuffer = this.tf;
        parcel.writeString(stringBuffer != null ? stringBuffer.toString() : "");
        parcel.writeByte(this.wn ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.nb ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.zz ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.vo);
        parcel.writeByte(this.wj ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.u.ordinal());
        parcel.writeByte(this.eo ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.yw);
        parcel.writeString(this.s);
        parcel.writeByte(this.ly ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.hn ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.cb ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.o ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.yt ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.xo, i);
        parcel.writeInt(this.xf);
        parcel.writeString(zr());
        parcel.writeByte(this.na ? (byte) 1 : (byte) 0);
        parcel.writeString(this.xl);
        parcel.writeInt(this.wo);
        parcel.writeString(this.j);
        parcel.writeByte(this.y ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.ec ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.bv ? (byte) 1 : (byte) 0);
    }

    public com.ss.android.socialbase.downloader.gc.z gd() {
        return this.xo;
    }

    public void z(com.ss.android.socialbase.downloader.gc.z zVar) {
        this.xo = zVar;
    }

    private void mz() {
        if (this.bw == null) {
            Context contextXl = com.ss.android.socialbase.downloader.downloader.dl.xl();
            if (contextXl != null) {
                String string = com.bytedance.sdk.openadsdk.api.plugin.g.g(contextXl, "sp_download_info", 0).getString(Long.toString(e()), "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.bw = new JSONObject(string);
                    } catch (JSONException e) {
                        wp.z(e);
                    }
                }
            }
            if (this.bw == null) {
                this.bw = new JSONObject();
            }
        }
    }

    public void zt() {
        Context contextXl;
        if (this.bw == null || (contextXl = com.ss.android.socialbase.downloader.downloader.dl.xl()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.api.plugin.g.g(contextXl, "sp_download_info", 0).edit().putString(Integer.toString(e()), this.bw.toString()).apply();
    }

    public int to() {
        mz();
        return this.bw.optInt("failed_resume_count", 0);
    }

    public void kb(int i) {
        mz();
        try {
            this.bw.put("failed_resume_count", i);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public long lz() {
        mz();
        return this.bw.optLong("last_failed_resume_time", 0L);
    }

    public void fo(long j) {
        mz();
        try {
            this.bw.put("last_failed_resume_time", j);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public int jh() {
        mz();
        return this.bw.optInt("unins_resume_count", 0);
    }

    public void wp(int i) {
        mz();
        try {
            this.bw.put("unins_resume_count", i);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public long fq() {
        mz();
        return this.bw.optLong("last_unins_resume_time", 0L);
    }

    public void uy(long j) {
        mz();
        try {
            this.bw.put("last_unins_resume_time", j);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public int i(String str) {
        mz();
        return this.bw.optInt(str, 0);
    }

    public void z(String str, String str2) {
        mz();
        try {
            this.bw.put(str, str2);
            zt();
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public long rw() {
        st();
        return this.gy.optLong("dbjson_last_start_download_time", 0L);
    }

    public int i(int i) {
        st();
        return this.gy.optInt("anti_hijack_error_code", i);
    }

    public void v(int i) {
        z("anti_hijack_error_code", Integer.valueOf(i));
    }

    public boolean gl() {
        st();
        return this.gy.optBoolean("is_save_path_redirected", false);
    }

    public void pf(boolean z2) {
        z("is_save_path_redirected", Boolean.valueOf(z2));
    }

    public String toString() {
        return "DownloadInfo{id=" + this.z + ", name='" + this.g + "', title='" + this.dl + "', url='" + this.f2065a + "', savePath='" + this.gc + "'}";
    }

    public int po() {
        st();
        return this.gy.optInt("dbjson_key_preconnect_level", 0);
    }

    public void pf(int i) {
        st();
        z("dbjson_key_preconnect_level", Integer.valueOf(i));
    }

    private void ts() {
        if (this.zb == null) {
            synchronized (this) {
                if (this.zb == null) {
                    this.zb = new ConcurrentHashMap<>();
                }
            }
        }
    }

    public ConcurrentHashMap<String, Object> rg() {
        ts();
        return this.zb;
    }

    public int fs() {
        st();
        return this.gy.optInt("executor_group", 2);
    }

    public String v(String str) {
        st();
        return this.gy.optString(str);
    }

    public void kb(long j) {
        this.k = j;
    }

    public boolean ib() {
        return this.wx;
    }

    public long ep() {
        return this.k;
    }

    public int ry() {
        return this.zd;
    }

    public void ls(int i) {
        this.zd = i;
    }

    public void z(PackageInfo packageInfo) {
        this.hy = new SoftReference<>(packageInfo);
    }

    public PackageInfo ct() {
        SoftReference<PackageInfo> softReference = this.hy;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public double w() {
        double dSf = sf() / 1048576.0d;
        double dBb = bb() / 1000.0d;
        if (dSf <= 0.0d || dBb <= 0.0d) {
            return -1.0d;
        }
        return dSf / dBb;
    }

    public long cn() {
        return this.lt;
    }

    public int ka() {
        mz();
        return this.bw.optInt("paused_resume_count", 0);
    }

    public void p(int i) {
        mz();
        try {
            this.bw.put("paused_resume_count", i);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f2066a;
        private boolean bv;
        private String dl;
        private String e;
        private int ec;
        private boolean eo;
        private String f;
        private int fo;
        private List<String> fv;
        private String g;
        private boolean gb;
        private String gc;
        private boolean gk;
        private JSONObject gp;
        private List<gc> gz;
        private long h;
        private String hh;
        private int i;
        private boolean io;
        private boolean iq;
        private boolean j;
        private long jq;
        private boolean js;
        private int[] kb;
        private String l;
        private boolean lq;
        private int ls;
        private boolean m;
        private boolean mc;
        private long na;
        private boolean oq;
        private int p;
        private String q;
        private boolean sv;
        private boolean sy;
        private boolean ti;
        private String[] uy;
        private boolean v;
        private String vm;
        private String wj;
        private int wp;
        private String x;
        private boolean xl;
        private int[] y;
        private String z;
        private boolean zw;
        private boolean pf = true;
        private boolean tb = true;
        private boolean uf = true;
        private com.ss.android.socialbase.downloader.g.e un = com.ss.android.socialbase.downloader.g.e.ENQUEUE_NONE;
        private boolean t = true;

        public z() {
        }

        public z(String str) {
            this.dl = str;
        }

        public z z(String str) {
            this.z = str;
            return this;
        }

        public z g(String str) {
            this.g = str;
            return this;
        }

        public z dl(String str) {
            this.dl = str;
            return this;
        }

        public z a(String str) {
            this.f = str;
            return this;
        }

        public z gc(String str) {
            this.f2066a = str;
            return this;
        }

        public z m(String str) {
            this.e = str;
            return this;
        }

        public z z(boolean z) {
            this.m = z;
            return this;
        }

        public z z(List<gc> list) {
            this.gz = list;
            return this;
        }

        public z z(int i) {
            this.wp = i;
            return this;
        }

        public z g(int i) {
            this.i = i;
            return this;
        }

        public z g(boolean z) {
            this.v = z;
            return this;
        }

        public z dl(int i) {
            this.ls = i;
            return this;
        }

        public z a(int i) {
            this.p = i;
            return this;
        }

        public z g(List<String> list) {
            this.fv = list;
            return this;
        }

        public z e(String str) {
            this.q = str;
            return this;
        }

        public z dl(boolean z) {
            this.iq = z;
            return this;
        }

        public z a(boolean z) {
            this.js = z;
            return this;
        }

        public z gc(boolean z) {
            this.zw = z;
            return this;
        }

        public z m(boolean z) {
            this.io = z;
            return this;
        }

        public z e(boolean z) {
            this.uf = z;
            return this;
        }

        public z gz(boolean z) {
            this.sy = z;
            return this;
        }

        public z gz(String str) {
            this.hh = str;
            return this;
        }

        public z fo(String str) {
            this.l = str;
            return this;
        }

        public z z(long j) {
            this.h = j;
            return this;
        }

        public z fo(boolean z) {
            this.gk = z;
            return this;
        }

        public z uy(String str) {
            this.x = str;
            return this;
        }

        public z uy(boolean z) {
            this.lq = z;
            return this;
        }

        public z kb(boolean z) {
            this.mc = z;
            return this;
        }

        public z z(com.ss.android.socialbase.downloader.g.e eVar) {
            this.un = eVar;
            return this;
        }

        public z wp(boolean z) {
            this.ti = z;
            return this;
        }

        public z i(boolean z) {
            this.oq = z;
            return this;
        }

        public z z(JSONObject jSONObject) {
            this.gp = jSONObject;
            return this;
        }

        public z v(boolean z) {
            this.t = z;
            return this;
        }

        public z kb(String str) {
            this.vm = str;
            return this;
        }

        public z z(int[] iArr) {
            this.y = iArr;
            return this;
        }

        public z wp(String str) {
            this.wj = str;
            return this;
        }

        public z gc(int i) {
            this.ec = i;
            return this;
        }

        public z g(long j) {
            this.na = j;
            return this;
        }

        public z pf(boolean z) {
            this.sv = z;
            return this;
        }

        public z ls(boolean z) {
            this.tb = z;
            return this;
        }

        public dl z() {
            return new dl(this);
        }
    }
}
