package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Food {
	
	private int num;
	private int id;
	private String name;
	private String material;
	private int stapleId;

}
