package repository;

import model.UserQuizStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQuizStatisticRepository extends JpaRepository<UserQuizStatistic, Integer> {

    @Query("SELECT s FROM user_quiz_statistic s WHERE s.user_id=?1")
    UserQuizStatistic findByUserId (Integer userId);
}
