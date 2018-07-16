package Controllers;

import Models.Crime;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class jsonParser  {
    private String inputFileName;

    public jsonParser(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public List<Crime> getJson() {

//this part takes the .json file and converts it into a one long string.
        String dataFile = "/Users/computer/IdeaProjects/testbed2/src/main/resources/json/input/"+ inputFileName +".json";

        Path filePath = Paths.get(dataFile);
        List<String> list = null;

        {
            try {
                list = Files.readAllLines(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            StringBuilder crimeString = new StringBuilder();
            for (int i = 0; i < Objects.requireNonNull(list).size(); i++) {

                crimeString.append(list.get(i));
            }

//this section takes the newly created json crimeString and turns it into a list of crime objects
//crime objects are basically the key value pairs from the .json

//a quick note, if its throwing java.lang.IllegalStateException: Expected BEGIN_ARRAY but was BEGIN_OBJECT errors it's because the .json MUST start with
//array brackets.
            Type foundListType = new TypeToken<ArrayList<Crime>>() {
            }.getType();

             List<Crime> crimes = new Gson().fromJson(crimeString.toString(), foundListType);

             return crimes;
        }
    }
}


