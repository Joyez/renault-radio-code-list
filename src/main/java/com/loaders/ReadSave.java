package com.loaders;

import com.models.codes.Code;
import com.models.codes.FirstCode;
import com.models.codes.SecondCode;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class ReadSave  {

    private static final String pathConfig = "config.bin";

    private static void saveCodes(Map<Code,Code> map)
    {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathConfig)))
        {
            objectOutputStream.writeObject(map);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map readCodes()
    {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathConfig))) {
            Map <Code,Code> mapCode;
            mapCode = (Map<Code, Code>) objectInputStream.readObject();
            return mapCode;

        } catch (FileNotFoundException e) {
            saveCodes(readCodesTxt());
            readCodes();
        } catch (ClassNotFoundException|IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Map readCodesTxt()
    {

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("temp.txt"))) {
            String text = bufferedReader.readLine();
            Map<Code,Code> mapCode = new TreeMap<>();
            while(text !=null){
                mapCode.put(new FirstCode(text.substring(2,6)),new SecondCode(text.substring(9,13)));
                text = bufferedReader.readLine();
            }
            return mapCode;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
