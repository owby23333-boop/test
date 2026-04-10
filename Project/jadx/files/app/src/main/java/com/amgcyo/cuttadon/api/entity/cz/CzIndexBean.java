package com.amgcyo.cuttadon.api.entity.cz;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CzIndexBean implements Serializable {
    private List<CzChannelBean> channel;
    private List<CzHelperBean> help;
    private List<CzPayDataBean> pay_data;

    public List<CzChannelBean> getChannel() {
        return this.channel;
    }

    public List<CzHelperBean> getHelp() {
        return this.help;
    }

    public List<CzPayDataBean> getPay_data() {
        return this.pay_data;
    }

    public void setChannel(List<CzChannelBean> list) {
        this.channel = list;
    }

    public void setHelp(List<CzHelperBean> list) {
        this.help = list;
    }

    public void setPay_data(List<CzPayDataBean> list) {
        this.pay_data = list;
    }
}
