package Pojo;





public class Administrators  implements java.io.Serializable {
     private String id;
     private String name;

    public Administrators() {
    }

    public Administrators(String id, String name) {
       this.id = id;
       this.name = name;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}


