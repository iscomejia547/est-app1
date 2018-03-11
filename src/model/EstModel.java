package model;

import beans.Student;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EstModel {
    private File file;//file de acceso
    private RandomAccessFile raf;//random access file
    private String PATH;
    private final int STREAM_SIZE=191;//el peso combinado en bytes de el registro de un objeto estudiante

    public EstModel() {
        PATH=null;
    }

    public String getPATH() {
        return PATH;
    }

    public void setPATH(String PATH) {
    }
    
    

    public void open() throws IOException{
        PATH="students.dat";
        file=new File(PATH);
        if(!file.exists()){//si el archivo no existe
            file.createNewFile();
            raf=new RandomAccessFile(file, "rw");
            raf.seek(0);
            raf.writeInt(0);//se establecen los indices n
            raf.writeInt(0);//y k
        }else{
            raf=new RandomAccessFile(file, "rw");
        }
    }
    public void close() throws IOException {
        if(raf!=null){
            raf.close();
        }
    }

    //ayuda para busqueda binaria recursiva
    private int runBinarySearchRecursively(int key, int low, int high) throws IOException {
        int middle = (low + high) / 2;

        if (high < low) {
            return -1;
        }
        long pos = 8 + STREAM_SIZE * middle;
        raf.seek(pos);
        int id = raf.readInt();
        if (key == id) {
            return middle;
        } else if (key < id) {
            return runBinarySearchRecursively(
                    key, low, middle - 1);
        } else {
            return runBinarySearchRecursively(
                    key, middle + 1, high);
        }
    }

    //ayuda para limitar string a un determinado numero de caracteres (as SQL NVARCHAR)
    private String toNVARCHAR(String text, int capacidad) {
            StringBuilder builder;
            if (text == null) {
                builder = new StringBuilder(capacidad);
            } else {
                builder = new StringBuilder(text);
                builder.setLength(capacidad);
            }
            return builder.toString();
    }

    public boolean add(Student t) throws IOException {
        open();
        if(t==null){
            return false;
        }
        raf.seek(0);
        int n=raf.readInt();//numero de registros disponibles, si el .dat fue recien creado, sera 0 por defecto
        int k=raf.readInt();//control de numeros de ID asignados;
        long pos=8+STREAM_SIZE*n;//apuntar a un espacio nuevo;

        //escritura del registro
        raf.seek(pos);
        raf.writeInt(++k);
        raf.writeUTF(toNVARCHAR(t.getName(), 25));//limitar el nombre a 15, si es mas largo, se cortara, si es mas corto, se rellenara
        raf.writeUTF(toNVARCHAR(t.getLastname(), 25));
        raf.writeUTF(toNVARCHAR(t.getCarnet(), 10));
        raf.writeUTF(toNVARCHAR(t.getCarreer(), 15));
        raf.writeUTF(toNVARCHAR(t.getCiudad(), 15));
        raf.writeInt(t.getAge());

        //actualizando datos
        raf.seek(0);
        raf.writeInt(++n);
        raf.writeInt(k);
        return true;
    }

    public List<Student> getAll() throws IOException {
        List<Student> students=new ArrayList<>();//el arraylist es mas accesible para las operaciones que usaremos(busquedas)
        open();
        raf.seek(0);
        int n=raf.readInt();//cantidad de registros
        for (int i=0;i<n;i++){
            long pos=8+STREAM_SIZE*i;
            raf.seek(pos);
            Student e=new Student();
            e.setId(raf.readInt());
            e.setName(raf.readUTF().replace('\0', ' ').trim());
            e.setLastname(raf.readUTF().replace('\0', ' ').trim());
            e.setCarnet(raf.readUTF());
            e.setCarreer(raf.readUTF().replace('\0', ' ' ).trim());
            e.setCiudad(raf.readUTF().replace('\0', ' ').trim());
            e.setAge(raf.readInt());
            students.add(e);
        }
        //Collections.sort(students, (Student e1, Student e2)->e1.getName().compareToIgnoreCase(e2.getName()));
        return students;
    }
    
    public boolean update() throws IOException{
        return false;
    }
    
    public boolean delete() throws IOException{
        return false;
    }
    public Student byId(int id) throws IOException{
        open();
        raf.seek(0);
        int n=raf.readInt();
        if(n==0){
            return null;
        }
        int index=runBinarySearchRecursively(id, 0, n-1);
        if(index<=-1){
            return null;
        }
        Student x=new Student();
        long pos=8+index*STREAM_SIZE;
        return null;
    }
}
