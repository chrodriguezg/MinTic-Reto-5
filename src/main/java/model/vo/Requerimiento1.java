package model.vo;

public class Requerimiento1 {
    private String Nombre;
    private String PrimerApellido;
    private int IdLider;
    private int Salario;
    
    public Requerimiento1(){
        Nombre = "";
        PrimerApellido = "";
        IdLider = 0;
        Salario = 0;
    } 
    
    public void setNombre(String nombre){
        Nombre = nombre;
    }
    public void setPrimerApellido(String primerApellido){
        PrimerApellido = primerApellido;
    }
    public void setIdLider(int idLider){
        IdLider = idLider;
    }
    public void setSalario(int salario){
        Salario = salario;
    }

    public String getNombre(){
        return Nombre;
    }
    public String getPrimerApellido(){
        return PrimerApellido;
    }
    public int getIdLider(){
        return IdLider;
    }
    public int getSalario(){
        return Salario;
    } 
    
    
}
