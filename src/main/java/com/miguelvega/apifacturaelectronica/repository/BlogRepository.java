package com.miguelvega.apifacturaelectronica.repository;

import com.miguelvega.apifacturaelectronica.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Long> {
}
