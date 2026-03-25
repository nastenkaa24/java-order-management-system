package Data_Access;

import Graphical_User_Interface.Model;

import java.io.*;

public class SerializationOperations {

    public static void saveModel(Model model) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Dara_Loga_save.ser"));
            out.writeObject(model);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Model loadModel() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Dara_Loga_save.ser"));
            Model model = (Model) in.readObject();
            in.close();
            return model;
        } catch (Exception e) {
            return new Model();
        }
    }
}