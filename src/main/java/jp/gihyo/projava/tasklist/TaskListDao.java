package jp.gihyo.projava.tasklist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@Service
public class TaskListDao {
    private final static String TABLE_NAME = "tasklist";
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    TaskListDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * レコードを追加し、追加した件数を返す
     * @param item HomeRestController.TaskItem
     * @return 追加件数
     */
    public int add(HomeController.TaskItem item){
        SqlParameterSource param = new BeanPropertySqlParameterSource(item);
        SimpleJdbcInsert insert = new SimpleJdbcInsert(this.jdbcTemplate)
                .withTableName(TABLE_NAME);
        return insert.execute(param);
    }

    public <LIst> List<HomeController.TaskItem> findAll(){
        String query = "SELECT * FROM " + TABLE_NAME;
        List<Map<String, Object>> result = this.jdbcTemplate.queryForList(query);
        List<HomeController.TaskItem> list = result.stream().map(
                (Map<String, Object> row) -> new HomeController.TaskItem(
                        row.get("id").toString(),
                        row.get("task").toString(),
                        row.get("deadline").toString(),
                        (Boolean)row.get("done")

                )).toList();
                return list;
    }

    public int delete(String id){
        int num = jdbcTemplate.update("DELETE FROM " + TABLE_NAME + " WHERE id = ?", id);
        return num;
    }

    public int update(HomeController.TaskItem taskItem){
        int number = jdbcTemplate.update("update tasklist set task=?, deadline=?, done=? where id = ?",
                taskItem.task(),
                taskItem.deadline(),
                taskItem.done(),
                taskItem.id());
        return number;
    }
}
