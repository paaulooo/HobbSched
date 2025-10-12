package com.paledev.hobbsched.repositories;

import com.paledev.hobbsched.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceRepository extends JpaRepository<Service,Long > {

}
