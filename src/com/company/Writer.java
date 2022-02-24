package com.company;

import java.io.IOException;
import java.io.FileWriter;
import java.util.List;

public class Writer {
    public void writeProjects(String filename, List<Project> projects, int nrOfProjects) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        fileWriter.write(String.valueOf(nrOfProjects));
        fileWriter.write("\n");
        for (Project project : projects) {
            if (project.isFinished()) {
                fileWriter.write(project.getName());
                fileWriter.write("\n");
                for (String person : project.getPersons()) {
                    fileWriter.write(person + " ");
                }
                fileWriter.write("\n");
            }
        }
        fileWriter.close();
    }
}
