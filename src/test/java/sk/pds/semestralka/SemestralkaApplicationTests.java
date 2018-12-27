package sk.pds.semestralka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sk.pds.semestralka.mapper.CarMapper;
import sk.pds.semestralka.model.Car;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SemestralkaApplicationTests {

	@Autowired
	private CarMapper studentMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testHello1() {
		List<Car> students = studentMapper.findAll();
		assertTrue(students!=null&&students.size()>0);
	}
}

