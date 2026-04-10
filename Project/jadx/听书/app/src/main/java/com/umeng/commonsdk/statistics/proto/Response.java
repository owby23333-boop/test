package com.umeng.commonsdk.statistics.proto;

import androidx.core.app.NotificationCompat;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.cb;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.cg;
import com.umeng.analytics.pro.ch;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class Response implements aw<Response, e>, Serializable, Cloneable {
    private static final int __RESP_CODE_ISSET_ID = 0;
    public static final Map<e, bi> metaDataMap;
    private static final Map<Class<? extends cd>, ce> schemes;
    private static final long serialVersionUID = -4549277923241195391L;
    private byte __isset_bitfield;
    public com.umeng.commonsdk.statistics.proto.d imprint;
    public String msg;
    private e[] optionals;
    public int resp_code;
    private static final ca STRUCT_DESC = new ca("Response");
    private static final bq RESP_CODE_FIELD_DESC = new bq("resp_code", (byte) 8, 1);
    private static final bq MSG_FIELD_DESC = new bq(NotificationCompat.CATEGORY_MESSAGE, (byte) 11, 2);
    private static final bq IMPRINT_FIELD_DESC = new bq(an.X, (byte) 12, 3);

    static {
        HashMap map = new HashMap();
        schemes = map;
        map.put(cf.class, new b());
        map.put(cg.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.RESP_CODE, new bi("resp_code", (byte) 1, new bj((byte) 8)));
        enumMap.put(e.MSG, new bi(NotificationCompat.CATEGORY_MESSAGE, (byte) 2, new bj((byte) 11)));
        enumMap.put(e.IMPRINT, new bi(an.X, (byte) 2, new bn((byte) 12, com.umeng.commonsdk.statistics.proto.d.class)));
        Map<e, bi> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        metaDataMap = mapUnmodifiableMap;
        bi.a(Response.class, mapUnmodifiableMap);
    }

    public enum e implements bd {
        RESP_CODE(1, "resp_code"),
        MSG(2, NotificationCompat.CATEGORY_MESSAGE),
        IMPRINT(3, an.X);

        private static final Map<String, e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                d.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            if (i == 1) {
                return RESP_CODE;
            }
            if (i == 2) {
                return MSG;
            }
            if (i != 3) {
                return null;
            }
            return IMPRINT;
        }

        public static e b(int i) {
            e eVarA = a(i);
            if (eVarA != null) {
                return eVarA;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static e a(String str) {
            return d.get(str);
        }

        e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        @Override // com.umeng.analytics.pro.bd
        public short a() {
            return this.e;
        }

        @Override // com.umeng.analytics.pro.bd
        public String b() {
            return this.f;
        }
    }

    public Response() {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
    }

    public Response(int i) {
        this();
        this.resp_code = i;
        setResp_codeIsSet(true);
    }

    public Response(Response response) {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
        this.__isset_bitfield = response.__isset_bitfield;
        this.resp_code = response.resp_code;
        if (response.isSetMsg()) {
            this.msg = response.msg;
        }
        if (response.isSetImprint()) {
            this.imprint = new com.umeng.commonsdk.statistics.proto.d(response.imprint);
        }
    }

    @Override // com.umeng.analytics.pro.aw
    public Response deepCopy() {
        return new Response(this);
    }

    @Override // com.umeng.analytics.pro.aw
    public void clear() {
        setResp_codeIsSet(false);
        this.resp_code = 0;
        this.msg = null;
        this.imprint = null;
    }

    public int getResp_code() {
        return this.resp_code;
    }

    public Response setResp_code(int i) {
        this.resp_code = i;
        setResp_codeIsSet(true);
        return this;
    }

    public void unsetResp_code() {
        this.__isset_bitfield = at.b(this.__isset_bitfield, 0);
    }

    public boolean isSetResp_code() {
        return at.a(this.__isset_bitfield, 0);
    }

    public void setResp_codeIsSet(boolean z) {
        this.__isset_bitfield = at.a(this.__isset_bitfield, 0, z);
    }

    public String getMsg() {
        return this.msg;
    }

    public Response setMsg(String str) {
        this.msg = str;
        return this;
    }

    public void unsetMsg() {
        this.msg = null;
    }

    public boolean isSetMsg() {
        return this.msg != null;
    }

    public void setMsgIsSet(boolean z) {
        if (z) {
            return;
        }
        this.msg = null;
    }

    public com.umeng.commonsdk.statistics.proto.d getImprint() {
        return this.imprint;
    }

    public Response setImprint(com.umeng.commonsdk.statistics.proto.d dVar) {
        this.imprint = dVar;
        return this;
    }

    public void unsetImprint() {
        this.imprint = null;
    }

    public boolean isSetImprint() {
        return this.imprint != null;
    }

    public void setImprintIsSet(boolean z) {
        if (z) {
            return;
        }
        this.imprint = null;
    }

    @Override // com.umeng.analytics.pro.aw
    public e fieldForId(int i) {
        return e.a(i);
    }

    @Override // com.umeng.analytics.pro.aw
    public void read(bv bvVar) throws bc {
        schemes.get(bvVar.D()).b().b(bvVar, this);
    }

    @Override // com.umeng.analytics.pro.aw
    public void write(bv bvVar) throws bc {
        schemes.get(bvVar.D()).b().a(bvVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Response(resp_code:");
        sb.append(this.resp_code);
        if (isSetMsg()) {
            sb.append(", ");
            sb.append("msg:");
            String str = this.msg;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (isSetImprint()) {
            sb.append(", ");
            sb.append("imprint:");
            com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
            if (dVar == null) {
                sb.append("null");
            } else {
                sb.append(dVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void validate() throws bc {
        com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
        if (dVar != null) {
            dVar.l();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bp(new ch(objectOutputStream)));
        } catch (bc e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.__isset_bitfield = (byte) 0;
            read(new bp(new ch(objectInputStream)));
        } catch (bc e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private static class b implements ce {
        private b() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    private static class a extends cf<Response> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bv bvVar, Response response) throws bc {
            bvVar.j();
            while (true) {
                bq bqVarL = bvVar.l();
                if (bqVarL.b == 0) {
                    break;
                }
                short s = bqVarL.c;
                if (s != 1) {
                    if (s != 2) {
                        if (s == 3) {
                            if (bqVarL.b == 12) {
                                response.imprint = new com.umeng.commonsdk.statistics.proto.d();
                                response.imprint.read(bvVar);
                                response.setImprintIsSet(true);
                            } else {
                                by.a(bvVar, bqVarL.b);
                            }
                        } else {
                            by.a(bvVar, bqVarL.b);
                        }
                    } else if (bqVarL.b == 11) {
                        response.msg = bvVar.z();
                        response.setMsgIsSet(true);
                    } else {
                        by.a(bvVar, bqVarL.b);
                    }
                } else if (bqVarL.b == 8) {
                    response.resp_code = bvVar.w();
                    response.setResp_codeIsSet(true);
                } else {
                    by.a(bvVar, bqVarL.b);
                }
                bvVar.m();
            }
            bvVar.k();
            if (!response.isSetResp_code()) {
                throw new bw("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
            }
            response.validate();
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bv bvVar, Response response) throws bc {
            response.validate();
            bvVar.a(Response.STRUCT_DESC);
            bvVar.a(Response.RESP_CODE_FIELD_DESC);
            bvVar.a(response.resp_code);
            bvVar.c();
            if (response.msg != null && response.isSetMsg()) {
                bvVar.a(Response.MSG_FIELD_DESC);
                bvVar.a(response.msg);
                bvVar.c();
            }
            if (response.imprint != null && response.isSetImprint()) {
                bvVar.a(Response.IMPRINT_FIELD_DESC);
                response.imprint.write(bvVar);
                bvVar.c();
            }
            bvVar.d();
            bvVar.b();
        }
    }

    private static class d implements ce {
        private d() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    private static class c extends cg<Response> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cd
        public void a(bv bvVar, Response response) throws bc {
            cb cbVar = (cb) bvVar;
            cbVar.a(response.resp_code);
            BitSet bitSet = new BitSet();
            if (response.isSetMsg()) {
                bitSet.set(0);
            }
            if (response.isSetImprint()) {
                bitSet.set(1);
            }
            cbVar.a(bitSet, 2);
            if (response.isSetMsg()) {
                cbVar.a(response.msg);
            }
            if (response.isSetImprint()) {
                response.imprint.write(cbVar);
            }
        }

        @Override // com.umeng.analytics.pro.cd
        public void b(bv bvVar, Response response) throws bc {
            cb cbVar = (cb) bvVar;
            response.resp_code = cbVar.w();
            response.setResp_codeIsSet(true);
            BitSet bitSetB = cbVar.b(2);
            if (bitSetB.get(0)) {
                response.msg = cbVar.z();
                response.setMsgIsSet(true);
            }
            if (bitSetB.get(1)) {
                response.imprint = new com.umeng.commonsdk.statistics.proto.d();
                response.imprint.read(cbVar);
                response.setImprintIsSet(true);
            }
        }
    }
}
