package com.ilya.remindmeproject.dto;

import java.util.Date;

/**
 * Created by ilya on 25.05.2016.
 */
public class RemindDTO {

    private String id;
    private String title;
    private Date remindDate;

    public RemindDTO() {
    }

    public RemindDTO(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getRemindDate() {
        return remindDate;
    }

    public void setRemindDate(Date remindDate) {
        this.remindDate = remindDate;
    }
}
