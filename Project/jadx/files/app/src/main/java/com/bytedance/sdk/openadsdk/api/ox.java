package com.bytedance.sdk.openadsdk.api;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public final class ox {
    private boolean mb = false;
    private int ox = -1;
    private String b = null;
    private ValueSet hj = null;

    private static final class mb implements Result {
        private final String b;
        private final ValueSet hj;
        private final boolean mb;
        private final int ox;

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.ox;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.mb;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.b;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.hj;
        }

        private mb(boolean z2, int i2, String str, ValueSet valueSet) {
            this.mb = z2;
            this.ox = i2;
            this.b = str;
            this.hj = valueSet;
        }
    }

    private ox() {
    }

    public static final ox mb() {
        return new ox();
    }

    public Result ox() {
        boolean z2 = this.mb;
        int i2 = this.ox;
        String str = this.b;
        ValueSet valueSetOx = this.hj;
        if (valueSetOx == null) {
            valueSetOx = b.mb().ox();
        }
        return new mb(z2, i2, str, valueSetOx);
    }

    public ox mb(boolean z2) {
        this.mb = z2;
        return this;
    }

    public ox mb(int i2) {
        this.ox = i2;
        return this;
    }

    public ox mb(ValueSet valueSet) {
        this.hj = valueSet;
        return this;
    }
}
