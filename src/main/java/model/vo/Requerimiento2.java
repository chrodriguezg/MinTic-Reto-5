package model.vo;

public class Requerimiento2 {
    private int IdProyecto;
    private String Constructora;
    private String Ciudad;
    private int Estrato;
    
    public Requerimiento2(){
        IdProyecto = 0;
        Constructora = "";
        Ciudad = "";
        Estrato = 0;
    } 
    
    public void setIdProyecto(int idProyecto){
        IdProyecto = idProyecto;
    }
    public void setConstructora(String constructora){
        Constructora = constructora;
    }
    public void setCiudad(String ciudad){
        Ciudad = ciudad;
    }
    public void setEstrato(int estrato){
        Estrato = estrato;
    }

    public int getIdProyecto(){
        return IdProyecto;
    }
    public String getConstructora(){
        return Constructora;
    }
    public String getCiudad(){
        return Ciudad;
    }
    public int getEstrato(){
        return Estrato;
    } 
    
    
}
