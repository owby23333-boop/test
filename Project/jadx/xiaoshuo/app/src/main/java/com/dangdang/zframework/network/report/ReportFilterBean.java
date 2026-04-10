package com.dangdang.zframework.network.report;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class ReportFilterBean implements Serializable {
    public List<ArrayBean> array;

    public static class ArrayBean implements Serializable {
        public String action;
        public List<Integer> filter;
        public String path;
    }
}
