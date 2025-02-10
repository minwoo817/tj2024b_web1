package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor // 롬복 이용한 기본생성자 and 전체매개변수 생성자 자동 생성
@Getter @Setter @ToString // 롬복 이용한 getter and setter , ToString 자동 생성
public class BoardDto {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bdate;
	private int bview;
	private int cno;
	private int mno;
	// + HTML에 출력할때 작성자의 회원번호가 아닌 작성자 ID 출력
	private String mid;
	private String cname;
}
