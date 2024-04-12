package projects.service;

import java.util.List;
import java.util.Optional;

import projects.dao.ProjectDao;
import projects.entity.Project;

public class ProjectService {
	private ProjectDao projectDao = new ProjectDao();
	

	public Project addProject(Project project) {
		return projectDao.insertProject(project);
	}

	//Method calls the project DAO to get all project rows without the details
	public List<Project> fetchAllProjects() {
		return projectDao.fetchAllProjects();
	}

	public Project fetchProjectById(Integer projectId) {	
		//temp assign variable type 
				//Optional<Project> op = projectDao.fetchProjectById(projectId);
				//may have to delete the top one
		return projectDao.fetchProjectById(projectId).orElseThrow(() -> new NoSuchElementException("Project with project ID=" + projectId + " does not exist"));
	}
}


