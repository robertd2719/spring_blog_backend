package io.robb.spring.spring_h2_backend.repositories;

import io.robb.spring.spring_h2_backend.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
}
