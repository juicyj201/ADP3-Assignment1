package za.ac.cput.Impl;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import za.ac.cput.Domain.Entity.Admin;

public interface AdminRepositoryImpl extends JpaRepositoryImplementation<Admin, String> {
}