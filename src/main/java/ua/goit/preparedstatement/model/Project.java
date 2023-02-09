package ua.goit.preparedstatement.model;

import java.util.Date;

public class Project {
    int id;
    int clientId;
    Date startDate;
    Date endDate;

    public Project() {
    }

    public Project(int clientId, Date startDate, Date endDate) {
        this.clientId = clientId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.sql.Date getStartDate() {
        return (java.sql.Date) startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public java.sql.Date getEndDate() {
        return (java.sql.Date) endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", clientID=" + clientId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
