package mapper;

import dto.UserQuizStatisticDto;
import model.UserQuizStatistic;
import org.springframework.stereotype.Component;

@Component
public class UserQuizStatisticMapper {

    public UserQuizStatisticDto mapToDto(UserQuizStatistic model){
        if(model == null) return null;
        return UserQuizStatisticDto.builder()
                .id(model.getUserId())
                .correctAnswers(model.getCorrectAnswers())
                .incorrectAnswers(model.getIncorrectAnswers())
                .lastQuizDate(model.getLastQuizDate())
                .build();
    }

    public UserQuizStatistic mapToModel(UserQuizStatisticDto dto) {
        if (dto == null) return null;
        return UserQuizStatistic.builder()
                .id(dto.getId())
                .correctAnswers(dto.getCorrectAnswers())
                .incorrectAnswers(dto.getIncorrectAnswers())
                .lastQuizDate(dto.getLastQuizDate())
                .build();
    }
}
