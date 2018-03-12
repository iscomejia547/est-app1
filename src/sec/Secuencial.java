/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Docente
 */
public class Secuencial {
    private FileOutputStream fos;
    private FileInputStream fis;
    private File file;
    private String filename;

    public Secuencial(String filename) throws FileNotFoundException {
        this.filename = filename;
        load();
    }

    public Secuencial(File file) throws FileNotFoundException {
        this.file = file;
        load();
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public void load() throws FileNotFoundException{
        if(filename != null){
            file = new File(filename);
        }        
        if(file == null){
            throw new NullPointerException("El objeto file o"
                    + " el objeto filename son NULL");            
        }        
        fos = new FileOutputStream(file,true);
        fis = new FileInputStream(file);
    }
    
    public void close() throws IOException{
        if(fos != null){
            fos.close();
        }
        
        if(fis != null){
            fis.close();
        }
    }
    
    public void writeText(String text) throws IOException{
        fos.write(text.getBytes());
    }
    
    public String readText() throws IOException{
        String text = "";
        int n;
        while((n = fis.read()) != -1){
            text += (char) n;
        }
        return text;
    }
    
    
    
            
}
