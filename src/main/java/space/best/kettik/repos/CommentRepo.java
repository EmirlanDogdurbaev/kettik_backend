package space.best.kettik.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import space.best.kettik.models.CommentModels;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepo extends JpaRepository<CommentModels, Long> {
     List<CommentModels> findAll();
     Optional<CommentModels> findById(Long id);
}