package com.amgcyo.cuttadon.api.entity.fission5;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Invalitation5Bean implements Serializable {
    private List<Integer> invitation_amount;
    private String invitation_code;
    private String invitation_url;
    private List<String> notice;
    private List<String> rule_msg;

    public List<Integer> getInvitation_amount() {
        return this.invitation_amount;
    }

    public String getInvitation_code() {
        return this.invitation_code;
    }

    public String getInvitation_url() {
        return this.invitation_url;
    }

    public List<String> getNotice() {
        return this.notice;
    }

    public List<String> getRule_msg() {
        return this.rule_msg;
    }

    public void setInvitation_amount(List<Integer> list) {
        this.invitation_amount = list;
    }

    public void setInvitation_code(String str) {
        this.invitation_code = str;
    }

    public void setInvitation_url(String str) {
        this.invitation_url = str;
    }

    public void setNotice(List<String> list) {
        this.notice = list;
    }

    public void setRule_msg(List<String> list) {
        this.rule_msg = list;
    }
}
