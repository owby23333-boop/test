package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.antibrush.AntiBrush;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.flowcontrol.FlowControl;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.q;
import com.taobao.accs.utl.t;
import com.tencent.smtt.sdk.TbsListener;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledFuture;
import java.util.zip.GZIPInputStream;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected TrafficsMonitor f18172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FlowControl f18173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AntiBrush f18174e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Context f18178i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.taobao.accs.ut.a.d f18179j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Message f18180k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.taobao.accs.net.b f18181l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f18182m;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ConcurrentMap<Message.Id, Message> f18176g = new ConcurrentHashMap();
    public ConcurrentMap<String, ScheduledFuture<?>> a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f18177h = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f18175f = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private LinkedHashMap<String, String> f18183n = new LinkedHashMap<String, String>() { // from class: com.taobao.accs.data.MessageHandler$1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, String> entry) {
            return size() > 50;
        }
    };

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Map<String, a> f18184o = new HashMap();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Runnable f18185p = new f(this);

    public d(Context context, com.taobao.accs.net.b bVar) {
        String str;
        this.f18182m = "MsgRecv_";
        this.f18178i = context;
        this.f18181l = bVar;
        this.f18172c = new TrafficsMonitor(this.f18178i);
        this.f18173d = new FlowControl(this.f18178i);
        this.f18174e = new AntiBrush(this.f18178i);
        if (bVar == null) {
            str = this.f18182m;
        } else {
            str = this.f18182m + bVar.f18210m;
        }
        this.f18182m = str;
        i();
        h();
    }

    private boolean b(int i2) {
        return i2 == -1 || i2 == -9 || i2 == -10 || i2 == -11;
    }

    private void i() {
        try {
            File file = new File(this.f18178i.getDir("accs", 0), "message" + this.f18181l.i());
            if (!file.exists()) {
                ALog.d(this.f18182m, "message file not exist", new Object[0]);
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return;
                }
                this.f18183n.put(line, line);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void j() {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.f18178i.getDir("accs", 0), "message" + this.f18181l.i()));
            fileWriter.write("");
            Iterator<String> it = this.f18183n.keySet().iterator();
            while (it.hasNext()) {
                fileWriter.append((CharSequence) it.next()).append((CharSequence) "\r\n");
            }
            fileWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void a(byte[] bArr) throws IOException {
        a(bArr, (String) null);
    }

    public void b() {
        ALog.d(this.f18182m, "onRcvPing", new Object[0]);
        synchronized (d.class) {
            this.f18177h = false;
        }
    }

    public boolean c() {
        return this.f18177h;
    }

    public int d() {
        return this.f18176g.size();
    }

    public Collection<Message> e() {
        return this.f18176g.values();
    }

    public Set<Message.Id> f() {
        return this.f18176g.keySet();
    }

    public com.taobao.accs.ut.a.d g() {
        return this.f18179j;
    }

    public void h() {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(this.f18185p);
        } catch (Throwable th) {
            ALog.e(this.f18182m, "restoreTraffics", th, new Object[0]);
        }
    }

    private boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f18183n.containsKey(str);
    }

    private void d(String str) {
        if (TextUtils.isEmpty(str) || this.f18183n.containsKey(str)) {
            return;
        }
        this.f18183n.put(str, str);
        j();
    }

    public void a(byte[] bArr, String str) throws IOException {
        int i2;
        int i3;
        int iB;
        int length;
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(this.f18182m, "onMessage", Constants.KEY_HOST, str);
        }
        t tVar = new t(bArr);
        try {
            int iA = tVar.a();
            i2 = (iA & TbsListener.ErrorCode.TPATCH_VERSION_FAILED) >> 4;
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.f18182m, "version:" + i2, new Object[0]);
            }
            i3 = iA & 15;
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.f18182m, "compress:" + i3, new Object[0]);
            }
            tVar.a();
            iB = tVar.b();
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.f18182m, "totalLen:" + iB, new Object[0]);
            }
            length = 0;
        } finally {
            try {
            } finally {
            }
        }
        while (length < iB) {
            int iB2 = tVar.b();
            int i4 = length + 2;
            if (iB2 <= 0) {
                throw new IOException("data format error");
            }
            byte[] bArr2 = new byte[iB2];
            tVar.read(bArr2);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.f18182m, "buf len:" + bArr2.length, new Object[0]);
            }
            length = i4 + bArr2.length;
            a(i3, bArr2, str, i2);
        }
    }

    private Intent c(Message message) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(message.f18152m);
        intent.putExtra("command", message.command);
        intent.putExtra(Constants.KEY_SERVICE_ID, message.serviceId);
        intent.putExtra(Constants.KEY_USER_ID, message.userinfo);
        Integer num = message.command;
        if (num != null && num.intValue() == 100) {
            intent.putExtra(Constants.KEY_DATA_ID, message.cunstomDataId);
        }
        NetPerformanceMonitor netPerformanceMonitor = message.G;
        if (netPerformanceMonitor != null) {
            intent.putExtra(Constants.KEY_MONIROT, netPerformanceMonitor);
        }
        return intent;
    }

    public void b(Message message) {
        if (this.f18176g.keySet().size() > 0) {
            Iterator<Message.Id> it = this.f18176g.keySet().iterator();
            while (it.hasNext()) {
                Message message2 = this.f18176g.get(it.next());
                if (message2 != null && message2.command != null && message2.getPackageName().equals(message.getPackageName())) {
                    switch (message.command.intValue()) {
                        case 1:
                        case 2:
                            if (message2.command.intValue() == 1 || message2.command.intValue() == 2) {
                                message2.isCancel = true;
                            }
                            break;
                        case 3:
                        case 4:
                            if (message2.command.intValue() == 3 || message2.command.intValue() == 4) {
                                message2.isCancel = true;
                            }
                            break;
                        case 5:
                        case 6:
                            if (message2.command.intValue() == 5 || message2.command.intValue() == 6) {
                                message2.isCancel = true;
                            }
                            break;
                    }
                }
                if (message2 != null && message2.isCancel) {
                    ALog.e(this.f18182m, "cancelControlMessage", "command", message2.command);
                }
            }
        }
    }

    public Message b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f18176g.remove(new Message.Id(0, str));
    }

    private void b(Message message, int i2) {
        if (message == null) {
            return;
        }
        String strK = UtilityImpl.k(this.f18178i);
        String str = System.currentTimeMillis() + "";
        boolean z2 = i2 == 200;
        int iIntValue = message.command.intValue();
        if (iIntValue == 1) {
            com.taobao.accs.ut.a.a aVar = new com.taobao.accs.ut.a.a();
            aVar.a = strK;
            aVar.b = str;
            aVar.f18256c = z2;
            aVar.a(i2);
            aVar.a();
            return;
        }
        if (iIntValue != 3) {
            return;
        }
        com.taobao.accs.ut.a.b bVar = new com.taobao.accs.ut.a.b();
        bVar.a = strK;
        bVar.b = str;
        bVar.f18260c = z2;
        bVar.f18262e = message.userinfo;
        bVar.a(i2);
        bVar.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r41v0, types: [com.taobao.accs.data.d] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v47 */
    /* JADX WARN: Type inference failed for: r5v48 */
    /* JADX WARN: Type inference failed for: r5v49 */
    /* JADX WARN: Type inference failed for: r5v50 */
    /* JADX WARN: Type inference failed for: r5v51 */
    /* JADX WARN: Type inference failed for: r5v9 */
    private void a(int i2, byte[] bArr, String str, int i3) throws JSONException, IOException {
        String str2;
        Map<Integer, String> map;
        byte[] bArr2;
        boolean z2;
        ?? r5;
        String str3;
        String str4;
        Map<Integer, String> map2;
        String str5;
        boolean z3;
        int i4;
        int i5;
        byte[] bArr3;
        Message.ReqType reqType;
        String str6;
        int i6;
        String str7;
        Map<Integer, String> map3;
        Object obj;
        ?? r52;
        Message.ReqType reqType2;
        byte[] bArr4;
        ?? r53;
        Message.ReqType reqType3;
        byte[] bArrA;
        String str8;
        String str9;
        long j2;
        String str10;
        String str11;
        Map<Integer, String> map4;
        long j3;
        String str12;
        int i7;
        Message.ReqType reqType4;
        String str13;
        boolean z4;
        Map<Integer, String> map5;
        byte[] bArrC;
        t tVar = new t(bArr);
        long jB = tVar.b();
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(this.f18182m, "flag:" + Integer.toHexString((int) jB), new Object[0]);
        }
        String strA = tVar.a(tVar.a());
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(this.f18182m, "target:" + strA, new Object[0]);
        }
        String strA2 = tVar.a(tVar.a());
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(this.f18182m, "source:" + strA2, new Object[0]);
        }
        try {
            String strA3 = tVar.a(tVar.a());
            if (ALog.isPrintLog(ALog.Level.D)) {
                str2 = BaseMonitor.ALARM_POINT_REQ_ERROR;
                ALog.d(this.f18182m, "dataId:" + strA3, new Object[0]);
            } else {
                str2 = BaseMonitor.ALARM_POINT_REQ_ERROR;
            }
            if (!strA2.contains(Constants.TARGET_SERVICE_ST) && !strA2.contains(Constants.TARGET_FORE) && !strA2.contains(Constants.TARGET_BACK)) {
                String str14 = strA2 + strA3;
                if (tVar.available() > 0) {
                    if (i3 == 2) {
                        Map<Integer, String> mapA = a(tVar);
                        if (mapA != null && mapA.containsKey(16) && mapA.containsKey(17)) {
                            map5 = mapA;
                            z4 = true;
                        } else {
                            map5 = mapA;
                            z4 = false;
                        }
                    } else {
                        z4 = false;
                        map5 = null;
                    }
                    if (i2 == 0 || z4) {
                        bArrC = tVar.c();
                    } else if (i2 == 1) {
                        bArrC = a(tVar);
                    } else {
                        z2 = z4;
                        map = map5;
                        bArr2 = null;
                    }
                    byte[] bArr5 = bArrC;
                    z2 = z4;
                    map = map5;
                    bArr2 = bArr5;
                } else {
                    map = null;
                    bArr2 = null;
                    z2 = false;
                }
                tVar.close();
                try {
                    if (bArr2 == null) {
                        map2 = map;
                        str5 = strA2;
                        ALog.d(this.f18182m, "oriData is null", new Object[0]);
                    } else {
                        map2 = map;
                        str5 = strA2;
                        if (ALog.isPrintLog(ALog.Level.D)) {
                            ALog.d(this.f18182m, "oriData:" + String.valueOf(bArr2), new Object[0]);
                        }
                    }
                    int iValueOf = Message.MsgType.valueOf((int) ((jB >> 15) & 1));
                    Message.ReqType reqTypeValueOf = Message.ReqType.valueOf((int) ((jB >> 13) & 3));
                    int i8 = (int) ((jB >> 12) & 1);
                    try {
                        int iValueOf2 = Message.MsgResType.valueOf((int) ((jB >> 11) & 1));
                        boolean z5 = ((int) ((jB >> 6) & 1)) == 1;
                        if (ALog.isPrintLog(ALog.Level.I) || strA.contains("accs-impaas")) {
                            z3 = z5;
                            ALog.e(this.f18182m, "handleMessage", Constants.KEY_DATA_ID, strA3, "type", Message.MsgType.name(iValueOf), "reqType", reqTypeValueOf.name(), "resType", Message.MsgResType.name(iValueOf2), Constants.KEY_TARGET, strA);
                            i4 = iValueOf;
                            i5 = 1;
                        } else {
                            z3 = z5;
                            i4 = iValueOf;
                            i5 = 1;
                        }
                        if (i4 == i5 && (reqTypeValueOf == Message.ReqType.ACK || reqTypeValueOf == Message.ReqType.RES)) {
                            Message messageRemove = this.f18176g.remove(new Message.Id(0, strA3));
                            if (messageRemove != null) {
                                if (ALog.isPrintLog(ALog.Level.D)) {
                                    str12 = strA3;
                                    i6 = iValueOf2;
                                    ALog.d(this.f18182m, "handleMessage reqMessage not null", new Object[0]);
                                } else {
                                    str12 = strA3;
                                    i6 = iValueOf2;
                                }
                                if (i8 == 1) {
                                    try {
                                        i7 = new JSONObject(new String(bArr2)).getInt("code");
                                    } catch (Exception unused) {
                                        i7 = -3;
                                    }
                                } else {
                                    i7 = 200;
                                }
                                if (messageRemove.getNetPermanceMonitor() != null) {
                                    messageRemove.getNetPermanceMonitor().onRecAck();
                                }
                                if (reqTypeValueOf == Message.ReqType.RES) {
                                    map3 = map2;
                                    byte[] bArr6 = bArr2;
                                    obj = Constants.KEY_TARGET;
                                    str13 = str12;
                                    reqType4 = reqTypeValueOf;
                                    str7 = str5;
                                    bArr3 = bArr6;
                                    str6 = strA;
                                    a(messageRemove, i7, reqTypeValueOf, bArr6, map3);
                                } else {
                                    map3 = map2;
                                    bArr3 = bArr2;
                                    reqType4 = reqTypeValueOf;
                                    obj = Constants.KEY_TARGET;
                                    str7 = str5;
                                    str6 = strA;
                                    str13 = str12;
                                    a(messageRemove, i7, map3);
                                }
                                String str15 = messageRemove.serviceId;
                                boolean zIsAppBackground = GlobalAppRuntimeInfo.isAppBackground();
                                long length = bArr.length;
                                a(new TrafficsMonitor.a(str15, zIsAppBackground, str, length));
                                str3 = str13;
                                r52 = length;
                                reqType = reqType4;
                            } else {
                                bArr3 = bArr2;
                                reqType = reqTypeValueOf;
                                i6 = iValueOf2;
                                str7 = str5;
                                str6 = strA;
                                map3 = map2;
                                obj = Constants.KEY_TARGET;
                                str3 = strA3;
                                ALog.e(this.f18182m, "handleMessage data ack/res reqMessage is null", Constants.KEY_DATA_ID, str3);
                                r52 = reqTypeValueOf;
                            }
                        } else {
                            bArr3 = bArr2;
                            reqType = reqTypeValueOf;
                            str6 = strA;
                            i6 = iValueOf2;
                            str7 = str5;
                            map3 = map2;
                            str3 = strA3;
                            obj = Constants.KEY_TARGET;
                            r52 = reqTypeValueOf;
                        }
                        if (i4 == 0) {
                            Message.ReqType reqType5 = reqType;
                            reqType2 = reqType5;
                            if (reqType5 == Message.ReqType.RES) {
                                Message messageRemove2 = this.f18176g.remove(new Message.Id(0, str3));
                                if (messageRemove2 != null) {
                                    a(messageRemove2, bArr3, bArr, str);
                                    return;
                                }
                                bArr4 = bArr3;
                                String str16 = this.f18182m;
                                Object[] objArr = {Constants.KEY_DATA_ID, str3};
                                ALog.e(str16, "handleMessage contorl ACK reqMessage is null", objArr);
                                reqType3 = reqType5;
                                r53 = objArr;
                                if (ALog.isPrintLog(ALog.Level.D)) {
                                    String str17 = this.f18182m;
                                    Object[] objArr2 = {AgooConstants.MESSAGE_BODY, new String(bArr4)};
                                    ALog.d(str17, "handleMessage not handled", objArr2);
                                    reqType3 = reqType5;
                                    r53 = objArr2;
                                }
                            }
                            if (i4 == 1 || reqType3 != Message.ReqType.DATA) {
                            }
                            String str18 = str6;
                            if (str18 == null) {
                                ALog.e(this.f18182m, "handleMessage target is null", new Object[0]);
                                return;
                            }
                            String[] strArrSplit = str18.split("\\|");
                            if (strArrSplit.length < 2) {
                                ALog.e(this.f18182m, "handleMessage target length is invalid", new Object[0]);
                                return;
                            }
                            r5 = r53;
                            if (ALog.isPrintLog(ALog.Level.D)) {
                                String str19 = this.f18182m;
                                Object[] objArr3 = {"isBurstData", Boolean.valueOf(z2)};
                                ALog.d(str19, "handleMessage onPush", objArr3);
                                r5 = objArr3;
                            }
                            if (this.f18179j != null) {
                                this.f18179j.a();
                            }
                            this.f18179j = new com.taobao.accs.ut.a.d();
                            this.f18179j.f18274c = String.valueOf(System.currentTimeMillis());
                            Context context = this.f18178i;
                            str4 = strArrSplit[1];
                            try {
                                if (UtilityImpl.a(context, str4)) {
                                    String str20 = strArrSplit.length >= 3 ? strArrSplit[2] : null;
                                    this.f18179j.f18276e = str20;
                                    if (c(str14)) {
                                        ALog.e(this.f18182m, "handleMessage msg duplicate", Constants.KEY_DATA_ID, str3);
                                        this.f18179j.f18279h = true;
                                        map4 = map3;
                                        j3 = jB;
                                        str11 = "";
                                        str8 = "accs";
                                    } else {
                                        if (z2) {
                                            bArrA = a(str14, map3, bArr4);
                                            if (bArrA == null) {
                                                ALog.e(this.f18182m, "handleMessage completeOriData is null", new Object[0]);
                                                return;
                                            } else if (i2 == 1) {
                                                t tVar2 = new t(bArrA);
                                                bArrA = a(tVar2);
                                                if (ALog.isPrintLog(ALog.Level.D)) {
                                                    ALog.d(this.f18182m, "handleMessage gzip completeOriData", Constants.KEY_DATA_ID, str14, "length", Integer.valueOf(bArrA.length));
                                                }
                                                tVar2.close();
                                            }
                                        } else {
                                            bArrA = bArr4;
                                        }
                                        d(str14);
                                        str8 = "accs";
                                        try {
                                            if (str8.equals(str20)) {
                                                ALog.e(this.f18182m, "handleMessage try deliverMsg", Constants.KEY_DATA_ID, str3, obj, strArrSplit[1], Constants.KEY_SERVICE_ID, str20);
                                            } else if (ALog.isPrintLog(ALog.Level.I)) {
                                                ALog.i(this.f18182m, "handleMessage try deliverMsg", Constants.KEY_DATA_ID, str3, obj, strArrSplit[1], Constants.KEY_SERVICE_ID, str20);
                                            }
                                            Intent intent = new Intent(Constants.ACTION_RECEIVE);
                                            intent.setPackage(strArrSplit[1]);
                                            intent.putExtra("command", 101);
                                            if (strArrSplit.length >= 3) {
                                                intent.putExtra(Constants.KEY_SERVICE_ID, strArrSplit[2]);
                                            }
                                            if (strArrSplit.length >= 4) {
                                                str9 = strArrSplit[3];
                                                intent.putExtra(Constants.KEY_USER_ID, str9);
                                            } else {
                                                str9 = "";
                                            }
                                            intent.putExtra("data", bArrA);
                                            intent.putExtra(Constants.KEY_DATA_ID, str3);
                                            intent.putExtra("packageName", this.f18178i.getPackageName());
                                            intent.putExtra(Constants.KEY_HOST, str);
                                            intent.putExtra(Constants.KEY_CONN_TYPE, this.b);
                                            boolean z6 = z3;
                                            intent.putExtra(Constants.KEY_NEED_BUSINESS_ACK, z6);
                                            intent.putExtra(Constants.KEY_APP_KEY, this.f18181l.i());
                                            intent.putExtra(Constants.KEY_CONFIG_TAG, this.f18181l.f18210m);
                                            NetPerformanceMonitor netPerformanceMonitor = new NetPerformanceMonitor();
                                            netPerformanceMonitor.setMsgType(4);
                                            netPerformanceMonitor.onReceiveData();
                                            intent.putExtra(Constants.KEY_MONIROT, netPerformanceMonitor);
                                            a(map3, intent);
                                            if (z6) {
                                                j2 = jB;
                                                z3 = z6;
                                                str10 = str7;
                                                a(intent, str10, str18, (short) j2);
                                            } else {
                                                z3 = z6;
                                                j2 = jB;
                                                str10 = str7;
                                            }
                                            long j4 = j2;
                                            g.a().b(this.f18178i, intent);
                                            UTMini.getInstance().commitEvent(66001, "MsgToBussPush", "commandId=101", "serviceId=" + str20 + " dataId=" + str3, 221);
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("1commandId=101serviceId=");
                                            sb.append(str20);
                                            com.taobao.accs.utl.k.a(str8, BaseMonitor.COUNT_POINT_TO_BUSS, sb.toString(), PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                                            this.f18179j.b = str3;
                                            this.f18179j.f18280i = str9;
                                            com.taobao.accs.ut.a.d dVar = this.f18179j;
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append(bArrA == null ? 0 : bArrA.length);
                                            try {
                                                sb2.append("");
                                                dVar.f18277f = sb2.toString();
                                                this.f18179j.a = UtilityImpl.k(this.f18178i);
                                                this.f18179j.f18275d = String.valueOf(System.currentTimeMillis());
                                                str11 = "";
                                                str7 = str10;
                                                map4 = map3;
                                                j3 = j4;
                                            } catch (Exception e2) {
                                                e = e2;
                                                str3 = "";
                                                r5 = str8;
                                                str4 = str2;
                                                ALog.e(this.f18182m, "handleMessage", e, new Object[0]);
                                                com.taobao.accs.utl.k.a(r5, str4, str3, "1", this.b + e.toString());
                                                return;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            r5 = str8;
                                            str4 = str2;
                                            str3 = "";
                                            ALog.e(this.f18182m, "handleMessage", e, new Object[0]);
                                            com.taobao.accs.utl.k.a(r5, str4, str3, "1", this.b + e.toString());
                                            return;
                                        }
                                        try {
                                            a(new TrafficsMonitor.a(str20, GlobalAppRuntimeInfo.isAppBackground(), str, bArr.length));
                                        } catch (Exception e4) {
                                            e = e4;
                                            r5 = str8;
                                            str4 = str2;
                                            str3 = str11;
                                            ALog.e(this.f18182m, "handleMessage", e, new Object[0]);
                                            com.taobao.accs.utl.k.a(r5, str4, str3, "1", this.b + e.toString());
                                            return;
                                        }
                                    }
                                    if (i6 != 1) {
                                        return;
                                    }
                                    if (!str8.equals(str20) && !"accs-impaas".equals(str20)) {
                                        ALog.i(this.f18182m, "handleMessage try sendAck dataId", Constants.KEY_DATA_ID, str3);
                                    } else {
                                        ALog.e(this.f18182m, "handleMessage try sendAck dataId", Constants.KEY_DATA_ID, str3);
                                    }
                                    boolean z7 = z3;
                                    String str21 = str8;
                                    String str22 = str3;
                                    str3 = str11;
                                    String str23 = str20;
                                    str4 = str2;
                                    Message messageBuildPushAck = Message.buildPushAck(this.f18181l.b((String) null), this.f18181l.d(), str18, str7, str22, false, (short) j3, str, map4);
                                    this.f18181l.b(messageBuildPushAck, true);
                                    a(messageBuildPushAck.dataId, str23);
                                    r5 = str21;
                                    if (z7) {
                                        com.taobao.accs.utl.k.a(str21, BaseMonitor.COUNT_ACK, str3, PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                                        r5 = str21;
                                    }
                                } else {
                                    str4 = str2;
                                    str3 = "";
                                    r5 = "accs";
                                    ALog.e(this.f18182m, "handleMessage not exist, unbind it", Constants.KEY_PACKAGE, strArrSplit[1]);
                                    this.f18181l.b(Message.buildUnbindApp(this.f18181l.b((String) null), strArrSplit[1]), true);
                                }
                                return;
                            } catch (Exception e5) {
                                e = e5;
                            }
                        } else {
                            reqType2 = reqType;
                        }
                        bArr4 = bArr3;
                        reqType3 = reqType2;
                        r53 = r52;
                        if (i4 == 1) {
                        }
                    } catch (Exception e6) {
                        e = e6;
                        str4 = str2;
                        str3 = "";
                        r5 = "accs";
                    }
                } catch (Exception e7) {
                    e = e7;
                    r5 = "accs";
                    str3 = "";
                }
            } else {
                ALog.e(this.f18182m, "ignore source 4|sal|sg/fg/bg message dataId:" + strA3, new Object[0]);
                this.f18176g.remove(new Message.Id(0, strA3));
            }
        } catch (Exception e8) {
            ALog.e(this.f18182m, "dataId read error " + e8.toString(), new Object[0]);
            tVar.close();
            com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", this.b + "data id read error" + e8.toString());
        }
    }

    private byte[] a(InputStream inputStream) throws IOException {
        byte[] bArr;
        if (inputStream == null) {
            return null;
        }
        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                bArr = new byte[8192];
            } catch (Throwable th) {
                try {
                    gZIPInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception unused) {
                }
                throw th;
            }
            while (true) {
                int i2 = gZIPInputStream.read(bArr);
                if (i2 <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception unused2) {
            }
            return byteArray;
        } catch (Exception e2) {
            ALog.e(this.f18182m, "uncompress data error " + e2.toString(), new Object[0]);
            com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", this.b + " uncompress data error " + e2.toString());
            try {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception unused3) {
            }
            return null;
        }
    }

    private void a(Message message, byte[] bArr, byte[] bArr2, String str) {
        JSONArray jSONArray;
        int i2 = -8;
        try {
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(this.f18182m, "handleControlMessage parse", "json", jSONObject.toString());
                }
                i2 = message.command.intValue() == 100 ? 200 : jSONObject.getInt("code");
                if (i2 == 200) {
                    int iIntValue = message.command.intValue();
                    if (iIntValue == 1) {
                        UtilityImpl.c(Constants.SP_FILE_NAME, this.f18178i);
                        try {
                            this.f18181l.j().a(this.f18178i.getPackageName());
                            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                            this.f18175f = q.a(jSONObject2, Constants.KEY_DEVICE_TOKEN, null);
                            if (jSONObject2 != null && (jSONArray = jSONObject2.getJSONArray(Constants.KEY_PACKAGE_NAMES)) != null) {
                                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                    String string = jSONArray.getString(i3);
                                    if (UtilityImpl.a(this.f18178i, string)) {
                                        this.f18181l.j().a(message.f18152m);
                                    } else {
                                        ALog.d(this.f18182m, "unbind app", "pkg", string);
                                        this.f18181l.b(Message.buildUnbindApp(this.f18181l.b((String) null), string), true);
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            ALog.i(this.f18182m, "no token/invalid app", th);
                        }
                    } else if (iIntValue == 2) {
                        this.f18181l.j().b(message.f18152m);
                    } else if (iIntValue == 3) {
                        this.f18181l.j().a(message.f18152m, message.userinfo);
                    } else if (iIntValue != 4) {
                        if (iIntValue == 100 && (this.f18181l instanceof com.taobao.accs.net.j) && "4|sal|accs-iot".equals(message.f18148i)) {
                            ((com.taobao.accs.net.j) this.f18181l).a(jSONObject);
                        }
                    } else {
                        this.f18181l.j().e(message.f18152m);
                    }
                } else if (message.command.intValue() == 3 && i2 == 300) {
                    this.f18181l.j().b(message.f18152m);
                }
            } catch (Throwable th2) {
                th = th2;
                ALog.e(this.f18182m, "handleControlMessage", th, new Object[0]);
                com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "handleControlMessage", "", this.b + th.toString());
            }
        } catch (Throwable th3) {
            th = th3;
        }
        a(message, i2, null, bArr, null);
        a(new TrafficsMonitor.a(message.serviceId, GlobalAppRuntimeInfo.isAppBackground(), str, bArr2.length));
    }

    private Map<Integer, String> a(t tVar) {
        HashMap map;
        if (tVar == null) {
            return null;
        }
        try {
            int iB = tVar.b();
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.f18182m, "extHeaderLen:" + iB, new Object[0]);
            }
            map = null;
            int i2 = 0;
            while (i2 < iB) {
                try {
                    int iB2 = tVar.b();
                    int i3 = (64512 & iB2) >> 10;
                    int i4 = iB2 & 1023;
                    String strA = tVar.a(i4);
                    i2 = i2 + 2 + i4;
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put(Integer.valueOf(i3), strA);
                    if (ALog.isPrintLog(ALog.Level.D)) {
                        ALog.d(this.f18182m, "", "extHeaderType", Integer.valueOf(i3), "value", strA);
                    }
                } catch (Exception e2) {
                    e = e2;
                    ALog.e(this.f18182m, "parseExtHeader", e, new Object[0]);
                    return map;
                }
            }
        } catch (Exception e3) {
            e = e3;
            map = null;
        }
        return map;
    }

    public void a(Message message, int i2) {
        a(message, i2, null, null, null);
    }

    public void a(Message message, int i2, Map<Integer, String> map) {
        a(message, i2, null, null, map);
    }

    public void a(Message message, int i2, Message.ReqType reqType, byte[] bArr, Map<Integer, String> map) {
        if (message.command != null && message.getType() >= 0 && message.getType() != 2) {
            String str = message.cunstomDataId;
            if (str != null) {
                this.a.remove(str);
            }
            if (this.f18174e.checkAntiBrush(message.host, map)) {
                i2 = ErrorCode.SERVIER_ANTI_BRUSH;
                reqType = null;
                bArr = null;
                map = null;
            }
            int iA = this.f18173d.a(map, message.serviceId);
            if (iA != 0) {
                i2 = iA == 2 ? ErrorCode.SERVIER_HIGH_LIMIT : iA == 3 ? ErrorCode.SERVIER_HIGH_LIMIT_BRUSH : ErrorCode.SERVIER_LOW_LIMIT;
                reqType = null;
                bArr = null;
                map = null;
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.f18182m, "onResult", "command", message.command, "erorcode", Integer.valueOf(i2));
            }
            if (message.command.intValue() == 102) {
                return;
            }
            if (!message.isCancel) {
                if (b(i2) && message.command.intValue() != 100 && message.retryTimes <= Message.CONTROL_MAX_RETRY_TIMES) {
                    message.startSendTime = System.currentTimeMillis();
                    message.retryTimes++;
                    ALog.d(this.f18182m, "onResult", "retryTimes", Integer.valueOf(message.retryTimes));
                    this.f18181l.b(message, true);
                    a(message, i2, true);
                } else {
                    a(message, i2, false);
                    Intent intentC = c(message);
                    intentC.putExtra("errorCode", i2);
                    Message.ReqType reqTypeValueOf = Message.ReqType.valueOf((message.f18145f >> 13) & 3);
                    if (reqType == Message.ReqType.RES || reqTypeValueOf == Message.ReqType.REQ) {
                        intentC.putExtra(Constants.KEY_SEND_TYPE, Constants.SEND_TYPE_RES);
                    }
                    if (i2 == 200) {
                        intentC.putExtra("data", bArr);
                    }
                    intentC.putExtra(Constants.KEY_APP_KEY, this.f18181l.b);
                    intentC.putExtra(Constants.KEY_CONFIG_TAG, this.f18181l.f18210m);
                    a(map, intentC);
                    g.a().b(this.f18178i, intentC);
                    if (!TextUtils.isEmpty(message.serviceId)) {
                        UTMini.getInstance().commitEvent(66001, "MsgToBuss0", "commandId=" + message.command, "serviceId=" + message.serviceId + " errorCode=" + i2 + " dataId=" + message.dataId, 221);
                        StringBuilder sb = new StringBuilder();
                        sb.append("1commandId=");
                        sb.append(message.command);
                        sb.append("serviceId=");
                        sb.append(message.serviceId);
                        com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_TO_BUSS, sb.toString(), PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                    }
                }
            } else {
                ALog.e(this.f18182m, "onResult message is cancel", "command", message.command);
                a(message, i2, true);
            }
            b(message, i2);
            return;
        }
        ALog.d(this.f18182m, "onError, skip ping/ack", new Object[0]);
    }

    private void a(Message message, int i2, boolean z2) {
        boolean z3;
        try {
            NetPerformanceMonitor netPermanceMonitor = message.getNetPermanceMonitor();
            if (netPermanceMonitor == null) {
                return;
            }
            netPermanceMonitor.onToBizDate();
            String string = message.host == null ? null : message.host.toString();
            if (i2 == 200) {
                z3 = true;
                if (message.retryTimes > 0) {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "succ", PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "succ_" + message.retryTimes, PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                } else {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQUEST, string);
                }
            } else {
                if (message.retryTimes > 0) {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "fail＿" + i2, PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "fail", PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                } else if (i2 != -13) {
                    com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_POINT_REQUEST, string, UtilityImpl.a(i2), this.b + message.serviceId + message.timeout);
                }
                netPermanceMonitor.setFailReason(i2);
                z3 = false;
            }
            netPermanceMonitor.setRet(z3);
            if (z2) {
                if (message.isCancel) {
                    netPermanceMonitor.setRet(false);
                    netPermanceMonitor.setFailReason("msg cancel");
                }
                AppMonitor.getInstance().commitStat(message.getNetPermanceMonitor());
            }
        } catch (Throwable th) {
            ALog.e(this.f18182m, "monitorPerf", th, new Object[0]);
        }
    }

    public void a() {
        ALog.d(this.f18182m, "onSendPing", new Object[0]);
        synchronized (d.class) {
            this.f18177h = true;
        }
    }

    public void a(Message message) {
        String str;
        Message message2 = this.f18180k;
        if (message2 != null && (str = message.cunstomDataId) != null && message.serviceId != null && message2.cunstomDataId.equals(str) && this.f18180k.serviceId.equals(message.serviceId)) {
            UTMini.getInstance().commitEvent(66001, "SEND_REPEAT", message.serviceId, message.cunstomDataId, Long.valueOf(Thread.currentThread().getId()));
        }
        if (message.getType() == -1 || message.getType() == 2 || message.isAck) {
            return;
        }
        this.f18176g.put(message.getMsgId(), message);
    }

    public void a(int i2) {
        this.f18177h = false;
        Message.Id[] idArr = (Message.Id[]) this.f18176g.keySet().toArray(new Message.Id[0]);
        if (idArr.length > 0) {
            ALog.d(this.f18182m, "onNetworkFail", new Object[0]);
            for (Message.Id id : idArr) {
                Message messageRemove = this.f18176g.remove(id);
                if (messageRemove != null) {
                    a(messageRemove, i2);
                }
            }
        }
    }

    public Message a(String str) {
        return this.f18176g.get(new Message.Id(0, str));
    }

    private byte[] a(String str, Map<Integer, String> map, byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    int i2 = Integer.parseInt(map.get(17));
                    int i3 = Integer.parseInt(map.get(16));
                    if (i3 <= 1) {
                        throw new RuntimeException("burstNums <= 1");
                    }
                    if (i2 >= 0 && i2 < i3) {
                        String str2 = map.get(18);
                        long j2 = 0;
                        try {
                            String str3 = map.get(15);
                            if (!TextUtils.isEmpty(str3)) {
                                j2 = Long.parseLong(str3);
                            }
                        } catch (Throwable th) {
                            ALog.w(this.f18182m, "putBurstMessage", th, new Object[0]);
                        }
                        a aVar = this.f18184o.get(str);
                        if (aVar == null) {
                            if (ALog.isPrintLog(ALog.Level.I)) {
                                ALog.i(this.f18182m, "putBurstMessage", Constants.KEY_DATA_ID, str, "burstLength", Integer.valueOf(i3));
                            }
                            aVar = new a(str, i3, str2);
                            aVar.a(j2);
                            this.f18184o.put(str, aVar);
                        }
                        return aVar.a(i2, i3, bArr);
                    }
                    throw new RuntimeException(String.format("burstNums:%s burstIndex:%s", Integer.valueOf(i3), Integer.valueOf(i2)));
                }
            } catch (Throwable th2) {
                ALog.w(this.f18182m, "putBurstMessage", th2, new Object[0]);
                return null;
            }
        }
        throw new RuntimeException("burstLength == 0");
    }

    private void a(Map<Integer, String> map, Intent intent) {
        if (map == null || intent == null) {
            return;
        }
        intent.putExtra(TaoBaseService.ExtraInfo.EXT_HEADER, (HashMap) map);
    }

    private void a(Intent intent, String str, String str2, short s2) {
        if (intent != null) {
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("source", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra(Constants.KEY_TARGET, str2);
            }
            intent.putExtra(Constants.KEY_FLAGS, s2);
        }
    }

    private void a(String str, String str2) {
        com.taobao.accs.ut.a.e eVar = new com.taobao.accs.ut.a.e();
        eVar.a = UtilityImpl.k(this.f18178i);
        eVar.f18283c = str;
        eVar.f18284d = "" + System.currentTimeMillis();
        eVar.f18286f = "";
        eVar.f18285e = str2;
        eVar.b = "";
        eVar.a();
    }

    public void a(TrafficsMonitor.a aVar) {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new e(this, aVar));
        } catch (Throwable th) {
            ALog.e(this.f18182m, "addTrafficsInfo", th, new Object[0]);
        }
    }
}
