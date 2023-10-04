package cn.com.project.domain;

// 日志
public class Log {
    //主键id
    private Integer id;

    //登录人
    private String dlr;

    //登录时间
    private String dlsj;

    //登录IP
    private String dlip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDlr() {
        return dlr;
    }

    public void setDlr(String dlr) {
        this.dlr = dlr == null ? null : dlr.trim();
    }

    public String getDlsj() {
        return dlsj;
    }

    public void setDlsj(String dlsj) {
        this.dlsj = dlsj == null ? null : dlsj.trim();
    }

    public String getDlip() {
        return dlip;
    }

    public void setDlip(String dlip) {
        this.dlip = dlip == null ? null : dlip.trim();
    }
}