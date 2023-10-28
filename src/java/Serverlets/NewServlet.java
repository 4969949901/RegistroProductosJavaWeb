/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Serverlets;

import Clases.ConexionBaseDeDatos ;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;


@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url="jdbc:mysql://localhost:3306/mybd";
        String usuario="root";
        String contraseña="H2023sql";
      
         try{
            Class.forName("com.mysql.jdbc.Driver");
          
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

            // Consulta SQL
            String sql = "SELECT codigo, nombre, cantidad, vencimiento, precio, descripcion FROM productos";
            PreparedStatement statement = conexion.prepareStatement(sql);

            // Ejecutar la consulta
            ResultSet resultado = statement.executeQuery();

            // Procesar los resultados
            while (resultado.next()) {
                int codigo = resultado.getInt("codigo");
                String nombre = resultado.getString("nombre");
                int cantidad = resultado.getInt("cantidad");
                Date vencimiento = resultado.getDate("vencimiento");
                double precio = resultado.getDouble("precio");
                String descripcion = resultado.getString("descripcion");

                // Puedes hacer lo que quieras con los datos obtenidos, como enviarlos al cliente
                // Aquí, simplemente los imprimiremos en la consola
                System.out.println("Código: " + codigo);
                System.out.println("Nombre: " + nombre);
                System.out.println("Cantidad: " + cantidad);
                System.out.println("Vencimiento: " + vencimiento);
                System.out.println("Precio: " + precio);
                System.out.println("Descripción: " + descripcion);
            }

            // Cerrar la conexión y los recursos
            statement.close();
            conexion.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
   

}

