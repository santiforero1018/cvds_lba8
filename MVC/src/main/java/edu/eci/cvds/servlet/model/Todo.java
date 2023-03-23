package edu.eci.cvds.servlet.model;

public class Todo {
    private int userId;
    private String Title;
    private int id;
    private String Completed;

    public Todo(){

    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    
    public void setId(int id){
        this.id = id;
    }

    
    public void setTitle(String Title){
        this.Title = Title;
    }

    
    public void setCompleted(String completed){
        this.Completed = completed;
    }

    public int getUserId(){
        return this.userId;
    }

    public int getId(){
        return this.id;
    }

    public String getTitle(){
        return this.Title;
    }

    public String getCompleted(){
        return this.Completed;
    }
}
