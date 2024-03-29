package co.yedam.jdbc05;

import java.util.Date;

import lombok.Data;

//Lombok 라이브러리 활용


//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor

@Data
public class EmpVO {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private int salary;
	private Date hireDate;
	private String jobId;
}
