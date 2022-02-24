package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private int line;
    private List<String> lines;
    private int nrOfProjects;

    public List<Contributor> readContributors(String filename) throws IOException {
        Path levelFile = Path.of(filename);
        lines = Files.readAllLines(levelFile);
        List<Contributor> contributors = new ArrayList<>();

        int nrOfContributors = Integer.parseInt(lines.get(0).split(" ")[0]);
        nrOfProjects = Integer.parseInt(lines.get(0).split(" ")[1]);
        line = 0;
        while (nrOfContributors != 0) {
            line++;
            String name = lines.get(line).split(" ")[0];
            int nrOfSkills = Integer.parseInt(lines.get(line).split(" ")[1]);
            Contributor contributor = new Contributor(name);

            while (nrOfSkills != 0) {
                line++;
                String skill = lines.get(line).split(" ")[0];
                int level = Integer.parseInt(lines.get(line).split(" ")[1]);
                contributor.addSkill(skill, level);
                nrOfSkills--;
            }

            contributors.add(contributor);
            nrOfContributors--;
        }
        return contributors;
    }

    public List<Project> readProjects() throws IOException {
        List<Project> projects = new ArrayList<>();

        while (nrOfProjects != 0) {
            line++;
            String name = lines.get(line).split(" ")[0];
            int days = Integer.parseInt(lines.get(line).split(" ")[1]);
            int score = Integer.parseInt(lines.get(line).split(" ")[2]);
            int bestBefore = Integer.parseInt(lines.get(line).split(" ")[3]);
            int nrOfRoles = Integer.parseInt(lines.get(line).split(" ")[4]);
            Project project = new Project(name, days, score, bestBefore);

            while (nrOfRoles != 0) {
                line++;
                String role = lines.get(line).split(" ")[0];
                int level = Integer.parseInt(lines.get(line).split(" ")[1]);
                project.addRole(role, level);
                nrOfRoles--;
            }

            projects.add(project);
            nrOfProjects--;
        }
        return projects;
    }
}
