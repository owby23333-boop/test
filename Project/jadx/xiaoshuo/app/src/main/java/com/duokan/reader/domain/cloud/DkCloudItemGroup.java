package com.duokan.reader.domain.cloud;

import java.text.ParseException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DkCloudItemGroup extends DkCloudItem {
    public DkCloudItemGroup(long j) {
        super(j);
    }

    public DkCloudItemGroup(Node node, long j) throws DOMException, ParseException {
        super(node, j);
    }
}
