package com.bytedance.msdk.adapter.ks.base.config;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterValueSetBuilder;

/* JADX INFO: loaded from: classes2.dex */
public class AdapterResultBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f336a = false;
    private int b = -1;
    private String c = null;
    private ValueSet d = null;

    private static final class ResultImpl implements Result {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f337a;
        private final int b;
        private final String c;
        private final ValueSet d;

        private ResultImpl(boolean z, int i, String str, ValueSet valueSet) {
            this.f337a = z;
            this.b = i;
            this.c = str;
            this.d = valueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.b;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.f337a;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.c;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.d;
        }
    }

    private AdapterResultBuilder() {
    }

    public static final AdapterResultBuilder create() {
        return new AdapterResultBuilder();
    }

    public Result build() {
        boolean z = this.f336a;
        int i = this.b;
        String str = this.c;
        ValueSet valueSet = this.d;
        if (valueSet == null) {
            valueSet = AdnAdapterValueSetBuilder.EMPTY;
        }
        return new ResultImpl(z, i, str, valueSet);
    }

    public AdapterResultBuilder setCode(int i) {
        this.b = i;
        return this;
    }

    public AdapterResultBuilder setMessage(String str) {
        this.c = str;
        return this;
    }

    public AdapterResultBuilder setSuccess(boolean z) {
        this.f336a = z;
        return this;
    }

    public AdapterResultBuilder setValues(ValueSet valueSet) {
        this.d = valueSet;
        return this;
    }
}
