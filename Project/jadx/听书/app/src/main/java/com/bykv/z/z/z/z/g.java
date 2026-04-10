package com.bykv.z.z.z.z;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private boolean z = false;
    private int g = -1;
    private String dl = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ValueSet f126a = null;

    private g() {
    }

    public static final g z() {
        return new g();
    }

    public g z(boolean z2) {
        this.z = z2;
        return this;
    }

    public g z(int i) {
        this.g = i;
        return this;
    }

    public g z(String str) {
        this.dl = str;
        return this;
    }

    public g z(ValueSet valueSet) {
        this.f126a = valueSet;
        return this;
    }

    public Result g() {
        boolean z2 = this.z;
        int i = this.g;
        String str = this.dl;
        ValueSet valueSetG = this.f126a;
        if (valueSetG == null) {
            valueSetG = dl.z().g();
        }
        return new z(z2, i, str, valueSetG);
    }

    private static final class z implements Result {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ValueSet f127a;
        private final String dl;
        private final int g;
        private final boolean z;

        private z(boolean z, int i, String str, ValueSet valueSet) {
            this.z = z;
            this.g = i;
            this.dl = str;
            this.f127a = valueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.z;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.g;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.dl;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.f127a;
        }
    }
}
