package com.yuewen;

import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes12.dex */
public class c73 extends n94 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9569b;

    public c73(String str, String str2) {
        c(str);
        this.f9569b = str2;
    }

    @Override // com.yuewen.n94
    public String a(Matcher matcher) {
        StringBuffer stringBuffer = new StringBuffer();
        matcher.appendReplacement(stringBuffer, this.f9569b);
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
