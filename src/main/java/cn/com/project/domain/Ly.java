package cn.com.project.domain;

// 留言
public class Ly {
    //主键id
    private Integer id;

    //标题
    private String title;

    //内容
    private String content;

    //回复内容
    private String hf;

    //用户id
    private Integer aid;

    //回复人id
    private Integer jid;

    //留言人
    private String lname;

    //回复人
    private String account;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getHf() {
        return hf;
    }

    public void setHf(String hf) {
        this.hf = hf == null ? null : hf.trim();
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname == null ? null : lname.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

}