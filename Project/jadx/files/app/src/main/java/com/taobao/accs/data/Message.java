package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.p;
import com.taobao.accs.utl.q;
import com.taobao.accs.utl.s;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class Message implements Serializable {
    public static int CONTROL_MAX_RETRY_TIMES = 5;
    public static final int EXT_HEADER_VALUE_MAX_LEN = 1023;
    public static final int FLAG_ACK_TYPE = 32;
    public static final int FLAG_BIZ_RET = 64;
    public static final int FLAG_DATA_TYPE = 32768;
    public static final int FLAG_ERR = 4096;
    public static final int FLAG_REQ_BIT1 = 16384;
    public static final int FLAG_REQ_BIT2 = 8192;
    public static final int FLAG_RET = 2048;
    public static final String KEY_BINDAPP = "ctrl_bindapp";
    public static final String KEY_BINDSERVICE = "ctrl_bindservice";
    public static final String KEY_BINDUSER = "ctrl_binduser";
    public static final String KEY_UNBINDAPP = "ctrl_unbindapp";
    public static final String KEY_UNBINDSERVICE = "ctrl_unbindservice";
    public static final String KEY_UNBINDUSER = "ctrl_unbinduser";
    public static final int MAX_RETRY_TIMES = 3;
    static long a = 1;
    byte[] D;
    int E;
    long F;
    transient NetPerformanceMonitor G;
    Id I;
    public String cunstomDataId;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    short f18143d;
    public String dataId;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    short f18144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    short f18145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    byte f18146g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    byte f18147h;
    public URL host;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    String f18148i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    String f18149j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Map<Integer, String> f18151l;
    public long startSendTime;
    public boolean isAck = false;
    public boolean force = false;
    public boolean isCancel = false;
    byte b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    byte f18142c = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f18150k = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    String f18152m = null;
    public Integer command = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Integer f18153n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    String f18154o = null;
    public String appSign = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    Integer f18155p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    String f18156q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    String f18157r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    String f18158s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    String f18159t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    String f18160u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    Integer f18161v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    String f18162w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    String f18163x = null;
    public String userinfo = null;
    public String serviceId = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    String f18164y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    String f18165z = null;
    String A = null;
    String B = null;
    String C = null;
    public long delyTime = 0;
    public int retryTimes = 0;
    public int timeout = com.taobao.accs.net.b.ACCS_RECEIVE_TIMEOUT;
    public String bizId = null;
    String H = null;

    /* JADX INFO: compiled from: Taobao */
    public static class Id implements Serializable {
        private int a;
        private String b;

        public Id(int i2, String str) {
            this.a = i2;
            this.b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Id.class != obj.getClass()) {
                return false;
            }
            Id id = (Id) obj;
            return this.a == id.getId() || this.b.equals(id.getDataId());
        }

        public String getDataId() {
            return this.b;
        }

        public int getId() {
            return this.a;
        }

        public int hashCode() {
            return this.b.hashCode();
        }
    }

    /* JADX INFO: compiled from: Taobao */
    public static class MsgResType implements Serializable {
        public static final int INVALID = -1;
        public static final int NEED_ACK = 1;
        public static final int NO_ACK = 0;

        public static String name(int i2) {
            return i2 != 0 ? i2 != 1 ? "INVALID" : "NEED_ACK" : "NO_ACK";
        }

        public static int valueOf(int i2) {
            if (i2 == 0) {
                return 0;
            }
            if (i2 != 1) {
            }
            return 1;
        }
    }

    /* JADX INFO: compiled from: Taobao */
    public static class MsgType implements Serializable {
        public static final int CONTROL = 0;
        public static final int DATA = 1;
        public static final int HANDSHAKE = 3;
        public static final int INVALID = -1;
        public static final int PING = 2;

        public static String name(int i2) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "INVALID" : "HANDSHAKE" : "PING" : "DATA" : "CONTROL";
        }

        public static int valueOf(int i2) {
            if (i2 == 0) {
                return 0;
            }
            int i3 = 1;
            if (i2 != 1) {
                i3 = 2;
                if (i2 != 2) {
                    i3 = 3;
                    if (i2 != 3) {
                        return 0;
                    }
                }
            }
            return i3;
        }
    }

    /* JADX INFO: compiled from: Taobao */
    public enum ReqType {
        DATA,
        ACK,
        REQ,
        RES;

        public static ReqType valueOf(int i2) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? DATA : RES : REQ : ACK : DATA;
        }
    }

    private Message() {
        synchronized (Message.class) {
            this.startSendTime = System.currentTimeMillis();
            this.dataId = this.startSendTime + "." + a;
            long j2 = a;
            a = 1 + j2;
            this.I = new Id((int) j2, this.dataId);
        }
    }

    public static Message BuildPing(boolean z2, int i2) {
        Message message = new Message();
        message.f18150k = 2;
        message.command = 201;
        message.force = z2;
        message.delyTime = i2;
        return message;
    }

    public static Message buildBackground(String str) {
        Message message = new Message();
        message.a(1, ReqType.DATA, 0);
        message.command = 100;
        message.f18148i = Constants.TARGET_BACK;
        a(str, message);
        return message;
    }

    @Deprecated
    public static Message buildBindApp(com.taobao.accs.net.b bVar, Context context, Intent intent) {
        return buildBindApp(bVar.b((String) null), bVar.f18210m, context, intent);
    }

    @Deprecated
    public static Message buildBindService(com.taobao.accs.net.b bVar, Context context, Intent intent) {
        return buildBindService(bVar.b((String) null), bVar.f18210m, intent);
    }

    @Deprecated
    public static Message buildBindUser(com.taobao.accs.net.b bVar, Context context, Intent intent) {
        return buildBindUser(bVar.b((String) null), bVar.f18210m, intent);
    }

    public static Message buildErrorReportMessage(String str, String str2, String str3, int i2) {
        Message message = new Message();
        try {
            message.host = new URL(str3);
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
        message.f18148i = Constants.TARGET_SERVICE_ST;
        message.a(1, ReqType.DATA, 0);
        message.command = 100;
        message.D = (0 + com.anythink.expressad.foundation.g.a.bQ + i2 + com.anythink.expressad.foundation.g.a.bQ + str + com.anythink.expressad.foundation.g.a.bQ + com.taobao.accs.utl.j.b(GlobalClientInfo.getContext()) + com.anythink.expressad.foundation.g.a.bQ + str2).getBytes();
        return message;
    }

    public static Message buildForeground(String str) {
        Message message = new Message();
        message.a(1, ReqType.DATA, 0);
        message.command = 100;
        message.f18148i = Constants.TARGET_FORE;
        a(str, message);
        return message;
    }

    public static Message buildHandshake(String str) {
        Message message = new Message();
        message.a(3, ReqType.DATA, 1);
        message.f18152m = str;
        message.f18148i = Constants.TARGET_CONTROL;
        message.command = 200;
        return message;
    }

    public static Message buildParameterError(String str, int i2) {
        Message message = new Message();
        message.a(1, ReqType.ACK, 0);
        message.command = Integer.valueOf(i2);
        message.f18152m = str;
        return message;
    }

    @Deprecated
    public static Message buildPushAck(com.taobao.accs.net.b bVar, String str, String str2, String str3, boolean z2, short s2, String str4, Map<Integer, String> map) {
        return buildPushAck(bVar.b((String) null), bVar.f18210m, str, str2, str3, z2, s2, str4, map);
    }

    @Deprecated
    public static Message buildRequest(com.taobao.accs.net.b bVar, Context context, String str, String str2, String str3, ACCSManager.AccsRequest accsRequest, boolean z2) {
        return buildRequest(context, bVar.b((String) null), bVar.f18210m, bVar.f18206i.getStoreId(), str, str2, accsRequest, z2);
    }

    @Deprecated
    public static Message buildSendData(com.taobao.accs.net.b bVar, Context context, String str, String str2, ACCSManager.AccsRequest accsRequest) {
        return buildSendData(bVar.b((String) null), bVar.f18210m, bVar.f18206i.getStoreId(), context, str, accsRequest, true);
    }

    @Deprecated
    public static Message buildUnbindApp(com.taobao.accs.net.b bVar, Context context, Intent intent) {
        return buildUnbindApp(bVar.b((String) null), intent);
    }

    @Deprecated
    public static Message buildUnbindService(com.taobao.accs.net.b bVar, Context context, Intent intent) {
        return buildUnbindService(bVar.b((String) null), bVar.f18210m, intent);
    }

    @Deprecated
    public static Message buildUnbindUser(com.taobao.accs.net.b bVar, Context context, Intent intent) {
        return buildUnbindUser(bVar.b((String) null), bVar.f18210m, intent);
    }

    private String c() {
        return "Msg_" + this.H;
    }

    short a(Map<Integer, String> map) {
        short length = 0;
        if (map != null) {
            try {
                Iterator<Integer> it = map.keySet().iterator();
                while (it.hasNext()) {
                    String str = map.get(Integer.valueOf(it.next().intValue()));
                    if (!TextUtils.isEmpty(str)) {
                        length = (short) (length + ((short) (str.getBytes(com.anythink.expressad.foundation.g.a.bN).length & 1023)) + 2);
                    }
                }
            } catch (Exception e2) {
                e2.toString();
            }
        }
        return length;
    }

    void b() throws JSONException, UnsupportedEncodingException {
        Integer num = this.command;
        if (num == null || num.intValue() == 100 || this.command.intValue() == 102) {
            return;
        }
        this.D = new q.a().a("command", this.command.intValue() == 100 ? null : this.command).a(Constants.KEY_APP_KEY, this.f18154o).a(Constants.KEY_OS_TYPE, this.f18155p).a("sign", this.appSign).a(Constants.KEY_SDK_VERSION, this.f18161v).a("appVersion", this.f18160u).a(Constants.KEY_TTID, this.f18162w).a("model", this.f18164y).a("brand", this.f18165z).a("imei", this.A).a(Constants.KEY_IMSI, this.B).a(Constants.KYE_MAC_ADDRESS, this.f18163x).a("os", this.f18156q).a(Constants.KEY_EXTS, this.f18159t).a().toString().getBytes(com.anythink.expressad.foundation.g.a.bN);
    }

    public byte[] build(Context context, int i2) {
        byte[] bytes;
        try {
            b();
        } catch (UnsupportedEncodingException e2) {
            ALog.e(c(), "build2", e2, new Object[0]);
        } catch (JSONException e3) {
            ALog.e(c(), "build1", e3, new Object[0]);
        }
        byte[] bArr = this.D;
        String str = bArr != null ? new String(bArr) : "";
        a();
        if (!this.isAck) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilityImpl.k(context));
            sb.append(com.anythink.expressad.foundation.g.a.bQ);
            sb.append(this.f18152m);
            sb.append(com.anythink.expressad.foundation.g.a.bQ);
            String str2 = this.serviceId;
            if (str2 == null) {
                str2 = "";
            }
            sb.append(str2);
            sb.append(com.anythink.expressad.foundation.g.a.bQ);
            String str3 = this.userinfo;
            if (str3 == null) {
                str3 = "";
            }
            sb.append(str3);
            this.f18149j = sb.toString();
        }
        try {
            bytes = (this.dataId + "").getBytes(com.anythink.expressad.foundation.g.a.bN);
            this.f18147h = (byte) this.f18149j.getBytes(com.anythink.expressad.foundation.g.a.bN).length;
            this.f18146g = (byte) this.f18148i.getBytes(com.anythink.expressad.foundation.g.a.bN).length;
        } catch (Exception e4) {
            e4.printStackTrace();
            ALog.e(c(), "build3", e4, new Object[0]);
            bytes = (this.dataId + "").getBytes();
            this.f18147h = (byte) this.f18149j.getBytes().length;
            this.f18146g = (byte) this.f18148i.getBytes().length;
        }
        short sA = a(this.f18151l);
        int length = this.f18146g + 3 + 1 + this.f18147h + 1 + bytes.length;
        byte[] bArr2 = this.D;
        this.f18144e = (short) (length + (bArr2 == null ? 0 : bArr2.length) + sA + 2);
        this.f18143d = (short) (this.f18144e + 2);
        s sVar = new s(this.f18143d + 2 + 4);
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(c(), "Build Message", Constants.KEY_DATA_ID, new String(bytes));
        }
        try {
            sVar.a((byte) (this.b | 32));
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\tversion:2 compress:" + ((int) this.b), new Object[0]);
            }
            if (i2 == 0) {
                sVar.a((byte) -128);
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(c(), "\tflag: 0x80", new Object[0]);
                }
            } else {
                sVar.a((byte) 64);
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(c(), "\tflag: 0x40", new Object[0]);
                }
            }
            sVar.a(this.f18143d);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\ttotalLength:" + ((int) this.f18143d), new Object[0]);
            }
            sVar.a(this.f18144e);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\tdataLength:" + ((int) this.f18144e), new Object[0]);
            }
            sVar.a(this.f18145f);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\tflags:" + Integer.toHexString(this.f18145f), new Object[0]);
            }
            sVar.a(this.f18146g);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\ttargetLength:" + ((int) this.f18146g), new Object[0]);
            }
            sVar.write(this.f18148i.getBytes(com.anythink.expressad.foundation.g.a.bN));
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\ttarget:" + this.f18148i, new Object[0]);
            }
            sVar.a(this.f18147h);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\tsourceLength:" + ((int) this.f18147h), new Object[0]);
            }
            sVar.write(this.f18149j.getBytes(com.anythink.expressad.foundation.g.a.bN));
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\tsource:" + this.f18149j, new Object[0]);
            }
            sVar.a((byte) bytes.length);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\tdataIdLength:" + bytes.length, new Object[0]);
            }
            sVar.write(bytes);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\tdataId:" + new String(bytes), new Object[0]);
            }
            sVar.a(sA);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\textHeader len:" + ((int) sA), new Object[0]);
            }
            if (this.f18151l != null) {
                Iterator<Integer> it = this.f18151l.keySet().iterator();
                while (it.hasNext()) {
                    int iIntValue = it.next().intValue();
                    String str4 = this.f18151l.get(Integer.valueOf(iIntValue));
                    if (!TextUtils.isEmpty(str4)) {
                        sVar.a((short) ((((short) iIntValue) << 10) | ((short) (str4.getBytes(com.anythink.expressad.foundation.g.a.bN).length & 1023))));
                        sVar.write(str4.getBytes(com.anythink.expressad.foundation.g.a.bN));
                        if (ALog.isPrintLog(ALog.Level.D)) {
                            ALog.d(c(), "\textHeader key:" + iIntValue + " value:" + str4, new Object[0]);
                        }
                    }
                }
            }
            if (this.D != null) {
                sVar.write(this.D);
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(c(), "\toriData:" + str, new Object[0]);
            }
            sVar.flush();
        } catch (IOException e5) {
            ALog.e(c(), "build4", e5, new Object[0]);
        }
        byte[] byteArray = sVar.toByteArray();
        try {
            sVar.close();
        } catch (IOException e6) {
            ALog.e(c(), "build5", e6, new Object[0]);
        }
        return byteArray;
    }

    public String getDataId() {
        return this.dataId;
    }

    public long getDelyTime() {
        return this.delyTime;
    }

    public Id getMsgId() {
        return this.I;
    }

    public NetPerformanceMonitor getNetPermanceMonitor() {
        return this.G;
    }

    public int getNode() {
        return this.E;
    }

    public String getPackageName() {
        String str = this.f18152m;
        return str == null ? "" : str;
    }

    public int getRetryTimes() {
        return this.retryTimes;
    }

    public int getType() {
        return this.f18150k;
    }

    public boolean isControlFrame() {
        return Constants.TARGET_CONTROL.equals(this.f18148i);
    }

    public boolean isTimeOut() {
        boolean z2 = (System.currentTimeMillis() - this.startSendTime) + this.delyTime >= ((long) this.timeout);
        if (z2) {
            ALog.e(c(), "delay time:" + this.delyTime + " beforeSendTime:" + (System.currentTimeMillis() - this.startSendTime) + " timeout" + this.timeout, new Object[0]);
        }
        return z2;
    }

    public void setSendTime(long j2) {
        this.F = j2;
    }

    public static Message buildBindApp(String str, String str2, Context context, Intent intent) {
        Message messageBuildBindApp = null;
        try {
            messageBuildBindApp = buildBindApp(context, str2, intent.getStringExtra(Constants.KEY_APP_KEY), intent.getStringExtra("app_sercet"), intent.getStringExtra("packageName"), intent.getStringExtra(Constants.KEY_TTID), intent.getStringExtra("appVersion"));
            a(str, messageBuildBindApp);
            return messageBuildBindApp;
        } catch (Exception e2) {
            ALog.e("Msg", "buildBindApp", e2.getMessage());
            return messageBuildBindApp;
        }
    }

    public static Message buildBindService(String str, String str2, Intent intent) {
        Message messageBuildBindService = null;
        try {
            messageBuildBindService = buildBindService(intent.getStringExtra("packageName"), intent.getStringExtra(Constants.KEY_SERVICE_ID));
            messageBuildBindService.H = str2;
            a(str, messageBuildBindService);
            return messageBuildBindService;
        } catch (Exception e2) {
            ALog.e("Msg", "buildBindService", e2, new Object[0]);
            e2.printStackTrace();
            return messageBuildBindService;
        }
    }

    public static Message buildBindUser(String str, String str2, Intent intent) {
        Message messageBuildBindUser = null;
        try {
            messageBuildBindUser = buildBindUser(intent.getStringExtra("packageName"), intent.getStringExtra(Constants.KEY_USER_ID));
            if (messageBuildBindUser != null) {
                messageBuildBindUser.H = str2;
                a(str, messageBuildBindUser);
            }
        } catch (Exception e2) {
            ALog.e("Msg", "buildBindUser", e2, new Object[0]);
            e2.printStackTrace();
        }
        return messageBuildBindUser;
    }

    public static Message buildPushAck(String str, String str2, String str3, String str4, String str5, boolean z2, short s2, String str6, Map<Integer, String> map) {
        Message message = new Message();
        message.E = 1;
        message.a(s2, z2);
        message.f18149j = str3;
        message.f18148i = str4;
        message.dataId = str5;
        message.isAck = true;
        message.f18151l = map;
        try {
            try {
                if (TextUtils.isEmpty(str6)) {
                    message.host = new URL(str);
                } else {
                    message.host = new URL(str6);
                }
                message.H = str2;
                if (message.host == null) {
                    message.host = new URL(str);
                }
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                ALog.e("Msg", "buildPushAck", th, new Object[0]);
                if (message.host == null) {
                    message.host = new URL(str);
                }
            } catch (Throwable th2) {
                if (message.host == null) {
                    try {
                        message.host = new URL(str);
                    } catch (MalformedURLException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th2;
            }
        }
        return message;
    }

    public static Message buildRequest(Context context, String str, String str2, String str3, String str4, String str5, ACCSManager.AccsRequest accsRequest, boolean z2) {
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.REQ, 1);
        message.command = 100;
        message.f18152m = str4;
        message.serviceId = accsRequest.serviceId;
        message.userinfo = accsRequest.userId;
        message.D = accsRequest.data;
        String str6 = TextUtils.isEmpty(accsRequest.targetServiceName) ? accsRequest.serviceId : accsRequest.targetServiceName;
        StringBuilder sb = new StringBuilder();
        sb.append(str5);
        sb.append(str6);
        sb.append(com.anythink.expressad.foundation.g.a.bQ);
        String str7 = accsRequest.target;
        if (str7 == null) {
            str7 = "";
        }
        sb.append(str7);
        message.f18148i = sb.toString();
        if (TextUtils.isEmpty(accsRequest.dataId)) {
            accsRequest.dataId = message.getMsgId().getDataId();
        }
        message.cunstomDataId = accsRequest.dataId;
        message.bizId = accsRequest.businessId;
        message.H = str2;
        int i2 = accsRequest.timeout;
        if (i2 > 0) {
            message.timeout = i2;
        }
        if (z2) {
            a(str, message, accsRequest);
        } else {
            message.host = accsRequest.host;
        }
        a(message, GlobalClientInfo.getInstance(context).getSid(str2), GlobalClientInfo.getInstance(context).getUserId(str2), str3, GlobalClientInfo.f18117c, accsRequest.businessId, accsRequest.tag);
        message.G = new NetPerformanceMonitor();
        message.G.setDataId(accsRequest.dataId);
        message.G.setServiceId(accsRequest.serviceId);
        message.G.setHost(message.host.toString());
        message.H = str2;
        return message;
    }

    @Deprecated
    public static Message buildSendData(com.taobao.accs.net.b bVar, Context context, String str, String str2, ACCSManager.AccsRequest accsRequest, boolean z2) {
        return buildSendData(bVar.b((String) null), bVar.f18210m, bVar.f18206i.getStoreId(), context, str, accsRequest, z2);
    }

    public static Message buildUnbindApp(String str, Intent intent) {
        ALog.e("Msg", "buildUnbindApp1" + UtilityImpl.a(new Exception()), new Object[0]);
        Message messageBuildUnbindApp = null;
        try {
            messageBuildUnbindApp = buildUnbindApp(str, intent.getStringExtra("packageName"));
            a(str, messageBuildUnbindApp);
            return messageBuildUnbindApp;
        } catch (Exception e2) {
            ALog.e("Msg", "buildUnbindApp1", e2.getMessage());
            return messageBuildUnbindApp;
        }
    }

    public static Message buildUnbindService(String str, String str2, Intent intent) {
        Message messageBuildUnbindService = null;
        try {
            messageBuildUnbindService = buildUnbindService(intent.getStringExtra("packageName"), intent.getStringExtra(Constants.KEY_SERVICE_ID));
            messageBuildUnbindService.H = str2;
            a(str, messageBuildUnbindService);
            return messageBuildUnbindService;
        } catch (Exception e2) {
            ALog.e("Msg", "buildUnbindService", e2, new Object[0]);
            e2.printStackTrace();
            return messageBuildUnbindService;
        }
    }

    public static Message buildUnbindUser(String str, String str2, Intent intent) {
        Message messageBuildUnbindUser = null;
        try {
            messageBuildUnbindUser = buildUnbindUser(intent.getStringExtra("packageName"));
            messageBuildUnbindUser.H = str2;
            a(str, messageBuildUnbindUser);
            return messageBuildUnbindUser;
        } catch (Exception e2) {
            ALog.e("Msg", "buildUnbindUser", e2, new Object[0]);
            e2.printStackTrace();
            return messageBuildUnbindUser;
        }
    }

    public static Message buildSendData(String str, String str2, String str3, Context context, String str4, ACCSManager.AccsRequest accsRequest) {
        return buildSendData(str, str2, str3, context, str4, accsRequest, true);
    }

    public static Message buildSendData(String str, String str2, String str3, Context context, String str4, ACCSManager.AccsRequest accsRequest, boolean z2) {
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.command = 100;
        message.f18152m = str4;
        message.serviceId = accsRequest.serviceId;
        message.userinfo = accsRequest.userId;
        message.D = accsRequest.data;
        String str5 = TextUtils.isEmpty(accsRequest.targetServiceName) ? accsRequest.serviceId : accsRequest.targetServiceName;
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.TARGET_SERVICE_PRE);
        sb.append(str5);
        sb.append(com.anythink.expressad.foundation.g.a.bQ);
        String str6 = accsRequest.target;
        if (str6 == null) {
            str6 = "";
        }
        sb.append(str6);
        message.f18148i = sb.toString();
        if (TextUtils.isEmpty(accsRequest.dataId)) {
            accsRequest.dataId = message.getMsgId().getDataId();
        }
        message.cunstomDataId = accsRequest.dataId;
        message.bizId = accsRequest.businessId;
        int i2 = accsRequest.timeout;
        if (i2 > 0) {
            message.timeout = i2;
        }
        if (z2) {
            a(str, message, accsRequest);
        } else {
            message.host = accsRequest.host;
        }
        a(message, GlobalClientInfo.getInstance(context).getSid(str2), GlobalClientInfo.getInstance(context).getUserId(str2), str3, GlobalClientInfo.f18117c, accsRequest.businessId, accsRequest.tag);
        message.G = new NetPerformanceMonitor();
        message.G.setMsgType(0);
        message.G.setDataId(accsRequest.dataId);
        message.G.setServiceId(accsRequest.serviceId);
        message.G.setHost(message.host.toString());
        message.H = str2;
        return message;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0046 A[Catch: Exception -> 0x004c, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x004c, blocks: (B:13:0x0029, B:14:0x002c, B:24:0x0046), top: B:42:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a() {
        /*
            r6 = this;
            r0 = 0
            byte[] r1 = r6.D     // Catch: java.lang.Throwable -> L37
            if (r1 != 0) goto L6
            return
        L6:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L37
            r1.<init>()     // Catch: java.lang.Throwable -> L37
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L32
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L32
            byte[] r0 = r6.D     // Catch: java.lang.Throwable -> L30
            r2.write(r0)     // Catch: java.lang.Throwable -> L30
            r2.finish()     // Catch: java.lang.Throwable -> L30
            byte[] r0 = r1.toByteArray()     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L29
            int r3 = r0.length     // Catch: java.lang.Throwable -> L30
            byte[] r4 = r6.D     // Catch: java.lang.Throwable -> L30
            int r4 = r4.length     // Catch: java.lang.Throwable -> L30
            if (r3 >= r4) goto L29
            r6.D = r0     // Catch: java.lang.Throwable -> L30
            r0 = 1
            r6.b = r0     // Catch: java.lang.Throwable -> L30
        L29:
            r2.close()     // Catch: java.lang.Exception -> L4c
        L2c:
            r1.close()     // Catch: java.lang.Exception -> L4c
            goto L4c
        L30:
            r0 = move-exception
            goto L3b
        L32:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L3b
        L37:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
        L3b:
            r6.c()     // Catch: java.lang.Throwable -> L4d
            r0.toString()     // Catch: java.lang.Throwable -> L4d
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L4d
            if (r2 == 0) goto L49
            r2.close()     // Catch: java.lang.Exception -> L4c
        L49:
            if (r1 == 0) goto L4c
            goto L2c
        L4c:
            return
        L4d:
            r0 = move-exception
            if (r2 == 0) goto L53
            r2.close()     // Catch: java.lang.Exception -> L58
        L53:
            if (r1 == 0) goto L58
            r1.close()     // Catch: java.lang.Exception -> L58
        L58:
            goto L5a
        L59:
            throw r0
        L5a:
            goto L59
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.data.Message.a():void");
    }

    @Deprecated
    public static Message buildUnbindApp(com.taobao.accs.net.b bVar, Context context, String str, String str2, String str3, String str4) {
        return buildUnbindApp(bVar.b((String) null), str);
    }

    public static Message buildUnbindApp(String str, String str2) {
        Message message;
        try {
            ALog.d("Msg", "buildUnbindApp", new Object[0]);
        } catch (Exception e2) {
            e = e2;
            message = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        message = new Message();
        try {
            message.E = 1;
            message.a(1, ReqType.DATA, 1);
            message.f18152m = str2;
            message.f18148i = Constants.TARGET_CONTROL;
            message.command = 2;
            message.f18152m = str2;
            message.f18161v = 221;
            message.cunstomDataId = KEY_UNBINDAPP;
            a(str, message);
        } catch (Exception e3) {
            e = e3;
            ALog.e("Msg", "buildUnbindApp", e.getMessage());
        }
        return message;
        ALog.e("Msg", "buildUnbindApp", e.getMessage());
        return message;
    }

    @Deprecated
    public static Message buildUnbindUser(Context context, String str, String str2, String str3, String str4, String str5) {
        return buildUnbindUser(str);
    }

    @Deprecated
    public static Message buildBindService(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        return buildBindService(str, str3);
    }

    @Deprecated
    public static Message buildBindUser(Context context, String str, String str2, String str3, String str4, String str5) {
        return buildBindUser(str, str4);
    }

    @Deprecated
    public static Message buildUnbindService(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        return buildUnbindService(str, str3);
    }

    public static Message buildUnbindUser(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.f18152m = str;
        message.f18148i = Constants.TARGET_CONTROL;
        message.command = 4;
        message.f18161v = 221;
        message.cunstomDataId = KEY_UNBINDUSER;
        return message;
    }

    @Deprecated
    public static Message buildBindApp(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        return buildBindApp(context, str, str2, str3, str4, str5, str6);
    }

    public static Message buildBindService(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.f18152m = str;
        message.serviceId = str2;
        message.f18148i = Constants.TARGET_CONTROL;
        message.command = 5;
        message.f18152m = str;
        message.serviceId = str2;
        message.f18161v = 221;
        message.cunstomDataId = KEY_BINDSERVICE;
        return message;
    }

    public static Message buildBindUser(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.f18152m = str;
        message.userinfo = str2;
        message.f18148i = Constants.TARGET_CONTROL;
        message.command = 3;
        message.f18152m = str;
        message.userinfo = str2;
        message.f18161v = 221;
        message.cunstomDataId = KEY_BINDUSER;
        return message;
    }

    public static Message buildUnbindService(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.f18152m = str;
        message.serviceId = str2;
        message.f18148i = Constants.TARGET_CONTROL;
        message.command = 6;
        message.f18152m = str;
        message.serviceId = str2;
        message.f18161v = 221;
        message.cunstomDataId = KEY_UNBINDSERVICE;
        return message;
    }

    public static Message buildBindApp(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.f18155p = 1;
        message.f18156q = Build.VERSION.SDK_INT + "";
        message.f18152m = str4;
        message.f18148i = Constants.TARGET_CONTROL;
        message.command = 1;
        message.f18154o = str2;
        message.appSign = UtilityImpl.a(context, str2, str3, UtilityImpl.k(context), str);
        message.f18161v = 221;
        message.f18160u = str6;
        message.f18152m = str4;
        message.f18162w = str5;
        message.f18164y = Build.MODEL;
        message.f18165z = Build.BRAND;
        message.cunstomDataId = KEY_BINDAPP;
        message.H = str;
        message.f18159t = new q.a().a("notifyEnable", UtilityImpl.p(context)).a("romInfo", new p().a()).a().toString();
        UtilityImpl.a(context, Constants.SP_FILE_NAME, UtilityImpl.p(context));
        return message;
    }

    private static void a(String str, Message message, ACCSManager.AccsRequest accsRequest) {
        URL url = accsRequest.host;
        if (url == null) {
            try {
                message.host = new URL(str);
                return;
            } catch (MalformedURLException e2) {
                ALog.e("Msg", "setUnit", e2, new Object[0]);
                e2.printStackTrace();
                return;
            }
        }
        message.host = url;
    }

    private static void a(String str, Message message) {
        try {
            message.host = new URL(str);
        } catch (Exception e2) {
            ALog.e("Msg", "setControlHost", e2, new Object[0]);
        }
    }

    private static void a(Message message, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str5) && TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str6) && str4 == null) {
            return;
        }
        message.f18151l = new HashMap();
        if (str5 != null && UtilityImpl.a(str5) <= 1023) {
            message.f18151l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_BUSINESS.ordinal()), str5);
        }
        if (str != null && UtilityImpl.a(str) <= 1023) {
            message.f18151l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_SID.ordinal()), str);
        }
        if (str2 != null && UtilityImpl.a(str2) <= 1023) {
            message.f18151l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_USERID.ordinal()), str2);
        }
        if (str6 != null && UtilityImpl.a(str6) <= 1023) {
            message.f18151l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_TAG.ordinal()), str6);
        }
        if (str4 != null && UtilityImpl.a(str4) <= 1023) {
            message.f18151l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_COOKIE.ordinal()), str4);
        }
        if (str3 == null || UtilityImpl.a(str3) > 1023) {
            return;
        }
        message.f18151l.put(19, str3);
    }

    private void a(int i2, ReqType reqType, int i3) {
        this.f18150k = i2;
        if (i2 != 2) {
            this.f18145f = (short) (((((i2 & 1) << 4) | (reqType.ordinal() << 2)) | i3) << 11);
        }
    }

    private void a(short s2, boolean z2) {
        this.f18150k = 1;
        this.f18145f = s2;
        this.f18145f = (short) (this.f18145f & (-16385));
        this.f18145f = (short) (this.f18145f | 8192);
        this.f18145f = (short) (this.f18145f & (-2049));
        this.f18145f = (short) (this.f18145f & (-65));
        if (z2) {
            this.f18145f = (short) (this.f18145f | 32);
        }
    }
}
