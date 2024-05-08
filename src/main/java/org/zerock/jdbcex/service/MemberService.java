package org.zerock.jdbcex.service;

import org.modelmapper.ModelMapper;
import org.zerock.jdbcex.dao.MemberDAO;
import org.zerock.jdbcex.domain.MemberVO;
import org.zerock.jdbcex.dto.MemberDTO;
import org.zerock.util.MapperUtil;

public enum MemberService {
    instance;//1나의 객체만 여러게는 , 사용
    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService() {
        dao = new MemberDAO();
        modelMapper= MapperUtil.MYINSTANCE.getModelMapper();
    }
    public MemberDTO Login(String mid,String mpw){
        MemberVO vo = dao.getWithPassword(mid, mpw);
        //DAO를 사용하여 sql 처리
        MemberDTO dto = modelMapper.map(vo, MemberDTO.class);
        //vo를 DTO로 변경(매핑)
        return dto;
    }
}
