package com.bytedance.sdk.openadsdk.api;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes10.dex */
public final class d {
    private boolean e = false;
    private int bf = -1;
    private String d = null;
    private ValueSet tg = null;

    public static final class e implements Result {
        private final int bf;
        private final String d;
        private final boolean e;
        private final ValueSet tg;

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.bf;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.e;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.d;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.tg;
        }

        private e(boolean z, int i, String str, ValueSet valueSet) {
            this.e = z;
            this.bf = i;
            this.d = str;
            this.tg = valueSet;
        }
    }

    private d() {
    }

    public static final d e() {
        return new d();
    }

    public Result bf() {
        boolean z = this.e;
        int i = this.bf;
        String str = this.d;
        ValueSet valueSetBf = this.tg;
        if (valueSetBf == null) {
            valueSetBf = tg.e().bf();
        }
        return new e(z, i, str, valueSetBf);
    }

    public d e(ValueSet valueSet) {
        this.tg = valueSet;
        return this;
    }
}
