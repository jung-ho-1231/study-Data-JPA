package com.example.jpadata.repository;

public interface NestedClosedProjections {
    String getUsername();

    TeamInfo getTeam();

    interface TeamInfo {
        String getName();
    }
}
