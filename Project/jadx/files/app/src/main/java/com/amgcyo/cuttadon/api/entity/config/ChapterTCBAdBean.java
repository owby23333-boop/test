package com.amgcyo.cuttadon.api.entity.config;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ChapterTCBAdBean implements Serializable {
    private BaseStochasticBean content_bottom;
    private BaseStochasticBean content_end;
    private BaseStochasticBean content_page;
    private BaseStochasticBean content_page1;
    private BaseStochasticBean interface_top;
    private int next_button_switch;
    private BaseStochasticBean read_ad_lock;

    public BaseStochasticBean getContent_bottom() {
        return this.content_bottom;
    }

    public BaseStochasticBean getContent_end() {
        return this.content_end;
    }

    public BaseStochasticBean getContent_page() {
        return this.content_page;
    }

    public BaseStochasticBean getContent_page1() {
        return this.content_page1;
    }

    public BaseStochasticBean getInterface_top() {
        return this.interface_top;
    }

    public int getNext_button_switch() {
        return this.next_button_switch;
    }

    public BaseStochasticBean getRead_ad_lock() {
        return this.read_ad_lock;
    }

    public void setContent_bottom(BaseStochasticBean baseStochasticBean) {
        this.content_bottom = baseStochasticBean;
    }

    public void setContent_end(BaseStochasticBean baseStochasticBean) {
        this.content_end = baseStochasticBean;
    }

    public void setContent_page(BaseStochasticBean baseStochasticBean) {
        this.content_page = baseStochasticBean;
    }

    public void setContent_page1(BaseStochasticBean baseStochasticBean) {
        this.content_page1 = baseStochasticBean;
    }

    public void setInterface_top(BaseStochasticBean baseStochasticBean) {
        this.interface_top = baseStochasticBean;
    }

    public void setNext_button_switch(int i2) {
        this.next_button_switch = i2;
    }

    public void setRead_ad_lock(BaseStochasticBean baseStochasticBean) {
        this.read_ad_lock = baseStochasticBean;
    }
}
