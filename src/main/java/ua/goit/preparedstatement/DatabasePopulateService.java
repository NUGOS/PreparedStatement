package ua.goit.preparedstatement;

import ua.goit.preparedstatement.model.Client;
import ua.goit.preparedstatement.model.Project;
import ua.goit.preparedstatement.model.Worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static ua.goit.preparedstatement.model.Level.*;


public class DatabasePopulateService {
    public static void main(String[] args) {

        addWorker();
        addClient();
        addProject();
        addWorkerAndProject();
    }


    private static void addWorker() {
        String sql = "INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES (?,?,?,?)";
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            List<Worker> workers = Arrays.asList(
                    new Worker("John Doe", java.sql.Date.valueOf("1980-01-01"), TRAINEE, 500),
                    new Worker("Jane Doe", java.sql.Date.valueOf("1982-02-02"), JUNIOR, 800),
                    new Worker("Jim Smith", java.sql.Date.valueOf("1983-03-03"), MIDDLE, 1500),
                    new Worker("Sarah Johnson", java.sql.Date.valueOf("1984-04-04"), MIDDLE, 6000),
                    new Worker("Tom Brown", java.sql.Date.valueOf("1985-05-05"), TRAINEE, 600),
                    new Worker("Emily Davis", java.sql.Date.valueOf("1986-06-06"), JUNIOR, 700),
                    new Worker("Michael Wilson", java.sql.Date.valueOf("1987-07-07"), MIDDLE, 1700),
                    new Worker("Ashley Jones", java.sql.Date.valueOf("1988-08-08"), SENIOR, 5000),
                    new Worker("Jessica Wilson", java.sql.Date.valueOf("1990-10-10"), JUNIOR, 900),
                    new Worker("David Anderson", java.sql.Date.valueOf("1989-09-09"), TRAINEE, 700)
            );
            for (Worker worker : workers) {
                preparedStatement.setString(1, worker.getName());
                preparedStatement.setDate(2, worker.getBirthday());
                preparedStatement.setString(3, worker.getLevel().toString());
                preparedStatement.setInt(4, worker.getSalary());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void addClient() {
        String sql = "INSERT INTO client (NAME) VALUES(?)";
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            List<Client> clients = Arrays.asList(
                    new Client("Google"),
                    new Client("Microsoft"),
                    new Client("Apple"),
                    new Client("Facebook"),
                    new Client("Amazon")
            );
            for (Client client : clients) {
                preparedStatement.setString(1, client.getName());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addProject() {
        String sql = "INSERT INTO project (CLIENT_ID, START_DATE, END_DATE) VALUES(?,?,?)";
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            List<Project> projects = Arrays.asList(
                    new Project(1, java.sql.Date.valueOf("2022-01-01"), java.sql.Date.valueOf("2022-03-01")),
                    new Project(2, java.sql.Date.valueOf("2022-02-01"), java.sql.Date.valueOf("2022-05-01")),
                    new Project(3, java.sql.Date.valueOf("2022-03-01"), java.sql.Date.valueOf("2022-06-01")),
                    new Project(4, java.sql.Date.valueOf("2022-04-01"), java.sql.Date.valueOf("2022-08-01")),
                    new Project(1, java.sql.Date.valueOf("2022-05-01"), java.sql.Date.valueOf("2022-09-01")),
                    new Project(2, java.sql.Date.valueOf("2022-06-01"), java.sql.Date.valueOf("2022-11-01")),
                    new Project(3, java.sql.Date.valueOf("2022-07-01"), java.sql.Date.valueOf("2022-12-01")),
                    new Project(4, java.sql.Date.valueOf("2022-08-01"), java.sql.Date.valueOf("2023-01-01")),
                    new Project(1, java.sql.Date.valueOf("2022-09-01"), java.sql.Date.valueOf("2023-03-01")),
                    new Project(2, java.sql.Date.valueOf("2022-10-01"), java.sql.Date.valueOf("2023-04-01"))
            );

            for (Project project : projects) {
                preparedStatement.setInt(1, project.getClientId());
                preparedStatement.setDate(2, project.getStartDate());
                preparedStatement.setDate(3, project.getEndDate());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addWorkerAndProject() {
        String sql = "INSERT INTO worker_project (WORKER_ID, PROJECT_ID) VALUES(?,?)";
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            List<WorkerProject> workerProjects = Arrays.asList(
                    new WorkerProject(1, 1),
                    new WorkerProject(7, 3),
                    new WorkerProject(5, 1),
                    new WorkerProject(8, 3),
                    new WorkerProject(2, 2),
                    new WorkerProject(3, 3),
                    new WorkerProject(6, 2),
                    new WorkerProject(9, 2),
                    new WorkerProject(4, 4),
                    new WorkerProject(10, 3),
                    new WorkerProject(1, 3),
                    new WorkerProject(2, 4),
                    new WorkerProject(3, 1),
                    new WorkerProject(4, 2),
                    new WorkerProject(5, 3),
                    new WorkerProject(6, 3),
                    new WorkerProject(7, 2),
                    new WorkerProject(8, 3),
                    new WorkerProject(9, 5),
                    new WorkerProject(10, 6),
                    new WorkerProject(1, 7),
                    new WorkerProject(2, 8),
                    new WorkerProject(3, 2),
                    new WorkerProject(4, 9),
                    new WorkerProject(5, 10),
                    new WorkerProject(6, 5),
                    new WorkerProject(7, 6),
                    new WorkerProject(8, 7),
                    new WorkerProject(9, 8),
                    new WorkerProject(10, 10)
            );
            for (WorkerProject workerProject : workerProjects) {
                preparedStatement.setInt(1, workerProject.workerId);
                preparedStatement.setInt(2, workerProject.projectId);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
