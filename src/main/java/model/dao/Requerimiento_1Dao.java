package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.Requerimiento1;

public class Requerimiento_1Dao {
    // Obtener los lideres con salario menor a 500000
    public ArrayList<Requerimiento1> requerimiento1() throws SQLException {
        ArrayList<Requerimiento1> respuesta = new ArrayList<Requerimiento1>();
        Connection conexion = JDBCUtilities.getConnection();
        try{
            String consulta = "SELECT Id_Lider, Nombre, Primer_Apellido, salario "+
                              "FROM Lider "+
                              "WHERE salario <= 500000 "+
                              "ORDER BY salario";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();
            
            //Recorrer los registros en los VO especificos
            while(resultSet.next()){
                Requerimiento1 requerimiento_1 = new Requerimiento1();
                requerimiento_1.setNombre(resultSet.getString("Nombre"));
                requerimiento_1.setPrimerApellido(resultSet.getString("Primer_Apellido"));
                requerimiento_1.setIdLider(resultSet.getInt("Id_Lider"));
                requerimiento_1.setSalario(resultSet.getInt("Salario"));
                respuesta.add(requerimiento_1);
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            System.err.println("Error consultando los lideres por salario "+e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }
        //Retornar la coleccion de vo's
        return respuesta;
    }
    
}
