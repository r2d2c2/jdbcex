package org.zerock.jdbcex.dao;


import lombok.Cleanup;
import org.zerock.jdbcex.domain.TodoVO;
import org.zerock.jdbcex.dto.TodoDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {//데이터 어섹스 오브젝트
    public String getTime(){
        String now = null;
        try(
                Connection conn=ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement pstmt= conn.prepareStatement("select now()");
                ResultSet rs=pstmt.executeQuery();
        ) //()안에 있으면 pstmt.close(); 생략된다
        {
            rs.next();
            now=rs.getString(1);//now() 가지고 오기
        }catch(SQLException e){
            e.printStackTrace();
        }
        return now;
    }
    public String getTime2() throws Exception{
        String now = null;
        //@Cleaup으로 .close()
        @Cleanup Connection conn=ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt= conn.prepareStatement("select now()");
        @Cleanup ResultSet rs=pstmt.executeQuery();

        rs.next();
        now=rs.getString(1);//now() 가지고 오기
        return now;
    }
    public void setData(TodoVO todoVO){
        try{
                Connection conn=ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement pstmt= conn.prepareStatement("insert into tbl_todo(title,dueDate,finished) values(?,?,?)");
                pstmt.setString(1,todoVO.getTitle());
                pstmt.setDate(2, Date.valueOf(todoVO.getDueDate()));
                pstmt.setBoolean(3, todoVO.isFinished());
                pstmt.executeUpdate();
                pstmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public TodoDTO selectData(Long id) throws Exception{

       @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
       @Cleanup PreparedStatement pstmt = connection.prepareStatement("select * from tbl_todo where tno=?");
        pstmt.setLong(1, id);
        ResultSet rs = pstmt.executeQuery();
        TodoDTO dto =null;
        if(rs.next()){
            dto=TodoDTO.builder()
                    .tno(rs.getLong("tno"))
                    .title(rs.getString("title"))
                    .dueDate(rs.getDate("dueDate").toLocalDate())
                    .finished(rs.getBoolean("finished"))
                    .build();

        }
        return dto;
    }


    public List<TodoVO> selectAll()throws Exception{
        String sql="select * from tbl_todo";
        @Cleanup Connection conn=ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt=conn.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        List<TodoVO> mylist=new ArrayList<>();
        while(rs.next()){
            TodoVO todoVO=TodoVO.builder()
                    .tno(rs.getLong("tno"))
                    .title(rs.getString("title"))
                    .dueDate(rs.getDate("dueDate").toLocalDate())
                    .finished(rs.getBoolean("finished"))
                    .build();
            mylist.add(todoVO);
        }
        return mylist;
    }
    public void updateData(TodoVO todoVO) throws Exception{
        String sql = "update tbl_todo set title=?,dueDate=?,finished=? where tno=?";
        @Cleanup Connection conn=ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,todoVO.getTitle());
        pstmt.setDate(2, Date.valueOf(todoVO.getDueDate()));
        pstmt.setBoolean(3, todoVO.isFinished());
        pstmt.setLong(4, todoVO.getTno());
        pstmt.executeUpdate();
    }
    public void deleteData(Long id) throws Exception{
        String sql = "delete from tbl_todo where tno=?";
        @Cleanup Connection conn=ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt=conn.prepareStatement(sql);
        pstmt.setLong(1, id);
        pstmt.executeUpdate();
    }
}
