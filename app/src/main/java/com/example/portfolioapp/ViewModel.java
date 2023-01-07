package com.example.portfolioapp;

public class ViewModel {
    String projectName;
    String projectDescription;
    int projectPic;

    String projectGitLink;
    String projectDate;
    String projectStack;
    String projectActivities;

    int projectPreview;


    public ViewModel(String projectName, String projectDescription, int projectPic,
                     String projectGitLink, String projectDate, String projectStack,
                     String projectActivities, int projectPreview) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectPic = projectPic;

        this.projectGitLink = projectGitLink;
        this.projectDate = projectDate;
        this.projectStack = projectStack;
        this.projectActivities = projectActivities;

        this.projectPreview = projectPreview;
    }

    public String getProjectName() {
        return projectName;
    }
    public String getProjectDescription() {
        return projectDescription;
    }
    public int getProjectPic() {
        return projectPic;
    }

    public String getProjectGitLink() {
        return projectGitLink;
    }
    public String getProjectDate() {
        return projectDate;
    }
    public String getProjectStack() {
        return projectStack;
    }
    public String getProjectActivities() {
        return projectActivities;
    }

    public int getProjectPreview() {
        return projectPreview;
    }
}
