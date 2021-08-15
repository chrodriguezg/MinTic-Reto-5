package model.vo;

public class Requerimiento3 {
    private int IdLider;
    private String Nombre;
    private String PrimerApellido;
    
    public Requerimiento3(){
        IdLider = 0;
        Nombre = "";
        PrimerApellido ="";
    } 
    
    public void setIdLider(int idLider){
        IdLider = idLider;
    }
    public void setNombre(String nombre){
        Nombre = nombre;
    }
    public void setPrimerApellido(String primerApellido){
        PrimerApellido = primerApellido;
    }

    public int getIdLider(){
        return IdLider;
    }
    public String getNombre(){
        return Nombre;
    }
    public String getPrimerApellido(){
        return PrimerApellido;
    }
}
