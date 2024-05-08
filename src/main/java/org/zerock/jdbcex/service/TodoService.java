package org.zerock.jdbcex.service;

import org.modelmapper.ModelMapper;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

public enum TodoService{
    instance;
    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService(){
        dao = new TodoDAO();
        modelMapper = MapperUtil.MYINSTANCE.getModelMapper();
    }
    public void register(TodoDTO todoDTO) throws Exception{
        TodoVO vo=modelMapper.map(todoDTO, TodoVO.class);//매핑
        dao.setData(vo);
    }
    public List<TodoDTO> listAll() throws Exception{
        List<TodoVO> todovo=dao.selectAll();
        List<TodoDTO> todoDTO=todovo.stream()
                .map(v->modelMapper.map(v,TodoDTO.class))
                .collect(Collectors.toList());
        return todoDTO;
    }
    public TodoDTO get(Long id) throws Exception{
        return dao.selectData(id);
    }
    public boolean update(TodoDTO todoDTO) throws Exception{
        TodoVO vo=modelMapper.map(todoDTO, TodoVO.class);
        dao.updateData(vo);
        return true;
    }
    public boolean delete(Long id) throws Exception{
        dao.deleteData(id);
        return true;
    }
}
