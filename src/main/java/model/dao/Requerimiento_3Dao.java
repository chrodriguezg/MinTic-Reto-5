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
import model.vo.Requerimiento3;

public class Requerimiento_3Dao {
   
    // Obtener los proyectos por estrato ubicados en Cartagena y ordenarlos de manera ascendente
    public ArrayList<Requerimiento3> requerimiento3() throws SQLException {
        ArrayList<Requerimiento3> respuesta = new ArrayList<Requerimiento3>();
        Connection conexion = JDBCUtilities.getConnection();
        try{
            String consulta = "SELECT ID_Lider, Nombre, Primer_Apellido "+
                              "FROM Lider l "+
                              "WHERE l.Primer_Apellido like '%z' "+
                              "ORDER BY l.Nombre";
                              
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();
            
            //Recorrer los registros en los VO especificos
            while(resultSet.next()){
                Requerimiento3 requerimiento_3 = new Requerimiento3();
                requerimiento_3.setIdLider(resultSet.getInt("Id_Lider"));
                requerimiento_3.setNombre(resultSet.getString("Nombre"));
                requerimiento_3.setPrimerApellido(resultSet.getString("Primer_Apellido"));
                respuesta.add(requerimiento_3);
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            System.err.println("Error consultando los lideres por nombre "+e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }
        //Retornar la coleccion de vo's
        return respuesta;
    }
        
}
