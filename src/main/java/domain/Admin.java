package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin {
	
	private Integer id;
	private String loginId;
	private String loginPass;
	private String email;
	private String name;

}
