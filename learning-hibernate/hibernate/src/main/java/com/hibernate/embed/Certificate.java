package com.hibernate.embed;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
    private int cid;

    private String cname;

    public Certificate(){}

    public Certificate(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}
