package com.jpastreamer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpastreamer.entity.Employee;
@Repository
public interface RepostroyJpa extends JpaRepository<Employee, Integer> {

}
