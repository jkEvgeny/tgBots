package mapper;

import dto.AnswerDto;
import dto.QuestionDto;
import lombok.NoArgsConstructor;
import model.Answer;
import model.Question;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class QuestionsMapper {

    public QuestionDto mapToDto(Question model){
        if(model == null) return null;
        List<AnswerDto> answerDtos = model.getAnswers().stream()
                .map(AnswersMapper::mapToDto)
                .collect(Collectors.toList());
        return QuestionDto.builder()
                .textQuestion(model.getTextQuestion())
                .answers(answerDtos)
                .build();
    }

    public Question mapToModel(QuestionDto dto) {
        if (dto == null) return null;
        List<Answer> answers = dto.getAnswers().stream()
                .map(AnswersMapper::mapToModel)
                .collect(Collectors.toList());
        return Question.builder()
                .id(dto.getId())
                .textQuestion(dto.getTextQuestion())
                .answers(answers)
                .build();
    }
}
