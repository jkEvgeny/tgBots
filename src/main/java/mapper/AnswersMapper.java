package mapper;

import dto.AnswerDto;
import model.Answer;
import org.springframework.stereotype.Component;

@Component
public class AnswersMapper {

    public static AnswerDto mapToDto(Answer model){
        if(model == null) return null;
        return AnswerDto.builder()
                .id(model.getId())
                .answer(model.getAnswer())
                .isCorrect(model.getIsCorrect())
                .build();
    }

    public static Answer mapToModel(AnswerDto dto) {
        if (dto == null) return null;
        return Answer.builder()
                .id(dto.getId())
                .answer(dto.getAnswer())
                .isCorrect(dto.getIsCorrect())
                .build();
    }
}
