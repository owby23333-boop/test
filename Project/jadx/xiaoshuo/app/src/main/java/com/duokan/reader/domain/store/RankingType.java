package com.duokan.reader.domain.store;

import com.chinaums.pppay.unify.UnifyPayListener;
import com.yuewen.jc2;

/* JADX INFO: loaded from: classes3.dex */
public enum RankingType {
    HOT("0"),
    HIGH_COMMENT("100"),
    MONTH("10"),
    FREE("1"),
    UPDATE("1002"),
    DANGDANG("230"),
    AMAZON("210"),
    JINGDONG("220"),
    DOUBAN("200"),
    NEW("1001"),
    BOY(jc2.B),
    GIRL("1502"),
    XUANHUAN("2001"),
    WUXIA(UnifyPayListener.ERR_ORDER_DUPLICATE),
    CITY(UnifyPayListener.ERR_PAY_FAIL),
    LOVE("2004"),
    RANK_FINISHED_ALL("1034"),
    RANK_PROGRESSIVE("1005");

    private String mTypeIndex;

    RankingType(String str) {
        this.mTypeIndex = str;
    }

    public String value() {
        return this.mTypeIndex;
    }
}
