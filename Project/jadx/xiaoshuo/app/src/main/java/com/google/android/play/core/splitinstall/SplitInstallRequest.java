package com.google.android.play.core.splitinstall;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class SplitInstallRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f6959a;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f6960a;

        private Builder() {
            this.f6960a = new ArrayList();
        }

        public Builder addModule(String str) {
            this.f6960a.add(str);
            return this;
        }

        public SplitInstallRequest build() {
            return new SplitInstallRequest(this, (byte) 0);
        }

        public /* synthetic */ Builder(byte b2) {
            this();
        }
    }

    private SplitInstallRequest(Builder builder) {
        this.f6959a = new ArrayList(builder.f6960a);
    }

    public static Builder newBuilder() {
        return new Builder((byte) 0);
    }

    public List<String> getModuleNames() {
        return this.f6959a;
    }

    public String toString() {
        String strValueOf = String.valueOf(this.f6959a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 34);
        sb.append("SplitInstallRequest{modulesNames=");
        sb.append(strValueOf);
        sb.append(com.alipay.sdk.m.y.l.d);
        return sb.toString();
    }

    public /* synthetic */ SplitInstallRequest(Builder builder, byte b2) {
        this(builder);
    }
}
