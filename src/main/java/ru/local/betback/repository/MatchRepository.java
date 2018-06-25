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
            "where exists(select *\n" +
            "             from appbet.team t\n" +
            "               inner join appbet.group_teams gt on t.id = gt.teams_id\n" +
            "             where gt.group_id = :groupId and (m.team1_id = t.id or m.team2_id = t.id))",
            nativeQuery = true)
    List<Match> getMatchesByGroupId(@Param("groupId") int id);
}
