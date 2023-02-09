package ua.goit.preparedstatement;

public class WorkerProject {
    int id;
    int workerId;
    int projectId;

    public WorkerProject() {
    }

    public WorkerProject(int workerId, int projectId) {
        this.workerId = workerId;
        this.projectId = projectId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "WorkerProject{" +
                "id=" + id +
                ", workerId=" + workerId +
                ", projectId=" + projectId +
                '}';
    }
}
