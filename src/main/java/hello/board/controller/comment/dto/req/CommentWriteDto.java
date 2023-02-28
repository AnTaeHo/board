package hello.board.controller.comment.dto.req;

import lombok.*;

import javax.persistence.Lob;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentWriteDto {

    @Lob
    private String content;

}
