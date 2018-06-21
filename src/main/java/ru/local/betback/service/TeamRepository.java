package ru.local.betback.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.local.betback.domain.Team;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findAllByOrderByIdAsc();

    @Query(value = "select * from appbet.team t where t.id not in (select ts.teams_id  from appbet.group_teams ts)",
            nativeQuery = true)
    List<Team> getTeamFreeGroup();
}
