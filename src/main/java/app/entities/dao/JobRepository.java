package app.entities.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.Job;

public interface JobRepository extends JpaRepository<Job, Long>{

}
