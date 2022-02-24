package com.company;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solve("input/a_an_example.in.txt");
        problem.solve("input/b_better_start_small.in.txt");
        problem.solve("input/c_collaboration.in.txt");
        problem.solve("input/d_dense_schedule.in.txt");
        problem.solve("input/e_exceptional_skills.in.txt");
        problem.solve("input/f_find_great_mentors.in.txt");
    }
}
