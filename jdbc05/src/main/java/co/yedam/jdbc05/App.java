package co.yedam.jdbc05;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
//        EmpVO evo = new EmpVO();
//        evo.setEmpId(100);
//        //evo.setEmpId();
    	String resource = "mybatis-config.xml";
    	InputStream inputStream = null;
    	try {
    		inputStream = Resources.getResourceAsStream(resource);
    	}catch(IOException e) {
    		e.printStackTrace();
    	}

    	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    	SqlSession session = sqlSessionFactory.openSession(true);
    	
//    	List<EmpVO> list = session.selectList("co.yedam.jdbc05.QueryMapper.selectEmp");
//    	for(EmpVO vo : list) {
//    		System.out.println(vo.toString());
//    	}
    	
    	EmpVO evo = new EmpVO();
    	evo.setEmployeeId(555);
    	evo.setEmail("555@email.com");
    	evo.setLastName("Park");
    	evo.setHireDate(new Date());
    	evo.setJobId("IT_PROG");
    	
    	int r = session.insert("co.yedam.jdbc05.QueryMapper.insertEmp", evo);
    	System.out.println(r + "전 입력되었습니다.");
    	
    	EmpVO evo2 = new EmpVO();
    	evo2.setEmployeeId(555);
    	evo2.setFirstName("hee");
    	evo2.setSalary(200);
    	int r2 = session.insert("co.yedam.jdbc05.QueryMapper.updateEmp", evo2);
    	System.out.println(r + "전 입력되었습니다.");
    	
    	EmpVO vo = session.selectOne("co.yedam.jdbc05.QueryMapper.getEmp", 555);
    	System.out.println(vo.toString());
    	
 
    	int r3 = session.delete("co.yedam.jdbc05.QueryMapper.deleteEmp", 555);
    	System.out.println(r3 + "이건은 삭제되었습니다.");
    	
    	
    	
    	
    	
    	
    	
    	
    }
}
