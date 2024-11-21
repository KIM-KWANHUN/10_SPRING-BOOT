package com.ohgiraffers.crud.model.dao;

import com.ohgiraffers.crud.model.dto.CategoryDTO;
import com.ohgiraffers.crud.model.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/* comment.
*   Mybatis 의 전용 어노테이션으로 Repository 의
*   더 구체적인 기능을 가진 어노테이션이다.
*   Repository 와 기능은 동일하다. Repository 는 데이터베이스와 연결이고 Mapper 는 Mybatis 와 연결 */
@Mapper
public interface MenuMapper {
    // 아래 있는 메소드는 커리문을 매핑하는 아이디!!
    List<MenuDTO> findAllMenus();

    List<CategoryDTO> findAllCategory();

}
