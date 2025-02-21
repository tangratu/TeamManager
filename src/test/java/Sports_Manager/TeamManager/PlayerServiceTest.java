package Sports_Manager.TeamManager;

import Sports_Manager.TeamManager.DTOs.PlayerDTO;

import Sports_Manager.TeamManager.mappers.PlayerMapper;
import Sports_Manager.TeamManager.models.Player;
import Sports_Manager.TeamManager.models.Team;
import Sports_Manager.TeamManager.repos.PlayerRepo;
import Sports_Manager.TeamManager.repos.TeamRepo;
import Sports_Manager.TeamManager.service.PlayerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.*;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {
	@InjectMocks
	private PlayerService ps;
	@Mock
	private PlayerRepo pr;
	@Mock
	private TeamRepo tr;
	@Mock
	private PlayerMapper pmapr;
	//TODO: make a @before  for model creation



	@Test
	@DisplayName(value ="Mapper test")
	void MapperTest(){
		PlayerMapper m = Mappers.getMapper(PlayerMapper.class);
		Team t = new Team();
		t.setIdteams(1L);
		t.setTeam_name("A");
		t.setActive(true);
		t.setRanking(800);
		PlayerDTO pdto = new PlayerDTO();
		pdto.setFname("a");
		pdto.setLname("b");
		pdto.setAge(1);
		pdto.setIdplayers(1L);
		pdto.setSalary(10.10);
		pdto.setTeamName("A");
		Player ptest = m.mapDTO(pdto,t);
		assertEquals(ptest.getFname(),pdto.getFname());
		assertEquals(ptest.getLname(),pdto.getLname());
		assertEquals(ptest.getIdplayers(),pdto.getIdplayers());
		assertEquals(ptest.getAge(),pdto.getAge());
		assertEquals(ptest.getTeam().getTeam_name(),pdto.getTeamName());
		ptest.setAge(2);
		assertNotEquals(pdto.getAge(),m.map2DTO(ptest).getAge());
	}

	@Test
	@DisplayName("Service create test for teamless player")
	void serviceCreateTeamlessPlayerTesting(){ // Also covers update

		PlayerDTO pdto = new PlayerDTO();
		pdto.setFname("a");
		pdto.setLname("b");
		pdto.setAge(1);
		pdto.setIdplayers(1L);
		pdto.setSalary(10.10);
		Player p = new Player();
		p.setFname("a");
		p.setLname("b");
		p.setAge(1);
		p.setIdplayers(1L);
		p.setSalary(10.10);
		Mockito.when(pr.save(p)).thenReturn(p);
		Mockito.when(tr.getByName(null)).thenReturn(null);
        Mockito.when(pmapr.mapDTO(pdto,null)).thenReturn(p);
		Player ptest = ps.createPlayer(pdto);
		Mockito.verify(pr).save(any()); // TODO: make player matcher
		Mockito.verify(tr).getByName(ArgumentMatchers.isNull());
		Mockito.verify(pmapr).mapDTO(any(), ArgumentMatchers.isNull()); // TODO: make playerdto matcher
		assertEquals(ptest.getFname(),p.getFname());
		assertEquals(ptest.getLname(),p.getLname());
		assertEquals(ptest.getIdplayers(),p.getIdplayers());
		assertEquals(ptest.getAge(),p.getAge());

	}

	@Test
	@DisplayName(value = "Create testing for player with team")
	void serviceCreateTeamPlayerTesting(){ // Also covers update
		Team t = new Team();
		t.setIdteams(1L);
		t.setTeam_name("A");
		t.setActive(true);
		t.setRanking(800);
		PlayerDTO pdto = new PlayerDTO();
		pdto.setFname("a");
		pdto.setLname("b");
		pdto.setAge(1);
		pdto.setIdplayers(1L);
		pdto.setSalary(10.10);
		pdto.setTeamName("A");
		Player p = new Player();
		p.setFname("a");
		p.setLname("b");
		p.setAge(1);
		p.setIdplayers(1L);
		p.setSalary(10.10);
		p.setTeam(t);
		Mockito.when(pmapr.mapDTO(pdto,t)).thenReturn(p);
		Mockito.when(tr.getByName(pdto.getTeamName())).thenReturn(t);
		Mockito.when(pr.save(p)).thenReturn(p);
		Player ptest = ps.createPlayer(pdto);
		Mockito.verify(pmapr).mapDTO(any(),ArgumentMatchers.isNotNull()); // TODO: add Team matcher
		Mockito.verify(tr).getByName(anyString());
		Mockito.verify(pr).save(any());
		assertEquals(ptest.getFname(),p.getFname());
		assertEquals(ptest.getLname(),p.getLname());
		assertEquals(ptest.getIdplayers(),p.getIdplayers());
		assertEquals(ptest.getAge(),p.getAge());
		assertEquals(ptest.getTeam().getTeam_name(),p.getTeam().getTeam_name());

	}

	@Test
	@DisplayName(value = "Service getById test when no such player exists")
	void serviceGetByIdNotExists(){
		Mockito.when(pmapr.map2DTO(null)).thenReturn(null);
		Mockito.when(pr.getById(1L)).thenReturn(null);
		PlayerDTO ptest = ps.getPlayerById(1L);
		Mockito.verify(pmapr).map2DTO(ArgumentMatchers.isNull());
		Mockito.verify(pr).getById(ArgumentMatchers.anyLong());
		assertNull(ptest);
	}
	@Test
	@DisplayName(value = "Service getById test when such a player exists with no team")
	void serviceGetByIdExistsNoTeam(){
		PlayerDTO pdto = new PlayerDTO();
		pdto.setFname("a");
		pdto.setLname("b");
		pdto.setAge(1);
		pdto.setIdplayers(1L);
		pdto.setSalary(10.10);
		Player p = new Player();
		p.setFname("a");
		p.setLname("b");
		p.setAge(1);
		p.setIdplayers(1L);
		p.setSalary(10.10);
		Mockito.when(pmapr.map2DTO(p)).thenReturn(pdto);
		Mockito.when(pr.getById(1L)).thenReturn(p);
		PlayerDTO ptest = ps.getPlayerById(1L);
		Mockito.verify(pmapr).map2DTO(any());
		Mockito.verify(pr).getById(ArgumentMatchers.anyLong());
		assertNotNull(ptest);
	}
	@Test
	@DisplayName(value = "Service getById test when such a player exists with a team")
	void serviceGetByIdExistsWithTeam(){
		Team t = new Team();
		t.setIdteams(1L);
		t.setTeam_name("A");
		t.setActive(true);
		t.setRanking(800);
		PlayerDTO pdto = new PlayerDTO();
		pdto.setFname("a");
		pdto.setLname("b");
		pdto.setAge(1);
		pdto.setIdplayers(1L);
		pdto.setSalary(10.10);
		pdto.setTeamName("A");
		Player p = new Player();
		p.setFname("a");
		p.setLname("b");
		p.setAge(1);
		p.setIdplayers(1L);
		p.setSalary(10.10);
		p.setTeam(t);
		Mockito.when(pmapr.map2DTO(p)).thenReturn(pdto);
		Mockito.when(pr.getById(1L)).thenReturn(p);
		PlayerDTO ptest = ps.getPlayerById(1L);
		Mockito.verify(pmapr).map2DTO(any());
		Mockito.verify(pr).getById(ArgumentMatchers.anyLong());
		assertNotNull(ptest);
		assertEquals(p.getTeam().getTeam_name(),ptest.getTeamName());
	}

}
