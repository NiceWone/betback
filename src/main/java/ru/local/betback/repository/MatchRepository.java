package ru.local.betback.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.local.betback.model.Match;

import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Long> {
    List<Match> findAllByOrderByIdAsc();

    @Query(value = "select *\n" +
            "from appbet.match m\n" +
            "  inner join appbet.team t1\n" +
            "    on m.team1_id = t1.id\n" +
            "  inner join appbet.team t2\n" +
            "    on m.team2_id = t2.id\n" +
            "where t1.group_id = :groupId and t2.group_id = :groupId",
            nativeQuery = true)
    List<Match> getMatchesByGroupId(@Param("groupId") int id);
}
