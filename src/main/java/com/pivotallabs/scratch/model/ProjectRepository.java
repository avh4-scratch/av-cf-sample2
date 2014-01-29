package com.pivotallabs.scratch.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, String> {

  List<Project> findByName(String name);
}
