package books.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class BookDto {
	private int bno;
	private String bname;
	private String bwriter;
	private String bpublisher;
	private String bdate;
	private String bupdate;
}
