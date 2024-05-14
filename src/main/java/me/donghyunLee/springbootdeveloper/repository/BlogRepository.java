package me.donghyunLee.springbootdeveloper.repository;

import me.donghyunLee.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
