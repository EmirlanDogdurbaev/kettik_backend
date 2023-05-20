package space.best.kettik.servises;

import org.springframework.stereotype.Service;
import space.best.kettik.models.CommentModels;
import space.best.kettik.repos.CommentRepo;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepo commentRepo;

    public CommentService(CommentRepo yourEntityRepository) {
        this.commentRepo = yourEntityRepository;
    }

    public CommentModels addComment(CommentModels comment) {
        return commentRepo.save(comment);
    }

    public List<CommentModels> getAllComments() {
        return commentRepo.findAll();
    }

    public CommentModels getCommentById(Long id) {
        return commentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Комментарий с указанным идентификатором не найден"));
    }
}
