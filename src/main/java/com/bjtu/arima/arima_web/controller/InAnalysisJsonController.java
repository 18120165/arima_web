package com.bjtu.arima.arima_web.controller;

import com.bjtu.arima.arima_web.dao.InsertData;
import com.bjtu.arima.arima_web.domain.ActiveRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/postJson")
public class InAnalysisJsonController {
    @RequestMapping(value = "/active", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String,Object> getPerson(@RequestBody ActiveRequest activeRequest) throws SQLException {
        InsertData insertData = new InsertData();
        insertData.insertBatchIfo("info4Hawkes",activeRequest);
        insertData.insertBatchRet("retweetData4Hawkes",activeRequest);
        insertData.insertBatchCom("commentData4Hawkes",activeRequest);
        Map<String,Object> param = new HashMap<String, Object>();
        System.out.println(activeRequest.toString());
        param.put("myJson",activeRequest);
        return param;
    }
}
