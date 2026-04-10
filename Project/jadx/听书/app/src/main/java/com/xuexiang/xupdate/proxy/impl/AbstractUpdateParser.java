package com.xuexiang.xupdate.proxy.impl;

import com.xuexiang.xupdate.listener.IUpdateParseCallback;
import com.xuexiang.xupdate.proxy.IUpdateParser;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractUpdateParser implements IUpdateParser {
    @Override // com.xuexiang.xupdate.proxy.IUpdateParser
    public boolean isAsyncParser() {
        return false;
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateParser
    public void parseJson(String str, IUpdateParseCallback iUpdateParseCallback) throws Exception {
    }
}
