package com.company;

import java.util.ArrayList;
import java.util.List;

public class Contributor {
    private String name;
    private List<Skill> skills = new ArrayList<>();

    public Contributor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public void addSkill(String skill, Integer level) {
        Skill newSkill = new Skill(skill, level);
        skills.add(newSkill);
    }
}
