package com.pivotallabs.scratch;

import com.pivotallabs.scratch.model.Project;
import com.pivotallabs.scratch.model.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class ProjectsController {
    private final ProjectRepository projectRepository;

    @Inject
    public ProjectsController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @RequestMapping(value = "/projects", method = GET)
    public Iterable<Project> index() {
        return projectRepository.findAll();
    }


    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/projects", method = POST)
    public String create(org.springframework.ui.Model model) {
        Project project = new Project(UUID.randomUUID().toString(),"notnull");

        Project save = projectRepository.saveAndFlush(project);
//        if (save.getName() == null) {throw  new RuntimeException("@@@");}

        model.addAttribute("project", project);
        return "project";
    }
}
