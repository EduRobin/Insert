package cz.educanet.jaxrs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {
    public static void main(String[] args) throws SQLException {
        String studio;
        String game;


        Scanner sc = new Scanner(System.in);


        System.out.println("Insert some studio: ");
        studio = sc.nextLine();
        System.out.println("Insert some game: ");
        game = sc.nextLine();


        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "");

        PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO games VALUES (NULL, ?, ?)");
        preparedStatement.setString(1, studio);
        preparedStatement.setString(2, game);

        preparedStatement.executeUpdate();

        connection.close();
    }
}
