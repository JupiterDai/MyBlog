package com.dyf.myblog.common.base;

import java.io.Serializable;
import java.util.Date;

import com.dyf.myblog.common.AppContext;



public abstract class BasePO implements Serializable, Cloneable {

    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public final void createAuditValues(AppContext context) {
        if (context != null) {
            Date now = new Date();
            setCreatedBy(context.getUserName());
            setUpdatedBy(context.getUserName());
            setCreatedAt(now);
            setUpdatedAt(now);
        }
    }

    public final void updateAuditValues(AppContext context) {
        if (context != null) {
            Date now = new Date();
            setUpdatedBy(context.getUserName());
            setUpdatedAt(now);
        }
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
