package pers.hdh.model;

import java.io.Serializable;

public class Email implements Serializable {
    private String url;
    private String apiUser;
    private String apiKey;
    private String rcpt_to;
    private String from;
    private String fromname;
    private String subject;
    private String resp_email_id;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApiUser() {
        return apiUser;
    }

    public void setApiUser(String apiUser) {
        this.apiUser = apiUser;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getRcpt_to() {
        return rcpt_to;
    }

    public void setRcpt_to(String rcpt_to) {
        this.rcpt_to = rcpt_to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFromname() {
        return fromname;
    }

    public void setFromname(String fromname) {
        this.fromname = fromname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getResp_email_id() {
        return resp_email_id;
    }

    public void setResp_email_id(String resp_email_id) {
        this.resp_email_id = resp_email_id;
    }
}
