package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class PageDto {
	private int totalCount;
	private int page;
	private int totalpage;
	private int startbtn;
	private int endbtn;
	// Object 타입으로 사용한 이유
    // - Object 타입은 자바의 최상위 클래스 이므로 모든 타입들의 자료들을 저장 할 수 없다.
    // - data 에는 List<boardDto> , List<replyDto> 등등 여러 타입들을 하나의 타입에서 저장한다
	private Object data; // 페이징된 자료
}
