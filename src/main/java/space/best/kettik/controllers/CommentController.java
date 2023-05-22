package space.best.kettik.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.best.kettik.models.CommentModels;
import space.best.kettik.servises.CommentService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000/")
public class CommentController {

    private final CommentService commentService ;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public ResponseEntity<List<CommentModels>> getAllComments() {
        List<CommentModels> comments = commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }


    @PostMapping("/comments")
    public ResponseEntity<CommentModels> addComment(@RequestBody CommentModels comment) {
        CommentModels addedComment = commentService.addComment(comment);
        return ResponseEntity.ok(addedComment);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<CommentModels> getCommentById(@PathVariable Long id) {
        CommentModels comment = commentService.getCommentById(id);
        return ResponseEntity.ok(comment);
    }
}
