package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserQuizStatisticDto {

    private Integer id;

    private Integer userId;

    private Integer correctAnswers;

    private Integer incorrectAnswers;

    private LocalDateTime lastQuizDate;
}
