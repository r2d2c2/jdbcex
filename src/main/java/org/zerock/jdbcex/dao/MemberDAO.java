package org.zerock.jdbcex.dao;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.zerock.jdbcex.domain.MemberVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    @SneakyThrows
    public MemberVO getWithPassword(String mid, String mpw) {
        String sql = "select * from tbl_member where mid=? and mpw=?";
        MemberVO vo = null;
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setString(1, mid);
        preparedStatement.setString(2, mpw);
        @Cleanup ResultSet resultSet=preparedStatement.executeQuery();
        if(resultSet.next()) {
            vo=MemberVO.builder()
                    .mid(resultSet.getString(1))//혹은 "mid" 으로 찾기
                    .mname(resultSet.getString(2))
                    .mpw(resultSet.getString(3))
                    .build();
        }
        return vo;
    }

}
