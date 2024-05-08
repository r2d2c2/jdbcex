package org.zerock.jdbcex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@AllArgsConstructor//빌더사용시 2개 필수
@NoArgsConstructor
public class MemberDTO {
    private String  mid;
    private String  mpw;
    private String  mname;
}
