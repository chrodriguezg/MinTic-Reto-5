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
import model.vo.Requerimiento2;

public class Requerimiento_2Dao {
   
    // Obtener los proyectos por estrato ubicados en Cartagena y ordenarlos de manera ascendente
    public ArrayList<Requerimiento2> requerimiento2() throws SQLException {
        ArrayList<Requerimiento2> respuesta = new ArrayList<Requerimiento2>();
        Connection conexion = JDBCUtilities.getConnection();
        try{
            String consulta = "SELECT ID_Proyecto, Constructora, Ciudad, Estrato "+
                              "FROM Proyecto p "+
                              "JOIN Tipo t "+
                              "USING (ID_Tipo) "+
                              "WHERE p.Ciudad = 'Cartagena' "+
                              "ORDER BY t.Estrato";
                              
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();
            
            //Recorrer los registros en los VO especificos
            while(resultSet.next()){
                Requerimiento2 requerimiento_2 = new Requerimiento2();
                requerimiento_2.setIdProyecto(resultSet.getInt("Id_Proyecto"));
                requerimiento_2.setConstructora(resultSet.getString("Constructora"));
                requerimiento_2.setCiudad(resultSet.getString("Ciudad"));
                requerimiento_2.setEstrato(resultSet.getInt("Estrato"));
                respuesta.add(requerimiento_2);
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            System.err.println("Error consultando los proyectos por estrato "+e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }
        //Retornar la coleccion de vo's
        return respuesta;
    }
        
}
