package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Project {
    private String name;
    private int days;
    private int score;
    private int bestBefore;
    private List<Role> roles = new ArrayList<>();
    private Boolean finished = false;
    private List<String> persons = new ArrayList<>();
    private HashMap<String, Integer> bonusSkills = new HashMap<>();

    public Project(String name, int days, int score, int bestBefore) {
        this.name = name;
        this.days = days;
        this.score = score;
        this.bestBefore = bestBefore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(int bestBefore) {
        this.bestBefore = bestBefore;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> skills) {
        this.roles = skills;
    }

    public Boolean isFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public List<String> getPersons() {
        return persons;
    }

    public void setPersons(List<String> persons) {
        this.persons = persons;
    }

    public void addRole(String name, int level) {
        Role newRole = new Role(name, level);
        roles.add(newRole);
    }

    public List<Contributor> tryProject(List<Contributor> contributors) {
        List<Contributor> newContributors = contributors;
        for (Role role : roles) {
            boolean ok = false;
            for (int i = 0; i < newContributors.size() && !ok; i++) {
                for (int j = 0; j < newContributors.get(i).getSkills().size() && !ok; j++) {
                    if (role.getName().equals(newContributors.get(i).getSkills().get(j).getName())) {
                        if ((role.getLevel() <= newContributors.get(i).getSkills().get(j).getLevel())
                        || (role.getLevel() - 1 == newContributors.get(i).getSkills().get(j).getLevel() && bonusSkills.containsKey(role.getName()) && bonusSkills.get(role.getName()) >= role.getLevel())) {
                            if (!persons.contains(newContributors.get(i).getName())) {
                                ok = true;
                                persons.add(newContributors.get(i).getName());
                                List<Skill> skills = newContributors.get(i).getSkills();
                                for (int k = 0; k < skills.size(); k++) {
                                    if (k != j) {
                                        if (!bonusSkills.containsKey(skills.get(k).getName()) || bonusSkills.get(skills.get(k).getName()) < skills.get(k).getLevel()) {
                                            bonusSkills.put(skills.get(k).getName(), skills.get(k).getLevel());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (!ok) {
                persons = new ArrayList<>();
                return contributors;
            }
        }
        finished = true;
        return newContributors;
    }
}
