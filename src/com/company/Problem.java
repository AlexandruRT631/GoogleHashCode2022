package com.company;

import java.io.IOException;
import java.util.List;

public class Problem {
    public void solve(String input) throws IOException {
        Reader reader = new Reader();
        Writer writer = new Writer();
        String output = input.replaceAll("in", "out").replaceAll("input", "output");
        List<Contributor> contributors = reader.readContributors(input);
        List<Project> projects = reader.readProjects();
        int remainingProjects = projects.size();

        boolean ok = true;
        while (remainingProjects != 0 && ok) {
            ok = false;
            for (int i = 0; i < projects.size() && remainingProjects != 0; i++) {
                if (!projects.get(i).isFinished()) {
                    Project project = projects.get(i);
                    contributors = project.tryProject(contributors);
                    if (project.isFinished()) {
                        ok = true;
                        projects.set(i, project);
                        remainingProjects--;
                    }
                }
            }
        }
        writer.writeProjects(output, projects, projects.size() - remainingProjects);
    }
}
