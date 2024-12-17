package service;

import dto.UserQuizStatisticDto;
import mapper.UserQuizStatisticMapper;
import model.UserQuizStatistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserQuizStatisticRepository;

import java.util.Optional;


@Service
public class UserQuizStatisticService {

    private final UserQuizStatisticRepository userQuizStatisticRepository;

    @Autowired
    private UserQuizStatisticMapper mapper;

    public UserQuizStatisticService(UserQuizStatisticRepository userQuizStatisticRepository) {
        this.userQuizStatisticRepository = userQuizStatisticRepository;
    }

    public UserQuizStatisticDto findByUserId(Integer userId) {
        return mapper.mapToDto(userQuizStatisticRepository.findByUserId(userId));
    }

    public void saveUserQuizStatistic(UserQuizStatisticDto userQuizStatisticDto) {
        if (userQuizStatisticDto.getUserId() == null) {
            userQuizStatisticRepository.save(mapper.mapToModel(userQuizStatisticDto));
        } else {
            Optional<UserQuizStatistic> userQuizStatistic = Optional.ofNullable(userQuizStatisticRepository.findByUserId(userQuizStatisticDto.getUserId()));
            userQuizStatistic.get().setUserId(userQuizStatisticDto.getUserId());
            userQuizStatistic.get().setCorrectAnswers(userQuizStatisticDto.getCorrectAnswers());
            userQuizStatistic.get().setIncorrectAnswers(userQuizStatisticDto.getIncorrectAnswers());
            userQuizStatistic.get().setLastQuizDate(userQuizStatisticDto.getLastQuizDate());
        }
    }
}
