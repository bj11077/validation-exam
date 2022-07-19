package nn.jung.valid.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequestDto {

    @Schema(description = "등록자명", example = "홍길동")
    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;
//    @Pattern(regexp = "^[a-zA-Z0-9 ㄱ-ㅎㅏ-ㅣ가-힣]", message = "특수문자는 포함할 수 없습니다.")

    @Schema(description = "댓글", example = "댓글1")
    @NotBlank(message = "댓글은 필수 입력 값입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ\\s]*$", message = "특수문자는 포함할 수 없습니다.")
    private String comment;
}
