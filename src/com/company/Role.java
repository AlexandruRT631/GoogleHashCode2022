package com.company;

public class Role extends Skill{
    private Boolean occupied = false;

    public Role(String name, int level) {
        super(name, level);
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }
}
