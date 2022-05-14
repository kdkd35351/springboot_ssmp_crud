package xyz.oooohao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.oooohao.domain.Book;

@Repository
@Mapper
public interface BookDao extends BaseMapper<Book> {

}
