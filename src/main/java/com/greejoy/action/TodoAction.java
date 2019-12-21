package com.greejoy.action;

import com.greejoy.model.Resp;
import com.greejoy.model.Todo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// 测试用例
@Path("/todo")
public class TodoAction {
    
    /**
     * 根据id查询任务信息.
     *
     * @param id 任务id
     * @return 任务信息
     */
    @Path("/getTaskInfo/{id}") // 大括号里的是参数名，在函数位置使用@PathParam注解映射
    @GET // 声明这个接口必须GET访问
    @Produces(MediaType.APPLICATION_JSON) // 声明这个接口将以json格式返回
    public Resp getTaskInfo(@PathParam("id") int id) {
        Todo todo = new Todo();
        todo.setId(id);
        todo.setAppId("test");

        return new Resp(0, "success", todo);
    }
}