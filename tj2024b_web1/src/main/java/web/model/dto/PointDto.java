package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class PointDto {
	private int pono;
	private int pocount;
	private String pocomment;
	private String podate;
	private int mno;
}
