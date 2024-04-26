package org.nbu.service;

import java.io.*;

public class SerializingServiceImpl {
    public <T extends Serializable> void serialize(String filePath, T item) throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(item);
        }
    }

    public  <T extends Serializable> T deserialize(String filePath) throws IOException, ClassNotFoundException {
        try(FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (T) objectInputStream.readObject();
        }
    }
}
