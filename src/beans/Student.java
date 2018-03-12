package beans;

public class Student {
    private int id;//peso 4b
    private String name;//nvarchar(25)+BOM 3bytes
    private String lastname;//nvarchar(25)
    private String carnet;//formato '20xx-xxxxc' donde x:numero y c:letra; nvarchar(10)
    private String carreer;//nvarchar(15)
    private String dept;//nvarchar(15)
    private String ciudad;//nvarchar(15)
    private int age;//peso=4b

    public Student(int id, String name, String lastname, String carnet, String carreer, String ciudad, int age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.carnet = carnet;
        this.carreer = carreer;
        this.age = age;
        this.ciudad=ciudad;
    }

    public Student() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getCarreer() {
        return carreer;
    }

    public void setCarreer(String carreer) {
        this.carreer = carreer;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
    
    

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", carnet='" + carnet + '\'' +
                ", carreer='" + carreer + '\'' +
                ", age=" + age +
                '}';
    }
    
    public Object[] toArray(){
        Object[] fields=new Object[8];
        fields[0]=this.getId();
        fields[1]=this.getName();
        fields[2]=this.getLastname();
        fields[3]=this.getAge();
        fields[4]=this.getCarnet();
        fields[5]=this.getCarreer();
        fields[6]=this.getDept();
        fields[7]=this.getCiudad();
        return fields;
    }
}
